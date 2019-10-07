package eu.supersede.integration.api.adaptation.proxies.test;


import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.Tenant;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AdapterProxyTest_Ampl4 {
    private static AdapterProxy<?, ?> proxy;

    private static AdaptationDashboardProxy<Object, Object> adaptationProxy;

    private static ModelRepositoryProxy<?, ?> modelRepositoryProxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdapterProxyTest_Ampl4.proxy = new AdapterProxy<Object, Object>();
        AdapterProxyTest_Ampl4.adaptationProxy = new AdaptationDashboardProxy<Object, Object>("adaptation", "adaptation", "atos");
        AdapterProxyTest_Ampl4.modelRepositoryProxy = new ModelRepositoryProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_add1() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactAdaptationDecisionActions_add1__15 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add1__15);
        boolean o_testEnactAdaptationDecisionActions_add1__16 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add1__16);
        HttpStatus o_testEnactAdaptationDecisionActions_add1__17 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add1__17)).toString());
        assertTrue(o_testEnactAdaptationDecisionActions_add1__15);
        assertTrue(o_testEnactAdaptationDecisionActions_add1__16);
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_add2() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation o_testEnactAdaptationDecisionActions_add2__5 = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactAdaptationDecisionActions_add2__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add2__16);
        boolean o_testEnactAdaptationDecisionActions_add2__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add2__17);
        HttpStatus o_testEnactAdaptationDecisionActions_add2__18 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add2__18)).toString());
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactAdaptationDecisionActions_add2__5)).getActions())).isEmpty());
        assertTrue(o_testEnactAdaptationDecisionActions_add2__16);
        assertTrue(o_testEnactAdaptationDecisionActions_add2__17);
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_add4() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactAdaptationDecisionActions_add4__15 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add4__15);
        boolean o_testEnactAdaptationDecisionActions_add4__16 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_add4__16);
        HttpStatus o_testEnactAdaptationDecisionActions_add4__17 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActions_add4__17)).toString());
        assertTrue(o_testEnactAdaptationDecisionActions_add4__15);
        assertTrue(o_testEnactAdaptationDecisionActions_add4__16);
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_mg35() throws Exception {
        Adaptation __DSPOT_a_0 = new Adaptation();
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactAdaptationDecisionActions_mg35__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_mg35__16);
        boolean o_testEnactAdaptationDecisionActions_mg35__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions_mg35__17);
        HttpStatus o_testEnactAdaptationDecisionActions_mg35__18 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).toString());
        int o_testEnactAdaptationDecisionActions_mg35__19 = adaptation.compareTo(__DSPOT_a_0);
        assertEquals(0, ((int) (o_testEnactAdaptationDecisionActions_mg35__19)));
        assertTrue(o_testEnactAdaptationDecisionActions_mg35__16);
        assertTrue(o_testEnactAdaptationDecisionActions_mg35__17);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActions_mg35__18)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString11_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSKSingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString11 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_mg37_failAssert0() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_2 = new Date("nj|}8wu]&8(Dgh`l V!3");
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_2);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_mg37 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionslitString74_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("wmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionslitString74 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull104_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), null);
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull104 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull105_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(null);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull105 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull106_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(null);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull106 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull110_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, null, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid adaptationDecisionActionIds", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_add1litString1637_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighL[ad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            boolean o_testEnactAdaptationDecisionActions_add1__15 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            boolean o_testEnactAdaptationDecisionActions_add1__16 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            HttpStatus o_testEnactAdaptationDecisionActions_add1__17 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_add1litString1637 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull110_failAssert0_mg763_failAssert0() throws Exception {
        try {
            {
                String __DSPOT_name_37 = "%hbH%0kY^9)l,IK)Mo+)";
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, null, featureConfigurationId);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110 should have thrown IllegalArgumentException");
                adaptation.setName(__DSPOT_name_37);
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110_failAssert0_mg763 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid adaptationDecisionActionIds", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_mg35litString1204_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_a_0 = new Adaptation();
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_High[oad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            boolean o_testEnactAdaptationDecisionActions_mg35__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            boolean o_testEnactAdaptationDecisionActions_mg35__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            HttpStatus o_testEnactAdaptationDecisionActions_mg35__18 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            int o_testEnactAdaptationDecisionActions_mg35__19 = adaptation.compareTo(__DSPOT_a_0);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_mg35litString1204 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__15 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__15);
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__16 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__16);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__22)).toString());
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__15);
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9407__16);
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5 = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__16);
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__17);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__23)).toString());
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__5)).getActions())).isEmpty());
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__16);
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_add9408__17);
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449() throws Exception {
        Adaptation __DSPOT_a_522 = new Adaptation();
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__16);
        boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__17);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).toString());
        int o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__24 = adaptation.compareTo(__DSPOT_a_522);
        assertEquals(0, ((int) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__24)));
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__16);
        assertTrue(o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__17);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9543_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, null, featureConfigurationAsString, featureConfigurationId);
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9543 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid adaptationDecisionActionIds", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, null, featureConfigurationId);
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid featureConfigurationAsString", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9545_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, null);
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9545 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid featureConfigurationId", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9543_failAssert0litString10690_failAssert0() throws Exception {
        try {
            {
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, null, featureConfigurationAsString, featureConfigurationId);
                org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9543 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9543_failAssert0litString10690 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid adaptationDecisionActionIds", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544_failAssert0_literalMutationString10214_failAssert0_add11852_failAssert0() throws Exception {
        try {
            {
                {
                    ModelSystem system = ModelSystem.Atos_HSK;
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
                    AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                    adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    List<String> adaptationDecisionActionIds = new ArrayList<>();
                    adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                    adaptationDecisionActionIds.add("");
                    Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                    AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, null, featureConfigurationId);
                    org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544_failAssert0_literalMutationString10214 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByStringnull9544_failAssert0_literalMutationString10214_failAssert0_add11852 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid featureConfigurationAsString", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449litString11156_failAssert0_mg12440_failAssert0() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_647 = Collections.singletonList(new Action());
                Adaptation __DSPOT_a_522 = new Adaptation();
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoa?d.yafc");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__16 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                boolean o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__17 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                HttpStatus o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__23 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
                int o_testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449__24 = adaptation.compareTo(__DSPOT_a_522);
                org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449litString11156 should have thrown NoSuchFileException");
                __DSPOT_a_522.setActions(__DSPOT_actions_647);
            }
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByString_mg9449litString11156_failAssert0_mg12440 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_add6415() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactFCGivenByString_add6415__18 = AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactFCGivenByString_add6415__18)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_add6416() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation o_testEnactFCGivenByString_add6416__5 = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactFCGivenByString_add6416__19 = AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactFCGivenByString_add6416__19)).toString());
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactFCGivenByString_add6416__5)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg6441() throws Exception {
        Adaptation __DSPOT_a_342 = new Adaptation();
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
        HttpStatus o_testEnactFCGivenByString_mg6441__19 = AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).toString());
        int o_testEnactFCGivenByString_mg6441__20 = adaptation.compareTo(__DSPOT_a_342);
        assertEquals(0, ((int) (o_testEnactFCGivenByString_mg6441__20)));
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactFCGivenByString_mg6441__19)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByStringlitString6491_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            org.junit.Assert.fail("testEnactFCGivenByStringlitString6491 should have thrown IOException");
        } catch (IOException expected) {
            assertEquals("Is a directory", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByStringnull6501_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, null, featureConfigurationId);
            org.junit.Assert.fail("testEnactFCGivenByStringnull6501 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid featureConfigurationAsString", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg6441_mg7152litString8527_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_a_390 = new Adaptation();
            Adaptation __DSPOT_a_342 = new Adaptation();
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVMl_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            HttpStatus o_testEnactFCGivenByString_mg6441__19 = AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            int o_testEnactFCGivenByString_mg6441__20 = adaptation.compareTo(__DSPOT_a_342);
            int o_testEnactFCGivenByString_mg6441_mg7152__27 = __DSPOT_a_342.compareTo(__DSPOT_a_390);
            org.junit.Assert.fail("testEnactFCGivenByString_mg6441_mg7152litString8527 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg6441_mg7152litString8674_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_a_390 = new Adaptation();
            Adaptation __DSPOT_a_342 = new Adaptation();
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            HttpStatus o_testEnactFCGivenByString_mg6441__19 = AdapterProxyTest_Ampl4.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            int o_testEnactFCGivenByString_mg6441__20 = adaptation.compareTo(__DSPOT_a_342);
            int o_testEnactFCGivenByString_mg6441_mg7152__27 = __DSPOT_a_342.compareTo(__DSPOT_a_390);
            org.junit.Assert.fail("testEnactFCGivenByString_mg6441_mg7152litString8674 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3927() throws Exception {
        uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testEnactAdaptationDecisionActionsForFC_add3927__12 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3927__12)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3928() throws Exception {
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation o_testEnactAdaptationDecisionActionsForFC_add3928__4 = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getActions())).isEmpty());
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testEnactAdaptationDecisionActionsForFC_add3928__13 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_add3928__13)).toString());
        assertEquals(1.0, ((double) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getRank())), 0.1);
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getTenant())).toString());
        assertEquals("atos", ((Tenant) (((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getTenant())).getId());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).toString());
        assertEquals("Atos", ((ModelSystem) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getModel_system())).getId());
        assertEquals("SmartPlatformFC_HSK_SingleVM_HighLoad", ((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getName());
        assertFalse(((Collection) (((Adaptation) (o_testEnactAdaptationDecisionActionsForFC_add3928__4)).getActions())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_mg3945() throws Exception {
        Adaptation __DSPOT_a_168 = new Adaptation();
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testEnactAdaptationDecisionActionsForFC_mg3945__13 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).toString());
        int o_testEnactAdaptationDecisionActionsForFC_mg3945__14 = adaptation.compareTo(__DSPOT_a_168);
        assertEquals(0, ((int) (o_testEnactAdaptationDecisionActionsForFC_mg3945__14)));
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is4xxClientError());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).is5xxServerError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945__13)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3987_failAssert0() throws Exception {
        try {
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, null);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3987 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid featureConfigurationId", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_mg3945_add4208() throws Exception {
        Adaptation __DSPOT_a_168 = new Adaptation();
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        HttpStatus o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is3xxRedirection());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is4xxClientError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).toString());
        HttpStatus o_testEnactAdaptationDecisionActionsForFC_mg3945__13 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
        int o_testEnactAdaptationDecisionActionsForFC_mg3945__14 = adaptation.compareTo(__DSPOT_a_168);
        assertEquals("Internal Server Error", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is3xxRedirection());
        assertTrue(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).is4xxClientError());
        assertEquals("500", ((HttpStatus) (o_testEnactAdaptationDecisionActionsForFC_mg3945_add4208__13)).toString());
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_literalMutationString3933_failAssert0_mg4279_failAssert0() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_179 = Collections.singletonList(new Action());
                String featureConfigurationId = uploadLatestComputedFC("");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_literalMutationString3933 should have thrown IOException");
                adaptation.setActions(__DSPOT_actions_179);
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_literalMutationString3933_failAssert0_mg4279 should have thrown IOException");
        } catch (IOException expected) {
            assertEquals("Is a directory", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3984_failAssert0null4659_failAssert0() throws Exception {
        try {
            {
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), null);
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(null);
                AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3984 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3984_failAssert0null4659 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3985_failAssert0litString4616_failAssert0() throws Exception {
        try {
            {
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(null);
                Assert.notNull(adaptation);
                AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3985 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3985_failAssert0litString4616 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3986_failAssert0litString4486_failAssert0_add5293_failAssert0() throws Exception {
        try {
            {
                {
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "High load configuration for HSK service");
                    adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(null);
                    AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3986 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3986_failAssert0litString4486 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3986_failAssert0litString4486_failAssert0_add5293 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3927_add4179null5999_failAssert0() throws Exception {
        try {
            uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation o_testEnactAdaptationDecisionActionsForFC_add3927_add4179__5 = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            Adaptation adaptation = createAdaptation(new Integer(featureConfigurationId), "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl4.adaptationProxy.addAdaptation(null);
            Assert.notNull(adaptation);
            HttpStatus o_testEnactAdaptationDecisionActionsForFC_add3927__12 = AdapterProxyTest_Ampl4.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3927_add4179null5999 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
        String userdir = System.getProperty("user.dir");
        ModelMetadata metadata = createFeatureConfigurationModelMetadata(fcName);
        IModel[] result = AdapterProxyTest_Ampl4.modelRepositoryProxy.createModelInstances(ModelType.FeatureConfiguration, metadata);
        Assert.notNull(result);
        Assert.notEmpty(result);
        FeatureConfiguration am = ((FeatureConfiguration) (result[0]));
        return am.getId();
    }

    private ModelMetadata createFeatureConfigurationModelMetadata(String fcName) throws IOException {
        ModelMetadata metadata = new ModelMetadata();
        metadata.setSender("DM Optimizer");
        metadata.setTimeStamp(Calendar.getInstance().getTime());
        List<IModel> modelInstances = createFeatureConfigurationMetadataInstances(fcName);
        metadata.setModelInstances(modelInstances);
        return metadata;
    }

    private List<IModel> createFeatureConfigurationMetadataInstances(String fcName) throws IOException {
        List<IModel> modelInstances = new ArrayList<>();
        FeatureConfiguration am = new FeatureConfiguration();
        modelInstances.add(am);
        am.setName(fcName);
        am.setAuthorId("DM Optimizer");
        am.setCreationDate(Calendar.getInstance().getTime());
        am.setLastModificationDate(Calendar.getInstance().getTime());
        am.setFileExtension(ModelType.FeatureConfiguration.getExtension());
        am.setSystemId(ModelSystem.Atos_HSK);
        am.setStatus(Status.Computed.toString());
        am.setRelativePath("features/configurations");
        am.setDependencies(new ArrayList<eu.supersede.integration.api.adaptation.types.TypedModelId>());
        am.setModelContent(getFeatureConfigurationContent(fcName));
        return modelInstances;
    }

    private String getFeatureConfigurationContent(String fcName) throws IOException {
        File f = new File("");
        List<String> lines = Files.readAllLines(Paths.get((((f.getAbsolutePath()) + "/src/test/resources/files/") + fcName)), StandardCharsets.UTF_8);
        String content = "";
        for (String s : lines) {
            content += s + "\n";
        }
        return content;
    }

    private Adaptation createAdaptation(Integer fc_id, String name) {
        Adaptation adaptation = new Adaptation();
        adaptation.setFc_id(fc_id);
        adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
        adaptation.setModel_system(ModelSystem.Atos);
        adaptation.setName(name);
        adaptation.setRank(1.0);
        adaptation.getActions().add(createActionA());
        adaptation.getActions().add(createActionB());
        return adaptation;
    }

    private Action createActionA() {
        Action action = new Action();
        action.setAction_id("highloadconfigurationinvm2_a");
        action.setDescription("High load configuration for HSK service");
        action.setName("VM2_A_HighConfiguration");
        action.setEnabled(true);
        return action;
    }

    private Action createActionB() {
        Action action = new Action();
        action.setAction_id("lowloadconfigurationinvm2_a");
        action.setDescription("Low load configuration for HSK service");
        action.setName("VM2_A_LowConfiguration");
        action.setEnabled(true);
        return action;
    }

    private <S extends IModel> String getLastComputedFeatureConfigurationForSystem(ModelSystem system) throws Exception {
        @SuppressWarnings("unchecked")
        List<S> metadata = ((List<S>) (AdapterProxyTest_Ampl4.modelRepositoryProxy.getModelInstances(ModelType.FeatureConfiguration, system, Status.Computed)));
        Collections.sort(metadata);
        IModel iModel = metadata.get(0);
        if ((iModel.getValue("id")) == null) {
            return null;
        }
        return ((String) (iModel.getValue("id")));
    }
}

