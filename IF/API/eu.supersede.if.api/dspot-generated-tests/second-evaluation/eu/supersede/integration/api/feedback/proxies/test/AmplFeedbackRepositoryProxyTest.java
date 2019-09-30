package eu.supersede.integration.api.feedback.proxies.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import eu.supersede.integration.api.feedback.proxies.FeedbackRepositoryProxy;
import eu.supersede.integration.api.feedback.repository.types.AttachmentFeedback;
import eu.supersede.integration.api.feedback.repository.types.AudioFeedback;
import eu.supersede.integration.api.feedback.repository.types.ContextInformation;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.ScreenshotFeedback;
import eu.supersede.integration.api.feedback.repository.types.TextFeedback;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;


public class AmplFeedbackRepositoryProxyTest {
    private static final Logger log = LoggerFactory.getLogger(AmplFeedbackRepositoryProxyTest.class);

    private static FeedbackRepositoryProxy<Object, Object> proxy;

    private Integer applicationId = 1;

    private Integer feedbackId = 6341;

    private String userId = "u8102390";

    @BeforeClass
    public static void setup() throws Exception {
        String user = "super_admin";
        String password = "password";
        AmplFeedbackRepositoryProxyTest.proxy = new FeedbackRepositoryProxy<Object, Object>(user, password);
    }

    @Test(timeout = 240000)
    public void testGetFeedbacksForApplicationnull1086_failAssert302() throws Exception {
        try {
            List<Feedback> result = AmplFeedbackRepositoryProxyTest.proxy.getFeedbacksForApplication(applicationId);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationnull1086 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetFeedbacksForApplicationWithOrchestratorConfigurationnull1092_failAssert304() throws Exception {
        try {
            List<Feedback> result = AmplFeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationWithOrchestratorConfiguration(applicationId);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationWithOrchestratorConfigurationnull1092 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetFeedbacksForApplicationByUsernull1089_failAssert303() throws Exception {
        try {
            List<Feedback> result = AmplFeedbackRepositoryProxyTest.proxy.getFeedbacksForApplicationByUser(applicationId, userId);
            Assert.notNull(null);
            Assert.isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testGetFeedbacksForApplicationByUsernull1089 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testGetFeedbackForApplicationnull1083_failAssert301() throws Exception {
        try {
            Feedback result = AmplFeedbackRepositoryProxyTest.proxy.getFeedbackForApplication(feedbackId, applicationId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetFeedbackForApplicationnull1083 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testCreateFeedbackForApplicationnull1_failAssert0() throws Exception {
        try {
            Feedback result = createFeedbackForApplication();
            Assert.notNull(null);
            org.junit.Assert.fail("testCreateFeedbackForApplicationnull1 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    public <T> String convertToJSON(T object) throws JsonProcessingException {
        return AmplFeedbackRepositoryProxyTest.proxy.convertToJSON(object);
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
        Feedback result = AmplFeedbackRepositoryProxyTest.proxy.createFeedbackForApplication(feedback, attachments, screenshots, audios, applicationId);
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

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString12() throws Exception {
        String attachmentName = "57377_1508862074050.txt";
        assertEquals("57377_1508862074050.txt", attachmentName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
        Assert.isTrue(((result.length) > 0));
        Path path = Paths.get("Text Feedback 1");
        Files.write(path, result);
        assertEquals("57377_1508862074050.txt", attachmentName);
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString4_failAssert1() throws Exception {
        try {
            String attachmentName = "Text Feedback 1";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachmentlitString4 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 98: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/attachments/Text Feedback 1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString5_failAssert2() throws Exception {
        try {
            String attachmentName = "57377k1508862074050.txt";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachmentlitString5 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentnull26_failAssert12() throws Exception {
        try {
            String attachmentName = null;
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("attachment.att");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAttachmentnull26 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid attachment name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString12litNum93() throws Exception {
        String attachmentName = "57377_1508862074050.txt";
        assertEquals("57377_1508862074050.txt", attachmentName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
        Assert.isTrue(((result.length) > 1));
        Path path = Paths.get("Text Feedback 1");
        Files.write(path, result);
        assertEquals("57377_1508862074050.txt", attachmentName);
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString4_failAssert1litString94_failAssert19() throws Exception {
        try {
            {
                String attachmentName = "Text Feedback 1";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("attachment1");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAttachmentlitString4 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1litString94 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 98: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/attachments/Text Feedback 1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString4_failAssert1null144_failAssert33() throws Exception {
        try {
            {
                String attachmentName = "Text Feedback 1";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(null, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("attachment.att");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAttachmentlitString4 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1null144 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid attachment name", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString5_failAssert2litString95_failAssert36() throws Exception {
        try {
            {
                String attachmentName = "57377k1508862074050.txt";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAttachmentlitString5 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString5_failAssert2litString95 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString12litNum93null278_failAssert70() throws Exception {
        try {
            String attachmentName = "57377_1508862074050.txt";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
            Assert.isTrue(((result.length) > 1));
            Path path = Paths.get("Text Feedback 1");
            Files.write(null, result);
            org.junit.Assert.fail("testDownloadAttachmentlitString12litNum93null278 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString4_failAssert1litString94_failAssert19litNum272_failAssert71() throws Exception {
        try {
            {
                {
                    String attachmentName = "Text Feedback 1";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("attachment1");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAttachmentlitString4 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1litString94 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1litString94_failAssert19litNum272 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 98: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/attachments/Text Feedback 1", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString4_failAssert1null144_failAssert33litString283_failAssert78() throws Exception {
        try {
            {
                {
                    String attachmentName = "Text Feedback 1";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(null, applicationId);
                    Assert.isTrue(((result.length) > 0));
                    Path path = Paths.get("attachment2");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAttachmentlitString4 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1null144 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString4_failAssert1null144_failAssert33litString283 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid attachment name", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAttachmentlitString5_failAssert2litString95_failAssert36litNum271_failAssert94() throws Exception {
        try {
            {
                {
                    String attachmentName = "57377k1508862074050.txt";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAttachment(attachmentName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAttachmentlitString5 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testDownloadAttachmentlitString5_failAssert2litString95 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadAttachmentlitString5_failAssert2litString95_failAssert36litNum271 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString734() throws Exception {
        String screenshotName = "21794_1508918809103.png";
        assertEquals("21794_1508918809103.png", screenshotName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
        Assert.isTrue(((result.length) > 0));
        Path path = Paths.get("^creenshot.png");
        Files.write(path, result);
        assertEquals("21794_1508918809103.png", screenshotName);
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString725_failAssert200() throws Exception {
        try {
            String screenshotName = "password";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshotlitString725 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString729_failAssert204() throws Exception {
        try {
            String screenshotName = "5_w)+KtmI6N*:lKC*+{5@T5";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshotlitString729 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 112: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/screenshots/5_w)+KtmI6N*:lKC*+{5@T5", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotnull747_failAssert212() throws Exception {
        try {
            String screenshotName = null;
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("screenshot.png");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadScreenshotnull747 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid screenshot name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString734litNum813() throws Exception {
        String screenshotName = "21794_1508918809103.png";
        assertEquals("21794_1508918809103.png", screenshotName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
        Assert.isTrue(((result.length) > 1));
        Path path = Paths.get("^creenshot.png");
        Files.write(path, result);
        assertEquals("21794_1508918809103.png", screenshotName);
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString725_failAssert200litString814_failAssert219() throws Exception {
        try {
            {
                String screenshotName = "password";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("src/test/resources/files");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadScreenshotlitString725 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200litString814 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString725_failAssert200null864_failAssert233() throws Exception {
        try {
            {
                String screenshotName = "password";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(null, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("screenshot.png");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadScreenshotlitString725 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200null864 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid screenshot name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString729_failAssert204litString814_failAssert236() throws Exception {
        try {
            {
                String screenshotName = "5_w)+KtmI6N*:lKC*+{5@T5";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("ZH");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadScreenshotlitString729 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString729_failAssert204litString814 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 112: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/screenshots/5_w)+KtmI6N*:lKC*+{5@T5", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString734litNum813null1000_failAssert270() throws Exception {
        try {
            String screenshotName = "21794_1508918809103.png";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
            Assert.isTrue(((result.length) > 1));
            Path path = Paths.get("^creenshot.png");
            Files.write(null, result);
            org.junit.Assert.fail("testDownloadScreenshotlitString734litNum813null1000 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString725_failAssert200litString814_failAssert219litNum990_failAssert271() throws Exception {
        try {
            {
                {
                    String screenshotName = "password";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("src/test/resources/files");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadScreenshotlitString725 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200litString814 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200litString814_failAssert219litNum990 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString725_failAssert200null864_failAssert233litString997_failAssert278() throws Exception {
        try {
            {
                {
                    String screenshotName = "password";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(null, applicationId);
                    Assert.isTrue(((result.length) > 0));
                    Path path = Paths.get("attachment.att");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadScreenshotlitString725 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200null864 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString725_failAssert200null864_failAssert233litString997 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid screenshot name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadScreenshotlitString729_failAssert204litString814_failAssert236litNum990_failAssert294() throws Exception {
        try {
            {
                {
                    String screenshotName = "5_w)+KtmI6N*:lKC*+{5@T5";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadScreenshot(screenshotName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("ZH");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadScreenshotlitString729 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testDownloadScreenshotlitString729_failAssert204litString814 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadScreenshotlitString729_failAssert204litString814_failAssert236litNum990 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Illegal character in path at index 112: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/screenshots/5_w)+KtmI6N*:lKC*+{5@T5", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString372() throws Exception {
        String audioName = "535533_1508250908348.mp3";
        assertEquals("535533_1508250908348.mp3", audioName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
        Assert.isTrue(((result.length) > 0));
        Path path = Paths.get("attachment1");
        Files.write(path, result);
        assertEquals("535533_1508250908348.mp3", audioName);
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAudiolitString364_failAssert101() throws Exception {
        try {
            String audioName = "5.0";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudiolitString364 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString368_failAssert105() throws Exception {
        try {
            String audioName = "auR%h1,xavU[1Rvnj|}8wu]&";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudiolitString368 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Malformed escape pair at index 92: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/audios/auR%h1,xavU[1Rvnj|}8wu]&", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudionull386_failAssert112() throws Exception {
        try {
            String audioName = null;
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            Assert.isTrue(((result.length) > 0));
            Path path = Paths.get("audio.mp3");
            Files.write(path, result);
            org.junit.Assert.fail("testDownloadAudionull386 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid audio name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString372litNum455() throws Exception {
        String audioName = "535533_1508250908348.mp3";
        assertEquals("535533_1508250908348.mp3", audioName);
        byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
        Assert.isTrue(((result.length) > 1));
        Path path = Paths.get("attachment1");
        Files.write(path, result);
        assertEquals("535533_1508250908348.mp3", audioName);
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAudiolitString364_failAssert101litString453_failAssert118() throws Exception {
        try {
            {
                String audioName = "5.0";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("21794_1508918809103.png");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAudiolitString364 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101litString453 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString364_failAssert101null499_failAssert132() throws Exception {
        try {
            {
                String audioName = "5.0";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(null, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("audio.mp3");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAudiolitString364 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101null499 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid audio name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString368_failAssert105litString454_failAssert135() throws Exception {
        try {
            {
                String audioName = "auR%h1,xavU[1Rvnj|}8wu]&";
                byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
                Assert.isTrue(((result.length) > 0));
                Path path = Paths.get("attachment1");
                Files.write(path, result);
                org.junit.Assert.fail("testDownloadAudiolitString368 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString368_failAssert105litString454 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Malformed escape pair at index 92: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/audios/auR%h1,xavU[1Rvnj|}8wu]&", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString372litNum455null644_failAssert169() throws Exception {
        try {
            String audioName = "535533_1508250908348.mp3";
            byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
            Assert.isTrue(((result.length) > 1));
            Path path = Paths.get("attachment1");
            Files.write(null, result);
            org.junit.Assert.fail("testDownloadAudiolitString372litNum455null644 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 240000)
    public void testDownloadAudiolitString364_failAssert101litString453_failAssert118litNum633_failAssert170() throws Exception {
        try {
            {
                {
                    String audioName = "5.0";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("21794_1508918809103.png");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAudiolitString364 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101litString453 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101litString453_failAssert118litNum633 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString364_failAssert101null499_failAssert132litString637_failAssert177() throws Exception {
        try {
            {
                {
                    String audioName = "5.0";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(null, applicationId);
                    Assert.isTrue(((result.length) > 0));
                    Path path = Paths.get("Text Feedback 1");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAudiolitString364 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101null499 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString364_failAssert101null499_failAssert132litString637 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid audio name", expected.getMessage());
        }
    }

    @Test(timeout = 240000)
    public void testDownloadAudiolitString368_failAssert105litString454_failAssert135litNum632_failAssert193() throws Exception {
        try {
            {
                {
                    String audioName = "auR%h1,xavU[1Rvnj|}8wu]&";
                    byte[] result = AmplFeedbackRepositoryProxyTest.proxy.downloadAudio(audioName, applicationId);
                    Assert.isTrue(((result.length) > 1));
                    Path path = Paths.get("attachment1");
                    Files.write(path, result);
                    org.junit.Assert.fail("testDownloadAudiolitString368 should have thrown URISyntaxException");
                }
                org.junit.Assert.fail("testDownloadAudiolitString368_failAssert105litString454 should have thrown URISyntaxException");
            }
            org.junit.Assert.fail("testDownloadAudiolitString368_failAssert105litString454_failAssert135litNum632 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
            assertEquals("Malformed escape pair at index 92: http://supersede.es.atos.net:8280/feedback_repository/en/applications/1/feedbacks/audios/auR%h1,xavU[1Rvnj|}8wu]&", expected.getMessage());
        }
    }
}

