package eu.supersede.integration.api.adaptation.dashboard.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Tenant;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;


public class AdaptationDashboardProxyTest_Ampl2 {
    private static AdaptationDashboardProxy<Object, Object> proxy;

    private static String adaptationId;

    private static String enactmentId;

    @BeforeClass
    public static void setup() throws Exception {
    	AdaptationDashboardProxyTest_Ampl2.proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "senercon");
        List<Adaptation> adaptations = AdaptationDashboardProxyTest_Ampl2.proxy.getAllAdaptations();
        Assert.notEmpty(adaptations);
        AdaptationDashboardProxyTest_Ampl2.adaptationId = adaptations.get(0).getFc_id();
        Assert.notNull(AdaptationDashboardProxyTest_Ampl2.adaptationId);





    }

    @Test(timeout = 30000)
    public void testGetAdaptation_add3216() throws Exception {
        Adaptation o_testGetAdaptation_add3216__1 = createAdaptation("905");
        assertEquals("905", ((Adaptation) (o_testGetAdaptation_add3216__1)).getFc_id());
        assertEquals(1.0, ((double) (((Adaptation) (o_testGetAdaptation_add3216__1)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testGetAdaptation_add3216__1)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testGetAdaptation_add3216__1)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("905", ((Adaptation) (o_testGetAdaptation_add3216__1)).getFc_id());
        assertEquals(1.0, ((double) (((Adaptation) (o_testGetAdaptation_add3216__1)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_add3216__1)).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testGetAdaptation_add3216__1)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testGetAdaptation_add3216__1)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg3233() throws Exception {
        Adaptation __DSPOT_a_281 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptation_mg3233__14 = adaptation.compareTo(__DSPOT_a_281);
        assertEquals(0, ((int) (o_testGetAdaptation_mg3233__14)));
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_literalMutationString3227_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptation_literalMutationString3227 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_literalMutationString3228_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("9/05");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptation_literalMutationString3228 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptationlitString3244_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Assert.notNull(adaptation);
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testGetAdaptationlitString3244 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_mg3233_add3415() throws Exception {
        Adaptation __DSPOT_a_281 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        Adaptation o_testGetAdaptation_mg3233_add3415__5 = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        assertEquals("905", ((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getActions())).isEmpty());
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testGetAdaptation_mg3233__14 = adaptation.compareTo(__DSPOT_a_281);
        assertEquals("905", ((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testGetAdaptation_mg3233_add3415__5)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetAdaptation_literalMutationString3228_failAssert0litString3495_failAssert0() throws Exception {
        try {
            {
                Adaptation adaptation = createAdaptation("r;pu");
                adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Assert.notNull(adaptation);
                adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.getAdaptation(adaptation.getFc_id());
                AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
                org.junit.Assert.fail("testGetAdaptation_literalMutationString3228 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testGetAdaptation_literalMutationString3228_failAssert0litString3495 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_add1() throws Exception {
        Adaptation o_testAddAdaptation_add1__1 = createAdaptation("905");
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_add1__1)).getFc_id());
        assertEquals(1.0, ((double) (((Adaptation) (o_testAddAdaptation_add1__1)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_add1__1)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_add1__1)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_add1__1)).getFc_id());
        assertEquals(1.0, ((double) (((Adaptation) (o_testAddAdaptation_add1__1)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_add1__1)).getModel_system())).getId());
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_add1__1)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_add1__1)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg14() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptation_mg14__10 = adaptation.compareTo(__DSPOT_a_0);
        assertEquals(0, ((int) (o_testAddAdaptation_mg14__10)));
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_literalMutationString9_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("9}05");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptation_literalMutationString9 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationlitString28_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("Medium load configuration for HSK service");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationlitString28 should have thrown URISyntaxException");
        } catch (URISyntaxException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull36_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation(null);
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull36 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull37_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(null);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddAdaptationnull37 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg14_add180() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        Adaptation o_testAddAdaptation_mg14_add180__3 = createAdaptation("905");
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation("905");
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptation_mg14__10 = adaptation.compareTo(__DSPOT_a_0);
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getModel_system())).getId());
        assertEquals(1.0, ((double) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_mg14_add180__3)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg14_add184() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        Adaptation adaptation = createAdaptation("905");
        Adaptation o_testAddAdaptation_mg14_add184__5 = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getActions())).isEmpty());
        adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
        int o_testAddAdaptation_mg14__10 = adaptation.compareTo(__DSPOT_a_0);
        assertEquals("905", ((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getFc_id());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).toString());
        assertEquals("Atos_HSK", ((ModelSystem) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getModel_system())).getId());
        assertEquals(0.0, ((double) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getRank())), 0.1);
        assertEquals("Medium load configuration for HSK service", ((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testAddAdaptation_mg14_add184__5)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddAdaptationnull36_failAssert0_mg194_failAssert0_add901_failAssert0() throws Exception {
        try {
            {
                {
                    double __DSPOT_rank_20 = 0.5387532636112112;
                    Adaptation adaptation = createAdaptation(null);
                    adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Assert.notNull(adaptation);
                    AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddAdaptationnull36 should have thrown HttpMessageNotReadableException");
                    adaptation.setRank(__DSPOT_rank_20);
                }
                org.junit.Assert.fail("testAddAdaptationnull36_failAssert0_mg194 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testAddAdaptationnull36_failAssert0_mg194_failAssert0_add901 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddAdaptation_mg14_mg240_mg982_failAssert0() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_76 = new Date("2&pb?56TtKz.F5M(E@of");
            Adaptation __DSPOT_a_36 = new Adaptation();
            Adaptation __DSPOT_a_0 = new Adaptation();
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            int o_testAddAdaptation_mg14__10 = adaptation.compareTo(__DSPOT_a_0);
            int o_testAddAdaptation_mg14_mg240__15 = adaptation.compareTo(__DSPOT_a_36);
            __DSPOT_a_0.setComputation_timestamp(__DSPOT_computation_timestamp_76);
            org.junit.Assert.fail("testAddAdaptation_mg14_mg240_mg982 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private Adaptation createAdaptation(String fc_id) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(fc_id);
        adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
        adaptation.setModel_system(ModelSystem.Atos_HSK);
        adaptation.setName("Medium load configuration for HSK service");
        adaptation.setRank(1.0);
        adaptation.getActions().add(createAction());
        return adaptation;
    }

    private Action createAction() {
        Action action = new Action();
        action.setAction_id("vm2_b_high");
        action.setDescription("Medium load configuration for HSK service");
        action.setName("VM2_B_HighConfiguration");
        action.setEnabled(true);
        return action;
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull5297_failAssert0() throws Exception {
        try {
            List<Enactment> adaptations = AdaptationDashboardProxyTest_Ampl2.proxy.getAllEnactments();
            Assert.notNull(null);
            org.junit.Assert.fail("testGetAllEnactmentsnull5297 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetAllEnactmentsnull5297_failAssert0_add5309_failAssert0() throws Exception {
        try {
            {
                AdaptationDashboardProxyTest_Ampl2.proxy.getAllEnactments();
                List<Enactment> adaptations = AdaptationDashboardProxyTest_Ampl2.proxy.getAllEnactments();
                Assert.notNull(null);
                org.junit.Assert.fail("testGetAllEnactmentsnull5297 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetAllEnactmentsnull5297_failAssert0_add5309 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_add5339() throws Exception {
        Enactment o_testGetEnactment_add5339__1 = AdaptationDashboardProxyTest_Ampl2.proxy.getEnactment(AdaptationDashboardProxyTest_Ampl2.enactmentId);
        assertNull(o_testGetEnactment_add5339__1);
        Enactment enactment = AdaptationDashboardProxyTest_Ampl2.proxy.getEnactment(AdaptationDashboardProxyTest_Ampl2.enactmentId);

        assertNull(o_testGetEnactment_add5339__1);
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg5340_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_adaptation_467 = new Adaptation();
            Enactment enactment = AdaptationDashboardProxyTest_Ampl2.proxy.getEnactment(AdaptationDashboardProxyTest_Ampl2.enactmentId);

            enactment.setAdaptation(__DSPOT_adaptation_467);
            org.junit.Assert.fail("testGetEnactment_mg5340 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg5341_failAssert0() throws Exception {
        try {
            Date __DSPOT_enactment_completion_time_468 = new Date(-196662320, 2027955824, -1357756128);
            Enactment enactment = AdaptationDashboardProxyTest_Ampl2.proxy.getEnactment(AdaptationDashboardProxyTest_Ampl2.enactmentId);

            enactment.setEnactment_completion_time(__DSPOT_enactment_completion_time_468);
            org.junit.Assert.fail("testGetEnactment_mg5341 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetEnactment_mg5340_failAssert0_mg5377_failAssert0() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_475 = Collections.singletonList(new Action());
                Adaptation __DSPOT_adaptation_467 = new Adaptation();
                Enactment enactment = AdaptationDashboardProxyTest_Ampl2.proxy.getEnactment(AdaptationDashboardProxyTest_Ampl2.enactmentId);

                enactment.setAdaptation(__DSPOT_adaptation_467);
                org.junit.Assert.fail("testGetEnactment_mg5340 should have thrown NullPointerException");
                __DSPOT_adaptation_467.setActions(__DSPOT_actions_475);
            }
            org.junit.Assert.fail("testGetEnactment_mg5340_failAssert0_mg5377 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactment_add1892_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.addEnactment(enactment);
            enactment = AdaptationDashboardProxyTest_Ampl2.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactment_add1892 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentlitString1924_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("\n");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest_Ampl2.proxy.addEnactment(enactment);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentlitString1924 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull1936_failAssert0() throws Exception {
        try {
            Adaptation adaptation = createAdaptation("905");
            adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
            Enactment enactment = createEnactment(adaptation.getFc_id());
            enactment = AdaptationDashboardProxyTest_Ampl2.proxy.addEnactment(null);
            Assert.notNull(enactment);
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteEnactment(adaptation.getFc_id());
            AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
            org.junit.Assert.fail("testAddEnactmentnull1936 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddEnactmentnull1936_failAssert0_literalMutationString2134_failAssert0litString2853_failAssert0() throws Exception {
        try {
            {
                {
                    Adaptation adaptation = createAdaptation("^p05");
                    adaptation = AdaptationDashboardProxyTest_Ampl2.proxy.addAdaptation(adaptation);
                    Enactment enactment = createEnactment(adaptation.getFc_id());
                    enactment = AdaptationDashboardProxyTest_Ampl2.proxy.addEnactment(null);
                    Assert.notNull(enactment);
                    AdaptationDashboardProxyTest_Ampl2.proxy.deleteEnactment(adaptation.getFc_id());
                    AdaptationDashboardProxyTest_Ampl2.proxy.deleteAdaptation(adaptation.getFc_id());
                    org.junit.Assert.fail("testAddEnactmentnull1936 should have thrown NullPointerException");
                }
                org.junit.Assert.fail("testAddEnactmentnull1936_failAssert0_literalMutationString2134 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testAddEnactmentnull1936_failAssert0_literalMutationString2134_failAssert0litString2853 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private Enactment createEnactment(String fc_id) {
        Enactment enactment = new Enactment();
        enactment.setFc_id(fc_id);
        enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
        enactment.setEnactment_request_time(Calendar.getInstance().getTime());
        enactment.setResult(true);
        return enactment;
    }
}

