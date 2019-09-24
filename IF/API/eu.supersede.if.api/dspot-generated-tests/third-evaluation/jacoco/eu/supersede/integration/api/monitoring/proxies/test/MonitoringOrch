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
    public void testListAllMonitorTypes_add1754() throws Exception {
        MonitorType o_testListAllMonitorTypes_add1754__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).hasChanges());
        MonitorType o_testListAllMonitorTypes_add1754__3 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).hasChanges());
        List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__1)).hasChanges());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testListAllMonitorTypes_add1754__3)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypesnull1769_failAssert0() throws Exception {
        try {
            createMonitorType();
            List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
            notNull(null);
            isTrue((!(result.isEmpty())));
            org.junit.Assert.fail("testListAllMonitorTypesnull1769 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testListAllMonitorTypes_add1754_add1837() throws Exception {
        MonitorType o_testListAllMonitorTypes_add1754__1 = createMonitorType();
        MonitorType o_testListAllMonitorTypes_add1754__3 = createMonitorType();
        List<MonitorType> o_testListAllMonitorTypes_add1754_add1837__9 = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
        Assert.assertFalse(o_testListAllMonitorTypes_add1754_add1837__9.isEmpty());
        List<MonitorType> result = MonitoringOrchestratorProxyTest.proxy.listAllMonitorTypes();
        notNull(result);
        isTrue((!(result.isEmpty())));
        Assert.assertFalse(o_testListAllMonitorTypes_add1754_add1837__9.isEmpty());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorType_add1264() throws Exception {
        MonitorType o_testCreateGetDeleteMonitorType_add1264__1 = createMonitorType();
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).hasChanges());
        MonitorType result = createMonitorType();
        result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
        notNull(result);
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorType_add1264__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTypenull1274_failAssert0() throws Exception {
        try {
            MonitorType result = createMonitorType();
            result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
            notNull(null);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(result);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1274 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTypenull1275_failAssert0() throws Exception {
        try {
            MonitorType result = createMonitorType();
            result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
            notNull(result);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1275 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTypenull1275_failAssert0_mg1328_failAssert0() throws Exception {
        try {
            {
                List<MonitorTool> __DSPOT_monitorTools_155 = Collections.singletonList(new MonitorTool());
                MonitorType result = createMonitorType();
                result = MonitoringOrchestratorProxyTest.proxy.getMonitorType(result.getName());
                notNull(result);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
                org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1275 should have thrown NullPointerException");
                result.setMonitorTools(__DSPOT_monitorTools_155);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorTypenull1275_failAssert0_mg1328 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
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
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getMonitorTools());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).isCurrentVersion());
        Assert.assertNull(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).getCreatedAt());
        Assert.assertFalse(((MonitorType) (o_testCreateGetDeleteMonitorTool_add1__1)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add2() throws Exception {
        MonitorType monitorType = createMonitorType();
        MonitorTool o_testCreateGetDeleteMonitorTool_add2__3 = createMonitorTool(monitorType);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorConfigurations());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).isCurrentVersion());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).hasChanges());
        MonitorTool monitorTool = createMonitorTool(monitorType);
        monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
        notNull(monitorTool);
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
        Assert.assertEquals("Twitter", ((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorName());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorTypeId());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getMonitorConfigurations());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).isCurrentVersion());
        Assert.assertNull(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).getCreatedAt());
        Assert.assertFalse(((MonitorTool) (o_testCreateGetDeleteMonitorTool_add2__3)).hasChanges());
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull21_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(null);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull21 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull22_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(monitorType);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(null);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull24_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool monitorTool = createMonitorTool(monitorType);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add2null228_failAssert0() throws Exception {
        try {
            MonitorType monitorType = createMonitorType();
            MonitorTool o_testCreateGetDeleteMonitorTool_add2__3 = createMonitorTool(monitorType);
            MonitorTool monitorTool = createMonitorTool(null);
            monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
            notNull(monitorTool);
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
            MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add2null228 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull21_failAssert0_mg154_failAssert0() throws Exception {
        try {
            {
                List<MonitorConfiguration> __DSPOT_monitorConfigurations_23 = Collections.singletonList(new MonitorConfiguration());
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(null);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull21 should have thrown NullPointerException");
                monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_23);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull21_failAssert0_mg154 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull22_failAssert0_mg159_failAssert0() throws Exception {
        try {
            {
                String __DSPOT_name_26 = "b{[Iz>YSe|%xHdm7#=To";
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(null);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22 should have thrown IllegalArgumentException");
                monitorTool.setName(__DSPOT_name_26);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull22_failAssert0_mg159 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull24_failAssert0_add112_failAssert0() throws Exception {
        try {
            {
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24_failAssert0_add112 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull24_failAssert0_mg148_failAssert0() throws Exception {
        try {
            {
                List<MonitorConfiguration> __DSPOT_monitorConfigurations_19 = Collections.singletonList(new MonitorConfiguration());
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(monitorType);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24 should have thrown NullPointerException");
                monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_19);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24_failAssert0_mg148 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add2null228_failAssert0_mg767_failAssert0() throws Exception {
        try {
            {
                List<MonitorConfiguration> __DSPOT_monitorConfigurations_108 = Collections.singletonList(new MonitorConfiguration());
                MonitorType monitorType = createMonitorType();
                MonitorTool o_testCreateGetDeleteMonitorTool_add2__3 = createMonitorTool(monitorType);
                MonitorTool monitorTool = createMonitorTool(null);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add2null228 should have thrown NullPointerException");
                o_testCreateGetDeleteMonitorTool_add2__3.setMonitorConfigurations(__DSPOT_monitorConfigurations_108);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add2null228_failAssert0_mg767 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorToolnull24_failAssert0_mg148_failAssert0null837_failAssert0() throws Exception {
        try {
            {
                {
                    List<MonitorConfiguration> __DSPOT_monitorConfigurations_19 = Collections.singletonList(new MonitorConfiguration());
                    MonitorType monitorType = createMonitorType();
                    MonitorTool monitorTool = createMonitorTool(monitorType);
                    monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                    notNull(monitorTool);
                    MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(null, monitorType.getName());
                    MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(null);
                    org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24 should have thrown NullPointerException");
                    monitorTool.setMonitorConfigurations(__DSPOT_monitorConfigurations_19);
                }
                org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24_failAssert0_mg148 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorToolnull24_failAssert0_mg148_failAssert0null837 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateGetDeleteMonitorTool_add1null223_failAssert0_mg814_failAssert0() throws Exception {
        try {
            {
                Integer __DSPOT_id_143 = -239346921;
                MonitorType o_testCreateGetDeleteMonitorTool_add1__1 = createMonitorType();
                MonitorType monitorType = createMonitorType();
                MonitorTool monitorTool = createMonitorTool(null);
                monitorTool = MonitoringOrchestratorProxyTest.proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
                notNull(monitorTool);
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
                MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
                org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add1null223 should have thrown NullPointerException");
                monitorTool.setId(__DSPOT_id_143);
            }
            org.junit.Assert.fail("testCreateGetDeleteMonitorTool_add1null223_failAssert0_mg814 should have thrown NullPointerException");
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
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorConfigurationForMonitorToolAndMonitorType(monitorConfigurationResult, monitorTool.getName(), monitorType.getName());
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());
        MonitoringOrchestratorProxyTest.proxy.deleteMonitorType(monitorType);
    }
}

