package eu.supersede.integration.api.feedback.proxies.test;


import eu.supersede.integration.api.feedback.orchestrator.types.ApiUser;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserRole;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.MechanismType;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.TriggerType;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notEmpty;
import static org.springframework.util.Assert.notNull;


public class FeedbackOrchestratorProxyTest {
    private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);

    private static FeedbackOrchestratorProxy<?, ?> proxy;

    private static long idApplicationBackup;

    private static long idApplication = 8;

    private static long idApplication_loaded;

    private static long idConfiguration = 9;

    private static long idGeneralConfiguration = 8;

    private static long idMechanism = 5;

    private static long idParameter = 47;

    private static long idUser = 1;

    private static long idUserGroup = 1;

    @BeforeClass
    public static void setup() throws Exception {
        String user = "superadmin";
        String password = "password";
        FeedbackOrchestratorProxyTest.proxy = new FeedbackOrchestratorProxy<Object, Object>(user, password);
        Application app = FeedbackOrchestratorProxyTest.createApplication();
        Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(app);
        FeedbackOrchestratorProxyTest.idApplication = result.getId();
        FeedbackOrchestratorProxyTest.idApplication_loaded = FeedbackOrchestratorProxyTest.idApplication;
        FeedbackOrchestratorProxyTest.idApplicationBackup = FeedbackOrchestratorProxyTest.idApplication;
        FeedbackOrchestratorProxyTest.idGeneralConfiguration = result.getGeneralConfiguration().getId();
        FeedbackOrchestratorProxyTest.idConfiguration = result.getConfigurations().get(0).getId();
        FeedbackOrchestratorProxyTest.idParameter = result.getGeneralConfiguration().getParameters().get(0).getId();
        FeedbackOrchestratorProxyTest.log.info((((((((("Testing FeedbackOrchestratorProxy with these artifacts: (applicationId: " + (FeedbackOrchestratorProxyTest.idApplication)) + ", generalConfigurationId: ") + (FeedbackOrchestratorProxyTest.idGeneralConfiguration)) + ", configurationId: ") + (FeedbackOrchestratorProxyTest.idConfiguration)) + ", parameterId: ") + (FeedbackOrchestratorProxyTest.idParameter)) + ")"));
    }

    @org.junit.AfterClass
    public static void dispose() throws Exception {
        FeedbackOrchestratorProxyTest.proxy.deleteApplication(FeedbackOrchestratorProxyTest.idApplicationBackup);
        FeedbackOrchestratorProxyTest.log.info(("Disposing created application: " + (FeedbackOrchestratorProxyTest.idApplicationBackup)));
    }

    @Test(timeout = 30000)
    public void testAuthenticate_add1024() throws Exception {
        String user = "superadmin";
        Assert.assertEquals("superadmin", user);
        String password = "password";
        Assert.assertEquals("password", password);
        FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
        String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
        notNull(token);
        Assert.assertEquals("superadmin", user);
        Assert.assertEquals("password", password);
    }

    @Test(timeout = 30000)
    public void testAuthenticate_literalMutationString1027_failAssert0() throws Exception {
        try {
            String user = "speradmin";
            String password = "password";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            notNull(token);
            org.junit.Assert.fail("testAuthenticate_literalMutationString1027 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAuthenticate_literalMutationString1033_failAssert0() throws Exception {
        try {
            String user = "superadmin";
            String password = "";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            notNull(token);
            org.junit.Assert.fail("testAuthenticate_literalMutationString1033 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAuthenticatenull1072_failAssert0() throws Exception {
        try {
            String user = "superadmin";
            String password = null;
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            notNull(token);
            org.junit.Assert.fail("testAuthenticatenull1072 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAuthenticate_add1024null1388_failAssert0() throws Exception {
        try {
            String user = "superadmin";
            String password = "password";
            FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, null);
            notNull(token);
            org.junit.Assert.fail("testAuthenticate_add1024null1388 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAPIUsersnull3818_failAssert0() throws Exception {
        try {
            List<ApiUser> result = FeedbackOrchestratorProxyTest.proxy.getApiUsers();
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetAPIUsersnull3818 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAPIUser_add3686() throws Exception {
        ApiUser o_testGetAPIUser_add3686__1 = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
        Assert.assertEquals("admin", ((ApiUser) (o_testGetAPIUser_add3686__1)).getUsername());
        Assert.assertTrue(((Collection) (((ApiUser) (o_testGetAPIUser_add3686__1)).getApiUserPermissions())).isEmpty());
        Assert.assertFalse(((ApiUser) (o_testGetAPIUser_add3686__1)).getAuthorities().isEmpty());
        Assert.assertNull(((ApiUser) (o_testGetAPIUser_add3686__1)).getPassword());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isAccountNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isAccountNonLocked());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isCredentialsNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isEnabled());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getAccountNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getAccountNonLocked());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getCredentialsNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getEnabled());
        Assert.assertFalse(((Collection) (((ApiUser) (o_testGetAPIUser_add3686__1)).getApiUserApiUserRoles())).isEmpty());
        Assert.assertEquals("admin", ((ApiUser) (o_testGetAPIUser_add3686__1)).getName());
        Assert.assertEquals(1L, ((long) (((ApiUser) (o_testGetAPIUser_add3686__1)).getId())));
        ApiUser result = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
        notNull(result);
        Assert.assertEquals("admin", ((ApiUser) (o_testGetAPIUser_add3686__1)).getUsername());
        Assert.assertTrue(((Collection) (((ApiUser) (o_testGetAPIUser_add3686__1)).getApiUserPermissions())).isEmpty());
        Assert.assertFalse(((ApiUser) (o_testGetAPIUser_add3686__1)).getAuthorities().isEmpty());
        Assert.assertNull(((ApiUser) (o_testGetAPIUser_add3686__1)).getPassword());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isAccountNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isAccountNonLocked());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isCredentialsNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).isEnabled());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getAccountNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getAccountNonLocked());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getCredentialsNonExpired());
        Assert.assertTrue(((ApiUser) (o_testGetAPIUser_add3686__1)).getEnabled());
        Assert.assertFalse(((Collection) (((ApiUser) (o_testGetAPIUser_add3686__1)).getApiUserApiUserRoles())).isEmpty());
        Assert.assertEquals("admin", ((ApiUser) (o_testGetAPIUser_add3686__1)).getName());
        Assert.assertEquals(1L, ((long) (((ApiUser) (o_testGetAPIUser_add3686__1)).getId())));
    }

    @Test(timeout = 30000)
    public void testGetAPIUsernull3700_failAssert0() throws Exception {
        try {
            ApiUser result = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
            notNull(null);
            org.junit.Assert.fail("testGetAPIUsernull3700 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteAPIUser() throws Exception {
        ApiUser user = createApiUser();
        ApiUser result = FeedbackOrchestratorProxyTest.proxy.createApiUser(user);
        notNull(result);
        isTrue(((result.getId()) > 0));
        result.setUsername(((result.getUsername()) + "Modified"));
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateApiUser(result);
        isTrue(result.getUsername().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteApiUser(result.getId());
    }

    @Ignore
    @Test
    public void testGetAPIUserPermissions() throws Exception {
        List<ApiUserPermission> result = FeedbackOrchestratorProxyTest.proxy.getApiUserPermissions(FeedbackOrchestratorProxyTest.idUser);
        notNull(result);
        isTrue((!(result.isEmpty())));
    }

    @Test
    @Ignore
    public void testCreateUpdateDeleteAPIUserPermission() throws Exception {
        ApiUser user = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
        ApiUserPermission permission = createApiUserPermission(user);
        ApiUserPermission result = FeedbackOrchestratorProxyTest.proxy.createApiUserPermission(permission, user.getId());
        notNull(result);
        isTrue(((result.getId()) > 0));


    }

    @Test(timeout = 30000)
    public void testGetApplicationsnull5224_failAssert0() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.getApplications();
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetApplicationsnull5224 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationWithConfigurationForAllLanguagesnull4510_failAssert0() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfigurationForAllLanguages(FeedbackOrchestratorProxyTest.idApplication);
            notNull(null);
            org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguagesnull4510 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationWithConfigurationForAllLanguages_mg4507_failAssert0_mg4588_failAssert0() throws Exception {
        try {
            {
                List<ApiUserPermission> __DSPOT_apiUserPermissions_428 = Collections.singletonList(new ApiUserPermission(new ApiUser("a }I7L(!sU15Fy:[|>C!", "X ){G5r3ED?cE[`ODn0d"), new Application("hOrxeAfbPn&/p*Qi2z]<", -1603450164, new Date(1222820437L), new Date("P1e!mFE>P^K)0;I+&3(a"), Collections.singletonList(new Configuration())), false));
                Date __DSPOT_updatedAt_413 = new Date(".=wHrYPZ`B(QD_Z_8l^1");
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfigurationForAllLanguages(FeedbackOrchestratorProxyTest.idApplication);
                notNull(result);
                result.setUpdatedAt(__DSPOT_updatedAt_413);
                org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguages_mg4507 should have thrown IllegalArgumentException");
                result.setApiUserPermissions(__DSPOT_apiUserPermissions_428);
            }
            org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguages_mg4507_failAssert0_mg4588 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationWithConfigurationForAllLanguages_mg4507_failAssert0_mg4594_failAssert0() throws Exception {
        try {
            {
                List<Configuration> __DSPOT_configurations_434 = Collections.singletonList(new Configuration());
                Date __DSPOT_updatedAt_413 = new Date(".=wHrYPZ`B(QD_Z_8l^1");
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfigurationForAllLanguages(FeedbackOrchestratorProxyTest.idApplication);
                notNull(result);
                result.setUpdatedAt(__DSPOT_updatedAt_413);
                org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguages_mg4507 should have thrown IllegalArgumentException");
                result.setConfigurations(__DSPOT_configurations_434);
            }
            org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguages_mg4507_failAssert0_mg4594 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationWithConfigurationForAllLanguagesnull4510_failAssert0_mg4593_failAssert0() throws Exception {
        try {
            {
                List<UserGroup> __DSPOT_userGroups_433 = Collections.singletonList(new UserGroup("tvX.w{7}//=&@I>amZ0X", Collections.<User>emptyList(), new Application("C>vI8Jee:?[fDyrHQm-)", 870282530, new Date(2061991894, 201392207, -342342886), new Date(475442029, -1510126103, -337402494), new GeneralConfiguration(), Collections.<Configuration>emptyList(), Collections.<User>emptyList())));
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfigurationForAllLanguages(FeedbackOrchestratorProxyTest.idApplication);
                notNull(null);
                org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguagesnull4510 should have thrown IllegalArgumentException");
                result.setUserGroups(__DSPOT_userGroups_433);
            }
            org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguagesnull4510_failAssert0_mg4593 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUsernull3889_failAssert0() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
            notNull(null);
            org.junit.Assert.fail("testGetApplicationForUsernull3889 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUser_mg3881_failAssert0_mg3970_failAssert0() throws Exception {
        try {
            {
                GeneralConfiguration __DSPOT_generalConfiguration_231 = new GeneralConfiguration();
                Date __DSPOT_createdAt_208 = new Date(",C[xA?8M.?Y<$H[rH4Lv");
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
                notNull(result);
                result.setCreatedAt(__DSPOT_createdAt_208);
                org.junit.Assert.fail("testGetApplicationForUser_mg3881 should have thrown IllegalArgumentException");
                result.setGeneralConfiguration(__DSPOT_generalConfiguration_231);
            }
            org.junit.Assert.fail("testGetApplicationForUser_mg3881_failAssert0_mg3970 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUser_mg3881_failAssert0_mg3977_failAssert0() throws Exception {
        try {
            {
                List<UserGroup> __DSPOT_userGroups_238 = Collections.singletonList(new UserGroup());
                Date __DSPOT_createdAt_208 = new Date(",C[xA?8M.?Y<$H[rH4Lv");
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
                notNull(result);
                result.setCreatedAt(__DSPOT_createdAt_208);
                org.junit.Assert.fail("testGetApplicationForUser_mg3881 should have thrown IllegalArgumentException");
                result.setUserGroups(__DSPOT_userGroups_238);
            }
            org.junit.Assert.fail("testGetApplicationForUser_mg3881_failAssert0_mg3977 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUser_mg3881_failAssert0_mg3980_failAssert0() throws Exception {
        try {
            {
                List<User> __DSPOT_users_241 = Collections.singletonList(new User());
                Date __DSPOT_createdAt_208 = new Date(",C[xA?8M.?Y<$H[rH4Lv");
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
                notNull(result);
                result.setCreatedAt(__DSPOT_createdAt_208);
                org.junit.Assert.fail("testGetApplicationForUser_mg3881 should have thrown IllegalArgumentException");
                result.setUsers(__DSPOT_users_241);
            }
            org.junit.Assert.fail("testGetApplicationForUser_mg3881_failAssert0_mg3980 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUsernull3889_failAssert0_mg3961_failAssert0() throws Exception {
        try {
            {
                List<Configuration> __DSPOT_configurations_223 = Collections.singletonList(new Configuration());
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
                notNull(null);
                org.junit.Assert.fail("testGetApplicationForUsernull3889 should have thrown IllegalArgumentException");
                result.setConfigurations(__DSPOT_configurations_223);
            }
            org.junit.Assert.fail("testGetApplicationForUsernull3889_failAssert0_mg3961 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUsernull3889_failAssert0_mg3982_failAssert0() throws Exception {
        try {
            {
                List<User> __DSPOT_users_243 = Collections.singletonList(new User());
                Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
                notNull(null);
                org.junit.Assert.fail("testGetApplicationForUsernull3889 should have thrown IllegalArgumentException");
                result.setUsers(__DSPOT_users_243);
            }
            org.junit.Assert.fail("testGetApplicationForUsernull3889_failAssert0_mg3982 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetApplicationForUserGroupnull4336_failAssert0() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUserGroup(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUserGroup);
            notNull(null);
            org.junit.Assert.fail("testGetApplicationForUserGroupnull4336 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_add1() throws Exception {
        List<Application> o_searchApplicationsByName_add1__1 = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test Website 21");
        Assert.assertFalse(o_searchApplicationsByName_add1__1.isEmpty());
        List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test Website 21");
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_searchApplicationsByName_add1__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_literalMutationString7_failAssert0() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("");
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByName_literalMutationString7 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_literalMutationString8_failAssert0() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("maxTime");
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByName_literalMutationString8 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByNamenull29_failAssert0() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName(null);
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByNamenull29 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid name", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_add1_literalMutationString149_failAssert0() throws Exception {
        try {
            List<Application> o_searchApplicationsByName_add1__1 = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test Website 21");
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("");
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByName_add1_literalMutationString149 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_add1_literalMutationString149_failAssert0_literalMutationString491_failAssert0() throws Exception {
        try {
            {
                List<Application> o_searchApplicationsByName_add1__1 = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Tesh Website 21");
                List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("");
                notNull(result);
                isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("searchApplicationsByName_add1_literalMutationString149 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("searchApplicationsByName_add1_literalMutationString149_failAssert0_literalMutationString491 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void searchApplicationsByName_add1_literalMutationString151_failAssert0litString605_failAssert0() throws Exception {
        try {
            {
                List<Application> o_searchApplicationsByName_add1__1 = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test Website 1");
                List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("maxTime");
                notNull(result);
                isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("searchApplicationsByName_add1_literalMutationString151 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("searchApplicationsByName_add1_literalMutationString151_failAssert0litString605 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testImportApplication() throws Exception {
        Application app = FeedbackOrchestratorProxyTest.createApplication();
        Application result = FeedbackOrchestratorProxyTest.proxy.importApplication(app);
        notNull(result);
    }

    @Test(timeout = 30000)
    public void testGetConfigurations_add5284() throws Exception {
        List<Configuration> o_testGetConfigurations_add5284__1 = FeedbackOrchestratorProxyTest.proxy.getConfigurations(FeedbackOrchestratorProxyTest.idApplication);
        Assert.assertFalse(o_testGetConfigurations_add5284__1.isEmpty());
        List<Configuration> result = FeedbackOrchestratorProxyTest.proxy.getConfigurations(FeedbackOrchestratorProxyTest.idApplication);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetConfigurations_add5284__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfiguration_mg5409() throws Exception {
        String __DSPOT_fallbackLanguage_593 = "RrB?!&5w,I&J?8).8rqB";
        String __DSPOT_language_592 = "&do!d(o|2%zRl]QN)a)9";
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        notNull(result);
        List<Parameter> o_testGetGeneralConfigurationsOfConfiguration_mg5409__6 = result.parametersByLanguage(__DSPOT_language_592, __DSPOT_fallbackLanguage_593);
        Assert.assertTrue(o_testGetGeneralConfigurationsOfConfiguration_mg5409__6.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationnull5417_failAssert0() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull5417 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationnull5417_failAssert0_mg5461_failAssert0() throws Exception {
        try {
            {
                Application __DSPOT_application_605 = new Application();
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                notNull(null);
                org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull5417 should have thrown IllegalArgumentException");
                result.setApplication(__DSPOT_application_605);
            }
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull5417_failAssert0_mg5461 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationnull5417_failAssert0_mg5462_failAssert0() throws Exception {
        try {
            {
                Configuration __DSPOT_configuration_606 = new Configuration();
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                notNull(null);
                org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull5417 should have thrown IllegalArgumentException");
                result.setConfiguration(__DSPOT_configuration_606);
            }
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull5417_failAssert0_mg5462 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationById_mg6666() throws Exception {
        String __DSPOT_fallbackLanguage_709 = "B*.LZU$pjF_ Q$X%Dh7Q";
        String __DSPOT_language_708 = "G!H&hJ!A5-F$VagF6Rr<";
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
        notNull(result);
        List<Parameter> o_testGetGeneralConfigurationsOfConfigurationById_mg6666__6 = result.parametersByLanguage(__DSPOT_language_708, __DSPOT_fallbackLanguage_709);
        Assert.assertTrue(o_testGetGeneralConfigurationsOfConfigurationById_mg6666__6.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationByIdnull6674_failAssert0() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
            notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull6674 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationByIdnull6674_failAssert0_mg6718_failAssert0() throws Exception {
        try {
            {
                Application __DSPOT_application_721 = new Application(" )J90tEG?RDuXxyW1pg3", -1945765465, new Date(1647057529L), new Date(409695205, -358764033, -1142141983, -795490785, 1048536858), new GeneralConfiguration(), Collections.<Configuration>emptyList(), Collections.<User>emptyList(), Collections.singletonList(new UserGroup("!}[Hq!^6p)&c(5#[eeXk", Collections.<User>emptyList(), new Application())));
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
                notNull(null);
                org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull6674 should have thrown IllegalArgumentException");
                result.setApplication(__DSPOT_application_721);
            }
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull6674_failAssert0_mg6718 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetGeneralConfigurationsOfConfigurationByIdnull6674_failAssert0_mg6719_failAssert0() throws Exception {
        try {
            {
                Configuration __DSPOT_configuration_722 = new Configuration();
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
                notNull(null);
                org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull6674 should have thrown IllegalArgumentException");
                result.setConfiguration(__DSPOT_configuration_722);
            }
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull6674_failAssert0_mg6719 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteGeneralConfigurationOfConfiguration() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfConfiguration(genConf, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfConfiguration(result, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        isTrue(result.getName().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId(), FeedbackOrchestratorProxyTest.idConfiguration);
    }

    @Test(timeout = 30000)
    public void testGetMechanismsOfConfiguration_add8383() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        FeedbackOrchestratorProxyTest.idConfiguration = 9;
        List<Mechanism> o_testGetMechanismsOfConfiguration_add8383__3 = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        Assert.assertFalse(o_testGetMechanismsOfConfiguration_add8383__3.isEmpty());
        List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetMechanismsOfConfiguration_add8383__3.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetMechanismsOfConfiguration_literalMutationNumber8394_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 8;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfConfiguration_literalMutationNumber8394 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfConfiguration_add7644() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        FeedbackOrchestratorProxyTest.idConfiguration = 9;
        FeedbackOrchestratorProxyTest.idMechanism = 29;
        Mechanism o_testGetMechanismOfConfiguration_add7644__4 = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getConfigurationMechanisms());
        Assert.assertTrue(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).isActive());
        Assert.assertEquals(1, ((int) (((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getOrder())));
        Assert.assertEquals("Mechanism[id=29, type=\'null\', parameters=[]]", ((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).toString());
        Assert.assertEquals(29L, ((long) (((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getId())));
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getType());
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getParameters());
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
        notNull(result);
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getConfigurationMechanisms());
        Assert.assertTrue(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).isActive());
        Assert.assertEquals(1, ((int) (((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getOrder())));
        Assert.assertEquals("Mechanism[id=29, type=\'null\', parameters=[]]", ((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).toString());
        Assert.assertEquals(29L, ((long) (((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getId())));
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getType());
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfConfiguration_add7644__4)).getParameters());
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfConfiguration_literalMutationNumber7657_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 9;
            FeedbackOrchestratorProxyTest.idMechanism = 0;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
            notNull(result);
            org.junit.Assert.fail("testGetMechanismOfConfiguration_literalMutationNumber7657 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfConfigurationnull7706_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 9;
            FeedbackOrchestratorProxyTest.idMechanism = 29;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
            notNull(null);
            org.junit.Assert.fail("testGetMechanismOfConfigurationnull7706 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateMechanismOfConfiguration() throws Exception {
        Mechanism fm = createFeedbackMechanism(MechanismType.AUDIO_TYPE);
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.createMechanismOfConfiguration(fm, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        notNull(result);
    }

    @Test(timeout = 30000)
    public void testGetMechanismsOfApplication_add7971() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        List<Mechanism> o_testGetMechanismsOfApplication_add7971__2 = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
        Assert.assertFalse(o_testGetMechanismsOfApplication_add7971__2.isEmpty());
        List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetMechanismsOfApplication_add7971__2.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetMechanismsOfApplication_literalMutationNumber7977_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 4;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfApplication_literalMutationNumber7977 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfApplication_add7298() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        FeedbackOrchestratorProxyTest.idMechanism = 28;
        Mechanism o_testGetMechanismOfApplication_add7298__3 = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getConfigurationMechanisms());
        Assert.assertFalse(((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).isActive());
        Assert.assertEquals(0, ((int) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getOrder())));
        Assert.assertEquals("Mechanism[id=28, type=\'TEXT_TYPE\', parameters=\'Parameter[id=44, key=\'maxLengthVisible\', value=\'1.0\', language=\'en\'], Parameter[id=45, key=\'labelFontSize\', value=\'12.0\', language=\'en\'], Parameter[id=46, key=\'labelPositioning\', value=\'left\', language=\'en\'], Parameter[id=47, key=\'fieldWidth\', value=\'200.0\', language=\'en\'], Parameter[id=48, key=\'title\', value=\'Feedback Pull\', language=\'en\'], Parameter[id=49, key=\'borderColor\', value=\'#000000\', language=\'en\'], Parameter[id=50, key=\'mandatoryReminder\', value=\'Please fill in the text field\', language=\'en\'], Parameter[id=51, key=\'label\', value=\'Feedback\', language=\'en\'], Parameter[id=52, key=\'fieldBackgroundColor\', value=\'#ffffff\', language=\'en\'], Parameter[id=53, key=\'borderWidth\', value=\'2.0\', language=\'en\'], Parameter[id=54, key=\'hint\', value=\'Please enter your feedback\', language=\'en\'], Parameter[id=55, key=\'validateOnSkip\', value=\'1.0\', language=\'en\'], Parameter[id=56, key=\'mandatory\', value=\'1.0\', language=\'en\'], Parameter[id=57, key=\'clearInput\', value=\'0.0\', language=\'en\'], Parameter[id=58, key=\'undoSteps\', value=\'1.0\', language=\'en\'], Parameter[id=59, key=\'undoEnabled\', value=\'1.0\', language=\'en\'], Parameter[id=60, key=\'fieldHeight\', value=\'50.0\', language=\'en\'], Parameter[id=61, key=\'validationRegex\', value=\'.\', language=\'en\'], Parameter[id=62, key=\'maxLength\', value=\'50.0\', language=\'en\']\']", ((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).toString());
        Assert.assertEquals(28L, ((long) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getId())));
        Assert.assertFalse(((Collection) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getParameters())).isEmpty());
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
        notNull(result);
        Assert.assertNull(((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getConfigurationMechanisms());
        Assert.assertFalse(((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).isActive());
        Assert.assertEquals(0, ((int) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getOrder())));
        Assert.assertEquals("Mechanism[id=28, type=\'TEXT_TYPE\', parameters=\'Parameter[id=44, key=\'maxLengthVisible\', value=\'1.0\', language=\'en\'], Parameter[id=45, key=\'labelFontSize\', value=\'12.0\', language=\'en\'], Parameter[id=46, key=\'labelPositioning\', value=\'left\', language=\'en\'], Parameter[id=47, key=\'fieldWidth\', value=\'200.0\', language=\'en\'], Parameter[id=48, key=\'title\', value=\'Feedback Pull\', language=\'en\'], Parameter[id=49, key=\'borderColor\', value=\'#000000\', language=\'en\'], Parameter[id=50, key=\'mandatoryReminder\', value=\'Please fill in the text field\', language=\'en\'], Parameter[id=51, key=\'label\', value=\'Feedback\', language=\'en\'], Parameter[id=52, key=\'fieldBackgroundColor\', value=\'#ffffff\', language=\'en\'], Parameter[id=53, key=\'borderWidth\', value=\'2.0\', language=\'en\'], Parameter[id=54, key=\'hint\', value=\'Please enter your feedback\', language=\'en\'], Parameter[id=55, key=\'validateOnSkip\', value=\'1.0\', language=\'en\'], Parameter[id=56, key=\'mandatory\', value=\'1.0\', language=\'en\'], Parameter[id=57, key=\'clearInput\', value=\'0.0\', language=\'en\'], Parameter[id=58, key=\'undoSteps\', value=\'1.0\', language=\'en\'], Parameter[id=59, key=\'undoEnabled\', value=\'1.0\', language=\'en\'], Parameter[id=60, key=\'fieldHeight\', value=\'50.0\', language=\'en\'], Parameter[id=61, key=\'validationRegex\', value=\'.\', language=\'en\'], Parameter[id=62, key=\'maxLength\', value=\'50.0\', language=\'en\']\']", ((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).toString());
        Assert.assertEquals(28L, ((long) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getId())));
        Assert.assertFalse(((Collection) (((Mechanism) (o_testGetMechanismOfApplication_add7298__3)).getParameters())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfApplication_literalMutationNumber7306_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idMechanism = 0;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
            notNull(result);
            org.junit.Assert.fail("testGetMechanismOfApplication_literalMutationNumber7306 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetMechanismOfApplicationnull7343_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idMechanism = 28;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
            notNull(null);
            org.junit.Assert.fail("testGetMechanismOfApplicationnull7343 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteMechanismOfApplication() throws Exception {
        Mechanism fm = createFeedbackMechanism(MechanismType.INFO_TYPE);
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.createMechanismOfApplication(fm, FeedbackOrchestratorProxyTest.idApplication);
        notNull(result);
        result.setType(MechanismType.SCREENSHOT_TYPE);
        result = FeedbackOrchestratorProxyTest.proxy.updateMechanismOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
        isTrue(((result.getType()) == (MechanismType.SCREENSHOT_TYPE)));
        FeedbackOrchestratorProxyTest.proxy.deleteMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
    }

    @Ignore
    @Test
    public void testGetMechanismParameters() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        FeedbackOrchestratorProxyTest.idMechanism = 28;
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.getMechanismParameters(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
        notNull(result);
        isTrue((!(result.isEmpty())));
    }

    @Test(timeout = 30000)
    public void testGetParametersnull9120_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.getParameters();
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetParametersnull9120 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteParameters() throws Exception {
        List<Parameter> parameters = createParameters();
        Parameter result = FeedbackOrchestratorProxyTest.proxy.createParameter(parameters.get(0));
        notNull(result);
        result.setValue(((result.getValue()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateParameter(result);
        isTrue(result.getValue().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteParameter(result.getId());
    }

    @Test(timeout = 30000)
    public void testGetUsers_add9240_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.proxy.getUsers(FeedbackOrchestratorProxyTest.idApplication);
            List<User> result = FeedbackOrchestratorProxyTest.proxy.getUsers(FeedbackOrchestratorProxyTest.idApplication);
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetUsers_add9240 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUser_mg2554() throws Exception {
        String __DSPOT_userIdentification_57 = "V?oX1=O[j4cCb|@BFd4M";
        Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
        UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
        User user = new User("usertest", "usertest", application, userGroup);
        FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
        FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
        boolean o_testCreateUser_mg2554__11 = userGroup.containsUserWithUserIdentification(__DSPOT_userIdentification_57);
        Assert.assertFalse(o_testCreateUser_mg2554__11);
    }

    @Test(timeout = 30000)
    public void testCreateUsernull2613_failAssert0() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
            FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUsernull2613 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUsernull2614_failAssert0() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
            FeedbackOrchestratorProxyTest.proxy.createUser(null, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUsernull2614 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetUserGroups_add9173_failAssert0() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.proxy.getUserGroups(FeedbackOrchestratorProxyTest.idApplication);
            List<UserGroup> result = FeedbackOrchestratorProxyTest.proxy.getUserGroups(FeedbackOrchestratorProxyTest.idApplication);
            notNull(result);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetUserGroups_add9173 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testGetUserGroup() throws Exception {
        UserGroup result = FeedbackOrchestratorProxyTest.proxy.getUserGroup(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUserGroup);
        notNull(result);
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfMechanism_add16382() throws Exception {
        List<Parameter> o_testSwitchOrderOfParametersOfMechanism_add16382__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, 45, 46);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfMechanism_add16382__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, 45, 46);
        notEmpty(result);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfMechanism_add16382__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfMechanism_literalMutationNumber16395_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, 0, 46);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanism_literalMutationNumber16395 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfMechanism_add16382_literalMutationNumber16695_failAssert0() throws Exception {
        try {
            List<Parameter> o_testSwitchOrderOfParametersOfMechanism_add16382__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, 45, 46);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, 22, 46);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanism_add16382_literalMutationNumber16695 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfMechanism_add11043() throws Exception {
        List<Parameter> o_testReorderParameterOfMechanism_add11043__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 28, 45, 1);
        Assert.assertFalse(o_testReorderParameterOfMechanism_add11043__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 28, 45, 1);
        notEmpty(result);
        Assert.assertFalse(o_testReorderParameterOfMechanism_add11043__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfMechanism_literalMutationNumber11054_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 56, 45, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfMechanism_literalMutationNumber11054 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfMechanism_add11043_literalMutationNumber11359_failAssert0() throws Exception {
        try {
            List<Parameter> o_testReorderParameterOfMechanism_add11043__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 28, 45, 1);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 56, 45, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfMechanism_add11043_literalMutationNumber11359 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfGeneralConfiguration_add14643() throws Exception {
        List<Parameter> o_testSwitchOrderOfParametersOfGeneralConfiguration_add14643__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 40, 41);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfGeneralConfiguration_add14643__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 40, 41);
        notEmpty(result);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfGeneralConfiguration_add14643__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfGeneralConfiguration_literalMutationNumber14656_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 0, 41);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfiguration_literalMutationNumber14656 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfGeneralConfiguration_add14643litNum15022_failAssert0() throws Exception {
        try {
            List<Parameter> o_testSwitchOrderOfParametersOfGeneralConfiguration_add14643__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 40, 41);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 39, 41);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfiguration_add14643litNum15022 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfGeneralConfiguration_add9307() throws Exception {
        List<Parameter> o_testReorderParameterOfGeneralConfiguration_add9307__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 8, 40, 1);
        Assert.assertFalse(o_testReorderParameterOfGeneralConfiguration_add9307__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 8, 40, 1);
        notEmpty(result);
        Assert.assertFalse(o_testReorderParameterOfGeneralConfiguration_add9307__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfGeneralConfiguration_literalMutationNumber9316_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 16, 40, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfGeneralConfiguration_literalMutationNumber9316 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfGeneralConfiguration_add9307litNum9693_failAssert0() throws Exception {
        try {
            List<Parameter> o_testReorderParameterOfGeneralConfiguration_add9307__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 8, 40, 1);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 8, Integer.MAX_VALUE, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfGeneralConfiguration_add9307litNum9693 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfParameter_add18231() throws Exception {
        List<Parameter> o_testSwitchOrderOfParametersOfParameter_add18231__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, 78, 79);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfParameter_add18231__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, 78, 79);
        notEmpty(result);
        Assert.assertFalse(o_testSwitchOrderOfParametersOfParameter_add18231__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfParameter_literalMutationNumber18244_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, 0, 79);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameter_literalMutationNumber18244 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSwitchOrderOfParametersOfParameter_add18231litNum18617_failAssert0() throws Exception {
        try {
            List<Parameter> o_testSwitchOrderOfParametersOfParameter_add18231__1 = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, 78, 79);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, 78, Integer.MIN_VALUE);
            notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameter_add18231litNum18617 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfParameter_add12819() throws Exception {
        List<Parameter> o_testReorderParameterOfParameter_add12819__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 78, 1);
        Assert.assertFalse(o_testReorderParameterOfParameter_add12819__1.isEmpty());
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 78, 1);
        notEmpty(result);
        Assert.assertFalse(o_testReorderParameterOfParameter_add12819__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfParameter_literalMutationNumber12832_failAssert0() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 0, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfParameter_literalMutationNumber12832 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testReorderParameterOfParameter_add12819_literalMutationNumber13136_failAssert0() throws Exception {
        try {
            List<Parameter> o_testReorderParameterOfParameter_add12819__1 = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 78, 1);
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 77, 1);
            notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfParameter_add12819_literalMutationNumber13136 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    private List<Mechanism> createMechanisms(List<Parameter> parameters) {
        List<Mechanism> result = new ArrayList<>();
        Mechanism m = new Mechanism(MechanismType.RATING_TYPE, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), new ArrayList<>(), parameters);
        m.setActive(true);
        m.setOrder(4);
        return result;
    }

    private List<Parameter> createParameters() {
        List<Parameter> result = new ArrayList<>();
        Parameter p = new Parameter("test", "test", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "en", null, new ArrayList<Parameter>());
        result.add(p);
        p = new Parameter("mainColor", "#00ff0f", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "en", null, new ArrayList<Parameter>());
        result.add(p);
        return result;
    }

    private ApiUser createApiUser() throws Exception {
        ApiUser user = new ApiUser("test", "test");
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setUsername("test");
        user.setAuthorities(createAuthorities());
        return user;
    }

    private List<ApiUserRole> createAuthorities() {
        List<ApiUserRole> result = new ArrayList<>();
        result.add(ApiUserRole.ADMIN);
        return result;
    }

    private List<ApiUserPermission> createListApiUserPermissions(ApiUser user) throws Exception {
        List<ApiUserPermission> result = new ArrayList<>();
        result.add(createApiUserPermission(user));
        return result;
    }

    private ApiUserPermission createApiUserPermission(ApiUser user) throws Exception {
        Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
        ApiUserPermission permission = new ApiUserPermission(user, application, true);
        return permission;
    }

    private static Application createApplication() {
        Application app = new Application();
        app.setName(("Test Website " + (new Random().nextInt(1000))));
        app.setState(1);
        List<Parameter> fps = new ArrayList<>();
        fps.add(FeedbackOrchestratorProxyTest.createParameter("reviewActive", "1"));
        fps.add(FeedbackOrchestratorProxyTest.createParameter("mainColor", "#00ff00"));
        app.setGeneralConfiguration(FeedbackOrchestratorProxyTest.createGeneralConfiguration(fps));
        app.setConfigurations(new ArrayList<Configuration>());
        app.getConfigurations().add(FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PUSH, FeedbackOrchestratorProxyTest.createGeneralConfiguration(fps), new ArrayList<Mechanism>()));
        return app;
    }

    private static GeneralConfiguration createGeneralConfiguration(List<Parameter> parameters) {
        GeneralConfiguration gc = new GeneralConfiguration();
        gc.setName("GeneralConfiguration generated");
        gc.setCreatedAt(Calendar.getInstance().getTime());
        gc.setParameters(parameters);
        return gc;
    }

    private static Configuration createConfiguration(TriggerType type, GeneralConfiguration gc, List<Mechanism> mechanisms) {
        Configuration conf = new Configuration();
        conf.setType(type);
        conf.setGeneralConfiguration(gc);
        conf.getMechanisms().addAll(mechanisms);
        conf.setPullDefault(false);
        conf.setPushDefault(false);
        conf.setName("Configuration generated");
        return conf;
    }

    private Mechanism createFeedbackMechanism(MechanismType type) {
        Mechanism fm = new Mechanism();
        fm.setType(type);
        fm.setActive(true);
        fm.setOrder(2);
        List<Parameter> parameters = new ArrayList<>();
        Parameter p1 = new Parameter();
        p1.setKey("maxTime");
        p1.setValue("10.0");
        p1.setLanguage("en");
        parameters.add(p1);
        Parameter p2 = new Parameter();
        p2.setKey("maxSizeMb");
        p2.setValue("20.0");
        p2.setLanguage("en");
        parameters.add(p2);
        fm.setParameters(parameters);
        return fm;
    }

    private static Parameter createParameter(String key, String value) {
        Parameter fp = new Parameter();
        fp.setKey(key);
        fp.setValue(value);
        return fp;
    }
}

