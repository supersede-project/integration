package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Tenant;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;

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
        Adaptation o_testResetDashboard_add8__16 = createAtosAdaptation();
        Assert.assertEquals("1241", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        Assert.assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1241", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        Assert.assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add9() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        Adaptation o_testResetDashboard_add9__19 = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        Assert.assertEquals("1241", ((Adaptation) (o_testResetDashboard_add9__19)).getFc_id());
        Assert.assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9__19)).getRank())), 0.1);
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getId());
        Assert.assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add9__19)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9__19)).getActions())).isEmpty());
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1241", ((Adaptation) (o_testResetDashboard_add9__19)).getFc_id());
        Assert.assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9__19)).getRank())), 0.1);
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).toString());
        Assert.assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getId());
        Assert.assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add9__19)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9__19)).getActions())).isEmpty());
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
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment o_testResetDashboard_add11__22 = createAtosEnactment(adaptation);
        Assert.assertEquals("1241", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1241", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add17() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        Enactment o_testResetDashboard_add17__33 = createSiemensEnactment(adaptation);
        Assert.assertEquals("1238", ((Enactment) (o_testResetDashboard_add17__33)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add17__33)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add17__33)).getAdaptation());
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        Assert.assertEquals("1238", ((Enactment) (o_testResetDashboard_add17__33)).getFc_id());
        Assert.assertTrue(((Enactment) (o_testResetDashboard_add17__33)).isResult());
        Assert.assertNull(((Enactment) (o_testResetDashboard_add17__33)).getAdaptation());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg37() throws Exception {
        Adaptation __DSPOT_a_11 = new Adaptation();
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        int o_testResetDashboard_mg37__40 = adaptation.compareTo(__DSPOT_a_11);
        Assert.assertEquals(0, ((int) (o_testResetDashboard_mg37__40)));
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
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
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
    public void testResetDashboard_mg44_failAssert0() throws Exception {
        try {
            Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
            org.junit.Assert.fail("testResetDashboard_mg44 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull48_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull48 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull49_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(null);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull49 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(null);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull55_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull55 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull56_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(null);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull56 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add8_mg1047() throws Exception {
        Adaptation __DSPOT_a_332 = new Adaptation();
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation o_testResetDashboard_add8__16 = createAtosAdaptation();
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        int o_testResetDashboard_add8_mg1047__43 = adaptation.compareTo(__DSPOT_a_332);
        Assert.assertEquals(0, ((int) (o_testResetDashboard_add8_mg1047__43)));
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull48_failAssert0_add224_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull48 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull48_failAssert0_add224 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull55_failAssert0_mg513_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_adaptation_54 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    enactment.setAdaptation(__DSPOT_adaptation_54);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull55 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull55_failAssert0_mg513 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0_mg558_failAssert0() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_80 = Collections.singletonList(new Action());
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
                adaptation.setActions(__DSPOT_actions_80);
            }
            org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg558 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull49_failAssert0_add496_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(null);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                createSiemensEnactment(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull49 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull49_failAssert0_add496 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull48_failAssert0null914_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(null);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull48 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull48_failAssert0null914 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0_mg500_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_49 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_49);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0_mg500 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add17null987_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            Enactment o_testResetDashboard_add17__33 = createSiemensEnactment(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboard_add17null987 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull56_failAssert0_mg506_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    double __DSPOT_rank_51 = 0.6158882738652133;
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.setRank(__DSPOT_rank_51);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(null);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull56 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull56_failAssert0_mg506 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0_add306_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboard_add12_failAssert0_add306 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull55_failAssert0_add417_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                AdaptationDashboardResetTest.proxy.addAdaptation(null);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull55 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull55_failAssert0_add417 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg44_failAssert0_mg858_failAssert0() throws Exception {
        try {
            {
                Adaptation __DSPOT_adaptation_273 = new Adaptation();
                Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
                org.junit.Assert.fail("testResetDashboard_mg44 should have thrown IllegalArgumentException");
                enactment.setAdaptation(__DSPOT_adaptation_273);
            }
            org.junit.Assert.fail("testResetDashboard_mg44_failAssert0_mg858 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0_mg759_failAssert0() throws Exception {
        try {
            {
                String __DSPOT_name_219 = "vhH&a[&sg2R8>3aX.)v8";
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
                adaptation.setName(__DSPOT_name_219);
            }
            org.junit.Assert.fail("testResetDashboardnull52_failAssert0_mg759 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0_add289_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull50_failAssert0_add289 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add8null1093_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation o_testResetDashboard_add8__16 = createAtosAdaptation();
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            notNull(adaptation);
            notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
            notNull(enactment);
            notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
            org.junit.Assert.fail("testResetDashboard_add8null1093 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0null826_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(null);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0null826 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0_add274_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull52_failAssert0_add274 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0_mg515_failAssert0() throws Exception {
        try {
            {
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Adaptation __DSPOT_a_55 = new Adaptation();
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    adaptation.compareTo(__DSPOT_a_55);
                }
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(null);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull50_failAssert0_mg515 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add9_add732_add3247() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        Adaptation o_testResetDashboard_add9__19 = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        Adaptation o_testResetDashboard_add9_add732__30 = createSiemensAdaptation();
        adaptation = createSiemensAdaptation();
        Adaptation o_testResetDashboard_add9_add732_add3247__36 = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        Assert.assertEquals("1238", ((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getFc_id());
        Assert.assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getRank())), 0.1);
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).toString());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getId());
        Assert.assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getActions())).isEmpty());
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        Assert.assertEquals("1238", ((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getFc_id());
        Assert.assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getRank())), 0.1);
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).toString());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getModel_system())).getId());
        Assert.assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9_add732_add3247__36)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg37_mg625_add1958() throws Exception {
        Adaptation __DSPOT_a_117 = new Adaptation();
        Adaptation __DSPOT_a_11 = new Adaptation();
        List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        notNull(adaptation);
        notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        notNull(enactment);
        notNull(enactment);
        Adaptation o_testResetDashboard_mg37_mg625_add1958__33 = createSiemensAdaptation();
        Assert.assertEquals("1238", ((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getFc_id());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getRank())), 0.1);
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).toString());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getId());
        Assert.assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getActions())).isEmpty());
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
        int o_testResetDashboard_mg37__40 = adaptation.compareTo(__DSPOT_a_11);
        int o_testResetDashboard_mg37_mg625__45 = __DSPOT_a_11.compareTo(__DSPOT_a_117);
        Assert.assertEquals("1238", ((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getFc_id());
        Assert.assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getRank())), 0.1);
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getTenant())).toString());
        Assert.assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getTenant())).getId());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).toString());
        Assert.assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getModel_system())).getId());
        Assert.assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getName());
        Assert.assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_mg37_mg625_add1958__33)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0_add334_failAssert0_mg2643_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        boolean __DSPOT_result_831 = true;
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setResult(__DSPOT_result_831);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull52_failAssert0_add334 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull52_failAssert0_add334_failAssert0_mg2643 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0_mg515_failAssert0_mg2444_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        List<Action> __DSPOT_actions_679 = Collections.<Action>emptyList();
                        Adaptation __DSPOT_a_55 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_55);
                        __DSPOT_a_55.setActions(__DSPOT_actions_679);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(null);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testResetDashboardnull50_failAssert0_mg515 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull50_failAssert0_mg515_failAssert0_mg2444 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0null856_failAssert0_add1642_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(null);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull57_failAssert0null856 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0null856_failAssert0_add1642 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0null856_failAssert0_mg2329_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Date __DSPOT_enactment_completion_time_581 = new Date("#O7,e!<J!z&e#9R[n4Y#");
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_581);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(null);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull57_failAssert0null856 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0null856_failAssert0_mg2329 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add17null987_failAssert0_add2952_failAssert0() throws Exception {
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
                Adaptation adaptation = createAtosAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                Enactment o_testResetDashboard_add17__33 = createSiemensEnactment(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                org.junit.Assert.fail("testResetDashboard_add17null987 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboard_add17null987_failAssert0_add2952 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0_mg558_failAssert0_mg2180_failAssert0() throws Exception {
        try {
            {
                {
                    List<Action> __DSPOT_actions_80 = Collections.singletonList(new Action());
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_471 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_471);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
                    adaptation.setActions(__DSPOT_actions_80);
                }
                org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg558 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testResetDashboard_add12_failAssert0_mg558_failAssert0_mg2180 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add9null1106_failAssert0_mg2810_failAssert0() throws Exception {
        try {
            {
                Date __DSPOT_enactment_completion_time_910 = new Date(2057896115, -1737204186, -1131449936, -1138191181, -1425554044);
                List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                for (Adaptation adaptation : adaptations) {
                    Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                    if (enactment != null) {
                        AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                    }
                    AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                }
                Adaptation adaptation = createAtosAdaptation();
                Adaptation o_testResetDashboard_add9__19 = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                notNull(adaptation);
                notNull(adaptation);
                Enactment enactment = createAtosEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                notNull(enactment);
                notNull(enactment);
                adaptation = createSiemensAdaptation();
                adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                enactment = createSiemensEnactment(adaptation);
                enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                org.junit.Assert.fail("testResetDashboard_add9null1106 should have thrown NullPointerException");
                enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_910);
            }
            org.junit.Assert.fail("testResetDashboard_add9null1106_failAssert0_mg2810 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0_add289_failAssert0_add2101_failAssert0() throws Exception {
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
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(null);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testResetDashboardnull50_failAssert0_add289 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testResetDashboardnull50_failAssert0_add289_failAssert0_add2101 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            Assert.assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0_add274_failAssert0_mg2200_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        boolean __DSPOT_result_482 = false;
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        enactment.setResult(__DSPOT_result_482);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull52_failAssert0_add274 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull52_failAssert0_add274_failAssert0_mg2200 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0_mg500_failAssert0null2900_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_49 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_49);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(null);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull57_failAssert0_mg500 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0_mg500_failAssert0null2900 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0_mg500_failAssert0_mg2465_failAssert0() throws Exception {
        try {
            {
                {
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        boolean __DSPOT_result_696 = false;
                        Adaptation __DSPOT_a_49 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_49);
                        enactment.setResult(__DSPOT_result_696);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testResetDashboardnull57_failAssert0_mg500 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull57_failAssert0_mg500_failAssert0_mg2465 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0_mg759_failAssert0_mg2184_failAssert0() throws Exception {
        try {
            {
                {
                    String __DSPOT_name_219 = "vhH&a[&sg2R8>3aX.)v8";
                    List<Adaptation> adaptations = AdaptationDashboardResetTest.proxy.getAllAdaptations();
                    for (Adaptation adaptation : adaptations) {
                        Adaptation __DSPOT_a_503 = new Adaptation();
                        Enactment enactment = AdaptationDashboardResetTest.proxy.getEnactment(adaptation.getFc_id());
                        if (enactment != null) {
                            AdaptationDashboardResetTest.proxy.deleteEnactment(adaptation.getFc_id());
                        }
                        AdaptationDashboardResetTest.proxy.deleteAdaptation(adaptation.getFc_id());
                        adaptation.compareTo(__DSPOT_a_503);
                    }
                    Adaptation adaptation = createAtosAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    notNull(adaptation);
                    notNull(adaptation);
                    Enactment enactment = createAtosEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(null);
                    notNull(enactment);
                    notNull(enactment);
                    adaptation = createSiemensAdaptation();
                    adaptation = AdaptationDashboardResetTest.proxy.addAdaptation(adaptation);
                    enactment = createSiemensEnactment(adaptation);
                    enactment = AdaptationDashboardResetTest.proxy.addEnactment(enactment);
                    org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
                    adaptation.setName(__DSPOT_name_219);
                }
                org.junit.Assert.fail("testResetDashboardnull52_failAssert0_mg759 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testResetDashboardnull52_failAssert0_mg759_failAssert0_mg2184 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    private Adaptation createAtosAdaptation() {
        Adaptation adaptation = new Adaptation();
        String id = "1241";
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

    private Adaptation createSiemensAdaptation() {
        Adaptation adaptation = new Adaptation();
        String id = "1238";
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

