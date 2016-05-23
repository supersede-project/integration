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
package eu.supersede.integration.api.security.test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;

import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.api.security.types.Role;
import eu.supersede.integration.api.security.types.User;

public class IFAuthenticationManagerTest {
	IFAuthenticationManager am;
	
	@Before
    public void setup() throws Exception {
		// Set Identity Server user/password as Java launcher properties:
		// -Dis.admin.user=
		// -Dis.admin.passwd=
		// for each tenant organization, use its admin account
		String admin = System.getProperty("is.admin.user");
		String password = System.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
    }
	
	//Authentication Test
	@Test
    public void authenticateUserTest() throws Exception{
    	Assert.isTrue(am.authenticateUser("yosu", "yosupass"));
    }
	
	//User tests
	
	@Test
	public void addUserTest() throws UserStoreException{
		User user = createUser();
    	boolean requirePasswordChange = false;
    	am.addUser(user, "userpassword", requirePasswordChange);
	}

	private User createUser() throws UserStoreException {
		User user = new User();
		user.setUserName("test");
		user.setFirstname("User Test firstname");
		user.setLastname("User Test lastname");
		user.setOrganization("User Test organization");
		user.setAddress("User Test address");
		user.setCountry("User Test country");
		user.setEmail("user@organization.org");
		user.setTelephone("800-555-55-55");
		user.setMobile("800-555-55-55");
		user.setIm("User Test IM");
    	try {
			user.setUrl(new URL("http://organization.org"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Adding roles
    	Set<Role>roles = new HashSet<Role>();
    	Set<Role> allRoles = am.getAllRoles();
    	for (Role role: allRoles){
    		if (role.getRoleName().contains("Supersede")){
    			roles.add(role);
    		}
    	}
    	user.setRoles(roles);
		return user;
	}
	
	@Test
	public void getUserTest() throws UserStoreException, MalformedURLException{
		String username = "test";
		User user = am.getUser(username);
		Assert.notNull(user);
	}
	
	@Test
	public void getAllUsersForRoleTest() throws UserStoreException, MalformedURLException{
		String rolename = "SupersedeSupervisor";
		Role role = new Role();
		role.setRoleName(rolename);
		List<User> users = am.getAllUsersForRole(role);
		Assert.notNull(users);
		Assert.isTrue(users.size()>0);
	}
	
	@Test
	public void updateUserTest() throws UserStoreException, MalformedURLException{
		User user = am.getUser("test");
		Assert.notNull(user);
		
		updateUser(user);

    	//Updating password and user profile
    	am.updateUserCredential(user, "userpasswordNew", "userpassword");
    	am.updateUser(user);
	}

	private void updateUser(User user) throws UserStoreException {
		user.setFirstname("User Test firstname modified");
		user.setLastname("User Test lastname modified");
		user.setOrganization("User Test organization modified");
		user.setAddress("User Test address modified");
		user.setCountry("User Test country modified");
		user.setEmail("user@organization_mod.org");
		user.setTelephone("800-555-55-66");
		user.setMobile("800-555-55-77");
		user.setIm("User Test IM modified");
		try {
			user.setUrl(new URL("http://organization_mod.org"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//Modifying roles
    	Set<Role> userRoles = am.getAllRolesOfUser(user);
    	Set<Role> allRoles = am.getAllRoles();
    	
    	Role removedRole = null;
    	for (Role role: userRoles){
    		if (role!=null && role.getRoleName().contains("Supersede")){
    			user.getRoles().remove(role);
    			removedRole = role;
    			break;
    		}
    	}
    	for (Role role: allRoles){
    		if (!user.getRoles().contains(role)){
    			if (removedRole != null && !removedRole.equals(role)){
    				user.getRoles().add(role);
    				break;
    			}
    		}
    	}
    	
    	user.setRoles(user.getRoles());
	}
	
	@Test
	public void deleteUserTest() throws UserStoreException, MalformedURLException{
		User user = am.getUser("test");
		Assert.notNull(user);
		am.deleteUser(user);
	}
	
	//Role tests
	@Test
	public void addRoleTest() throws UserStoreException, MalformedURLException{
		Role role = new Role();
		role.setRoleName ("testRole");
    	
		//Permissions
    	Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
    	Permission[] permissions = new Permission[]{permission};
    	
    	role.setPermissions(permissions);
    	
    	am.addRole(role);
	}
	
	/**
	 * Execute createUserTest before
	 * @throws UserStoreException
	 * @throws MalformedURLException
	 */
	@Test
	public void getAllRolesForUserTest() throws UserStoreException, MalformedURLException{
		User user = am.getUser("test");
		Assert.notNull(user);
		Set<Role> roles = am.getAllRolesOfUser(user);
		Assert.notNull(roles);
	}
	
	/*
	 * User test should be available before executing this test.
	 */
	@Test
	public void updateRoleTest() throws UserStoreException, MalformedURLException{
		Role role = new Role();
		role.setRoleName ("testRoleModified");
		
		User user = am.getUser("test");
		Assert.notNull(user);
		
		role.getUsers().add(user);
    	
    	am.updateRole(role, "testRole");
	}
	
	@Test
	public void deleteRoleTest() throws UserStoreException{
		Role role = new Role();
		role.setRoleName ("testRoleModified");
		
		am.deleteRole(role);
	}
	
	@Test
	public void getAuthorizationTokenTest() throws TenantMgtAdminServiceExceptionException, URISyntaxException{
		AuthorizationToken token = am.getAuthorizationToken("test", "test1", "siemens");
		Assert.notNull(token);
		Assert.notNull(token.getAccessToken());
		Assert.isTrue(!token.getAccessToken().isEmpty());
	}
	
}
