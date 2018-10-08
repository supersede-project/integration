package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.monitors.proxies.HttpMonitorProxy;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collections;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class AmplHttpMonitorProxyTest {
    private static HttpMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplHttpMonitorProxyTest.proxy = new HttpMonitorProxy<Object, Object>();
    }

    @Ignore
    @Test
    public void testCreateAndDeleteMonitorConfiguration() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Ignore
    @Test
    public void testUpdateMonitorConfiguration() throws Exception {
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        Assert.notNull(result);
        result.setTimeSlot(6000);
        result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        Assert.notNull(result);
        Assert.isTrue(((result.getTimeSlot()) == 6000));
    }

    private HttpMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        HttpMonitorConfiguration conf = new HttpMonitorConfiguration();
        conf.setToolName("ApacheHttp");
        conf.setTimeSlot(3000);
        conf.setKafkaTopic("HttpTopic");
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setUrl("http://lab-supersede.atos-sports.tv:8000/handshake_test.php");
        conf.setMethod(Method.GET);
        return conf;
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_add1() throws Exception {
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1 = createMonitorConfiguration();
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getDate())));
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toExternalForm());
        assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).hashCode())));
        assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getMethod()).name());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawFragment());
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getToolName());
        assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getMethod()).ordinal())));
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).toASCIIString());
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getPath());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).toString());
        assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getProtocol());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).toString());
        assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaTopic());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getQuery());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).isOpaque());
        assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getPort())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawQuery());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getDoInput());
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawPath());
        assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getPort())));
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getUserInfo());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getAuthority());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getQuery());
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getPath());
        assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).hashCode())));
        assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).isAbsolute());
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getContentType());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getRef());
        assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getUrl());
        assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getUserInfo());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getFragment());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getFile());
        assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getHost());
        assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getAuthority());
        assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getTimeSlot())));
        assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getDefaultPort())));
        assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).getHost());
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toString());
        assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getId());
        assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).toURI()).getScheme());
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString27_failAssert10() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "httpStress");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("src/test/resources/files", "httpStress"));
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString27 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/files/httpStress", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_add1_add116() throws Exception {
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1 = createMonitorConfiguration();
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toString());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getRef());
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getFile());
        assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getTimeSlot())));
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getDate())));
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getPath());
        assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getToolName());
        assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).isOpaque());
        assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaTopic());
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).toASCIIString());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getMethod()).name());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getHost());
        assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getPort())));
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).toString());
        assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).hashCode())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getUserInfo());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getFragment());
        assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).isAbsolute());
        assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getScheme());
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawPath());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getQuery());
        assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getId());
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getPath());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawQuery());
        assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getProtocol());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getContentType());
        assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).toString());
        assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getMethod()).ordinal())));
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getAuthority());
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toExternalForm());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).hashCode())));
        assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getUrl());
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getQuery());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getDoInput());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getDefaultPort())));
        assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getPort())));
        assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getHost());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getUserInfo());
        assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).getAuthority());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).toURI()).getRawFragment());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__5);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__6);
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__18 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__18);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__19 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__19);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__20 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__20);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__21 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__21);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110() throws Exception {
        try {
            HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3 = createMonitorConfiguration();
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getQuery());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getRef());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawQuery());
            assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getAuthority());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getDate())));
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getUserInfo());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawPath());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getFragment());
            assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getUrl());
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getDoInput());
            assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).hashCode())));
            assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getDefaultPort())));
            assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).isOpaque());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).toString());
            assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getPort())));
            assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getScheme());
            assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getContentType());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getPath());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toExternalForm());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getPort())));
            assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getMethod()).ordinal())));
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getProtocol());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getFile());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaTopic());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getQuery());
            assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).hashCode())));
            assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getHost());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getPath());
            assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getMethod()).name());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getAuthority());
            assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getTimeSlot())));
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toString());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawFragment());
            assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getToolName());
            assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).toString());
            assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getId());
            assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getHost());
            assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).isAbsolute());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).toASCIIString());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).getUserInfo());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__17 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add112() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            FileSystems.getDefault().getPath("", "list1s.txt");
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add112__18 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492() throws Exception {
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1 = createMonitorConfiguration();
        assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).isAbsolute());
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).toString());
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getPath());
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawFragment());
        assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getPort())));
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawPath());
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toExternalForm());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getDate())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getFragment());
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getDefaultPort())));
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getPath());
        assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getUrl());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getUserInfo());
        assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getToolName());
        assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getTimeSlot())));
        assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).toString());
        assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getId());
        assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getMethod()).ordinal())));
        assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getProtocol());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).isOpaque());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getQuery());
        assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).hashCode())));
        assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getScheme());
        assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getAuthority());
        assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getHost());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getDoInput());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getPort())));
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getFile());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getUserInfo());
        assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getMethod()).name());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getContentType());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getQuery());
        assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getAuthority());
        assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getHost());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).getRef());
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toString());
        assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaTopic());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawQuery());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).toASCIIString());
        assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).hashCode())));
        assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__5);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__6);
        HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        HttpMonitorConfiguration conf = createMonitorConfiguration();
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
        Assert.notNull(result);
        Assert.isTrue(((result.getId()) > 0));
        AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__18 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__19 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__20 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__21 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__39 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__39);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__40 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__40);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__41 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__41);
        boolean o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__42 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_add1_add116_add492__42);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489() throws Exception {
        try {
            HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3 = createMonitorConfiguration();
            assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getToolName());
            assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).hashCode())));
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getDate())));
            assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getDefaultPort())));
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getPath());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getQuery());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).isAbsolute());
            assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getMethod()).ordinal())));
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawFragment());
            assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getMethod()).name());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getAuthority());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).toString());
            assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getPort())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).toASCIIString());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getQuery());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getFragment());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getRef());
            assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaTopic());
            assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).isOpaque());
            assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getHost());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getUserInfo());
            assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).hashCode())));
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getUserInfo());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawQuery());
            assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getId());
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getDoInput());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toExternalForm());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).toString());
            assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getHost());
            assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getPort())));
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toString());
            assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getTimeSlot())));
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getRawPath());
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getContentType());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getUrl());
            assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getAuthority());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getProtocol());
            assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getScheme());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).toURI()).getPath());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__3).getKafkaEndpoint()).getFile());
            HttpMonitorConfiguration o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3 = createMonitorConfiguration();
            boolean o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__7);
            boolean o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__8 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            assertTrue(o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110_add489__8);
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            Assert.isTrue(((result.getId()) > 0));
            AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add110__17 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add112_literalMutationString563_failAssert39() throws Exception {
        try {
            try {
                HttpMonitorConfiguration conf = createMonitorConfiguration();
                FileSystems.getDefault().getPath("", "list1s.txt");
                Path file = FileSystems.getDefault().getPath("", "");
                HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(conf, FileSystems.getDefault().getPath("", ""));
                Assert.notNull(result);
                Assert.isTrue(((result.getId()) > 0));
                AmplHttpMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
                org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17 should have thrown NoSuchFileException");
            } catch (NoSuchFileException expected) {
                String o_testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add112__18 = expected.getMessage();
            }
            org.junit.Assert.fail("testCreateAndDeleteMonitorConfigurationMultipart_literalMutationString17_failAssert0_add112_literalMutationString563 should have thrown IOException");
        } catch (IOException expected_1) {
            assertEquals("Is a directory", expected_1.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_add965() throws Exception {
        HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add965__1 = createMonitorConfiguration();
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toString());
        assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getScheme());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawQuery());
        assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getDefaultPort())));
        assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getToolName());
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getPath());
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).toString());
        assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).isOpaque());
        assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getUserInfo());
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawPath());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getQuery());
        assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).hashCode())));
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getHost());
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaTopic());
        assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toExternalForm());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getDate())));
        assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getId());
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getContentType());
        assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getPort())));
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).toASCIIString());
        assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getMethod()).name());
        assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getMethod()).ordinal())));
        assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getFile());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getRef());
        assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getTimeSlot())));
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).toString());
        assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getPath());
        assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getAuthority());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getDoInput());
        assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).hashCode())));
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getFragment());
        assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getQuery());
        assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getPort())));
        assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).isAbsolute());
        assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getAuthority());
        assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).getProtocol());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getRawFragment());
        assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getUserInfo());
        assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getUrl());
        assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).toURI()).getHost());
        assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
        Assert.notNull(result);
        result.setTimeSlot(6000);
        result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
        Assert.notNull(result);
        Assert.isTrue(((result.getTimeSlot()) == 6000));
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationString983 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationString991_failAssert48() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "j.pbZs?{yo");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("src/test/resources/files", "j.pbZs?{yo"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationString991 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("src/test/resources/files/j.pbZs?{yo", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationNumber995_failAssert52() throws Exception {
        try {
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(0);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationNumber995 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3 = createMonitorConfiguration();
            assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).hashCode())));
            assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getHost());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getFragment());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getUserInfo());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawPath());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getMethod()).ordinal())));
            assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).isAbsolute());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).toASCIIString());
            assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getPort())));
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getQuery());
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getRef());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getQuery());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getPath());
            assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaTopic());
            assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getUrl());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawFragment());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).toString());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toExternalForm());
            assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).isOpaque());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getAuthority());
            assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getId());
            assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getDefaultPort())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toString());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getDate())));
            assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getHost());
            assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).toString());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getFile());
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getTimeSlot())));
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getAuthority());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getDoInput());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getScheme());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getUserInfo());
            assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getPort())));
            assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getContentType());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getPath());
            assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).hashCode())));
            assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getMethod()).name());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).getProtocol());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).toURI()).getRawQuery());
            assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getToolName());
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationString983 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__20 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_add965_literalMutationString1243_failAssert62() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_add965__1 = createMonitorConfiguration();
            ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_add965__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_add965_literalMutationString1243 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3 = createMonitorConfiguration();
            assertEquals("http://lab-supersede.atos-sports.tv:8000/handshake_test.php", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getUrl());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getProtocol());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getDoInput());
            assertEquals("ApacheHttp", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getToolName());
            assertEquals(0, ((int) (((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getMethod()).ordinal())));
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawFragment());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getAuthority());
            assertNull(((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getId());
            assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).hashCode())));
            assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).isAbsolute());
            assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getDefaultPort())));
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getPath());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getQuery());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getRef());
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).toString());
            assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).isOpaque());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toExternalForm());
            assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawPath());
            assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getHost());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getUserInfo());
            assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getAuthority());
            assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getUserInfo());
            assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getPort())));
            assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getHost());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawQuery());
            assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).toString());
            assertEquals(3000, ((int) (((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getTimeSlot())));
            assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getPort())));
            assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).toASCIIString());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getFragment());
            assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getContentType());
            assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toString());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getPath());
            assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getScheme());
            assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).getFile());
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getDate())));
            assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).getQuery());
            assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaEndpoint()).toURI()).hashCode())));
            assertEquals("GET", ((eu.supersede.integration.api.monitoring.manager.types.Method)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getMethod()).name());
            assertEquals("HttpTopic", ((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__3).getKafkaTopic());
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3 = createMonitorConfiguration();
            boolean o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            assertTrue(o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__7);
            boolean o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__8 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            assertTrue(o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_add1698__8);
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationString983 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__20 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_literalMutationString1764() throws Exception {
        try {
            HttpMonitorConfiguration o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3 = createMonitorConfiguration();
            boolean o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_literalMutationString1764__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            assertTrue(o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_literalMutationString1764__6);
            boolean o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_literalMutationString1764__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration)o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            assertTrue(o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099_literalMutationString1764__7);
            HttpMonitorConfiguration conf = createMonitorConfiguration();
            Path file = FileSystems.getDefault().getPath("", "list1s.txt");
            HttpMonitorConfiguration result = AmplHttpMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration(), FileSystems.getDefault().getPath("", "list1s.txt"));
            Assert.notNull(result);
            result.setTimeSlot(6000);
            result = AmplHttpMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            Assert.notNull(result);
            Assert.isTrue(((result.getTimeSlot()) == 6000));
            org.junit.Assert.fail("testUpdateMonitorConfigurationMultipart_literalMutationString983 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            String o_testUpdateMonitorConfigurationMultipart_literalMutationString983_failAssert40_add1099__20 = expected.getMessage();
            assertEquals("list1s.txt", expected.getMessage());
        }
    }
}

