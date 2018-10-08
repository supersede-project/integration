package eu.supersede.integration.api.security.test;


import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.api.security.types.Role;
import eu.supersede.integration.api.security.types.User;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;


@Ignore
public class AmplIFAuthenticationManagerTest {
    static IFAuthenticationManager am;

    String testUserName = "test";

    String testUserPassword = "testpassword";

    String tenant = "atos";

    String testRoleName = "testRole";

    boolean requirePasswordChange = false;

    @BeforeClass
    public static void setup() throws Exception {
        String admin = System.getProperty("is.admin.user");
        String password = System.getProperty("is.admin.passwd");
        AmplIFAuthenticationManagerTest.am = new IFAuthenticationManager(admin, password);
    }

    private User createTestUser() throws UserStoreException {
        User user = new User();
        user.setUserName(testUserName);
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
        Set<Role> roles = new HashSet<Role>();
        Set<Role> allRoles = AmplIFAuthenticationManagerTest.am.getAllRoles();
        Role role = createTestRole();
        if (!(allRoles.contains(role))) {
            AmplIFAuthenticationManagerTest.am.addRole(role);
        }
        roles.add(role);
        user.setRoles(roles);
        return user;
    }

    private void updateUser(User user) throws UserStoreException {
        user.setFirstname("User Test firstname modified");
        user.setLastname("User Test lastname modified");
        user.setOrganization("User Test organization modified");
        user.setAddress("User Test address modified");
        user.setCountry("User Test country modified");
        user.setEmail("user@organization_mod.org");
        user.setTelephone("800-555-55-66");
        user.setMobile("800-555-55-77");
        user.setIm("User Test IM modified");
        try {
            user.setUrl(new URL("http://organization_mod.org"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Set<Role> userRoles = AmplIFAuthenticationManagerTest.am.getAllRolesOfUser(user);
        Set<Role> allRoles = AmplIFAuthenticationManagerTest.am.getAllRoles();
        Role removedRole = null;
        for (Role role : userRoles) {
            if ((role != null) && (role.getRoleName().contains("Supersede"))) {
                user.getRoles().remove(role);
                removedRole = role;
                break;
            }
        }
        for (Role role : allRoles) {
            if (!(user.getRoles().contains(role))) {
                if ((removedRole != null) && (!(removedRole.equals(role)))) {
                    user.getRoles().add(role);
                    break;
                }
            }
        }
        user.setRoles(user.getRoles());
    }

    private Role createTestRole() {
        Role role = new Role();
        role.setRoleName(testRoleName);
        Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        role.setPermissions(permissions);
        return role;
    }

    @Ignore
    @Test
    public void getAuthorizationTokenTest() throws MalformedURLException, URISyntaxException, TenantMgtAdminServiceExceptionException, UserStoreException {
        AuthorizationToken token = AmplIFAuthenticationManagerTest.am.getAuthorizationToken(testUserName, testUserPassword, "atos");
        Assert.notNull(token);
        Assert.notNull(token.getAccessToken());
        Assert.isTrue((!(token.getAccessToken().isEmpty())));
    }
}

