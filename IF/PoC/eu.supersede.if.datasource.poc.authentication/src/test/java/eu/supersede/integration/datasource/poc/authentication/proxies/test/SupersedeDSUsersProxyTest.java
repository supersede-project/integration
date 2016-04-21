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

import eu.supersede.integration.datasource.poc.authentication.DataStoreApp;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSRolesProxy;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.datasource.poc.authentication.types.UsersCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSUsersProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSUsersProxyTest.class);
	private SupersedeDSUsersProxy proxy;
	private SupersedeDSRolesProxy rolesProxy;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSUsersProxy();
    	rolesProxy = new SupersedeDSRolesProxy();
    }

    @Test
    public void testGetUsers() throws Exception{
    	log.info("Testing testGetUsers");
		UsersCollection collection = proxy.getUsers();
		Assert.assertTrue(!collection.getUsers().isEmpty());
    }
    
    @Test
    public void testGetUser() throws Exception{
    	log.info("Testing testGetUser");
		User user = proxy.getUser(1);
		Assert.assertNotNull(user);
    }
    
    @Test
    public void testGetUserWithRoles() throws Exception{
    	log.info("Testing testGetUserWithRoles");
		User user = proxy.getUserWithRoles(1);
		Assert.assertNotNull(user);
    }
    
    @Test
    public void testCreateUser() throws Exception{
    	log.info("Testing testCreateUser");
    	User user = createUser();
		int userId = proxy.createUser(user);
		Assert.assertTrue(userId>0);
    }
    
    @Test
    public void testCreateUserWithRoles() throws Exception{
    	log.info("Testing testCreateUser");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user);
		Assert.assertTrue(userId>0);
		
    }
    
    @Test
    public void testUpdateUser() throws Exception{
    	log.info("Testing testUpdateUser");
    	User user = createUser();
		int userId = proxy.createUser(user);
		user.setUserId(userId);
    	user.setLogin(user.getLogin() + "UPDATED");
		proxy.updateUser(user);
    }
    
    @Test
    public void testUpdateUserWithRoles() throws Exception{
    	log.info("Testing testUpdateUserWithRoles");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user);
		user.setUserId(userId);
    	user.setLogin(user.getLogin() + "UPDATED");
    	List<Role> newRoles = new ArrayList<Role> (Arrays.asList(user.getRoles())); //Required since Arrays.asList returns an unmutable array
    	newRoles.add(rolesProxy.getRole(2));
    	user.setRoles(newRoles.toArray(new Role[]{}));
		proxy.updateUser(user);
    }
    
    @Test
    public void testDeleteUser() throws Exception{
    	log.info("Testing testDeleteUser");
    	User user = createUser();
		int userId = proxy.createUser(user);
		user.setUserId(userId);
		proxy.deleteUser(user);
    }
    
    @Test
    public void testDeleteUserWithRoles() throws Exception{
    	log.info("Testing testDeleteUserWithRoles");
    	User user = createUserWithRoles();
		int userId = proxy.createUser(user);
		user.setUserId(userId);
		proxy.deleteUser(user);
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
		Role role = rolesProxy.getRole(1);
		user.setRoles(new Role[]{role});
		return user;
	}
}
