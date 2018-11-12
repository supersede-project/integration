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
import static org.junit.Assert.assertTrue;


public class AmplHttpMonitorProxyTest {
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
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
        HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 1));
        HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitString1_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("list1s.txt", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitString1 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum19_failAssert16() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > (Integer.MAX_VALUE)));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum19 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull26_failAssert18() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull26 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull27_failAssert19() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull27 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull28_failAssert20() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 0));
            HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull28 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("list1s.txt", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17null230_failAssert38() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null230 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17null232_failAssert39() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null232 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17null237_failAssert40() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null237 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartnull28_failAssert20litString99_failAssert171() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/]est/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 0));
                HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull28 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartnull28_failAssert20litString99 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/]est/resources/files/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21litString679_failAssert206() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("list1s.txt", "src/test/resources/files");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21litString679 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt/src/test/resources/files", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21_mg725_failAssert214() throws Exception {
        try {
            {
                String __DSPOT_url_14 = "Ct1H=N6{+DN-eV8<Or;(";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("list1s.txt", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97 should have thrown NoSuchFileException");
                conf.setUrl(__DSPOT_url_14);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21_mg725 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21null751_failAssert216() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("list1s.txt", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21null751 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21null753_failAssert217() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("list1s.txt", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17litString97_failAssert21null753 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17null232_failAssert39null769_failAssert257() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath(null, "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null232 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null232_failAssert39null769 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationMultipartlitNum17null237_failAssert40_mg756_failAssert275() throws Exception {
        try {
            {
                String __DSPOT_url_18 = " _ 2&pb?56TtKz.F5M(E";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationMultipartlitNum17__11 = HttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null237 should have thrown IllegalArgumentException");
                conf.setUrl(__DSPOT_url_18);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipartlitNum17null237_failAssert40_mg756 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
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
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/fIles/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            result.setTimeSlot(6001);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1002_failAssert312() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            result.setTimeSlot(5999);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1002 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(result);
            result.setTimeSlot(Integer.MIN_VALUE);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1016_failAssert324() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1016 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1017_failAssert325() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1017 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1018_failAssert326() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
            Assert.notNull(null);
            result.setTimeSlot(6000);
            result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286_failAssert330() throws Exception {
        try {
            {
                String __DSPOT_url_35 = "w1WL[gZTO{/AJ+_NXuz7";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(null);
                result.setTimeSlot(6000);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018 should have thrown IllegalArgumentException");
                result.setUrl(__DSPOT_url_35);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311_mg1233_failAssert332() throws Exception {
        try {
            {
                String __DSPOT_url_28 = "d]z^b ndZQzekGw)WtZA";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                result.setTimeSlot(6001);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001 should have thrown IllegalArgumentException");
                conf.setUrl(__DSPOT_url_28);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311_mg1233 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1016_failAssert324_mg1305_failAssert336() throws Exception {
        try {
            {
                String __DSPOT_url_39 = "Un((j*-vj<@X]YP!2!1t";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
                Assert.notNull(result);
                result.setTimeSlot(6000);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1016 should have thrown IllegalArgumentException");
                result.setUrl(__DSPOT_url_39);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1016_failAssert324_mg1305 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296_mg1245_failAssert338() throws Exception {
        try {
            {
                String __DSPOT_url_31 = "I]?$AOD{_@e,R]r3_{}V";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                result.setTimeSlot(6000);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
                result.setUrl(__DSPOT_url_31);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296_mg1245 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/fIles/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1017_failAssert325_mg1299_failAssert340() throws Exception {
        try {
            {
                String __DSPOT_url_37 = "F5:K|}Y.+DPW(yw#7%vG";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
                Assert.notNull(result);
                result.setTimeSlot(6000);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1017 should have thrown IllegalArgumentException");
                result.setUrl(__DSPOT_url_37);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1017_failAssert325_mg1299 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314_mg1223_failAssert342() throws Exception {
        try {
            {
                String __DSPOT_url_27 = "!a`s[iA&c(8{&?H -[-T";
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MIN_VALUE);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004 should have thrown NullPointerException");
                result.setUrl(__DSPOT_url_27);
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314_mg1223 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449() throws Exception {
        try {
            {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "list1s.txt");
                HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 6000));
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/fIles/list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449litString1757_failAssert526() throws Exception {
        try {
            {
                {
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 6000));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449litString1757 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/fIles", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449null1856_failAssert532() throws Exception {
        try {
            {
                {
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(null, file);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 6000));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449null1856 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid HttpMonitorConfiguration conf", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449null1861_failAssert533() throws Exception {
        try {
            {
                {
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/fIles", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, null);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 6000));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986 should have thrown NoSuchFileException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168 should have thrown NoSuchFileException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitString986_failAssert296litNum1168_failAssert449null1861 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid Path file", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286_failAssert330litNum1915_failAssert543() throws Exception {
        try {
            {
                {
                    String __DSPOT_url_35 = "w1WL[gZTO{/AJ+_NXuz7";
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(null);
                    result.setTimeSlot(6000);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == (Integer.MIN_VALUE)));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018 should have thrown IllegalArgumentException");
                    result.setUrl(__DSPOT_url_35);
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286_failAssert330litNum1915 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311_mg1233_failAssert332litNum1907_failAssert552() throws Exception {
        try {
            {
                {
                    String __DSPOT_url_28 = "d]z^b ndZQzekGw)WtZA";
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(result);
                    result.setTimeSlot(6001);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == (Integer.MIN_VALUE)));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001 should have thrown IllegalArgumentException");
                    conf.setUrl(__DSPOT_url_28);
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311_mg1233 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1001_failAssert311_mg1233_failAssert332litNum1907 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314_mg1223_failAssert342null1920_failAssert557() throws Exception {
        try {
            {
                {
                    String __DSPOT_url_27 = null;
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MIN_VALUE);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 6000));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004 should have thrown NullPointerException");
                    result.setUrl(__DSPOT_url_27);
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314_mg1223 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartlitNum1004_failAssert314_mg1223_failAssert342null1920 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286_failAssert330litNum1899_failAssert597() throws Exception {
        try {
            {
                {
                    String __DSPOT_url_35 = "w1WL[gZTO{/AJ+_NXuz7";
                    HttpMonitorConfiguration conf = createMonitorConfiguration();
                    Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
                    HttpMonitorConfiguration result = HttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, file);
                    Assert.notNull(null);
                    result.setTimeSlot(6000);
                    result = HttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 6001));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018 should have thrown IllegalArgumentException");
                    result.setUrl(__DSPOT_url_35);
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipartnull1018_failAssert326_mg1286_failAssert330litNum1899 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
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

