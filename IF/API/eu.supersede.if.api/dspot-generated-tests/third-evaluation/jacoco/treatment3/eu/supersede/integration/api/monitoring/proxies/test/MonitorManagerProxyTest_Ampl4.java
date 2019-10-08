package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.proxies.MonitorManagerProxy;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;


public class MonitorManagerProxyTest_Ampl4 {
    private static MonitorManagerProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        MonitorManagerProxyTest_Ampl4.proxy = new MonitorManagerProxy<eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1() throws Exception {
        TwitterMonitorConfiguration o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1 = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getId());
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7 = MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).toString());
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8 = MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__8)).toString());
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__1)).getId());
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_add1__7)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6() throws Exception {
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5 = MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).toString());
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6 = MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__6)).toString());
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove6__5)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12() throws Exception {
        List<String> __DSPOT_accounts_0 = Collections.<String>emptyList();
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8 = MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).toString());
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9 = MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).toString());
        conf.setAccounts(__DSPOT_accounts_0);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull26_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(null);
            conf.setTimeSlot(60);
            MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
            MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull26 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(60);
            MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(null);
            MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(60);
            MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
            MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(null);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12_add155() throws Exception {
        List o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12_add155__1 = Collections.<String>emptyList();
        Assert.assertTrue(o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12_add155__1.isEmpty());
        List<String> __DSPOT_accounts_0 = Collections.<String>emptyList();
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__8 = MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
        HttpStatus o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12__9 = MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        conf.setAccounts(__DSPOT_accounts_0);
        Assert.assertTrue(o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg12_add155__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28_failAssert0litNum305_failAssert0() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
                conf.setTimeSlot(-845241424);
                MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(null);
                MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28_failAssert0litNum305 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29_failAssert0_literalMutationNumber144_failAssert0_add974_failAssert0() throws Exception {
        try {
            {
                {
                    createTwitterMonitorConfiguration();
                    TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                    conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
                    conf.setTimeSlot(59);
                    MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf);
                    MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(null);
                    org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29_failAssert0_literalMutationNumber144 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull29_failAssert0_literalMutationNumber144_failAssert0_add974 should have thrown IllegalArgumentException");
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
        conf = MonitorManagerProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        Assert.assertNotNull(conf);
        conf.setTimeSlot(60);
        Assert.assertEquals(MonitorManagerProxyTest_Ampl4.proxy.updateMonitorConfiguration(conf), HttpStatus.OK);
        Assert.assertEquals(MonitorManagerProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf), HttpStatus.OK);
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

