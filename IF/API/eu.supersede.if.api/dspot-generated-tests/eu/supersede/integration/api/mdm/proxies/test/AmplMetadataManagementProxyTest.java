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
import org.springframework.util.Assert;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertEquals;


public class AmplMetadataManagementProxyTest {
    private static MetadataManagementProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplMetadataManagementProxyTest.proxy = new MetadataManagementProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testRegisterReleaselitString201_failAssert30() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("\n");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(release);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterReleaselitString201 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleasenull243_failAssert62() throws Exception {
        try {
            Release release = new Release();
            release.setEvent("TwitterMonitor");
            release.setSchemaVersion("Sample_Version_1");
            String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
            release.setJsonInstances(jsonInstances);
            release.setDispatch(true);
            release.setDispatcherPath("/path/to/dispatcher.txt");
            KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(null);
            Assert.notNull(result);
            org.junit.Assert.fail("testRegisterReleasenull243 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleaselitString201_failAssert30litString372_failAssert64() throws Exception {
        try {
            {
                Release release = new Release();
                release.setEvent("\n");
                release.setSchemaVersion("list1s.txt");
                String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
                release.setJsonInstances(jsonInstances);
                release.setDispatch(true);
                release.setDispatcherPath("/path/to/dispatcher.txt");
                KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(release);
                Assert.notNull(result);
                org.junit.Assert.fail("testRegisterReleaselitString201 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30litString372 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleaselitString201_failAssert30null440_failAssert103() throws Exception {
        try {
            {
                Release release = new Release();
                release.setEvent("\n");
                release.setSchemaVersion("Sample_Version_1");
                String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
                release.setJsonInstances(jsonInstances);
                release.setDispatch(true);
                release.setDispatcherPath("/path/to/dispatcher.txt");
                KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(null);
                Assert.notNull(result);
                org.junit.Assert.fail("testRegisterReleaselitString201 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30null440 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleaselitString201_failAssert30litString372_failAssert64litString633_failAssert154() throws Exception {
        try {
            {
                {
                    Release release = new Release();
                    release.setEvent("\n");
                    release.setSchemaVersion("list1s.txt");
                    String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
                    release.setJsonInstances(jsonInstances);
                    release.setDispatch(true);
                    release.setDispatcherPath("/path/to/dispatcher.txt");
                    KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(release);
                    Assert.notNull(result);
                    org.junit.Assert.fail("testRegisterReleaselitString201 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30litString372 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30litString372_failAssert64litString633 should have thrown HttpServerErrorException");
        } catch (HttpServerErrorException expected) {
            assertEquals("500 Internal Server Error", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRegisterReleaselitString201_failAssert30litString372_failAssert64null683_failAssert174() throws Exception {
        try {
            {
                {
                    Release release = new Release();
                    release.setEvent("\n");
                    release.setSchemaVersion("list1s.txt");
                    String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
                    release.setJsonInstances(jsonInstances);
                    release.setDispatch(true);
                    release.setDispatcherPath("/path/to/dispatcher.txt");
                    KafkaTopic result = AmplMetadataManagementProxyTest.proxy.registerRelease(null);
                    Assert.notNull(result);
                    org.junit.Assert.fail("testRegisterReleaselitString201 should have thrown HttpServerErrorException");
                }
                org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30litString372 should have thrown HttpServerErrorException");
            }
            org.junit.Assert.fail("testRegisterReleaselitString201_failAssert30litString372_failAssert64null683 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGelAllReleasesnull8_failAssert1() throws Exception {
        try {
            List<Release> result = AmplMetadataManagementProxyTest.proxy.getAllReleases();
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGelAllReleasesnull8 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGelAllEventsnull1_failAssert0() throws Exception {
        try {
            List<Event> result = AmplMetadataManagementProxyTest.proxy.getAllEvents();
            Assert.notNull(null);
            Assert.notEmpty(result);
            org.junit.Assert.fail("testGelAllEventsnull1 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testJsonInstanceslitString16() throws Exception {
        String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{kidItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
        assertEquals("{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{kidItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}", jsonInstances);
        System.out.println(jsonInstances);
        assertEquals("{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{kidItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}", jsonInstances);
    }

    @Test(timeout = 30000)
    public void testSendFileslitString822_failAssert206() throws Exception {
        try {
            Path filePath = FileSystems.getDefault().getPath("Sample_Version_1", "list1s.txt");
            AmplMetadataManagementProxyTest.proxy.sendFile(filePath);
            org.junit.Assert.fail("testSendFileslitString822 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("Sample_Version_1/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSendFilesnull839_failAssert223() throws Exception {
        try {
            Path filePath = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            AmplMetadataManagementProxyTest.proxy.sendFile(null);
            org.junit.Assert.fail("testSendFilesnull839 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid filePath", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSendFileslitString822_failAssert206litString881_failAssert224() throws Exception {
        try {
            {
                Path filePath = FileSystems.getDefault().getPath("Sample_Version_1", "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}");
                AmplMetadataManagementProxyTest.proxy.sendFile(filePath);
                org.junit.Assert.fail("testSendFileslitString822 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testSendFileslitString822_failAssert206litString881 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("Sample_Version_1/{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https:/twitter.com/SnoopDogg/status/734894106967703552\"}]}}", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSendFileslitString822_failAssert206null915_failAssert241() throws Exception {
        try {
            {
                Path filePath = FileSystems.getDefault().getPath("Sample_Version_1", "list1s.txt");
                AmplMetadataManagementProxyTest.proxy.sendFile(null);
                org.junit.Assert.fail("testSendFileslitString822 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testSendFileslitString822_failAssert206null915 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid filePath", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testSendFileslitString822_failAssert206litString881_failAssert224null1028_failAssert268() throws Exception {
        try {
            {
                {
                    Path filePath = FileSystems.getDefault().getPath("Sample_Version_1", "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}");
                    AmplMetadataManagementProxyTest.proxy.sendFile(null);
                    org.junit.Assert.fail("testSendFileslitString822 should have thrown NoSuchFileException");
                }
                org.junit.Assert.fail("testSendFileslitString822_failAssert206litString881 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testSendFileslitString822_failAssert206litString881_failAssert224null1028 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid filePath", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull66_failAssert2() throws Exception {
        try {
            Feedback feedback = new Feedback("hello, I don't like this");
            FeedbackClassification result = AmplMetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(null);
            Assert.notNull(result);
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feedback", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull67_failAssert3() throws Exception {
        try {
            Feedback feedback = new Feedback("hello, I don't like this");
            FeedbackClassification result = AmplMetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(feedback);
            Assert.notNull(null);
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull67 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull66_failAssert2litString114_failAssert4() throws Exception {
        try {
            {
                Feedback feedback = new Feedback("list1s.txt");
                FeedbackClassification result = AmplMetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(null);
                Assert.notNull(result);
                org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66_failAssert2litString114 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feedback", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull67_failAssert3litString105_failAssert16() throws Exception {
        try {
            {
                Feedback feedback = new Feedback("{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}");
                FeedbackClassification result = AmplMetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(feedback);
                Assert.notNull(null);
                org.junit.Assert.fail("testRealtimeFeedbackClassificationnull67 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull67_failAssert3litString105 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testRealtimeFeedbackClassificationnull66_failAssert2litString114_failAssert4null184_failAssert28() throws Exception {
        try {
            {
                {
                    Feedback feedback = new Feedback("list1s.txt");
                    FeedbackClassification result = AmplMetadataManagementProxyTest.proxy.getRealtimeFeedbackClassification(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66_failAssert2litString114 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testRealtimeFeedbackClassificationnull66_failAssert2litString114_failAssert4null184 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feedback", expected.getMessage());
        }
    }
}

