package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.TwitterMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AmplTwitterMonitorProxyTest {
    private static TwitterMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplTwitterMonitorProxyTest.proxy = new TwitterMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1() throws Exception {
        TwitterMonitorConfiguration conf = createMonitorConfiguration();
        TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 1));
        HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
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
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > (Integer.MAX_VALUE)));
            AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum3 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull21_failAssert1() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull21 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null103_failAssert3() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null103 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null104_failAssert4() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            Assert.isTrue(((result.getId()) > 1));
            HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null104 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null103_failAssert3_mg224_failAssert40() throws Exception {
        try {
            {
                List<String> __DSPOT_accounts_20 = Collections.singletonList("ndBdj-qEHp!#I]LDWP=,");
                TwitterMonitorConfiguration conf = createMonitorConfiguration();
                TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null103 should have thrown IllegalArgumentException");
                conf.setAccounts(__DSPOT_accounts_20);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null103_failAssert3_mg224 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationlitNum1null104_failAssert4_mg220_failAssert45() throws Exception {
        try {
            {
                List<String> __DSPOT_accounts_16 = Collections.singletonList("><6ycw,-c^.vZ(8(U^r,");
                TwitterMonitorConfiguration conf = createMonitorConfiguration();
                TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(null);
                Assert.isTrue(((result.getId()) > 1));
                HttpStatus o_testCreateAndDeleteMonitorConfigurationlitNum1__8 = AmplTwitterMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null104 should have thrown IllegalArgumentException");
                conf.setAccounts(__DSPOT_accounts_16);
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationlitNum1null104_failAssert4_mg220 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum254_failAssert50() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(result);
            result.setTimeSlot(61);
            result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull270_failAssert62() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
            Assert.notNull(result);
            result.setTimeSlot(60);
            result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull270 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull271_failAssert63() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            Assert.notNull(null);
            result.setTimeSlot(60);
            result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull271 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum254_failAssert50litNum323_failAssert67() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createMonitorConfiguration();
                TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 59));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50litNum323 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum254_failAssert50null357_failAssert76() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createMonitorConfiguration();
                TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50null357 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull270_failAssert62litNum328_failAssert78() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createMonitorConfiguration();
                TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
                Assert.notNull(result);
                result.setTimeSlot(61);
                result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                Assert.notNull(result);
                Assert.isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfigurationnull270 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull270_failAssert62litNum328 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum254_failAssert50litNum323_failAssert67null493_failAssert118() throws Exception {
        try {
            {
                {
                    TwitterMonitorConfiguration conf = createMonitorConfiguration();
                    TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(null);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50litNum323 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50litNum323_failAssert67null493 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationlitNum254_failAssert50litNum323_failAssert67null494_failAssert119() throws Exception {
        try {
            {
                {
                    TwitterMonitorConfiguration conf = createMonitorConfiguration();
                    TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(conf);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(null);
                    Assert.isTrue(((result.getTimeSlot()) == 59));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50litNum323 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationlitNum254_failAssert50litNum323_failAssert67null494 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull270_failAssert62litNum328_failAssert78litNum480_failAssert127() throws Exception {
        try {
            {
                {
                    TwitterMonitorConfiguration conf = createMonitorConfiguration();
                    TwitterMonitorConfiguration result = AmplTwitterMonitorProxyTest.proxy.createMonitorConfiguration(null);
                    Assert.notNull(result);
                    result.setTimeSlot(61);
                    result = AmplTwitterMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                    Assert.notNull(result);
                    Assert.isTrue(((result.getTimeSlot()) == 61));
                    org.junit.Assert.fail("testUpdateMonitorConfigurationnull270 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateMonitorConfigurationnull270_failAssert62litNum328 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull270_failAssert62litNum328_failAssert78litNum480 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    private TwitterMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        TwitterMonitorConfiguration conf = new TwitterMonitorConfiguration();
        conf.setToolName("TwitterAPI");
        conf.setTimeSlot(30);
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setKafkaTopic("tweeterMonitoring");
        conf.setKeywordExpression("(tweet OR follow) AND (me)");
        conf.setAccounts(Arrays.asList(new String[]{ "QuimMotger" }));
        return conf;
    }
}

