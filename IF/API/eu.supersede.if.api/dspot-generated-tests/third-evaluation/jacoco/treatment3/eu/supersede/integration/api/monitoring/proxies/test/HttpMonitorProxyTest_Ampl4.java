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
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


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
        org.junit.Assert.assertEquals(HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf), HttpStatus.OK);
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipart() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipart__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart__11)).toString());
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
        HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__12)).toString());
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString12_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/esources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString12 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull62_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull62 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0_literalMutationString261_failAssert0() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 0));
                HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull63_failAssert0_literalMutationString261 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0litString470_failAssert0() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/testpresources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 0));
                HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0litString470 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0_literalMutationString297_failAssert0_literalMutationString1184_failAssert0() throws Exception {
        try {
            {
                {
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("Jp9Flz5*yC=M]:bMoV#NG^1y", "list1s.xt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getId()) > 0));
                    HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                    org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0_literalMutationString297 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull64_failAssert0_literalMutationString297_failAssert0_literalMutationString1184 should have thrown NoSuchFileException");
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
    public void testUpdateMonitorConfigurationMultipart_add1905() throws Exception {
        HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add1905__1 = createMonitorConfiguration();
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getId());
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
        Assert.notNull(result);
        Assert.notNull(result);
        result.setTimeSlot(6000);
        result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        Assert.isTrue(((result.getTimeSlot()) == 6000));
        assertEquals(3000, ((int) (((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getTimeSlot())));
        assertEquals("ApacheHttp", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getToolName());
        assertEquals("HttpTopic", ((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getKafkaTopic());
        assertNull(((HttpMonitorConfiguration) (o_testUpdateMonitorConfigurationMultipart_add1905__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.notNull(result);
            result.setTimeSlot(0);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0litNum2543_failAssert0() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0litNum2543 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0_mg2437_failAssert0_add3289_failAssert0() throws Exception {
        try {
            {
                {
                    String __DSPOT_url_43 = "YhJjsv>Bx*R0oQx`#S=-";
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(result);
                    Assert.notNull(result);
                    result.setTimeSlot(0);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    result.getTimeSlot();
                    Assert.isTrue(((result.getTimeSlot()) == 6000));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931 should have thrown NullPointerException");
                    result.setUrl(__DSPOT_url_43);
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0_mg2437 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber1931_failAssert0_mg2437_failAssert0_add3289 should have thrown NullPointerException");
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

