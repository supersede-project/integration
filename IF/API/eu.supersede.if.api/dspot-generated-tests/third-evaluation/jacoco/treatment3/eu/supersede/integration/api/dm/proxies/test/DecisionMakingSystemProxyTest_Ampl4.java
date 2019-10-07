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
import org.springframework.http.HttpStatus;


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
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1__1)).getId());
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_add1__4 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_add1__4)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_add1__4)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_add1__4)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_add1__4)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_add1__4)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_add1__4)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_add1__4)).toString());
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlert_add1__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1__1)).getId());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg3() throws Exception {
        String __DSPOT_applicationId_0 = "-*k},GdhscbCS@!x*zH_";
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg3__4 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg3__4)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg3__4)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg3__4)).toString());
        alert.setApplicationId(__DSPOT_applicationId_0);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg3__4)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg3__4)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg3__4)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg3__4)).toString());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg6() throws Exception {
        List<UserRequest> __DSPOT_requests_3 = Collections.singletonList(new UserRequest());
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg6__6 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg6__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg6__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg6__6)).toString());
        alert.setRequests(__DSPOT_requests_3);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg6__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg6__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg6__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg6__6)).toString());
    }

    @Test(timeout = 30000)
    public void testNotifyAlertnull9() throws Exception {
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlertnull9__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
        Assert.assertNull(o_testNotifyAlertnull9__3);
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg6_add39() throws Exception {
        List o_testNotifyAlert_mg6_add39__1 = Collections.singletonList(new UserRequest());
        Assert.assertFalse(o_testNotifyAlert_mg6_add39__1.isEmpty());
        List<UserRequest> __DSPOT_requests_3 = Collections.singletonList(new UserRequest());
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg6__6 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        alert.setRequests(__DSPOT_requests_3);
        Assert.assertFalse(o_testNotifyAlert_mg6_add39__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testNotifyAlertnull9_add37() throws Exception {
        Alert o_testNotifyAlertnull9_add37__1 = createAlert();
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlertnull9_add37__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlertnull9_add37__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlertnull9_add37__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlertnull9_add37__1)).getId());
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlertnull9__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlertnull9_add37__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlertnull9_add37__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlertnull9_add37__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlertnull9_add37__1)).getId());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_add1_add60_add555() throws Exception {
        Alert o_testNotifyAlert_add1_add60_add555__1 = createAlert();
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getId());
        Alert o_testNotifyAlert_add1_add60__1 = createAlert();
        Alert o_testNotifyAlert_add1__1 = createAlert();
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_add1__4 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlert_add1_add60_add555__1)).getId());
    }

    @Test(timeout = 30000)
    public void testNotifyAlertnull9_add37_add550() throws Exception {
        Alert o_testNotifyAlertnull9_add37_add550__1 = createAlert();
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getId());
        Alert o_testNotifyAlertnull9_add37__1 = createAlert();
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlertnull9__3 = DecisionMakingSystemProxyTest.proxy.notifyAlert(null);
        Assert.assertEquals(1481717773760L, ((long) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getTimestamp())));
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getRequests())).isEmpty());
        Assert.assertEquals("Delta", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getTenant());
        Assert.assertFalse(((Collection) (((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getConditions())).isEmpty());
        Assert.assertEquals("appId1", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getApplicationId());
        Assert.assertEquals("id1", ((Alert) (o_testNotifyAlertnull9_add37_add550__1)).getId());
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

