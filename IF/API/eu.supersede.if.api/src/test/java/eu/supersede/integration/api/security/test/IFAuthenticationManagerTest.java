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

import org.junit.BeforeClass;
import org.junit.Ignore;
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
	static IFAuthenticationManager am;
	//User test
	String testUserName = "test";
	String testUserPassword = "testpassword";
	String tenant = "atos";
	//Role test
	String testRoleName = "testRole";
	boolean requirePasswordChange = false;
	
	@BeforeClass
    public static void setup() throws Exception {
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
		//If user does not exist, create user
		if (am.getUser(testUserName)==null){
			User user = createTestUser();
			
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
    	Assert.isTrue(am.authenticateUser(testUserName, testUserPassword));
    }
	
	//User tests
	
	@Test
	public void addUserTest() throws UserStoreException, MalformedURLException{
		User user = createTestUser();
		//If user exist remove user
		if (am.getUser(user.getUserName())!=null){
			am.deleteUser(user);
		}
		
    	am.addUser(user, testUserPassword, requirePasswordChange);
	}

	private User createTestUser() throws UserStoreException {
		User user = new User();
		user.setUserName(testUserName);
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
    	Role role = createTestRole();
    	if (!allRoles.contains(role)){
    		am.addRole(role);
    	}
//    	for (Role role: allRoles){
//    		if (role.getRoleName().contains("testRole")){
//    			roles.add(role);
//    		}
//    	}
    	roles.add(role);
    	user.setRoles(roles);
		return user;
	}
	
	@Test
	public void getUserTest() throws UserStoreException, MalformedURLException{
		//If user does not exist, create user
		if (am.getUser(testUserName)==null){
			User user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
		User user = am.getUser(testUserName);
		Assert.notNull(user);
	}
	
	@Test
	public void getAllUsersForRoleTest() throws UserStoreException, MalformedURLException{
		Role role = createTestRole();
		//Add role if it does not exist
		Set<Role> allRoles = am.getAllRoles();
    	if (!allRoles.contains(role)){
    		am.addRole(role);
    	}
    	
		//Add user if user does not exist
		if (am.getUser(testUserName)==null){
			User user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
		
		List<User> users = am.getAllUsersForRole(role);
		Assert.notNull(users);
		Assert.isTrue(users.size()>0);
	}
	
	@Test
	public void updateUserTest() throws UserStoreException, MalformedURLException{
		User user = am.getUser(testUserName);
		//If user does not exist, create user
		if (user==null){
			user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}

		updateUser(user);

    	//Updating password and user profile
    	am.updateUserCredential(user, testUserPassword + "New", testUserPassword);
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
		User user = am.getUser(testUserName);
		//If user does not exist, create user
		if (user==null){
			user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
		am.deleteUser(user);
	}
	
	//Role tests
	@Test
	public void addRoleTest() throws UserStoreException, MalformedURLException{
		Role role = createTestRole();
    	
    	//if role exist, remove role
    	if (am.getAllRoles().contains(role)){
    		am.deleteRole(role);
    	}
    	
    	am.addRole(role);
	}

	private Role createTestRole() {
		Role role = new Role();
		role.setRoleName (testRoleName);
    	
		//Permissions
    	Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
    	Permission[] permissions = new Permission[]{permission};
    	role.setPermissions(permissions);
		return role;
	}
	
	/**
	 * Execute createUserTest before
	 * @throws UserStoreException
	 * @throws MalformedURLException
	 */
	@Test
	public void getAllRolesForUserTest() throws UserStoreException, MalformedURLException{
		User user = am.getUser(testUserName);
		//If user does not exist, create user
		if (user==null){
			user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
		Assert.notNull(user);
		Set<Role> roles = am.getAllRolesOfUser(user);
		Assert.notNull(roles);
	}
	
	/*
	 * User test should be available before executing this test.
	 */
//	@Test
//	public void updateRoleTest() throws UserStoreException, MalformedURLException{
//		Role role = new Role();
//		role.setRoleName ("testRoleModified");
//		
//		User user = am.getUser(testUserName);
//		Assert.notNull(user);
//		
//		role.getUsers().add(user);
//    	
//    	am.updateRole(role, "testRole");
//	}
	
	@Test
	public void deleteRoleTest() throws UserStoreException{
		Role role = createTestRole();
    	//if role does no exist, create role
    	if (!am.getAllRoles().contains(role)){
    		am.addRole(role);
    	}
		
		am.deleteRole(role);
	}
	
	@Test
	public void getAuthorizationTokenTest() throws TenantMgtAdminServiceExceptionException, URISyntaxException, UserStoreException, MalformedURLException{
		//Create user if it does not exist
		if (am.getUser(testUserName)==null){
			User user = createTestUser();
	    	am.addUser(user, testUserPassword, requirePasswordChange);
		}
		
		AuthorizationToken token = am.getAuthorizationToken(testUserName, testUserPassword, "atos");
		Assert.notNull(token);
		Assert.notNull(token.getAccessToken());
		Assert.isTrue(!token.getAccessToken().isEmpty());
	}
	
	@Ignore @Test
	public void getAuthorizationTokenTest2() throws TenantMgtAdminServiceExceptionException, URISyntaxException, UserStoreException, MalformedURLException{
		AuthorizationToken token = am.getAuthorizationToken("wp_admin", "12345", "atos");
		Assert.notNull(token);
		Assert.notNull(token.getAccessToken());
		Assert.isTrue(!token.getAccessToken().isEmpty());
	}
	
}
