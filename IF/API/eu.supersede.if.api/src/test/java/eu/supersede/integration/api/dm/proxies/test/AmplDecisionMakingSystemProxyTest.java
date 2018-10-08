package eu.supersede.integration.api.dm.proxies.test;


import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.util.Assert.isTrue;


public class AmplDecisionMakingSystemProxyTest {
    private static final Logger log = LoggerFactory.getLogger(AmplDecisionMakingSystemProxyTest.class);

    private static DecisionMakingSystemProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplDecisionMakingSystemProxyTest.proxy = new DecisionMakingSystemProxy<Object, Object>();
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

    @Test(timeout = 120000)
    public void testNotifyAlert_add1() throws Exception {
        Alert o_testNotifyAlert_add1__1 = createAlert();
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getConditions()).isEmpty());
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getRequests()).isEmpty());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getRequests()).size())));
        Assert.assertEquals("appId1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getApplicationId());
        Assert.assertEquals("id1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getId());
        Assert.assertEquals("Delta", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getTenant());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getConditions()).size())));
        Assert.assertEquals(1481717773760L, ((long) (((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1__1).getTimestamp())));
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(createAlert()));
    }

    @Test(timeout = 120000)
    public void testNotifyAlert_sd4() throws Exception {
        Alert alert = createAlert();
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(alert));
        Assert.assertEquals("appId1", alert.getApplicationId());
    }

    @Test(timeout = 120000)
    public void testNotifyAlert_add1_add62() throws Exception {
        Alert o_testNotifyAlert_add1_add62__1 = createAlert();
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getRequests()).isEmpty());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getRequests()).size())));
        Assert.assertEquals("Delta", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getTenant());
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getConditions()).isEmpty());
        Assert.assertEquals(1481717773760L, ((long) (((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getTimestamp())));
        Assert.assertEquals("id1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getId());
        Assert.assertEquals("appId1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getApplicationId());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62__1).getConditions()).size())));
        Alert o_testNotifyAlert_add1__1 = createAlert();
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(createAlert()));
    }

    @Test(timeout = 120000)
    public void testNotifyAlert_sd4_sd71() throws Exception {
        Alert alert = createAlert();
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(alert));
        String o_testNotifyAlert_sd4__6 = alert.getApplicationId();
        Assert.assertEquals("appId1", o_testNotifyAlert_sd4__6);
        Assert.assertEquals("id1", alert.getId());
    }

    @Test(timeout = 120000)
    public void testNotifyAlert_add1_add62_add236() throws Exception {
        Alert o_testNotifyAlert_add1_add62_add236__1 = createAlert();
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getConditions()).isEmpty());
        Assert.assertEquals("id1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getId());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getRequests()).size())));
        Assert.assertEquals("Delta", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getTenant());
        Assert.assertEquals(1481717773760L, ((long) (((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getTimestamp())));
        Assert.assertFalse(((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getRequests()).isEmpty());
        Assert.assertEquals("appId1", ((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getApplicationId());
        Assert.assertEquals(1, ((int) (((java.util.List)((eu.supersede.integration.api.dm.types.Alert)o_testNotifyAlert_add1_add62_add236__1).getConditions()).size())));
        Alert o_testNotifyAlert_add1_add62__1 = createAlert();
        Alert o_testNotifyAlert_add1__1 = createAlert();
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(createAlert()));
    }

    @Test(timeout = 120000)
    public void testNotifyAlert_sd4_sd71_sd244() throws Exception {
        Alert alert = createAlert();
        isTrue(AmplDecisionMakingSystemProxyTest.proxy.notifyAlert(alert));
        String o_testNotifyAlert_sd4__6 = alert.getApplicationId();
        Assert.assertEquals("appId1", o_testNotifyAlert_sd4__6);
        String o_testNotifyAlert_sd4_sd71__10 = alert.getId();
        Assert.assertEquals("id1", o_testNotifyAlert_sd4_sd71__10);
        Assert.assertEquals("appId1", alert.getApplicationId());
    }
}

