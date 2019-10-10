package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.TwitterMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class TwitterMonitorProxyTest_Ampl2 {
    private static TwitterMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        TwitterMonitorProxyTest_Ampl2.proxy = new TwitterMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        TwitterMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
        TwitterMonitorConfiguration conf = createMonitorConfiguration();
        TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        TwitterMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull18_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            TwitterMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull18 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull19_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
            notNull(null);
            isTrue(((result.getId()) > 0));
            TwitterMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull19 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_add947() throws Exception {
        TwitterMonitorConfiguration o_testUpdateMonitorConfiguration_add947__1 = createMonitorConfiguration();
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getKeywordExpression());
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testUpdateMonitorConfiguration_add947__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getId());
        TwitterMonitorConfiguration conf = createMonitorConfiguration();
        TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
        notNull(result);
        notNull(result);
        result.setTimeSlot(60);
        result = TwitterMonitorProxyTest_Ampl2.proxy.updateMonitorConfiguration(result);
        isTrue(((result.getTimeSlot()) == 60));
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getKeywordExpression());
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testUpdateMonitorConfiguration_add947__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add947__1)).getId());
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

