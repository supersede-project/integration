package eu.supersede.integration.api.dm.proxies.test;


import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


public class AmplDecisionMakingSystemProxyTest {
    private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxyTest.class);

    private static DecisionMakingSystemProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        DecisionMakingSystemProxyTest.proxy = new DecisionMakingSystemProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg1() throws Exception {
        String __DSPOT_applicationId_0 = "-*k},GdhscbCS@!x*zH_";
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg1__4 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg1__4)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg1__4)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg1__4)).toString());
        alert.setApplicationId(__DSPOT_applicationId_0);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg1__4)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg1__4)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg1__4)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg1__4)).toString());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg2() throws Exception {
        List<Condition> __DSPOT_conditions_1 = Collections.<Condition>emptyList();
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg2__5 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg2__5)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg2__5)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg2__5)).toString());
        alert.setConditions(__DSPOT_conditions_1);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg2__5)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg2__5)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg2__5)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg2__5)).toString());
    }

    @Test(timeout = 30000)
    public void testNotifyAlert_mg4() throws Exception {
        List<UserRequest> __DSPOT_requests_3 = Collections.singletonList(new UserRequest());
        Alert alert = createAlert();
        HttpStatus o_testNotifyAlert_mg4__6 = DecisionMakingSystemProxyTest.proxy.notifyAlert(alert);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg4__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg4__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg4__6)).toString());
        alert.setRequests(__DSPOT_requests_3);
        Assert.assertEquals("OK", ((HttpStatus) (o_testNotifyAlert_mg4__6)).getReasonPhrase());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is1xxInformational());
        Assert.assertTrue(((HttpStatus) (o_testNotifyAlert_mg4__6)).is2xxSuccessful());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is3xxRedirection());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is4xxClientError());
        Assert.assertFalse(((HttpStatus) (o_testNotifyAlert_mg4__6)).is5xxServerError());
        Assert.assertEquals("200", ((HttpStatus) (o_testNotifyAlert_mg4__6)).toString());
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

