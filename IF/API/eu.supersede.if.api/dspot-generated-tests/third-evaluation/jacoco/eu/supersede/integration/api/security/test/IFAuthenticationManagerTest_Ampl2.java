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


public class IFAuthenticationManagerTest_Ampl2 {
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
        IFAuthenticationManagerTest_Ampl2.am = new IFAuthenticationManager(admin, password);
    }

    @Test(timeout = 30000)
    public void authenticateUserTest_add6123() throws Exception {
        User o_authenticateUserTest_add6123__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_authenticateUserTest_add6123__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_authenticateUserTest_add6123__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test firstname", ((User) (o_authenticateUserTest_add6123__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_authenticateUserTest_add6123__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_authenticateUserTest_add6123__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_authenticateUserTest_add6123__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_authenticateUserTest_add6123__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_authenticateUserTest_add6123__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_authenticateUserTest_add6123__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_authenticateUserTest_add6123__1)).getCountry());
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        isTrue(IFAuthenticationManagerTest_Ampl2.am.authenticateUser(this.testUserName, this.testUserPassword));
        Assert.assertEquals("test", ((User) (o_authenticateUserTest_add6123__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_authenticateUserTest_add6123__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test firstname", ((User) (o_authenticateUserTest_add6123__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_authenticateUserTest_add6123__1)).getLastname());
        Assert.assertEquals("User Test organization", ((User) (o_authenticateUserTest_add6123__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_authenticateUserTest_add6123__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_authenticateUserTest_add6123__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals(3556498, ((int) (((User) (o_authenticateUserTest_add6123__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_authenticateUserTest_add6123__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_authenticateUserTest_add6123__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void authenticateUserTest_add6127() throws Exception {
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        boolean o_authenticateUserTest_add6127__8 = IFAuthenticationManagerTest_Ampl2.am.authenticateUser(testUserName, testUserPassword);
        Assert.assertTrue(o_authenticateUserTest_add6127__8);
        isTrue(IFAuthenticationManagerTest_Ampl2.am.authenticateUser(this.testUserName, this.testUserPassword));
        Assert.assertTrue(o_authenticateUserTest_add6127__8);
    }

    @Test(timeout = 30000)
    public void authenticateUserTest_add6123_mg6520() throws Exception {
        User __DSPOT_o_563 = new User();
        User o_authenticateUserTest_add6123__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        isTrue(IFAuthenticationManagerTest_Ampl2.am.authenticateUser(this.testUserName, this.testUserPassword));
        boolean o_authenticateUserTest_add6123_mg6520__15 = o_authenticateUserTest_add6123__1.equals(__DSPOT_o_563);
        Assert.assertFalse(o_authenticateUserTest_add6123_mg6520__15);
    }

    @Test(timeout = 30000)
    public void authenticateUserTest_add6123_add6231() throws Exception {
        User o_authenticateUserTest_add6123__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        boolean o_authenticateUserTest_add6123_add6231__4 = ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123__1).getClaims().containsKey("http://wso2.org/claims/lastname");
        Assert.assertTrue(o_authenticateUserTest_add6123_add6231__4);
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        isTrue(IFAuthenticationManagerTest_Ampl2.am.authenticateUser(this.testUserName, this.testUserPassword));
        Assert.assertTrue(o_authenticateUserTest_add6123_add6231__4);
    }

    @Test(timeout = 30000)
    public void authenticateUserTest_add6123_mg6520_add7824() throws Exception {
        User __DSPOT_o_563 = new User();
        User o_authenticateUserTest_add6123__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        User o_authenticateUserTest_add6123_mg6520_add7824__6 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertFalse(((Collection) (((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getRoles())).isEmpty());
        Assert.assertEquals("User Test lastname", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getLastname());
        Assert.assertEquals("test", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getFirstname());
        Assert.assertEquals("User Test organization", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getIm());
        Assert.assertEquals(3556498, ((int) (((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getCountry());
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        isTrue(IFAuthenticationManagerTest_Ampl2.am.authenticateUser(this.testUserName, this.testUserPassword));
        boolean o_authenticateUserTest_add6123_mg6520__15 = o_authenticateUserTest_add6123__1.equals(__DSPOT_o_563);
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_authenticateUserTest_add6123_mg6520_add7824__6).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertFalse(((Collection) (((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getRoles())).isEmpty());
        Assert.assertEquals("User Test lastname", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getLastname());
        Assert.assertEquals("test", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getUserName());
        Assert.assertEquals("User Test firstname", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getFirstname());
        Assert.assertEquals("User Test organization", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getIm());
        Assert.assertEquals(3556498, ((int) (((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_authenticateUserTest_add6123_mg6520_add7824__6)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_add1127() throws MalformedURLException, UserStoreException {
        User o_addUserTest_add1127__1 = createTestUser();
        Assert.assertEquals("test", ((User) (o_addUserTest_add1127__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_add1127__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_add1127__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_add1127__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1127__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1127__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_add1127__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_add1127__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_add1127__1)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_add1127__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_add1127__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_add1127__1)).getCountry());
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl2.am.addUser(user, this.testUserPassword, this.requirePasswordChange);
        Assert.assertEquals("test", ((User) (o_addUserTest_add1127__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_add1127__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_add1127__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_add1127__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1127__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_add1127__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_add1127__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_add1127__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_add1127__1)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_add1127__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_add1127__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_add1127__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1134() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_130 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        boolean o_addUserTest_mg1134__12 = user.equals(__DSPOT_o_130);
        Assert.assertFalse(o_addUserTest_mg1134__12);
    }

    @Test(timeout = 30000)
    public void addUserTest_add1130_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            org.junit.Assert.fail("addUserTest_add1130 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_add1131_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            org.junit.Assert.fail("addUserTest_add1131 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Username \'test\' already exists in the system. Please pick another username.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1135_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Claim[] __DSPOT__claims_131 = new Claim[]{ new Claim() };
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            user.readClaims(__DSPOT__claims_131);
            org.junit.Assert.fail("addUserTest_mg1135 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1146_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            URL __DSPOT_url_142 = new URL("t *&f$qchO@nUXCj=]n>", "[?;&I(mnT.nK7w|,dxKc", -425731810, "5[*Td[$vMFfDqM[KPh3?");
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            user.setUrl(__DSPOT_url_142);
            org.junit.Assert.fail("addUserTest_mg1146 should have thrown MalformedURLException");
        } catch (MalformedURLException expected) {
            Assert.assertEquals("Invalid port number :-425731810", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1148_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(null);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            org.junit.Assert.fail("addUserTestnull1148 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1149_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = createTestUser();
            if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            }
            IFAuthenticationManagerTest_Ampl2.am.addUser(null, testUserPassword, requirePasswordChange);
            org.junit.Assert.fail("addUserTestnull1149 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1134_add1222() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_130 = new User();
        User o_addUserTest_mg1134_add1222__3 = createTestUser();
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1134_add1222__3)).getUserName());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1134_add1222__3)).getTelephone());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1134_add1222__3)).getLastname());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1134_add1222__3)).getMobile());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1134_add1222__3)).getRoles())).isEmpty());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1134_add1222__3)).getFirstname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1134_add1222__3)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1134_add1222__3)).getEmail());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1134_add1222__3)).getIm());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1134_add1222__3)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1134_add1222__3)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1134_add1222__3)).getCountry());
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        boolean o_addUserTest_mg1134__12 = user.equals(__DSPOT_o_130);
        Assert.assertEquals("test", ((User) (o_addUserTest_mg1134_add1222__3)).getUserName());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1134_add1222__3)).getTelephone());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_addUserTest_mg1134_add1222__3).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test lastname", ((User) (o_addUserTest_mg1134_add1222__3)).getLastname());
        Assert.assertEquals("800-555-55-55", ((User) (o_addUserTest_mg1134_add1222__3)).getMobile());
        Assert.assertFalse(((Collection) (((User) (o_addUserTest_mg1134_add1222__3)).getRoles())).isEmpty());
        Assert.assertEquals("User Test firstname", ((User) (o_addUserTest_mg1134_add1222__3)).getFirstname());
        Assert.assertEquals("User Test organization", ((User) (o_addUserTest_mg1134_add1222__3)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_addUserTest_mg1134_add1222__3)).getEmail());
        Assert.assertEquals("User Test IM", ((User) (o_addUserTest_mg1134_add1222__3)).getIm());
        Assert.assertEquals(3556498, ((int) (((User) (o_addUserTest_mg1134_add1222__3)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_addUserTest_mg1134_add1222__3)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_addUserTest_mg1134_add1222__3)).getCountry());
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1134_add1243() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_130 = new User();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        boolean o_addUserTest_mg1134_add1243__12 = user.equals(__DSPOT_o_130);
        Assert.assertFalse(o_addUserTest_mg1134_add1243__12);
        boolean o_addUserTest_mg1134__12 = user.equals(__DSPOT_o_130);
        Assert.assertFalse(o_addUserTest_mg1134_add1243__12);
    }

    @Test(timeout = 30000)
    public void addUserTest_mg1135_failAssert0_add1299_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Claim[] __DSPOT__claims_131 = new Claim[]{ new Claim() };
                User user = createTestUser();
                if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                    IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                }
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                user.readClaims(__DSPOT__claims_131);
                org.junit.Assert.fail("addUserTest_mg1135 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("addUserTest_mg1135_failAssert0_add1299 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTestnull1149_failAssert0_mg1313_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                String __DSPOT_mobile_186 = "w$*mg?5HyBm>HJn<R|%/";
                User user = createTestUser();
                if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                }
                IFAuthenticationManagerTest_Ampl2.am.addUser(null, testUserPassword, requirePasswordChange);
                org.junit.Assert.fail("addUserTestnull1149 should have thrown IllegalArgumentException");
                user.setMobile(__DSPOT_mobile_186);
            }
            org.junit.Assert.fail("addUserTestnull1149_failAssert0_mg1313 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addUserTest_add1127_add1403_add3598() throws MalformedURLException, UserStoreException {
        User o_addUserTest_add1127_add1403__1 = createTestUser();
        User o_addUserTest_add1127__1 = createTestUser();
        User user = createTestUser();
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        }
        IFAuthenticationManagerTest_Ampl2.am.addUser(user, this.testUserPassword, this.requirePasswordChange);
        boolean o_addUserTest_add1127_add1403_add3598__16 = ((eu.supersede.integration.api.security.types.User)o_addUserTest_add1127_add1403__1).getClaims().containsKey("http://wso2.org/claims/telephone");
        Assert.assertTrue(o_addUserTest_add1127_add1403_add3598__16);
    }

    @Test(timeout = 30000)
    public void addUserTest_add1131_failAssert0_add1254_failAssert0_add3139_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    User user = createTestUser();
                    if ((IFAuthenticationManagerTest_Ampl2.am.getUser(user.getUserName())) != null) {
                        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                    }
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                    org.junit.Assert.fail("addUserTest_add1131 should have thrown UserStoreException");
                }
                org.junit.Assert.fail("addUserTest_add1131_failAssert0_add1254 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addUserTest_add1131_failAssert0_add1254_failAssert0_add3139 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Username \'test\' already exists in the system. Please pick another username.", expected.getMessage());
        }
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
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        Role role = createTestRole();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        roles.add(role);
        user.setRoles(roles);
        return user;
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18223() throws MalformedURLException, UserStoreException {
        Role o_getAllUsersForRoleTest_add18223__1 = createTestRole();
        Assert.assertTrue(((Collection) (((Role) (o_getAllUsersForRoleTest_add18223__1)).getUsers())).isEmpty());
        Assert.assertEquals("testRole", ((Role) (o_getAllUsersForRoleTest_add18223__1)).getRoleName());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_getAllUsersForRoleTest_add18223__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_getAllUsersForRoleTest_add18223__1)).getPermissions())).isEmpty());
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertTrue(((Collection) (((Role) (o_getAllUsersForRoleTest_add18223__1)).getUsers())).isEmpty());
        Assert.assertEquals("testRole", ((Role) (o_getAllUsersForRoleTest_add18223__1)).getRoleName());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_getAllUsersForRoleTest_add18223__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_getAllUsersForRoleTest_add18223__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18225() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        boolean o_getAllUsersForRoleTest_add18225__6 = allRoles.contains(role);
        Assert.assertTrue(o_getAllUsersForRoleTest_add18225__6);
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertTrue(o_getAllUsersForRoleTest_add18225__6);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18227() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        User o_getAllUsersForRoleTest_add18227__11 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_getAllUsersForRoleTest_add18227__11)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_getAllUsersForRoleTest_add18227__11)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_getAllUsersForRoleTest_add18227__11)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllUsersForRoleTest_add18227__11)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add18227__11)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add18227__11)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllUsersForRoleTest_add18227__11)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_getAllUsersForRoleTest_add18227__11)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllUsersForRoleTest_add18227__11)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllUsersForRoleTest_add18227__11)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllUsersForRoleTest_add18227__11)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllUsersForRoleTest_add18227__11)).getCountry());
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        Assert.assertEquals("test", ((User) (o_getAllUsersForRoleTest_add18227__11)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_getAllUsersForRoleTest_add18227__11)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_getAllUsersForRoleTest_add18227__11)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllUsersForRoleTest_add18227__11)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add18227__11)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllUsersForRoleTest_add18227__11)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllUsersForRoleTest_add18227__11)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_getAllUsersForRoleTest_add18227__11)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllUsersForRoleTest_add18227__11)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllUsersForRoleTest_add18227__11)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllUsersForRoleTest_add18227__11)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllUsersForRoleTest_add18227__11)).getCountry());
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18227_add18616() throws MalformedURLException, UserStoreException {
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        User o_getAllUsersForRoleTest_add18227__11 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        boolean o_getAllUsersForRoleTest_add18227_add18616__26 = ((eu.supersede.integration.api.security.types.User)o_getAllUsersForRoleTest_add18227__11).getClaims().containsKey("http://wso2.org/claims/url");
        Assert.assertTrue(o_getAllUsersForRoleTest_add18227_add18616__26);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18225_mg18442() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_1493 = new Object();
        Role role = createTestRole();
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
        boolean o_getAllUsersForRoleTest_add18225__6 = allRoles.contains(role);
        if (!(allRoles.contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
            User user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
        notNull(users);
        isTrue(((users.size()) > 0));
        boolean o_getAllUsersForRoleTest_add18225_mg18442__28 = role.equals(__DSPOT_o_1493);
        Assert.assertFalse(o_getAllUsersForRoleTest_add18225_mg18442__28);
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18227_mg18890_failAssert0_mg20498_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Role __DSPOT_o_1748 = new Role();
                URL __DSPOT_url_1583 = new URL("Bb0c8kqh_2gIc)]a];:1", "2,D>u92X}#ac&qzr[,on", 1701450744, "MO/(#RU;s)C]-?(Um0a4");
                Role role = createTestRole();
                Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
                if (!(allRoles.contains(role))) {
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                }
                User o_getAllUsersForRoleTest_add18227__11 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
                if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
                    User user = createTestUser();
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
                notNull(users);
                isTrue(((users.size()) > 0));
                o_getAllUsersForRoleTest_add18227__11.setUrl(__DSPOT_url_1583);
                org.junit.Assert.fail("getAllUsersForRoleTest_add18227_mg18890 should have thrown MalformedURLException");
                role.equals(__DSPOT_o_1748);
            }
            org.junit.Assert.fail("getAllUsersForRoleTest_add18227_mg18890_failAssert0_mg20498 should have thrown MalformedURLException");
        } catch (MalformedURLException expected) {
            Assert.assertEquals("unknown protocol: bb0c8kqh_2gic)]a];:1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void getAllUsersForRoleTest_add18227_mg18890_failAssert0_mg20525_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User __DSPOT_o_1767 = new User();
                URL __DSPOT_url_1583 = new URL("Bb0c8kqh_2gIc)]a];:1", "2,D>u92X}#ac&qzr[,on", 1701450744, "MO/(#RU;s)C]-?(Um0a4");
                Role role = createTestRole();
                Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
                if (!(allRoles.contains(role))) {
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                }
                User o_getAllUsersForRoleTest_add18227__11 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
                if ((IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName)) == null) {
                    User user = createTestUser();
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                List<User> users = IFAuthenticationManagerTest_Ampl2.am.getAllUsersForRole(role);
                notNull(users);
                isTrue(((users.size()) > 0));
                o_getAllUsersForRoleTest_add18227__11.setUrl(__DSPOT_url_1583);
                org.junit.Assert.fail("getAllUsersForRoleTest_add18227_mg18890 should have thrown MalformedURLException");
                o_getAllUsersForRoleTest_add18227__11.equals(__DSPOT_o_1767);
            }
            org.junit.Assert.fail("getAllUsersForRoleTest_add18227_mg18890_failAssert0_mg20525 should have thrown MalformedURLException");
        } catch (MalformedURLException expected) {
            Assert.assertEquals("unknown protocol: bb0c8kqh_2gic)]a];:1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTest_add25007_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl2.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl2.am.updateUser(user);
            org.junit.Assert.fail("updateUserTest_add25007 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Old credential does not match with the existing credentials.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTest_remove25014_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl2.am.updateUserCredential(user, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl2.am.updateUser(user);
            org.junit.Assert.fail("updateUserTest_remove25014 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Old credential does not match with the existing credentials.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTestnull25039_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl2.am.updateUserCredential(null, ((testUserPassword) + "New"), testUserPassword);
            IFAuthenticationManagerTest_Ampl2.am.updateUser(user);
            org.junit.Assert.fail("updateUserTestnull25039 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTestnull25040_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            updateUser(user);
            IFAuthenticationManagerTest_Ampl2.am.updateUserCredential(user, null, testUserPassword);
            IFAuthenticationManagerTest_Ampl2.am.updateUser(user);
            org.junit.Assert.fail("updateUserTestnull25040 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Unsupported type of password", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void updateUserTest_remove25014_failAssert0null25273_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl2.am.updateUserCredential(user, null, testUserPassword);
                IFAuthenticationManagerTest_Ampl2.am.updateUser(user);
                org.junit.Assert.fail("updateUserTest_remove25014 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("updateUserTest_remove25014_failAssert0null25273 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Unsupported type of password", expected.getMessage());
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
        Set<Role> userRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRolesOfUser(user);
        Set<Role> allRoles = IFAuthenticationManagerTest_Ampl2.am.getAllRoles();
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
    public void deleteUserTest_add10778() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_add10778__5 = createTestUser();
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add10778__5)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add10778__5)).getRoles())).isEmpty());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add10778__5)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778__5)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778__5)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add10778__5)).getIm());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add10778__5)).getFirstname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add10778__5)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add10778__5)).getLastname());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add10778__5)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add10778__5)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add10778__5)).getCountry());
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add10778__5)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add10778__5)).getRoles())).isEmpty());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add10778__5)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778__5)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778__5)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add10778__5)).getIm());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add10778__5)).getFirstname());
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add10778__5)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add10778__5)).getLastname());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add10778__5)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add10778__5)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add10778__5)).getCountry());
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg10783() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_864 = new User();
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        boolean o_deleteUserTest_mg10783__12 = user.equals(__DSPOT_o_864);
        Assert.assertFalse(o_deleteUserTest_mg10783__12);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add10780_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            org.junit.Assert.fail("deleteUserTest_add10780 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_remove10781_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
            }
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            org.junit.Assert.fail("deleteUserTest_remove10781 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTestnull10797_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
            if (user == null) {
                user = createTestUser();
                IFAuthenticationManagerTest_Ampl2.am.addUser(null, testUserPassword, requirePasswordChange);
            }
            IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
            org.junit.Assert.fail("deleteUserTestnull10797 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add10778_add11152() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_add10778__5 = createTestUser();
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            boolean o_deleteUserTest_add10778_add11152__11 = ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778__5).getClaims().containsKey("http://wso2.org/claims/givenname");
            Assert.assertTrue(o_deleteUserTest_add10778_add11152__11);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add10778_add11125() throws MalformedURLException, UserStoreException {
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_add10778__5 = createTestUser();
            User o_deleteUserTest_add10778_add11125__8 = createTestUser();
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add10778_add11125__8)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add10778_add11125__8)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add10778_add11125__8)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add10778_add11125__8)).getLastname());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add10778_add11125__8)).getFirstname());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add10778_add11125__8)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778_add11125__8)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778_add11125__8)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add10778_add11125__8)).getIm());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add10778_add11125__8)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add10778_add11125__8)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add10778_add11125__8)).getCountry());
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            Assert.assertEquals("test", ((User) (o_deleteUserTest_add10778_add11125__8)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_add10778_add11125__8)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_add10778_add11125__8).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_add10778_add11125__8)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_add10778_add11125__8)).getLastname());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_add10778_add11125__8)).getFirstname());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_add10778_add11125__8)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778_add11125__8)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_add10778_add11125__8)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_add10778_add11125__8)).getIm());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_add10778_add11125__8)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_add10778_add11125__8)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_add10778_add11125__8)).getCountry());
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg10783_add10865() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_864 = new User();
        User o_deleteUserTest_mg10783_add10865__3 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        Assert.assertNull(o_deleteUserTest_mg10783_add10865__3);
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        boolean o_deleteUserTest_mg10783__12 = user.equals(__DSPOT_o_864);
        Assert.assertNull(o_deleteUserTest_mg10783_add10865__3);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_mg10783_add10868() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_864 = new User();
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            User o_deleteUserTest_mg10783_add10868__7 = createTestUser();
            Assert.assertEquals("test", ((User) (o_deleteUserTest_mg10783_add10868__7)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_mg10783_add10868__7)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_mg10783_add10868__7)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_mg10783_add10868__7)).getLastname());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_mg10783_add10868__7)).getFirstname());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_mg10783_add10868__7)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg10783_add10868__7)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg10783_add10868__7)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_mg10783_add10868__7)).getIm());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_mg10783_add10868__7)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_mg10783_add10868__7)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_mg10783_add10868__7)).getCountry());
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
            Assert.assertEquals("test", ((User) (o_deleteUserTest_mg10783_add10868__7)).getUserName());
            Assert.assertFalse(((Collection) (((User) (o_deleteUserTest_mg10783_add10868__7)).getRoles())).isEmpty());
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/organization"));
            Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/organization"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/telephone"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/telephone"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/im"));
            Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/im"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/country"));
            Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/country"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/mobile"));
            Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/mobile"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
            Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/emailaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/lastname"));
            Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/lastname"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
            Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/streetaddress"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/url"));
            Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/url"));
            Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().containsKey("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_deleteUserTest_mg10783_add10868__7).getClaims().get("http://wso2.org/claims/givenname"));
            Assert.assertEquals("User Test organization", ((User) (o_deleteUserTest_mg10783_add10868__7)).getOrganization());
            Assert.assertEquals("User Test lastname", ((User) (o_deleteUserTest_mg10783_add10868__7)).getLastname());
            Assert.assertEquals("User Test firstname", ((User) (o_deleteUserTest_mg10783_add10868__7)).getFirstname());
            Assert.assertEquals("user@organization.org", ((User) (o_deleteUserTest_mg10783_add10868__7)).getEmail());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg10783_add10868__7)).getTelephone());
            Assert.assertEquals("800-555-55-55", ((User) (o_deleteUserTest_mg10783_add10868__7)).getMobile());
            Assert.assertEquals("User Test IM", ((User) (o_deleteUserTest_mg10783_add10868__7)).getIm());
            Assert.assertEquals(3556498, ((int) (((User) (o_deleteUserTest_mg10783_add10868__7)).hashCode())));
            Assert.assertEquals("User Test address", ((User) (o_deleteUserTest_mg10783_add10868__7)).getAddress());
            Assert.assertEquals("User Test country", ((User) (o_deleteUserTest_mg10783_add10868__7)).getCountry());
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
        boolean o_deleteUserTest_mg10783__12 = user.equals(__DSPOT_o_864);
    }

    @Test(timeout = 30000)
    public void deleteUserTest_add10780_failAssert0_mg10950_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                String __DSPOT_firstname_936 = "=3<Y-a5%i=a*.gTyg{0y";
                User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(user);
                org.junit.Assert.fail("deleteUserTest_add10780 should have thrown UserStoreException");
                user.setFirstname(__DSPOT_firstname_936);
            }
            org.junit.Assert.fail("deleteUserTest_add10780_failAssert0_mg10950 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Cannot delete user who is not exist", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteUserTestnull10798_failAssert0_mg10902_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                String __DSPOT_email_897 = ":>Sc^kiyW4UMe[sb5(;!";
                User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
                if (user == null) {
                    user = createTestUser();
                    IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
                }
                IFAuthenticationManagerTest_Ampl2.am.deleteUser(null);
                org.junit.Assert.fail("deleteUserTestnull10798 should have thrown IllegalArgumentException");
                user.setEmail(__DSPOT_email_897);
            }
            org.junit.Assert.fail("deleteUserTestnull10798_failAssert0_mg10902 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("user shouldn\'t be null", expected.getMessage());
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
        if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
            IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        Assert.assertEquals("testRole", ((Role) (o_addRoleTest_add1__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_addRoleTest_add1__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_addRoleTest_add1__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_addRoleTest_add1__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void addRoleTest_add4_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add4 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_remove6_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
            }
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            org.junit.Assert.fail("addRoleTest_remove6 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTestnull13_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(null)) {
                IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            org.junit.Assert.fail("addRoleTestnull13 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTestnull15_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            Role role = createTestRole();
            if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            }
            IFAuthenticationManagerTest_Ampl2.am.addRole(null);
            org.junit.Assert.fail("addRoleTestnull15 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add4_failAssert0_add87_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add4 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add4_failAssert0_add87 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add4_failAssert0null131_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(null)) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add4 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add4_failAssert0null131 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add4_failAssert0null134_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(null);
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add4 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add4_failAssert0null134 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg106_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Set<User> __DSPOT_userList_22 = Collections.singleton(new User());
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                role.setUsers(__DSPOT_userList_22);
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_remove6_failAssert0null123_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(null);
                org.junit.Assert.fail("addRoleTest_remove6 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_remove6_failAssert0null123 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1_add89_mg647() throws MalformedURLException, UserStoreException {
        Object __DSPOT_o_125 = new Object();
        Role o_addRoleTest_add1_add89__1 = createTestRole();
        Role o_addRoleTest_add1__1 = createTestRole();
        Role role = createTestRole();
        if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
            IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        boolean o_addRoleTest_add1_add89_mg647__18 = role.equals(__DSPOT_o_125);
        Assert.assertFalse(o_addRoleTest_add1_add89_mg647__18);
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1_remove141_failAssert0_mg485_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Set<User> __DSPOT_userList_56 = Collections.singleton(new User());
                Role o_addRoleTest_add1__1 = createTestRole();
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                org.junit.Assert.fail("addRoleTest_add1_remove141 should have thrown UserStoreException");
                o_addRoleTest_add1__1.setUsers(__DSPOT_userList_56);
            }
            org.junit.Assert.fail("addRoleTest_add1_remove141_failAssert0_mg485 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg106_failAssert0null560_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_22 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(null)) {
                        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_22);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106_failAssert0null560 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg106_failAssert0null569_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_22 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl2.am.addRole(null);
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_22);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106_failAssert0null569 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add1null155_failAssert0_mg539_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                Set<User> __DSPOT_userList_88 = Collections.singleton(new User());
                Role o_addRoleTest_add1__1 = createTestRole();
                Role role = createTestRole();
                if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                    IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                }
                IFAuthenticationManagerTest_Ampl2.am.addRole(null);
                org.junit.Assert.fail("addRoleTest_add1null155 should have thrown IllegalArgumentException");
                role.setUsers(__DSPOT_userList_88);
            }
            org.junit.Assert.fail("addRoleTest_add1null155_failAssert0_mg539 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg106_failAssert0null565_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_22 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl2.am.deleteRole(null);
                    }
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_22);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106_failAssert0null565 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("role shouldn\'t be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void addRoleTest_add5_failAssert0_mg106_failAssert0_add441_failAssert0() throws MalformedURLException, UserStoreException {
        try {
            {
                {
                    Set<User> __DSPOT_userList_22 = Collections.singleton(new User());
                    Role role = createTestRole();
                    if (IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role)) {
                        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
                    }
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    IFAuthenticationManagerTest_Ampl2.am.addRole(role);
                    org.junit.Assert.fail("addRoleTest_add5 should have thrown UserStoreException");
                    role.setUsers(__DSPOT_userList_22);
                }
                org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106 should have thrown UserStoreException");
            }
            org.junit.Assert.fail("addRoleTest_add5_failAssert0_mg106_failAssert0_add441 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Role name: testRole in the system. Please pick another role name.", expected.getMessage());
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
    public void getAllRolesForUserTest_add15731() throws MalformedURLException, UserStoreException {
        User o_getAllRolesForUserTest_add15731__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add15731__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add15731__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add15731__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add15731__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add15731__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add15731__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add15731__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add15731__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add15731__1)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add15731__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add15731__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add15731__1)).getCountry());
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl2.am.getAllRolesOfUser(user);
        notNull(roles);
        Assert.assertEquals("test", ((User) (o_getAllRolesForUserTest_add15731__1)).getUserName());
        Assert.assertFalse(((Collection) (((User) (o_getAllRolesForUserTest_add15731__1)).getRoles())).isEmpty());
        Assert.assertEquals("User Test organization", ((User) (o_getAllRolesForUserTest_add15731__1)).getOrganization());
        Assert.assertEquals("user@organization.org", ((User) (o_getAllRolesForUserTest_add15731__1)).getEmail());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add15731__1)).getTelephone());
        Assert.assertEquals("800-555-55-55", ((User) (o_getAllRolesForUserTest_add15731__1)).getMobile());
        Assert.assertEquals("User Test IM", ((User) (o_getAllRolesForUserTest_add15731__1)).getIm());
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/organization"));
        Assert.assertEquals("User Test organization", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/organization"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/telephone"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/telephone"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/im"));
        Assert.assertEquals("User Test IM", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/im"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/country"));
        Assert.assertEquals("User Test country", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/country"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/mobile"));
        Assert.assertEquals("800-555-55-55", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/mobile"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/emailaddress"));
        Assert.assertEquals("user@organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/emailaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/streetaddress"));
        Assert.assertEquals("User Test address", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/streetaddress"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/lastname"));
        Assert.assertEquals("User Test lastname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/lastname"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/url"));
        Assert.assertEquals("http://organization.org", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/url"));
        Assert.assertTrue(((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().get("http://wso2.org/claims/givenname"));
        Assert.assertEquals("User Test firstname", ((User) (o_getAllRolesForUserTest_add15731__1)).getFirstname());
        Assert.assertEquals("User Test lastname", ((User) (o_getAllRolesForUserTest_add15731__1)).getLastname());
        Assert.assertEquals(3556498, ((int) (((User) (o_getAllRolesForUserTest_add15731__1)).hashCode())));
        Assert.assertEquals("User Test address", ((User) (o_getAllRolesForUserTest_add15731__1)).getAddress());
        Assert.assertEquals("User Test country", ((User) (o_getAllRolesForUserTest_add15731__1)).getCountry());
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_mg15740() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_1298 = new User();
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl2.am.getAllRolesOfUser(user);
        notNull(roles);
        boolean o_getAllRolesForUserTest_mg15740__15 = user.equals(__DSPOT_o_1298);
        Assert.assertFalse(o_getAllRolesForUserTest_mg15740__15);
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_add15731_add16057() throws MalformedURLException, UserStoreException {
        User o_getAllRolesForUserTest_add15731__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl2.am.getAllRolesOfUser(user);
        notNull(roles);
        boolean o_getAllRolesForUserTest_add15731_add16057__16 = ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/mobile");
        Assert.assertTrue(o_getAllRolesForUserTest_add15731_add16057__16);
    }

    @Test(timeout = 30000)
    public void getAllRolesForUserTest_add15731_add16057_mg17679() throws MalformedURLException, UserStoreException {
        User __DSPOT_o_1417 = new User();
        User o_getAllRolesForUserTest_add15731__1 = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        User user = IFAuthenticationManagerTest_Ampl2.am.getUser(testUserName);
        if (user == null) {
            user = createTestUser();
            IFAuthenticationManagerTest_Ampl2.am.addUser(user, testUserPassword, requirePasswordChange);
        }
        notNull(user);
        Set<Role> roles = IFAuthenticationManagerTest_Ampl2.am.getAllRolesOfUser(user);
        notNull(roles);
        boolean o_getAllRolesForUserTest_add15731_add16057__16 = ((eu.supersede.integration.api.security.types.User)o_getAllRolesForUserTest_add15731__1).getClaims().containsKey("http://wso2.org/claims/mobile");
        boolean o_getAllRolesForUserTest_add15731_add16057_mg17679__21 = o_getAllRolesForUserTest_add15731__1.equals(__DSPOT_o_1417);
        Assert.assertFalse(o_getAllRolesForUserTest_add15731_add16057_mg17679__21);
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add9535() throws UserStoreException {
        Role o_deleteRoleTest_add9535__1 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add9535__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add9535__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add9535__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add9535__1)).getPermissions())).isEmpty());
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add9535__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add9535__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add9535__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add9535__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_mg9542() throws UserStoreException {
        Object __DSPOT_o_689 = new Object();
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        boolean o_deleteRoleTest_mg9542__13 = role.equals(__DSPOT_o_689);
        Assert.assertFalse(o_deleteRoleTest_mg9542__13);
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add9539_failAssert0() throws UserStoreException {
        try {
            Role role = createTestRole();
            if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
                IFAuthenticationManagerTest_Ampl2.am.addRole(role);
            }
            IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            org.junit.Assert.fail("deleteRoleTest_add9539 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_remove9540_failAssert0() throws UserStoreException {
        try {
            Role role = createTestRole();
            if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
            }
            IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
            org.junit.Assert.fail("deleteRoleTest_remove9540 should have thrown UserStoreException");
        } catch (UserStoreException expected) {
            Assert.assertEquals("Can not delete non exiting role", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_add9535_add9609() throws UserStoreException {
        Role o_deleteRoleTest_add9535_add9609__1 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add9535_add9609__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add9535_add9609__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add9535_add9609__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add9535_add9609__1)).getPermissions())).isEmpty());
        Role o_deleteRoleTest_add9535__1 = createTestRole();
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_add9535_add9609__1)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_add9535_add9609__1)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_add9535_add9609__1)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_add9535_add9609__1)).getPermissions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void deleteRoleTest_mg9542_add9596() throws UserStoreException {
        Object __DSPOT_o_689 = new Object();
        Role o_deleteRoleTest_mg9542_add9596__3 = createTestRole();
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_mg9542_add9596__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).getPermissions())).isEmpty());
        Role role = createTestRole();
        if (!(IFAuthenticationManagerTest_Ampl2.am.getAllRoles().contains(role))) {
            IFAuthenticationManagerTest_Ampl2.am.addRole(role);
        }
        IFAuthenticationManagerTest_Ampl2.am.deleteRole(role);
        boolean o_deleteRoleTest_mg9542__13 = role.equals(__DSPOT_o_689);
        Assert.assertEquals("testRole", ((Role) (o_deleteRoleTest_mg9542_add9596__3)).getRoleName());
        Assert.assertTrue(((Collection) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).getUsers())).isEmpty());
        Assert.assertEquals(-1146839000, ((int) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).hashCode())));
        Assert.assertFalse(((Collection) (((Role) (o_deleteRoleTest_mg9542_add9596__3)).getPermissions())).isEmpty());
    }

    @Ignore
    @Test
    public void getAuthorizationTokenTest() throws MalformedURLException, URISyntaxException, TenantMgtAdminServiceExceptionException, UserStoreException {
        AuthorizationToken token = IFAuthenticationManagerTest_Ampl2.am.getAuthorizationToken(testUserName, testUserPassword, "atos");
        notNull(token);
        notNull(token.getAccessToken());
        isTrue((!(token.getAccessToken().isEmpty())));
    }
}

