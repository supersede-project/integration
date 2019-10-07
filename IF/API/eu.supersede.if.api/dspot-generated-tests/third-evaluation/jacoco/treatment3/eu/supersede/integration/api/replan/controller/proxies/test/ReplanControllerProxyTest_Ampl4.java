package eu.supersede.integration.api.replan.controller.proxies.test;


import eu.supersede.integration.api.replan.controller.proxies.IReplanController;
import eu.supersede.integration.api.replan.controller.proxies.ReplanControllerProxy;
import eu.supersede.integration.api.replan.controller.types.AddFeaturesForProjectPayload;
import eu.supersede.integration.api.replan.controller.types.Constraint;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.FeatureWP3;
import eu.supersede.integration.api.replan.controller.types.Job;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.ReplanIdentifiableObject;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class ReplanControllerProxyTest {
    private static final Logger log = LoggerFactory.getLogger(ReplanControllerProxyTest.class);

    private static IReplanController proxy;

    private static int projectId;

    private static int skillId;

    private static int resourceId;

    private static int featureId;

    private static int releaseId;

    @BeforeClass
    public static void setup() throws Exception {
        ReplanControllerProxyTest.proxy = new ReplanControllerProxy();
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        ReplanControllerProxyTest.projectId = project.getId();
        Skill skill = new Skill();
        skill.setName("Atos test: Swift");
        skill.setDescription("Atos test: Swift development of iOS");
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource.getId());
        ReplanControllerProxyTest.resourceId = resource.getId();
        Feature feature = ReplanControllerProxyTest.createFeature();
        feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        ReplanControllerProxyTest.featureId = feature.getId();
        Release release = ReplanControllerProxyTest.createRelease();
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.addReleaseOfProjectById(release, ReplanControllerProxyTest.projectId), HttpStatus.OK);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(releases);
        Assert.notNull(releases.get(0).getId());
        ReplanControllerProxyTest.releaseId = releases.get(0).getId();
        skill = ReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        ReplanControllerProxyTest.skillId = skill.getId();
    }

    @org.junit.AfterClass
    public static void cleanup() throws Exception {
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(ReplanControllerProxyTest.skillId, ReplanControllerProxyTest.projectId), HttpStatus.OK);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(ReplanControllerProxyTest.featureId, ReplanControllerProxyTest.projectId), HttpStatus.OK);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(ReplanControllerProxyTest.resourceId, ReplanControllerProxyTest.projectId), HttpStatus.OK);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteReleaseByIdOfProjectById(ReplanControllerProxyTest.releaseId, ReplanControllerProxyTest.projectId), HttpStatus.OK);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteProjectById(ReplanControllerProxyTest.projectId), HttpStatus.OK);
    }

    @Test(timeout = 30000)
    public void testGetAllProjectsnull35800_failAssert0() throws Exception {
        try {
            List<Project> projects = ReplanControllerProxyTest.proxy.getAllProjects();
            Assert.notNull(null);
            Assert.notEmpty(projects);
            org.junit.Assert.fail("testGetAllProjectsnull35800 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProjectByIdnull38282_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.proxy.getProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetProjectByIdnull38282 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectById_add36421() throws Exception {
        List<Feature> o_testGetFeaturesOfProjectById_add36421__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testGetFeaturesOfProjectById_add36421__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add36421__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectById_add36424() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Feature> o_testGetFeaturesOfProjectById_add36424__5 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add36424__5.isEmpty());
        features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add36424__5.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectById_add35846() throws Exception {
        List<Feature> o_testGetFeatureByIdOfProjectById_add35846__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testGetFeatureByIdOfProjectById_add35846__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        assertFalse(o_testGetFeatureByIdOfProjectById_add35846__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_add38364() throws Exception {
        List<Release> o_testGetReleaseByIdOfProjectById_add38364__1 = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testGetReleaseByIdOfProjectById_add38364__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(releases);
        Release release = ReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        assertFalse(o_testGetReleaseByIdOfProjectById_add38364__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_add38364_mg38499_failAssert0_mg38721_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_997 = Collections.singletonList(new Resource());
                Date __DSPOT_deadline_987 = new Date("98,:vZSyvK=3uf%r@|0I");
                List<Release> o_testGetReleaseByIdOfProjectById_add38364__1 = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = ReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDeadline(__DSPOT_deadline_987);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add38364_mg38499 should have thrown IllegalArgumentException");
                release.setResources(__DSPOT_resources_997);
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_add38364_mg38499_failAssert0_mg38721 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add36786() throws Exception {
        List<Release> o_testGetFeaturesOfReleaseByIdOfProjectById_add36786__1 = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testGetFeaturesOfReleaseByIdOfProjectById_add36786__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(releases);
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        assertFalse(o_testGetFeaturesOfReleaseByIdOfProjectById_add36786__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber36794_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber36794 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectById_add37235() throws Exception {
        List<Release> o_testGetPlanOfReleaseByIdOfProjectById_add37235__1 = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testGetPlanOfReleaseByIdOfProjectById_add37235__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(releases);
        Plan plan = ReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(plan);
        assertFalse(o_testGetPlanOfReleaseByIdOfProjectById_add37235__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull37267_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Plan plan = ReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull37267 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243_failAssert0_mg37399_failAssert0() throws Exception {
        try {
            {
                List<Job> __DSPOT_jobs_919 = Collections.singletonList(new Job());
                List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = ReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), ReplanControllerProxyTest.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243 should have thrown ArrayIndexOutOfBoundsException");
                plan.setJobs(__DSPOT_jobs_919);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243_failAssert0_mg37399 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243_failAssert0_mg37407_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resourceUsage_924 = Collections.singletonList(new Resource());
                List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = ReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), ReplanControllerProxyTest.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243 should have thrown ArrayIndexOutOfBoundsException");
                plan.setResourceUsage(__DSPOT_resourceUsage_924);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber37243_failAssert0_mg37407 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add17365() throws Exception {
        Project o_testCreateAndDeleteProject_add17365__1 = ReplanControllerProxyTest.createProject();
        assertEquals("hour", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getEffortUnit());
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteProject_add17365__1)).getId());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        HttpStatus o_testCreateAndDeleteProject_add17365__9 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteProject_add17365__9)).toString());
        assertEquals("hour", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getEffortUnit());
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteProject_add17365__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteProject_add17365__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteProject_add17365__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add17370() throws Exception {
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        HttpStatus o_testCreateAndDeleteProject_add17370__8 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).toString());
        HttpStatus o_testCreateAndDeleteProject_add17370__10 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertNull(o_testCreateAndDeleteProject_add17370__10);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteProject_add17370__8)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull17379_failAssert0_mg17448_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_553 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest.createProject();
                project = ReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteProjectnull17379 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_553);
            }
            org.junit.Assert.fail("testCreateAndDeleteProjectnull17379_failAssert0_mg17448 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add17365null17541_failAssert0_mg17885_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_570 = Collections.singletonList(new Resource());
                Project o_testCreateAndDeleteProject_add17365__1 = ReplanControllerProxyTest.createProject();
                Project project = ReplanControllerProxyTest.createProject();
                project = ReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                HttpStatus o_testCreateAndDeleteProject_add17365__9 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteProject_add17365null17541 should have thrown IllegalArgumentException");
                o_testCreateAndDeleteProject_add17365__1.setResources(__DSPOT_resources_570);
            }
            org.junit.Assert.fail("testCreateAndDeleteProject_add17365null17541_failAssert0_mg17885 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    private static Project createProject() {
        Project project = new Project();
        project.setName("Atos Project Test");
        project.setDescription("Atos Project Test Description");
        project.setEffortUnit("hour");
        project.setHoursPerEffortUnit(1.0);
        project.setHoursPerWeekFullTimeResource(40.0);
        return project;
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add15168() throws Exception {
        Project o_testCreateAndDeleteFeatureForProject_add15168__1 = ReplanControllerProxyTest.createProject();
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getId());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest.createFeature();
        feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        HttpStatus o_testCreateAndDeleteFeatureForProject_add15168__17 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).toString());
        HttpStatus o_testCreateAndDeleteFeatureForProject_add15168__20 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__20)).toString());
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteFeatureForProject_add15168__1)).getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15168__17)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add15179() throws Exception {
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest.createFeature();
        feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        HttpStatus o_testCreateAndDeleteFeatureForProject_add15179__16 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).toString());
        HttpStatus o_testCreateAndDeleteFeatureForProject_add15179__19 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
        assertNull(o_testCreateAndDeleteFeatureForProject_add15179__19);
        HttpStatus o_testCreateAndDeleteFeatureForProject_add15179__22 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__22)).toString());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_add15179__16)).toString());
        assertNull(o_testCreateAndDeleteFeatureForProject_add15179__19);
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg15198() throws Exception {
        List<Skill> __DSPOT_requiredSkills_267 = Collections.singletonList(new Skill());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest.createFeature();
        feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__19 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).toString());
        HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__22 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).toString());
        feature.setRequiredSkills(__DSPOT_requiredSkills_267);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__19)).toString());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg15198__22)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add15174_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add15174 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15199_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15199 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15200_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15201_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15201 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15202_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(null);
            Assert.notNull(feature.getId());
            ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15202 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15200_failAssert0_mg15455_failAssert0() throws Exception {
        try {
            {
                List<Feature> __DSPOT_dependencies_310 = Collections.singletonList(new Feature());
                Project project = ReplanControllerProxyTest.createProject();
                project = ReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest.createFeature();
                feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200 should have thrown IllegalArgumentException");
                feature.setDependencies(__DSPOT_dependencies_310);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200_failAssert0_mg15455 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg15198null15762_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_requiredSkills_267 = Collections.singletonList(new Skill());
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__19 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__22 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            feature.setRequiredSkills(__DSPOT_requiredSkills_267);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg15198null15762 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg15198_add15464_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_requiredSkills_267 = Collections.singletonList(new Skill());
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__19 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__22 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            feature.setRequiredSkills(__DSPOT_requiredSkills_267);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg15198_add15464 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg15198null15765_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_requiredSkills_267 = Collections.singletonList(new Skill());
            Project project = ReplanControllerProxyTest.createProject();
            project = ReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest.createFeature();
            feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__19 = ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg15198__22 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            feature.setRequiredSkills(__DSPOT_requiredSkills_267);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg15198null15765 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull15200_failAssert0_mg15455_failAssert0null16812_failAssert0() throws Exception {
        try {
            {
                {
                    List<Feature> __DSPOT_dependencies_310 = Collections.singletonList(new Feature());
                    Project project = ReplanControllerProxyTest.createProject();
                    project = ReplanControllerProxyTest.proxy.createProject(null);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    Feature feature = ReplanControllerProxyTest.createFeature();
                    feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                    Assert.notNull(feature);
                    Assert.notNull(feature.getId());
                    ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                    ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200 should have thrown IllegalArgumentException");
                    feature.setDependencies(__DSPOT_dependencies_310);
                }
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200_failAssert0_mg15455 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull15200_failAssert0_mg15455_failAssert0null16812 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Test
    @Ignore
    public void testAddFeaturesOfProjectById() throws Exception {
        AddFeaturesForProjectPayload payload = new AddFeaturesForProjectPayload();
        List<FeatureWP3> features = new ArrayList<>();
        features.add(ReplanControllerProxyTest.createFeatureWP3());
        payload.setFeatures(features);
        List<Constraint> constraints = new ArrayList<>();
        constraints.add(createConstraint());
        payload.setConstraints(constraints);
        payload.setEvaluationTime(DateFormat.getDateInstance().format(Calendar.getInstance().getTime()));
        ReplanControllerProxyTest.proxy.addFeaturesToProjectById(payload, 1);
    }

    private Constraint createConstraint() {
        Constraint constraint = new Constraint();
        constraint.setOperator("EQUALS");
        constraint.setVariable("size");
        constraint.setValue(1.0);
        return constraint;
    }

    private static Feature createFeature() {
        Feature feature = new Feature();
        feature.setCode(111);
        feature.setName("Atos Test Feature: Fix auto upload");
        feature.setDescription("Bla, bla, bla es mucho decir");
        feature.setEffort(4.0);
        feature.setDeadline(Calendar.getInstance().getTime());
        feature.setPriority(5);
        return feature;
    }

    private static FeatureWP3 createFeatureWP3() {
        FeatureWP3 feature = new FeatureWP3();
        feature.setName("Atos Test Feature: Fix auto upload");
        feature.setDescription("Bla, bla, bla es mucho decir");
        feature.setEffort(4.0);
        return feature;
    }

    private static Release createRelease() {
        Release release = new Release();
        release.setName("Atos test release name");
        release.setDescription("Atos test release description");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        release.setDeadline(c.getTime());
        release.setStartsAt(Calendar.getInstance().getTime());
        return release;
    }

    @Test(timeout = 30000)
    public void testUpdateProject_add39335() throws Exception {
        Project o_testUpdateProject_add39335__1 = ReplanControllerProxyTest.createProject();
        assertEquals("hour", ((Project) (o_testUpdateProject_add39335__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testUpdateProject_add39335__1)).getHoursPerEffortUnit())), 0.1);
        assertEquals(40.0, ((double) (((Project) (o_testUpdateProject_add39335__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertTrue(((Collection) (((Project) (o_testUpdateProject_add39335__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testUpdateProject_add39335__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testUpdateProject_add39335__1)).getName());
        assertNull(((Project) (o_testUpdateProject_add39335__1)).getId());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = ReplanControllerProxyTest.proxy.updateProject(project);
        HttpStatus o_testUpdateProject_add39335__14 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_add39335__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39335__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_add39335__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39335__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39335__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39335__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_add39335__14)).toString());
        assertEquals("hour", ((Project) (o_testUpdateProject_add39335__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testUpdateProject_add39335__1)).getHoursPerEffortUnit())), 0.1);
        assertEquals(40.0, ((double) (((Project) (o_testUpdateProject_add39335__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertTrue(((Collection) (((Project) (o_testUpdateProject_add39335__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testUpdateProject_add39335__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testUpdateProject_add39335__1)).getName());
        assertNull(((Project) (o_testUpdateProject_add39335__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateProject_add39344() throws Exception {
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = ReplanControllerProxyTest.proxy.updateProject(project);
        HttpStatus o_testUpdateProject_add39344__13 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_add39344__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_add39344__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_add39344__13)).toString());
        HttpStatus o_testUpdateProject_add39344__15 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertNull(o_testUpdateProject_add39344__15);
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_add39344__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_add39344__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_add39344__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_add39344__13)).toString());
    }

    @Test(timeout = 30000)
    public void testUpdateProject_mg39359() throws Exception {
        List<Resource> __DSPOT_resources_1002 = Collections.singletonList(new Resource());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = ReplanControllerProxyTest.proxy.updateProject(project);
        HttpStatus o_testUpdateProject_mg39359__16 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_mg39359__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_mg39359__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_mg39359__16)).toString());
        project.setResources(__DSPOT_resources_1002);
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_mg39359__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_mg39359__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_mg39359__16)).toString());
    }

    @Test(timeout = 30000)
    public void testUpdateProject_mg39359_add39522() throws Exception {
        List<Resource> __DSPOT_resources_1002 = Collections.singletonList(new Resource());
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = ReplanControllerProxyTest.proxy.updateProject(project);
        HttpStatus o_testUpdateProject_mg39359_add39522__16 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is3xxRedirection());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is2xxSuccessful());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).toString());
        HttpStatus o_testUpdateProject_mg39359__16 = ReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        project.setResources(__DSPOT_resources_1002);
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is3xxRedirection());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).is2xxSuccessful());
        assertEquals("200", ((HttpStatus) (o_testUpdateProject_mg39359_add39522__16)).toString());
    }

    @Test
    @Ignore
    public void testUpdateFeatureOfProjectById() throws Exception {
        Project project = ReplanControllerProxyTest.createProject();
        project = ReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest.createFeature();
        feature = ReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(project.getId());
        Assert.notEmpty(features);
        feature = ReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), project.getId());
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        ReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()), HttpStatus.OK);
        org.junit.Assert.assertEquals(ReplanControllerProxyTest.proxy.deleteProjectById(project.getId()), HttpStatus.OK);
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectById_remove41040() throws Exception {
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        String originalDescription = release.getDescription();
        assertEquals("Atos test release description", originalDescription);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        release.setDescription(originalDescription);
        release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest.projectId);
        assertEquals("Atos test release description", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull41070_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release.setDescription(originalDescription);
            release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull41070 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectById_remove41040null41335_failAssert0_mg41768_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_1088 = Collections.singletonList(new Resource());
                List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(0);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + " modified by test"));
                release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, ReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDescription(originalDescription);
                release = ReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testUpdateReleasesOfProjectById_remove41040null41335 should have thrown IllegalArgumentException");
                release.setResources(__DSPOT_resources_1088);
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_remove41040null41335_failAssert0_mg41768 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitNum43545() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill skill = skills.get(0);
        String originalDescription = skill.getDescription();
        assertEquals("Atos test: Swift development of iOS modified by test modified by test modified by test", originalDescription);
        skill.setDescription(((skill.getDescription()) + " modified by test"));
        skill = ReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        Assert.notNull(skill);
        skill.setDescription(originalDescription);
        skill = ReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
        assertEquals("Atos test: Swift development of iOS modified by test modified by test modified by test", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdnull43556_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(0);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = ReplanControllerProxyTest.proxy.updateSkillOfProjectById(null, ReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = ReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdnull43556 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_add42194() throws Exception {
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Resource resource = resources.get(0);
        String originalDescription = resource.getDescription();
        assertEquals("Atos test: Swift developer with experience on iOS 10 modified by test modified by test modified by test", originalDescription);
        resource.setDescription(((resource.getDescription()) + " modified by test"));
        resource.setDescription(((resource.getDescription()) + " modified by test"));
        resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource.setDescription(originalDescription);
        resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        assertEquals("Atos test: Swift developer with experience on iOS 10 modified by test modified by test modified by test", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdnull42235_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(0);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdnull42235_failAssert0_mg42449_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_skills_1100 = Collections.singletonList(new Skill());
                List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                Resource resource = resources.get(0);
                String originalDescription = resource.getDescription();
                resource.setDescription(((resource.getDescription()) + " modified by test"));
                resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, ReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.notNull(resource);
                resource.setDescription(originalDescription);
                resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235 should have thrown IllegalArgumentException");
                resource.setSkills(__DSPOT_skills_1100);
            }
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235_failAssert0_mg42449 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdnull42235_failAssert0_mg42449_failAssert0litNum43007_failAssert0() throws Exception {
        try {
            {
                {
                    List<Skill> __DSPOT_skills_1100 = Collections.singletonList(new Skill());
                    List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
                    Assert.notNull(resources);
                    Assert.notEmpty(resources);
                    Resource resource = resources.get(Integer.MIN_VALUE);
                    String originalDescription = resource.getDescription();
                    resource.setDescription(((resource.getDescription()) + " modified by test"));
                    resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, ReplanControllerProxyTest.projectId);
                    Assert.notNull(resource);
                    Assert.notNull(resource);
                    resource.setDescription(originalDescription);
                    resource = ReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
                    org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235 should have thrown IllegalArgumentException");
                    resource.setSkills(__DSPOT_skills_1100);
                }
                org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235_failAssert0_mg42449 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull42235_failAssert0_mg42449_failAssert0litNum43007 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_add11537() throws Exception {
        List<Skill> o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add11537__1 = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add11537__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);

        assertFalse(o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add11537__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber11555_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber11555 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber11560_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), ReplanControllerProxyTest.projectId);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber11560 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull11596_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull11596 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull11599_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull11599 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1() throws Exception {
        List<Feature> o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__8 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__8);
        Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__1.isEmpty());
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1__8);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__7 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__7);
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__9);
        Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__7);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add4__9);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_remove16_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_remove16 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber19_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(1));
            Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber19 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber29_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber29 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber19_failAssert0_mg456_failAssert0() throws Exception {
        try {
            {
                Date __DSPOT_deadline_29 = new Date("T&zgYc TM1`_8;0L`A=S");
                List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                dependencies.add(features.get(1));
                Feature feature = ReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                Assert.notNull(feature);
                feature = ReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber19 should have thrown ArrayIndexOutOfBoundsException");
                feature.setDeadline(__DSPOT_deadline_29);
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber19_failAssert0_mg456 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469() throws Exception {
        List<Resource> o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__1 = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__1.isEmpty());
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__12);
        Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__1.isEmpty());
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7469__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475() throws Exception {
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__11);
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__13 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__13);
        Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__11);
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add7475__13);
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_remove7489_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_remove7489 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber7492_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(1));
            Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber7492 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber7502_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber7502 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull7546_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = ReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull7546 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049() throws Exception {
        List<Feature> o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__12);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).toString());
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__17)).toString());
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__1.isEmpty());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__12);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2049__14)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__11);
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__13 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__13);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).toString());
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18)).toString());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__11);
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__13);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__11);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).toString());
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__17)).toString());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__11);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2070__14)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove2067_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove2067 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2068_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(1));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2068 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2072_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(40));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2072 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("40", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2078_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber2078 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum2100_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(-1804336248).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum2100 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1804336248", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull2119_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull2119 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055_add2432() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055_add2432__5 = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055_add2432__5.isEmpty());
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__11 = featuresToAdd.add(features.get(0));
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__13 = featuresToAdd.add(features.get(0));
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__15 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055__18 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add2055_add2432__5.isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove2067_failAssert0litNum2755_failAssert0() throws Exception {
        try {
            {
                List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
                ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), ReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove2067 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove2067_failAssert0litNum2755 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectById_add9749() throws Exception {
        Skill skill = new Skill();
        skill.setName("Atos test: Swift");
        skill.setName("Atos test: Swift");
        skill.setDescription("Atos Test: Swift development of iOS");
        skill = ReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        HttpStatus o_testAddDeleteSkillOfProjectById_add9749__9 = ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9749__9)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectById_add9753() throws Exception {
        Skill skill = new Skill();
        skill.setName("Atos test: Swift");
        skill.setDescription("Atos Test: Swift development of iOS");
        skill = ReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        HttpStatus o_testAddDeleteSkillOfProjectById_add9753__8 = ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).toString());
        HttpStatus o_testAddDeleteSkillOfProjectById_add9753__10 = ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest.projectId);
        assertNull(o_testAddDeleteSkillOfProjectById_add9753__10);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteSkillOfProjectById_add9753__8)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull9804_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = ReplanControllerProxyTest.proxy.addSkillOfProjectById(null, ReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull9804 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull9805_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = ReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            ReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull9805 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectById_add4927() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testAddDeleteResourceOfProjectById_add4927__10 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4927__10)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectById_add4932() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testAddDeleteResourceOfProjectById_add4932__9 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).toString());
        HttpStatus o_testAddDeleteResourceOfProjectById_add4932__11 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertNull(o_testAddDeleteResourceOfProjectById_add4932__11);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_add4932__9)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectById_mg4956() throws Exception {
        List<Skill> __DSPOT_skills_85 = Collections.singletonList(new Skill());
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testAddDeleteResourceOfProjectById_mg4956__12 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).toString());
        resource.setSkills(__DSPOT_skills_85);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956__12)).toString());
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdnull5012_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(null, ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdnull5012 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdnull5013_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdnull5013 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectById_mg4956_add5379() throws Exception {
        List<Skill> __DSPOT_skills_85 = Collections.singletonList(new Skill());
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testAddDeleteResourceOfProjectById_mg4956_add5379__12 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is3xxRedirection());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is4xxClientError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).toString());
        HttpStatus o_testAddDeleteResourceOfProjectById_mg4956__12 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        resource.setSkills(__DSPOT_skills_85);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is3xxRedirection());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is5xxServerError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is1xxInformational());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).is4xxClientError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectById_mg4956_add5379__12)).toString());
    }

    private <T extends ReplanIdentifiableObject> boolean containsId(List<T> collection, Integer id) {
        boolean result = false;
        for (T object : collection) {
            if ((object.getId()) == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_add13120() throws Exception {
        List<Skill> o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__1 = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__12);
        Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertFalse(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__1.isEmpty());
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13120__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_add13126() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__11);
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__13 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__13);
        Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__11);
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add13126__13);
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_remove13140_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_remove13140 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber13143_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(1));
            Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber13143 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber13153_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), ReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber13153 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add33842() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__16);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__18 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__18);
        feature = ReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), ReplanControllerProxyTest.projectId);
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__16);
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add33842__18);
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add22648() throws Exception {
        List<Feature> o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__12);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).toString());
        List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__27 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__27);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).toString());
        featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__1.isEmpty());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__12);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__14)).toString());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__27);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22648__29)).toString());
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add22665() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__11);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).toString());
        List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__26 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__26);
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__28 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__28);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).toString());
        featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__11);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13)).toString());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__26);
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__28);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30)).toString());
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676() throws Exception {
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__10 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__10);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).toString());
        List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__25 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__25);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).toString());
        featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__10);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__12)).toString());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__25);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectById_remove22676__27)).toString());
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_remove22683_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_remove22683 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber22701_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(1));
            ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber22701 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add22665_add23228() throws Exception {
        List<Feature> o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665_add23228__1 = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665_add23228__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest.proxy.getReleasesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__11 = featuresToAdd.add(features.get(0));
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__13 = ReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        List<Feature> featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__26 = featuresToDelete.add(features.get(0));
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__28 = featuresToDelete.add(features.get(0));
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665__30 = ReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        featuresOfRelease = ReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add22665_add23228__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectById_add27781() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testDeleteResourceOfProjectById_add27781__10 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).toString());
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.isTrue((!(containsId(resources, resource.getId()))));
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27781__10)).toString());
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectById_add27786() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testDeleteResourceOfProjectById_add27786__9 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).toString());
        HttpStatus o_testDeleteResourceOfProjectById_add27786__11 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertNull(o_testDeleteResourceOfProjectById_add27786__11);
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.isTrue((!(containsId(resources, resource.getId()))));
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_add27786__9)).toString());
        assertNull(o_testDeleteResourceOfProjectById_add27786__11);
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectById_mg27815() throws Exception {
        List<Skill> __DSPOT_skills_715 = Collections.singletonList(new Skill());
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testDeleteResourceOfProjectById_mg27815__12 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).toString());
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.isTrue((!(containsId(resources, resource.getId()))));
        resource.setSkills(__DSPOT_skills_715);
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectById_mg27815__12)).toString());
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectById_mg27815_add28247null29694_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_skills_715 = Collections.singletonList(new Skill());
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            HttpStatus o_testDeleteResourceOfProjectById_mg27815__12 = ReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest.projectId);
            List<Resource> o_testDeleteResourceOfProjectById_mg27815_add28247__16 = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(resources, resource.getId()))));
            resource.setSkills(__DSPOT_skills_715);
            org.junit.Assert.fail("testDeleteResourceOfProjectById_mg27815_add28247null29694 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_add18324() throws Exception {
        List<Skill> o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__1 = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        assertFalse(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__12);
        Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__21 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__21);
        int numberOfSkills = resource.getSkills().size();
        resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
        assertFalse(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__1.isEmpty());
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__12);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18324__21);
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_add18330() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__11);
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__13 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__13);
        Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__22 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__22);
        int numberOfSkills = resource.getSkills().size();
        resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), ReplanControllerProxyTest.projectId);
        Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__11);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__13);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18330__22);
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdnull18420_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest.proxy.getSkillsOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest.proxy.getResourcesOfProjectById(ReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = ReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = ReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(null, resource.getId(), ReplanControllerProxyTest.projectId);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdnull18420 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }
}

