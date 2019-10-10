package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotWritableException;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class GooglePlayMonitorProxyTest_Ampl4 {
    private static GooglePlayMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        GooglePlayMonitorProxyTest_Ampl4.proxy = new GooglePlayMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        GooglePlayMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertEquals("com.facebook.katana", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getPackageName());
        Assert.assertEquals(30, ((int) (((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
        GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
        GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        HttpStatus o_testCreateAndDeleteMonitorConfiguration_add1__9 = GooglePlayMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteMonitorConfiguration_add1__9)).toString());
        Assert.assertEquals("com.facebook.katana", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getPackageName());
        Assert.assertEquals(30, ((int) (((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((GooglePlayMonitorConfiguration) (o_testCreateAndDeleteMonitorConfiguration_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull26_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            GooglePlayMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull26 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfigurationnull27_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            notNull(null);
            isTrue(((result.getId()) > 0));
            GooglePlayMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationnull27 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteMonitorConfiguration_add1_add116null452_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1_add116__1 = createMonitorConfiguration();
            GooglePlayMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(null);
            notNull(result);
            isTrue(((result.getId()) > 0));
            HttpStatus o_testCreateAndDeleteMonitorConfiguration_add1__9 = GooglePlayMonitorProxyTest_Ampl4.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfiguration_add1_add116null452 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorConfigurationRequest[\"id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_add610() throws Exception {
        GooglePlayMonitorConfiguration o_testUpdateMonitorConfiguration_add610__1 = createMonitorConfiguration();
        Assert.assertEquals("com.facebook.katana", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getPackageName());
        Assert.assertEquals(30, ((int) (((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getKafkaTopic());
        Assert.assertNull(((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getId());
        GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
        GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
        notNull(result);
        notNull(result);
        result.setTimeSlot(60);
        result = GooglePlayMonitorProxyTest_Ampl4.proxy.updateMonitorConfiguration(result);
        isTrue(((result.getTimeSlot()) == 60));
        Assert.assertEquals("com.facebook.katana", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getPackageName());
        Assert.assertEquals(30, ((int) (((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getTimeSlot())));
        Assert.assertEquals("AppTweak", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getToolName());
        Assert.assertEquals("MarketPlace", ((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getKafkaTopic());
        Assert.assertNull(((GooglePlayMonitorConfiguration) (o_testUpdateMonitorConfiguration_add610__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfiguration_literalMutationNumber622_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            notNull(result);
            notNull(result);
            result.setTimeSlot(0);
            result = GooglePlayMonitorProxyTest_Ampl4.proxy.updateMonitorConfiguration(result);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber622 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateMonitorConfigurationnull650_failAssert0() throws Exception {
        try {
            GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
            GooglePlayMonitorConfiguration result = GooglePlayMonitorProxyTest_Ampl4.proxy.createMonitorConfiguration(conf);
            notNull(result);
            notNull(result);
            result.setTimeSlot(60);
            result = GooglePlayMonitorProxyTest_Ampl4.proxy.updateMonitorConfiguration(null);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfigurationnull650 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
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

