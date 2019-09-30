package eu.supersede.integration.api.feedback.proxies.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.AttachmentFeedback;
import eu.supersede.integration.api.feedback.repository.types.AudioFeedback;
import eu.supersede.integration.api.feedback.repository.types.CategoryFeedback;
import eu.supersede.integration.api.feedback.repository.types.ContextInformation;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.FeedbackStatus;
import eu.supersede.integration.api.feedback.repository.types.RatingFeedback;
import eu.supersede.integration.api.feedback.repository.types.ScreenshotFeedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class FeedbackRepositoryProxyTest_Ampl2 {
    private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxyTest_Ampl2.class);

    private static FeedbackRepositoryProxy<Object, Object> proxy;

    private Integer applicationId = 1;

    private Integer feedbackId = 6341;

    private String userId = "u8102390";

    @BeforeClass
    public static void setup() throws Exception {
        String user = "super_admin";
        String password = "password";
        FeedbackRepositoryProxyTest_Ampl2.proxy = new FeedbackRepositoryProxy<Object, Object>(user, password);
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplication_add11845() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplication_add11845__1 = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplication(applicationId);
        Assert.assertFalse(o_testGetFeedbacksForApplication_add11845__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplication(applicationId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplication_add11845__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationnull11851_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplication(applicationId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationnull11851 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationWithOrchestratorConfiguration_add12126() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add12126__1 = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
        Assert.assertFalse(o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add12126__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add12126__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationWithOrchestratorConfigurationnull12132_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationWithOrchestratorConfigurationnull12132 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationByUser_add11984() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplicationByUser_add11984__1 = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
        Assert.assertFalse(o_testGetFeedbacksForApplicationByUser_add11984__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplicationByUser_add11984__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationByUsernull11990_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationByUsernull11990 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_add9673() throws Exception {
        Feedback o_testGetFeedbackForApplication_add9673__1 = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
        Assert.assertEquals("New Feedback", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getTitle());
        Assert.assertEquals("userId1", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getStatuses());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("{\"diagram\": \"diagramX2\"}", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getMetaData());
        Assert.assertEquals(400L, ((long) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getId())));
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getCategoryFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getRatingFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getFeedbackStatus());
        Assert.assertEquals("Feedback[id=6341, configurationId=11]", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).toString());
        Assert.assertEquals(6341L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getId())));
        Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
        notNull(result);
        Assert.assertEquals("New Feedback", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getTitle());
        Assert.assertEquals("userId1", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getStatuses());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("{\"diagram\": \"diagramX2\"}", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getMetaData());
        Assert.assertEquals(400L, ((long) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getContextInformation())).getId())));
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getCategoryFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getRatingFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getFeedbackStatus());
        Assert.assertEquals("Feedback[id=6341, configurationId=11]", ((Feedback) (o_testGetFeedbackForApplication_add9673__1)).toString());
        Assert.assertEquals(6341L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add9673__1)).getId())));
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplicationnull9694_failAssert0() throws Exception {
        try {
            Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
            notNull(null);
            org.junit.Assert.fail("testGetFeedbackForApplicationnull9694 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplicationnull9694_failAssert0_mg9765_failAssert0() throws Exception {
        try {
            {
                Application __DSPOT_application_193 = new Application();
                Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
                notNull(null);
                org.junit.Assert.fail("testGetFeedbackForApplicationnull9694 should have thrown IllegalArgumentException");
                result.setApplication(__DSPOT_application_193);
            }
            org.junit.Assert.fail("testGetFeedbackForApplicationnull9694_failAssert0_mg9765 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_mg9676_failAssert0_mg9919_failAssert0() throws Exception {
        try {
            {
                List<AudioFeedback> __DSPOT_audioFeedbacks_228 = Collections.singletonList(new AudioFeedback("=2V;#1JH7P8czuTc(A#A", 757381944, "3uSXfeA ic-Xw[ &JB%5", "0Ta3H$Yby[WU&iIzWeG`", new Feedback("d3RB;TNZIocnnHqe}*(o", "g3gxyp4;cV3]1H7O}2JK", -553163655L, 1054814240L, "ph(mE>&G,99Dhj!W^$>b"), -1246948587L, 173681672));
                Application __DSPOT_application_175 = new Application("XV;8qtc<3]`c[*]0*NUR", 103209380, new Date("f>g].;R^&NhR0[-k-SKT"), new Date(1143962952, -885324722, -311291208, 213329572, -664590353), new eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration("8*#Z{ H94wSTi:*WrHbP", new Date(460838345, 378120465, 529960761, -1340049597, 2101360576, 1952931535), new Date(-501624293L), Collections.singletonList(new eu.supersede.integration.api.feedback.orchestrator.types.Parameter()), new Application(), new Configuration()), Collections.singletonList(new Configuration()));
                Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
                notNull(result);
                result.setApplication(__DSPOT_application_175);
                org.junit.Assert.fail("testGetFeedbackForApplication_mg9676 should have thrown IllegalArgumentException");
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_228);
            }
            org.junit.Assert.fail("testGetFeedbackForApplication_mg9676_failAssert0_mg9919 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_add9673null10209_failAssert0() throws Exception {
        try {
            Feedback o_testGetFeedbackForApplication_add9673__1 = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
            Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
            notNull(null);
            org.junit.Assert.fail("testGetFeedbackForApplication_add9673null10209 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_mg9676_failAssert0_mg9895_failAssert0() throws Exception {
        try {
            {
                List<Configuration> __DSPOT_configurations_216 = Collections.singletonList(new Configuration());
                Application __DSPOT_application_175 = new Application("XV;8qtc<3]`c[*]0*NUR", 103209380, new Date("f>g].;R^&NhR0[-k-SKT"), new Date(1143962952, -885324722, -311291208, 213329572, -664590353), new eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration("8*#Z{ H94wSTi:*WrHbP", new Date(460838345, 378120465, 529960761, -1340049597, 2101360576, 1952931535), new Date(-501624293L), Collections.singletonList(new eu.supersede.integration.api.feedback.orchestrator.types.Parameter()), new Application(), new Configuration()), Collections.singletonList(new Configuration()));
                Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
                notNull(result);
                result.setApplication(__DSPOT_application_175);
                org.junit.Assert.fail("testGetFeedbackForApplication_mg9676 should have thrown IllegalArgumentException");
                __DSPOT_application_175.setConfigurations(__DSPOT_configurations_216);
            }
            org.junit.Assert.fail("testGetFeedbackForApplication_mg9676_failAssert0_mg9895 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_mg9676_failAssert0_add9759_failAssert0() throws Exception {
        try {
            {
                Collections.singletonList(new eu.supersede.integration.api.feedback.orchestrator.types.Parameter());
                Application __DSPOT_application_175 = new Application("XV;8qtc<3]`c[*]0*NUR", 103209380, new Date("f>g].;R^&NhR0[-k-SKT"), new Date(1143962952, -885324722, -311291208, 213329572, -664590353), new eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration("8*#Z{ H94wSTi:*WrHbP", new Date(460838345, 378120465, 529960761, -1340049597, 2101360576, 1952931535), new Date(-501624293L), Collections.singletonList(new eu.supersede.integration.api.feedback.orchestrator.types.Parameter()), new Application(), new Configuration()), Collections.singletonList(new Configuration()));
                Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.getFeedbackForApplication(feedbackId, applicationId);
                notNull(result);
                result.setApplication(__DSPOT_application_175);
                org.junit.Assert.fail("testGetFeedbackForApplication_mg9676 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetFeedbackForApplication_mg9676_failAssert0_add9759 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_add1() throws Exception {
        Feedback o_testCreateFeedbackForApplication_add1__1 = createFeedbackForApplication();
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("{\"diagram\": \"diagramX2\"}", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getMetaData());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals("+0200", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getTimeZone());
        Assert.assertEquals("CH", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getCountry());
        Assert.assertEquals("ZH", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getRegion());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getCategoryFeedbacks());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getRatingFeedbacks());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getFeedbackStatus());
        Assert.assertEquals("New Feedback", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTitle());
        Assert.assertEquals("u8102390", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getStatuses());
        Assert.assertEquals("en", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getLanguage());
        Feedback result = createFeedbackForApplication();
        notNull(result);
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("{\"diagram\": \"diagramX2\"}", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getMetaData());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals("+0200", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getTimeZone());
        Assert.assertEquals("CH", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getCountry());
        Assert.assertEquals("ZH", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getRegion());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getCategoryFeedbacks());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getRatingFeedbacks());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getFeedbackStatus());
        Assert.assertEquals("New Feedback", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTitle());
        Assert.assertEquals("u8102390", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getStatuses());
        Assert.assertEquals("en", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getLanguage());
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0() throws Exception {
        try {
            List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
            Feedback result = createFeedbackForApplication();
            notNull(result);
            result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0_mg392_failAssert0() throws Exception {
        try {
            {
                FeedbackStatus __DSPOT_feedbackStatus_45 = new FeedbackStatus();
                List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                Feedback result = createFeedbackForApplication();
                notNull(result);
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
                result.setFeedbackStatus(__DSPOT_feedbackStatus_45);
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg392 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0_mg389_failAssert0() throws Exception {
        try {
            {
                ContextInformation __DSPOT_contextInformation_42 = new ContextInformation();
                List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                Feedback result = createFeedbackForApplication();
                notNull(result);
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
                result.setContextInformation(__DSPOT_contextInformation_42);
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg389 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0_mg397_failAssert0() throws Exception {
        try {
            {
                List<Status> __DSPOT_statuses_50 = Collections.singletonList(new Status(1915610052, 858517827, "<aFOWRC/$oDWlo<Yu0]k"));
                List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                Feedback result = createFeedbackForApplication();
                notNull(result);
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
                result.setStatuses(__DSPOT_statuses_50);
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg397 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0_add88_failAssert0() throws Exception {
        try {
            {
                Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L));
                List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                Feedback result = createFeedbackForApplication();
                notNull(result);
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_add88 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_mg7_failAssert0_mg392_failAssert0_add1373_failAssert0() throws Exception {
        try {
            {
                {
                    FeedbackStatus __DSPOT_feedbackStatus_45 = new FeedbackStatus();
                    Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L));
                    List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                    Feedback result = createFeedbackForApplication();
                    notNull(result);
                    result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                    org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
                    result.setFeedbackStatus(__DSPOT_feedbackStatus_45);
                }
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg392 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg392_failAssert0_add1373 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    public <T> String convertToJSON(T object) throws JsonProcessingException {
        return FeedbackRepositoryProxyTest_Ampl2.proxy.convertToJSON(object);
    }

    private Feedback createFeedbackForApplication() throws Exception {
        Feedback feedback = createFeedback();
        Map<String, Path> attachments = new HashMap<>();
        attachments.put("attachment1", FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
        attachments.put("attachment2", FileSystems.getDefault().getPath("src/test/resources/files", "attachment2.txt"));
        Map<String, Path> screenshots = new HashMap<>();
        screenshots.put("screenshot1", FileSystems.getDefault().getPath("src/test/resources/files", "supersede_screenshot1.png"));
        Map<String, Path> audios = new HashMap<>();
        audios.put("audio1", FileSystems.getDefault().getPath("src/test/resources/files", "track.mp3"));
        Feedback result = FeedbackRepositoryProxyTest_Ampl2.proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId);
        return result;
    }

    private Feedback createFeedback() {
        Feedback feedback = new Feedback("New Feedback", userId, 1, 11, "en");
        feedback.setTextFeedbacks(new ArrayList<TextFeedback>() {
            {
                add(new TextFeedback("Text Feedback 1", 1));
                add(new TextFeedback("info@example.com", 2));
            }
        });
        feedback.setContextInformation(new ContextInformation("1920x1080", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36", "5.0", new Date(), "+0200", 2.0F, "CH", "ZH", "http://example.com/subpage1", "{\"diagram\": \"diagramX2\"}"));
        feedback.setAttachmentFeedbacks(new ArrayList<AttachmentFeedback>() {
            {
                add(new AttachmentFeedback("attachment1", 3));
                add(new AttachmentFeedback("attachment2", 3));
            }
        });
        feedback.setScreenshotFeedbacks(new ArrayList<ScreenshotFeedback>() {
            {
                add(new ScreenshotFeedback("screenshot1", 4, null));
            }
        });
        feedback.setAudioFeedbacks(new ArrayList<AudioFeedback>() {
            {
                add(new AudioFeedback(4L, 2));
            }
        });
        return feedback;
    }

    @Test(timeout = 30000)
    public void testDownloadAttachment_add5470() throws Exception {
        String attachmentName = "57377_1508862074050.txt";
        Assert.assertEquals("57377_1508862074050.txt", attachmentName);
        FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAttachment(attachmentName, applicationId);
        byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAttachment(attachmentName, applicationId);
        notNull(result);
        Path path = Paths.get("attachment.att");
        Files.write(path, result);
        Assert.assertEquals("57377_1508862074050.txt", attachmentName);
    }

    @Test(timeout = 30000)
    public void testDownloadAttachment_literalMutationString5476_failAssert0() throws Exception {
        try {
            String attachmentName = "57377_f508862074050.txt";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAttachment(attachmentName, applicationId);
            notNull(result);
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachment_literalMutationString5476 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAttachment_literalMutationString5481_failAssert0() throws Exception {
        try {
            String attachmentName = "c?FXt(-b`l}A)v%,52OUR8D";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAttachment(attachmentName, applicationId);
            notNull(result);
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachment_literalMutationString5481 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_add8282() throws Exception {
        String screenshotName = "21794_1508918809103.png";
        Assert.assertEquals("21794_1508918809103.png", screenshotName);
        FeedbackRepositoryProxyTest_Ampl2.proxy.downloadScreenshot(screenshotName, applicationId);
        byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadScreenshot(screenshotName, applicationId);
        notNull(result);
        Path path = Paths.get("screenshot.png");
        Files.write(path, result);
        Assert.assertEquals("21794_1508918809103.png", screenshotName);
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_literalMutationString8288_failAssert0() throws Exception {
        try {
            String screenshotName = "";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadScreenshot(screenshotName, applicationId);
            notNull(result);
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshot_literalMutationString8288 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("406 Not Acceptable", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_literalMutationString8290_failAssert0() throws Exception {
        try {
            String screenshotName = "0,a=S_K)=I*j06n?hXt-q2<";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadScreenshot(screenshotName, applicationId);
            notNull(result);
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshot_literalMutationString8290 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAudio_add6890() throws Exception {
        String audioName = "535533_1508250908348.mp3";
        Assert.assertEquals("535533_1508250908348.mp3", audioName);
        FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAudio(audioName, applicationId);
        byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAudio(audioName, applicationId);
        notNull(result);
        Path path = Paths.get("audio.mp3");
        Files.write(path, result);
        Assert.assertEquals("535533_1508250908348.mp3", audioName);
    }

    @Test(timeout = 30000)
    public void testDownloadAudio_literalMutationString6896_failAssert0() throws Exception {
        try {
            String audioName = "";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAudio(audioName, applicationId);
            notNull(result);
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudio_literalMutationString6896 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("406 Not Acceptable", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAudio_literalMutationString6899_failAssert0() throws Exception {
        try {
            String audioName = "5[35533_1508250908348.mp3";
            byte[] result = FeedbackRepositoryProxyTest_Ampl2.proxy.downloadAudio(audioName, applicationId);
            notNull(result);
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudio_literalMutationString6899 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }
}

