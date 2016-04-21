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

import eu.supersede.integration.datasource.poc.authentication.DataStoreApp;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSRolesProxy;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSRolesxUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSRolesxUsersProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesxUsersProxyTest.class);
	private SupersedeDSRolesxUsersProxy proxy;
	private SupersedeDSRolesProxy rolesProxy;
	private SupersedeDSUsersProxy usersProxy;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSRolesxUsersProxy();
    	rolesProxy = new SupersedeDSRolesProxy();
    	usersProxy = new SupersedeDSUsersProxy();
    }
    
    @Test
    public void testAddRoleForUser() throws Exception{
    	log.info("Testing testAddRoleForUser");
		Role role = rolesProxy.getRole(2);
		User user = usersProxy.getUser(2);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		proxy.addRoleForUser(role, user);
    }
    
    @Test
    public void testDeleteRoleForUser() throws Exception{
    	log.info("Testing testDeleteRoleForUser");
		Role role = rolesProxy.getRole(2);
		User user = usersProxy.getUser(2);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		proxy.deleteRoleForUser(role, user);
    }
    
    @Test
    public void testRolehasUser() throws Exception{
    	log.info("Testing testRolehasUser");
		Role role = rolesProxy.getRole(1);
		User user = usersProxy.getUser(1);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		boolean result = proxy.roleHasUser(role, user);
		Assert.assertTrue(result);
    }
    
    @Test
    public void testUserhasRole() throws Exception{
    	log.info("Testing testUserhasRole");
		Role role = rolesProxy.getRole(1);
		User user = usersProxy.getUser(2);
		Assert.assertNotNull(role);
		Assert.assertNotNull(user);
		boolean result = proxy.userHasRole(user, role);
		Assert.assertTrue(result);
    }
    
    @Test
    public void testGetAllRolesForUser() throws Exception{
    	log.info("Testing testGetAllRolesForUser");
		User user = usersProxy.getUser(2);		
		Assert.assertNotNull(user);
		List<Integer> result = proxy.getAllRolesForUser(user);
		Assert.assertTrue(result.size()>0);
    }
}
