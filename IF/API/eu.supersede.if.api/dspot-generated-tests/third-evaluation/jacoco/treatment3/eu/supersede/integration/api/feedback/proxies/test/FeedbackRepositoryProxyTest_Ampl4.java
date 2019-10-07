package eu.supersede.integration.api.feedback.proxies.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.AttachmentFeedback;
import eu.supersede.integration.api.feedback.repository.types.AudioFeedback;
import eu.supersede.integration.api.feedback.repository.types.CategoryFeedback;
import eu.supersede.integration.api.feedback.repository.types.ContextInformation;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.RatingFeedback;
import eu.supersede.integration.api.feedback.repository.types.ScreenshotFeedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
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


public class FeedbackRepositoryProxyTest {
    private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxyTest.class);

    private static FeedbackRepositoryProxy<Object, Object> proxy;

    private Integer applicationId = 1;

    private Integer feedbackId = 6341;

    private String userId = "u8102390";

    @BeforeClass
    public static void setup() throws Exception {
        String user = "super_admin";
        String password = "password";
        FeedbackRepositoryProxyTest.proxy = new FeedbackRepositoryProxy<Object, Object>(user, password);
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplication_add6768() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplication_add6768__1 = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplication(applicationId);
        Assert.assertFalse(o_testGetFeedbacksForApplication_add6768__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplication(applicationId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplication_add6768__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationnull6774_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplication(applicationId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationnull6774 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationWithOrchestratorConfiguration_add7052() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add7052__1 = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
        Assert.assertFalse(o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add7052__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplicationWithOrchestratorConfiguration_add7052__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationWithOrchestratorConfigurationnull7058_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationWithOrchestratorConfigurationnull7058 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationByUser_add6910() throws Exception {
        List<Feedback> o_testGetFeedbacksForApplicationByUser_add6910__1 = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
        Assert.assertFalse(o_testGetFeedbacksForApplicationByUser_add6910__1.isEmpty());
        List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testGetFeedbacksForApplicationByUser_add6910__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeedbacksForApplicationByUsernull6916_failAssert0() throws Exception {
        try {
            List<Feedback> result = FeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationByUsernull6916 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplication_add6581() throws Exception {
        Feedback o_testGetFeedbackForApplication_add6581__1 = FeedbackRepositoryProxyTest.proxy.getFeedbackForApplication(feedbackId, applicationId);
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getCategoryFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getRatingFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getFeedbackStatus());
        Assert.assertEquals("userId1", ((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getStatuses());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals(400L, ((long) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getId())));
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertEquals("Feedback[id=6341, configurationId=11]", ((Feedback) (o_testGetFeedbackForApplication_add6581__1)).toString());
        Assert.assertEquals(6341L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getId())));
        Feedback result = FeedbackRepositoryProxyTest.proxy.getFeedbackForApplication(feedbackId, applicationId);
        notNull(result);
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getCategoryFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getRatingFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getFeedbackStatus());
        Assert.assertEquals("userId1", ((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getUserIdentification());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getStatuses());
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getAndroidVersion());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals(400L, ((long) (((ContextInformation) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getContextInformation())).getId())));
        Assert.assertFalse(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertTrue(((Collection) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertEquals("Feedback[id=6341, configurationId=11]", ((Feedback) (o_testGetFeedbackForApplication_add6581__1)).toString());
        Assert.assertEquals(6341L, ((long) (((Feedback) (o_testGetFeedbackForApplication_add6581__1)).getId())));
    }

    @Test(timeout = 30000)
    public void testGetFeedbackForApplicationnull6602_failAssert0() throws Exception {
        try {
            Feedback result = FeedbackRepositoryProxyTest.proxy.getFeedbackForApplication(feedbackId, applicationId);
            notNull(null);
            org.junit.Assert.fail("testGetFeedbackForApplicationnull6602 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateFeedbackForApplication_add1() throws Exception {
        Feedback o_testCreateFeedbackForApplication_add1__1 = createFeedbackForApplication();
        Assert.assertEquals("New Feedback", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTitle());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getStatuses());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getAndroidVersion());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getCategoryFeedbacks());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getRatingFeedbacks());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getFeedbackStatus());
        Feedback result = createFeedbackForApplication();
        notNull(result);
        Assert.assertEquals("New Feedback", ((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTitle());
        Assert.assertEquals(11L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getConfigurationId())));
        Assert.assertEquals(1L, ((long) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplicationId())));
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getStatuses());
        Assert.assertEquals(2.0F, ((float) (((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getDevicePixelRatio())), 0.1);
        Assert.assertEquals("1920x1080", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getResolution());
        Assert.assertEquals("5.0", ((ContextInformation) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getContextInformation())).getAndroidVersion());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAttachmentFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getAudioFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getCategoryFeedbacks());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getRatingFeedbacks());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getScreenshotFeedbacks())).isEmpty());
        Assert.assertFalse(((Collection) (((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getTextFeedbacks())).isEmpty());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getApplication());
        Assert.assertNull(((Feedback) (o_testCreateFeedbackForApplication_add1__1)).getFeedbackStatus());
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
    public void testCreateFeedbackForApplication_mg7_failAssert0_mg381_failAssert0() throws Exception {
        try {
            {
                List<AttachmentFeedback> __DSPOT_attachmentFeedbacks_54 = Collections.singletonList(new AttachmentFeedback("B`v*a[[KUdhw0!nnrtG]", 36448589L));
                List<AudioFeedback> __DSPOT_audioFeedbacks_3 = Collections.singletonList(new AudioFeedback("V5:Wz2[|+mr6#-VtX(r!", 175909232, "s2l>UgIvC=TU&zgYc TM", "1`_8;0L`A=SO/woO!OKS", new Feedback("Rl&{ha!&Bcvg[?i!rb0/", "|]6^FT)-ef&bk*201yCi", new Date(), new Date(1181874356L), -1336129686L, -218475904L, "auR%h1,xavU[1Rvnj|}8", new ContextInformation("u]&8(Dgh`l V!3a(!.#b", "{[Iz>YSe|%xHdm7#=ToX", ")D7x>[Bob5_83OI`-k-a", new Date("(J8Bp[$XdYQ7-#sa<}t>"), "?]?7gchsEp#5_w)+KtmI", 0.5729418F, "*:lKC*+{5@T5!^MYU(dM", "7KJ&><6ycw,-c^.vZ(8(", "U^r,Jp9Flz5*yC=M]:bM", "oV#NG^1yAAF?5P&+YTN/"), Collections.singletonList(new AttachmentFeedback("O[*WW4JN-$nw<}7EGpwm", 280915206, "(EQndBdj-qEHp!#I]LDW", "P=,y4JV)d4}^w[&oDAIO", -137427397L)), Collections.singletonList(new AudioFeedback("O!T}Lq8xal:7%uE_&Ml%", 534937887, "sG#Ahw*&z*$G`c:wkJ!]", "[,J^uy}s#6CE3#^t lGv", new Feedback(), 69465992L, -1945088755)), Collections.<CategoryFeedback>emptyList(), Collections.<RatingFeedback>emptyList(), Collections.singletonList(new ScreenshotFeedback("`yc.L`HJ*J8r}4@(!YL#", -292052944L, Collections.singletonList(new eu.supersede.integration.api.feedback.repository.types.TextAnnotation()))), Collections.<TextFeedback>emptyList(), Collections.<Status>emptyList()), 1384249954L, -1830319410));
                Feedback result = createFeedbackForApplication();
                notNull(result);
                result.setAudioFeedbacks(__DSPOT_audioFeedbacks_3);
                org.junit.Assert.fail("testCreateFeedbackForApplication_mg7 should have thrown IllegalArgumentException");
                result.setAttachmentFeedbacks(__DSPOT_attachmentFeedbacks_54);
            }
            org.junit.Assert.fail("testCreateFeedbackForApplication_mg7_failAssert0_mg381 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    public <T> String convertToJSON(T object) throws JsonProcessingException {
        return FeedbackRepositoryProxyTest.proxy.convertToJSON(object);
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
        Feedback result = FeedbackRepositoryProxyTest.proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId);
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
    public void testDownloadAttachment_add2305() throws Exception {
        String attachmentName = "57377_1508862074050.txt";
        Assert.assertEquals("57377_1508862074050.txt", attachmentName);
        FeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
        byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
        isTrue(((result.length) > 0));
        Path path = Paths.get("attachment.att");
        Files.write(path, result);
        Assert.assertEquals("57377_1508862074050.txt", attachmentName);
    }

    @Test(timeout = 30000)
    public void testDownloadAttachment_literalMutationString2311_failAssert0() throws Exception {
        try {
            String attachmentName = "";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachment_literalMutationString2311 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("406 Not Acceptable", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAttachment_literalMutationString2313_failAssert0() throws Exception {
        try {
            String attachmentName = "57377_1508862074050.t>xt";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachment_literalMutationString2313 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_add5120() throws Exception {
        String screenshotName = "21794_1508918809103.png";
        Assert.assertEquals("21794_1508918809103.png", screenshotName);
        FeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
        byte[] result = FeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
        isTrue(((result.length) > 0));
        Path path = Paths.get("screenshot.png");
        Files.write(path, result);
        Assert.assertEquals("21794_1508918809103.png", screenshotName);
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_literalMutationString5126_failAssert0() throws Exception {
        try {
            String screenshotName = "";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshot_literalMutationString5126 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            Assert.assertEquals("406 Not Acceptable", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadScreenshot_literalMutationString5131_failAssert0() throws Exception {
        try {
            String screenshotName = "pxr[!Nm[$X @0(Lb=h|mwDX";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshot_literalMutationString5131 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAudio_literalMutationString3793_failAssert0() throws Exception {
        try {
            String audioName = "535533#1508250908348.mp3";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudio_literalMutationString3793 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            Assert.assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAudio_literalMutationString3804_failAssert0() throws Exception {
        try {
            String audioName = "535533_1508250908348.mp3";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudio_literalMutationString3804 should have thrown FileSystemException");
        } catch (FileSystemException expected) {
            Assert.assertEquals(": Is a directory", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDownloadAudiolitString3813_failAssert0() throws Exception {
        try {
            String audioName = "Vc?ql9ti^{EuZpS1Xh^b%,dg";
            byte[] result = FeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            isTrue(((result.length) > 0));
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudiolitString3813 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }
}

