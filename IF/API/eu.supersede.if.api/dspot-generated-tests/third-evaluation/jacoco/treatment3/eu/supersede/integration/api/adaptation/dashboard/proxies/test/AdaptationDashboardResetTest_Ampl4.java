package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Tenant;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import static org.springframework.util.Assert.notNull;


public class AdaptationDashboardResetTest {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationDashboardResetTest.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add8() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation o_testResetDashboard_add8__16 = createAtosAdaptation(1);
        Assert.assertEquals("1", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        Assert.assertEquals("Atos_HSK 1", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
        Adaptation adaptation = createAtosAdaptation(1);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation(2);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        Assert.assertEquals("Atos_HSK 1", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add11() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation(1);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment o_testResetDashboard_add11__22 = createAtosEnactment(adaptation);
        Assert.assertEquals("1", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation(2);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg43() throws Exception {
        Adaptation __DSPOT_a_11 = new Adaptation();
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation(1);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation(2);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        int o_testResetDashboard_mg43__40 = adaptation.compareTo(__DSPOT_a_11);
        Assert.assertEquals(0, ((int) (o_testResetDashboard_mg43__40)));
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add18_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_add18 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_literalMutationNumber24_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboard_literalMutationNumber24 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull76_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(null);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull76 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull77_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull77 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull78_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(null);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull78 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull80_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(null);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull80 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull81_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull81 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull84_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(null);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull84 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull86_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(null);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull86 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull87_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            org.junit.Assert.fail("testResetDashboardnull87 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull84_failAssert0_mg830_failAssert0() throws Exception {
        try {
            {
                double __DSPOT_rank_131 = 0.4382021097862473;
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(null);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull84 should have thrown HttpMessageNotWritableException");
                adaptation.setRank(__DSPOT_rank_131);
            }
            org.junit.Assert.fail("testResetDashboardnull84_failAssert0_mg830 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull78_failAssert0_mg923_failAssert0() throws Exception {
        try {
            {
                boolean __DSPOT_result_213 = false;
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(null);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull78 should have thrown IllegalArgumentException");
                enactment.setResult(__DSPOT_result_213);
            }
            org.junit.Assert.fail("testResetDashboardnull78_failAssert0_mg923 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull77_failAssert0_add423_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                notNull(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull77 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull77_failAssert0_add423 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull77_failAssert0litNum1553_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(Integer.MAX_VALUE);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull77 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull77_failAssert0litNum1553 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull81_failAssert0null1721_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(null);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull81 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull81_failAssert0null1721 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull81_failAssert0litNum1629_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(0);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull81 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull81_failAssert0litNum1629 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull78_failAssert0_add356_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(null);
                notNull(adaptation);
                createAtosEnactment(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull78_failAssert0_add356 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull86_failAssert0_mg690_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Date __DSPOT_computation_timestamp_41 = new Date(">[Bob5_83OI`-k-a8(J8");
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_41);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(null);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull86 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull86_failAssert0_mg690 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg43null1749_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_a_11 = new Adaptation();
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation(1);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(null);
            adaptation = createSiemensAdaptation(2);
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            int o_testResetDashboard_mg43__40 = adaptation.compareTo(__DSPOT_a_11);
            org.junit.Assert.fail("testResetDashboard_mg43null1749 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add18_failAssert0_add495_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_add18 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboard_add18_failAssert0_add495 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull81_failAssert0null1708_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull81 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull81_failAssert0null1708 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull76_failAssert0_add437_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(null);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull76 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull76_failAssert0_add437 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull87_failAssert0litNum1372_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(Integer.MAX_VALUE);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                org.junit.Assert.fail("testResetDashboardnull87 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull87_failAssert0litNum1372 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0_mg757_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_72 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_72);
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg757 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull80_failAssert0_literalMutationNumber714_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation(0);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(null);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull80 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull80_failAssert0_literalMutationNumber714 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull78_failAssert0_rv1059_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    HttpStatus __DSPOT_invoc_16 = AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    __DSPOT_invoc_16.getReasonPhrase();
                }
                Adaptation adaptation = createAtosAdaptation(1);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(null);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation(2);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull78 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull78_failAssert0_rv1059 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull76_failAssert0_add437_failAssert0_rv5209_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        HttpStatus __DSPOT_invoc_17 = AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        __DSPOT_invoc_17.is2xxSuccessful();
                    }
                    Adaptation adaptation = createAtosAdaptation(null);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull76 should have thrown HttpMessageNotWritableException");
                }
                org.junit.Assert.fail("testResetDashboardnull76_failAssert0_add437 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull76_failAssert0_add437_failAssert0_rv5209 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add18_failAssert0null1780_failAssert0_add2330_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_add18 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testResetDashboard_add18_failAssert0null1780 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboard_add18_failAssert0null1780_failAssert0_add2330 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0_mg757_failAssert0litNum4078_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_72 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_72);
                    }
                    Adaptation adaptation = createAtosAdaptation(Integer.MAX_VALUE);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg757 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg757_failAssert0litNum4078 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull86_failAssert0_mg690_failAssert0litNum4864_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Date __DSPOT_computation_timestamp_41 = new Date(">[Bob5_83OI`-k-a8(J8");
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_41);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(Integer.MIN_VALUE);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(null);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull86 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull86_failAssert0_mg690 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull86_failAssert0_mg690_failAssert0litNum4864 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull84_failAssert0_mg860_failAssert0_mg3393_failAssert0() throws Exception {
        try {
            {
                {
                    Date __DSPOT_enactment_completion_time_158 = new Date(1827632475, 221477669, -1904320861, -1979099070, 416956815);
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        String __DSPOT_name_686 = "Fe]3#C6HvQ{7`[>;YwP/";
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.setName(__DSPOT_name_686);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(null);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull84 should have thrown HttpMessageNotWritableException");
                    enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_158);
                }
                org.junit.Assert.fail("testResetDashboardnull84_failAssert0_mg860 should have thrown HttpMessageNotWritableException");
            }
            org.junit.Assert.fail("testResetDashboardnull84_failAssert0_mg860_failAssert0_mg3393 should have thrown HttpMessageNotWritableException");
        } catch (HttpMessageNotWritableException expected) {
            Assert.assertEquals("Could not write content: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"]); nested exception is com.fasterxml.jackson.databind.JsonMappingException: (was java.lang.NullPointerException) (through reference chain: eu.supersede.integration.api.adaptation.dashboad.types.Adaptation[\"fc_id\"])", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull77_failAssert0_add423_failAssert0_mg2970_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_419 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_419);
                    }
                    Adaptation adaptation = createAtosAdaptation(1);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                    notNull(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation(2);
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull77 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull77_failAssert0_add423 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull77_failAssert0_add423_failAssert0_mg2970 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    private Adaptation createAtosAdaptation(Integer id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(id);
        Calendar computation = Calendar.getInstance();
        adaptation.setComputation_timestamp(computation.getTime());
        adaptation.setModel_system(ModelSystem.Atos_HSK);
        adaptation.setName((((ModelSystem.Atos_HSK) + " ") + id));
        adaptation.setRank(1.0);
        adaptation.getActions().add(createLowLoadAction());
        adaptation.getActions().add(createHSKAction());
        adaptation.getActions().add(createCREAction());
        return adaptation;
    }

    private Action createCREAction() {
        Action action = new Action();
        action.setAction_id("cre_8739");
        action.setDescription("Content Searching Index Engine in single VM");
        action.setName("CRE");
        action.setEnabled(true);
        return action;
    }

    private Action createHSKAction() {
        Action action = new Action();
        action.setAction_id("hsk_8273");
        action.setDescription("Players - Smart platform Handshake service in single VM");
        action.setName("HSK");
        action.setEnabled(true);
        return action;
    }

    private Action createLowLoadAction() {
        Action action = new Action();
        action.setAction_id("lowloadconfigurationinvm2_a");
        action.setDescription("Low load configuration for HSK service in single VM");
        action.setName("LowLoadConfigurationinVM2_A");
        action.setEnabled(true);
        return action;
    }

    private Enactment createAtosEnactment(Adaptation adaptation) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(adaptation.getFc_id());
        Calendar completion_time = Calendar.getInstance();
        Calendar request_time = Calendar.getInstance();
        request_time.add(Calendar.MINUTE, 5);
        completion_time.setTimeInMillis(60000);
        enactment.setEnactment_completion_time(completion_time.getTime());
        enactment.setEnactment_request_time(request_time.getTime());
        enactment.setResult(true);
        return enactment;
    }

    private Adaptation createSiemensAdaptation(Integer id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(id);
        Calendar computation = Calendar.getInstance();
        computation.add(Calendar.MINUTE, 10);
        adaptation.setComputation_timestamp(computation.getTime());
        adaptation.setModel_system(ModelSystem.Siemens);
        adaptation.setName((((ModelSystem.Siemens) + " ") + id));
        adaptation.setRank(1.0);
        adaptation.getActions().add(createSiemensAction());
        return adaptation;
    }

    private Action createSiemensAction() {
        Action action = new Action();
        action.setAction_id("c1");
        action.setDescription("GetMetheorologicalData composition for 90% availability");
        action.setName("SC1");
        action.setEnabled(true);
        return action;
    }

    private Enactment createSiemensEnactment(Adaptation adaptation) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(adaptation.getFc_id());
        Calendar completion_time = Calendar.getInstance();
        Calendar request_time = Calendar.getInstance();
        request_time.add(Calendar.MINUTE, 6);
        completion_time.setTimeInMillis(30000);
        enactment.setEnactment_completion_time(completion_time.getTime());
        enactment.setEnactment_request_time(request_time.getTime());
        enactment.setResult(true);
        return enactment;
    }
}

