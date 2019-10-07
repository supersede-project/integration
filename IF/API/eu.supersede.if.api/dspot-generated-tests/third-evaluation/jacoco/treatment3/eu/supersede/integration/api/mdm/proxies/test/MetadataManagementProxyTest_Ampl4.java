package eu.supersede.integration.api.mdm.proxies.test;


import eu.supersede.integration.api.mdm.proxies.MetadataManagementProxy;
import eu.supersede.integration.api.mdm.types.Event;
import eu.supersede.integration.api.mdm.types.Feedback;
import eu.supersede.integration.api.mdm.types.FeedbackClassification;
import eu.supersede.integration.api.mdm.types.KafkaTopic;
import eu.supersede.integration.api.mdm.types.Release;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class MetadataManagementProxyTest {
    private static MetadataManagementProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        MetadataManagementProxyTest.proxy = new MetadataManagementProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_add1174_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_add1174 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_remove1181_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_remove1181 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_remove1182_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_remove1182 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_remove1183_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_remove1183 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_remove1184_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_remove1184 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterRelease_remove1185_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterRelease_remove1185 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleasenull1293_failAssert0() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = MetadataManagementProxyTest.proxy.registerRelease(null);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterReleasenull1293 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGelAllReleasesnull76_failAssert0() throws Exception {
        try {
            List<Release> result = MetadataManagementProxyTest.proxy.getAllReleases();
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGelAllReleasesnull76 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGelAllEventsnull6_failAssert0() throws Exception {
        try {
            List<Event> result = MetadataManagementProxyTest.proxy.getAllEvents();
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGelAllEventsnull6 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGelAllEventsnull6_failAssert0_add26_failAssert0() throws Exception {
        try {
            {
                MetadataManagementProxyTest.proxy.getAllEvents();
                List<Event> result = MetadataManagementProxyTest.proxy.getAllEvents();
                Assert.notNull(null);
                Assert.notEmpty(result);
                org.junit.Assert.fail("testGelAllEventsnull6 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGelAllEventsnull6_failAssert0_add26 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testJsonInstances_literalMutationString130() throws Exception {
        String jsonInstances = "";
        assertEquals("", jsonInstances);
        System.out.println(jsonInstances);
        assertEquals("", jsonInstances);
    }

    @Test(timeout = 30000)
    public void testSendFiles_add3716() throws Exception {
        FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        Path filePath = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpStatus o_testSendFiles_add3716__6 = MetadataManagementProxyTest.proxy.sendFile(filePath);
        assertEquals("OK", ((HttpStatus) (o_testSendFiles_add3716__6)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testSendFiles_add3716__6)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testSendFiles_add3716__6)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testSendFiles_add3716__6)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testSendFiles_add3716__6)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testSendFiles_add3716__6)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testSendFiles_add3716__6)).toString());
    }

    @Test(timeout = 30000)
    public void testSendFiles_literalMutationString3720_failAssert0() throws Exception {
        try {
            Path filePath = FileSystems.getDefault().getPath("srcMtest/resources/files", "list1s.txt");
            MetadataManagementProxyTest.proxy.sendFile(filePath);
            org.junit.Assert.fail("testSendFiles_literalMutationString3720 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassification_add371() throws Exception {
        Feedback feedback = new Feedback("hello, I don't like this");
        FeedbackClassification o_testRealtimeFeedbackClassification_add371__3 = MetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(feedback);
        assertEquals(0.0, ((double) (((FeedbackClassification) (o_testRealtimeFeedbackClassification_add371__3)).getAccuracy())), 0.1);
        assertNull(((FeedbackClassification) (o_testRealtimeFeedbackClassification_add371__3)).getClassification());
        FeedbackClassification result = MetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(feedback);
        Assert.notNull(result);
        assertEquals(0.0, ((double) (((FeedbackClassification) (o_testRealtimeFeedbackClassification_add371__3)).getAccuracy())), 0.1);
        assertNull(((FeedbackClassification) (o_testRealtimeFeedbackClassification_add371__3)).getClassification());
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull399_failAssert0() throws Exception {
        try {
            Feedback feedback = new Feedback("hello, I don't like this");
            FeedbackClassification result = MetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(null);
            Assert.notNull(result);
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull399 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feedback", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull400_failAssert0() throws Exception {
        try {
            Feedback feedback = new Feedback("hello, I don't like this");
            FeedbackClassification result = MetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(feedback);
            Assert.notNull(null);
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull400 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
}

