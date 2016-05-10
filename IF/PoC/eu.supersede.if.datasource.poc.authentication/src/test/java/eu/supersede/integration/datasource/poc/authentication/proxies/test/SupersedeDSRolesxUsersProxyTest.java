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
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSRolesxUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.properties.IntegrationProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSRolesxUsersProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesxUsersProxyTest.class);
	private SupersedeDSRolesxUsersProxy proxy;
	private SupersedeDSRolesProxy rolesProxy;
	private SupersedeDSUsersProxy usersProxy;
	private IFAuthenticationManager am;
	private AuthorizationToken token;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSRolesxUsersProxy();
    	rolesProxy = new SupersedeDSRolesProxy();
    	usersProxy = new SupersedeDSUsersProxy();
    	String admin = IntegrationProperty.getProperty("is.admin.user");
		String password = IntegrationProperty.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken("yosu", "yosupass");
    }
    
    @Test
    public void testAddRoleForUser() throws Exception{
    	log.info("Testing testAddRoleForUser");
		Role role = rolesProxy.getRole(2, token);
		User user = usersProxy.getUser(2, token);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		proxy.addRoleForUser(role, user, token);
    }
    
    @Test
    public void testDeleteRoleForUser() throws Exception{
    	log.info("Testing testDeleteRoleForUser");
		Role role = rolesProxy.getRole(2, token);
		User user = usersProxy.getUser(2, token);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		proxy.deleteRoleForUser(role, user, token);
    }
    
    @Test
    public void testRolehasUser() throws Exception{
    	log.info("Testing testRolehasUser");
		Role role = rolesProxy.getRole(1, token);
		User user = usersProxy.getUser(1, token);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		boolean result = proxy.roleHasUser(role, user, token);
		Assert.assertTrue(result);
    }
    
    @Test
    public void testUserhasRole() throws Exception{
    	log.info("Testing testUserhasRole");
		Role role = rolesProxy.getRole(1, token);
		User user = usersProxy.getUser(2, token);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		boolean result = proxy.userHasRole(user, role, token);
		Assert.assertTrue(result);
    }
    
    @Test
    public void testGetAllRolesForUser() throws Exception{
    	log.info("Testing testGetAllRolesForUser");
		User user = usersProxy.getUser(2, token);		
		Assert.assertNotNull(user);
		List<Integer> result = proxy.getAllRolesForUser(user, token);
		Assert.assertTrue(result.size()>0);
    }
}
