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
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AdapterProxyTest_Ampl2 {
    private static AdapterProxy<?, ?> proxy;

    private static AdaptationDashboardProxy<Object, Object> adaptationProxy;

    private static ModelRepositoryProxy<?, ?> modelRepositoryProxy;

    @BeforeClass
    public static void setup() throws Exception {
        AdapterProxyTest_Ampl2.proxy = new AdapterProxy<Object, Object>();
        AdapterProxyTest_Ampl2.adaptationProxy = new AdaptationDashboardProxy<Object, Object>("adaptation", "adaptation", "atos");
        AdapterProxyTest_Ampl2.modelRepositoryProxy = new ModelRepositoryProxy<Object, Object>();
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions() throws Exception {
        ModelSystem system = ModelSystem.Atos_HSK;
        String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
        Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
        adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
        Assert.notNull(adaptation);
        List<String> adaptationDecisionActionIds = new ArrayList<>();
        boolean o_testEnactAdaptationDecisionActions__13 = adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions__13);
        boolean o_testEnactAdaptationDecisionActions__14 = adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
        assertTrue(o_testEnactAdaptationDecisionActions__14);
        Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
        Assert.isTrue(result);
        assertTrue(o_testEnactAdaptationDecisionActions__13);
        assertTrue(o_testEnactAdaptationDecisionActions__14);
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString13_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSKSingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString13 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString23_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "X(r!Fs2l>UgIvC=TU&zgYc TM1`_8;0L`A=SO");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString23 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString29_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("OKS@Rl&{ha!&Bcvg[?i!rb0/|]6^");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString29 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString34_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString34 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_mg39_failAssert0() throws Exception {
        try {
            Date __DSPOT_computation_timestamp_2 = new Date("nj|}8wu]&8(Dgh`l V!3");
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            adaptation.setComputation_timestamp(__DSPOT_computation_timestamp_2);
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_mg39 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionslitString49_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("\n");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionslitString49 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
            assertEquals("/var/jenkins_home/workspace/supersede-if-dspot-script/IF/API/eu.supersede.if.api/src/test/resources/files/\n", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull108_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(null, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull108 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull110_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(null);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull111_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(null);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull111 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull115_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            List<String> adaptationDecisionActionIds = new ArrayList<>();
            adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
            adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, null, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull115 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide valid adaptationDecisionActionIds", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString34_failAssert0litString779_failAssert0() throws Exception {
        try {
            {
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "llB^!%Y]_E]i.}JC]TrhX0]_^tFCqr,tX[gb ");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconigurationinvm2_a");
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString34 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString34_failAssert0litString779 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActions_literalMutationString23_failAssert0litString1194_failAssert0() throws Exception {
        try {
            {
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "X(r!Fs2l>UgIvC=TU&zgYc M1`_8;0L`A=SO");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString23 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActions_literalMutationString23_failAssert0litString1194 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsnull110_failAssert0_add448_failAssert0() throws Exception {
        try {
            {
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(null);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsnull110_failAssert0_add448 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactSelectedAdaptationDecisionsInFCGivenByString_mg7279_failAssert0litString8072_failAssert0() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_366 = new Adaptation();
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                List<String> adaptationDecisionActionIds = new ArrayList<>();
                adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
                adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
                Path fcPath = Paths.get("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
                Assert.isTrue(result);
                adaptation.compareTo(__DSPOT_a_366);
                org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByString_mg7279 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testEnactSelectedAdaptationDecisionsInFCGivenByString_mg7279_failAssert0litString8072 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg5216_failAssert0() throws Exception {
        try {
            Adaptation __DSPOT_a_264 = new Adaptation();
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            Assert.isTrue(result);
            adaptation.compareTo(__DSPOT_a_264);
            org.junit.Assert.fail("testEnactFCGivenByString_mg5216 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg5217_failAssert0() throws Exception {
        try {
            List<Action> __DSPOT_actions_265 = Collections.singletonList(new Action());
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            Assert.isTrue(result);
            adaptation.setActions(__DSPOT_actions_265);
            org.junit.Assert.fail("testEnactFCGivenByString_mg5217 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByStringlitString5241_failAssert0() throws Exception {
        try {
            ModelSystem system = ModelSystem.Atos_HSK;
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_Highoad.yafc");
            String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactFCGivenByStringlitString5241 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg5217_failAssert0litString5770_failAssert0() throws Exception {
        try {
            {
                List<Action> __DSPOT_actions_265 = Collections.singletonList(new Action());
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
                Assert.isTrue(result);
                adaptation.setActions(__DSPOT_actions_265);
                org.junit.Assert.fail("testEnactFCGivenByString_mg5217 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testEnactFCGivenByString_mg5217_failAssert0litString5770 should have thrown IOException");
        } catch (IOException expected) {
            assertEquals("Is a directory", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactFCGivenByString_mg5216_failAssert0litString5747_failAssert0() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_264 = new Adaptation();
                ModelSystem system = ModelSystem.Atos_HSK;
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HiJghLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
                Assert.isTrue(result);
                adaptation.compareTo(__DSPOT_a_264);
                org.junit.Assert.fail("testEnactFCGivenByString_mg5216 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testEnactFCGivenByString_mg5216_failAssert0litString5747 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3025_failAssert0() throws Exception {
        try {
            uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3025 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0() throws Exception {
        try {
            String __DSPOT_fc_id_123 = "m&{:-/38n(LZ=I%e;*vS";
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
            Assert.isTrue(result);
            adaptation.setFc_id(__DSPOT_fc_id_123);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFClitString3054_failAssert0() throws Exception {
        try {
            String featureConfigurationId = uploadLatestComputedFC("SmartPatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFClitString3054 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3088_failAssert0() throws Exception {
        try {
            String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
            Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
            adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
            Assert.notNull(adaptation);
            Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, null);
            Assert.isTrue(result);
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3088 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid featureConfigurationId", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3025_failAssert0litString3537_failAssert0() throws Exception {
        try {
            {
                uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVMhHighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3025 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3025_failAssert0litString3537 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFClitString3054_failAssert0_mg3329_failAssert0() throws Exception {
        try {
            {
                Adaptation __DSPOT_a_126 = new Adaptation();
                String featureConfigurationId = uploadLatestComputedFC("SmartPatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFClitString3054 should have thrown NoSuchFileException");
                adaptation.compareTo(__DSPOT_a_126);
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFClitString3054_failAssert0_mg3329 should have thrown NoSuchFileException");
        } catch (NoSuchFileException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3030_failAssert0_add3226_failAssert0() throws Exception {
        try {
            {
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(adaptation);
                AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                Assert.isTrue(result);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3030 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3030_failAssert0_add3226 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3087_failAssert0litString3686_failAssert0() throws Exception {
        try {
            {
                String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                Adaptation adaptation = createAdaptation(featureConfigurationId, "Vp5h+El_H3)p PdrmWUE([ NxcyWZkasdnA%M");
                adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                Assert.notNull(null);
                Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                Assert.isTrue(result);
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3087 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3087_failAssert0litString3686 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_add3030_failAssert0null3749_failAssert0litString4783_failAssert0() throws Exception {
        try {
            {
                {
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_#ingleVM_HighLoad");
                    adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(null);
                    Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    Assert.isTrue(result);
                    Assert.isTrue(result);
                    org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3030 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3030_failAssert0null3749 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_add3030_failAssert0null3749_failAssert0litString4783 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFCnull3084_failAssert0_literalMutationString3370_failAssert0litString4658_failAssert0() throws Exception {
        try {
            {
                {
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    Adaptation adaptation = createAdaptation(null, "\n");
                    adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    Assert.isTrue(result);
                    org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3084 should have thrown HttpMessageNotReadableException");
                }
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3084_failAssert0_literalMutationString3370 should have thrown HttpMessageNotReadableException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFCnull3084_failAssert0_literalMutationString3370_failAssert0litString4658 should have thrown HttpMessageNotReadableException");
        } catch (HttpMessageNotReadableException expected) {
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242_failAssert0litString4464_failAssert0() throws Exception {
        try {
            {
                {
                    String __DSPOT_fc_id_123 = "m&{:-/38n(LZ=I%e;*vS";
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    createAdaptation(featureConfigurationId, "adaptation");
                    Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                    adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    Assert.isTrue(result);
                    adaptation.setFc_id(__DSPOT_fc_id_123);
                    org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242_failAssert0litString4464 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242_failAssert0litString4483_failAssert0() throws Exception {
        try {
            {
                {
                    String __DSPOT_fc_id_123 = "m&{:-/38n(LZ=I%e;*vS";
                    String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
                    createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
                    Adaptation adaptation = createAdaptation(featureConfigurationId, "^uTe=TKkftLA4)55VDw]{.2 &9!?oyn.<}&NT");
                    adaptation = AdapterProxyTest_Ampl2.adaptationProxy.addAdaptation(adaptation);
                    Assert.notNull(adaptation);
                    Boolean result = AdapterProxyTest_Ampl2.proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
                    Assert.isTrue(result);
                    adaptation.setFc_id(__DSPOT_fc_id_123);
                    org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testEnactAdaptationDecisionActionsForFC_mg3048_failAssert0_add3242_failAssert0litString4483 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
        String userdir = System.getProperty("user.dir");
        ModelMetadata metadata = createFeatureConfigurationModelMetadata(fcName);
        IModel[] result = AdapterProxyTest_Ampl2.modelRepositoryProxy.createModelInstances(ModelType.FeatureConfiguration, metadata);
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

    private Adaptation createAdaptation(String fc_id, String name) {
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
        List<S> metadata = ((List<S>) (AdapterProxyTest_Ampl2.modelRepositoryProxy.getModelInstances(ModelType.FeatureConfiguration, system, Status.Computed)));
        Collections.sort(metadata);
        IModel iModel = metadata.get(0);
        if ((iModel.getValue("id")) == null) {
            return null;
        }
        return ((String) (iModel.getValue("id")));
    }
}

