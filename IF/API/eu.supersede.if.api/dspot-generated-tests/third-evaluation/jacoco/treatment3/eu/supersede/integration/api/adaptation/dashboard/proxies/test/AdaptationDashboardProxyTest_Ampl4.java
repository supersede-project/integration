package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdaptationDashboardProxyTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    private static String adaptationId;

    private static String enactmentId;

    private static Adaptation createdAdaptation;

    private static Enactment createdEnactment;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationDashboardProxyTest.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
        List<Adaptation> adaptations = AdaptationDashboardProxyTest.proxy.getAllAdaptations();
        List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
        for (Enactment e : enactments) {
            AdaptationDashboardProxyTest.proxy.deleteEnactment(e.getFc_id());
        }
        for (Adaptation a : adaptations) {
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(a.getFc_id());
        }
        AdaptationDashboardProxyTest.createdAdaptation = AdaptationDashboardProxyTest.createAdaptation(1);
        AdaptationDashboardProxyTest.proxy.addAdaptation(AdaptationDashboardProxyTest.createdAdaptation);
        adaptations = AdaptationDashboardProxyTest.proxy.getAllAdaptations();
        AdaptationDashboardProxyTest.adaptationId = adaptations.get(0).getFc_id();
        Assert.notNull(AdaptationDashboardProxyTest.adaptationId);
        enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
        if (enactments.isEmpty()) {
            AdaptationDashboardProxyTest.createdEnactment = AdaptationDashboardProxyTest.createEnactment(AdaptationDashboardProxyTest.adaptationId);
            AdaptationDashboardProxyTest.proxy.addEnactment(AdaptationDashboardProxyTest.createdEnactment);
            enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
        }
        AdaptationDashboardProxyTest.enactmentId = enactments.get(0).getFc_id();
        Assert.notNull(AdaptationDashboardProxyTest.enactmentId);
    }

    @org.junit.AfterClass
    public static void cleanup() throws Exception {
        if ((AdaptationDashboardProxyTest.createdEnactment) != null) {
            if ((AdaptationDashboardProxyTest.createdAdaptation) != null) {
                org.junit.Assert.assertEquals(AdaptationDashboardProxyTest.proxy.deleteEnactment(AdaptationDashboardProxyTest.createdAdaptation.getFc_id()), HttpStatus.OK);
            } else {
                org.junit.Assert.assertEquals(AdaptationDashboardProxyTest.proxy.deleteEnactment(AdaptationDashboardProxyTest.adaptationId), HttpStatus.OK);
            }
        }
        if ((AdaptationDashboardProxyTest.createdAdaptation) != null) {
            org.junit.Assert.assertEquals(AdaptationDashboardProxyTest.proxy.deleteAdaptation(AdaptationDashboardProxyTest.createdAdaptation.getFc_id()), HttpStatus.OK);
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull31_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull31 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull32_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(4);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull32 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull33_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(4);
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull33 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull31_failAssert0_mg160_failAssert0() throws Exception {
        try {
            {
                Date __DSPOT_computation_timestamp_8 = new Date("Wz2[|+mr6#-VtX(r!Fs2");
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(null);
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddAdaptationnull31 should have thrown HttpMessageNotWritableException");
                adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_8);
            }
            org.junit.Assert.fail("testAddAdaptationnull31_failAssert0_mg160 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private static Adaptation createAdaptation(Integer fc_id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(fc_id);
        adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
        adaptation.setModel_system(ModelSystem.Atos_HSK);
        adaptation.setName("Medium load configuration for HSK service");
        adaptation.setRank(1.0);
        adaptation.getActions().add(AdaptationDashboardProxyTest.createAction());
        return adaptation;
    }

    private static Action createAction() {
        Action action = new Action();
        action.setAction_id("vm2_b_high");
        action.setDescription("Medium load configuration for HSK service");
        action.setName("VM2_B_HighConfiguration");
        action.setEnabled(true);
        return action;
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull4220_failAssert0() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllEnactmentsnull4220 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_add4255() throws Exception {
        List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
        Assert.notNull(enactments);
        Enactment o_testGetEnactment_add4255__4 = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
        assertEquals("1", ((Enactment) (o_testGetEnactment_add4255__4)).getFc_id());
        assertEquals("1", ((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getFc_id());
        assertEquals(0.0, ((double) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getRank())), 0.1);
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getName());
        assertFalse(((Collection) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getActions())).isEmpty());
        assertTrue(((Enactment) (o_testGetEnactment_add4255__4)).isResult());
        Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
        Assert.notNull(enactment);
        assertEquals("1", ((Enactment) (o_testGetEnactment_add4255__4)).getFc_id());
        assertEquals("1", ((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getFc_id());
        assertEquals(0.0, ((double) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getRank())), 0.1);
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getName());
        assertFalse(((Collection) (((Adaptation) (((Enactment) (o_testGetEnactment_add4255__4)).getAdaptation())).getActions())).isEmpty());
        assertTrue(((Enactment) (o_testGetEnactment_add4255__4)).isResult());
    }

    @Test(timeout = 30000)
    public void testGetEnactmentnull4283_failAssert0() throws Exception {
        try {
            List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
            Assert.notNull(enactments);
            Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
            Assert.notNull(null);
            org.junit.Assert.fail("testGetEnactmentnull4283 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg4267_failAssert0_mg4409_failAssert0() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_370 = new Adaptation();
                Date __DSPOT_enactment_request_timestamp_361 = new Date("ae;yT1.?>.gB?2l[mns*");
                List<Enactment> enactments = AdaptationDashboardProxyTest.proxy.getAllEnactments();
                Assert.notNull(enactments);
                Enactment enactment = AdaptationDashboardProxyTest.proxy.getEnactment(enactments.get(0).getFc_id());
                Assert.notNull(enactment);
                enactment.setEnactment_request_time(__DSPOT_enactment_request_timestamp_361);
                org.junit.Assert.fail("testGetEnactment_mg4267 should have thrown IllegalArgumentException");
                enactment.setAdaptation(__DSPOT_adaptation_370);
            }
            org.junit.Assert.fail("testGetEnactment_mg4267_failAssert0_mg4409 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_add912_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactment_add912 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_remove918_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactment_remove918 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull957_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(null);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull957 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull958_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull958 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull959_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull959 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull960_failAssert0() throws Exception {
        try {
            Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
            if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
            Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
            Assert.notNull(null);
            AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull960 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_add912_failAssert0_add1209_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
                if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactment_add912 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddEnactment_add912_failAssert0_add1209 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull958_failAssert0litNum1595_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(0);
                if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(null);
                Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull958 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testAddEnactmentnull958_failAssert0litNum1595 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull959_failAssert0litNum1599_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(3);
                if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(null);
                Assert.notNull(enactment);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull959 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testAddEnactmentnull959_failAssert0litNum1599 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull960_failAssert0litNum1526_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(3);
                if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                    AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(null);
                AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactmentnull960 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddEnactmentnull960_failAssert0litNum1526 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_remove918_failAssert0_rv1284_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = AdaptationDashboardProxyTest.createAdaptation(2);
                if ((AdaptationDashboardProxyTest.proxy.getEnactment(adaptation.getFc_id())) != null) {
                }
                adaptation = AdaptationDashboardProxyTest.proxy.addAdaptation(adaptation);
                Enactment enactment = AdaptationDashboardProxyTest.createEnactment(adaptation.getFc_id());
                enactment = AdaptationDashboardProxyTest.proxy.addEnactment(enactment);
                Assert.notNull(enactment);
                HttpStatus __DSPOT_invoc_18 = AdaptationDashboardProxyTest.proxy.deleteEnactment(adaptation.getFc_id());
                AdaptationDashboardProxyTest.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testAddEnactment_remove918 should have thrown HttpMessageNotReadableException");
                __DSPOT_invoc_18.is1xxInformational();
            }
            org.junit.Assert.fail("testAddEnactment_remove918_failAssert0_rv1284 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    private static Enactment createEnactment(String fc_id) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(fc_id);
        enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
        enactment.setEnactment_request_time(Calendar.getInstance().getTime());
        enactment.setResult(true);
        return enactment;
    }
}

