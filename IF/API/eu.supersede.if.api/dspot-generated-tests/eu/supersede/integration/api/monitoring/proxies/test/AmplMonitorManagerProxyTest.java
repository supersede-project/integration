package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.proxies.MonitorManagerProxy;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;


public class AmplMonitorManagerProxyTest {
    private static MonitorManagerProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplMonitorManagerProxyTest.proxy = new MonitorManagerProxy<eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1() throws Exception {
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((TwitterMonitorConfiguration) (conf)).getAccounts().isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("http://localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).toString());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPath());
        Assert.assertEquals("localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getAuthority());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getQuery());
        Assert.assertEquals("http", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getProtocol());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getFile());
        Assert.assertEquals("localhost", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getHost());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getUserInfo());
        Assert.assertEquals(9092, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPort())));
        Assert.assertEquals(80, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getDefaultPort())));
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getRef());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(61);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).toString());
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7)).toString());
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((TwitterMonitorConfiguration) (conf)).getAccounts().isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(61, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("http://localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).toString());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPath());
        Assert.assertEquals("localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getAuthority());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getQuery());
        Assert.assertEquals("http", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getProtocol());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getFile());
        Assert.assertEquals("localhost", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getHost());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getUserInfo());
        Assert.assertEquals(9092, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPort())));
        Assert.assertEquals(80, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getDefaultPort())));
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getRef());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7() throws Exception {
        List<String> __DSPOT_accounts_0 = Collections.singletonList("k},GdhscbCS@!x*zH_,y");
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((TwitterMonitorConfiguration) (conf)).getAccounts().isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("http://localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).toString());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPath());
        Assert.assertEquals("localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getAuthority());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getQuery());
        Assert.assertEquals("http", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getProtocol());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getFile());
        Assert.assertEquals("localhost", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getHost());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getUserInfo());
        Assert.assertEquals(9092, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPort())));
        Assert.assertEquals(80, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getDefaultPort())));
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getRef());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).toString());
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).toString());
        conf.setAccounts(__DSPOT_accounts_0);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)conf).getAccounts().contains("k},GdhscbCS@!x*zH_,y"));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("http://localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).toString());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPath());
        Assert.assertEquals("localhost:9092", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getAuthority());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getQuery());
        Assert.assertEquals("http", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getProtocol());
        Assert.assertEquals("", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getFile());
        Assert.assertEquals("localhost", ((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getHost());
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getUserInfo());
        Assert.assertEquals(9092, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getPort())));
        Assert.assertEquals(80, ((int) (((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getDefaultPort())));
        Assert.assertNull(((URL) (((TwitterMonitorConfiguration) (conf)).getKafkaEndpoint())).getRef());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull9_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(null);
            conf.setTimeSlot(60);
            AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
            AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull9 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(60);
            AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
            AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull12_failAssert2() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(60);
            AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
            AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(null);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull12 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null85_failAssert3() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(61);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null85 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null101_failAssert4() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(61);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(null);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null101 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7null168_failAssert5() throws Exception {
        try {
            List<String> __DSPOT_accounts_0 = Collections.singletonList("k},GdhscbCS@!x*zH_,y");
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(null);
            conf.setTimeSlot(60);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
            HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            conf.setAccounts(__DSPOT_accounts_0);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7null168 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1null148_failAssert65() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
                conf.setTimeSlot(60);
                AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
                AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(null);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1null148 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null85_failAssert3_mg452_failAssert95() throws Exception {
        try {
            {
                List<String> __DSPOT_accounts_12 = Collections.singletonList("KC*+{5@T5!^MYU(dM7KJ");
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
                conf.setTimeSlot(61);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null85 should have thrown IllegalArgumentException");
                conf.setAccounts(__DSPOT_accounts_12);
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null85_failAssert3_mg452 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null101_failAssert4_mg471_failAssert98() throws Exception {
        try {
            {
                List<String> __DSPOT_accounts_14 = Collections.singletonList("9Flz5*yC=M]:bMoV#NG^");
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
                conf.setTimeSlot(61);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__6 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1__7 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(null);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null101 should have thrown IllegalArgumentException");
                conf.setAccounts(__DSPOT_accounts_14);
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationlitNum1null101_failAssert4_mg471 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7null168_failAssert5litString448_failAssert101() throws Exception {
        try {
            {
                List<String> __DSPOT_accounts_0 = Collections.singletonList("ApacheHttp");
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(null);
                conf.setTimeSlot(60);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__8 = AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
                HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7__9 = AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
                conf.setAccounts(__DSPOT_accounts_0);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7null168 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg7null168_failAssert5litString448 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1null148_failAssert65litNum459_failAssert123() throws Exception {
        try {
            {
                {
                    TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                    conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
                    conf.setTimeSlot(59);
                    AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
                    AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(null);
                    org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1null148 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull11_failAssert1null148_failAssert65litNum459 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    private TwitterMonitorConfiguration createTwitterMonitorConfiguration() throws MalformedURLException {
        TwitterMonitorConfiguration twitterConf = new TwitterMonitorConfiguration();
        twitterConf.setToolName("TwitterAPI");
        twitterConf.setTimeSlot(30);
        twitterConf.setKafkaEndpoint(new URL("http://localhost:9092"));
        twitterConf.setKafkaTopic("tweeterMonitoring");
        twitterConf.setKeywordExpression("(olympics) AND (streaming)");
        return twitterConf;
    }

    @Ignore
    @Test
    public void testCreateUpdateAndDeleteHttpMonitorConfiguration() throws Exception {
        HttpMonitorConfiguration conf = createHttpMonitorConfiguration();
        conf = AmplMonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.assertNotNull(conf);
        conf.setTimeSlot(60);
        Assert.assertEquals(AmplMonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf), HttpStatus.OK);
        Assert.assertEquals(AmplMonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf), HttpStatus.OK);
    }

    private HttpMonitorConfiguration createHttpMonitorConfiguration() throws MalformedURLException {
        HttpMonitorConfiguration httpConf = new HttpMonitorConfiguration();
        httpConf.setToolName("ApacheHttp");
        httpConf.setTimeSlot(30000);
        httpConf.setKafkaTopic("httpStress");
        httpConf.setUrl("http://lab-supersede.atos-sports.tv:8000/handshake_test.php");
        httpConf.setMethod(Method.GET);
        return httpConf;
    }
}

