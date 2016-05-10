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
package eu.supersede.integration.datasource.poc.authentication.proxies.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.datasource.poc.authentication.DataStoreApp;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSRolesProxy;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.datasource.poc.authentication.types.UsersCollection;
import eu.supersede.integration.properties.IntegrationProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSUsersProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSUsersProxyTest.class);
	private SupersedeDSUsersProxy proxy;
	private SupersedeDSRolesProxy rolesProxy;
	private IFAuthenticationManager am;
	private AuthorizationToken token;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSUsersProxy();
    	rolesProxy = new SupersedeDSRolesProxy();
    	String admin = IntegrationProperty.getProperty("is.admin.user");
		String password = IntegrationProperty.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken("yosu", "yosupass");
    }

    @Test
    public void testGetUsers() throws Exception{
    	log.info("Testing testGetUsers");
		UsersCollection collection = proxy.getUsers(token);
		Assert.assertTrue(!collection.getUsers().isEmpty());
    }
    
    @Test
    public void testGetUser() throws Exception{
    	log.info("Testing testGetUser");
		User user = proxy.getUser(1, token);
		Assert.assertNotNull(user);
    }
    
    @Test
    public void testGetUserWithRoles() throws Exception{
    	log.info("Testing testGetUserWithRoles");
		User user = proxy.getUserWithRoles(1, token);
		Assert.assertNotNull(user);
    }
    
    @Test
    public void testCreateUser() throws Exception{
    	log.info("Testing testCreateUser");
    	User user = createUser();
		int userId = proxy.createUser(user, token);
		Assert.assertTrue(userId>0);
    }
    
    @Test
    public void testCreateUserWithRoles() throws Exception{
    	log.info("Testing testCreateUser");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user, token);
		Assert.assertTrue(userId>0);
		
    }
    
    @Test
    public void testUpdateUser() throws Exception{
    	log.info("Testing testUpdateUser");
    	User user = createUser();
		int userId = proxy.createUser(user, token);
		user.setUserId(userId);
    	user.setLogin(user.getLogin() + "UPDATED");
		proxy.updateUser(user, token);
    }
    
    @Test
    public void testUpdateUserWithRoles() throws Exception{
    	log.info("Testing testUpdateUserWithRoles");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user, token);
		user.setUserId(userId);
    	user.setLogin(user.getLogin() + "UPDATED");
    	List<Role> newRoles = new ArrayList<Role> (Arrays.asList(user.getRoles())); //Required since Arrays.asList returns an unmutable array
    	newRoles.add(rolesProxy.getRole(2, token));
    	user.setRoles(newRoles.toArray(new Role[]{}));
		proxy.updateUser(user, token);
    }
    
    @Test
    public void testDeleteUser() throws Exception{
    	log.info("Testing testDeleteUser");
    	User user = createUser();
		int userId = proxy.createUser(user, token);
		user.setUserId(userId);
		proxy.deleteUser(user, token);
    }
    
    @Test
    public void testDeleteUserWithRoles() throws Exception{
    	log.info("Testing testDeleteUserWithRoles");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user, token);
		user.setUserId(userId);
		proxy.deleteUser(user, token);
    }

	private User createUser() {
		User user = new User();
		user.setLogin("clara");
		user.setPassword("claraPassword");
		user.setFirst_name("Clara");
		user.setFamily_name("Pezuela");
		user.setEmail("clara.pezuela@atos.net");
		user.setCreation_date(new Date());
		user.setActive(false);
		return user;
	}
	
	private User createUserWithRoles() {
		User user = new User();
		user.setLogin("clara");
		user.setPassword("claraPassword");
		user.setFirst_name("Clara");
		user.setFamily_name("Pezuela");
		user.setEmail("clara.pezuela@atos.net");
		user.setCreation_date(new Date());
		user.setActive(false);
		Role role = rolesProxy.getRole(1, token);
		user.setRoles(new Role[]{role});
		return user;
	}
}
