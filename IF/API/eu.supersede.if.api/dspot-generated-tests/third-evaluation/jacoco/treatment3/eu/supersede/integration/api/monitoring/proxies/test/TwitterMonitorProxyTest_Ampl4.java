package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.TwitterMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class TwitterMonitorProxyTest_Ampl4 {
    private static TwitterMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        TwitterMonitorProxyTest_Ampl4.proxy = new TwitterMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        TwitterMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
        TwitterMonitorConfiguration conf = createMonitorConfiguration();
        TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        HttpStatus o_testCreateAndDeleteMonitorConfiguration_add1__9 = TwitterMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).toString());
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKeywordExpression());
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull28_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            TwitterMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull28 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull29_failAssert0() throws Exception {
        try {
            TwitterMonitorConfiguration conf = createMonitorConfiguration();
            TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            notNull(null);
            isTrue(((result.getId()) > 0));
            TwitterMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull29 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_add1060() throws Exception {
        TwitterMonitorConfiguration o_testUpdateMonitorConfiguration_add1060__1 = createMonitorConfiguration();
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testUpdateMonitorConfiguration_add1060__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getKeywordExpression());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getId());
        TwitterMonitorConfiguration conf = createMonitorConfiguration();
        TwitterMonitorConfiguration result = TwitterMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        notNull(result);
        notNull(result);
        result.setTimeSlot(60);
        result = TwitterMonitorProxyTest_Ampl4.proxy.updateMonitorConfiguration(result);
        isTrue(((result.getTimeSlot()) == 60));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration)o_testUpdateMonitorConfiguration_add1060__1).getAccounts().contains("QuimMotger"));
        Assert.assertEquals("(tweet OR follow) AND (me)", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getKeywordExpression());
        Assert.assertEquals(30, ((int) (((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getTimeSlot())));
        Assert.assertEquals("TwitterAPI", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getToolName());
        Assert.assertEquals("tweeterMonitoring", ((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getKafkaTopic());
        Assert.assertNull(((TwitterMonitorConfiguration) (o_testUpdateMonitorConfiguration_add1060__1)).getId());
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

