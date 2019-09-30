package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageNotWritableException;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class AppStoreMonitorProxyTest_Ampl2 {
    private static AppStoreMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AppStoreMonitorProxyTest_Ampl2.proxy = new AppStoreMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertEquals("567630281", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getappId());
        Assert.assertEquals(30, ((int) (((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AppStoreMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("567630281", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getappId());
        Assert.assertEquals(30, ((int) (((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((AppStoreMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull16_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            AppStoreMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull16 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull17_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
            notNull(null);
            isTrue(((result.getId()) > 0));
            AppStoreMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull17 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1null126_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            AppStoreMonitorProxyTest_Ampl2.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfiguration_add1null126 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_add497() throws Exception {
        AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_add497__1 = createMonitorConfiguration();
        Assert.assertEquals("567630281", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getappId());
        Assert.assertEquals(30, ((int) (((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getTimeSlot())));
        Assert.assertEquals("MarketPlace", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getKafkaTopic());
        Assert.assertEquals("AppTweak", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getToolName());
        Assert.assertNull(((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getId());
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
        notNull(result);
        notNull(result);
        result.setTimeSlot(60);
        result = AppStoreMonitorProxyTest_Ampl2.proxy.updateMonitorConfiguration(result);
        isTrue(((result.getTimeSlot()) == 60));
        Assert.assertEquals("567630281", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getappId());
        Assert.assertEquals(30, ((int) (((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getTimeSlot())));
        Assert.assertEquals("MarketPlace", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getKafkaTopic());
        Assert.assertEquals("AppTweak", ((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getToolName());
        Assert.assertNull(((AppStoreMonitorConfiguration) (o_testUpdateMonitorConfiguration_add497__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_literalMutationNumber509_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
            notNull(result);
            notNull(result);
            result.setTimeSlot(0);
            result = AppStoreMonitorProxyTest_Ampl2.proxy.updateMonitorConfiguration(result);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber509 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull537_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AppStoreMonitorProxyTest_Ampl2.proxy.createMonitorConfiguration(conf);
            notNull(result);
            notNull(result);
            result.setTimeSlot(60);
            result = AppStoreMonitorProxyTest_Ampl2.proxy.updateMonitorConfiguration(null);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull537 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
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

