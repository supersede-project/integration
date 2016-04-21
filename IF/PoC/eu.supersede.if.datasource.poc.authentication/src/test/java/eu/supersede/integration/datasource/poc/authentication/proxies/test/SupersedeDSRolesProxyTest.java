package eu.supersede.integration.datasource.poc.authentication.proxies.test;

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
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.RolesCollection;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSRolesProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesProxyTest.class);
	private SupersedeDSRolesProxy proxy;
	
    @Before
    public void setup() throws Exception {
    	proxy = new SupersedeDSRolesProxy();
    }

    @Test
    public void testGetRoles() throws Exception{
    	log.info("Testing testGetRoles");
		RolesCollection collection = new SupersedeDSRolesProxy().getRoles();
		Assert.assertTrue(!collection.getRoles().isEmpty());
    }
    
    @Test
    public void testGetRole() throws Exception{
    	log.info("Testing testGetRole");
		Role role = new SupersedeDSRolesProxy().getRole(1);
		Assert.assertNotNull(role);
    }
    
    @Test
    public void testGetRoleWithUsers() throws Exception{
    	log.info("Testing testGetRoleWithUsers");
		Role role = new SupersedeDSRolesProxy().getRoleWithUsers(1);
		Assert.assertNotNull(role);
    }
    
    @Test
    public void testCreateRole() throws Exception{
    	log.info("Testing testCreateRole");
    	Role role = createRole();
		int roleId = new SupersedeDSRolesProxy().createRole(role);
		Assert.assertTrue(roleId>0);
    }
    
    @Test
    public void testUpdateRole() throws Exception{
    	log.info("Testing testUpdateRole");
    	Role role = createRole();
    	int roleId = proxy.createRole(role);
    	role.setRoleId(roleId);
    	role.setDescription(role.getDescription() + " .UPDATED");
		proxy.updateRole(role);
    }
    
    @Test
    public void testDeleteRole() throws Exception{
    	log.info("Testing testDeleteRole");
    	Role role = createRole();
    	int roleId = proxy.createRole(role);
    	role.setRoleId(roleId);
		proxy.deleteRole(role);
    }

	private Role createRole() {
		Role role = new Role();
		role.setName("SW Integrator");
		role.setDescription("Software Integrator, resposible for the integration of services");
		role.setActive(false);
		return role;
	}

}
