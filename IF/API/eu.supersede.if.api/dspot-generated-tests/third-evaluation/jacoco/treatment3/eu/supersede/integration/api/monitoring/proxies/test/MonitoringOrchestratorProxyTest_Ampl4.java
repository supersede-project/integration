package eu.supersede.integration.api.monitoring.proxies.test;


import eu.supersede.integration.api.monitoring.orchestrator.proxies.MonitoringOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorTool;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorType;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;


public class MonitoringOrchestratorProxyTest {
    private static MonitoringOrchestratorProxy<?, ?> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        String user = "superadmin";
        String password = "password";
        MonitoringOrchestratorProxyTest.proxy = new MonitoringOrchestratorProxy<Object, Object>(user, password);
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypes() throws Exception {
        MonitorType o_testListAllMonitorTypes__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes__1)).hasChanges());
        List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypes_add3248() throws Exception {
        MonitorType o_testListAllMonitorTypes_add3248__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).hasChanges());
        MonitorType o_testListAllMonitorTypes_add3248__3 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).hasChanges());
        List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__1)).hasChanges());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add3248__3)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypesnull3263_failAssert0() throws Exception {
        try {
            createMonitorType();
            List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testListAllMonitorTypesnull3263 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypesnull3263_failAssert0_add3308_failAssert0() throws Exception {
        try {
            {
                createMonitorType();
                createMonitorType();
                List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
                notNull(null);
                isTrue((!(result.isEmpty())));
                org.junit.Assert.fail("testListAllMonitorTypesnull3263 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testListAllMonitorTypesnull3263_failAssert0_add3308 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_add1931() throws Exception {
        MonitorType o_testCreateGetDeleteMonitorType_add1931__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).hasChanges());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_add1931__8 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1931__8)).toString());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1931__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_add1933() throws Exception {
        MonitorType result = createMonitorType();
        result.getName();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_add1933__8 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1933__8)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_add1935() throws Exception {
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_add1935__7 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).toString());
        HttpStatus o_testCreateGetDeleteMonitorType_add1935__8 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertNull(o_testCreateGetDeleteMonitorType_add1935__8);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_add1935__7)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_mg1938() throws Exception {
        List<MonitorTool> __DSPOT_monitorTools_182 = Collections.singletonList(new MonitorTool());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_mg1938__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).toString());
        result.setMonitorTools(__DSPOT_monitorTools_182);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938__10)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTypenull1940_failAssert0() throws Exception {
        try {
            MonitorType result = createMonitorType();
            result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
            notNull(null);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1940 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTypenull1941_failAssert0() throws Exception {
        try {
            MonitorType result = createMonitorType();
            result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
            notNull(result);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1941 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_add1935_add1999() throws Exception {
        MonitorType o_testCreateGetDeleteMonitorType_add1935_add1999__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).hasChanges());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_add1935__7 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        HttpStatus o_testCreateGetDeleteMonitorType_add1935__8 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1935_add1999__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_mg1938_add1985() throws Exception {
        List<MonitorTool> __DSPOT_monitorTools_182 = Collections.singletonList(new MonitorTool());
        MonitorType o_testCreateGetDeleteMonitorType_mg1938_add1985__4 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).hasChanges());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_mg1938__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        result.setMonitorTools(__DSPOT_monitorTools_182);
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_mg1938_add1985__4)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_mg1938_add2001() throws Exception {
        List<MonitorTool> __DSPOT_monitorTools_182 = Collections.singletonList(new MonitorTool());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        HttpStatus o_testCreateGetDeleteMonitorType_mg1938_add2001__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).toString());
        HttpStatus o_testCreateGetDeleteMonitorType_mg1938__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        result.setMonitorTools(__DSPOT_monitorTools_182);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorType_mg1938_add2001__10)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_mg1938null2103_failAssert0() throws Exception {
        try {
            List<MonitorTool> __DSPOT_monitorTools_182 = Collections.singletonList(new MonitorTool());
            MonitorType result = createMonitorType();
            result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
            notNull(null);
            HttpStatus o_testCreateGetDeleteMonitorType_mg1938__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
            result.setMonitorTools(__DSPOT_monitorTools_182);
            org.junit.Assert.fail("testCreateGetDeleteMonitorType_mg1938null2103 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    private MonitorType createMonitorType() throws Exception {
        String monitorTypeName = UUID.randomUUID().toString();
        try {
            MonitorType mt = MonitoringOrchestratorProxyTest.proxy.getMonitorType(monitorTypeName);
            if (mt != null) {
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(mt);
            }
        } catch (Exception ex) {

        }
        MonitorType monitorType = new MonitorType();
        monitorType.setName(monitorTypeName);
        MonitorType result = MonitoringOrchestratorProxyTest.proxy.createMonitorType(monitorType);
        notNull(result);
        return result;
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add1() throws Exception {
        MonitorType o_testCreateGetDeleteMonitorTool_add1__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).hasChanges());
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_add1__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_add1__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__13)).toString());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).hasChanges());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add1__11)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add4() throws Exception {
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool.getName();
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_add4__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_add4__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__13)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add4__11)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add7() throws Exception {
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_add7__10 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_add7__12 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertNull(o_testCreateGetDeleteMonitorTool_add7__12);
        HttpStatus o_testCreateGetDeleteMonitorTool_add7__14 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__14)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_add7__10)).toString());
        Assert.assertNull(o_testCreateGetDeleteMonitorTool_add7__12);
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_remove10() throws Exception {
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_remove10__9 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_remove10__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__11)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_remove10__9)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg15() throws Exception {
        List<MonitorConfiguration> __DSPOT_monitorConfigurations_4 = Collections.singletonList(new MonitorConfiguration());
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg15__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg15__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).toString());
        monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_4);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__13)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg15__15)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg17() throws Exception {
        Integer __DSPOT_monitorTypeId_6 = -1391374059;
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).toString());
        monitorTool.setMonitorTypeId(__DSPOT_monitorTypeId_6);
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__11)).toString());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17__13)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull19_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(null);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull19 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull20_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(monitorType);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(null);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull20 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull22_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(monitorType);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg17_add255() throws Exception {
        Integer __DSPOT_monitorTypeId_6 = -1391374059;
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17_add255__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is4xxClientError());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is1xxInformational());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is5xxServerError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is3xxRedirection());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).toString());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        monitorTool.setMonitorTypeId(__DSPOT_monitorTypeId_6);
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is4xxClientError());
        Assert.assertTrue(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is1xxInformational());
        Assert.assertEquals("OK", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is5xxServerError());
        Assert.assertFalse(((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).is3xxRedirection());
        Assert.assertEquals("200", ((HttpStatus) (o_testCreateGetDeleteMonitorTool_mg17_add255__15)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg15_add143() throws Exception {
        List<MonitorConfiguration> __DSPOT_monitorConfigurations_4 = Collections.singletonList(new MonitorConfiguration());
        MonitorType monitorType = createMonitorType();
        MonitorTool o_testCreateGetDeleteMonitorTool_mg15_add143__6 = createMonitorTool(monitorType);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorConfigurations());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).isCurrentVersion());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).hasChanges());
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg15__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg15__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_4);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getMonitorConfigurations());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).isCurrentVersion());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg15_add143__6)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull20_failAssert0_mg151_failAssert0() throws Exception {
        try {
            {
                List<MonitorConfiguration> __DSPOT_monitorConfigurations_18 = Collections.singletonList(new MonitorConfiguration());
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(null);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull20 should have thrown IllegalArgumentException");
                monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_18);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull20_failAssert0_mg151 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull20_failAssert0_add120_failAssert0() throws Exception {
        try {
            {
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(null);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull20 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull20_failAssert0_add120 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull22_failAssert0_add112_failAssert0() throws Exception {
        try {
            {
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22_failAssert0_add112 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add1_add285_add1097() throws Exception {
        MonitorType o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).getMonitorTools());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).isCurrentVersion());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).hasChanges());
        MonitorType o_testCreateGetDeleteMonitorTool_add1__1 = createMonitorType();
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_add1_add285__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_add1__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_add1__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).getMonitorTools());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).isCurrentVersion());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1_add285_add1097__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg17_add255_add1148() throws Exception {
        Integer __DSPOT_monitorTypeId_6 = -1391374059;
        MonitorType monitorType = createMonitorType();
        MonitorTool o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4 = createMonitorTool(monitorType);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorConfigurations());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).isCurrentVersion());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).hasChanges());
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17_add255__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        HttpStatus o_testCreateGetDeleteMonitorTool_mg17__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        monitorTool.setMonitorTypeId(__DSPOT_monitorTypeId_6);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getMonitorConfigurations());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).isCurrentVersion());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_mg17_add255_add1148__4)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg15_add143null1456_failAssert0() throws Exception {
        try {
            List<MonitorConfiguration> __DSPOT_monitorConfigurations_4 = Collections.singletonList(new MonitorConfiguration());
            MonitorType monitorType = createMonitorType();
            MonitorTool o_testCreateGetDeleteMonitorTool_mg15_add143__6 = createMonitorTool(monitorType);
            MonitorTool monitorTool = createMonitorTool(null);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            HttpStatus o_testCreateGetDeleteMonitorTool_mg15__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            HttpStatus o_testCreateGetDeleteMonitorTool_mg15__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_4);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_mg15_add143null1456 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_mg15_add143null1461_failAssert0() throws Exception {
        try {
            List<MonitorConfiguration> __DSPOT_monitorConfigurations_4 = Collections.singletonList(new MonitorConfiguration());
            MonitorType monitorType = createMonitorType();
            MonitorTool o_testCreateGetDeleteMonitorTool_mg15_add143__6 = createMonitorTool(monitorType);
            MonitorTool monitorTool = createMonitorTool(monitorType);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            HttpStatus o_testCreateGetDeleteMonitorTool_mg15__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            HttpStatus o_testCreateGetDeleteMonitorTool_mg15__15 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
            monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_4);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_mg15_add143null1461 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add1null503_failAssert0_add1101_failAssert0() throws Exception {
        try {
            {
                MonitorType o_testCreateGetDeleteMonitorTool_add1__1 = createMonitorType();
                MonitorType monitorType = createMonitorType();
                createMonitorTool(null);
                MonitorTool monitorTool = createMonitorTool(null);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                HttpStatus o_testCreateGetDeleteMonitorTool_add1__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                HttpStatus o_testCreateGetDeleteMonitorTool_add1__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add1null503 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add1null503_failAssert0_add1101 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add1_add209null1478_failAssert0() throws Exception {
        try {
            MonitorType o_testCreateGetDeleteMonitorTool_add1__1 = createMonitorType();
            MonitorType monitorType = createMonitorType();
            MonitorTool o_testCreateGetDeleteMonitorTool_add1_add209__6 = createMonitorTool(monitorType);
            MonitorTool monitorTool = createMonitorTool(null);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            HttpStatus o_testCreateGetDeleteMonitorTool_add1__11 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            HttpStatus o_testCreateGetDeleteMonitorTool_add1__13 = MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add1_add209null1478 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    private MonitorTool createMonitorTool(MonitorType monitorType) throws Exception {
        String monitorToolName = UUID.randomUUID().toString();
        try {
            MonitorTool mt = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorToolName, monitorType.getName());
            if (mt != null) {
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(mt, monitorType.getName());
            }
        } catch (Exception ex) {

        }
        MonitorTool monitorTool = new MonitorTool();
        monitorTool.setName(monitorToolName);
        monitorTool.setMonitorName("Twitter");
        monitorTool = MonitoringOrchestratorProxyTest.proxy.createMonitorToolForMonitorType(monitorTool, monitorType.getName());
        notNull(monitorTool);
        return monitorTool;
    }

    @Test
    @Ignore
    public void testCreateGetUpdateDeleteMonitorConfiguration() throws Exception {
        MonitorType monitorType = createMonitorType();
        MonitorTool monitorTool = createMonitorTool(monitorType);
        MonitorConfiguration conf = new MonitorConfiguration();
        conf.setKafkaEndpoint("http://localhost:9092");
        conf.setKafkaTopic("olympicGamesTwitterMonitoring");
        conf.setKeywordExpression("keyword1 AND keyword2");
        conf.setState("active");
        conf.setTimeSlot("300");
        conf.setConfigSender("WP4");
        conf.setTimeStamp("Sat June 08 02:16:57 2016");
        MonitorConfiguration monitorConfigurationResult = MonitoringOrchestratorProxyTest.proxy.createMonitorConfigurationForMonitorToolAndMonitorType(conf, monitorTool.getName(), monitorType.getName());
        notNull(monitorConfigurationResult);
        monitorConfigurationResult = MonitoringOrchestratorProxyTest.proxy.getMonitorConfigurationForMonitorToolAndMonitorType(monitorConfigurationResult.getId(), monitorTool.getName(), monitorType.getName());
        notNull(monitorConfigurationResult);
        monitorConfigurationResult.setTimeSlot("100");
        monitorConfigurationResult = MonitoringOrchestratorProxyTest.proxy.updateMonitorConfigurationForMonitorToolAndMonitorType(monitorConfigurationResult, monitorTool.getName(), monitorType.getName());
        notNull(monitorConfigurationResult);
        Assert.assertEquals(MonitoringOrchestratorProxyTest.proxy.deleteMonitorConfigurationForMonitorToolAndMonitorType(monitorConfigurationResult, monitorTool.getName(), monitorType.getName()), HttpStatus.OK);
        Assert.assertEquals(MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName()), HttpStatus.OK);
        Assert.assertEquals(MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType), HttpStatus.OK);
    }
}

