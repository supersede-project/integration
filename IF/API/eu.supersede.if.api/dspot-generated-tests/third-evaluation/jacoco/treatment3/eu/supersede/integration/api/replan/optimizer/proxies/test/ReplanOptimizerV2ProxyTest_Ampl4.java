package eu.supersede.integration.api.replan.optimizer.proxies.test;


import eu.supersede.integration.api.replan.optimizer_v2.proxies.IReplanOptimizer;
import eu.supersede.integration.api.replan.optimizer_v2.proxies.ReplanOptimizerProxy;
import eu.supersede.integration.api.replan.optimizer_v2.types.AlgorithmParameters;
import eu.supersede.integration.api.replan.optimizer_v2.types.Feature;
import eu.supersede.integration.api.replan.optimizer_v2.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer_v2.types.PlannedFeature;
import eu.supersede.integration.api.replan.optimizer_v2.types.PlanningSolution;
import eu.supersede.integration.api.replan.optimizer_v2.types.Priority;
import eu.supersede.integration.api.replan.optimizer_v2.types.Resource;
import eu.supersede.integration.api.replan.optimizer_v2.types.Skill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.util.Assert.notNull;


public class ReplanOptimizerV2ProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ReplanOptimizerV2ProxyTest.class);

    private static IReplanOptimizer proxy;

    @BeforeClass
    public static void setup() throws Exception {
        ReplanOptimizerV2ProxyTest.proxy = new ReplanOptimizerProxy();
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add1() throws Exception {
        NextReleaseProblem o_testOptimizePlan_add1__1 = createNextReleaseProblem();
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getFeatures())).isEmpty());
        Assert.assertEquals(40.0, ((double) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getHoursPerWeek())), 0.1);
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getCurrentPlan());
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getAlgorithmParameters());
        Assert.assertEquals(1, ((int) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getNbWeeks())));
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getResources())).isEmpty());
        NextReleaseProblem nrProblem = createNextReleaseProblem();
        PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
        notNull(solution);
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getFeatures())).isEmpty());
        Assert.assertEquals(40.0, ((double) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getHoursPerWeek())), 0.1);
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getCurrentPlan());
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getAlgorithmParameters());
        Assert.assertEquals(1, ((int) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getNbWeeks())));
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getResources())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add2() throws Exception {
        NextReleaseProblem nrProblem = createNextReleaseProblem();
        PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
        Assert.assertFalse(((Collection) (((PlanningSolution) (o_testOptimizePlan_add2__3)).getJobs())).isEmpty());
        PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
        notNull(solution);
        Assert.assertFalse(((Collection) (((PlanningSolution) (o_testOptimizePlan_add2__3)).getJobs())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull12_failAssert0() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
            notNull(solution);
            org.junit.Assert.fail("testOptimizePlannull12 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add2null91_failAssert0() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
            PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
            notNull(solution);
            org.junit.Assert.fail("testOptimizePlan_add2null91 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull12_failAssert0_mg60_failAssert0() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_7 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull12 should have thrown NullPointerException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_7);
            }
            org.junit.Assert.fail("testOptimizePlannull12_failAssert0_mg60 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull12_failAssert0_mg64_failAssert0() throws Exception {
        try {
            {
                PlanningSolution __DSPOT_currentPlan_8 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull12 should have thrown NullPointerException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_8);
            }
            org.junit.Assert.fail("testOptimizePlannull12_failAssert0_mg64 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add1null117_failAssert0_mg373_failAssert0() throws Exception {
        try {
            {
                List<PlannedFeature> __DSPOT_jobs_70 = Collections.singletonList(new PlannedFeature());
                NextReleaseProblem o_testOptimizePlan_add1__1 = createNextReleaseProblem();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlan_add1null117 should have thrown NullPointerException");
                solution.setJobs(__DSPOT_jobs_70);
            }
            org.junit.Assert.fail("testOptimizePlan_add1null117_failAssert0_mg373 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add2null91_failAssert0_mg322_failAssert0() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_36 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(nrProblem);
                PlanningSolution solution = ReplanOptimizerV2ProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlan_add2null91 should have thrown NullPointerException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_36);
            }
            org.junit.Assert.fail("testOptimizePlan_add2null91_failAssert0_mg322 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
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

