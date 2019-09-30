package eu.supersede.integration.api.security.test;


import eu.supersede.integration.api.security.IFAccount;
import eu.supersede.integration.api.security.IFUserStoreManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notEmpty;


public class IdentityManagerClientTest_Ampl2 {
    private static UserStoreManager usm;

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

    private static String admin;

    private static String password;

    @BeforeClass
    public static void setup() throws Exception {
        IdentityManagerClientTest_Ampl2.admin = IFAccount.getUser();
        IdentityManagerClientTest_Ampl2.password = IFAccount.getPassword();
        IdentityManagerClientTest_Ampl2.usm = new IFUserStoreManager(IdentityManagerClientTest_Ampl2.admin, IdentityManagerClientTest_Ampl2.password);
    }

    @Test(timeout = 30000)
    public void testAuthenticateUserAccount_add4096() throws Exception {
        boolean o_testAuthenticateUserAccount_add4096__1 = IdentityManagerClientTest_Ampl2.usm.authenticate(IdentityManagerClientTest_Ampl2.admin, IdentityManagerClientTest_Ampl2.password);
        Assert.assertTrue(o_testAuthenticateUserAccount_add4096__1);
        isTrue(IdentityManagerClientTest_Ampl2.usm.authenticate(IdentityManagerClientTest_Ampl2.admin, IdentityManagerClientTest_Ampl2.password));
        Assert.assertTrue(o_testAuthenticateUserAccount_add4096__1);
    }

    @Test(timeout = 30000)
    public void testGetAllProfileNames_literalMutationNumber4149_failAssert0() throws Exception {
        try {
            String[] profiles = IdentityManagerClientTest_Ampl2.usm.getAllProfileNames();
            notEmpty(profiles);
            for (int i = -1; i < (profiles.length); i++) {
                System.out.println(("Profile: " + (profiles[i])));
            }
            org.junit.Assert.fail("testGetAllProfileNames_literalMutationNumber4149 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddUser_literalMutationString1881_failAssert0() throws Exception {
        try {
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            notEmpty(roles);
            String userName = "test";
            String credential = "test";
            {
                IdentityManagerClientTest_Ampl2.usm.deleteUser(userName);
            }
            Map<String, String> claims = new HashMap<String, String>();
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_FIRST_NAME_URI, "User Test firstname");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_LAST_NAME_URI, "http://wso2.org/claims/organization");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_ORGANIZATION_URI, "User Test organization");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_ADDRESS_URI, "User Test address");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_COUNTRY_URI, "User Test country");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_EMAIL_URI, "user@organization.org");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_TELEPHONE_URI, "800-555-55-55");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_MOBILE_URI, "800-555-55-55");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_IM_URI, "User Test IM");
            claims.put(IdentityManagerClientTest_Ampl2.CLAIM_URL_URI, "http://organization.org");
            String[] profiles = IdentityManagerClientTest_Ampl2.usm.getAllProfileNames();
            notEmpty(profiles);
            boolean requirePasswordChange = false;
            String[] roleList = new String[]{ roles[1], roles[2] };
            IdentityManagerClientTest_Ampl2.usm.addUser(userName, ((Object) (credential)), roleList, claims, profiles[0], requirePasswordChange);


            org.junit.Assert.fail("testAddUser_literalMutationString1881 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_add1() throws Exception {
        String roleName = "testRole";
        Assert.assertEquals("testRole", roleName);
        String[] userList = new String[]{  };
        Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        IdentityManagerClientTest_Ampl2.usm.getRoleNames();
        String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
        if (Arrays.asList(roles).contains(roleName)) {
            IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
        }
        IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
        Assert.assertEquals("testRole", roleName);
    }

    @Test(timeout = 30000)
    public void testAddRole_remove7() throws Exception {
        String roleName = "testRole";
        Assert.assertEquals("testRole", roleName);
        String[] userList = new String[]{  };
        Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
        if (Arrays.asList(roles).contains(roleName)) {
            IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
        }
        Assert.assertEquals("testRole", roleName);
    }

    @Test(timeout = 30000)
    public void testAddRole_literalMutationString14() throws Exception {
        String roleName = "testRole";
        Assert.assertEquals("testRole", roleName);
        String[] userList = new String[]{  };
        Permission permission = new Permission("", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
        if (Arrays.asList(roles).contains(roleName)) {
            IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
        }
        IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
        Assert.assertEquals("testRole", roleName);
    }

    @Test(timeout = 30000)
    public void testAddRole_add4_failAssert0() throws Exception {
        try {
            String roleName = "testRole";
            String[] userList = new String[]{  };
            Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
            Permission[] permissions = new Permission[]{ permission };
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            if (Arrays.asList(roles).contains(roleName)) {
                IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
                IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
            }
            IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
            org.junit.Assert.fail("testAddRole_add4 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_add5_failAssert0() throws Exception {
        try {
            String roleName = "testRole";
            String[] userList = new String[]{  };
            Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
            Permission[] permissions = new Permission[]{ permission };
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            if (Arrays.asList(roles).contains(roleName)) {
                IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
            }
            IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
            IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
            org.junit.Assert.fail("testAddRole_add5 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_literalMutationString8_failAssert0() throws Exception {
        try {
            String roleName = "";
            String[] userList = new String[]{  };
            Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
            Permission[] permissions = new Permission[]{ permission };
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            if (Arrays.asList(roles).contains(roleName)) {
                IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
            }
            IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
            org.junit.Assert.fail("testAddRole_literalMutationString8 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_remove7litString425() throws Exception {
        String roleName = "testRole";
        Assert.assertEquals("testRole", roleName);
        String[] userList = new String[]{  };
        Permission permission = new Permission("/pemission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
        if (Arrays.asList(roles).contains(roleName)) {
            IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
        }
        Assert.assertEquals("testRole", roleName);
    }

    @Test(timeout = 30000)
    public void testAddRole_add5_failAssert0litString427_failAssert0() throws Exception {
        try {
            {
                String roleName = "testRole";
                String[] userList = new String[]{  };
                Permission permission = new Permission(">Va&1`i[aMe!@y;s?/OCDfv", CarbonConstants.UI_PERMISSION_ACTION);
                Permission[] permissions = new Permission[]{ permission };
                String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
                if (Arrays.asList(roles).contains(roleName)) {
                    IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
                }
                IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
                IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
                org.junit.Assert.fail("testAddRole_add5 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("testAddRole_add5_failAssert0litString427 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_add1null493_failAssert0() throws Exception {
        try {
            String roleName = "testRole";
            String[] userList = new String[]{  };
            Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
            Permission[] permissions = new Permission[]{ permission };
            IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            if (Arrays.asList(roles).contains(roleName)) {
                IdentityManagerClientTest_Ampl2.usm.deleteRole(roleName);
            }
            IdentityManagerClientTest_Ampl2.usm.addRole(null, userList, permissions);
            org.junit.Assert.fail("testAddRole_add1null493 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("unknown", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddRole_add1litString438null1257_failAssert0() throws Exception {
        try {
            String roleName = "testRoCle";
            String[] userList = new String[]{  };
            Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
            Permission[] permissions = new Permission[]{ permission };
            IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            String[] roles = IdentityManagerClientTest_Ampl2.usm.getRoleNames();
            if (Arrays.asList(roles).contains(roleName)) {
                IdentityManagerClientTest_Ampl2.usm.deleteRole(null);
            }
            IdentityManagerClientTest_Ampl2.usm.addRole(roleName, userList, permissions);
            org.junit.Assert.fail("testAddRole_add1litString438null1257 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("unknown", expected.getMessage());
        }
    }
}

