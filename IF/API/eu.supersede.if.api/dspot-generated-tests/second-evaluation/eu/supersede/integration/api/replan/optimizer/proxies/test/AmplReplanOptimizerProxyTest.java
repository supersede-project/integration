package eu.supersede.integration.api.replan.optimizer.proxies.test;


import eu.supersede.integration.api.replan.optimizer.proxies.IReplanOptimizer;
import eu.supersede.integration.api.replan.optimizer.proxies.ReplanOptimizerProxy;
import eu.supersede.integration.api.replan.optimizer.types.AlgorithmParameters;
import eu.supersede.integration.api.replan.optimizer.types.Feature;
import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlannedFeature;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;
import eu.supersede.integration.api.replan.optimizer.types.Priority;
import eu.supersede.integration.api.replan.optimizer.types.Resource;
import eu.supersede.integration.api.replan.optimizer.types.Skill;
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


public class AmplReplanOptimizerProxyTest {
    private static final Logger log = LoggerFactory.getLogger(AmplReplanOptimizerProxyTest.class);

    private static IReplanOptimizer proxy;

    @BeforeClass
    public static void setup() throws Exception {
        AmplReplanOptimizerProxyTest.proxy = new ReplanOptimizerProxy();
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
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
            PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
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
                AlgorithmParameters __DSPOT_algorithmParameters_8 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_8);
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
                PlanningSolution __DSPOT_currentPlan_10 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_10);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg39_failAssert4() throws Exception {
        try {
            {
                List<Feature> __DSPOT_features_11 = Collections.<Feature>emptyList();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                nrProblem.setFeatures(__DSPOT_features_11);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg39 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg48_failAssert8() throws Exception {
        try {
            {
                List<PlannedFeature> __DSPOT_jobs_18 = Collections.singletonList(new PlannedFeature());
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                Assert.notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                solution.setJobs(__DSPOT_jobs_18);
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg48 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg35_failAssert10() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_7 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
                Assert.notNull(null);
                org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_7);
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
                PlanningSolution __DSPOT_currentPlan_9 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
                Assert.notNull(null);
                org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_9);
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg36_failAssert2null145_failAssert18() throws Exception {
        try {
            {
                {
                    AlgorithmParameters __DSPOT_algorithmParameters_8 = new AlgorithmParameters();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_8);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg36 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg36_failAssert2null145 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg38_failAssert3null118_failAssert20() throws Exception {
        try {
            {
                {
                    PlanningSolution __DSPOT_currentPlan_10 = new PlanningSolution();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setCurrentPlan(__DSPOT_currentPlan_10);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg38_failAssert3null118 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg39_failAssert4null111_failAssert22() throws Exception {
        try {
            {
                {
                    List<Feature> __DSPOT_features_11 = Collections.<Feature>emptyList();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    nrProblem.setFeatures(__DSPOT_features_11);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg39 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg39_failAssert4null111 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull8_failAssert0_mg48_failAssert8null112_failAssert24() throws Exception {
        try {
            {
                {
                    List<PlannedFeature> __DSPOT_jobs_18 = Collections.singletonList(new PlannedFeature());
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(null);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull8 should have thrown NullPointerException");
                    solution.setJobs(__DSPOT_jobs_18);
                }
                org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg48 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testOptimizePlannull8_failAssert0_mg48_failAssert8null112 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg35_failAssert10null140_failAssert27() throws Exception {
        try {
            {
                {
                    AlgorithmParameters __DSPOT_algorithmParameters_7 = new AlgorithmParameters();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                    nrProblem.setAlgorithmParameters(null);
                }
                org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg35 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg35_failAssert10null140 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull9_failAssert1_mg37_failAssert11null119_failAssert29() throws Exception {
        try {
            {
                {
                    PlanningSolution __DSPOT_currentPlan_9 = new PlanningSolution();
                    NextReleaseProblem nrProblem = createNextReleaseProblem();
                    PlanningSolution solution = AmplReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testOptimizePlannull9 should have thrown IllegalArgumentException");
                    nrProblem.setCurrentPlan(null);
                }
                org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testOptimizePlannull9_failAssert1_mg37_failAssert11null119 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    private NextReleaseProblem createNextReleaseProblem() {
        NextReleaseProblem nrProblem = new NextReleaseProblem();
        nrProblem.setHoursPerWeek(40.0);
        nrProblem.setNbWeeks(4);
        nrProblem.getFeatures().addAll(createFeatures());
        nrProblem.getResources().addAll(createResources());
        return nrProblem;
    }

    private Collection<Feature> createFeatures() {
        List<Feature> features = new ArrayList<>();
        Feature f1 = new Feature();
        f1.setName("1");
        f1.setDuration(10.0);
        Priority priority1 = new Priority();
        priority1.setLevel(4);
        priority1.setScore(5);
        f1.setPriority(priority1);
        List<Skill> skills = new ArrayList<>();
        Skill s1 = new Skill();
        s1.setName("1");
        skills.add(s1);
        Skill s3 = new Skill();
        s3.setName("3");
        skills.add(s3);
        f1.getRequiredSkills().addAll(skills);
        features.add(f1);
        Feature f2 = new Feature();
        f2.setName("2");
        f2.setDuration(20.0);
        Priority priority2 = new Priority();
        priority2.setLevel(2);
        priority2.setScore(4);
        f2.setPriority(priority2);
        f2.getRequiredSkills().addAll(skills);
        features.add(f2);
        return features;
    }

    private Collection<Resource> createResources() {
        List<Resource> resources = new ArrayList<>();
        Skill s1 = new Skill();
        s1.setName("1");
        Skill s2 = new Skill();
        s2.setName("2");
        Skill s3 = new Skill();
        s3.setName("3");
        Resource r1 = new Resource();
        r1.setName("1");
        List<Skill> skills = new ArrayList<>();
        skills.add(s1);
        skills.add(s2);
        r1.getSkills().addAll(skills);
        r1.setAvailability(75.0);
        resources.add(r1);
        Resource r2 = new Resource();
        r2.setName("2");
        skills = new ArrayList<>();
        skills.add(s2);
        skills.add(s3);
        r2.getSkills().addAll(skills);
        r2.setAvailability(55.0);
        resources.add(r2);
        Resource r3 = new Resource();
        r3.setName("3");
        skills = new ArrayList<>();
        skills.add(s1);
        skills.add(s3);
        r3.getSkills().addAll(skills);
        r3.setAvailability(90.0);
        resources.add(r3);
        return resources;
    }
}

