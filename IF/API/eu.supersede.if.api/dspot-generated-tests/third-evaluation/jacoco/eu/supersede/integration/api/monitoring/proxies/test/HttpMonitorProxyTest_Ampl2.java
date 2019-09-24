package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.monitors.proxies.HttpMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class HttpMonitorProxyTest {
    private static HttpMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        HttpMonitorProxyTest.proxy = new HttpMonitorProxy<Object, Object>();
    }

    @Ignore
    @Test
    public void testCreateAndDeleteMonitorConfiguration() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_add1() throws Exception {
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1 = createMonitorConfiguration();
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getId());
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString13_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/esources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString13 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitString49_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/rsources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitString49 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull65_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull65 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0litString549_failAssert0litString1232_failAssert0() throws Exception {
        try {
            {
                {
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resourcs/files", "ljst1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getId()) > 0));
                    HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                    org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0litString549 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0litString549_failAssert0litString1232 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_add1litString551_failAssert0_literalMutationString1104_failAssert0() throws Exception {
        try {
            {
                HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1 = createMonitorConfiguration();
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/fiwles", "lis(1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 0));
                HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_add1litString551 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_add1litString551_failAssert0_literalMutationString1104 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Ignore
    @Test
    public void testUpdateMonitorConfiguration() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        result.setTimeSlot(6000);
        result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        Assert.notNull(result);
        Assert.isTrue(((result.getTimeSlot()) == 6000));
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_add1716() throws Exception {
        HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add1716__1 = createMonitorConfiguration();
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getId());
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
        Assert.notNull(result);
        Assert.notNull(result);
        result.setTimeSlot(6000);
        result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        Assert.isTrue(((result.getTimeSlot()) == 6000));
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1716__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber1742_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.notNull(result);
            result.setTimeSlot(0);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1742 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1802_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.notNull(null);
            result.setTimeSlot(6000);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1802 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_add1716_literalMutationNumber2359_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add1716__1 = createMonitorConfiguration();
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.notNull(result);
            result.setTimeSlot(5999);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_add1716_literalMutationNumber2359 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber1742_failAssert0_literalMutationString2117_failAssert0() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "f^6j9]=|UR");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                Assert.notNull(result);
                result.setTimeSlot(0);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1742 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1742_failAssert0_literalMutationString2117 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_add1716_add2035litNum3566_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add1716_add2035__1 = createMonitorConfiguration();
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add1716__1 = createMonitorConfiguration();
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.notNull(result);
            result.setTimeSlot(0);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_add1716_add2035litNum3566 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private HttpMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        HttpMonitorConfiguration conf = new HttpMonitorConfiguration();
        conf.setToolName("ApacheHttp");
        conf.setTimeSlot(3000);
        conf.setKafkaTopic("HttpTopic");
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setUrl("http://lab-supersede.atos-sports.tv:8000/handshake_test.php");
        conf.setMethod(Method.GET);
        return conf;
    }
}

