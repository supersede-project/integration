package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorProxy;
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


public class AmplAppStoreMonitorProxyTest {
    private static AppStoreMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AppStoreMonitorProxyTest.proxy = new AppStoreMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1() throws Exception {
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 1));
        HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
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
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > (Integer.MAX_VALUE)));
            AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum3 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull19_failAssert1() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull19 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null83_failAssert3() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null83 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null85_failAssert4() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null85 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null83_failAssert3_mg195_failAssert36() throws Exception {
        try {
            {
                String __DSPOT_appId_10 = "oX)D7x>[Bob5_83OI`-k";
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null83 should have thrown HttpMessageNotWritableException");
                conf.setAppId(__DSPOT_appId_10);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null83_failAssert3_mg195 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null85_failAssert4_mg192_failAssert39() throws Exception {
        try {
            {
                String __DSPOT_appId_8 = "8wu]&8(Dgh`l V!3a(!.";
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null85 should have thrown IllegalArgumentException");
                conf.setAppId(__DSPOT_appId_8);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null85_failAssert4_mg192 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(61);
            result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
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
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(Integer.MAX_VALUE);
            result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
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
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            result.setTimeSlot(60);
            result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull228 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull229_failAssert55() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            result.setTimeSlot(60);
            result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
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
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(60);
            result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull231 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum276_failAssert59() throws Exception {
        try {
            {
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 59));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum276 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42null320_failAssert66() throws Exception {
        try {
            {
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42null320 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68() throws Exception {
        try {
            {
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 61));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44null331_failAssert76() throws Exception {
        try {
            {
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44null331 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44null332_failAssert77() throws Exception {
        try {
            {
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(null);
                result.setTimeSlot(Integer.MAX_VALUE);
                result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44null332 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum276_failAssert59null521_failAssert134() throws Exception {
        try {
            {
                {
                    AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                    AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum276 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum276_failAssert59null521 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum214_failAssert42litNum276_failAssert59null525_failAssert135() throws Exception {
        try {
            {
                {
                    AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                    AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum276 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum214_failAssert42litNum276_failAssert59null525 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null522_failAssert143() throws Exception {
        try {
            {
                {
                    AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                    AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(null);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null522 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null526_failAssert144() throws Exception {
        try {
            {
                {
                    AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                    AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(null);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null526 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null533_failAssert146() throws Exception {
        try {
            {
                {
                    AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                    AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(Integer.MAX_VALUE);
                    result = AppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum216_failAssert44litNum274_failAssert68null533 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private AppStoreMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        AppStoreMonitorConfiguration conf = new AppStoreMonitorConfiguration();
        conf.setToolName("AppTweak");
        conf.setTimeSlot(30);
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setKafkaTopic("MarketPlace");
        conf.setAppId("567630281");
        return conf;
    }
}

