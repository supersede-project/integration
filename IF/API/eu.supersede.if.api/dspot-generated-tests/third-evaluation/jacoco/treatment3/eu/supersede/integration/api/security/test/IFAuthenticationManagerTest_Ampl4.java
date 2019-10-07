package eu.supersede.integration.api.security.test;


import eu.supersede.integration.api.security.IFAccount;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.api.security.types.Role;
import eu.supersede.integration.api.security.types.User;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.wso2.carbon.CarbonConstants;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.Claim;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class IFAuthenticationManagerTest_Ampl4 {
    static IFAuthenticationManager am;

    String testUserName = "test";

    String testUserPassword = "testpassword";

    String tenant = "atos";

    String testRoleName = "testRole";

    boolean requirePasswordChange = false;

    @BeforeClass
    public static void setup() throws Exception {
        String admin = IFAccount.getUser();
        String password = IFAccount.getPassword();
        IFAuthenticationManagerTest_Ampl4.am = new IFAuthenticationManager(admin, password);
        try {
            User user = new User();
            user.setUserName("test");
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        } catch (Exception e) {

        }
    }

    @Test(timeout = 30000)
    public void addUserTest_add1082() throws MalformedURLException, UserStoreException {
        User o_addUserTest_add1082__1 = createTestUser();
        Assert.assertEquals("test", ((User) (o_addUserTest_add1082__1)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_add1082__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_add1082__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_add1082__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_add1082__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1082__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1082__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_add1082__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_add1082__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_add1082__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_add1082__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_add1082__1)).getCountry());
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        isTrue(isValidTestUser(user));
        Assert.assertEquals("test", ((User) (o_addUserTest_add1082__1)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_add1082__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_add1082__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_add1082__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_add1082__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1082__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1082__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_add1082__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_add1082__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1082__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_add1082__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_add1082__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_add1082__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_add1089() throws MalformedURLException, UserStoreException {
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        boolean o_addUserTest_add1089__12 = isValidTestUser(user);
        Assert.assertTrue(o_addUserTest_add1089__12);
        isTrue(isValidTestUser(user));
        Assert.assertTrue(o_addUserTest_add1089__12);
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1093() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_145 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        isTrue(isValidTestUser(user));
        boolean o_addUserTest_mg1093__16 = user.equals(__DSPOT_o_145);
        Assert.assertFalse(o_addUserTest_mg1093__16);
    }

    @Test(timeout = 30000)
    public void addUserTest_add1085_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            org.junit.Assert.fail("addUserTest_add1085 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_add1086_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            org.junit.Assert.fail("addUserTest_add1086 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Username \'test\' already exists in the system. Please pick another username.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_remove1090_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            org.junit.Assert.fail("addUserTest_remove1090 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Username \'test\' already exists in the system. Please pick another username.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_remove1091_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            org.junit.Assert.fail("addUserTest_remove1091 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1094_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Claim[] __DSPOT__claims_146 = new Claim[]{ new Claim(), new Claim(), new Claim() };
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            user.readClaims(__DSPOT__claims_146);
            org.junit.Assert.fail("addUserTest_mg1094 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1105_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            URL __DSPOT_url_157 = new URL(new URL(new URL("O&`]e7o[Kiw/qa6pE0]A"), "]Ci2@sxS($<9$T4bXzes"), "i<&g-WNb,LXZU? pnD>X");
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            user.setUrl(__DSPOT_url_157);
            org.junit.Assert.fail("addUserTest_mg1105 should have thrown MalformedURLException");
        } catch (MalformedURLException expected) {
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1108_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(null, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(user));
            org.junit.Assert.fail("addUserTestnull1108 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1109_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            isTrue(isValidTestUser(null));
            org.junit.Assert.fail("addUserTestnull1109 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1093_add1218() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_145 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        User o_addUserTest_mg1093_add1218__12 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1093_add1218__12)).getUserName());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1093_add1218__12)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1093_add1218__12)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1093_add1218__12)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1093_add1218__12)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218__12)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218__12)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1093_add1218__12)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1093_add1218__12)).getRoles())).isEmpty());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1093_add1218__12)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1093_add1218__12)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1093_add1218__12)).getCountry());
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        isTrue(isValidTestUser(user));
        boolean o_addUserTest_mg1093__16 = user.equals(__DSPOT_o_145);
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1093_add1218__12)).getUserName());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1093_add1218__12)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1093_add1218__12)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1093_add1218__12)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1093_add1218__12)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218__12)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218__12)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1093_add1218__12)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1093_add1218__12)).getRoles())).isEmpty());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1093_add1218__12)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1093_add1218__12)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1093_add1218__12)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_add1086_failAssert0null1457_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User user = createTestUser();
                if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                    IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                }
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                isTrue(isValidTestUser(null));
                org.junit.Assert.fail("addUserTest_add1086 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addUserTest_add1086_failAssert0null1457 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Username \'test\' already exists in the system. Please pick another username.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1109_failAssert0_add1215_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User user = createTestUser();
                user.getUserName();
                if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                    IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                }
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                isTrue(isValidTestUser(null));
                org.junit.Assert.fail("addUserTestnull1109 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("addUserTestnull1109_failAssert0_add1215 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1108_failAssert0null1551_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User user = createTestUser();
                if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
                    IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                }
                IFAuthenticationManagerTest_Ampl4.am.addUser(null, testUserPassword, requirePasswordChange);
                user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                isTrue(isValidTestUser(null));
                org.junit.Assert.fail("addUserTestnull1108 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("addUserTestnull1108_failAssert0null1551 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1093_add1218_add3586() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_145 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        User o_addUserTest_mg1093_add1218_add3586__12 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getUserName());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getOrganization());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getMobile());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getLastname());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getTelephone());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1093_add1218_add3586__12)).getRoles())).isEmpty());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1093_add1218_add3586__12)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getCountry());
        User o_addUserTest_mg1093_add1218__12 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        isTrue(isValidTestUser(user));
        boolean o_addUserTest_mg1093__16 = user.equals(__DSPOT_o_145);
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getUserName());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getOrganization());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218_add3586__12).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getMobile());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getLastname());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getTelephone());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1093_add1218_add3586__12)).getRoles())).isEmpty());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1093_add1218_add3586__12)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1093_add1218_add3586__12)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1093_add1218_add3614() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_145 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        User o_addUserTest_mg1093_add1218__12 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        boolean o_addUserTest_mg1093_add1218_add3614__15 = ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1093_add1218__12).getClaims().containsKey("http://wso2.org/claims/organization");
        Assert.assertTrue(o_addUserTest_mg1093_add1218_add3614__15);
        user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        isTrue(isValidTestUser(user));
        boolean o_addUserTest_mg1093__16 = user.equals(__DSPOT_o_145);
        Assert.assertTrue(o_addUserTest_mg1093_add1218_add3614__15);
    }

    @Ignore
    @Test
    public void throwUserExistWhenAddUserTest() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        try {
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        }
    }

    private User createTestUser() throws UserStoreException {
        return createTestUser(testUserName);
    }

    private User createTestUser(String userName) throws UserStoreException {
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
            notNull(user.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Set<Role> roles = new HashSet<Role>();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        Role role = createTestRole();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        roles.add(role);
        user.setRoles(roles);
        return user;
    }

    private boolean isValidTestUser(User user) {
        if (user == null) {
            return false;
        }
        if (!(user.getFirstname().equals("User Test firstname"))) {
            return false;
        }
        if (!(user.getLastname().equals("User Test lastname"))) {
            return false;
        }
        if (!(user.getOrganization().equals("User Test organization"))) {
            return false;
        }
        if (!(user.getAddress().equals("User Test address"))) {
            return false;
        }
        if (!(user.getCountry().equals("User Test country"))) {
            return false;
        }
        if (!(user.getEmail().equals("user@organization.org"))) {
            return false;
        }
        if (!(user.getTelephone().equals("800-555-55-55"))) {
            return false;
        }
        if (!(user.getMobile().equals("800-555-55-55"))) {
            return false;
        }
        if (!(user.getIm().equals("User Test IM"))) {
            return false;
        }
        return true;
    }

    @Test(timeout = 30000)
    public void getUserTest_add17187_add17549() throws MalformedURLException, UserStoreException {
        User o_getUserTest_add17187__1 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        boolean o_getUserTest_add17187_add17549__4 = ((eu.supersede.integration.api.security.types.User)o_getUserTest_add17187__1).getClaims().containsKey("http://wso2.org/claims/organization");
        Assert.assertTrue(o_getUserTest_add17187_add17549__4);
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        notNull(user);
        Assert.assertTrue(o_getUserTest_add17187_add17549__4);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add13281() throws MalformedURLException, UserStoreException {
        Role o_getAllUsersForRoleTest_add13281__1 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_getAllUsersForRoleTest_add13281__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_getAllUsersForRoleTest_add13281__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_getAllUsersForRoleTest_add13281__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_getAllUsersForRoleTest_add13281__1)).getPermissions())).isEmpty());
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertEquals("testRole", ((Role) (o_getAllUsersForRoleTest_add13281__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_getAllUsersForRoleTest_add13281__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_getAllUsersForRoleTest_add13281__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_getAllUsersForRoleTest_add13281__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add13283() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        boolean o_getAllUsersForRoleTest_add13283__6 = allRoles.contains(role);
        Assert.assertTrue(o_getAllUsersForRoleTest_add13283__6);
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertTrue(o_getAllUsersForRoleTest_add13283__6);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add13285() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        User o_getAllUsersForRoleTest_add13285__11 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_getAllUsersForRoleTest_add13285__11)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllUsersForRoleTest_add13285__11)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllUsersForRoleTest_add13285__11)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllUsersForRoleTest_add13285__11)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllUsersForRoleTest_add13285__11)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add13285__11)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add13285__11)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllUsersForRoleTest_add13285__11)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllUsersForRoleTest_add13285__11)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllUsersForRoleTest_add13285__11)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllUsersForRoleTest_add13285__11)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllUsersForRoleTest_add13285__11)).getCountry());
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertEquals("test", ((User) (o_getAllUsersForRoleTest_add13285__11)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllUsersForRoleTest_add13285__11)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllUsersForRoleTest_add13285__11)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllUsersForRoleTest_add13285__11)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllUsersForRoleTest_add13285__11)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add13285__11)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add13285__11)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllUsersForRoleTest_add13285__11)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllUsersForRoleTest_add13285__11)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllUsersForRoleTest_add13285__11)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllUsersForRoleTest_add13285__11)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllUsersForRoleTest_add13285__11)).getCountry());
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTestnull13322_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
            if (!(allRoles.contains(role))) {
                IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            }
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
                User user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(null);
            notNull(users);
            isTrue(((users.size()) > 0));
            org.junit.Assert.fail("getAllUsersForRoleTestnull13322 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTestnull13323_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
            if (!(allRoles.contains(role))) {
                IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            }
            if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
                User user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
            notNull(null);
            isTrue(((users.size()) > 0));
            org.junit.Assert.fail("getAllUsersForRoleTestnull13323 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add13285_add13715() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        User o_getAllUsersForRoleTest_add13285__11 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        boolean o_getAllUsersForRoleTest_add13285_add13715__26 = ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add13285__11).getClaims().containsKey("http://wso2.org/claims/url");
        Assert.assertTrue(o_getAllUsersForRoleTest_add13285_add13715__26);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add13285_mg13970() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_1558 = new Object();
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        User o_getAllUsersForRoleTest_add13285__11 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if ((IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl4.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        boolean o_getAllUsersForRoleTest_add13285_mg13970__28 = role.equals(__DSPOT_o_1558);
        Assert.assertFalse(o_getAllUsersForRoleTest_add13285_mg13970__28);
    }

    @Test(timeout = 30000)
    public void updateUserTest_add19184() throws MalformedURLException, UserStoreException {
        User o_updateUserTest_add19184__1 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_updateUserTest_add19184__1)).getUserName());
        Assert.assertEquals("User Test firstname modified", ((User) (o_updateUserTest_add19184__1)).getFirstname());
        Assert.assertEquals("User Test lastname modified", ((User) (o_updateUserTest_add19184__1)).getLastname());
        Assert.assertEquals("User Test organization modified", ((User) (o_updateUserTest_add19184__1)).getOrganization());
        Assert.assertEquals("user@organization_mod.org", ((User) (o_updateUserTest_add19184__1)).getEmail());
        Assert.assertEquals("800-555-55-66", ((User) (o_updateUserTest_add19184__1)).getTelephone());
        Assert.assertEquals("800-555-55-77", ((User) (o_updateUserTest_add19184__1)).getMobile());
        Assert.assertEquals("User Test IM modified", ((User) (o_updateUserTest_add19184__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_updateUserTest_add19184__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-66", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-77", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization_mod.org", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization_mod.org", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_updateUserTest_add19184__1)).hashCode())));
        Assert.assertEquals("User Test address modified", ((User) (o_updateUserTest_add19184__1)).getAddress());
        Assert.assertEquals("User Test country modified", ((User) (o_updateUserTest_add19184__1)).getCountry());
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        updateUser(user);
        IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
        IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
        Assert.assertEquals("test", ((User) (o_updateUserTest_add19184__1)).getUserName());
        Assert.assertEquals("User Test firstname modified", ((User) (o_updateUserTest_add19184__1)).getFirstname());
        Assert.assertEquals("User Test lastname modified", ((User) (o_updateUserTest_add19184__1)).getLastname());
        Assert.assertEquals("User Test organization modified", ((User) (o_updateUserTest_add19184__1)).getOrganization());
        Assert.assertEquals("user@organization_mod.org", ((User) (o_updateUserTest_add19184__1)).getEmail());
        Assert.assertEquals("800-555-55-66", ((User) (o_updateUserTest_add19184__1)).getTelephone());
        Assert.assertEquals("800-555-55-77", ((User) (o_updateUserTest_add19184__1)).getMobile());
        Assert.assertEquals("User Test IM modified", ((User) (o_updateUserTest_add19184__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_updateUserTest_add19184__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-66", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-77", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization_mod.org", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization_mod.org", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname modified", ((eu.supersede.integration.api.security.types.User)o_updateUserTest_add19184__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_updateUserTest_add19184__1)).hashCode())));
        Assert.assertEquals("User Test address modified", ((User) (o_updateUserTest_add19184__1)).getAddress());
        Assert.assertEquals("User Test country modified", ((User) (o_updateUserTest_add19184__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void updateUserTest_mg19200() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_1976 = new Object();
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        updateUser(user);
        IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
        IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
        boolean o_updateUserTest_mg19200__15 = user.equals(__DSPOT_o_1976);
        Assert.assertFalse(o_updateUserTest_mg19200__15);
    }

    @Test(timeout = 30000)
    public void updateUserTest_mg19201_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Claim[] __DSPOT__claims_1977 = new Claim[]{ new Claim() };
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
            user.readClaims(__DSPOT__claims_1977);
            org.junit.Assert.fail("updateUserTest_mg19201 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTestnull19216_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(null, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
            org.junit.Assert.fail("updateUserTestnull19216 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTestnull19217_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, null, testUserPassword);
            IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
            org.junit.Assert.fail("updateUserTestnull19217 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Unsupported type of password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTestnull19218_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl4.am.updateUser(null);
            org.junit.Assert.fail("updateUserTestnull19218 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTest_mg19212_failAssert0_mg19525_literalMutationString21174_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User __DSPOT_o_2074 = new User();
                URL __DSPOT_url_1988 = new URL("|k`_d=^0NDJy{L%b@Xp2");
                User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                updateUser(user);
                IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "http://wso2.org/claims/organization"), testUserPassword);
                IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
                user.setUrl(__DSPOT_url_1988);
                org.junit.Assert.fail("updateUserTest_mg19212 should have thrown MalformedURLException");
                user.equals(__DSPOT_o_2074);
            }
            org.junit.Assert.fail("updateUserTest_mg19212_failAssert0_mg19525_literalMutationString21174 should have thrown MalformedURLException");
        } catch (MalformedURLException expected) {
            Assert.assertEquals("no protocol: |k`_d=^0NDJy{L%b@Xp2", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTest_add19184litString19947_mg22474_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Claim[] __DSPOT__claims_2271 = new Claim[]{ new Claim(), new Claim() };
            User o_updateUserTest_add19184__1 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl4.am.updateUser(user);
            user.readClaims(__DSPOT__claims_2271);
            org.junit.Assert.fail("updateUserTest_add19184litString19947_mg22474 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
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
        Set<Role> userRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl4.am.getAllRoles();
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

    @Test(timeout = 30000)
    public void deleteUserTest_add6672() throws MalformedURLException, UserStoreException {
        User o_deleteUserTest_add6672__1 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertNull(o_deleteUserTest_add6672__1);
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        Assert.assertNull(o_deleteUserTest_add6672__1);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add6673() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_add6673__5 = createTestUser();
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add6673__5)).getUserName());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add6673__5)).getFirstname());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add6673__5)).getLastname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add6673__5)).getOrganization());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add6673__5)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add6673__5)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add6673__5)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add6673__5)).getIm());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add6673__5)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add6673__5)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add6673__5)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add6673__5)).getCountry());
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add6673__5)).getUserName());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add6673__5)).getFirstname());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add6673__5)).getLastname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add6673__5)).getOrganization());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add6673__5)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add6673__5)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add6673__5)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add6673__5)).getIm());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add6673__5)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add6673__5).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add6673__5)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add6673__5)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add6673__5)).getCountry());
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg6678() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_824 = new User();
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        boolean o_deleteUserTest_mg6678__12 = user.equals(__DSPOT_o_824);
        Assert.assertFalse(o_deleteUserTest_mg6678__12);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add6675_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            org.junit.Assert.fail("deleteUserTest_add6675 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg6679_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Claim[] __DSPOT__claims_825 = new Claim[]{ new Claim(), new Claim(), new Claim(), new Claim() };
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
            user.readClaims(__DSPOT__claims_825);
            org.junit.Assert.fail("deleteUserTest_mg6679 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTestnull6693_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(null);
            org.junit.Assert.fail("deleteUserTestnull6693 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg6678_add6776() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_824 = new User();
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_mg6678_add6776__7 = createTestUser();
            Assert.assertEquals("test", ((User) (o_deleteUserTest_mg6678_add6776__7)).getUserName());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_mg6678_add6776__7)).getFirstname());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_mg6678_add6776__7)).getLastname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_mg6678_add6776__7)).getOrganization());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_mg6678_add6776__7)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg6678_add6776__7)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg6678_add6776__7)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_mg6678_add6776__7)).getIm());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_mg6678_add6776__7)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_mg6678_add6776__7)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_mg6678_add6776__7)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_mg6678_add6776__7)).getCountry());
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            Assert.assertEquals("test", ((User) (o_deleteUserTest_mg6678_add6776__7)).getUserName());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_mg6678_add6776__7)).getFirstname());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_mg6678_add6776__7)).getLastname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_mg6678_add6776__7)).getOrganization());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_mg6678_add6776__7)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg6678_add6776__7)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg6678_add6776__7)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_mg6678_add6776__7)).getIm());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_mg6678_add6776__7)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg6678_add6776__7).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_mg6678_add6776__7)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_mg6678_add6776__7)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_mg6678_add6776__7)).getCountry());
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        boolean o_deleteUserTest_mg6678__12 = user.equals(__DSPOT_o_824);
    }

    @Test(timeout = 30000)
    public void deleteUserTestnull6693_failAssert0_mg6840_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                String __DSPOT_organization_876 = ";}WQfvL=c4&yLKu 2Ewo";
                User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(null);
                org.junit.Assert.fail("deleteUserTestnull6693 should have thrown IllegalArgumentException");
                user.setOrganization(__DSPOT_organization_876);
            }
            org.junit.Assert.fail("deleteUserTestnull6693_failAssert0_mg6840 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg6679_failAssert0_mg6794_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                String __DSPOT_email_846 = "d&mJTP[,bV;,qv[w0`1@";
                Claim[] __DSPOT__claims_825 = new Claim[]{ new Claim(), new Claim(), new Claim(), new Claim() };
                User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                user.readClaims(__DSPOT__claims_825);
                org.junit.Assert.fail("deleteUserTest_mg6679 should have thrown NullPointerException");
                user.setEmail(__DSPOT_email_846);
            }
            org.junit.Assert.fail("deleteUserTest_mg6679_failAssert0_mg6794 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add6675_failAssert0_mg6777_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User __DSPOT_o_839 = new User();
                User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                org.junit.Assert.fail("deleteUserTest_add6675 should have thrown UserStoreException");
                user.equals(__DSPOT_o_839);
            }
            org.junit.Assert.fail("deleteUserTest_add6675_failAssert0_mg6777 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg6678_mg6854_failAssert0_mg8850_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Set<Role> __DSPOT_roles_1133 = Collections.singleton(new Role());
                User __DSPOT_o_887 = new User();
                User __DSPOT_o_824 = new User();
                User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
                boolean o_deleteUserTest_mg6678__12 = user.equals(__DSPOT_o_824);
                __DSPOT_o_824.equals(__DSPOT_o_887);
                org.junit.Assert.fail("deleteUserTest_mg6678_mg6854 should have thrown NullPointerException");
                __DSPOT_o_824.setRoles(__DSPOT_roles_1133);
            }
            org.junit.Assert.fail("deleteUserTest_mg6678_mg6854_failAssert0_mg8850 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(expected = UserStoreException.class)
    public void throwUserDoesNotExistWhenDeleteUserTest() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser("userdoesnotexist");
            IFAuthenticationManagerTest_Ampl4.am.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1() throws MalformedURLException, UserStoreException {
        Role o_addRoleTest_add1__1 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_addRoleTest_add1__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_addRoleTest_add1__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_addRoleTest_add1__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_addRoleTest_add1__1)).getPermissions())).isEmpty());
        Role role = createTestRole();
        if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        Assert.assertEquals("testRole", ((Role) (o_addRoleTest_add1__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_addRoleTest_add1__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_addRoleTest_add1__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_addRoleTest_add1__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void addRoleTest_add4_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add4 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_remove6_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_remove6 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTestnull13_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(null)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTestnull13 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTestnull15_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(null);
            org.junit.Assert.fail("addRoleTestnull15 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1_add123_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role o_addRoleTest_add1__1 = createTestRole();
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add1_add123 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1null153_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role o_addRoleTest_add1__1 = createTestRole();
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(null)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add1null153 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1null154_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role o_addRoleTest_add1__1 = createTestRole();
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(null);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add1null154 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1null155_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role o_addRoleTest_add1__1 = createTestRole();
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.addRole(null);
            org.junit.Assert.fail("addRoleTest_add1null155 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg116_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Set<User> __DSPOT_userList_27 = Collections.singleton(new User());
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                    IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
                }
                IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                role.setUsers(__DSPOT_userList_27);
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1_add115_mg595() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_118 = new Object();
        Role o_addRoleTest_add1__1 = createTestRole();
        Role o_addRoleTest_add1_add115__4 = createTestRole();
        Role role = createTestRole();
        if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        boolean o_addRoleTest_add1_add115_mg595__18 = o_addRoleTest_add1__1.equals(__DSPOT_o_118);
        Assert.assertFalse(o_addRoleTest_add1_add115_mg595__18);
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1_add89_mg619() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_138 = new Object();
        Role o_addRoleTest_add1_add89__1 = createTestRole();
        Role o_addRoleTest_add1__1 = createTestRole();
        Role role = createTestRole();
        if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        boolean o_addRoleTest_add1_add89_mg619__18 = role.equals(__DSPOT_o_138);
        Assert.assertFalse(o_addRoleTest_add1_add89_mg619__18);
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg116_failAssert0null568_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_27 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl4.am.addRole(null);
                    IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_27);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116_failAssert0null568 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg116_failAssert0null566_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_27 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl4.am.deleteRole(null);
                    }
                    IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_27);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116_failAssert0null566 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg116_failAssert0_add442_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_27 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
                        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_27);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg116_failAssert0_add442 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    private Role createTestRole() {
        Role role = new Role();
        role.setRoleName(testRoleName);
        Permission permission = new Permission("/permission/admin/login", CarbonConstants.UI_PERMISSION_ACTION);
        Permission[] permissions = new Permission[]{ permission };
        role.setPermissions(permissions);
        return role;
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_mg10665() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_1257 = new User();
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        notNull(roles);
        boolean o_getAllRolesForUserTest_mg10665__15 = user.equals(__DSPOT_o_1257);
        Assert.assertFalse(o_getAllRolesForUserTest_mg10665__15);
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTestnull10682_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            notNull(user);
            Set<Role> roles = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
            notNull(null);
            org.junit.Assert.fail("getAllRolesForUserTestnull10682 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_add10660_add10758() throws MalformedURLException, UserStoreException {
        User o_getAllRolesForUserTest_add10660_add10758__1 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add10660_add10758__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getCountry());
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> o_getAllRolesForUserTest_add10660__10 = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        notNull(roles);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_add10758__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add10660_add10758__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add10660_add10758__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_add10660_mg10800_add11438() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_1271 = new User();
        User o_getAllRolesForUserTest_add10660_mg10800_add11438__3 = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getCountry());
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> o_getAllRolesForUserTest_add10660__10 = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl4.am.getAllRolesOfUser(user);
        notNull(roles);
        boolean o_getAllRolesForUserTest_add10660_mg10800__18 = user.equals(__DSPOT_o_1271);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getIm());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getRoles())).isEmpty());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add10660_mg10800_add11438__3).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add10660_mg10800_add11438__3)).getCountry());
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add5470() throws UserStoreException {
        Role o_deleteRoleTest_add5470__1 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add5470__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add5470__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add5470__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add5470__1)).getPermissions())).isEmpty());
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add5470__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add5470__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add5470__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add5470__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_mg5477() throws UserStoreException {
        Object __DSPOT_o_661 = new Object();
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        boolean o_deleteRoleTest_mg5477__13 = role.equals(__DSPOT_o_661);
        Assert.assertFalse(o_deleteRoleTest_mg5477__13);
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add5474_failAssert0() throws UserStoreException {
        try {
            Role role = createTestRole();
            if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
                IFAuthenticationManagerTest_Ampl4.am.addRole(role);
            }
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            org.junit.Assert.fail("deleteRoleTest_add5474 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_remove5475_failAssert0() throws UserStoreException {
        try {
            Role role = createTestRole();
            if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            }
            IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
            org.junit.Assert.fail("deleteRoleTest_remove5475 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_mg5477_add5528() throws UserStoreException {
        Object __DSPOT_o_661 = new Object();
        Role o_deleteRoleTest_mg5477_add5528__3 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_mg5477_add5528__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).getPermissions())).isEmpty());
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        boolean o_deleteRoleTest_mg5477__13 = role.equals(__DSPOT_o_661);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_mg5477_add5528__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_mg5477_add5528__3)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_mg5477_add5532() throws UserStoreException {
        Object __DSPOT_o_661 = new Object();
        Role role = createTestRole();
        boolean o_deleteRoleTest_mg5477_add5532__5 = IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role);
        Assert.assertFalse(o_deleteRoleTest_mg5477_add5532__5);
        if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        boolean o_deleteRoleTest_mg5477__13 = role.equals(__DSPOT_o_661);
        Assert.assertFalse(o_deleteRoleTest_mg5477_add5532__5);
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add5470_mg5613_add5901() throws UserStoreException {
        Role __DSPOT_o_691 = new Role();
        Role o_deleteRoleTest_add5470_mg5613_add5901__3 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getPermissions())).isEmpty());
        Role o_deleteRoleTest_add5470__1 = createTestRole();
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl4.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl4.am.deleteRole(role);
        boolean o_deleteRoleTest_add5470_mg5613__16 = o_deleteRoleTest_add5470__1.equals(__DSPOT_o_691);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add5470_mg5613_add5901__3)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void deleteRoleTestnull5484_failAssert0_mg5580_failAssert0_add5936_failAssert0() throws UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_678 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (!(IFAuthenticationManagerTest_Ampl4.am.getAllRoles().contains(role))) {
                        IFAuthenticationManagerTest_Ampl4.am.addRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl4.am.deleteRole(null);
                    org.junit.Assert.fail("deleteRoleTestnull5484 should have thrown IllegalArgumentException");
                    role.setUsers(__DSPOT_userList_678);
                    role.setUsers(__DSPOT_userList_678);
                }
                org.junit.Assert.fail("deleteRoleTestnull5484_failAssert0_mg5580 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("deleteRoleTestnull5484_failAssert0_mg5580_failAssert0_add5936 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void getAuthorizationTokenTest() throws MalformedURLException, URISyntaxException, TenantMgtAdminServiceExceptionException, UserStoreException {
        AuthorizationToken token = IFAuthenticationManagerTest_Ampl4.am.getAuthorizationToken(testUserName, testUserPassword, "atos");
        notNull(token);
        notNull(token.getAccessToken());
        isTrue((!(token.getAccessToken().isEmpty())));
    }

    @Ignore
    @Test
    public void testUpdateUserCredential() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl4.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl4.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        IFAuthenticationManagerTest_Ampl4.am.updateUserCredential(user, "newCredential", "oldCredential");
    }
}

