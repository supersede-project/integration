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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreManager;

import eu.supersede.integration.api.security.IFUserStoreManager;

@Ignore
public class IdentityManagerClientTest {
//	private static final Logger log = LoggerFactory.getLogger(IdentityManagerClientTest.class);
	private static UserStoreManager usm;
	
	public static final String CLAIM_FIRST_NAME_URI = "http://wso2.org/claims/givenname";
	public static final String CLAIM_LAST_NAME_URI = "http://wso2.org/claims/lastname";
	public static final String CLAIM_ORGANIZATION_URI = "http://wso2.org/claims/organization";
	public static final String CLAIM_ADDRESS_URI = "http://wso2.org/claims/streetaddress";
	public static final String CLAIM_COUNTRY_URI = "http://wso2.org/claims/country";
	public static final String CLAIM_EMAIL_URI = "http://wso2.org/claims/emailaddress";
	public static final String CLAIM_TELEPHONE_URI = "http://wso2.org/claims/telephone";
	public static final String CLAIM_MOBILE_URI = "http://wso2.org/claims/mobile";
	public static final String CLAIM_IM_URI = "http://wso2.org/claims/im";
	public static final String CLAIM_URL_URI = "http://wso2.org/claims/url";
	
	private static String admin;
	private static String password;
	
    @BeforeClass
    public static void setup() throws Exception {
//    	String admin = IntegrationProperty.getProperty("is.admin.user");
//		String password = IntegrationProperty.getProperty("is.admin.passwd");
    	admin = System.getProperty("is.admin.user");
    	password = System.getProperty("is.admin.passwd");
        usm = new IFUserStoreManager(admin, password);
    }

    @Test
    public void testAuthenticateUserAccount() throws Exception{
    	Assert.isTrue(usm.authenticate(admin, password));
    }
    
    @Test
    public void testGetRoles() throws Exception{
    	String[] roles = usm.getRoleNames();
    	Assert.notEmpty(roles);
    	for (int i=0; i<roles.length; i++)
    		System.out.println("Role: " + roles[i]);
    }
    
    @Test
    public void testGetAllProfileNames() throws Exception{
    	String[] profiles = usm.getAllProfileNames();
    	Assert.notEmpty(profiles);
    	for (int i=0; i<profiles.length; i++)
    		System.out.println("Profile: " + profiles[i]);
    }
    
    @Test
    public void testAddUser() throws Exception{
    	String[] roles = usm.getRoleNames();
    	Assert.notEmpty(roles);
    	String userName = "test";
    	String credential = "test";
    	
    	//Remove user if exist
    	try{
    		usm.deleteUser(userName);
    	}catch (Exception ignored){
    		//Exception thrown when trying to delete a non-existing user - ignore
    	}
    	
    	//Claims are use to add user metadata
    	Map<String, String> claims = new HashMap<String, String>();
    	claims.put(CLAIM_FIRST_NAME_URI, "User Test firstname");
    	claims.put(CLAIM_LAST_NAME_URI, "User Test lastname");
    	claims.put(CLAIM_ORGANIZATION_URI, "User Test organization");
    	claims.put(CLAIM_ADDRESS_URI, "User Test address");
    	claims.put(CLAIM_COUNTRY_URI, "User Test country");
    	claims.put(CLAIM_EMAIL_URI, "user@organization.org");
    	claims.put(CLAIM_TELEPHONE_URI, "800-555-55-55");
    	claims.put(CLAIM_MOBILE_URI, "800-555-55-55");
    	claims.put(CLAIM_IM_URI, "User Test IM");
    	claims.put(CLAIM_URL_URI, "http://organization.org");
        
    	String[] profiles = usm.getAllProfileNames();
    	Assert.notEmpty(profiles);
    	boolean requirePasswordChange = false;
    	String[] roleList = new String[]{roles[1], roles[2]}; 
    	usm.addUser(userName, (Object) credential, roleList, claims, profiles[0], requirePasswordChange);
    	
//    	int userId = usm.getUserId(userName);
//    	Assert.isTrue (userId>0);
    }
    
    @Test
    public void testAddRole() throws Exception{
    	String roleName = "testRole";
    	String[] userList = new String[]{};
    	Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
    	Permission[] permissions = new Permission[]{permission};
    	
    	String[] roles = usm.getRoleNames();
    	if(Arrays.asList(roles).contains(roleName))
    		usm.deleteRole(roleName);
    	
    	usm.addRole(roleName, userList, permissions);
    }
}
