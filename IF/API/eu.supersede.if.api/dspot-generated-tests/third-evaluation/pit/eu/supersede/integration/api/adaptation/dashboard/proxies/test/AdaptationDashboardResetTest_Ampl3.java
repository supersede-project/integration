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
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class AdaptationDashboardResetTest_Ampl3 {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdaptationDashboardResetTest_Ampl3.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add15() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        Adaptation o_testResetDashboard_add15__30 = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        assertEquals("1238", ((Adaptation) (o_testResetDashboard_add15__30)).getFc_id());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).toString());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add15__30)).getRank())), 0.1);
        assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add15__30)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add15__30)).getActions())).isEmpty());
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1238", ((Adaptation) (o_testResetDashboard_add15__30)).getFc_id());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).toString());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add15__30)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add15__30)).getRank())), 0.1);
        assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add15__30)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add15__30)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull56_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(null);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull56 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull57_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(null);
            org.junit.Assert.fail("testResetDashboardnull57 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add14() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        Adaptation o_testResetDashboard_add14__27 = createSiemensAdaptation();
        assertEquals("1238", ((Adaptation) (o_testResetDashboard_add14__27)).getFc_id());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).toString());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add14__27)).getRank())), 0.1);
        assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add14__27)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add14__27)).getActions())).isEmpty());
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1238", ((Adaptation) (o_testResetDashboard_add14__27)).getFc_id());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getTenant())).toString());
        assertEquals("siemens", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getTenant())).getId());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).toString());
        assertEquals("Siemens", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add14__27)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add14__27)).getRank())), 0.1);
        assertEquals("Siemens 1238", ((Adaptation) (o_testResetDashboard_add14__27)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add14__27)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add8() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation o_testResetDashboard_add8__16 = createAtosAdaptation();
        assertEquals("1241", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1241", ((Adaptation) (o_testResetDashboard_add8__16)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add8__16)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testResetDashboard_add8__16)).getRank())), 0.1);
        assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add8__16)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add8__16)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add12_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_add12 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull48_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull48 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull55_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(null);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull55 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add9() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        Adaptation o_testResetDashboard_add9__19 = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        assertEquals("1241", ((Adaptation) (o_testResetDashboard_add9__19)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9__19)).getRank())), 0.1);
        assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add9__19)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9__19)).getActions())).isEmpty());
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1241", ((Adaptation) (o_testResetDashboard_add9__19)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testResetDashboard_add9__19)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testResetDashboard_add9__19)).getRank())), 0.1);
        assertEquals("Atos_HSK 1241", ((Adaptation) (o_testResetDashboard_add9__19)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testResetDashboard_add9__19)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add11() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment o_testResetDashboard_add11__22 = createAtosEnactment(adaptation);
        assertEquals("1241", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1241", ((Enactment) (o_testResetDashboard_add11__22)).getFc_id());
        assertTrue(((Enactment) (o_testResetDashboard_add11__22)).isResult());
        assertNull(((Enactment) (o_testResetDashboard_add11__22)).getAdaptation());
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull49_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(null);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull49 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull53_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(null);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull53 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg44_failAssert0() throws Exception {
        try {
            Date __DSPOT_enactment_completion_time_18 = new Date("&bk*201yCi*OdwpauR%h");
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_18);
            org.junit.Assert.fail("testResetDashboard_mg44 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_mg37() throws Exception {
        Adaptation __DSPOT_a_11 = new Adaptation();
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        int o_testResetDashboard_mg37__40 = adaptation.compareTo(__DSPOT_a_11);
        assertEquals(0, ((int) (o_testResetDashboard_mg37__40)));
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull54_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(null);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull54 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add18_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            enactment = createSiemensEnactment(adaptation);
            AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            org.junit.Assert.fail("testResetDashboard_add18 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull51_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(null);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull51 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull52_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(null);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull52 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboardnull50_failAssert0() throws Exception {
        try {
            List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
            for (Adaptation adaptation : adaptations) {
                Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
                if (enactment != null) {
                    AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
                }
                AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
            }
            Adaptation adaptation = createAtosAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(null);
            Enactment enactment = createAtosEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            Assert.notNull(enactment);
            adaptation = createSiemensAdaptation();
            adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
            enactment = createSiemensEnactment(adaptation);
            enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
            org.junit.Assert.fail("testResetDashboardnull50 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testResetDashboard_add17() throws Exception {
        List<Adaptation> adaptations = AdaptationDashboardResetTest_Ampl3.proxy.getAllAdaptations();
        for (Adaptation adaptation : adaptations) {
            Enactment enactment = AdaptationDashboardResetTest_Ampl3.proxy.getEnactment(adaptation.getFc_id());
            if (enactment != null) {
                AdaptationDashboardResetTest_Ampl3.proxy.deleteEnactment(adaptation.getFc_id());
            }
            AdaptationDashboardResetTest_Ampl3.proxy.deleteAdaptation(adaptation.getFc_id());
        }
        Adaptation adaptation = createAtosAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        Enactment enactment = createAtosEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        Assert.notNull(enactment);
        Assert.notNull(enactment);
        adaptation = createSiemensAdaptation();
        adaptation = AdaptationDashboardResetTest_Ampl3.proxy.addAdaptation(adaptation);
        Enactment o_testResetDashboard_add17__33 = createSiemensEnactment(adaptation);
        assertEquals("1238", ((Enactment) (o_testResetDashboard_add17__33)).getFc_id());
        assertTrue(((Enactment) (o_testResetDashboard_add17__33)).isResult());
        assertNull(((Enactment) (o_testResetDashboard_add17__33)).getAdaptation());
        enactment = createSiemensEnactment(adaptation);
        enactment = AdaptationDashboardResetTest_Ampl3.proxy.addEnactment(enactment);
        assertEquals("1238", ((Enactment) (o_testResetDashboard_add17__33)).getFc_id());
        assertTrue(((Enactment) (o_testResetDashboard_add17__33)).isResult());
        assertNull(((Enactment) (o_testResetDashboard_add17__33)).getAdaptation());
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

