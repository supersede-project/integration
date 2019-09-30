package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile;
import eu.supersede.integration.api.monitoring.monitors.proxies.ConfigurationFileHttpMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;


public class AmplConfigurationFileHttpMonitorProxyTest {
    private static ConfigurationFileHttpMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplConfigurationFileHttpMonitorProxyTest.proxy = new ConfigurationFileHttpMonitorProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull11_failAssert0() throws Exception {
        try {
            HttpMonitorConfigurationFile conf = createMonitorConfiguration();
            HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(null);
            Assert.notNull(result);
            org.junit.Assert.fail("testCreateMonitorConfigurationnull11 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull12_failAssert1() throws Exception {
        try {
            HttpMonitorConfigurationFile conf = createMonitorConfiguration();
            HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(conf);
            Assert.notNull(null);
            org.junit.Assert.fail("testCreateMonitorConfigurationnull12 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull11_failAssert0_mg53_failAssert2() throws Exception {
        try {
            {
                List<String> __DSPOT_listOfEvents_16 = Collections.singletonList("h`l V!3a(!.#b{[Iz>YS");
                HttpMonitorConfigurationFile conf = createMonitorConfiguration();
                HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(null);
                Assert.notNull(result);
                org.junit.Assert.fail("testCreateMonitorConfigurationnull11 should have thrown IllegalArgumentException");
                conf.setListOfEvents(__DSPOT_listOfEvents_16);
            }
            org.junit.Assert.fail("testCreateMonitorConfigurationnull11_failAssert0_mg53 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull12_failAssert1_mg47_failAssert13() throws Exception {
        try {
            {
                List<String> __DSPOT_listOfEvents_10 = Collections.singletonList("cvg[?i!rb0/|]6^FT)-e");
                HttpMonitorConfigurationFile conf = createMonitorConfiguration();
                HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(conf);
                Assert.notNull(null);
                org.junit.Assert.fail("testCreateMonitorConfigurationnull12 should have thrown IllegalArgumentException");
                conf.setListOfEvents(__DSPOT_listOfEvents_10);
            }
            org.junit.Assert.fail("testCreateMonitorConfigurationnull12_failAssert1_mg47 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull11_failAssert0_mg53_failAssert2litString116_failAssert24() throws Exception {
        try {
            {
                {
                    List<String> __DSPOT_listOfEvents_16 = Collections.singletonList("change");
                    HttpMonitorConfigurationFile conf = createMonitorConfiguration();
                    HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(null);
                    Assert.notNull(result);
                    org.junit.Assert.fail("testCreateMonitorConfigurationnull11 should have thrown IllegalArgumentException");
                    conf.setListOfEvents(__DSPOT_listOfEvents_16);
                }
                org.junit.Assert.fail("testCreateMonitorConfigurationnull11_failAssert0_mg53 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateMonitorConfigurationnull11_failAssert0_mg53_failAssert2litString116 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid monitor configuration", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateMonitorConfigurationnull12_failAssert1_mg47_failAssert13litString113_failAssert35() throws Exception {
        try {
            {
                {
                    List<String> __DSPOT_listOfEvents_10 = Collections.singletonList("production");
                    HttpMonitorConfigurationFile conf = createMonitorConfiguration();
                    HttpMonitorConfigurationFile result = AmplConfigurationFileHttpMonitorProxyTest.proxy.createHTMLMonitorConfigurationFile(conf);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testCreateMonitorConfigurationnull12 should have thrown IllegalArgumentException");
                    conf.setListOfEvents(__DSPOT_listOfEvents_10);
                }
                org.junit.Assert.fail("testCreateMonitorConfigurationnull12_failAssert1_mg47 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateMonitorConfigurationnull12_failAssert1_mg47_failAssert13litString113 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
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

