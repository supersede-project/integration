package eu.supersede.integration.api.feedback.proxies.test;


import eu.supersede.integration.api.feedback.orchestrator.types.ApiUser;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserRole;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.MechanismType;
import eu.supersede.integration.api.feedback.orchestrator.types.Message;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.TriggerType;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AmplFeedbackOrchestratorProxyTest {
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

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22() throws Exception {
        try {
            String user = "test";
            String password = "password";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            Assert.notNull(token);
            org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString72_failAssert27() throws Exception {
        try {
            String user = "";
            String password = "password";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            Assert.notNull(token);
            org.junit.Assert.fail("testAuthenticatelitString72 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString80_failAssert35() throws Exception {
        try {
            String user = "superadmin";
            String password = "";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            Assert.notNull(token);
            org.junit.Assert.fail("testAuthenticatelitString80 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatenull84_failAssert39() throws Exception {
        try {
            String user = "superadmin";
            String password = null;
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            Assert.notNull(token);
            org.junit.Assert.fail("testAuthenticatenull84 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatenull87_failAssert42() throws Exception {
        try {
            String user = "superadmin";
            String password = "password";
            String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
            Assert.notNull(null);
            org.junit.Assert.fail("testAuthenticatenull87 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString131_failAssert43() throws Exception {
        try {
            {
                String user = "test";
                String password = "mainColor";
                String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
                Assert.notNull(token);
                org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString148_failAssert48() throws Exception {
        try {
            {
                String user = "test";
                String password = "";
                String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
                Assert.notNull(token);
                org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString148 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22null166_failAssert51() throws Exception {
        try {
            {
                String user = "test";
                String password = null;
                String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
                Assert.notNull(token);
                org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22null166 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22null169_failAssert52() throws Exception {
        try {
            {
                String user = "test";
                String password = "password";
                String token = FeedbackOrchestratorProxyTest.proxy.authenticate(null, password);
                Assert.notNull(token);
                org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22null169 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString131_failAssert43null283_failAssert94() throws Exception {
        try {
            {
                {
                    String user = "test";
                    String password = "mainColor";
                    String token = FeedbackOrchestratorProxyTest.proxy.authenticate(null, password);
                    Assert.notNull(token);
                    org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
                }
                org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131_failAssert43null283 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString131_failAssert43null286_failAssert95() throws Exception {
        try {
            {
                {
                    String user = "test";
                    String password = "mainColor";
                    String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, null);
                    Assert.notNull(token);
                    org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
                }
                org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131_failAssert43null286 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString131_failAssert43null288_failAssert96() throws Exception {
        try {
            {
                {
                    String user = "test";
                    String password = "mainColor";
                    String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
                }
                org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString131_failAssert43null288 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testAuthenticatelitString67_failAssert22litString148_failAssert48null291_failAssert99() throws Exception {
        try {
            {
                {
                    String user = "test";
                    String password = "";
                    String token = FeedbackOrchestratorProxyTest.proxy.authenticate(user, password);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testAuthenticatelitString67 should have thrown HttpClientErrorException");
                }
                org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString148 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testAuthenticatelitString67_failAssert22litString148_failAssert48null291 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAPIUsersnull4950_failAssert1236() throws Exception {
        try {
            List<ApiUser> result = FeedbackOrchestratorProxyTest.proxy.getApiUsers();
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetAPIUsersnull4950 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetAPIUsernull4947_failAssert1235() throws Exception {
        try {
            ApiUser result = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAPIUsernull4947 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteAPIUser() throws Exception {
        ApiUser user = createApiUser();
        ApiUser result = FeedbackOrchestratorProxyTest.proxy.createApiUser(user);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        result.setUsername(((result.getUsername()) + "Modified"));
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateApiUser(result);
        Assert.isTrue(result.getUsername().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteApiUser(result.getId());
    }

    @Ignore
    @Test
    public void testGetAPIUserPermissions() throws Exception {
        List<ApiUserPermission> result = FeedbackOrchestratorProxyTest.proxy.getApiUserPermissions(FeedbackOrchestratorProxyTest.idUser);
        Assert.notNull(result);
        Assert.isTrue((!(result.isEmpty())));
    }

    @Test
    @Ignore
    public void testCreateUpdateDeleteAPIUserPermission() throws Exception {
        ApiUser user = FeedbackOrchestratorProxyTest.proxy.getApiUser(FeedbackOrchestratorProxyTest.idUser);
        ApiUserPermission permission = createApiUserPermission(user);
        ApiUserPermission result = FeedbackOrchestratorProxyTest.proxy.createApiUserPermission(permission, user.getId());
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));


    }

    @Test(timeout = 240000)
    public void testGetApplicationsnull4965_failAssert1241() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.getApplications();
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetApplicationsnull4965 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetApplicationWithConfigurationnull4959_failAssert1239() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetApplicationWithConfigurationnull4959 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetApplicationWithConfigurationForAllLanguagesnull4962_failAssert1240() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfigurationForAllLanguages(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetApplicationWithConfigurationForAllLanguagesnull4962 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetApplicationForUsernull4953_failAssert1237() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUser(FeedbackOrchestratorProxyTest.idApplication_loaded, FeedbackOrchestratorProxyTest.idUser);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetApplicationForUsernull4953 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetApplicationForUserGroupnull4956_failAssert1238() throws Exception {
        try {
            Application result = FeedbackOrchestratorProxyTest.proxy.getApplicationForUserGroup(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUserGroup);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetApplicationForUserGroupnull4956 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamelitString1_failAssert0() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Modified");
            Assert.notNull(result);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByNamelitString1 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamelitString3_failAssert2() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test, Website 21");
            Assert.notNull(result);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByNamelitString3 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamenull9_failAssert8() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName(null);
            Assert.notNull(result);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByNamenull9 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamenull10_failAssert9() throws Exception {
        try {
            List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test Website 21");
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("searchApplicationsByNamenull10 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamelitString1_failAssert0null38_failAssert10() throws Exception {
        try {
            {
                List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Modified");
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("searchApplicationsByNamelitString1 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("searchApplicationsByNamelitString1_failAssert0null38 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamelitString3_failAssert2null39_failAssert11() throws Exception {
        try {
            {
                List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName("Test, Website 21");
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("searchApplicationsByNamelitString3 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("searchApplicationsByNamelitString3_failAssert2null39 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void searchApplicationsByNamenull9_failAssert8null35_failAssert12() throws Exception {
        try {
            {
                List<Application> result = FeedbackOrchestratorProxyTest.proxy.searchApplicationsByName(null);
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("searchApplicationsByNamenull9 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("searchApplicationsByNamenull9_failAssert8null35 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationlitString545() throws Exception {
        Application app = FeedbackOrchestratorProxyTest.createApplication();
        Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(app);
        Assert.notNull(result);
        FeedbackOrchestratorProxyTest.log.debug(("usertest" + (result.getId())));
        HttpStatus o_testCreateUpdateDeleteApplicationlitString545__14 = FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteApplicationlitString545__14)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationnull553_failAssert160() throws Exception {
        try {
            Application app = FeedbackOrchestratorProxyTest.createApplication();
            Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(null);
            Assert.notNull(result);
            FeedbackOrchestratorProxyTest.log.debug(("Removing application: " + (result.getId())));
            FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationnull553 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid application", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationnull554_failAssert161() throws Exception {
        try {
            Application app = FeedbackOrchestratorProxyTest.createApplication();
            Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(app);
            Assert.notNull(null);
            FeedbackOrchestratorProxyTest.log.debug(("Removing application: " + (result.getId())));
            FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationnull554 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationlitString545null602_failAssert162() throws Exception {
        try {
            Application app = FeedbackOrchestratorProxyTest.createApplication();
            Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(null);
            Assert.notNull(result);
            FeedbackOrchestratorProxyTest.log.debug(("usertest" + (result.getId())));
            HttpStatus o_testCreateUpdateDeleteApplicationlitString545__14 = FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null602 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid application", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationlitString545null604_failAssert163() throws Exception {
        try {
            Application app = FeedbackOrchestratorProxyTest.createApplication();
            Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(app);
            Assert.notNull(null);
            FeedbackOrchestratorProxyTest.log.debug(("usertest" + (result.getId())));
            HttpStatus o_testCreateUpdateDeleteApplicationlitString545__14 = FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null604 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationlitString545null602_failAssert162null715_failAssert202() throws Exception {
        try {
            {
                Application app = FeedbackOrchestratorProxyTest.createApplication();
                Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(null);
                Assert.notNull(null);
                FeedbackOrchestratorProxyTest.log.debug(("usertest" + (result.getId())));
                HttpStatus o_testCreateUpdateDeleteApplicationlitString545__14 = FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null602 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null602_failAssert162null715 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid application", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteApplicationlitString545null604_failAssert163null714_failAssert205() throws Exception {
        try {
            {
                Application app = FeedbackOrchestratorProxyTest.createApplication();
                Application result = FeedbackOrchestratorProxyTest.proxy.createApplication(app);
                Assert.notNull(null);
                FeedbackOrchestratorProxyTest.log.debug(null);
                HttpStatus o_testCreateUpdateDeleteApplicationlitString545__14 = FeedbackOrchestratorProxyTest.proxy.deleteApplication(result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null604 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteApplicationlitString545null604_failAssert163null714 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testImportApplication() throws Exception {
        Application app = FeedbackOrchestratorProxyTest.createApplication();
        Application result = FeedbackOrchestratorProxyTest.proxy.importApplication(app);
        Assert.notNull(result);
    }

    @Test(timeout = 240000)
    public void testGetGeneralConfigurationOfApplicationnull4974_failAssert1244() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationOfApplicationnull4974 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetGeneralConfigurationOfApplicationByIdnull4977_failAssert1245() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationOfApplicationByIdnull4977 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(result.getName().contains(""));
        HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1806__17)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(result.getName().contains("Modified"));
        HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Removing application: "));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1810_failAssert543() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(null, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1810 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid generalConfiguration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1811_failAssert544() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1811 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "grouptest"));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809null1945_failAssert562() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(null, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809null1945 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid generalConfiguration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809null1947_failAssert563() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809null1947 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528litString1862_failAssert567() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "Removing application: "));
                result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("usertest"));
                FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528litString1862 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528null1964_failAssert584() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                result.setName(((result.getName()) + "Removing application: "));
                result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528null1964 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548litString2184_failAssert648() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "grouptest"));
                result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("nodified"));
                HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548litString2184 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548null2242_failAssert654() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(null, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "grouptest"));
                result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548null2242 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid generalConfiguration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548null2244_failAssert655() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                result.setName(((result.getName()) + "grouptest"));
                result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809__17 = FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationnull1809litString1867_failAssert548null2244 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528null1964_failAssert584litString2179_failAssert699() throws Exception {
        try {
            {
                {
                    List<Parameter> parameters = createParameters();
                    GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                    GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfApplication(genConf, FeedbackOrchestratorProxyTest.idApplication);
                    Assert.notNull(null);
                    result.setName(((result.getName()) + "Removing application: "));
                    result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
                    Assert.isTrue(result.getName().contains("Modified"));
                    FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                    org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528null1964 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteGeneralConfigurationOfApplicationlitString1793_failAssert528null1964_failAssert584litString2179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetConfigurationsnull4971_failAssert1243() throws Exception {
        try {
            List<Configuration> result = FeedbackOrchestratorProxyTest.proxy.getConfigurations(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetConfigurationsnull4971 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetConfigurationnull4968_failAssert1242() throws Exception {
        try {
            Configuration result = FeedbackOrchestratorProxyTest.proxy.getConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetConfigurationnull4968 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationlitString738() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
        List<Mechanism> mechanisms = createMechanisms(parameters);
        Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
        Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(result.getName().contains(""));
        HttpStatus o_testCreateUpdateDeleteConfigurationlitString738__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationlitString738__21)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
        List<Mechanism> mechanisms = createMechanisms(parameters);
        Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
        Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(result.getName().contains("Modified"));
        HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull741__21)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull743() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
        List<Mechanism> mechanisms = createMechanisms(parameters);
        Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, null, mechanisms);
        Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(result.getName().contains("Modified"));
        HttpStatus o_testCreateUpdateDeleteConfigurationnull743__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteConfigurationnull743__21)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationlitString725_failAssert206() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "test"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull744_failAssert221() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, null);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull744 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull745_failAssert222() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(null, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull745 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid configuration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull746_failAssert223() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull746 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "mainColor"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741null933_failAssert242() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, null);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741null933 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741null936_failAssert243() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(null, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741null936 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid configuration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741null939_failAssert244() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741null939 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull743litString819_failAssert248() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, null, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            result.setName(((result.getName()) + "M9dified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull743__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull743litString819 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull743null945_failAssert263() throws Exception {
        try {
            List<Parameter> parameters = createParameters();
            GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
            List<Mechanism> mechanisms = createMechanisms(parameters);
            Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, null, mechanisms);
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            result.setName(((result.getName()) + "Modified"));
            result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
            Assert.isTrue(result.getName().contains("Modified"));
            HttpStatus o_testCreateUpdateDeleteConfigurationnull743__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull743null945 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationlitString725_failAssert206litString809_failAssert267() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "test"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("ModiTied"));
                FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725_failAssert206litString809 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationlitString725_failAssert206null942_failAssert287() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                result.setName(((result.getName()) + "test"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725_failAssert206null942 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227litString1336_failAssert390() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "mainColor"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Disposing created application: "));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808_failAssert227litString1336 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1444_failAssert398() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, null, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "mainColor"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1444 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1448_failAssert399() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, null);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "mainColor"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1448 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1450_failAssert400() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(null, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(result);
                result.setName(((result.getName()) + "mainColor"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1450 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid configuration", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1452_failAssert401() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                result.setName(((result.getName()) + "mainColor"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741litString808_failAssert227null1452 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationnull741null939_failAssert244null1474_failAssert468() throws Exception {
        try {
            {
                List<Parameter> parameters = createParameters();
                GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(null);
                List<Mechanism> mechanisms = createMechanisms(parameters);
                Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, null, mechanisms);
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                result.setName(((result.getName()) + "Modified"));
                result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                Assert.isTrue(result.getName().contains("Modified"));
                HttpStatus o_testCreateUpdateDeleteConfigurationnull741__21 = FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741null939 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationnull741null939_failAssert244null1474 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteConfigurationlitString725_failAssert206null942_failAssert287litString1335_failAssert512() throws Exception {
        try {
            {
                {
                    List<Parameter> parameters = createParameters();
                    GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
                    List<Mechanism> mechanisms = createMechanisms(parameters);
                    Configuration conf = FeedbackOrchestratorProxyTest.createConfiguration(TriggerType.PULL, genConf, mechanisms);
                    Configuration result = FeedbackOrchestratorProxyTest.proxy.createConfiguration(conf, FeedbackOrchestratorProxyTest.idApplication);
                    Assert.notNull(null);
                    result.setName(((result.getName()) + "test"));
                    result = FeedbackOrchestratorProxyTest.proxy.updateConfiguration(result, FeedbackOrchestratorProxyTest.idApplication);
                    Assert.isTrue(result.getName().contains("Modified"));
                    FeedbackOrchestratorProxyTest.proxy.deleteConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId());
                    org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725_failAssert206null942 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteConfigurationlitString725_failAssert206null942_failAssert287litString1335 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull335_failAssert106() throws Exception {
        try {
            Message message = new Message((("Hey user " + (FeedbackOrchestratorProxyTest.idUser)) + ", we considered your feedback and implemented it today. It will be shipped with the release next Monday."));
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(null, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
            Assert.notNull(result);
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid message", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull336_failAssert107() throws Exception {
        try {
            Message message = new Message((("Hey user " + (FeedbackOrchestratorProxyTest.idUser)) + ", we considered your feedback and implemented it today. It will be shipped with the release next Monday."));
            Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(message, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
            Assert.notNull(null);
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull335_failAssert106litString400_failAssert108() throws Exception {
        try {
            {
                Message message = new Message((("Modified" + (FeedbackOrchestratorProxyTest.idUser)) + ", we considered your feedback and implemented it today. It will be shipped with the release next Monday."));
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(null, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
                Assert.notNull(result);
                org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335_failAssert106litString400 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid message", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull336_failAssert107litString389_failAssert125() throws Exception {
        try {
            {
                Message message = new Message((("GeneralConfiguration generated" + (FeedbackOrchestratorProxyTest.idUser)) + ", we considered your feedback and implemented it today. It will be shipped with the release next Monday."));
                Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(message, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
                Assert.notNull(null);
                org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336_failAssert107litString389 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull335_failAssert106litString400_failAssert108litString494_failAssert142() throws Exception {
        try {
            {
                {
                    Message message = new Message((("Modified" + (FeedbackOrchestratorProxyTest.idUser)) + "password"));
                    Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(null, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
                    Assert.notNull(result);
                    org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335_failAssert106litString400 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull335_failAssert106litString400_failAssert108litString494 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid message", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreatePullConfigurationForUserInfonull336_failAssert107litString389_failAssert125litString491_failAssert151() throws Exception {
        try {
            {
                {
                    Message message = new Message((("GeneralConfiguration generated" + (FeedbackOrchestratorProxyTest.idUser)) + "Modified"));
                    Configuration result = FeedbackOrchestratorProxyTest.proxy.createPullConfigurationForUserInfo(message, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUser);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336_failAssert107litString389 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreatePullConfigurationForUserInfonull336_failAssert107litString389_failAssert125litString491 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetGeneralConfigurationsOfConfigurationnull4980_failAssert1246() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationnull4980 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetGeneralConfigurationsOfConfigurationByIdnull4983_failAssert1247() throws Exception {
        try {
            GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.getGeneralConfigurationOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idGeneralConfiguration);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetGeneralConfigurationsOfConfigurationByIdnull4983 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteGeneralConfigurationOfConfiguration() throws Exception {
        List<Parameter> parameters = createParameters();
        GeneralConfiguration genConf = FeedbackOrchestratorProxyTest.createGeneralConfiguration(parameters);
        GeneralConfiguration result = FeedbackOrchestratorProxyTest.proxy.createGeneralConfigurationOfConfiguration(genConf, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        Assert.notNull(result);
        result.setName(((result.getName()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateGeneralConfigurationOfConfiguration(result, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        Assert.isTrue(result.getName().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteGeneralConfigurationsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, result.getId(), FeedbackOrchestratorProxyTest.idConfiguration);
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationlitNum5302_failAssert1323() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 8;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            Assert.notNull(result);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfConfigurationlitNum5302 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationnull5307_failAssert1328() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 9;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationlitNum5302_failAssert1323null5342_failAssert1329() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 8;
                FeedbackOrchestratorProxyTest.idConfiguration = 8;
                List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("testGetMechanismsOfConfigurationlitNum5302 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfConfigurationlitNum5302_failAssert1323null5342 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341_failAssert1330() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 9;
                FeedbackOrchestratorProxyTest.idConfiguration = 9;
                List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341_failAssert1330litNum5380_failAssert1342() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idConfiguration = 10;
                    List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                    Assert.notNull(null);
                    Assert.isTrue((!(result.isEmpty())));
                    org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341_failAssert1330litNum5380 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341_failAssert1330litNum5381_failAssert1343() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idConfiguration = 8;
                    List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
                    Assert.notNull(null);
                    Assert.isTrue((!(result.isEmpty())));
                    org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfConfigurationnull5307_failAssert1328litNum5341_failAssert1330litNum5381 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationlitNum5102_failAssert1273() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 9;
            FeedbackOrchestratorProxyTest.idMechanism = 28;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
            Assert.notNull(result);
            org.junit.Assert.fail("testGetMechanismOfConfigurationlitNum5102 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationnull5107_failAssert1278() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idConfiguration = 9;
            FeedbackOrchestratorProxyTest.idMechanism = 29;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationlitNum5102_failAssert1273null5160_failAssert1279() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 8;
                FeedbackOrchestratorProxyTest.idConfiguration = 9;
                FeedbackOrchestratorProxyTest.idMechanism = 28;
                Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetMechanismOfConfigurationlitNum5102 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testGetMechanismOfConfigurationlitNum5102_failAssert1273null5160 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159_failAssert1280() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 9;
                FeedbackOrchestratorProxyTest.idConfiguration = 9;
                FeedbackOrchestratorProxyTest.idMechanism = 29;
                Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159_failAssert1280litNum5216_failAssert1298() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idConfiguration = 10;
                    FeedbackOrchestratorProxyTest.idMechanism = 29;
                    Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159_failAssert1280litNum5216 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159_failAssert1280litNum5223_failAssert1305() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idConfiguration = 9;
                    FeedbackOrchestratorProxyTest.idMechanism = 28;
                    Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfConfiguration(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration, FeedbackOrchestratorProxyTest.idMechanism);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfConfigurationnull5107_failAssert1278litNum5159_failAssert1280litNum5223 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateMechanismOfConfiguration() throws Exception {
        Mechanism fm = createFeedbackMechanism(MechanismType.AUDIO_TYPE);
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.createMechanismOfConfiguration(fm, FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idConfiguration);
        Assert.notNull(result);
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfApplicationlitNum5253_failAssert1310() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 7;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(result);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfApplicationlitNum5253 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfApplicationnull5258_failAssert1315() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetMechanismsOfApplicationnull5258 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfApplicationlitNum5253_failAssert1310null5275_failAssert1316() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 7;
                List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("testGetMechanismsOfApplicationlitNum5253 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfApplicationlitNum5253_failAssert1310null5275 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismsOfApplicationnull5258_failAssert1315litNum5274_failAssert1317() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 9;
                List<Mechanism> result = FeedbackOrchestratorProxyTest.proxy.getMechanismsOfApplication(FeedbackOrchestratorProxyTest.idApplication);
                Assert.notNull(null);
                Assert.isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("testGetMechanismsOfApplicationnull5258 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismsOfApplicationnull5258_failAssert1315litNum5274 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationlitNum4993_failAssert1248() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idMechanism = 27;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
            Assert.notNull(result);
            org.junit.Assert.fail("testGetMechanismOfApplicationlitNum4993 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationnull4998_failAssert1253() throws Exception {
        try {
            FeedbackOrchestratorProxyTest.idApplication = 8;
            FeedbackOrchestratorProxyTest.idMechanism = 28;
            Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetMechanismOfApplicationnull4998 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationlitNum4993_failAssert1248null5033_failAssert1254() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 8;
                FeedbackOrchestratorProxyTest.idMechanism = 27;
                Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetMechanismOfApplicationlitNum4993 should have thrown HttpClientErrorException");
            }
            org.junit.Assert.fail("testGetMechanismOfApplicationlitNum4993_failAssert1248null5033 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationnull4998_failAssert1253litNum5032_failAssert1255() throws Exception {
        try {
            {
                FeedbackOrchestratorProxyTest.idApplication = 9;
                FeedbackOrchestratorProxyTest.idMechanism = 28;
                Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetMechanismOfApplicationnull4998 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfApplicationnull4998_failAssert1253litNum5032 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationnull4998_failAssert1253litNum5032_failAssert1255litNum5071_failAssert1267() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idMechanism = 29;
                    Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetMechanismOfApplicationnull4998 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismOfApplicationnull4998_failAssert1253litNum5032 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfApplicationnull4998_failAssert1253litNum5032_failAssert1255litNum5071 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetMechanismOfApplicationnull4998_failAssert1253litNum5032_failAssert1255litNum5072_failAssert1268() throws Exception {
        try {
            {
                {
                    FeedbackOrchestratorProxyTest.idApplication = 9;
                    FeedbackOrchestratorProxyTest.idMechanism = 27;
                    Mechanism result = FeedbackOrchestratorProxyTest.proxy.getMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetMechanismOfApplicationnull4998 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetMechanismOfApplicationnull4998_failAssert1253litNum5032 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetMechanismOfApplicationnull4998_failAssert1253litNum5032_failAssert1255litNum5072 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("404 Not Found", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteMechanismOfApplication() throws Exception {
        Mechanism fm = createFeedbackMechanism(MechanismType.INFO_TYPE);
        Mechanism result = FeedbackOrchestratorProxyTest.proxy.createMechanismOfApplication(fm, FeedbackOrchestratorProxyTest.idApplication);
        Assert.notNull(result);
        result.setType(MechanismType.SCREENSHOT_TYPE);
        result = FeedbackOrchestratorProxyTest.proxy.updateMechanismOfApplication(result, FeedbackOrchestratorProxyTest.idApplication);
        Assert.isTrue(((result.getType()) == (MechanismType.SCREENSHOT_TYPE)));
        FeedbackOrchestratorProxyTest.proxy.deleteMechanismOfApplication(FeedbackOrchestratorProxyTest.idApplication, result.getId());
    }

    @Ignore
    @Test
    public void testGetMechanismParameters() throws Exception {
        FeedbackOrchestratorProxyTest.idApplication = 8;
        FeedbackOrchestratorProxyTest.idMechanism = 28;
        List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.getMechanismParameters(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idMechanism);
        Assert.notNull(result);
        Assert.isTrue((!(result.isEmpty())));
    }

    @Test(timeout = 240000)
    public void testGetParametersnull5401_failAssert1349() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.getParameters();
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetParametersnull5401 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetParameternull5398_failAssert1348() throws Exception {
        try {
            Parameter result = FeedbackOrchestratorProxyTest.proxy.getParameter(FeedbackOrchestratorProxyTest.idParameter);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetParameternull5398 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testCreateUpdateDeleteParameters() throws Exception {
        List<Parameter> parameters = createParameters();
        Parameter result = FeedbackOrchestratorProxyTest.proxy.createParameter(parameters.get(0));
        Assert.notNull(result);
        result.setValue(((result.getValue()) + "Modified"));
        result = FeedbackOrchestratorProxyTest.proxy.updateParameter(result);
        Assert.isTrue(result.getValue().contains("Modified"));
        FeedbackOrchestratorProxyTest.proxy.deleteParameter(result.getId());
    }

    @Test(timeout = 240000)
    public void testGetUsersnull5407_failAssert1351() throws Exception {
        try {
            List<User> result = FeedbackOrchestratorProxyTest.proxy.getUsers(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetUsersnull5407 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256() throws Exception {
        Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
        UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
        User user = new User("usertest", "usertest", application, userGroup);
        HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
        assertEquals("Created", ((HttpStatus) (o_testCreateUserlitString4256__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUserlitString4256__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is5xxServerError());
        assertEquals("201", ((HttpStatus) (o_testCreateUserlitString4256__8)).toString());
        HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
        assertEquals("Created", ((HttpStatus) (o_testCreateUserlitString4256__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUserlitString4256__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__9)).is5xxServerError());
        assertEquals("201", ((HttpStatus) (o_testCreateUserlitString4256__9)).toString());
        assertEquals("Created", ((HttpStatus) (o_testCreateUserlitString4256__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUserlitString4256__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUserlitString4256__8)).is5xxServerError());
        assertEquals("201", ((HttpStatus) (o_testCreateUserlitString4256__8)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUsernull4280_failAssert1083() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
            FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUsernull4280 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUsernull4281_failAssert1084() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
            FeedbackOrchestratorProxyTest.proxy.createUser(null, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUsernull4281 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256null4437_failAssert1085() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
            HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUserlitString4256null4437 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256null4441_failAssert1086() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
            User user = new User("usertest", "usertest", application, userGroup);
            HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
            HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(null, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUserlitString4256null4441 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUsernull4280_failAssert1083litString4388_failAssert1097() throws Exception {
        try {
            {
                Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
                UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
                User user = new User("us ertest", "usertest", application, userGroup);
                FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
                FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
                org.junit.Assert.fail("testCreateUsernull4280 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUsernull4280_failAssert1083litString4388 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256null4437_failAssert1085litString4690_failAssert1173() throws Exception {
        try {
            {
                Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
                UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
                User user = new User("GeneralConfiguration generated", "usertest", application, userGroup);
                HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
                HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(user, FeedbackOrchestratorProxyTest.idApplication);
                org.junit.Assert.fail("testCreateUserlitString4256null4437 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUserlitString4256null4437_failAssert1085litString4690 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256null4441_failAssert1086litString4690_failAssert1190() throws Exception {
        try {
            {
                Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
                UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
                User user = new User("Test Website 21", "usertest", application, userGroup);
                HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
                HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(null, FeedbackOrchestratorProxyTest.idApplication);
                org.junit.Assert.fail("testCreateUserlitString4256null4441 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUserlitString4256null4441_failAssert1086litString4690 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid user", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserlitString4256null4441_failAssert1086null4732_failAssert1206() throws Exception {
        try {
            {
                Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
                UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
                User user = new User("usertest", "usertest", application, userGroup);
                HttpStatus o_testCreateUserlitString4256__8 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
                HttpStatus o_testCreateUserlitString4256__9 = FeedbackOrchestratorProxyTest.proxy.createUser(null, FeedbackOrchestratorProxyTest.idApplication);
                org.junit.Assert.fail("testCreateUserlitString4256null4441 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUserlitString4256null4441_failAssert1086null4732 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetUserGroupsnull5404_failAssert1350() throws Exception {
        try {
            List<UserGroup> result = FeedbackOrchestratorProxyTest.proxy.getUserGroups(FeedbackOrchestratorProxyTest.idApplication);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetUserGroupsnull5404 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testGetUserGroup() throws Exception {
        UserGroup result = FeedbackOrchestratorProxyTest.proxy.getUserGroup(FeedbackOrchestratorProxyTest.idApplication, FeedbackOrchestratorProxyTest.idUserGroup);
        Assert.notNull(result);
    }

    @Test(timeout = 240000)
    public void testCreateUserGrouplitString4857() throws Exception {
        Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
        UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
        HttpStatus o_testCreateUserGrouplitString4857__6 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(userGroup, FeedbackOrchestratorProxyTest.idApplication);
        assertEquals("Created", ((HttpStatus) (o_testCreateUserGrouplitString4857__6)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUserGrouplitString4857__6)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUserGrouplitString4857__6)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUserGrouplitString4857__6)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUserGrouplitString4857__6)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUserGrouplitString4857__6)).is5xxServerError());
        assertEquals("201", ((HttpStatus) (o_testCreateUserGrouplitString4857__6)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUserGroupnull4865_failAssert1216() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("grouptest", new ArrayList<>(), application);
            FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUserGroupnull4865 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUserGrouplitString4857null4893_failAssert1217() throws Exception {
        try {
            Application application = FeedbackOrchestratorProxyTest.proxy.getApplicationWithConfiguration(FeedbackOrchestratorProxyTest.idApplication);
            UserGroup userGroup = new UserGroup("Modified", new ArrayList<>(), application);
            HttpStatus o_testCreateUserGrouplitString4857__6 = FeedbackOrchestratorProxyTest.proxy.createUserGroup(null, FeedbackOrchestratorProxyTest.idApplication);
            org.junit.Assert.fail("testCreateUserGrouplitString4857null4893 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid userGroup", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 27, 45, 46);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6126_failAssert1521() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 28, Integer.MAX_VALUE, 46);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6126 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198_failAssert1529() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 27, 46, 46);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6202_failAssert1531() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 27, Integer.MAX_VALUE, 46);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6202 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198_failAssert1529litNum6291_failAssert1559() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 27, 46, 47);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198_failAssert1529litNum6291 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198_failAssert1529litNum6295_failAssert1561() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfMechanism(8, 27, 46, Integer.MAX_VALUE);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfMechanismlitNum6119_failAssert1516litNum6198_failAssert1529litNum6295 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5600_failAssert1395() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 29, 45, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5601_failAssert1396() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 27, 45, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5600_failAssert1395litNum5686_failAssert1408() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 29, 46, 1);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600_failAssert1395litNum5686 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5601_failAssert1396litNum5675_failAssert1418() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 27, 46, 1);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601_failAssert1396litNum5675 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5600_failAssert1395litNum5686_failAssert1408litNum5745_failAssert1429() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 29, 46, 2);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600_failAssert1395litNum5686 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5600_failAssert1395litNum5686_failAssert1408litNum5745 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfMechanismlitNum5601_failAssert1396litNum5675_failAssert1418litNum5745_failAssert1433() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfMechanism(8, 27, 46, 2);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601_failAssert1396litNum5675 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfMechanismlitNum5601_failAssert1396litNum5675_failAssert1418litNum5745 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 7, 40, 41);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5943_failAssert1477() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 8, 39, 41);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5943 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014_failAssert1486() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 7, 41, 41);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6015_failAssert1487() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 7, 39, 41);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6015 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014_failAssert1486litNum6073_failAssert1504() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 7, 41, 42);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014_failAssert1486litNum6073 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014_failAssert1486litNum6077_failAssert1506() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfGeneralConfiguration(8, 7, 41, Integer.MAX_VALUE);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfGeneralConfigurationlitNum5937_failAssert1472litNum6014_failAssert1486litNum6077 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 9, 40, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 7, 40, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352litNum5490_failAssert1366() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 9, 41, 1);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352litNum5490 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353litNum5490_failAssert1376() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 7, 41, 1);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353litNum5490 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352litNum5490_failAssert1366litNum5561_failAssert1387() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 9, 41, 2);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352litNum5490 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5416_failAssert1352litNum5490_failAssert1366litNum5561 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353litNum5490_failAssert1376litNum5560_failAssert1390() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfGeneralConfiguration(8, 7, 41, 2);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353litNum5490 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfGeneralConfigurationlitNum5417_failAssert1353litNum5490_failAssert1376litNum5560 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 78, 78, 79);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6345_failAssert1577() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 77, Integer.MAX_VALUE, 79);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6345 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431_failAssert1585() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 78, 79, 79);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6435_failAssert1587() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 78, Integer.MAX_VALUE, 79);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6435 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431_failAssert1585litNum6511_failAssert1615() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 78, 79, 80);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431_failAssert1585litNum6511 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431_failAssert1585litNum6515_failAssert1617() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.switchOrderOfParametersOfParameter(8, 78, 79, Integer.MAX_VALUE);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testSwitchOrderOfParametersOfParameterlitNum6337_failAssert1571litNum6431_failAssert1585litNum6515 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5785_failAssert1438() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 78, 78, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5792_failAssert1444() throws Exception {
        try {
            List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 77, 77, 1);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5792 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859_failAssert1452() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 78, 79, 1);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5785_failAssert1438litNum5871_failAssert1459() throws Exception {
        try {
            {
                List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 78, 78, 0);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5871 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859_failAssert1452litNum5911_failAssert1467() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 78, 79, 2);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859_failAssert1452litNum5911 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this collection must not be empty: it must contain at least 1 element", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859_failAssert1452litNum5912_failAssert1468() throws Exception {
        try {
            {
                {
                    List<Parameter> result = FeedbackOrchestratorProxyTest.proxy.reorderParameterOfParameter(8, 78, 79, 0);
                    Assert.notEmpty(result);
                    org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testReorderParameterOfParameterlitNum5785_failAssert1438litNum5859_failAssert1452litNum5912 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414() throws Exception {
        Integer mechanismId = 1;
        Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
        parameter.setLanguage("en");
        parameter.setCreatedAt(Calendar.getInstance().getTime());
        parameter.setOrder(1);
        parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
        Assert.notNull(parameter.getId());
        parameter.setValue(((parameter.getValue()) + "modified"));
        parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
        Assert.isTrue(parameter.getValue().contains("modified"));
        HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismlitString2414__20)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473() throws Exception {
        Integer mechanismId = 1;
        Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
        parameter.setLanguage("en");
        parameter.setCreatedAt(Calendar.getInstance().getTime());
        parameter.setOrder(1);
        parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
        Assert.notNull(parameter.getId());
        parameter.setValue(((parameter.getValue()) + "modified"));
        parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
        Assert.isTrue(parameter.getValue().contains("modified"));
        HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
        assertEquals("OK", ((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateUpdateDeleteParameterInMechanismnull2473__20)).toString());
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2435_failAssert712() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "en"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2435 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2471_failAssert727() throws Exception {
        try {
            Integer mechanismId = null;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2471 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2476_failAssert728() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(null, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2476 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2478_failAssert730() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(null);
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2478 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2479_failAssert731() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(null, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2479 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2480_failAssert732() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, null);
            Assert.isTrue(parameter.getValue().contains("modified"));
            FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2480 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414litString2881_failAssert734() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("m{odified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414litString2881 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3058_failAssert750() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(null, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3058 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3046_failAssert751() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(null, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3046 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3061_failAssert752() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, null);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3061 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3051_failAssert753() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, null);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3051 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3055_failAssert754() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(null);
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3055 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2961_failAssert772() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(null, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2961 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2965_failAssert774() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(((parameter.getValue()) + "modified"));
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, null);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2965 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2955_failAssert775() throws Exception {
        try {
            Integer mechanismId = 1;
            Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
            parameter.setLanguage("en");
            parameter.setCreatedAt(Calendar.getInstance().getTime());
            parameter.setOrder(1);
            parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
            Assert.notNull(parameter.getId());
            parameter.setValue(null);
            parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
            Assert.isTrue(parameter.getValue().contains("modified"));
            HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2955 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2965_failAssert774litString3586_failAssert884() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(((parameter.getValue()) + ", we considered your feedback and implemented it today. It will be shipped with the release next Monday."));
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, null);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2965 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2965_failAssert774litString3586 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414litString2881_failAssert734litNum3589_failAssert885() throws Exception {
        try {
            {
                Integer mechanismId = Integer.MIN_VALUE;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(((parameter.getValue()) + "modified"));
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
                Assert.isTrue(parameter.getValue().contains("m{odified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414litString2881 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414litString2881_failAssert734litNum3589 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2961_failAssert772null3834_failAssert891() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(null);
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(null, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2961 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2961_failAssert772null3834 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3055_failAssert754litNum3677_failAssert898() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(Integer.MAX_VALUE);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(null);
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3055 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3055_failAssert754litNum3677 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3046_failAssert751litNum3799_failAssert902() throws Exception {
        try {
            {
                Integer mechanismId = Integer.MAX_VALUE;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(null, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(((parameter.getValue()) + "modified"));
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3046 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3046_failAssert751litNum3799 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3058_failAssert750litNum3782_failAssert903() throws Exception {
        try {
            {
                Integer mechanismId = Integer.MAX_VALUE;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(((parameter.getValue()) + "modified"));
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(null, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3058 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3058_failAssert750litNum3782 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid parameter", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3051_failAssert753null3811_failAssert910() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, null);
                Assert.notNull(parameter.getId());
                parameter.setValue(null);
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3051 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3051_failAssert753null3811 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismlitString2414null3061_failAssert752null3820_failAssert911() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("Modified", "test");
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(null);
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, null);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismlitString2414__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), mechanismId);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3061 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismlitString2414null3061_failAssert752null3820 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid mechanismId", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateUpdateDeleteParameterInMechanismnull2473null2955_failAssert775null3813_failAssert920() throws Exception {
        try {
            {
                Integer mechanismId = 1;
                Parameter parameter = FeedbackOrchestratorProxyTest.createParameter("test", null);
                parameter.setLanguage("en");
                parameter.setCreatedAt(Calendar.getInstance().getTime());
                parameter.setOrder(1);
                parameter = FeedbackOrchestratorProxyTest.proxy.createParameterInMechanism(parameter, mechanismId);
                Assert.notNull(parameter.getId());
                parameter.setValue(null);
                parameter = FeedbackOrchestratorProxyTest.proxy.updateParameterInMechanism(parameter, mechanismId);
                Assert.isTrue(parameter.getValue().contains("modified"));
                HttpStatus o_testCreateUpdateDeleteParameterInMechanismnull2473__20 = FeedbackOrchestratorProxyTest.proxy.deleteParameterInMechanism(parameter.getId(), null);
                org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2955 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateDeleteParameterInMechanismnull2473null2955_failAssert775null3813 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
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

