package eu.supersede.integration.api.replan.optimizer.proxies.test;


import eu.supersede.integration.api.replan.optimizer.proxies.IReplanOptimizer;
import eu.supersede.integration.api.replan.optimizer.proxies.ReplanOptimizerProxy;
import eu.supersede.integration.api.replan.optimizer.types.AlgorithmParameters;
import eu.supersede.integration.api.replan.optimizer.types.Feature;
import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;
import eu.supersede.integration.api.replan.optimizer.types.Priority;
import eu.supersede.integration.api.replan.optimizer.types.Resource;
import eu.supersede.integration.api.replan.optimizer.types.Skill;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.springframework.util.Assert.notNull;


public class ReplanOptimizerProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ReplanOptimizerProxyTest.class);

    private static IReplanOptimizer proxy;

    @BeforeClass
    public static void setup() throws Exception {
        ReplanOptimizerProxyTest.proxy = new ReplanOptimizerProxy();
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add1() throws Exception {
        NextReleaseProblem o_testOptimizePlan_add1__1 = createNextReleaseProblem();
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getFeatures())).isEmpty());
        Assert.assertEquals(4, ((int) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getNbWeeks())));
        Assert.assertEquals(40.0, ((double) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getHoursPerWeek())), 0.1);
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getCurrentPlan());
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getAlgorithmParameters());
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getResources())).isEmpty());
        NextReleaseProblem nrProblem = createNextReleaseProblem();
        PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
        notNull(solution);
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getFeatures())).isEmpty());
        Assert.assertEquals(4, ((int) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getNbWeeks())));
        Assert.assertEquals(40.0, ((double) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getHoursPerWeek())), 0.1);
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getCurrentPlan());
        Assert.assertNull(((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getAlgorithmParameters());
        Assert.assertFalse(((Collection) (((NextReleaseProblem) (o_testOptimizePlan_add1__1)).getResources())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add2() throws Exception {
        NextReleaseProblem nrProblem = createNextReleaseProblem();
        PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
        Assert.assertFalse(((Collection) (((PlanningSolution) (o_testOptimizePlan_add2__3)).getJobs())).isEmpty());
        PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
        notNull(solution);
        Assert.assertFalse(((Collection) (((PlanningSolution) (o_testOptimizePlan_add2__3)).getJobs())).isEmpty());
    }

    @Test(timeout = 30000)
    public void testOptimizePlannull12_failAssert0() throws Exception {
        try {
            NextReleaseProblem nrProblem = createNextReleaseProblem();
            PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(null);
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
            PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
            PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(null);
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
                PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(null);
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
    public void testOptimizePlannull12_failAssert0_mg63_failAssert0() throws Exception {
        try {
            {
                PlanningSolution __DSPOT_currentPlan_8 = new PlanningSolution();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlannull12 should have thrown NullPointerException");
                nrProblem.setCurrentPlan(__DSPOT_currentPlan_8);
            }
            org.junit.Assert.fail("testOptimizePlannull12_failAssert0_mg63 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testOptimizePlan_add2null91_failAssert0_mg321_failAssert0() throws Exception {
        try {
            {
                AlgorithmParameters __DSPOT_algorithmParameters_35 = new AlgorithmParameters();
                NextReleaseProblem nrProblem = createNextReleaseProblem();
                PlanningSolution o_testOptimizePlan_add2__3 = ReplanOptimizerProxyTest.proxy.optimizePlan(nrProblem);
                PlanningSolution solution = ReplanOptimizerProxyTest.proxy.optimizePlan(null);
                notNull(solution);
                org.junit.Assert.fail("testOptimizePlan_add2null91 should have thrown NullPointerException");
                nrProblem.setAlgorithmParameters(__DSPOT_algorithmParameters_35);
            }
            org.junit.Assert.fail("testOptimizePlan_add2null91_failAssert0_mg321 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            Assert.assertEquals(null, expected.getMessage());
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

