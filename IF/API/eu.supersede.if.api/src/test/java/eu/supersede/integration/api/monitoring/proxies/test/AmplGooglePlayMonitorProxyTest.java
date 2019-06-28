package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AmplGooglePlayMonitorProxyTest {
    private static GooglePlayMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplGooglePlayMonitorProxyTest.proxy = new GooglePlayMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1() throws Exception {
        GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
        GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 1));
        HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfigurationlitNum1__8)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum3_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > (Integer.MAX_VALUE)));
            AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum3 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull19_failAssert1() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull19 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null91_failAssert3() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null91 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null93_failAssert4() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null93 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null91_failAssert3_mg192_failAssert36() throws Exception {
        try {
            {
                String __DSPOT_packageName_8 = "8wu]&8(Dgh`l V!3a(!.";
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null91 should have thrown HttpMessageNotWritableException");
                conf.setPackageName(__DSPOT_packageName_8);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null91_failAssert3_mg192 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null93_failAssert4_mg193_failAssert39() throws Exception {
        try {
            {
                String __DSPOT_packageName_9 = "#b{[Iz>YSe|%xHdm7#=T";
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplGooglePlayMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null93 should have thrown IllegalArgumentException");
                conf.setPackageName(__DSPOT_packageName_9);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null93_failAssert4_mg193 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(61);
            result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(Integer.MAX_VALUE);
            result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull228_failAssert54() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            result.setTimeSlot(60);
            result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull228 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull229_failAssert55() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            result.setTimeSlot(60);
            result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull229 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull231_failAssert57() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(60);
            result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull231 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum279_failAssert59() throws Exception {
        try {
            {
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 59));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum279 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42null321_failAssert66() throws Exception {
        try {
            {
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42null321 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68() throws Exception {
        try {
            {
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 61));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44null317_failAssert76() throws Exception {
        try {
            {
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44null317 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44null322_failAssert77() throws Exception {
        try {
            {
                GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(null);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44null322 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum279_failAssert59null517_failAssert134() throws Exception {
        try {
            {
                {
                    GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                    GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum279 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum279_failAssert59null517 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum279_failAssert59null518_failAssert135() throws Exception {
        try {
            {
                {
                    GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                    GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum279 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum279_failAssert59null518 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null515_failAssert143() throws Exception {
        try {
            {
                {
                    GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                    GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(null);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null515 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null520_failAssert144() throws Exception {
        try {
            {
                {
                    GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                    GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(null);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null520 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null526_failAssert146() throws Exception {
        try {
            {
                {
                    GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
                    GooglePlayMonitorConfiguration result = AmplGooglePlayMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AmplGooglePlayMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum273_failAssert68null526 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private GooglePlayMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        GooglePlayMonitorConfiguration conf = new GooglePlayMonitorConfiguration();
        conf.setToolName("AppTweak");
        conf.setTimeSlot(30);
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setKafkaTopic("MarketPlace");
        conf.setPackageName("com.facebook.katana");
        return conf;
    }
}

