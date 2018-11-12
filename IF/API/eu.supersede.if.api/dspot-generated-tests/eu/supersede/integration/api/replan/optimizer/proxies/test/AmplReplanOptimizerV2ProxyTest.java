package eu.supersede.integration.api.replan.optimizer.proxies.test;


import eu.supersede.integration.api.replan.optimizer_v2.proxies.IReplanOptimizer;
import eu.supersede.integration.api.replan.optimizer_v2.proxies.ReplanOptimizerProxy;
import eu.supersede.integration.api.replan.optimizer_v2.types.AlgorithmParameters;
import eu.supersede.integration.api.replan.optimizer_v2.types.Feature;
import eu.supersede.integration.api.replan.optimizer_v2.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer_v2.types.PlanningSolution;
import eu.supersede.integration.api.replan.optimizer_v2.types.Priority;
import eu.supersede.integration.api.replan.optimizer_v2.types.Resource;
import eu.supersede.integration.api.replan.optimizer_v2.types.Skill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;


public class AmplReplanOptimizerV2ProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ReplanOptimizerV2ProxyTest.class);

    private static IReplanOptimizer proxy;

    @BeforeClass
    public static void setup() throws Exception {
        ReplanOptimizerV2ProxyTest.proxy = new ReplanOptimizerProxy();
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
            Assert.notNull(solution);
            org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
            Assert.notNull(null);
            org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg36_failAssert2() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_77 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_77);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg36 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg38_failAssert3() throws Exception {
        try {
            {
                PlanningSolution __DSPOT_currentPlan_79 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_79);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg40_failAssert4() throws Exception {
        try {
            {
                List<Feature> __DSPOT_features_81 = Collections.<Feature>emptyList();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setFeatures(__DSPOT_features_81);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg40 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg35_failAssert10() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_76 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
                Assert.notNull(null);
                org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_76);
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg35 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg37_failAssert11() throws Exception {
        try {
            {
                PlanningSolution __DSPOT_currentPlan_78 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
                Assert.notNull(null);
                org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_78);
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg36_failAssert2null134_failAssert18() throws Exception {
        try {
            {
                {
                    AlgorithmParameters __DSPOT_algorithmParameters_77 = new AlgorithmParameters();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_77);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg36 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg36_failAssert2null134 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg38_failAssert3null106_failAssert20() throws Exception {
        try {
            {
                {
                    PlanningSolution __DSPOT_currentPlan_79 = new PlanningSolution();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setCurrentPlan(__DSPOT_currentPlan_79);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38_failAssert3null106 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg40_failAssert4null107_failAssert22() throws Exception {
        try {
            {
                {
                    List<Feature> __DSPOT_features_81 = Collections.<Feature>emptyList();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setFeatures(__DSPOT_features_81);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg40 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg40_failAssert4null107 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg35_failAssert10null137_failAssert25() throws Exception {
        try {
            {
                {
                    AlgorithmParameters __DSPOT_algorithmParameters_76 = new AlgorithmParameters();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                    nrProblem.setAlgorithmParameters(null);
                }
                org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg35 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg35_failAssert10null137 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg37_failAssert11null111_failAssert27() throws Exception {
        try {
            {
                {
                    PlanningSolution __DSPOT_currentPlan_78 = new PlanningSolution();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                    nrProblem.setCurrentPlan(null);
                }
                org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37_failAssert11null111 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    private NextReleaseProblem createNextReleaseProblem() {
        NextReleaseProblem nrProblem = new NextReleaseProblem();
        nrProblem.setHoursPerWeek(40.0);
        nrProblem.setNbWeeks(1);
        nrProblem.getFeatures().addAll(createFeatures());
        nrProblem.getResources().addAll(createResources());
        return nrProblem;
    }

    private Collection<Feature> createFeatures() {
        Skill s4 = new Skill();
        s4.setName("4");
        Priority priority = new Priority();
        priority.setLevel(2);
        priority.setScore(2);
        List<Feature> features = new ArrayList<>();
        Feature f9 = createFeature9(s4, priority);
        features.add(f9);
        Feature f10 = createFeature10(f9, s4, priority);
        features.add(f10);
        Feature f11 = createFeature11(f9, s4, priority);
        features.add(f11);
        Feature f12 = createFeature12(f10, s4, priority);
        features.add(f12);
        return features;
    }

    private Feature createFeature9(Skill s4, Priority priority) {
        Feature f = new Feature();
        f.setName("9");
        f.setDuration(9.0);
        f.setPriority(priority);
        List<Skill> skills = new ArrayList<>();
        Skill s = new Skill();
        s.setName("2");
        skills.add(s);
        f.getRequiredSkills().addAll(skills);
        return f;
    }

    private Feature createFeature10(Feature f9, Skill s4, Priority priority) {
        Feature f = new Feature();
        f.setName("10");
        f.setDuration(12.0);
        f.setPriority(priority);
        List<Skill> skills = new ArrayList<>();
        skills.add(s4);
        f.getRequiredSkills().addAll(skills);
        f.getDependencies().add(f9);
        return f;
    }

    private Feature createFeature11(Feature f9, Skill s4, Priority priority) {
        Feature f = new Feature();
        f.setName("11");
        f.setDuration(8.0);
        f.setPriority(priority);
        List<Skill> skills = new ArrayList<>();
        skills.add(s4);
        f.getRequiredSkills().addAll(skills);
        f.getDependencies().add(f9);
        return f;
    }

    private Feature createFeature12(Feature f10, Skill s4, Priority priority) {
        Feature f = new Feature();
        f.setName("12");
        f.setDuration(10.0);
        f.setPriority(priority);
        List<Skill> skills = new ArrayList<>();
        skills.add(s4);
        f.getRequiredSkills().addAll(skills);
        f.getDependencies().add(f10);
        return f;
    }

    private Collection<Resource> createResources() {
        List<Resource> resources = new ArrayList<>();
        Skill s1 = new Skill();
        s1.setName("1");
        Skill s2 = new Skill();
        s2.setName("2");
        Skill s4 = new Skill();
        s4.setName("4");
        Resource r1 = new Resource();
        r1.setName("1");
        r1.setAvailability(20.0);
        List<Skill> skills = new ArrayList<>();
        skills.add(s1);
        skills.add(s2);
        skills.add(s4);
        r1.getSkills().addAll(skills);
        resources.add(r1);
        Resource r2 = new Resource();
        r2.setName("2");
        r2.setAvailability(40.0);
        skills = new ArrayList<>();
        skills.add(s1);
        skills.add(s4);
        r2.getSkills().addAll(skills);
        resources.add(r2);
        return resources;
    }
}

