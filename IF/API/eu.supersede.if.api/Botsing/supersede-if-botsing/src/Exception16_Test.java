import org.junit.Test;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.User;
import eu.supersede.integration.api.security.types.Role;
import org.wso2.carbon.user.core.UserStoreException;
import java.net.MalformedURLException;
import java.net.URL;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.CarbonConstants;
import java.util.Set;
import java.util.HashSet;

public class Exception16_Test{
	String testRoleName = "testRole";
	@Test (expected=org.wso2.carbon.user.core.UserStoreException.class)
	public void throwUserDoesNotExistWhenDeleteUserTest() throws UserStoreException, MalformedURLException{
		try {
                        IFAuthenticationManager am = new IFAuthenticationManager();
			User user = createTestUser("userdoesnotexist", am);
			am.deleteUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private User createTestUser(String userName, IFAuthenticationManager am) throws UserStoreException {
		User user = new User();
		user.setUserName(userName);
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
	//			roles.add(role);
    	//    		}
    	//    	}
   	    	roles.add(role);
    	    	user.setRoles(roles);
		return user;
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
}
