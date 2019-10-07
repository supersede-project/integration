package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile;
import eu.supersede.integration.api.monitoring.monitors.proxies.ConfigurationFileHttpMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.springframework.util.Assert.notNull;


public class ConfigurationFileHttpMonitorProxyTest {
    private static ConfigurationFileHttpMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        ConfigurationFileHttpMonitorProxyTest.proxy = new ConfigurationFileHttpMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfiguration_add1() throws Exception {
        HttpMonitorConfigurationFile o_testCreateMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertEquals("production", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getServer());
        Assert.assertEquals(150, ((int) (((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getTextContentSize())));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("change"));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("input"));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("submit"));
        Assert.assertNull(((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getTimeSlot());
        Assert.assertEquals("HTTPS", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getProtocol());
        Assert.assertEquals("HTMLMonitor", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("http", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getId());
        HttpMonitorConfigurationFile conf = createMonitorConfiguration();
        HttpMonitorConfigurationFile result = ConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(conf);
        notNull(result);
        Assert.assertEquals("production", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getServer());
        Assert.assertEquals(150, ((int) (((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getTextContentSize())));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("change"));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("input"));
        Assert.assertTrue(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile)o_testCreateMonitorConfiguration_add1__1).getListOfEvents().contains("submit"));
        Assert.assertNull(((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getTimeSlot());
        Assert.assertEquals("HTTPS", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getProtocol());
        Assert.assertEquals("HTMLMonitor", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getToolName());
        Assert.assertEquals("http", ((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getKafkaTopic());
        Assert.assertNull(((HttpMonitorConfigurationFile) (o_testCreateMonitorConfiguration_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull15_failAssert0() throws Exception {
        try {
            HttpMonitorConfigurationFile conf = createMonitorConfiguration();
            HttpMonitorConfigurationFile result = ConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(null);
            notNull(result);
            org.junit.Assert.fail("testCreateMonitorConfigurationnull15 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull16_failAssert0() throws Exception {
        try {
            HttpMonitorConfigurationFile conf = createMonitorConfiguration();
            HttpMonitorConfigurationFile result = ConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(conf);
            notNull(null);
            org.junit.Assert.fail("testCreateMonitorConfigurationnull16 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    private HttpMonitorConfigurationFile createMonitorConfiguration() throws MalformedURLException {
        HttpMonitorConfigurationFile conf = new HttpMonitorConfigurationFile();
        conf.setToolName("HTMLMonitor");
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setKafkaTopic("http");
        conf.setServer("production");
        conf.setProtocol("HTTPS");
        conf.setTextContentSize(150);
        conf.setListOfEvents(Arrays.asList("change", "input", "submit"));
        return conf;
    }
}

