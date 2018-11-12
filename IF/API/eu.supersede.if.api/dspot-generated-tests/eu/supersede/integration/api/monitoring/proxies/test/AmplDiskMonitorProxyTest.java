package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Instruction;
import eu.supersede.integration.api.monitoring.monitors.proxies.DiskMonitorProxy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class AmplDiskMonitorProxyTest {
    private static DiskMonitorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplDiskMonitorProxyTest.proxy = new DiskMonitorProxy<Object, Object>();
    }

    private DiskMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
        DiskMonitorConfiguration conf = new DiskMonitorConfiguration();
        conf.setToolName("JSchTool");
        conf.setTimeSlot(2);
        conf.setKafkaEndpoint(new URL("http://localhost:9092"));
        conf.setKafkaTopic("disk");
        conf.setUser("supersede");
        conf.setHost("tools.supersede.atos-sports.tv");
        conf.setInstructions(new ArrayList<Instruction>() {
            {
                add(new Instruction("test-instruction", "snmpdf -v2c -c supersede.ovp prt.tbs"));
            }
        });
        return conf;
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1() throws Exception {
        DiskMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getAuthority());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toString());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getFile());
        Assert.assertEquals("disk", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaTopic());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getId());
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getPort())));
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals("tools.supersede.atos-sports.tv", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getHost());
        Assert.assertEquals("supersede", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getUser());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getPath());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals(2, ((int) (((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getTimeSlot())));
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).hashCode())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getRef());
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getInstructions()).isEmpty());
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getHost());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertEquals("JSchTool", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getToolName());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getProtocol());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).getQuery());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getInstructions()).size())));
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).isOpaque());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        DiskMonitorConfiguration conf = createMonitorConfiguration();
        DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplDiskMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1_add83() throws Exception {
        DiskMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1_add83__1 = createMonitorConfiguration();
        Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getPort())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getLastModified())));
        Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).hashCode())));
        Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getScheme());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getAuthority());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getRef());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
        Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getHost());
        Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getId());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getQuery());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawFragment());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getDoInput());
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getFile());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawUserInfo());
        Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getContentLength())));
        Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getUseCaches());
        Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getDefaultPort())));
        Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getPath());
        Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).hashCode())));
        Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).toString());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getInstructions()).size())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).toASCIIString());
        Assert.assertEquals(2, ((int) (((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getTimeSlot())));
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getFragment());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getUserInfo());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
        Assert.assertEquals("supersede", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getUser());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getQuery());
        Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawAuthority());
        Assert.assertEquals("tools.supersede.atos-sports.tv", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getHost());
        Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getProtocol());
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toString());
        Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getPort())));
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getInstructions()).isEmpty());
        Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getHost());
        Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getReadTimeout())));
        Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toExternalForm());
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getDate())));
        Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getExpiration())));
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
        Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).isAbsolute());
        Assert.assertEquals("JSchTool", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getToolName());
        Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
        Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getUserInfo());
        Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).toString());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getPath());
        Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getDoOutput());
        Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawQuery());
        Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
        Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).getAuthority());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getContentEncoding());
        Assert.assertEquals("disk", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaTopic());
        Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).openConnection()).getContentType());
        Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).getRawPath());
        Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1_add83__1).getKafkaEndpoint()).toURI()).isOpaque());
        DiskMonitorConfiguration o_testCreateAndDeleteMonitorConfiguration_add1__1 = createMonitorConfiguration();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add83__5 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add83__5);
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_add83__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_add83__6);
        DiskMonitorConfiguration conf = createMonitorConfiguration();
        DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplDiskMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1_sd96() throws Exception {
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_sd96__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_sd96__7);
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_sd96__8 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        Assert.assertTrue(o_testCreateAndDeleteMonitorConfiguration_add1_sd96__8);
        DiskMonitorConfiguration conf = createMonitorConfiguration();
        DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplDiskMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        createMonitorConfiguration().setInstructions(Collections.singletonList(new Instruction("[T]e_+S#i]w!maZJcf{Y", "<x-zr2#$hDLf,#+w{NUw")));
    }

    @Test(timeout = 120000)
    public void testCreateAndDeleteMonitorConfiguration_add1_sd96_sd221() throws Exception {
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_sd96__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
        boolean o_testCreateAndDeleteMonitorConfiguration_add1_sd96__8 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testCreateAndDeleteMonitorConfiguration_add1__1).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
        DiskMonitorConfiguration conf = createMonitorConfiguration();
        DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(conf);
        notNull(result);
        isTrue(((result.getId()) > 0));
        AmplDiskMonitorProxyTest.proxy.deleteMonitorConfiguration(conf);
        createMonitorConfiguration().setInstructions(Collections.singletonList(new Instruction("[T]e_+S#i]w!maZJcf{Y", "<x-zr2#$hDLf,#+w{NUw")));
        Assert.assertEquals("tools.supersede.atos-sports.tv", conf.getHost());
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0() throws Exception {
        try {
            DiskMonitorConfiguration conf = createMonitorConfiguration();
            DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(4);
            Thread.sleep(5000);
            result = AmplDiskMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 3));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber483 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574() throws Exception {
        try {
            DiskMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3 = createMonitorConfiguration();
            Assert.assertEquals("localhost", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getHost());
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getConnectTimeout())));
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getIfModifiedSince())));
            Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getInstructions()).isEmpty());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getUserInfo());
            Assert.assertEquals("http", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getProtocol());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getFragment());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getLastModified())));
            Assert.assertEquals("http", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getScheme());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getUserInfo());
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getFile());
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawSchemeSpecificPart());
            Assert.assertEquals(2, ((int) (((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getTimeSlot())));
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getAllowUserInteraction());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawAuthority());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getDefaultUseCaches());
            Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getInstructions()).size())));
            Assert.assertTrue(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).isAbsolute());
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getPath());
            Assert.assertFalse(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).isOpaque());
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getContentType());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getUseCaches());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).toString());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getQuery());
            Assert.assertNull(((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getId());
            Assert.assertEquals(-1, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getContentLength())));
            Assert.assertEquals("JSchTool", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getToolName());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getExpiration())));
            Assert.assertEquals(2133928973, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).hashCode())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getDoInput());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawUserInfo());
            Assert.assertEquals(-1110591729, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).hashCode())));
            Assert.assertEquals(0, ((int) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getReadTimeout())));
            Assert.assertEquals("sun.net.www.protocol.http.HttpURLConnection:http://localhost:9092", ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).toString());
            Assert.assertEquals("localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getAuthority());
            Assert.assertEquals(-1L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getContentLengthLong())));
            Assert.assertFalse(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getDoOutput());
            Assert.assertNull(((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getRef());
            Assert.assertEquals(9092, ((int) (((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getPort())));
            Assert.assertNull(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getContentEncoding());
            Assert.assertEquals("", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawPath());
            Assert.assertEquals("tools.supersede.atos-sports.tv", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getHost());
            Assert.assertEquals("", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getPath());
            Assert.assertEquals(80, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getDefaultPort())));
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty());
            Assert.assertEquals("localhost", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getHost());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawQuery());
            Assert.assertEquals(0L, ((long) (((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getDate())));
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getQuery());
            Assert.assertEquals("supersede", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getUser());
            Assert.assertEquals("http://localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).toASCIIString());
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toExternalForm());
            Assert.assertNull(((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getRawFragment());
            Assert.assertEquals(9092, ((int) (((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getPort())));
            Assert.assertEquals("localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).getAuthority());
            Assert.assertTrue(((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty());
            Assert.assertEquals("disk", ((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaTopic());
            Assert.assertEquals("http://localhost:9092", ((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toString());
            Assert.assertEquals("//localhost:9092", ((java.net.URI)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).toURI()).getSchemeSpecificPart());
            DiskMonitorConfiguration conf = createMonitorConfiguration();
            DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(4);
            Thread.sleep(5000);
            result = AmplDiskMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 3));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber483 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd711() throws Exception {
        try {
            DiskMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3 = createMonitorConfiguration();
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd711__6 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd711__6);
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd711__7 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd711__7);
            DiskMonitorConfiguration conf = createMonitorConfiguration();
            DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(createMonitorConfiguration());
            notNull(result);
            result.setTimeSlot(4);
            Thread.sleep(5000);
            result = AmplDiskMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 3));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber483 should have thrown IllegalArgumentException");
            createMonitorConfiguration().getHost();
        } catch (IllegalArgumentException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721() throws Exception {
        try {
            List<Instruction> __DSPOT_instructions_160 = Collections.singletonList(new Instruction("UhwIbR]FMwAeMp&sZ9q!", "M32Z7w;!lr:)EfUW+}=M"));
            DiskMonitorConfiguration o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3 = createMonitorConfiguration();
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721__9 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getRequestProperties().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721__9);
            boolean o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721__10 = ((java.net.URLConnection)((java.net.URL)((eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration)o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574__3).getKafkaEndpoint()).openConnection()).getHeaderFields().isEmpty();
            Assert.assertTrue(o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721__10);
            DiskMonitorConfiguration conf = createMonitorConfiguration();
            DiskMonitorConfiguration result = AmplDiskMonitorProxyTest.proxy.createMonitorConfiguration(conf);
            notNull(result);
            result.setTimeSlot(4);
            Thread.sleep(5000);
            result = AmplDiskMonitorProxyTest.proxy.updateMonitorConfiguration(result);
            notNull(result);
            isTrue(((result.getTimeSlot()) == 3));
            org.junit.Assert.fail("testUpdateMonitorConfiguration_literalMutationNumber483 should have thrown IllegalArgumentException");
            conf.setInstructions(Collections.singletonList(new Instruction("UhwIbR]FMwAeMp&sZ9q!", "M32Z7w;!lr:)EfUW+}=M")));
        } catch (IllegalArgumentException expected) {
            String o_testUpdateMonitorConfiguration_literalMutationNumber483_failAssert0_add574_sd721__28 = expected.getMessage();
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }
}

