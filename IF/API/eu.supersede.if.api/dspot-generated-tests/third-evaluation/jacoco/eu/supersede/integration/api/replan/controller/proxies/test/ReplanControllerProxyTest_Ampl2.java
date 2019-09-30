package eu.supersede.integration.api.replan.controller.proxies.test;


import eu.supersede.integration.api.replan.controller.proxies.IReplanController;
import eu.supersede.integration.api.replan.controller.proxies.ReplanControllerProxy;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.Job;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
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
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class ReplanControllerProxyTest_Ampl2 {
    private static final Logger log = LoggerFactory.getLogger(ReplanControllerProxyTest_Ampl2.class);

    private static IReplanController proxy;

    private static int projectId;

    private static int skillId;

    private static int resourceId;

    private static int featureId;

    private static int releaseId;

    @BeforeClass
    public static void setup() throws Exception {
        ReplanControllerProxyTest_Ampl2.proxy = new ReplanControllerProxy();
        Project project = ReplanControllerProxyTest_Ampl2.createProject();
        project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        ReplanControllerProxyTest_Ampl2.projectId = project.getId();
        Skill skill = new Skill();
        skill.setName("Atos test: Swift");
        skill.setDescription("Atos test: Swift development of iOS");
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource.getId());
        ReplanControllerProxyTest_Ampl2.resourceId = resource.getId();
        Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
        feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        ReplanControllerProxyTest_Ampl2.featureId = feature.getId();
        Release release = ReplanControllerProxyTest_Ampl2.createRelease();
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(releases);
        Assert.notNull(releases.get(0).getId());
        ReplanControllerProxyTest_Ampl2.releaseId = releases.get(0).getId();
        skill = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skill);
        ReplanControllerProxyTest_Ampl2.skillId = skill.getId();
    }

    @org.junit.AfterClass
    public static void cleanup() throws Exception {
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(ReplanControllerProxyTest_Ampl2.skillId, ReplanControllerProxyTest_Ampl2.projectId));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(ReplanControllerProxyTest_Ampl2.featureId, ReplanControllerProxyTest_Ampl2.projectId));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(ReplanControllerProxyTest_Ampl2.resourceId, ReplanControllerProxyTest_Ampl2.projectId));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteReleaseByIdOfProjectById(ReplanControllerProxyTest_Ampl2.releaseId, ReplanControllerProxyTest_Ampl2.projectId));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(ReplanControllerProxyTest_Ampl2.projectId));
    }

    @Test(timeout = 30000)
    public void testGetAllProjectsnull33524_failAssert0() throws Exception {
        try {
            List<Project> projects = ReplanControllerProxyTest_Ampl2.proxy.getAllProjects();
            Assert.notNull(null);
            Assert.notEmpty(projects);
            org.junit.Assert.fail("testGetAllProjectsnull33524 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetProjectByIdnull36179_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.proxy.getProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetProjectByIdnull36179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectById_add34322() throws Exception {
        List<Feature> o_testGetFeaturesOfProjectById_add34322__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testGetFeaturesOfProjectById_add34322__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add34322__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectById_add34325() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Feature> o_testGetFeaturesOfProjectById_add34325__5 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add34325__5.isEmpty());
        features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId, FeatureStatus.PENDING);
        assertFalse(o_testGetFeaturesOfProjectById_add34325__5.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectById_add33575() throws Exception {
        List<Feature> o_testGetFeatureByIdOfProjectById_add33575__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testGetFeatureByIdOfProjectById_add33575__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        assertFalse(o_testGetFeatureByIdOfProjectById_add33575__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectById_add33575_mg33728_failAssert0_mg33983_failAssert0() throws Exception {
        try {
            {
                List<Feature> __DSPOT_dependencies_948 = Collections.singletonList(new Feature());
                Date __DSPOT_deadline_924 = new Date("az^?,^T:Ja#K= Elh$32");
                List<Feature> o_testGetFeatureByIdOfProjectById_add33575__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(features);
                Feature feature = ReplanControllerProxyTest_Ampl2.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(feature);
                feature.setDeadline(__DSPOT_deadline_924);
                org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add33575_mg33728 should have thrown IllegalArgumentException");
                feature.setDependencies(__DSPOT_dependencies_948);
            }
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add33575_mg33728_failAssert0_mg33983 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectById_add33575_mg33728_failAssert0_mg33997_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_953 = Collections.singletonList(new Skill());
                Date __DSPOT_deadline_924 = new Date("az^?,^T:Ja#K= Elh$32");
                List<Feature> o_testGetFeatureByIdOfProjectById_add33575__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(features);
                Feature feature = ReplanControllerProxyTest_Ampl2.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(feature);
                feature.setDeadline(__DSPOT_deadline_924);
                org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add33575_mg33728 should have thrown IllegalArgumentException");
                feature.setRequiredSkills(__DSPOT_requiredSkills_953);
            }
            org.junit.Assert.fail("testGetFeatureByIdOfProjectById_add33575_mg33728_failAssert0_mg33997 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_add36261() throws Exception {
        List<Release> o_testGetReleaseByIdOfProjectById_add36261__1 = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testGetReleaseByIdOfProjectById_add36261__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(releases);
        Release release = ReplanControllerProxyTest_Ampl2.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(release);
        assertFalse(o_testGetReleaseByIdOfProjectById_add36261__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_add34687() throws Exception {
        List<Release> o_testGetFeaturesOfReleaseByIdOfProjectById_add34687__1 = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testGetFeaturesOfReleaseByIdOfProjectById_add34687__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(releases);
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        assertFalse(o_testGetFeaturesOfReleaseByIdOfProjectById_add34687__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber34695_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(releases);
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectById_literalMutationNumber34695 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectById_add35136() throws Exception {
        List<Release> o_testGetPlanOfReleaseByIdOfProjectById_add35136__1 = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testGetPlanOfReleaseByIdOfProjectById_add35136__1.isEmpty());
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(releases);
        Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(plan);
        assertFalse(o_testGetPlanOfReleaseByIdOfProjectById_add35136__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(releases);
            Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber35144_failAssert0_mg35307_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resourceUsage_970 = Collections.singletonList(new Resource());
                List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(releases);
                Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber35144 should have thrown ArrayIndexOutOfBoundsException");
                plan.setResourceUsage(__DSPOT_resourceUsage_970);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectById_literalMutationNumber35144_failAssert0_mg35307 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35281_failAssert0() throws Exception {
        try {
            {
                List<Job> __DSPOT_jobs_961 = Collections.singletonList(new Job());
                List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(releases);
                Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168 should have thrown IllegalArgumentException");
                plan.setJobs(__DSPOT_jobs_961);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35281 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35289_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resourceUsage_963 = Collections.singletonList(new Resource());
                List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(releases);
                Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168 should have thrown IllegalArgumentException");
                plan.setResourceUsage(__DSPOT_resourceUsage_963);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35289 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35281_failAssert0_literalMutationNumber35628_failAssert0() throws Exception {
        try {
            {
                {
                    List<Job> __DSPOT_jobs_961 = Collections.singletonList(new Job());
                    List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(40).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168 should have thrown IllegalArgumentException");
                    plan.setJobs(__DSPOT_jobs_961);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35281 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35281_failAssert0_literalMutationNumber35628 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("40", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35289_failAssert0_add35595_failAssert0() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resourceUsage_963 = Collections.singletonList(new Resource());
                    List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                    Assert.notEmpty(releases);
                    releases.get(0).getId();
                    Plan plan = ReplanControllerProxyTest_Ampl2.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168 should have thrown IllegalArgumentException");
                    plan.setResourceUsage(__DSPOT_resourceUsage_963);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35289 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull35168_failAssert0_mg35289_failAssert0_add35595 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add18038() throws Exception {
        Project o_testCreateAndDeleteProject_add18038__1 = ReplanControllerProxyTest_Ampl2.createProject();
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteProject_add18038__1)).getId());
        Project project = ReplanControllerProxyTest_Ampl2.createProject();
        project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteProject_add18038__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteProject_add18038__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteProject_add18038__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add18043_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteProject_add18043 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add18043_failAssert0_mg18145_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_606 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteProject_add18043 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_606);
            }
            org.junit.Assert.fail("testCreateAndDeleteProject_add18043_failAssert0_mg18145 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_add18038null18184_failAssert0_mg18424_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_620 = Collections.singletonList(new Resource());
                Project o_testCreateAndDeleteProject_add18038__1 = ReplanControllerProxyTest_Ampl2.createProject();
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteProject_add18038null18184 should have thrown IllegalArgumentException");
                o_testCreateAndDeleteProject_add18038__1.setResources(__DSPOT_resources_620);
            }
            org.junit.Assert.fail("testCreateAndDeleteProject_add18038null18184_failAssert0_mg18424 should have thrown IllegalArgumentException");
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
    public void testCreateAndDeleteFeatureForProject_add16143() throws Exception {
        Project o_testCreateAndDeleteFeatureForProject_add16143__1 = ReplanControllerProxyTest_Ampl2.createProject();
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getId());
        Project project = ReplanControllerProxyTest_Ampl2.createProject();
        project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
        feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
        assertEquals(40.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals("hour", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getEffortUnit());
        assertEquals(1.0, ((double) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getName());
        assertNull(((Project) (o_testCreateAndDeleteFeatureForProject_add16143__1)).getId());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16149_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16149 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16154_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16158_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16178_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16178 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16179_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16180_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(null, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16180 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16181_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
            feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(null);
            Assert.notNull(feature.getId());
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16181 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16178_failAssert0_mg16466_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_330 = Collections.singletonList(new Skill());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16178 should have thrown IllegalArgumentException");
                feature.setRequiredSkills(__DSPOT_requiredSkills_330);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16178_failAssert0_mg16466 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16487_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_348 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_348);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16487 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16154_failAssert0_mg16452_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_321 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_321);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154_failAssert0_mg16452 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16149_failAssert0_mg16470_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_334 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16149 should have thrown HttpClientErrorException");
                project.setResources(__DSPOT_resources_334);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16149_failAssert0_mg16470 should have thrown HttpClientErrorException");
        } catch (HttpClientErrorException expected) {
            assertEquals("400 Bad Request", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull16181_failAssert0_mg16491_failAssert0() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_354 = Collections.singletonList(new Resource());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(null);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16181 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_354);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull16181_failAssert0_mg16491 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16523_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_375 = Collections.singletonList(new Skill());
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158 should have thrown IllegalArgumentException");
                feature.setRequiredSkills(__DSPOT_requiredSkills_375);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16523 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16487_failAssert0null17624_failAssert0() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_348 = Collections.singletonList(new Resource());
                    Project project = ReplanControllerProxyTest_Ampl2.createProject();
                    project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                    feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
                    Assert.notNull(feature);
                    Assert.notNull(feature.getId());
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                    org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_348);
                }
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16487 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16158_failAssert0_mg16487_failAssert0null17624 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_add16154_failAssert0_mg16452_failAssert0null17632_failAssert0() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_321 = Collections.singletonList(new Resource());
                    Project project = ReplanControllerProxyTest_Ampl2.createProject();
                    project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                    Assert.notNull(project);
                    Assert.notNull(project.getId());
                    Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
                    feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(null, project.getId());
                    Assert.notNull(feature);
                    Assert.notNull(feature.getId());
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
                    Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                    org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_321);
                }
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154_failAssert0_mg16452 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_add16154_failAssert0_mg16452_failAssert0null17632 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
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
    public void testUpdateProject_add37159() throws Exception {
        Project o_testUpdateProject_add37159__1 = ReplanControllerProxyTest_Ampl2.createProject();
        assertEquals("hour", ((Project) (o_testUpdateProject_add37159__1)).getEffortUnit());
        assertEquals(40.0, ((double) (((Project) (o_testUpdateProject_add37159__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals(1.0, ((double) (((Project) (o_testUpdateProject_add37159__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testUpdateProject_add37159__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testUpdateProject_add37159__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testUpdateProject_add37159__1)).getName());
        assertNull(((Project) (o_testUpdateProject_add37159__1)).getId());
        Project project = ReplanControllerProxyTest_Ampl2.createProject();
        project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + " modified by test"));
        project = ReplanControllerProxyTest_Ampl2.proxy.updateProject(project);
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
        assertEquals("hour", ((Project) (o_testUpdateProject_add37159__1)).getEffortUnit());
        assertEquals(40.0, ((double) (((Project) (o_testUpdateProject_add37159__1)).getHoursPerWeekFullTimeResource())), 0.1);
        assertEquals(1.0, ((double) (((Project) (o_testUpdateProject_add37159__1)).getHoursPerEffortUnit())), 0.1);
        assertTrue(((Collection) (((Project) (o_testUpdateProject_add37159__1)).getResources())).isEmpty());
        assertEquals("Atos Project Test Description", ((Project) (o_testUpdateProject_add37159__1)).getDescription());
        assertEquals("Atos Project Test", ((Project) (o_testUpdateProject_add37159__1)).getName());
        assertNull(((Project) (o_testUpdateProject_add37159__1)).getId());
    }

    @Test(timeout = 30000)
    public void testUpdateProject_add37168_failAssert0() throws Exception {
        try {
            Project project = ReplanControllerProxyTest_Ampl2.createProject();
            project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + " modified by test"));
            project = ReplanControllerProxyTest_Ampl2.proxy.updateProject(project);
            Assert.notNull(project);
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
            org.junit.Assert.fail("testUpdateProject_add37168 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateProject_add37168_failAssert0null37384_failAssert0() throws Exception {
        try {
            {
                Project project = ReplanControllerProxyTest_Ampl2.createProject();
                project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + " modified by test"));
                project = ReplanControllerProxyTest_Ampl2.proxy.updateProject(project);
                Assert.notNull(null);
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
                org.junit.Assert.fail("testUpdateProject_add37168 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateProject_add37168_failAssert0null37384 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test
    public void testUpdateFeatureOfProjectById() throws Exception {
        Project project = ReplanControllerProxyTest_Ampl2.createProject();
        project = ReplanControllerProxyTest_Ampl2.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = ReplanControllerProxyTest_Ampl2.createFeature();
        feature = ReplanControllerProxyTest_Ampl2.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(project.getId());
        Assert.notEmpty(features);
        feature = ReplanControllerProxyTest_Ampl2.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), project.getId());
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        ReplanControllerProxyTest_Ampl2.proxy.updateFeatureOfProjectById(feature, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
        Assert.isTrue(ReplanControllerProxyTest_Ampl2.proxy.deleteProjectById(project.getId()));
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectById_remove38366() throws Exception {
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        String originalDescription = release.getDescription();
        assertEquals("Atos test release description", originalDescription);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release.setDescription(originalDescription);
        release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
        assertEquals("Atos test release description", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectById_mg38384() throws Exception {
        List<Resource> __DSPOT_resources_1113 = Collections.singletonList(new Resource());
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        Release release = releases.get(0);
        String originalDescription = release.getDescription();
        assertEquals("Atos test release description modified by test modified by test modified by test", originalDescription);
        release.setDescription(((release.getDescription()) + " modified by test"));
        release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release.setDescription(originalDescription);
        release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
        release.setResources(__DSPOT_resources_1113);
        assertEquals("Atos test release description modified by test modified by test modified by test", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull38401_failAssert0() throws Exception {
        try {
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release.setDescription(originalDescription);
            release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull38401 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectById_mg38384null38725_failAssert0() throws Exception {
        try {
            List<Resource> __DSPOT_resources_1113 = Collections.singletonList(new Resource());
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release.setDescription(originalDescription);
            release = ReplanControllerProxyTest_Ampl2.proxy.updateReleaseOfProjectById(release, ReplanControllerProxyTest_Ampl2.projectId);
            release.setResources(__DSPOT_resources_1113);
            org.junit.Assert.fail("testUpdateReleasesOfProjectById_mg38384null38725 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectById_add41235() throws Exception {
        List<Skill> o_testUpdateSkillsOfProjectById_add41235__1 = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testUpdateSkillsOfProjectById_add41235__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill skill = skills.get(0);
        String originalDescription = skill.getDescription();
        assertEquals("Atos test: Swift development of iOS", originalDescription);
        skill.setDescription(((skill.getDescription()) + " modified by test"));
        skill = ReplanControllerProxyTest_Ampl2.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skill);
        Assert.notNull(skill);
        skill.setDescription(originalDescription);
        skill = ReplanControllerProxyTest_Ampl2.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testUpdateSkillsOfProjectById_add41235__1.isEmpty());
        assertEquals("Atos test: Swift development of iOS", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdnull41279_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(0);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = ReplanControllerProxyTest_Ampl2.proxy.updateSkillOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skill);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = ReplanControllerProxyTest_Ampl2.proxy.updateSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdnull41279 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_add39985() throws Exception {
        List<Resource> o_testUpdateResourceOfProjectById_add39985__1 = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testUpdateResourceOfProjectById_add39985__1.isEmpty());
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Resource resource = resources.get(0);
        String originalDescription = resource.getDescription();
        assertEquals("Atos test: Swift developer with experience on iOS 10 modified by test modified by test modified by test", originalDescription);
        resource.setDescription(((resource.getDescription()) + " modified by test"));
        resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource.setDescription(originalDescription);
        resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testUpdateResourceOfProjectById_add39985__1.isEmpty());
        assertEquals("Atos test: Swift developer with experience on iOS 10 modified by test modified by test modified by test", originalDescription);
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdnull40031_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(0);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull40031 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_literalMutationNumber40003_failAssert0_mg40241_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_skills_1153 = Collections.singletonList(new Skill());
                List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                Resource resource = resources.get(1);
                String originalDescription = resource.getDescription();
                resource.setDescription(((resource.getDescription()) + " modified by test"));
                resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(resource);
                Assert.notNull(resource);
                resource.setDescription(originalDescription);
                resource = ReplanControllerProxyTest_Ampl2.proxy.updateResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
                org.junit.Assert.fail("testUpdateResourceOfProjectById_literalMutationNumber40003 should have thrown ArrayIndexOutOfBoundsException");
                resource.setSkills(__DSPOT_skills_1153);
            }
            org.junit.Assert.fail("testUpdateResourceOfProjectById_literalMutationNumber40003_failAssert0_mg40241 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_add12411() throws Exception {
        List<Skill> o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add12411__1 = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add12411__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteSkillsOfFeatureByIdOfProjectById_add12411__1.isEmpty());
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber12429_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber12429 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber12434_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectById_literalMutationNumber12434 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull12470_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull12470 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull12473_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notEmpty(features);
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull12473 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954() throws Exception {
        List<Feature> o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__8 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__8);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__1.isEmpty());
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1954__8);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__7 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__7);
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__9 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__9);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__7);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_add1957__9);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993() throws Exception {
        List<Skill> __DSPOT_requiredSkills_30 = Collections.singletonList(new Skill());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        feature.setRequiredSkills(__DSPOT_requiredSkills_30);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_remove1969_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_remove1969 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber1972_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(1));
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber1972 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber1982_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_literalMutationNumber1982 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_add2252() throws Exception {
        List<Skill> __DSPOT_requiredSkills_30 = Collections.singletonList(new Skill());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_add2252__10 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_add2252__10);
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10 = dependencies.add(features.get(0));
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        feature.setRequiredSkills(__DSPOT_requiredSkills_30);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_add2252__10);
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_literalMutationNumber2407_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_requiredSkills_30 = Collections.singletonList(new Skill());
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10 = dependencies.add(features.get(0));
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(40).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            feature.setRequiredSkills(__DSPOT_requiredSkills_30);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_literalMutationNumber2407 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("40", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993litNum2530_failAssert0() throws Exception {
        try {
            List<Skill> __DSPOT_requiredSkills_30 = Collections.singletonList(new Skill());
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10 = dependencies.add(features.get(0));
            Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(Integer.MIN_VALUE).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(feature);
            Assert.notNull(feature);
            feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            feature.setRequiredSkills(__DSPOT_requiredSkills_30);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993litNum2530 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_literalMutationNumber2407_failAssert0null3698_failAssert0() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_30 = Collections.singletonList(new Skill());
                List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993__10 = dependencies.add(features.get(0));
                Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(feature);
                Assert.notNull(feature);
                feature = ReplanControllerProxyTest_Ampl2.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(40).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                feature.setRequiredSkills(__DSPOT_requiredSkills_30);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_literalMutationNumber2407 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectById_mg1993_literalMutationNumber2407_failAssert0null3698 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629() throws Exception {
        List<Resource> o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__1 = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__1.isEmpty());
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__12 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__12);
        Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__1.isEmpty());
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8629__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635() throws Exception {
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__11);
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__13 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__13);
        Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(release);
        Assert.notNull(release);
        release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__11);
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__13);
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_remove8649_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_remove8649 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber8652_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(1));
            Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber8652 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber8662_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_literalMutationNumber8662 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull8706_failAssert0() throws Exception {
        try {
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull8706 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635_mg9165_failAssert0() throws Exception {
        try {
            Date __DSPOT_startsAt_164 = new Date("Hasgx%sgVPn5_N]Rma)Z");
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__11 = resourcesToAdd.add(resources.get(0));
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635__13 = resourcesToAdd.add(resources.get(0));
            Release release = ReplanControllerProxyTest_Ampl2.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(release);
            Assert.notNull(release);
            release = ReplanControllerProxyTest_Ampl2.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            release.setStartsAt(__DSPOT_startsAt_164);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectById_add8635_mg9165 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266() throws Exception {
        List<Feature> o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__12);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__1.isEmpty());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4266__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4267() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4267__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4267__12);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4267__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__11);
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__13 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__13);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__11);
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__13);
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove4286_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_remove4286 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4289_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(1));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4289 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4293_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(40));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4293 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("40", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4299_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber4299 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum4318_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum4318 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull4340_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull4340 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull4344_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull4344 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272_add4646() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__11 = featuresToAdd.add(features.get(0));
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272_add4646__15 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272_add4646__15);
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272__13 = featuresToAdd.add(features.get(0));
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectById_add4272_add4646__15);
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectById_add10815() throws Exception {
        Skill skill = new Skill();
        skill.setName("Atos test: Swift");
        skill.setDescription("Atos Test: Swift development of iOS");
        Skill o_testAddDeleteSkillOfProjectById_add10815__5 = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
        assertEquals("Atos Test: Swift development of iOS", ((Skill) (o_testAddDeleteSkillOfProjectById_add10815__5)).getDescription());
        assertEquals("Atos test: Swift", ((Skill) (o_testAddDeleteSkillOfProjectById_add10815__5)).getName());
        skill = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skill);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        assertEquals("Atos Test: Swift development of iOS", ((Skill) (o_testAddDeleteSkillOfProjectById_add10815__5)).getDescription());
        assertEquals("Atos test: Swift", ((Skill) (o_testAddDeleteSkillOfProjectById_add10815__5)).getName());
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectById_add10817_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skill);
            ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectById_add10817 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull10870_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skill);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull10870 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull10871_failAssert0() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfProjectById(skill, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillByIdOfProjectById(skill.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull10871 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_add14036() throws Exception {
        List<Skill> o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__1 = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__12);
        Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__1.isEmpty());
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14036__12);
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_add14042() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__11);
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__13 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__13);
        Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__11);
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectById_add14042__13);
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_remove14056_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_remove14056 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber14059_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(1));
            Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber14059 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber14069_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectById_literalMutationNumber14069 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectById_add31592() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notEmpty(features);
        Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(feature);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__16);
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__18 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__18);
        feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__16);
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectById_add31592__18);
    }

    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdnull31644_failAssert0_mg31979_failAssert0() throws Exception {
        try {
            {
                List<Feature> __DSPOT_dependencies_835 = Collections.singletonList(new Feature());
                List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notEmpty(features);
                Feature feature = ReplanControllerProxyTest_Ampl2.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
                Assert.notNull(feature);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                skillsToDelete.add(skills.get(0));
                feature = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), ReplanControllerProxyTest_Ampl2.projectId);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull31644 should have thrown IllegalArgumentException");
                feature.setDependencies(__DSPOT_dependencies_835);
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull31644_failAssert0_mg31979 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add23323() throws Exception {
        List<Feature> o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__1 = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__1.isEmpty());
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__12);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__29 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__29);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__1.isEmpty());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__12);
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23323__29);
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add23324() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__12 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__12);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__29 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__29);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__12);
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23324__29);
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add23341() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__11);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__28 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__28);
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__30 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__30);
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__11);
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__28);
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__30);
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_remove23361_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_remove23361 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber23386_failAssert0() throws Exception {
        try {
            List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notNull(features);
            Assert.notEmpty(features);
            Assert.notEmpty(features);
            List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            Assert.isTrue(result);
            List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(-1).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectById_literalMutationNumber23386 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectById_add23341_add23886() throws Exception {
        List<Feature> features = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notNull(features);
        Assert.notEmpty(features);
        Assert.notEmpty(features);
        List<Release> o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341_add23886__5 = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341_add23886__5.isEmpty());
        List<Release> releases = ReplanControllerProxyTest_Ampl2.proxy.getReleasesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__11 = featuresToAdd.add(features.get(0));
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        Assert.isTrue(result);
        List<Feature> featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__28 = featuresToDelete.add(features.get(0));
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341__30 = featuresToDelete.add(features.get(0));
        result = ReplanControllerProxyTest_Ampl2.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        featuresOfRelease = ReplanControllerProxyTest_Ampl2.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertFalse(o_testDeleteFeaturesOfReleaseByIdOfProjectById_add23341_add23886__5.isEmpty());
    }

    @Test(timeout = 30000)
    public void tesDeleteResourceOfProjectById_add4() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift Developer");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        Resource o_tesDeleteResourceOfProjectById_add4__6 = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
        assertTrue(((Collection) (((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getSkills())).isEmpty());
        assertEquals(80.0, ((double) (((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getAvailability())), 0.1);
        assertEquals("Atos test: Swift developer with experience on iOS 10", ((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getDescription());
        assertEquals("Atos test: Swift Developer", ((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getName());
        resource = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(result);
        assertTrue(((Collection) (((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getSkills())).isEmpty());
        assertEquals(80.0, ((double) (((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getAvailability())), 0.1);
        assertEquals("Atos test: Swift developer with experience on iOS 10", ((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getDescription());
        assertEquals("Atos test: Swift Developer", ((Resource) (o_tesDeleteResourceOfProjectById_add4__6)).getName());
    }

    @Test(timeout = 30000)
    public void tesDeleteResourceOfProjectById_add6_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("tesDeleteResourceOfProjectById_add6 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void tesDeleteResourceOfProjectByIdnull88_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(null, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("tesDeleteResourceOfProjectByIdnull88 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void tesDeleteResourceOfProjectByIdnull89_failAssert0() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = ReplanControllerProxyTest_Ampl2.proxy.addResourceOfProjectById(resource, ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(null);
            boolean result = ReplanControllerProxyTest_Ampl2.proxy.deleteResourceByIdOfProjectById(resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(result);
            org.junit.Assert.fail("tesDeleteResourceOfProjectByIdnull89 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_add18798() throws Exception {
        List<Skill> o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__1 = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        assertFalse(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__1.isEmpty());
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__12 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__12);
        Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__21 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__21);
        int numberOfSkills = resource.getSkills().size();
        resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
        assertFalse(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__1.isEmpty());
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__12);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18798__21);
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectById_add18804() throws Exception {
        List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__11);
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__13 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__13);
        Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.notNull(resource);
        Assert.notNull(resource);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__22 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__22);
        int numberOfSkills = resource.getSkills().size();
        resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
        Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__11);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__13);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectById_add18804__22);
    }

    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdnull18894_failAssert0() throws Exception {
        try {
            List<Skill> skills = ReplanControllerProxyTest_Ampl2.proxy.getSkillsOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = ReplanControllerProxyTest_Ampl2.proxy.getResourcesOfProjectById(ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = ReplanControllerProxyTest_Ampl2.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.notNull(resource);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = ReplanControllerProxyTest_Ampl2.proxy.deleteSkillsOfResourceByIdOfProjectById(null, resource.getId(), ReplanControllerProxyTest_Ampl2.projectId);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdnull18894 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }
}

