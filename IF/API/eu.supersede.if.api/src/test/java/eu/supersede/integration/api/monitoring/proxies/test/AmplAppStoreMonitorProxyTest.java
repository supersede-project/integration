package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.AppStoreMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class AmplAppStoreMonitorProxyTest {
    private static AppStoreMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplAppStoreMonitorProxyTest.proxy = new AppStoreMonitorProxy<Object, Object>();
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

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getId());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).hashCode())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getRef());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getappId());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaTopic());
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getHost());
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getPort())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toString());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getAuthority());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getProtocol());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getToolName());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getTimeSlot())));
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getFile());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getQuery());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getPath());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).hashCode())));
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplAppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1_add54() throws Exception {
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1_add54__1 = createMonitorConfiguration();
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getPort())));
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toString());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getRef());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getQuery());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getHost());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaTopic());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getProtocol());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getappId());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getId());
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getToolName());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).hashCode())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getTimeSlot())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getAuthority());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getFile());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).getPath());
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add54__5);
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add54__6);
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplAppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1_add54_add127() throws Exception {
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1 = createMonitorConfiguration();
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getPort())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getHost());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toString());
        Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getTimeSlot())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).hashCode())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getRef());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getQuery());
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getPath());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getId());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getFile());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getappId());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getAuthority());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getProtocol());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaTopic());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__1).getToolName());
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1_add54__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__5);
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add54__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add54_add127__6);
        AppStoreMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add54__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        AppStoreMonitorConfiguration conf = createMonitorConfiguration();
        AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplAppStoreMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_add220() throws Exception {
        AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_add220__1 = createMonitorConfiguration();
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toString());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getId());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getRef());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getPath());
        Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getappId());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getFile());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).hashCode())));
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getQuery());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getHost());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaTopic());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getAuthority());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getTimeSlot())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getToolName());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getProtocol());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).getPort())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
        notNull(result);
        result.setTimeSlot(60);
        result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        notNull(result);
        isTrue(((result.getTimeSlot()) == 60));
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0() throws Exception {
        try {
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(0);
            result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber232 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_add220_add298() throws Exception {
        AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_add220_add298__1 = createMonitorConfiguration();
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getPath());
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).hashCode())));
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getToolName());
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getPort())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaTopic());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getQuery());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getTimeSlot())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toString());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getFile());
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getId());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getAuthority());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getRef());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getappId());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getProtocol());
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).getHost());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220_add298__1).getKafkaEndpoint()).toURI()).isAbsolute());
        AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_add220__1 = createMonitorConfiguration();
        boolean o_testUpdateMonitorConfiguration_add220_add298__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        Assert.assertTrue(o_testUpdateMonitorConfiguration_add220_add298__5);
        boolean o_testUpdateMonitorConfiguration_add220_add298__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_add220__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        Assert.assertTrue(o_testUpdateMonitorConfiguration_add220_add298__6);
        AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
        notNull(result);
        result.setTimeSlot(60);
        result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        notNull(result);
        isTrue(((result.getTimeSlot()) == 60));
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297() throws Exception {
        try {
            AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3 = createMonitorConfiguration();
            Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).isOpaque());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).toString());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getDate())));
            Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaTopic());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getUserInfo());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawFragment());
            Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getToolName());
            Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).hashCode())));
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getDoInput());
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getRef());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawQuery());
            Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getProtocol());
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getPath());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getQuery());
            Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).hashCode())));
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getFile());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getContentType());
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getPath());
            Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getPort())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getDefaultPort())));
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawPath());
            Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getTimeSlot())));
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getFragment());
            Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getHost());
            Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getId());
            Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getHost());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).toASCIIString());
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getPort())));
            Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getappId());
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toString());
            Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).isAbsolute());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getAuthority());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getAuthority());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toExternalForm());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).getQuery());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getUserInfo());
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).toString());
            Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).toURI()).getScheme());
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(0);
            result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber232 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462() throws Exception {
        try {
            AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3 = createMonitorConfiguration();
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getProtocol());
            Assert.assertEquals("MarketPlace", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaTopic());
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getPath());
            Assert.assertEquals("567630281", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getappId());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawPath());
            Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).isAbsolute());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getUserInfo());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getDate())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getDoInput());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).toASCIIString());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getUserInfo());
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getRef());
            Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).hashCode())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getHost());
            Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getAuthority());
            Assert.assertEquals(30, ((int) (((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getTimeSlot())));
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getPort())));
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getQuery());
            Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).hashCode())));
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getFile());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getPath());
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getQuery());
            Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getId());
            Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toString());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawQuery());
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).isOpaque());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).toString());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getAuthority());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getFragment());
            Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getHost());
            Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getPort())));
            Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).getDefaultPort())));
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawFragment());
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).toString());
            Assert.assertEquals("AppTweak", ((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getToolName());
            Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getScheme());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).openConnection()).getContentType());
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__3).getKafkaEndpoint()).toExternalForm());
            AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3 = createMonitorConfiguration();
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__7);
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__8 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_add462__8);
            AppStoreMonitorConfiguration conf = createMonitorConfiguration();
            AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(0);
            result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 60));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber232 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_literalMutationNumber493_failAssert10() throws Exception {
        try {
            try {
                AppStoreMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3 = createMonitorConfiguration();
                ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
                ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
                AppStoreMonitorConfiguration conf = createMonitorConfiguration();
                AppStoreMonitorConfiguration result = AmplAppStoreMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
                notNull(result);
                result.setTimeSlot(1);
                result = AmplAppStoreMonitorProxyTest.proxy.updateMonitorConfiguration(result);
                notNull(result);
                isTrue(((result.getTimeSlot()) == 60));
                org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber232 should have thrown NullPointerException");
            } catch (NullPointerException expected) {
                expected.getMessage();
            }
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber232_failAssert0_add297_literalMutationNumber493 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected_1) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected_1.getMessage());
        }
    }
}

