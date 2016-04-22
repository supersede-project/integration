package eu.supersede.integration.api.security.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreManager;

import eu.supersede.integration.api.security.IFUserStoreManager;

public class IdentityManagerClientTest {
	private static final Logger log = LoggerFactory.getLogger(IdentityManagerClientTest.class);
	private UserStoreManager usm;
	
    @Before
    public void setup() throws Exception {
        usm = new IFUserStoreManager();
    }

    @Test
    public void testAuthenticateUserAccount() throws Exception{
    	Assert.isTrue(usm.authenticate("yosu", "yosutest"));
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
    	Map<String, String> claims = new HashMap<String, String>();
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
    	String roleName = "test";
    	String[] userList = new String[]{};
    	Permission[] permissions = new Permission[]{};
    	
    	usm.addRole(roleName, userList, permissions);
    }
}
