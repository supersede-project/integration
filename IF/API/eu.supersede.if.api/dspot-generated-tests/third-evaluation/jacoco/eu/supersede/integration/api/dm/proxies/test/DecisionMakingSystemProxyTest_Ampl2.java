package eu.supersede.integration.api.dm.proxies.test;


import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.util.Assert.isTrue;


public class DecisionMakingSystemProxyTest {
    private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxyTest.class);

    private static DecisionMakingSystemProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        DecisionMakingSystemProxyTest.proxy = new DecisionMakingSystemProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add1() throws Exception {
        Alert o_testNotifyAlert_add1__1 = createAlert();
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlert_add1__1)).getTimestamp())));
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1__1)).getApplicationId());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getConditions())).isEmpty());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getRequests())).isEmpty());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1__1)).getId());
        Alert alert = createAlert();
        boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        isTrue(result);
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlert_add1__1)).getTimestamp())));
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1__1)).getApplicationId());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getConditions())).isEmpty());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getRequests())).isEmpty());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add2() throws Exception {
        Alert alert = createAlert();
        boolean o_testNotifyAlert_add2__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertTrue(o_testNotifyAlert_add2__3);
        boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        isTrue(result);
        Assert.assertTrue(o_testNotifyAlert_add2__3);
    }

    @Test(timeout = 30000)
    public void testNotifyAlertnull11_failAssert0() throws Exception {
        try {
            Alert alert = createAlert();
            boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
            isTrue(result);
            org.junit.Assert.fail("testNotifyAlertnull11 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add1null94_failAssert0() throws Exception {
        try {
            Alert o_testNotifyAlert_add1__1 = createAlert();
            Alert alert = createAlert();
            boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
            isTrue(result);
            org.junit.Assert.fail("testNotifyAlert_add1null94 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add2null100_failAssert0() throws Exception {
        try {
            Alert alert = createAlert();
            boolean o_testNotifyAlert_add2__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
            boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
            isTrue(result);
            org.junit.Assert.fail("testNotifyAlert_add2null100 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlertnull11_failAssert0_mg57_failAssert0() throws Exception {
        try {
            {
                List<UserRequest> __DSPOT_requests_10 = Collections.singletonList(new UserRequest());
                Alert alert = createAlert();
                boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
                isTrue(result);
                org.junit.Assert.fail("testNotifyAlertnull11 should have thrown IllegalArgumentException");
                alert.setRequests(__DSPOT_requests_10);
            }
            org.junit.Assert.fail("testNotifyAlertnull11_failAssert0_mg57 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add1null94_failAssert0_mg280_failAssert0() throws Exception {
        try {
            {
                List<Condition> __DSPOT_conditions_32 = Collections.singletonList(new Condition());
                Alert o_testNotifyAlert_add1__1 = createAlert();
                Alert alert = createAlert();
                boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
                isTrue(result);
                org.junit.Assert.fail("testNotifyAlert_add1null94 should have thrown IllegalArgumentException");
                o_testNotifyAlert_add1__1.setConditions(__DSPOT_conditions_32);
            }
            org.junit.Assert.fail("testNotifyAlert_add1null94_failAssert0_mg280 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add1null94_failAssert0_mg317_failAssert0() throws Exception {
        try {
            {
                List<UserRequest> __DSPOT_requests_51 = Collections.singletonList(new UserRequest());
                Alert o_testNotifyAlert_add1__1 = createAlert();
                Alert alert = createAlert();
                boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
                isTrue(result);
                org.junit.Assert.fail("testNotifyAlert_add1null94 should have thrown IllegalArgumentException");
                alert.setRequests(__DSPOT_requests_51);
            }
            org.junit.Assert.fail("testNotifyAlert_add1null94_failAssert0_mg317 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add2null100_failAssert0_mg288_failAssert0() throws Exception {
        try {
            {
                List<Condition> __DSPOT_conditions_36 = Collections.<Condition>emptyList();
                Alert alert = createAlert();
                boolean o_testNotifyAlert_add2__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
                boolean result = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
                isTrue(result);
                org.junit.Assert.fail("testNotifyAlert_add2null100 should have thrown IllegalArgumentException");
                alert.setConditions(__DSPOT_conditions_36);
            }
            org.junit.Assert.fail("testNotifyAlert_add2null100_failAssert0_mg288 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    private Alert createAlert() {
        Alert alert = new Alert();
        alert.setId("id1");
        alert.setApplicationId("appId1");
        alert.setTimestamp(1481717773760L);
        alert.setTenant("Delta");
        List<Condition> conditions = new ArrayList<Condition>();
        conditions.add(new Condition(DataID.UNSPECIFIED, Operator.GEq, 10.5));
        alert.setConditions(conditions);
        List<UserRequest> requests = new ArrayList<>();
        String[] feedbackIDs = new String[]{ "feedbackId1" };
        String[] features = new String[]{ "UI", "backend" };
        requests.add(new UserRequest("id1", RequestClassification.FeatureRequest, 0.5, "description string", 1, 2, 0, feedbackIDs, features));
        alert.setRequests(requests);
        return alert;
    }
}

