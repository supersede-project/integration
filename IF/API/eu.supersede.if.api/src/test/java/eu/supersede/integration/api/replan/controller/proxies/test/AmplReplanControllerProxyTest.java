package eu.supersede.integration.api.replan.controller.proxies.test;


import eu.supersede.integration.api.replan.controller.proxies.IReplanController;
import eu.supersede.integration.api.replan.controller.proxies.ReplanControllerProxy;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.Job;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class AmplReplanControllerProxyTest {
    private static final Logger log = LoggerFactory.getLogger(AmplReplanControllerProxyTest.class);

    private static IReplanController proxy;

    private int projectId = 1;

    @BeforeClass
    public static void setup() throws Exception {
        AmplReplanControllerProxyTest.proxy = new ReplanControllerProxy();
    }

    private Project createProject() {
        Project project = new Project();
        project.setName("Project Test");
        project.setDescription("Project Test Description");
        project.setEffortUnit("hour");
        project.setHoursPerEffortUnit(1.0);
        project.setHoursPerWeekFullTimeResource(40.0);
        return project;
    }

    private Feature createFeature() {
        Feature feature = new Feature();
        feature.setCode(111);
        feature.setName("Fix auto upload");
        feature.setDescription("Bla, bla, bla es mucho decir");
        feature.setEffort(4.0);
        feature.setDeadline(Calendar.getInstance().getTime());
        feature.setPriority(5);
        return feature;
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddFeaturesOfReleaseByIdOfProjectById__11);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_sd10() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId));
        List<Skill> o_tesDeleteResourceOfProjectById_sd10__13 = resource.getSkills();
        assertTrue(o_tesDeleteResourceOfProjectById_sd10__13.isEmpty());
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_add6_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Swift Developer");
            resource.setDescription("Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
            Assert.notNull(resource);
            AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId));
            org.junit.Assert.fail("tesDeleteResourceOfProjectById_add6 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_sd10_add116() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId));
        List<Skill> o_tesDeleteResourceOfProjectById_sd10__13 = resource.getSkills();
        boolean o_tesDeleteResourceOfProjectById_sd10_add116__18 = o_tesDeleteResourceOfProjectById_sd10__13.isEmpty();
        assertTrue(o_tesDeleteResourceOfProjectById_sd10_add116__18);
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_add6_failAssert0_add147() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Swift Developer");
            resource.setName("Swift Developer");
            resource.setDescription("Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, this.projectId);
            Assert.notNull(resource);
            boolean o_tesDeleteResourceOfProjectById_add6_failAssert0_add147__12 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId);
            assertTrue(o_tesDeleteResourceOfProjectById_add6_failAssert0_add147__12);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId));
            org.junit.Assert.fail("tesDeleteResourceOfProjectById_add6 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_sd10_add116_add369() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId));
        List<Skill> o_tesDeleteResourceOfProjectById_sd10_add116_add369__14 = resource.getSkills();
        assertTrue(o_tesDeleteResourceOfProjectById_sd10_add116_add369__14.isEmpty());
        List<Skill> o_tesDeleteResourceOfProjectById_sd10__13 = resource.getSkills();
        boolean o_tesDeleteResourceOfProjectById_sd10_add116__18 = o_tesDeleteResourceOfProjectById_sd10__13.isEmpty();
    }

    @Test(timeout = 10000)
    public void tesDeleteResourceOfProjectById_add6_failAssert0_add147_add404() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Swift Developer");
            resource.setName("Swift Developer");
            resource.setDescription("Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, this.projectId);
            Assert.notNull(resource);
            boolean o_tesDeleteResourceOfProjectById_add6_failAssert0_add147_add404__12 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId);
            assertTrue(o_tesDeleteResourceOfProjectById_add6_failAssert0_add147_add404__12);
            boolean o_tesDeleteResourceOfProjectById_add6_failAssert0_add147__12 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), this.projectId));
            org.junit.Assert.fail("tesDeleteResourceOfProjectById_add6 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd668() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd668__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_sd668__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd669() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId);
        Assert.notNull(feature);
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16 = feature.getDeadline();
        assertEquals(118, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getYear())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getTimezoneOffset())));
        assertEquals(1523052000000L, ((long) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getTime())));
        assertEquals("Apr 7, 2018 12:00:00 AM", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).toLocaleString());
        assertEquals(7, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getDate())));
        assertEquals(6, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getDay())));
        assertEquals(1523052000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).toInstant()).getNano())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getSeconds())));
        assertEquals("6 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).toGMTString());
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).getHours())));
        assertEquals(1523052000000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16).toInstant()).toEpochMilli())));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd672() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(4), feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd673() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd673__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_sd673__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(1), feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber682() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 1));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber682__10 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber682__10);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) > 40));
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), projectId));
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd669_add891() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669_add891__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDependenciesOfFeatureByIdOfProjectById_sd669_add891__9);
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16 = feature.getDeadline();
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd669_sd903() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16 = feature.getDeadline();
        assertEquals(new Integer(1), feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd669_sd902() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16 = feature.getDeadline();
        assertEquals(new Integer(4), feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd669_sd898() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_sd669__16 = feature.getDeadline();
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053__7 = features.size();
            assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053__7)));
            Assert.isTrue(((features.size()) > 40));
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId));
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_add809() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int o_testAddDependenciesOfFeatureByIdOfProjectById_add658_add809__6 = features.size();
        assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_add658_add809__6)));
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(4), feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(new Integer(1), feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd672_sd939() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__16 = feature.getPriority();
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd673_sd980() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd673__9 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_sd673__16 = feature.getReleaseId();
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd824_failAssert12() throws Exception {
        try {
            Date __DSPOT_deadline_18 = new Date(")d4}^w[&oDAIOw? O!T}");
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) > 2));
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDeadline(new Date(")d4}^w[&oDAIOw? O!T}"));
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_add658_sd824 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_sd672_literalMutationNumber959_failAssert17() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) > 2));
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__9 = dependencies.add(features.get(-1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testAddDependenciesOfFeatureByIdOfProjectById_sd672__16 = feature.getPriority();
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_sd672_literalMutationNumber959 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_add1926() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_add1926__6 = features.size();
        assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_add1926__6)));
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816__19 = feature.getCode();
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_add2010() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_add2010__6 = features.size();
        assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_add2010__6)));
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821__19 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_add1968() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_add1968__6 = features.size();
        assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_add1968__6)));
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820__19 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1976() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820__19 = feature.getPriority();
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2018() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821__19 = feature.getReleaseId();
        assertEquals(new Integer(222), feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816__19 = feature.getCode();
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23 = feature.getDeadline();
        assertEquals(-120, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getTimezoneOffset())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getMonth())));
        assertEquals(118, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getYear())));
        assertEquals("6 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).toGMTString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).toInstant()).getNano())));
        assertEquals("Apr 7, 2018 12:00:00 AM", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).toLocaleString());
        assertEquals(1523052000000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getHours())));
        assertEquals(6, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getDay())));
        assertEquals(1523052000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).toInstant()).getEpochSecond())));
        assertEquals(1523052000000L, ((long) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getMinutes())));
        assertEquals(7, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd816_sd1935__23).getDate())));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820__19 = feature.getPriority();
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23 = feature.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getSeconds())));
        assertEquals("Apr 7, 2018 12:00:00 AM", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).toLocaleString());
        assertEquals(3, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getMonth())));
        assertEquals(118, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getYear())));
        assertEquals(1523052000000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).toInstant()).getNano())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getHours())));
        assertEquals(6, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getDay())));
        assertEquals(1523052000000L, ((long) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getTime())));
        assertEquals("6 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).toGMTString());
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getMinutes())));
        assertEquals(7, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).getDate())));
        assertEquals(1523052000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd820_sd1977__23).toInstant()).getEpochSecond())));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821__19 = feature.getReleaseId();
        Date o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23 = feature.getDeadline();
        assertEquals(6, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getDay())));
        assertEquals(1523052000000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).toInstant()).toEpochMilli())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getTimezoneOffset())));
        assertEquals(1523052000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getSeconds())));
        assertEquals(118, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getYear())));
        assertEquals("6 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).toGMTString());
        assertEquals("Apr 7, 2018 12:00:00 AM", ((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).toLocaleString());
        assertEquals(7, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getMonth())));
        assertEquals(1523052000000L, ((long) (((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).getTime())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2019__23).toInstant()).getNano())));
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_sd2022() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) > 2));
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(0));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821__19 = feature.getReleaseId();
        assertEquals(new Integer(4), feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053_add1842() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053__7 = features.size();
            int o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053_add1842__10 = features.size();
            assertEquals(7, ((int) (o_testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685_failAssert0_add1053_add1842__10)));
            Assert.isTrue(((features.size()) > 40));
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId));
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_literalMutationNumber685 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_literalMutationNumber2038_failAssert6() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) > 2));
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDependenciesOfFeatureByIdOfProjectById_add658__10 = dependencies.add(features.get(-1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821__19 = feature.getReleaseId();
            org.junit.Assert.fail("testAddDependenciesOfFeatureByIdOfProjectById_add658_sd821_literalMutationNumber2038 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2819_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(-1));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2819 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2822_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(40));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2822 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891__12);
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(0));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2898_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(-1));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2898 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906_failAssert3() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(40).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(40).getId(), projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891_add3135() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891_add3135__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891_add3135__12);
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891__12 = featuresToAdd.add(features.get(0));
        boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(0));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906_failAssert3_add3188() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906_failAssert3_add3188__14 = featuresToAdd.add(features.get(0));
            assertTrue(o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906_failAssert3_add3188__14);
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(40).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(40).getId(), this.projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_add2807_literalMutationNumber2906 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891_literalMutationNumber3149_failAssert2() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891__12 = featuresToAdd.add(features.get(0));
            boolean o_testAddFeaturesOfReleaseByIdOfProjectById_add2807__12 = featuresToAdd.add(features.get(-1));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddFeaturesOfReleaseByIdOfProjectById_add2807_add2891_literalMutationNumber3149 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourceOfProjectById_sd3403() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        List<Skill> o_testAddResourceOfProjectById_sd3403__9 = resource.getSkills();
        assertTrue(o_testAddResourceOfProjectById_sd3403__9.isEmpty());
    }

    @Test(timeout = 10000)
    public void testAddResourceOfProjectById_sd3403_add3501() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        List<Skill> o_testAddResourceOfProjectById_sd3403__9 = resource.getSkills();
        boolean o_testAddResourceOfProjectById_sd3403_add3501__14 = o_testAddResourceOfProjectById_sd3403__9.isEmpty();
        assertTrue(o_testAddResourceOfProjectById_sd3403_add3501__14);
    }

    @Test(timeout = 10000)
    public void testAddResourceOfProjectById_sd3403_add3501_add3619() throws Exception {
        Resource resource = new Resource();
        resource.setName("Swift Developer");
        resource.setName("Swift Developer");
        resource.setDescription("Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, projectId);
        Assert.notNull(resource);
        List<Skill> o_testAddResourceOfProjectById_sd3403_add3501_add3619__10 = resource.getSkills();
        assertTrue(o_testAddResourceOfProjectById_sd3403_add3501_add3619__10.isEmpty());
        List<Skill> o_testAddResourceOfProjectById_sd3403__9 = resource.getSkills();
        boolean o_testAddResourceOfProjectById_sd3403_add3501__14 = o_testAddResourceOfProjectById_sd3403__9.isEmpty();
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3752() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3752__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_add3752__12);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_sd3762() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__11);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18 = release.getDeadline();
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getHours())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).toGMTString());
        assertEquals(-60, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getTimezoneOffset())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).toLocaleString());
        assertEquals(3, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getDay())));
        assertEquals(30, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getDate())));
        assertEquals(10, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getMonth())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).toInstant()).getNano())));
        assertEquals(116, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getYear())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18).getTime())));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_sd3764_failAssert0() throws Exception {
        try {
            Date __DSPOT_deadline_163 = new Date("&5+;N4Sb)kE+#PmjF|_k");
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(release);
            release.setDeadline(new Date("&5+;N4Sb)kE+#PmjF|_k"));
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_sd3764 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_literalMutationNumber3767_failAssert1() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(-1));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_literalMutationNumber3767 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851__12);
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21 = release.getDeadline();
        assertEquals(-60, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getMinutes())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getHours())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).toInstant()).getNano())));
        assertEquals(30, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getDate())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).toGMTString());
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).toInstant()).getEpochSecond())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).toLocaleString());
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getTime())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getDay())));
        assertEquals(10, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getMonth())));
        assertEquals(116, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21).getYear())));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_literalMutationNumber3862_failAssert0() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(-1));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_add3751_literalMutationNumber3862 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3752_sd3886_failAssert3() throws Exception {
        try {
            Date __DSPOT_deadline_167 = new Date("I:lZE.`#n5*TWD1iXd&W");
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3752__12 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(release);
            release.setDeadline(new Date("I:lZE.`#n5*TWD1iXd&W"));
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_add3752_sd3886 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921_failAssert9() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(-1).getId(), projectId);
            Assert.notNull(release);
            Date o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18 = release.getDeadline();
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_add4359() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_add4359__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_add4359__12);
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851__12 = resourcesToAdd.add(resources.get(0));
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851__12 = resourcesToAdd.add(resources.get(0));
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25 = release.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getMinutes())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).toLocaleString());
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).toInstant()).getNano())));
        assertEquals(116, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getHours())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getTime())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getDay())));
        assertEquals(-60, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getTimezoneOffset())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).toInstant()).getEpochSecond())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).toGMTString());
        assertEquals(30, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getDate())));
        assertEquals(10, ((int) (((java.util.Date)o_testAddResourcesOfReleaseByIdOfProjectById_add3751_add3851_sd4367__25).getMonth())));
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857_add4393() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857_add4393__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857_add4393__12);
        boolean o_testAddResourcesOfReleaseByIdOfProjectById_add3751__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testAddResourcesOfReleaseByIdOfProjectById_add3751_sd3857__21 = release.getDeadline();
    }

    @Test(timeout = 10000)
    public void testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921_failAssert9_add4481() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921_failAssert9_add4481__13 = resourcesToAdd.add(resources.get(0));
            assertTrue(o_testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921_failAssert9_add4481__13);
            boolean o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(-1).getId(), this.projectId);
            Assert.notNull(release);
            Date o_testAddResourcesOfReleaseByIdOfProjectById_sd3762__18 = release.getDeadline();
            org.junit.Assert.fail("testAddResourcesOfReleaseByIdOfProjectById_sd3762_literalMutationNumber3921 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillOfProjectById_add4893() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testAddSkillOfProjectById_add4893__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893__5).getDescription());
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893__5).getName());
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testAddSkillOfProjectById_add4893_add4957() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testAddSkillOfProjectById_add4893_add4957__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893_add4957__5).getName());
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893_add4957__5).getDescription());
        Skill o_testAddSkillOfProjectById_add4893__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testAddSkillOfProjectById_add4893_add4957_add5025() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testAddSkillOfProjectById_add4893_add4957_add5025__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893_add4957_add5025__5).getName());
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testAddSkillOfProjectById_add4893_add4957_add5025__5).getDescription());
        Skill o_testAddSkillOfProjectById_add4893_add4957__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Skill o_testAddSkillOfProjectById_add4893__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_add5101() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_add5101__8 = features.get(0).getId();
        assertEquals(1, ((int) (o_testAddSkillsOfFeatureByIdOfProjectById_add5101__8)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getHours())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).toInstant()).toEpochMilli())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).toGMTString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getTime())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getSeconds())));
        assertEquals(118, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getYear())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getMonth())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).toInstant()).getNano())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).toLocaleString());
        assertEquals(5, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getDate())));
        assertEquals(4, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13).getDay())));
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5108() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5109() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(1, (int)feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_literalMutationNumber5119_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), projectId));
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_literalMutationNumber5119 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_literalMutationNumber5122_failAssert1() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), projectId));
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_literalMutationNumber5122 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }



    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13 = feature.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getMinutes())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getTimezoneOffset())));
        assertEquals(5, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getDate())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getHours())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).toInstant()).getNano())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getMonth())));
        assertEquals(4, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getDay())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getTime())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).toGMTString());
        assertEquals(118, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).getYear())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13).toInstant()).toEpochMilli())));
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_sd5280() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_sd5276() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5247() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5108_sd5335() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108__13 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5109_sd5364() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5109__13 = feature.getReleaseId();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5251() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5108_add5331() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108_add5331__8 = features.get(0).getId();
        assertEquals(1, ((int) (o_testAddSkillsOfFeatureByIdOfProjectById_sd5108_add5331__8)));
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108__13 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5109_add5360() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5109_add5360__8 = features.get(0).getId();
        assertEquals(1, ((int) (o_testAddSkillsOfFeatureByIdOfProjectById_sd5109_add5360__8)));
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5109__13 = feature.getReleaseId();
    }


    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5106_literalMutationNumber5320() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> o_testAddSkillsOfFeatureByIdOfProjectById_sd5106__13 = feature.getDependencies();
        boolean o_testAddSkillsOfFeatureByIdOfProjectById_sd5106_literalMutationNumber5320__18 = o_testAddSkillsOfFeatureByIdOfProjectById_sd5106__13.isEmpty();
        assertFalse(o_testAddSkillsOfFeatureByIdOfProjectById_sd5106_literalMutationNumber5320__18);
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_add5101_add5210() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_add5101__8 = features.get(0).getId();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_add5101_add5210__12 = features.get(0).getId();
        assertEquals(1, ((int) (o_testAddSkillsOfFeatureByIdOfProjectById_add5101_add5210__12)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId));
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_literalMutationNumber5294_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), this.projectId);
            Assert.notNull(feature);
            Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_sd5105_literalMutationNumber5294 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_add5101_literalMutationNumber5233_failAssert10() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testAddSkillsOfFeatureByIdOfProjectById_add5101__8 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_add5101_literalMutationNumber5233 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5108_sd5343_failAssert14() throws Exception {
        try {
            Date __DSPOT_deadline_221 = new Date(";cXLFumzTniWimrOiR]O");
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108__13 = feature.getPriority();
            feature.setDeadline(new Date(";cXLFumzTniWimrOiR]O"));
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_sd5108_sd5343 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }


    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13 = feature.getDeadline();
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17 = feature.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getHours())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).toInstant()).getEpochSecond())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).toInstant()).toEpochMilli())));
        assertEquals(-120, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getTimezoneOffset())));
        assertEquals(3, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getMonth())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).toLocaleString());
        assertEquals(5, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getDate())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).toGMTString());
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getMinutes())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getSeconds())));
        assertEquals(4, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getDay())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).toInstant()).getNano())));
        assertEquals(118, ((int) (((java.util.Date)o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_add6092__17).getYear())));
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_sd6097() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13 = feature.getDeadline();
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_sd6093() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13 = feature.getDeadline();
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5247_sd6183() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5247__17 = feature.getCode();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5251_sd6273() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5251__17 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_sd5280_sd6123() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_sd5280__17 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5247_sd6188() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5247__17 = feature.getCode();
        assertEquals(1, (int)feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5251_sd6278() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104__13 = feature.getCode();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5104_sd5251__17 = feature.getPriority();
        assertEquals(1, (int)feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5108_sd5340_sd6374() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108__13 = feature.getPriority();
        Integer o_testAddSkillsOfFeatureByIdOfProjectById_sd5108_sd5340__17 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }


    @Test(timeout = 10000)
    public void testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_literalMutationNumber6108_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), this.projectId);
            Assert.notNull(feature);
            Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275__13 = feature.getDeadline();
            Date o_testAddSkillsOfFeatureByIdOfProjectById_sd5105__13 = feature.getDeadline();
            org.junit.Assert.fail("testAddSkillsOfFeatureByIdOfProjectById_sd5105_add5275_literalMutationNumber6108 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_add7243() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddSkillsOfResourceByIdOfProjectById_add7243__12);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
    }


    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_literalMutationNumber7259_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(-1));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddSkillsOfResourceByIdOfProjectById_literalMutationNumber7259 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_add7243_add7345() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345__12);
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243__12 = skillsToAdd.add(skills.get(0));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
    }



    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_add7243_literalMutationNumber7356_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243__12 = skillsToAdd.add(skills.get(-1));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddSkillsOfResourceByIdOfProjectById_add7243_literalMutationNumber7356 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_add7243_add7345_add7651() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345_add7651__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345_add7651__12);
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345__12 = skillsToAdd.add(skills.get(0));
        boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243__12 = skillsToAdd.add(skills.get(0));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
    }


    @Test(timeout = 10000)
    public void testAddSkillsOfResourceByIdOfProjectById_add7243_add7345_literalMutationNumber7664_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243_add7345__12 = skillsToAdd.add(skills.get(-1));
            boolean o_testAddSkillsOfResourceByIdOfProjectById_add7243__12 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId));
            org.junit.Assert.fail("testAddSkillsOfResourceByIdOfProjectById_add7243_add7345_literalMutationNumber7664 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7979() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testCancelLastPlanOfReleaseByIdOfProjectById_add7979__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testCancelLastPlanOfReleaseByIdOfProjectById_add7979__4)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
        boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        assertTrue(o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7987() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
        List<Job> o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14 = plan.getJobs();
        assertTrue(o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14.isEmpty());
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7989() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
        assertEquals(0, (int)plan.getNumberJobs());
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7990() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber7999_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber7999 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8002_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId));
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8002 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8004_failAssert2() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8004 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8167_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), this.projectId);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8167 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8159_failAssert3() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8159 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7990_literalMutationNumber8297_failAssert9() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.notNull(plan);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            Integer o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7990__14 = plan.getReleaseId();
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_sd7990_literalMutationNumber8297 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8004_failAssert2_sd8387_failAssert18() throws Exception {
        try {
            try {
                Date __DSPOT_creationDate_456 = new Date("d%nuEff!%1UO!ZP#i,sz");
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(plan);
                Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
                org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8004 should have thrown ArrayIndexOutOfBoundsException");
                plan.setCreationDate(new Date("d%nuEff!%1UO!ZP#i,sz"));
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_literalMutationNumber8004_failAssert2_sd8387 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7987_literalMutationNumber8203_failAssert19() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(plan);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            List<Job> o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14 = plan.getJobs();
            o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14.isEmpty();
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_sd7987_literalMutationNumber8203 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 100000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1_add8850() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1_add8850__11 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            assertTrue(o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1_add8850__11);
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_sd7987_literalMutationNumber8203_failAssert19_add8999() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987_literalMutationNumber8203_failAssert19_add8999__6 = releases.get(0).getId();
            assertEquals(1, (int)releases.get(0).getId());
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(plan);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            List<Job> o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14 = plan.getJobs();
            o_testCancelLastPlanOfReleaseByIdOfProjectById_sd7987__14.isEmpty();
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_sd7987_literalMutationNumber8203 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1_add8847() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169_failAssert1_add8847__6 = releases.get(0).getId();
            assertEquals(1, (int)releases.get(0).getId());
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
            boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8169 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8159_failAssert3_sd8903_failAssert0() throws Exception {
        try {
            try {
                Date __DSPOT_creationDate_474 = new Date(";uS9b&r5!GQi?`Oiw0F]");
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(plan);
                boolean o_testCancelLastPlanOfReleaseByIdOfProjectById_add7982__9 = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Boolean result = AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId));
                org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8159 should have thrown ArrayIndexOutOfBoundsException");
                plan.setCreationDate(new Date(";uS9b&r5!GQi?`Oiw0F]"));
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testCancelLastPlanOfReleaseByIdOfProjectById_add7982_literalMutationNumber8159_failAssert3_sd8903 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_sd9641() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_sd9644() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        List<Resource> o_testCreateAndDeleteFeatureForProject_sd9644__23 = project.getResources();
        assertTrue(o_testCreateAndDeleteFeatureForProject_sd9644__23.isEmpty());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9629_failAssert0() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9629 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9634_failAssert1() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9634 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9638_failAssert3() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_sd9641_add9791() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        feature.getId();
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            boolean o_testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934__22 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            assertFalse(o_testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934__22);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9634 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            boolean o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974__18 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            assertTrue(o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974__18);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            boolean o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978__22 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            assertTrue(o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978__22);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9924_failAssert0() throws Exception {
        try {
            try {
                Project project = createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = createFeature();
                AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9634 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9924 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9629_failAssert0_sd9897_failAssert3() throws Exception {
        try {
            try {
                Date __DSPOT_deadline_536 = new Date("[A}8/o#n)B( ^qB(YasZ");
                Project project = createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = createFeature();
                AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9629 should have thrown HttpClientErrorException");
                feature.setDeadline(new Date("[A}8/o#n)B( ^qB(YasZ"));
            } catch (HttpClientErrorException eee) {
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9629_failAssert0_sd9897 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_sd9641_add9791_add10603() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        feature.getId();
        Assert.notNull(feature.getId());
        feature.getId();
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934_add10659() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            boolean o_testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934_add10659__18 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            assertTrue(o_testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934_add10659__18);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            boolean o_testCreateAndDeleteFeatureForProject_add9634_failAssert1_add9934__22 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9634 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978_add10758() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            boolean o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978__22 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            boolean o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978_add10758__26 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            assertFalse(o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9978_add10758__26);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_sd9641_add9791_add10599_failAssert1() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = createFeature();
            AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            feature.getId();
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            String o_testCreateAndDeleteFeatureForProject_sd9641__23 = project.getEffortUnit();
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_sd9641_add9791_add10599 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974_add10700_failAssert6() throws Exception {
        try {
            try {
                Project project = createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = createFeature();
                AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                boolean o_testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974__18 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
                Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add9638_failAssert3_add9974_add10700 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_add11505_failAssert0() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteProject_add11505 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508_add11564() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508_sd11578() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        String o_testCreateAndDeleteProject_sd11508__11 = project.getEffortUnit();
        assertEquals("hour", o_testCreateAndDeleteProject_sd11508__11);
        project.setResources(Collections.singletonList(new Resource()));
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_add11505_failAssert0_add11585() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            boolean o_testCreateAndDeleteProject_add11505_failAssert0_add11585__10 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            assertTrue(o_testCreateAndDeleteProject_add11505_failAssert0_add11585__10);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteProject_add11505 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508_add11564_add11703() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508_sd11578_add11722() throws Exception {
        Project project = createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
        String o_testCreateAndDeleteProject_sd11508__11 = project.getEffortUnit();
        assertEquals("hour", o_testCreateAndDeleteProject_sd11508__11);
        project.setResources(Collections.singletonList(new Resource()));
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_add11505_failAssert0_add11585_add11743() throws Exception {
        try {
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            boolean o_testCreateAndDeleteProject_add11505_failAssert0_add11585_add11743__10 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            assertTrue(o_testCreateAndDeleteProject_add11505_failAssert0_add11585_add11743__10);
            boolean o_testCreateAndDeleteProject_add11505_failAssert0_add11585__10 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteProject_add11505 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testCreateAndDeleteProject_sd11508_sd11578_add11725_failAssert2() throws Exception {
        try {
            List<Resource> __DSPOT_resources_661 = Collections.singletonList(new Resource());
            Project project = createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()));
            String o_testCreateAndDeleteProject_sd11508__11 = project.getEffortUnit();
            project.setResources(Collections.singletonList(new Resource()));
            org.junit.Assert.fail("testCreateAndDeleteProject_sd11508_sd11578_add11725 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }



    @Test(timeout = 10000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11950_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(-1));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            new ArrayList<>().add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == ((resource.getSkills().size()) - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11950 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            new ArrayList<>().add(skills.get(-1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == ((resource.getSkills().size()) - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }




    @Test(timeout = 10000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297__13 = skillsToAdd.add(skills.get(0));
            assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297__13);
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), this.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skills.get(-1);
            new ArrayList<>().add(skills.get(-1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), this.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == ((resource.getSkills().size()) - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_literalMutationNumber12316() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_literalMutationNumber12316__13 = skillsToAdd.add(skills.get(0));
            assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_literalMutationNumber12316__13);
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(-1).getId(), this.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            new ArrayList<>().add(skills.get(-1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), this.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == ((resource.getSkills().size()) - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297_add13143() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297__13 = skillsToAdd.add(skills.get(0));
            Integer o_testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960_failAssert2_add12297_add13143__17 = resources.get(0).getId();
            assertEquals(1, (int)resources.get(0).getId());
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), this.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skills.get(-1);
            new ArrayList<>().add(skills.get(-1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), this.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == ((resource.getSkills().size()) - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectById_literalMutationNumber11960 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }


    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13876() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__18 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__18);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__20 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13876__20);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13881() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13881__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13881__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13881__18 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13881__18);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24 = feature.getDeadline();
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).toGMTString());
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getDate())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getDay())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).toInstant()).getEpochSecond())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getSeconds())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getYear())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getTimezoneOffset())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getTime())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).toInstant()).getNano())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).getHours())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24).toInstant()).toEpochMilli())));
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13885() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13885__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13885__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13885__18 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13885__18);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13886() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13886__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13886__9);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13886__18 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13886__18);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        assertEquals(1, (int)feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13895() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 1));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13895__10 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13895__10);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13895__19 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13895__19);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 40));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 2));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(40));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14215() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14215__20 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14215__20);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24 = feature.getDeadline();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14209() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14209__9 = dependenciesToAdd.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_add14209__9);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24 = feature.getDeadline();
    }



    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_sd14225() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882_sd14221() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__9 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__18 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_sd13882__24 = feature.getDeadline();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898_failAssert0_add14463() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898_failAssert0_add14463__7 = features.size();
            assertEquals(7, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898_failAssert0_add14463__7)));
            Assert.isTrue(((features.size()) >= 40));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13898 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_add14524() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 2));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_add14524__11 = dependenciesToAdd.add(features.get(1));
            assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_add14524__11);
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(40));
            feature.getId();
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_literalMutationNumber14551() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 2));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_literalMutationNumber14551__11 = dependenciesToAdd.add(features.get(1));
            assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914_failAssert4_literalMutationNumber14551__11);
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(-1).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(40));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber13914 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060__25 = feature.getId();
        assertEquals(1, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060__25)));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14057() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14057__21 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14057__21);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14064_sd15820() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14064__29 = feature.getDependencies();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14064_sd15820__36 = o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14064__29.isEmpty();
        assertFalse(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14064_sd15820__36);
        feature.setDependencies(Collections.singletonList(new Feature()));
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15651() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15651__25 = feature.getId();
        assertEquals(1, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15651__25)));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062__29 = feature.getCode();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15703() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15703__25 = feature.getId();
        assertEquals(1, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15703__25)));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15755() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15755__25 = feature.getId();
        assertEquals(1, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15755__25)));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067__29 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15693() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15693__6 = features.size();
        assertEquals(7, ((int) (o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15693__6)));
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15706() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062__29 = feature.getCode();
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33 = feature.getDeadline();
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getMonth())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).toInstant()).getNano())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).toInstant()).toEpochMilli())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).toInstant()).getEpochSecond())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getDay())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getMinutes())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).toGMTString());
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getSeconds())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getDate())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_sd15655__33).getHours())));
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15758() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067__29 = feature.getReleaseId();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33 = feature.getDeadline();
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getTime())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).toGMTString());
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).toInstant()).getEpochSecond())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getMonth())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).toInstant()).toEpochMilli())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getTimezoneOffset())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getYear())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getDay())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).toLocaleString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15707__33).getSeconds())));
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067__29 = feature.getReleaseId();
        Date o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33 = feature.getDeadline();
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getSeconds())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getTime())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).toInstant()).getEpochSecond())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getDate())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getDay())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getHours())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).toGMTString());
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getMonth())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_sd15759__33).getTimezoneOffset())));
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_sd15711() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
        assertEquals(1, (int)feature.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15648() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15648__21 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_add15648__21);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062__29 = feature.getCode();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15700() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15700__21 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066_add15700__21);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14066__29 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15752() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.isTrue(((features.size()) >= 2));
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15752__21 = dependenciesToDelete.add(features.get(1));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067_add15752__21);
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14067__29 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_literalMutationNumber15671_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 40));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062__29 = feature.getCode();
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_literalMutationNumber15671 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_literalMutationNumber15687_failAssert4() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 2));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(40));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062__29 = feature.getCode();
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_sd14062_literalMutationNumber15687 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060_sd15610_failAssert15() throws Exception {
        try {
            Date __DSPOT_deadline_841 = new Date("710U8Xh}`e!,3/H!B>(r");
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.isTrue(((features.size()) >= 2));
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__10 = dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866__19 = dependenciesToDelete.add(features.get(1));
            Integer o_testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060__25 = feature.getId();
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDeadline(new Date("710U8Xh}`e!,3/H!B>(r"));
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectById_add13866_add14060_sd15610 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(1));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16516_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(-1));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16516 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16519_failAssert2() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(40));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16519 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16526_failAssert7() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16526 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16531_failAssert9() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(-1));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16531 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16534_failAssert10() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(40));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16534 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16541_failAssert15() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
            Assert.isTrue(result);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16541 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(2).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(-1).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710_failAssert4() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(1));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(-1));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16720_failAssert5() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(1));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16720 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16891_failAssert10() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(-1));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16891 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529 should have thrown ArrayIndexOutOfBoundsException");
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2_add17802() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2_add17802__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2_add17802__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2_add17802__33 = featuresToDelete.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911_failAssert2_add17802__33);
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(-1).getId(), this.projectId);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(-1).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16911 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__33 = featuresToDelete.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__33);
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__35 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031_failAssert23_add18127__35);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529 should have thrown ArrayIndexOutOfBoundsException");
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16529_failAssert8_literalMutationNumber17031 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__33 = featuresToDelete.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__33);
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__35 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916_failAssert7_add17997__35);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16916 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710_failAssert4_add17867() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710_failAssert4_add17867__15 = featuresToAdd.add(features.get(1));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710_failAssert4_add17867__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(-1));
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16515_failAssert0_literalMutationNumber16710 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17737() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17737__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17737__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17672() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17672__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17672__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(2).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17725() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17725__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17725__15);
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17725__17 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_add17725__17);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17660() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17660__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895_failAssert0_add17660__15);
                AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(2).getId(), this.projectId);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(2).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16895 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_literalMutationNumber17752() throws Exception {
        try {
            try {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_literalMutationNumber17752__15 = featuresToAdd.add(features.get(0));
                assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901_failAssert1_literalMutationNumber17752__15);
                boolean result = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(2).getId(), this.projectId);
                Assert.isTrue(result);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                result = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), this.projectId);
                Assert.isTrue(result);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == ((featuresOfRelease.size()) - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520 should have thrown IllegalArgumentException");
            } catch (IllegalArgumentException eee) {
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber16520_failAssert3_literalMutationNumber16901 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21);
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18776() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20);
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22);
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_sd18781() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__11);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__20 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__20);
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
        Date o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26 = release.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getMinutes())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getSeconds())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).toInstant()).getNano())));
        assertEquals(116, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getYear())));
        assertEquals(-60, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getTimezoneOffset())));
        assertEquals(10, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getMonth())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).toInstant()).getEpochSecond())));
        assertEquals(30, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getDate())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).toInstant()).toEpochMilli())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getTime())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).getDay())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26).toGMTString());
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18786_failAssert0() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(-1));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18786 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(-1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902__12);
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908__23 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908__23);
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
        Date o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31 = release.getDeadline();
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getHours())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getTime())));
        assertEquals(10, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getMonth())));
        assertEquals(116, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getYear())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getSeconds())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).toInstant()).getEpochSecond())));
        assertEquals(-60, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getTimezoneOffset())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).toInstant()).toEpochMilli())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).toLocaleString());
        assertEquals(30, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).getDate())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_sd18913__31).toGMTString());
    }


    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20 = resourcesToDelete.add(resources.get(0));
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
        Assert.notNull(release);
        Date o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34 = release.getDeadline();
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getTime())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).toInstant()).getNano())));
        assertEquals(-60, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getTimezoneOffset())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).toInstant()).toEpochMilli())));
        assertEquals(30, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getSeconds())));
        assertEquals(10, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getMinutes())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).toGMTString());
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getHours())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).toLocaleString());
        assertEquals(116, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getYear())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_sd18951__34).getDay())));
    }


    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_add19049() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_add19049__14 = resourcesToAdd.add(resources.get(0));
            assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_add19049__14);
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(-1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }


    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_literalMutationNumber19075() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_literalMutationNumber19075__13 = resourcesToAdd.add(resources.get(0));
            assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796_failAssert3_literalMutationNumber19075__13);
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(-1).getId(), this.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(-1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18796 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006_failAssert11() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(40).getId(), projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
            Assert.notNull(release);
            Date o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26 = release.getDeadline();
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18786_failAssert0_sd19031_failAssert13() throws Exception {
        try {
            try {
                Date __DSPOT_deadline_890 = new Date(".@ll+JCy` CpY ;@M@eF");
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                resourcesToAdd.add(resources.get(-1));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                resourcesToDelete.add(resources.get(0));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18786 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(new Date(".@ll+JCy` CpY ;@M@eF"));
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber18786_failAssert0_sd19031 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20 = resourcesToDelete.add(resources.get(0));
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
        Assert.notNull(release);
        Date o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37 = releases.get(0).getDeadline();
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getSeconds())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).toGMTString());
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).toInstant()).toEpochMilli())));
        assertEquals(10, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getMinutes())));
        assertEquals(-60, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getTimezoneOffset())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).toInstant()).getNano())));
        assertEquals(30, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getDate())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getTime())));
        assertEquals(116, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getYear())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_sd19722__37).getHours())));
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_add19717() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11 = resourcesToAdd.add(resources.get(0));
        Release o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942__15 = releases.get(0);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20 = resourcesToDelete.add(resources.get(0));
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_add19717__29 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_add19717__29);
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22 = resourcesToDelete.add(resources.get(0));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
        Assert.notNull(release);
    }



    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902_add19594() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
        Assert.notNull(resources);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902__12 = resourcesToAdd.add(resources.get(0));
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(0));
        Integer o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902_add19594__31 = release.getId();
        assertEquals(1, ((int) (o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18902_add19594__31)));
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
        Assert.notNull(release);
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006_failAssert11_add19971() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006_failAssert11_add19971__13 = resourcesToAdd.add(resources.get(0));
            assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006_failAssert11_add19971__13);
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(40).getId(), this.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
            Assert.notNull(release);
            Date o_testDeleteResourcesOfReleaseByIdOfProjectById_sd18781__26 = release.getDeadline();
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_sd18781_literalMutationNumber19006 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }


    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_literalMutationNumber19746_failAssert2() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__11 = resourcesToAdd.add(resources.get(0));
            Release o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942__15 = releases.get(0);
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__20 = resourcesToDelete.add(resources.get(-1));
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18776__22 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_add18776_add18942_literalMutationNumber19746 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908_literalMutationNumber19660_failAssert19() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(this.projectId);
            Assert.notNull(resources);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__12 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), this.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908__23 = resourcesToDelete.add(resources.get(0));
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectById_add18765__21 = resourcesToDelete.add(resources.get(-1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), this.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectById_add18765_add18908_literalMutationNumber19660 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20621() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testDeleteSkillOfProjectById_add20621__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621__5).getName());
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621__5).getDescription());
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20623_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Swift");
            skill.setDescription("Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
            Assert.notNull(skill);
            AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId));
            org.junit.Assert.fail("testDeleteSkillOfProjectById_add20623 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20621_add20696() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testDeleteSkillOfProjectById_add20621_add20696__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621_add20696__5).getDescription());
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621_add20696__5).getName());
        Skill o_testDeleteSkillOfProjectById_add20621__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20623_failAssert0_add20714() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Swift");
            skill.setName("Swift");
            skill.setDescription("Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, this.projectId);
            Assert.notNull(skill);
            boolean o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714__11 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId);
            assertTrue(o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714__11);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId));
            org.junit.Assert.fail("testDeleteSkillOfProjectById_add20623 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20621_add20696_add20856() throws Exception {
        Skill skill = new Skill();
        skill.setName("Swift");
        skill.setDescription("Swift development of iOS");
        Skill o_testDeleteSkillOfProjectById_add20621_add20696_add20856__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621_add20696_add20856__5).getName());
        assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20621_add20696_add20856__5).getDescription());
        Skill o_testDeleteSkillOfProjectById_add20621_add20696__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Skill o_testDeleteSkillOfProjectById_add20621__5 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
        Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillOfProjectById_add20623_failAssert0_add20714_add20878() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Swift");
            skill.setName("Swift");
            skill.setDescription("Swift development of iOS");
            Skill o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714_add20878__8 = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, this.projectId);
            assertEquals("Swift development of iOS", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714_add20878__8).getDescription());
            assertEquals("Swift", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714_add20878__8).getName());
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, this.projectId);
            Assert.notNull(skill);
            boolean o_testDeleteSkillOfProjectById_add20623_failAssert0_add20714__11 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId);
            boolean result = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId);
            Assert.isTrue(AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), this.projectId));
            org.junit.Assert.fail("testDeleteSkillOfProjectById_add20623 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21047() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21047__17 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21047__17);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21055() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21055__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21055__16);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21055__18 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21055__18);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
    }



    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21060() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21061() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22 = feature.getDeadline();
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getMonth())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getDay())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).toLocaleString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).toInstant()).getNano())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getTimezoneOffset())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).toGMTString());
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).toInstant()).toEpochMilli())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getMinutes())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getDate())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).getTime())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21061__22).toInstant()).getEpochSecond())));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21064() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        assertNull(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21075_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(-1).getId(), projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21075 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21078_failAssert1() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21078 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21080_failAssert2() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(-1));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21080 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21283() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21283__19 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21283__19);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21293() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21293__27 = feature.getReleaseId();
        assertNull(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21293__27);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21279() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21279__9 = features.get(0).getId();
        assertEquals(1, ((int) (o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21279__9)));
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21292() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27 = feature.getDeadline();
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getDate())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getSeconds())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getMinutes())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getDay())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getMonth())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).toInstant()).getEpochSecond())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).toInstant()).getNano())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getYear())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).getTime())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21289__27).toGMTString());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_sd21288() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }



    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21080_failAssert2_add21556() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21080_failAssert2_add21556__11 = features.get(0).getId();
            assertEquals(1, (int)features.get(0).getId());
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(-1));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber21080 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

 

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        assertEquals(111, (int)feature.getCode());
    }


    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28 = feature.getDeadline();
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getTime())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).toLocaleString());
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).toGMTString());
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getTimezoneOffset())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).toInstant()).toEpochMilli())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getMinutes())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).toInstant()).getNano())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getDay())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).toInstant()).getEpochSecond())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21450__28).getMonth())));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21440() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21440__9 = features.get(0).getId();
        assertEquals(1, ((int) (o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21440__9)));
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21453() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }



    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_literalMutationNumber21306_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), this.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_add21056_literalMutationNumber21306 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22466() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22466__22 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22466__22);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22476() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22476__30 = feature.getReleaseId();
        assertNull(o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22476__30);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22475() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22461() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22461__9 = features.get(0).getId();
        assertEquals(1, ((int) (o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_add22461__9)));
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30 = feature.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getHours())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getDate())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).toGMTString());
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getYear())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getTime())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).toInstant()).getNano())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).toInstant()).getEpochSecond())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getMonth())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getSeconds())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).toInstant()).toEpochMilli())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).toLocaleString());
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22472__30).getTimezoneOffset())));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_sd22471() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }



    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_add22560() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_add22560__19 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_add22560__19);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_add22816() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_add22816__19 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_add22816__19);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__22 = feature.getPriority();
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22570() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31 = feature.getDeadline();
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getDate())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).toInstant()).getNano())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).toGMTString());
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getDay())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getSeconds())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).toLocaleString());
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getMinutes())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).toInstant()).toEpochMilli())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).toInstant()).getEpochSecond())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getTime())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22567__31).getYear())));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__22 = feature.getPriority();
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31 = feature.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getHours())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).toInstant()).getNano())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getDate())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).toGMTString());
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getTimezoneOffset())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).toInstant()).toEpochMilli())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getMonth())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getMinutes())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getYear())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getSeconds())));
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22823__31).getDay())));
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444_sd22566() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_add21444__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405_sd22822() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064_add21405__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21064__22 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327__16 = skills.get(0);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060__22 = feature.getCode();
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31 = feature.getDeadline();
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getHours())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getYear())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).toGMTString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).toInstant()).getNano())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getTimezoneOffset())));
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getSeconds())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getMonth())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).toInstant()).toEpochMilli())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).toInstant()).getEpochSecond())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21060_add21327_sd22652__31).getTime())));
    }


    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21453_sd22782() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21453__28 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__16 = skillsToDelete.add(skills.get(0));
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065__22 = feature.getReleaseId();
        Integer o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449__28 = feature.getCode();
        Date o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32 = feature.getDeadline();
        assertEquals(4, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getDay())));
        assertEquals(3, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getMonth())));
        assertEquals(118, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getYear())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getTime())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).toInstant()).toEpochMilli())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).toLocaleString());
        assertEquals(5, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getHours())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getMinutes())));
        assertEquals(-120, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getTimezoneOffset())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).getSeconds())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).toInstant()).getNano())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testDeleteSkillsOfFeatureByIdOfProjectById_sd21065_sd21449_sd22612__32).toGMTString());
    }



    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_literalMutationNumber22489_failAssert1() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(40).getId(), this.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
            Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(0);
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_literalMutationNumber22489 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_literalMutationNumber22496_failAssert2() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(this.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__16 = skills.get(0);
            Skill o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284__19 = skills.get(-1);
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add21056__17 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), this.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectById_add21056_add21284_literalMutationNumber22496 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeatureByIdOfProjectById_add23490__4)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23494() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_sd23494__9 = feature.getDeadline();
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).toInstant()).toEpochMilli())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).toInstant()).getEpochSecond())));
        assertEquals(5, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getMonth())));
        assertEquals(-120, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getTimezoneOffset())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).toGMTString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getSeconds())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).toInstant()).getNano())));
        assertEquals(4, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getDay())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getHours())));
        assertEquals(118, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23494__9).getYear())));
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23497() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_literalMutationNumber23508_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_literalMutationNumber23508 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_add23584() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490_add23584__4 = features.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeatureByIdOfProjectById_add23490_add23584__4)));
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23590() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
        assertEquals(5, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getMonth())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).toInstant()).getEpochSecond())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).toGMTString());
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).toLocaleString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getTime())));
        assertEquals(4, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getDay())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getSeconds())));
        assertEquals(118, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getYear())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getMinutes())));
        assertEquals(-120, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591__13).getHours())));
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23594() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23595() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23595__13 = feature.getReleaseId();
        assertNull(o_testGetFeatureByIdOfProjectById_add23490_sd23595__13);
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23622() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Date o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13 = feature.getDeadline();
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).toInstant()).toEpochMilli())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getTime())));
        assertEquals(118, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getYear())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).toGMTString());
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).toInstant()).getEpochSecond())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).toLocaleString());
        assertEquals(5, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getHours())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).toInstant()).getNano())));
        assertEquals(-120, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getTimezoneOffset())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getMonth())));
        assertEquals(4, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13).getMinutes())));
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23625() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23494_sd23651() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_sd23494__9 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23497_sd23678() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23497__9 = feature.getPriority();
        Integer o_testGetFeatureByIdOfProjectById_sd23497_sd23678__13 = feature.getReleaseId();
        assertNull(o_testGetFeatureByIdOfProjectById_sd23497_sd23678__13);
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23498_add23695() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_sd23498_add23695__4 = features.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeatureByIdOfProjectById_sd23498_add23695__4)));
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23498__9 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23598_failAssert0() throws Exception {
        try {
            Date __DSPOT_deadline_1119 = new Date("yr;t]&]!vbNw8.:<e2op");
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
            Assert.notNull(feature);
            feature.setDeadline(new Date("yr;t]&]!vbNw8.:<e2op"));
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_sd23598 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_literalMutationNumber23605_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(-1).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_literalMutationNumber23605 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_literalMutationNumber23610_failAssert3() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_literalMutationNumber23610 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_sd24273() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23591_sd24273__17 = feature.getReleaseId();
        assertNull(o_testGetFeatureByIdOfProjectById_add23490_sd23591_sd24273__17);
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_add24267() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13 = feature.getDeadline();
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).toGMTString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).toInstant()).getNano())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getMonth())));
        assertEquals(4, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getDay())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).toInstant()).getEpochSecond())));
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).toLocaleString());
        assertEquals(5, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getSeconds())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).toInstant()).toEpochMilli())));
        assertEquals(-120, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getTimezoneOffset())));
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getHours())));
        assertEquals(118, ((int) (((java.util.Date)o_testGetFeatureByIdOfProjectById_add23490_sd23591_add24267__13).getYear())));
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_sd24272() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_sd24268() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23622_sd24371() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Date o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13 = feature.getDeadline();
        Integer o_testGetFeatureByIdOfProjectById_sd23493_sd23622_sd24371__17 = feature.getReleaseId();
        assertNull(o_testGetFeatureByIdOfProjectById_sd23493_sd23622_sd24371__17);
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23622_sd24370() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Date o_testGetFeatureByIdOfProjectById_sd23493_sd23622__13 = feature.getDeadline();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23626_sd24420() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Integer o_testGetFeatureByIdOfProjectById_sd23493_sd23626__13 = feature.getReleaseId();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23626_sd24424() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Integer o_testGetFeatureByIdOfProjectById_sd23493_sd23626__13 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23494_sd23652_sd24478() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Date o_testGetFeatureByIdOfProjectById_sd23494__9 = feature.getDeadline();
        Integer o_testGetFeatureByIdOfProjectById_sd23494_sd23652__13 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23493_sd23625_sd24393() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23493__9 = feature.getCode();
        Integer o_testGetFeatureByIdOfProjectById_sd23493_sd23625__13 = feature.getPriority();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_sd23497_sd23678_sd24505() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_sd23497__9 = feature.getPriority();
        Integer o_testGetFeatureByIdOfProjectById_sd23497_sd23678__13 = feature.getReleaseId();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23595_add24330() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23595_add24330__8 = features.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeatureByIdOfProjectById_add23490_sd23595_add24330__8)));
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23595__13 = feature.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23590_sd24235() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23590__13 = feature.getCode();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23594_sd24305() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        Integer o_testGetFeatureByIdOfProjectById_add23490_sd23594__13 = feature.getPriority();
        assertEquals(5, (int)feature.getPriority());
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_literalMutationNumber24286_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(40).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_sd23591_literalMutationNumber24286 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23591_literalMutationNumber24288_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), this.projectId);
            Assert.notNull(feature);
            Date o_testGetFeatureByIdOfProjectById_add23490_sd23591__13 = feature.getDeadline();
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_sd23591_literalMutationNumber24288 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeatureByIdOfProjectById_add23490_sd23590_literalMutationNumber24258_failAssert23() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testGetFeatureByIdOfProjectById_add23490__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(40).getId(), this.projectId);
            Assert.notNull(feature);
            Integer o_testGetFeatureByIdOfProjectById_add23490_sd23590__13 = feature.getCode();
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add23490_sd23590_literalMutationNumber24258 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber25259_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber25259 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber25262_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber25262 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293__4)));
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296__8 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296__8)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25300_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(-1).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25300 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25305_failAssert2() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25305 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25308_failAssert3() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25308 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293_add25438() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293_add25438__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293_add25438__4)));
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293__4 = releases.get(0).getId();
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296_add25463() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296_add25463__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296_add25463__4)));
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
        Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296__8 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25305_failAssert2_add25506() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25305_failAssert2_add25506__6 = releases.get(0).getId();
            assertEquals(1, (int)releases.get(0).getId());
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_literalMutationNumber25305 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293_literalMutationNumber25447_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293__4 = releases.get(-1).getId();
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25293_literalMutationNumber25447 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296_literalMutationNumber25477_failAssert8() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255__4 = releases.get(0).getId();
            Integer o_testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296__8 = releases.get(-1).getId();
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_add25255_add25296_literalMutationNumber25477 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetPlanOfReleaseByIdOfProjectById_add25804__4)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 100000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(2, (int)plan.getNumberFeatures());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25810() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(1, (int)plan.getNumberJobs());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25811() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber25820_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber25820 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber25823_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId));
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber25823 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_add25890() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804_add25890__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetPlanOfReleaseByIdOfProjectById_add25804_add25890__4)));
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25898() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(2, (int)plan.getNumberFeatures());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25899() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(1, (int)plan.getNumberJobs());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25900() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25807_sd25929() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Date o_testGetPlanOfReleaseByIdOfProjectById_sd25807__9 = plan.getCreationDate();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 100000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25952() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
        assertEquals(1, (int)plan.getNumberJobs());
    }

    @Test(timeout = 20000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25953() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810__9 = plan.getNumberJobs();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_literalMutationNumber25909_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(-1).getId();
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_add25804_literalMutationNumber25909 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_literalMutationNumber25914_failAssert2() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_add25804_literalMutationNumber25914 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25807_literalMutationNumber25941_failAssert5() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(plan);
            Date o_testGetPlanOfReleaseByIdOfProjectById_sd25807__9 = plan.getCreationDate();
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_sd25807_literalMutationNumber25941 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25955_failAssert6() throws Exception {
        try {
            Date __DSPOT_creationDate_1283 = new Date("/t[:&/Q%haL`9o.Tvur=");
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(plan);
            Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
            plan.setCreationDate(new Date("/t[:&/Q%haL`9o.Tvur="));
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25955 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896_sd26590() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Date o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896__13 = plan.getCreationDate();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25949_sd26788() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
        Date o_testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25949__13 = plan.getCreationDate();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977_sd26863() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810__9 = plan.getNumberJobs();
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977__13 = plan.getReleaseId();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977_add26854() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977_add26854__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977_add26854__4)));
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810__9 = plan.getNumberJobs();
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25810_sd25977__13 = plan.getReleaseId();
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25900_sd26683() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25900__13 = plan.getReleaseId();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25953_sd26838() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25953__13 = plan.getReleaseId();
        assertEquals(1, (int)plan.getReleaseId());
    }

    @Test(timeout = 20000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25899_sd26651() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25899__13 = plan.getNumberJobs();
        assertEquals(1, (int)plan.getNumberJobs());
    }

    @Test(timeout = 20000)
    public void testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25952_sd26812() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809__9 = plan.getNumberFeatures();
        Integer o_testGetPlanOfReleaseByIdOfProjectById_sd25809_sd25952__13 = plan.getNumberJobs();
        assertEquals(1, (int)plan.getNumberJobs());
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25898_add26610() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
        Assert.notEmpty(releases);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25898_add26610__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25898_add26610__4)));
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
        Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
        Assert.notNull(plan);
        Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25898__13 = plan.getNumberFeatures();
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896_literalMutationNumber26599_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(-1).getId();
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), this.projectId);
            Assert.notNull(plan);
            Date o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896__13 = plan.getCreationDate();
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896_literalMutationNumber26599 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896_literalMutationNumber26607_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testGetPlanOfReleaseByIdOfProjectById_add25804__4 = releases.get(0).getId();
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), this.projectId);
            Assert.notNull(plan);
            Date o_testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896__13 = plan.getCreationDate();
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_add25804_sd25896_literalMutationNumber26607 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetProjectById_sd27564() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testGetProjectById_sd27564_add27603() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testGetProjectById_sd27564_add27603_add27647() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetReleaseByIdOfProjectById_add27694__4)));
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_sd27697() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testGetReleaseByIdOfProjectById_sd27697__9 = release.getDeadline();
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).toInstant()).getEpochSecond())));
        assertEquals(10, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getMonth())));
        assertEquals(30, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getDate())));
        assertEquals(-60, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getTimezoneOffset())));
        assertEquals(116, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getYear())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).toGMTString());
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getTime())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getMinutes())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).toLocaleString());
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getSeconds())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).getHours())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697__9).toInstant()).getNano())));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_literalMutationNumber27702_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_literalMutationNumber27702 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_literalMutationNumber27705_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(40).getId(), projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_literalMutationNumber27705 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_add27748() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetReleaseByIdOfProjectById_add27694_add27748__4)));
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_sd27754() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testGetReleaseByIdOfProjectById_add27694_sd27754__13 = release.getDeadline();
        assertEquals(10, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getMonth())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).toGMTString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).toInstant()).getNano())));
        assertEquals(116, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getYear())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getDay())));
        assertEquals(30, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getDate())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getHours())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).toInstant()).getEpochSecond())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).toLocaleString());
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).toInstant()).toEpochMilli())));
        assertEquals(-60, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getTimezoneOffset())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_sd27754__13).getMinutes())));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_sd27697_sd27775() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testGetReleaseByIdOfProjectById_sd27697__9 = release.getDeadline();
        Date o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13 = release.getDeadline();
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getTime())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).toLocaleString());
        assertEquals(30, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getHours())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getSeconds())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getMinutes())));
        assertEquals(116, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getYear())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).toInstant()).getNano())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).toInstant()).getEpochSecond())));
        assertEquals(-60, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getTimezoneOffset())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).toGMTString());
        assertEquals(10, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_sd27697_sd27775__13).getMonth())));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27759_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(-1).getId();
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27759 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27764_failAssert2() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27764 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_literalMutationNumber27705_failAssert1_sd27807_failAssert6() throws Exception {
        try {
            try {
                Date __DSPOT_deadline_1429 = new Date("wJD0X/#9$UN)AU$4HgD@");
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(40).getId(), projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectById_literalMutationNumber27705 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(new Date("wJD0X/#9$UN)AU$4HgD@"));
            } catch (ArrayIndexOutOfBoundsException eee) {
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_literalMutationNumber27705_failAssert1_sd27807 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_add27748_add27999() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748_add27999__4 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetReleaseByIdOfProjectById_add27694_add27748_add27999__4)));
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748__4 = releases.get(0).getId();
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_add27748_add28001() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748__4 = releases.get(0).getId();
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748_add28001__8 = releases.get(0).getId();
        assertEquals(1, ((int) (o_testGetReleaseByIdOfProjectById_add27694_add27748_add28001__8)));
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_add27748_sd28007() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notEmpty(releases);
        Integer o_testGetReleaseByIdOfProjectById_add27694_add27748__4 = releases.get(0).getId();
        Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
        Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
        Assert.notNull(release);
        Date o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17 = release.getDeadline();
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getHours())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).toGMTString());
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getSeconds())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getMinutes())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).toInstant()).toEpochMilli())));
        assertEquals(30, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getDate())));
        assertEquals(3, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getDay())));
        assertEquals(10, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getMonth())));
        assertEquals(-60, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getTimezoneOffset())));
        assertEquals(116, ((int) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getYear())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).toInstant()).getNano())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).getTime())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testGetReleaseByIdOfProjectById_add27694_add27748_sd28007__17).toLocaleString());
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27764_failAssert2_add28090() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(this.projectId);
            Assert.notEmpty(releases);
            Integer o_testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27764_failAssert2_add28090__6 = releases.get(0).getId();
            assertEquals(1, (int)releases.get(0).getId());
            Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(-1).getId(), this.projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add27694_literalMutationNumber27764 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testGetReleaseByIdOfProjectById_add27694_add27748_literalMutationNumber28012_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notEmpty(releases);
            Integer o_testGetReleaseByIdOfProjectById_add27694_add27748__4 = releases.get(-1).getId();
            Integer o_testGetReleaseByIdOfProjectById_add27694__4 = releases.get(0).getId();
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
            Assert.notNull(AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId));
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add27694_add27748_literalMutationNumber28012 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        assertEquals(111, (int)AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getCode());
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28553() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        Date o_testUpdateFeatureOfProjectById_sd28553__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getDeadline();
        assertEquals("Apr 5, 2018 12:00:00 AM", ((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).toLocaleString());
        assertEquals(-120, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getTimezoneOffset())));
        assertEquals(4, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getDay())));
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getMonth())));
        assertEquals(5, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getDate())));
        assertEquals(1522879200000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).toInstant()).toEpochMilli())));
        assertEquals(1522879200L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getHours())));
        assertEquals(118, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getYear())));
        assertEquals("4 Apr 2018 22:00:00 GMT", ((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).toGMTString());
        assertEquals(1522879200000L, ((long) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getTime())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateFeatureOfProjectById_sd28553__15).getSeconds())));
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_literalMutationNumber28567_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_literalMutationNumber28567 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_literalMutationNumber28570_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(40).getId(), projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_literalMutationNumber28570 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_add28722() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testUpdateFeatureOfProjectById_sd28552_add28722__4 = features.get(0).getId();
        assertEquals(1, ((int) (o_testUpdateFeatureOfProjectById_sd28552_add28722__4)));
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getCode();
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28553_add28772() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
        Assert.notEmpty(features);
        Integer o_testUpdateFeatureOfProjectById_sd28553_add28772__4 = features.get(0).getId();
        assertEquals(1, ((int) (o_testUpdateFeatureOfProjectById_sd28553_add28772__4)));
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        Date o_testUpdateFeatureOfProjectById_sd28553__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getDeadline();
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_literalMutationNumber28759_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId);
            Assert.notNull(feature);
            Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getCode();
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28552_literalMutationNumber28759 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28553_literalMutationNumber28809_failAssert2() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId);
            Assert.notNull(feature);
            Date o_testUpdateFeatureOfProjectById_sd28553__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, projectId).getDeadline();
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28553_literalMutationNumber28809 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_add28722_sd29511() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testUpdateFeatureOfProjectById_sd28552_add28722__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId).getCode();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28553_add28772_sd29568() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
        Assert.notEmpty(features);
        Integer o_testUpdateFeatureOfProjectById_sd28553_add28772__4 = features.get(0).getId();
        Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        Assert.notNull(feature);
        Date o_testUpdateFeatureOfProjectById_sd28553__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId).getDeadline();
        assertEquals(111, (int)feature.getCode());
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28553_add28772_sd29590_failAssert0() throws Exception {
        try {
            Date __DSPOT_deadline_1535 = new Date("<5]|k5aw4Z#8{}YbgCZ5");
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testUpdateFeatureOfProjectById_sd28553_add28772__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId);
            Assert.notNull(feature);
            Date o_testUpdateFeatureOfProjectById_sd28553__15 = __DSPOT_invoc_11.getDeadline();
            __DSPOT_invoc_11.setDeadline(new Date("<5]|k5aw4Z#8{}YbgCZ5"));
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28553_add28772_sd29590 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29540_failAssert1() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testUpdateFeatureOfProjectById_sd28552_add28722__4 = features.get(-1).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId);
            Assert.notNull(feature);
            Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId).getCode();
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29540 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29545_failAssert2() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testUpdateFeatureOfProjectById_sd28552_add28722__4 = features.get(0).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(-1).getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId);
            Assert.notNull(feature);
            Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId).getCode();
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29545 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29543_failAssert3() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(this.projectId);
            Assert.notEmpty(features);
            Integer o_testUpdateFeatureOfProjectById_sd28552_add28722__4 = features.get(40).getId();
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), this.projectId);
            Assert.notNull(feature);
            feature.setDescription(((feature.getDescription()) + " modified by test"));
            Feature __DSPOT_invoc_11 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId);
            Assert.notNull(feature);
            Integer o_testUpdateFeatureOfProjectById_sd28552__15 = AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, this.projectId).getCode();
            org.junit.Assert.fail("testUpdateFeatureOfProjectById_sd28552_add28722_literalMutationNumber29543 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateProject_sd30307() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = AmplReplanControllerProxyTest.proxy.updateProject(project);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testUpdateProject_sd30307_add30382() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        Assert.notNull(project);
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = AmplReplanControllerProxyTest.proxy.updateProject(project);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testUpdateProject_sd30307_add30382_add30466() throws Exception {
        Project project = AmplReplanControllerProxyTest.proxy.getProjectById(projectId);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project);
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = AmplReplanControllerProxyTest.proxy.updateProject(project);
        Assert.notNull(project);
        assertEquals("hour", project.getEffortUnit());
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
        Assert.notNull(release);
        Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getSeconds())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).toLocaleString());
        assertEquals(-60, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getTimezoneOffset())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getHours())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).toGMTString());
        assertEquals(116, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getYear())));
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getDay())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getTime())));
        assertEquals(30, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getDate())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).toInstant()).getNano())));
        assertEquals(10, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558__12).getMonth())));
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_literalMutationNumber30563_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(-1);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_literalMutationNumber30563 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_add30645() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
        Assert.notNull(release);
        Date o_testUpdateReleasesOfProjectById_sd30558_add30645__12 = release.getDeadline();
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getSeconds())));
        assertEquals(10, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getMonth())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).toInstant()).getNano())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).toInstant()).toEpochMilli())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getMinutes())));
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).toGMTString());
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getHours())));
        assertEquals(116, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getYear())));
        assertEquals(-60, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getTimezoneOffset())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getTime())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).toLocaleString());
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).toInstant()).getEpochSecond())));
        assertEquals(30, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645__12).getDate())));
        Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_sd30646() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
        Assert.notNull(release);
        Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
        Date o_testUpdateReleasesOfProjectById_sd30558_sd30646__16 = release.getDeadline();
        assertEquals(10, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getMonth())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getMinutes())));
        assertEquals(30, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getSeconds())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).toInstant()).getEpochSecond())));
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getHours())));
        assertEquals(-60, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getTimezoneOffset())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).toLocaleString());
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).toGMTString());
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).toInstant()).toEpochMilli())));
        assertEquals(116, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getYear())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).getTime())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_sd30646__16).toInstant()).getNano())));
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_sd30648_failAssert0() throws Exception {
        try {
            Date __DSPOT_deadline_1583 = new Date("6-*};E9`u!Ce#(-%(=hn");
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
            release.setDeadline(new Date("6-*};E9`u!Ce#(-%(=hn"));
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_sd30558_sd30648 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_literalMutationNumber30651_failAssert1() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(-1);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_sd30558_literalMutationNumber30651 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_add30645_add30820() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
        Assert.notNull(release);
        Date o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12 = release.getDeadline();
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).toGMTString());
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).toInstant()).getNano())));
        assertEquals(-60, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getTimezoneOffset())));
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getDay())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getSeconds())));
        assertEquals(116, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getYear())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).toLocaleString());
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getTime())));
        assertEquals(30, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getDate())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).toInstant()).toEpochMilli())));
        assertEquals(10, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getMonth())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).toInstant()).getEpochSecond())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30820__12).getHours())));
        Date o_testUpdateReleasesOfProjectById_sd30558_add30645__12 = release.getDeadline();
        Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_add30645_add30821() throws Exception {
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
        Assert.notNull(release);
        Date o_testUpdateReleasesOfProjectById_sd30558_add30645__12 = release.getDeadline();
        Date o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16 = release.getDeadline();
        assertEquals(3, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getDay())));
        assertEquals(-60, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getTimezoneOffset())));
        assertEquals(1480460400000L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).toInstant()).toEpochMilli())));
        assertEquals(10, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getMonth())));
        assertEquals(0, ((int) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).toInstant()).getNano())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getMinutes())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getSeconds())));
        assertEquals(1480460400L, ((long) (((java.time.Instant)((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).toInstant()).getEpochSecond())));
        assertEquals("Nov 30, 2016 12:00:00 AM", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).toLocaleString());
        assertEquals("29 Nov 2016 23:00:00 GMT", ((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).toGMTString());
        assertEquals(30, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getDate())));
        assertEquals(0, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getHours())));
        assertEquals(1480460400000L, ((long) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getTime())));
        assertEquals(116, ((int) (((java.util.Date)o_testUpdateReleasesOfProjectById_sd30558_add30645_add30821__16).getYear())));
        Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_add30645_literalMutationNumber30827_failAssert0() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(-1);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            Date o_testUpdateReleasesOfProjectById_sd30558_add30645__12 = release.getDeadline();
            Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_sd30558_add30645_literalMutationNumber30827 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_sd30646_sd30849_failAssert2() throws Exception {
        try {
            Date __DSPOT_deadline_1589 = new Date("z={[YT&^U6Y]Kg1e/q[N");
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
            Date o_testUpdateReleasesOfProjectById_sd30558_sd30646__16 = release.getDeadline();
            release.setDeadline(new Date("z={[YT&^U6Y]Kg1e/q[N"));
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_sd30558_sd30646_sd30849 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateReleasesOfProjectById_sd30558_sd30646_literalMutationNumber30852_failAssert3() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(-1);
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, projectId);
            Assert.notNull(release);
            Date o_testUpdateReleasesOfProjectById_sd30558__12 = release.getDeadline();
            Date o_testUpdateReleasesOfProjectById_sd30558_sd30646__16 = release.getDeadline();
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_sd30558_sd30646_literalMutationNumber30852 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateResourceOfProjectById_literalMutationNumber31224_failAssert0() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(-1);
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testUpdateResourceOfProjectById_literalMutationNumber31224 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_add31386() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill o_testUpdateSkillsOfProjectById_add31386__5 = skills.get(0);
        assertEquals(1, ((int) (((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386__5).getId())));
        assertEquals("Java", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386__5).getName());
        Skill skill = skills.get(0);
        skill.setDescription(((skill.getDescription()) + " modified by test"));
        skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_literalMutationNumber31392_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(-1);
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectById_literalMutationNumber31392 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_add31386_add31458() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill o_testUpdateSkillsOfProjectById_add31386_add31458__5 = skills.get(0);
        assertEquals(1, ((int) (((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386_add31458__5).getId())));
        assertEquals("Java", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386_add31458__5).getName());
        Skill o_testUpdateSkillsOfProjectById_add31386__5 = skills.get(0);
        Skill skill = skills.get(0);
        skill.setDescription(((skill.getDescription()) + " modified by test"));
        skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_add31386_literalMutationNumber31465_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill o_testUpdateSkillsOfProjectById_add31386__5 = skills.get(-1);
            Skill skill = skills.get(0);
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectById_add31386_literalMutationNumber31465 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_add31386_add31458_add31618() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill o_testUpdateSkillsOfProjectById_add31386_add31458_add31618__5 = skills.get(0);
        assertEquals("Java", ((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386_add31458_add31618__5).getName());
        assertEquals(1, ((int) (((eu.supersede.integration.api.replan.controller.types.Skill)o_testUpdateSkillsOfProjectById_add31386_add31458_add31618__5).getId())));
        Skill o_testUpdateSkillsOfProjectById_add31386_add31458__5 = skills.get(0);
        Skill o_testUpdateSkillsOfProjectById_add31386__5 = skills.get(0);
        Skill skill = skills.get(0);
        skill.setDescription(((skill.getDescription()) + " modified by test"));
        skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
        Assert.notNull(skill);
    }

    @Test(timeout = 10000)
    public void testUpdateSkillsOfProjectById_add31386_add31458_literalMutationNumber31626_failAssert0() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill o_testUpdateSkillsOfProjectById_add31386_add31458__5 = skills.get(-1);
            Skill o_testUpdateSkillsOfProjectById_add31386__5 = skills.get(0);
            Skill skill = skills.get(0);
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectById_add31386_add31458_literalMutationNumber31626 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException eee) {
        }
    }
}

