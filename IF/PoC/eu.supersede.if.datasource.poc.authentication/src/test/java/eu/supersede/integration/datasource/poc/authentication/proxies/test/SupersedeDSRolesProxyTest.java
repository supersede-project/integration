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
import eu.supersede.integration.datasource.poc.authentication.types.RolesCollection;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.properties.IntegrationProperty;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSRolesProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesProxyTest.class);
	private SupersedeDSRolesProxy proxy;
	private SupersedeDSUsersProxy usersProxy;
	private IFAuthenticationManager am;
	private AuthorizationToken token;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSRolesProxy();
    	usersProxy = new SupersedeDSUsersProxy();
    	String admin = IntegrationProperty.getProperty("is.admin.user");
		String password = IntegrationProperty.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken("yosu", "yosupass");
    }

    @Test
    public void testGetRoles() throws Exception{
    	log.info("Testing testGetRoles");
		RolesCollection collection = new SupersedeDSRolesProxy().getRoles(token);
		Assert.assertTrue(!collection.getRoles().isEmpty());
    }
    
    @Test
    public void testGetRole() throws Exception{
    	log.info("Testing testGetRole");
		Role role = new SupersedeDSRolesProxy().getRole(1, token);
		Assert.assertNotNull(role);
    }
    
    @Test
    public void testGetRoleWithUsers() throws Exception{
    	log.info("Testing testGetRoleWithUsers");
		Role role = new SupersedeDSRolesProxy().getRoleWithUsers(1, token);
		Assert.assertNotNull(role);
    }
    
    @Test
    public void testCreateRole() throws Exception{
    	log.info("Testing testCreateRole");
    	Role role = createRole();
		int roleId = new SupersedeDSRolesProxy().createRole(role, token);
		Assert.assertTrue(roleId>0);
    }
    
    @Test
    public void testCreateRoleWithUsers() throws Exception{
    	log.info("Testing testCreateRoleWithUsers");
    	Role role = createRoleWithUsers();
		int roleId = proxy.createRole(role, token);
		Assert.assertTrue(roleId>0);
    }
    
    @Test
    public void testUpdateRole() throws Exception{
    	log.info("Testing testUpdateRole");
    	Role role = createRole();
    	int roleId = proxy.createRole(role, token);
    	role.setRoleId(roleId);
    	role.setDescription(role.getDescription() + " .UPDATED");
		proxy.updateRole(role, token);
    }
    
    @Test
    public void testUpdateRoleWithUsers() throws Exception{
    	log.info("Testing testUpdateRoleWithUsers");
    	Role role = createRoleWithUsers();
    	int roleId = proxy.createRole(role, token);
    	role.setRoleId(roleId);
    	role.setDescription(role.getDescription() + " .UPDATED");
    	
    	List<User> newUsers = new ArrayList<User> (Arrays.asList(role.getUsers())); //Required since Arrays.asList returns an unmutable array
    	newUsers.add(usersProxy.getUser(2, token));
    	role.setUsers(newUsers.toArray(new User[]{}));
		proxy.updateRole(role, token);
    }
    
    
    @Test
    public void testDeleteRole() throws Exception{
    	log.info("Testing testDeleteRole");
    	Role role = createRole();
    	int roleId = proxy.createRole(role, token);
    	role.setRoleId(roleId);
		proxy.deleteRole(role, token);
    }
    
    @Test
    public void testDeleteRoleWithUsers() throws Exception{
    	log.info("Testing testDeleteRoleWithUsers");
    	Role role = createRoleWithUsers();
    	int roleId = proxy.createRole(role, token);
    	role.setRoleId(roleId);
		proxy.deleteRole(role, token);
    }

	private Role createRole() {
		Role role = new Role();
		role.setName("SW Integrator");
		role.setDescription("Software Integrator, resposible for the integration of services");
		role.setActive(false);
		return role;
	}
	
	private Role createRoleWithUsers() {
		Role role = new Role();
		role.setName("SW Integrator");
		role.setDescription("Software Integrator, resposible for the integration of services");
		role.setActive(false);
		User user = usersProxy.getUser(1, token);
		role.setUsers(new User[]{user});
		return role;
	}

}
