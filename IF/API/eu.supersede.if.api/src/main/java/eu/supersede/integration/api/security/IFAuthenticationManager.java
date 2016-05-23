/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.security;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.http.RequestEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.Claim;

import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.api.security.types.Role;
import eu.supersede.integration.api.security.types.User;
import eu.supersede.integration.api.tenants.IFTenantsManager;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.properties.IntegrationProperty;

public class IFAuthenticationManager {
	private IFUserStoreManager usm = null;
//	private IFTenantsManager tm = null;
	private RestTemplate restTemplate = new RestTemplate();
	private static String TOKEN_SERVICE_ENDPOINT = IntegrationProperty.getProperty("is.server.services.token");
//	private static String AUTHORIZATION_PAIR_BASE64 = IntegrationProperty.getProperty("is.authorization.pair.base64");

	static {
		// This is use to enable the https SSL connection with IF WSO2 IS
		/*
		 * fix for Exception in thread "main"
		 * javax.net.ssl.SSLHandshakeException:
		 * sun.security.validator.ValidatorException: PKIX path building failed:
		 * sun.security.provider.certpath.SunCertPathBuilderException: unable to
		 * find valid certification path to requested target
		 */
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HostnameVerifier supersedeISValid = new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				System.out.println("Verifying hostname: " + hostname);
				String token_service_hostname = null;
				try {
					token_service_hostname = new URL(TOKEN_SERVICE_ENDPOINT).getHost();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (token_service_hostname == null) {
					return false;
				} else {
					return hostname.equals(token_service_hostname);
				}
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(supersedeISValid);

		// try {
		// HttpsURLConnection.setDefaultHostnameVerifier(supersedeISValid);
		// String token_service_hostname = new URL
		// (TOKEN_SERVICE_ENDPOINT).getHost();
		// HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) ->
		// hostname.equals(token_service_hostname));
		// HttpsURLConnection.setDefaultHostnameVerifier(
		// (hostname, session) -> {System.out.println("Verifying hostname: " +
		// hostname); return hostname.equals(token_service_hostname);});
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// }
	}
	
	public IFAuthenticationManager(String admin, String password){
		usm = new IFUserStoreManager(admin, password);
//		tm = new IFTenantsManager(admin, password);
	}

	// User Authentication
	public boolean authenticateUser(String userName, String credential) throws UserStoreException {
		return usm.authenticate(userName, credential);
	}

	// User CRUD operations

	public void addUser(User user, String credential, boolean requirePasswordChange) throws UserStoreException {
		Assert.notNull(user, "user shouldn't be null");
		Assert.notNull(user.getUserName(), "Username shouldn't be null");
		Assert.isTrue(!user.getUserName().isEmpty(), "Username shouldn't be empty");
		Assert.notNull(credential, "credential shouldn't be null");
		Assert.isTrue(!credential.isEmpty(), "credential shouldn't be empty");
		String[] profiles = usm.getAllProfileNames();
		Assert.notNull(profiles, "profiles shouldn't be empty");
		Assert.isTrue(profiles.length > 0, "There should be at least one profile");
		String[] roleNames = new String[user.getRoles().size()];
		int i = 0;
		for (Role role : user.getRoles()) {
			roleNames[i++] = role.getRoleName();
		}

		usm.addUser(user.getUserName(), credential, roleNames, user.getClaims(), profiles[0], requirePasswordChange);
	}

	public User getUser(String userName) throws UserStoreException, MalformedURLException {
		Assert.notNull(userName, "Username shouldn't be null");
		Assert.isTrue(!userName.isEmpty(), "Username shouldn't be empty");
		User user = new User();
		user.setUserName(userName);
		String[] profiles = usm.getAllProfileNames();
		Assert.notNull(profiles, "profiles shouldn't be empty");
		Assert.isTrue(profiles.length > 0, "There should be at least one profile");
		Claim[] claims = usm.getUserClaimValues(userName, profiles[0]);
		user.readClaims(claims);
		Set<Role> roles = getAllRolesOfUser(user);
		user.setRoles(roles);

		return user;
	}

	public List<User> getAllUsersForRole(Role role) throws UserStoreException, MalformedURLException {
		Assert.notNull(role, "role shouldn't be null");
		Assert.notNull(role.getRoleName(), "Role name shouldn't be null");
		Assert.isTrue(!role.getRoleName().isEmpty(), "Role name shouldn't be empty");

		String[] userNames = usm.getUserListOfRole(role.getRoleName());
		List<User> users = new ArrayList<User>();
		if (userNames != null) {
			for (int i = 0; i < userNames.length; i++) {
				users.add(getUser(userNames[i]));
			}
		}
		return users;
	}

	public void updateUserCredential(User user, String newCredential, String oldCredential) throws UserStoreException {
		Assert.notNull(user, "user shouldn't be null");
		Assert.notNull(user.getUserName(), "Username shouldn't be null");
		Assert.isTrue(!user.getUserName().isEmpty(), "Username shouldn't be empty");

		usm.updateCredential(user.getUserName(), newCredential, oldCredential);
	}

	public void updateUser(User user) throws UserStoreException, MalformedURLException {
		Assert.notNull(user, "user shouldn't be null");
		Assert.notNull(user.getUserName(), "Username shouldn't be null");
		Assert.isTrue(!user.getUserName().isEmpty(), "Username shouldn't be empty");

		User oldUser = getUser(user.getUserName());
		Assert.notNull(oldUser);

		Set<Role> rolesInNewUser = user.getRoles();
		Set<Role> rolesInOldUser = oldUser.getRoles();

		Set<Role> rolesToAdd = new HashSet<>(rolesInNewUser);
		rolesToAdd.removeAll(rolesInOldUser);
		Set<Role> rolesToRemove = new HashSet<>(rolesInOldUser);
		rolesToRemove.removeAll(rolesInNewUser);

		// updating roles
		usm.updateRoleListOfUser(user.getUserName(), Role.roleNames(rolesToRemove), Role.roleNames(rolesToAdd));

		// Updating user profile
		String[] profiles = usm.getProfileNames(user.getUserName());
		Assert.notNull(profiles, "profiles shouldn't be null");
		Assert.isTrue(profiles.length > 0, "profiles shouldn't be empty");

		usm.setUserClaimValues(user.getUserName(), user.getClaims(), profiles[0]);
	}

	public void deleteUser(User user) throws UserStoreException {
		Assert.notNull(user, "user shouldn't be null");
		Assert.notNull(user.getUserName(), "Username shouldn't be null");
		Assert.isTrue(!user.getUserName().isEmpty(), "Username shouldn't be empty");
		usm.deleteUser(user.getUserName());
	}

	// Role CRUD operations
	public Set<Role> getAllRoles() throws UserStoreException {
		String[] roleNames = usm.getRoleNames();
		Assert.notNull(roleNames, "Role names shouldn't be null");
		return Role.roles(roleNames);
	}

	public Set<Role> getAllRolesOfUser(User user) throws UserStoreException {
		Assert.notNull(user, "user shouldn't be null");
		Assert.notNull(user.getUserName(), "Username shouldn't be null");
		Assert.isTrue(!user.getUserName().isEmpty(), "Username shouldn't be empty");
		String[] roleNames = usm.getRoleListOfUser(user.getUserName());
		Assert.notNull(roleNames, "Role names shouldn't be null");
		return Role.roles(roleNames);
	}

	public void addRole(Role role) throws UserStoreException {
		Assert.notNull(role, "role shouldn't be null");
		Assert.notNull(role.getRoleName(), "Role name shouldn't be null");
		Assert.isTrue(!role.getRoleName().isEmpty(), "Role name shouldn't be empty");
		String[] userList = User.userNames(role.getUsers());
		usm.addRole(role.getRoleName(), userList, role.getPermissions().toArray(new Permission[] {}));
	}

	public void updateRole(Role role, String oldRoleName) throws UserStoreException {
		Assert.notNull(role, "role shouldn't be null");
		Assert.notNull(role.getRoleName(), "Role name shouldn't be null");
		Assert.isTrue(!role.getRoleName().isEmpty(), "Role name shouldn't be empty");
		// Role name
		usm.updateRoleName(oldRoleName, role.getRoleName());

		Set<User> usersInNewRole = role.getUsers();
		Set<User> usersInOldRole = User.users(usm.getUserListOfRole(oldRoleName));

		Set<User> usersToAdd = new HashSet<>(usersInNewRole);
		usersToAdd.removeAll(usersInOldRole);
		Set<User> usersToRemove = new HashSet<>(usersInOldRole);
		usersToRemove.removeAll(usersInNewRole);

		// Role Users
		usm.updateUserListOfRole(role.getRoleName(), User.userNames(usersToRemove), User.userNames(usersToAdd));

		// Role permissions
		// The stub does not allow to change permissions
	}

	public void deleteRole(Role role) throws UserStoreException {
		Assert.notNull(role, "role shouldn't be null");
		Assert.notNull(role.getRoleName(), "Role name shouldn't be null");
		Assert.isTrue(!role.getRoleName().isEmpty(), "Role name shouldn't be empty");
		usm.deleteRole(role.getRoleName());
	}

	// Getting authorization token

	public AuthorizationToken getAuthorizationToken(String userName, String credential, String tenant) throws TenantMgtAdminServiceExceptionException, URISyntaxException {
		Assert.isTrue(userName!=null & !userName.isEmpty(), "Username not set");
		Assert.isTrue(credential!=null & !credential.isEmpty(), "Credential not set");
		
		String tenantDomain = "";
		if (tenant!=null && !tenant.isEmpty()) {
			tenantDomain = IntegrationProperty.getProperty("is.authorization." + tenant + ".tenant.domain");
			Assert.isTrue(tenantDomain!=null & !tenantDomain.isEmpty(), "TenantUrl not retrieved from configuration");
		}//If tenant not set, using default IS
		
//		if (!tm.doesExistTenantDomain(tenantDomain)){
//			throw new IFException(tenantDomain + "does not exist in IF IS");
//		}
		
		String base64AuthorizationPair = IntegrationProperty.getProperty("is.authorization." + tenant + ".tenant.pair.base64");
		Assert.isTrue(base64AuthorizationPair!=null & !base64AuthorizationPair.isEmpty(), "Tenant base 64 authorization pair not retrieved from configuration");
		
		RequestEntity<String> request = RequestEntity.post(new URI(TOKEN_SERVICE_ENDPOINT))
					.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
					.header("Authorization", "Basic " + base64AuthorizationPair)
					.body("grant_type=password&username=" + userName+tenantDomain + "&password=" + credential);
		return restTemplate.exchange(request, AuthorizationToken.class).getBody();
	}
}
