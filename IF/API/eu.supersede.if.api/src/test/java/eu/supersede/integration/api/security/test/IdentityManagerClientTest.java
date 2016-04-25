package eu.supersede.integration.api.security.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreManager;

import eu.supersede.integration.api.security.IFUserStoreManager;

public class IdentityManagerClientTest {
//	private static final Logger log = LoggerFactory.getLogger(IdentityManagerClientTest.class);
	private UserStoreManager usm;
	
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
    	
    	usm.addRole(roleName, userList, permissions);
    }
}
