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


public class MonitorManagerProxyTest {
    private static MonitorManagerProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        MonitorManagerProxyTest.proxy = new MonitorManagerProxy<eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration, Object>();
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
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
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
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove7() throws Exception {
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_remove8() throws Exception {
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14() throws Exception {
        List<String> __DSPOT_accounts_0 = Collections.<String>emptyList();
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (conf)).getId());
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        conf.setAccounts(__DSPOT_accounts_0);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (conf)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (conf)).getAccounts())).isEmpty());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (conf)).getToolName());
        Assert.assertEquals(60, ((int) (((TwitterMonitorConfiguration) (conf)).getTimeSlot())));
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (conf)).getKafkaTopic());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(null);
            conf.setTimeSlot(60);
            MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
            MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull28 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull30_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
            conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
            conf.setTimeSlot(60);
            MonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
            MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull30 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148() throws Exception {
        List<String> __DSPOT_accounts_0 = Collections.<String>emptyList();
        TwitterMonitorConfiguration o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3 = createTwitterMonitorConfiguration();
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getAccounts())).isEmpty());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getKafkaTopic());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getTimeSlot())));
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getId());
        TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
        conf.setAccounts(__DSPOT_accounts_0);
        Assert.assertEquals("(olympics) AND (streaming)", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getKeywordExpression());
        Assert.assertTrue(((Collection) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getAccounts())).isEmpty());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getKafkaTopic());
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getToolName());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getTimeSlot())));
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateUpdateAndDeleteTwitterMonitorConfiguration_mg14_add148__3)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateUpdateAndDeleteTwitterMonitorConfigurationnull30_failAssert0litNum224_failAssert0() throws Exception {
        try {
            {
                TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
                conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
                conf.setTimeSlot(59);
                MonitorManagerProxyTest.proxy.updateMonitorConfiguration(null);
                MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull30 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateUpdateAndDeleteTwitterMonitorConfigurationnull30_failAssert0litNum224 should have thrown IllegalArgumentException");
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
        conf = MonitorManagerProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.assertNotNull(conf);
        conf.setTimeSlot(60);
        MonitorManagerProxyTest.proxy.updateMonitorConfiguration(conf);
        MonitorManagerProxyTest.proxy.deleteMonitorConfiguration(conf);
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

