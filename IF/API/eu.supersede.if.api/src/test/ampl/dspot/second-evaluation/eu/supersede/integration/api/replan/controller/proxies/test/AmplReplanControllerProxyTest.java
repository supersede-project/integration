package eu.supersede.integration.api.replan.controller.proxies.test;


import eu.supersede.integration.api.replan.controller.proxies.IReplanController;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.Job;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.ReplanIdentifiableObject;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AmplReplanControllerProxyTest {
    private static final Logger log = LoggerFactory.getLogger(AmplReplanControllerProxyTest.class);

    private static IReplanController proxy;

    private static int projectId;

    private static int skillId;

    private static int resourceId;

    private static int featureId;

    private static int releaseId;

    @Ignore
    @Test(timeout = 30000)
    public void testGetAllProjectsnull12480_failAssert3117() throws Exception {
        try {
            List<Project> projects = AmplReplanControllerProxyTest.proxy.getAllProjects();
            Assert.notNull(null);
            Assert.notEmpty(projects);
            org.junit.Assert.fail("testGetAllProjectsnull12480 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetProjectByIdnull13002_failAssert3216() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.proxy.getProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetProjectByIdnull13002 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetProjectByIdnull13002_failAssert3216_mg13017_failAssert3217() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_753 = "A_paq1]6^Tc.QTdw$*mg";
                Project project = AmplReplanControllerProxyTest.proxy.getProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetProjectByIdnull13002 should have thrown IllegalArgumentException");
                project.setEffortUnit(__DSPOT_effortUnit_753);
            }
            org.junit.Assert.fail("testGetProjectByIdnull13002_failAssert3216_mg13017 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetProjectByIdnull13002_failAssert3216_mg13017_failAssert3217litString13029_failAssert3221() throws Exception {
        try {
            {
                {
                    String __DSPOT_effortUnit_753 = "Atos Test: Swift developer with experience on iOS 10";
                    Project project = AmplReplanControllerProxyTest.proxy.getProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetProjectByIdnull13002 should have thrown IllegalArgumentException");
                    project.setEffortUnit(__DSPOT_effortUnit_753);
                }
                org.junit.Assert.fail("testGetProjectByIdnull13002_failAssert3216_mg13017 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetProjectByIdnull13002_failAssert3216_mg13017_failAssert3217litString13029 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectByIdnull12647_failAssert3148() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
            Assert.notNull(features);
            Assert.notEmpty(features);
            org.junit.Assert.fail("testGetFeaturesOfProjectByIdnull12647 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectByIdnull12649_failAssert3149() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
            Assert.notNull(null);
            Assert.notEmpty(features);
            org.junit.Assert.fail("testGetFeaturesOfProjectByIdnull12649 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfProjectByIdnull12647_failAssert3148null12659_failAssert3150() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(features);
                features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId, FeatureStatus.PENDING);
                Assert.notNull(null);
                Assert.notEmpty(features);
                org.junit.Assert.fail("testGetFeaturesOfProjectByIdnull12647 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetFeaturesOfProjectByIdnull12647_failAssert3148null12659 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectByIdnull12501_failAssert3123() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdnull12501 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118_mg12541_failAssert3124() throws Exception {
        try {
            {
                Integer __DSPOT_code_674 = -610563678;
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487 should have thrown ArrayIndexOutOfBoundsException");
                feature.setCode(__DSPOT_code_674);
            }
            org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118_mg12541 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectByIdnull12501_failAssert3123litNum12544_failAssert3136() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdnull12501 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdnull12501_failAssert3123litNum12544 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118_mg12541_failAssert3124null12620_failAssert3145() throws Exception {
        try {
            {
                {
                    Integer __DSPOT_code_674 = null;
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487 should have thrown ArrayIndexOutOfBoundsException");
                    feature.setCode(__DSPOT_code_674);
                }
                org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118_mg12541 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetFeatureByIdOfProjectByIdlitNum12487_failAssert3118_mg12541_failAssert3124null12620 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleasesOfProjectByIdnull13300_failAssert3290() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(releases);
            org.junit.Assert.fail("testGetReleasesOfProjectByIdnull13300 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_mg13073_failAssert3236() throws Exception {
        try {
            Date __DSPOT_deadline_761 = new Date("W&j=|H&S:leb1;bIVLt3");
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release.setDeadline(__DSPOT_deadline_761);
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }


    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdnull13077_failAssert3238() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13104_failAssert3239() throws Exception {
        try {
            {
                Date __DSPOT_deadline_764 = new Date(1115136137, 941142490, -533569656);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(__DSPOT_deadline_764);
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13104 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13112_failAssert3240() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_765 = Collections.singletonList(new Resource());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067 should have thrown ArrayIndexOutOfBoundsException");
                release.setResources(__DSPOT_resources_765);
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13112 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_mg13073_failAssert3236litString13101_failAssert3243() throws Exception {
        try {
            {
                Date __DSPOT_deadline_761 = new Date("Atos Test: Swift development of iOS");
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDeadline(__DSPOT_deadline_761);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073_failAssert3236litString13101 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdnull13077_failAssert3238litNum13114_failAssert3266() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077_failAssert3238litNum13114 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdnull13077_failAssert3238_mg13125_failAssert3269() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_768 = Collections.singletonList(new Resource());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077 should have thrown IllegalArgumentException");
                release.setResources(__DSPOT_resources_768);
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077_failAssert3238_mg13125 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13104_failAssert3239null13231_failAssert3271() throws Exception {
        try {
            {
                {
                    Date __DSPOT_deadline_764 = new Date(1115136137, 941142490, -533569656);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067 should have thrown ArrayIndexOutOfBoundsException");
                    release.setDeadline(__DSPOT_deadline_764);
                }
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13104 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13104_failAssert3239null13231 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13112_failAssert3240null13233_failAssert3273() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_765 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067 should have thrown ArrayIndexOutOfBoundsException");
                    release.setResources(__DSPOT_resources_765);
                }
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13112 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdlitNum13067_failAssert3231_mg13112_failAssert3240null13233 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectById_mg13073_failAssert3236litString13101_failAssert3243litNum13206_failAssert3275() throws Exception {
        try {
            {
                {
                    Date __DSPOT_deadline_761 = new Date("Atos Test: Swift development of iOS");
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    release.setDeadline(__DSPOT_deadline_761);
                    org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073_failAssert3236litString13101 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectById_mg13073_failAssert3236litString13101_failAssert3243litNum13206 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetReleaseByIdOfProjectByIdnull13077_failAssert3238_mg13125_failAssert3269litNum13215_failAssert3287() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_768 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Release release = AmplReplanControllerProxyTest.proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077 should have thrown IllegalArgumentException");
                    release.setResources(__DSPOT_resources_768);
                }
                org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077_failAssert3238_mg13125 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetReleaseByIdOfProjectByIdnull13077_failAssert3238_mg13125_failAssert3269litNum13215 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectByIdlitNum12675_failAssert3152() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdlitNum12675 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectByIdnull12682_failAssert3157() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdnull12682 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectByIdlitNum12675_failAssert3152null12704_failAssert3158() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdlitNum12675 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdlitNum12675_failAssert3152null12704 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetFeaturesOfReleaseByIdOfProjectByIdnull12682_failAssert3157litNum12705_failAssert3163() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdnull12682 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetFeaturesOfReleaseByIdOfProjectByIdnull12682_failAssert3157litNum12705 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(plan);
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(releases);
            Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
 
    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12777_failAssert3171() throws Exception {
        try {
            {
                Date __DSPOT_creationDate_702 = new Date(-925352950, -1585112445, -1177372626, -1145321272, -725103276);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                plan.setCreationDate(__DSPOT_creationDate_702);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12777 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12781_failAssert3172() throws Exception {
        try {
            {
                List<Job> __DSPOT_jobs_703 = Collections.singletonList(new Job());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                plan.setJobs(__DSPOT_jobs_703);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12781 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12788_failAssert3174() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resourceUsage_708 = Collections.singletonList(new Resource());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(plan);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                plan.setResourceUsage(__DSPOT_resourceUsage_708);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12788 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170litNum12782_failAssert3182() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170litNum12782 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12784_failAssert3184() throws Exception {
        try {
            {
                Date __DSPOT_creationDate_704 = new Date(-1121624603L);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
                plan.setCreationDate(__DSPOT_creationDate_704);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12784 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785_failAssert3185() throws Exception {
        try {
            {
                List<Job> __DSPOT_jobs_705 = Collections.singletonList(new Job());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(releases);
                Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
                plan.setJobs(__DSPOT_jobs_705);
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12777_failAssert3171null12878_failAssert3190() throws Exception {
        try {
            {
                {
                    Date __DSPOT_creationDate_702 = new Date(-925352950, -1585112445, -1177372626, -1145321272, -725103276);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                    plan.setCreationDate(__DSPOT_creationDate_702);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12777 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12777_failAssert3171null12878 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12781_failAssert3172null12888_failAssert3192() throws Exception {
        try {
            {
                {
                    List<Job> __DSPOT_jobs_703 = Collections.singletonList(new Job());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                    plan.setJobs(__DSPOT_jobs_703);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12781 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12781_failAssert3172null12888 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12788_failAssert3174null12896_failAssert3194() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resourceUsage_708 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728 should have thrown ArrayIndexOutOfBoundsException");
                    plan.setResourceUsage(__DSPOT_resourceUsage_708);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12788 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdlitNum12728_failAssert3165_mg12788_failAssert3174null12896 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12784_failAssert3184litNum12852_failAssert3196() throws Exception {
        try {
            {
                {
                    Date __DSPOT_creationDate_704 = new Date(-1121624602L);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
                    plan.setCreationDate(__DSPOT_creationDate_704);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12784 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12784_failAssert3184litNum12852 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785_failAssert3185litNum12854_failAssert3213() throws Exception {
        try {
            {
                {
                    List<Job> __DSPOT_jobs_705 = Collections.singletonList(new Job());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
                    plan.setJobs(__DSPOT_jobs_705);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785_failAssert3185litNum12854 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785_failAssert3185null12901_failAssert3215() throws Exception {
        try {
            {
                {
                    List<Job> __DSPOT_jobs_705 = Collections.singletonList(new Job());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(releases);
                    Plan plan = AmplReplanControllerProxyTest.proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741 should have thrown IllegalArgumentException");
                    plan.setJobs(null);
                }
                org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testGetPlanOfReleaseByIdOfProjectByIdnull12741_failAssert3170_mg12785_failAssert3185null12901 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetSkillsOfProjectByIdnull13314_failAssert3292() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            org.junit.Assert.fail("testGetSkillsOfProjectByIdnull13314 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testGetResourcesOfProjectByIdnull13307_failAssert3291() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            org.junit.Assert.fail("testGetResourcesOfProjectByIdnull13307 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
 
    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_mg6010() throws Exception {
        String __DSPOT_effortUnit_405 = "7yoEh?_F)3VJg?!KP(j8";
        Project project = AmplReplanControllerProxyTest.createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        HttpStatus o_testCreateAndDeleteProject_mg6010__9 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).toString());
        project.setEffortUnit(__DSPOT_effortUnit_405);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteProject_mg6010__9)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6014_failAssert1528() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6014 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6015_failAssert1529() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6015 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
    
    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_mg6010null6074_failAssert1530() throws Exception {
        try {
            String __DSPOT_effortUnit_405 = "7yoEh?_F)3VJg?!KP(j8";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            HttpStatus o_testCreateAndDeleteProject_mg6010__9 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_405);
            org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6074 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_mg6010null6075_failAssert1531() throws Exception {
        try {
            String __DSPOT_effortUnit_405 = "7yoEh?_F)3VJg?!KP(j8";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            HttpStatus o_testCreateAndDeleteProject_mg6010__9 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_405);
            org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6075 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6014_failAssert1528_mg6044_failAssert1535() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_416 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteProjectnull6014 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_416);
            }
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6014_failAssert1528_mg6044 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6015_failAssert1529_mg6040_failAssert1549() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_414 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteProjectnull6015 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_414);
            }
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6015_failAssert1529_mg6040 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_mg6010null6074_failAssert1530litString6181_failAssert1560() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_405 = " modified by test";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                HttpStatus o_testCreateAndDeleteProject_mg6010__9 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(__DSPOT_effortUnit_405);
                org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6074 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6074_failAssert1530litString6181 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProject_mg6010null6075_failAssert1531litString6179_failAssert1575() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_405 = "Bla, bla, bla es mucho decir";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                HttpStatus o_testCreateAndDeleteProject_mg6010__9 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(__DSPOT_effortUnit_405);
                org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6075 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteProject_mg6010null6075_failAssert1531litString6179 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6014_failAssert1528_mg6044_failAssert1535null6239_failAssert1590() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_416 = Collections.singletonList(new Resource());
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(null);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testCreateAndDeleteProjectnull6014 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_416);
                }
                org.junit.Assert.fail("testCreateAndDeleteProjectnull6014_failAssert1528_mg6044 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6014_failAssert1528_mg6044_failAssert1535null6239 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteProjectnull6015_failAssert1529_mg6040_failAssert1549null6233_failAssert1593() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_414 = Collections.singletonList(new Resource());
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(project);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testCreateAndDeleteProjectnull6015 should have thrown IllegalArgumentException");
                    project.setResources(null);
                }
                org.junit.Assert.fail("testCreateAndDeleteProjectnull6015_failAssert1529_mg6040 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteProjectnull6015_failAssert1529_mg6040_failAssert1549null6233 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
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

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724() throws Exception {
        String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
        Project project = AmplReplanControllerProxyTest.createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = AmplReplanControllerProxyTest.createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).toString());
        HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).toString());
        project.setEffortUnit(__DSPOT_effortUnit_220);
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__17)).toString());
        assertEquals("OK", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testCreateAndDeleteFeatureForProject_mg4724__20)).toString());
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269() throws Exception {
        try {
            Date __DSPOT_deadline_225 = new Date("I]?$AOD{_@e,R]r3_{}V");
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            feature.setDeadline(__DSPOT_deadline_225);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4735_failAssert1270() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4735 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4736_failAssert1271() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4736 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4737_failAssert1272() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4737 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4738_failAssert1273() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(null);
            Assert.notNull(feature.getId());
            AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4738 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4971_failAssert1274() throws Exception {
        try {
            String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_220);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4971 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4974_failAssert1275() throws Exception {
        try {
            String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_220);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4974 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4976_failAssert1276() throws Exception {
        try {
            String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
            Assert.notNull(feature);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_220);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4976 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4977_failAssert1277() throws Exception {
        try {
            String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            Feature feature = AmplReplanControllerProxyTest.createFeature();
            feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
            Assert.notNull(null);
            Assert.notNull(feature.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
            HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            project.setEffortUnit(__DSPOT_effortUnit_220);
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4977 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269litString4779_failAssert1278() throws Exception {
        try {
            {
                Date __DSPOT_deadline_225 = new Date("Atos test: Swift");
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                feature.setDeadline(__DSPOT_deadline_225);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269litString4779 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4828_failAssert1289() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_265 = Collections.singletonList(new Resource());
                Date __DSPOT_deadline_225 = new Date("I]?$AOD{_@e,R]r3_{}V");
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                feature.setDeadline(__DSPOT_deadline_225);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_265);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4828 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4847_failAssert1292() throws Exception {
        try {
            {
                List<Feature> __DSPOT_dependencies_283 = Collections.singletonList(new Feature());
                Date __DSPOT_deadline_225 = new Date("I]?$AOD{_@e,R]r3_{}V");
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                feature.setDeadline(__DSPOT_deadline_225);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
                feature.setDependencies(__DSPOT_dependencies_283);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4847 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4875_failAssert1296() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_289 = Collections.singletonList(new Skill());
                Date __DSPOT_deadline_225 = new Date("I]?$AOD{_@e,R]r3_{}V");
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                feature.setDeadline(__DSPOT_deadline_225);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
                feature.setRequiredSkills(__DSPOT_requiredSkills_289);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269_mg4875 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4735_failAssert1270_mg4804_failAssert1323() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_246 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4735 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_246);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4735_failAssert1270_mg4804 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProjectnull4737_failAssert1272_mg4803_failAssert1387() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_245 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4737 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_245);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProjectnull4737_failAssert1272_mg4803 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4971_failAssert1274null5581_failAssert1448() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(null);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4971 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4971_failAssert1274null5581 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4976_failAssert1276null5623_failAssert1449() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(null);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4976 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4976_failAssert1276null5623 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid feature", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4729_failAssert1269litString4779_failAssert1278null5719_failAssert1450() throws Exception {
        try {
            {
                {
                    Date __DSPOT_deadline_225 = new Date("Atos test: Swift");
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(project);
                    Assert.notNull(project);
                    Assert.notNull(project.getId());
                    Feature feature = AmplReplanControllerProxyTest.createFeature();
                    feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                    Assert.notNull(feature);
                    Assert.notNull(feature.getId());
                    AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    feature.setDeadline(null);
                    org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269litString4779 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4729_failAssert1269litString4779_failAssert1278null5719 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4976_failAssert1276null5612_failAssert1464() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(null, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(__DSPOT_effortUnit_220);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4976 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4976_failAssert1276null5612 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4977_failAssert1277null5629_failAssert1480() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(null);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(null);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4977 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4977_failAssert1277null5629 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4977_failAssert1277_mg5504_failAssert1522() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_349 = Collections.singletonList(new Resource());
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(null);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(__DSPOT_effortUnit_220);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4977 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_349);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4977_failAssert1277_mg5504 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testCreateAndDeleteFeatureForProject_mg4724null4974_failAssert1275_mg5492_failAssert1523() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_337 = Collections.singletonList(new Resource());
                String __DSPOT_effortUnit_220 = "{5uN(!P:(01(Vo/][%sG";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                Feature feature = AmplReplanControllerProxyTest.createFeature();
                feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
                Assert.notNull(feature);
                Assert.notNull(feature.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__17 = AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId());
                HttpStatus o_testCreateAndDeleteFeatureForProject_mg4724__20 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                project.setEffortUnit(__DSPOT_effortUnit_220);
                org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4974 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_337);
            }
            org.junit.Assert.fail("testCreateAndDeleteFeatureForProject_mg4724null4974_failAssert1275_mg5492 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
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
   
    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321() throws Exception {
        Project project = AmplReplanControllerProxyTest.createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
        project = AmplReplanControllerProxyTest.proxy.updateProject(project);
        Assert.notNull(project);
        HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
        assertEquals("OK", ((HttpStatus) (o_testUpdateProjectlitString13321__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testUpdateProjectlitString13321__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testUpdateProjectlitString13321__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testUpdateProjectlitString13321__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testUpdateProjectlitString13321__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testUpdateProjectlitString13321__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testUpdateProjectlitString13321__13)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13333_failAssert3293() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + " modified by test"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(project);
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectnull13333 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13334_failAssert3294() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + " modified by test"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(project);
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectnull13334 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13337_failAssert3296() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + " modified by test"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(null);
            AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectnull13337 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13413_failAssert3297() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(null);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(project);
            HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectlitString13321null13413 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13416_failAssert3298() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(null);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(project);
            HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectlitString13321null13416 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13423_failAssert3300() throws Exception {
        try {
            Project project = AmplReplanControllerProxyTest.createProject();
            project = AmplReplanControllerProxyTest.proxy.createProject(project);
            Assert.notNull(project);
            Assert.notNull(project.getId());
            project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
            project = AmplReplanControllerProxyTest.proxy.updateProject(project);
            Assert.notNull(null);
            HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
            org.junit.Assert.fail("testUpdateProjectlitString13321null13423 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13334_failAssert3294_mg13427_failAssert3337() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_802 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + " modified by test"));
                project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                Assert.notNull(project);
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testUpdateProjectnull13334 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_802);
            }
            org.junit.Assert.fail("testUpdateProjectnull13334_failAssert3294_mg13427 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13337_failAssert3296_mg13427_failAssert3362() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_802 = Collections.singletonList(new Resource());
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + " modified by test"));
                project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                Assert.notNull(null);
                AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testUpdateProjectnull13337 should have thrown IllegalArgumentException");
                project.setResources(__DSPOT_resources_802);
            }
            org.junit.Assert.fail("testUpdateProjectnull13337_failAssert3296_mg13427 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13413_failAssert3297_mg13651_failAssert3376() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_808 = "SN*sw)`v}zN/0NJ?w/&c";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(null);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
                project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                Assert.notNull(project);
                HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testUpdateProjectlitString13321null13413 should have thrown IllegalArgumentException");
                project.setEffortUnit(__DSPOT_effortUnit_808);
            }
            org.junit.Assert.fail("testUpdateProjectlitString13321null13413_failAssert3297_mg13651 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13416_failAssert3298_mg13646_failAssert3384() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_805 = "Bd%$(Yc4+914v7{bG0ev";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(null);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
                project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                Assert.notNull(project);
                HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testUpdateProjectlitString13321null13416 should have thrown IllegalArgumentException");
                project.setEffortUnit(__DSPOT_effortUnit_805);
            }
            org.junit.Assert.fail("testUpdateProjectlitString13321null13416_failAssert3298_mg13646 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectlitString13321null13423_failAssert3300_mg13645_failAssert3392() throws Exception {
        try {
            {
                String __DSPOT_effortUnit_804 = "BXWZ9Li]$FA^|2]&v3A9";
                Project project = AmplReplanControllerProxyTest.createProject();
                project = AmplReplanControllerProxyTest.proxy.createProject(project);
                Assert.notNull(project);
                Assert.notNull(project.getId());
                project.setDescription(((project.getDescription()) + "Atos Project Test Description"));
                project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                Assert.notNull(null);
                HttpStatus o_testUpdateProjectlitString13321__13 = AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                org.junit.Assert.fail("testUpdateProjectlitString13321null13423 should have thrown IllegalArgumentException");
                project.setEffortUnit(__DSPOT_effortUnit_804);
            }
            org.junit.Assert.fail("testUpdateProjectlitString13321null13423_failAssert3300_mg13645 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13334_failAssert3294_mg13427_failAssert3337litString13648_failAssert3400() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_802 = Collections.singletonList(new Resource());
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(project);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    project.setDescription(((project.getDescription()) + "Atos test: Swift development of iOS"));
                    project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                    Assert.notNull(project);
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testUpdateProjectnull13334 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_802);
                }
                org.junit.Assert.fail("testUpdateProjectnull13334_failAssert3294_mg13427 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateProjectnull13334_failAssert3294_mg13427_failAssert3337litString13648 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13334_failAssert3294_mg13427_failAssert3337null13717_failAssert3408() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_802 = Collections.singletonList(new Resource());
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(null);
                    Assert.notNull(null);
                    Assert.notNull(project.getId());
                    project.setDescription(((project.getDescription()) + " modified by test"));
                    project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                    Assert.notNull(project);
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testUpdateProjectnull13334 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_802);
                }
                org.junit.Assert.fail("testUpdateProjectnull13334_failAssert3294_mg13427 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateProjectnull13334_failAssert3294_mg13427_failAssert3337null13717 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid project", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateProjectnull13337_failAssert3296_mg13427_failAssert3362litString13644_failAssert3413() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_802 = Collections.singletonList(new Resource());
                    Project project = AmplReplanControllerProxyTest.createProject();
                    project = AmplReplanControllerProxyTest.proxy.createProject(project);
                    Assert.notNull(project);
                    Assert.notNull(project.getId());
                    project.setDescription(((project.getDescription()) + "Atos test: Swift Developer"));
                    project = AmplReplanControllerProxyTest.proxy.updateProject(project);
                    Assert.notNull(null);
                    AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId());
                    org.junit.Assert.fail("testUpdateProjectnull13337 should have thrown IllegalArgumentException");
                    project.setResources(__DSPOT_resources_802);
                }
                org.junit.Assert.fail("testUpdateProjectnull13337_failAssert3296_mg13427 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateProjectnull13337_failAssert3296_mg13427_failAssert3362litString13644 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test
    @Ignore
    public void testUpdateFeatureOfProjectById() throws Exception {
        Project project = AmplReplanControllerProxyTest.createProject();
        project = AmplReplanControllerProxyTest.proxy.createProject(project);
        Assert.notNull(project);
        Assert.notNull(project.getId());
        Feature feature = AmplReplanControllerProxyTest.createFeature();
        feature = AmplReplanControllerProxyTest.proxy.createFeatureOfProjectById(feature, project.getId());
        Assert.notNull(feature);
        Assert.notNull(feature.getId());
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(project.getId());
        Assert.notEmpty(features);
        feature = AmplReplanControllerProxyTest.proxy.getFeatureByIdOfProjectById(features.get(0).getId(), project.getId());
        Assert.notNull(feature);
        feature.setDescription(((feature.getDescription()) + " modified by test"));
        AmplReplanControllerProxyTest.proxy.updateFeatureOfProjectById(feature, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        org.junit.Assert.assertEquals(AmplReplanControllerProxyTest.proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()), HttpStatus.OK);
        org.junit.Assert.assertEquals(AmplReplanControllerProxyTest.proxy.deleteProjectById(project.getId()), HttpStatus.OK);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(1);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release.setDescription(originalDescription);
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13868_failAssert3432() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release.setDescription(originalDescription);
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433() throws Exception {
        try {
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            Release release = releases.get(0);
            String originalDescription = release.getDescription();
            release.setDescription(((release.getDescription()) + " modified by test"));
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            release.setDescription(originalDescription);
            release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426litString13936_failAssert3436() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(1);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + "Atos Test: Swift developer with experience on iOS 10"));
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDescription(originalDescription);
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426litString13936 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426_mg13967_failAssert3445() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_828 = Collections.singletonList(new Resource());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(1);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + " modified by test"));
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDescription(originalDescription);
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856 should have thrown ArrayIndexOutOfBoundsException");
                release.setResources(__DSPOT_resources_828);
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426_mg13967 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13868_failAssert3432litString13938_failAssert3454() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(0);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + " modified by test"));
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release.setDescription(originalDescription);
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868_failAssert3432litString13938 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433litString13937_failAssert3477() throws Exception {
        try {
            {
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(0);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + "Atos test release description"));
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                release.setDescription(originalDescription);
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433litString13937 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978_failAssert3492() throws Exception {
        try {
            {
                List<Resource> __DSPOT_resources_832 = Collections.singletonList(new Resource());
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                Release release = releases.get(0);
                String originalDescription = release.getDescription();
                release.setDescription(((release.getDescription()) + " modified by test"));
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                release.setDescription(originalDescription);
                release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
                release.setResources(__DSPOT_resources_832);
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426litString13936_failAssert3436null14171_failAssert3500() throws Exception {
        try {
            {
                {
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(releases);
                    Release release = releases.get(1);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + "Atos Test: Swift developer with experience on iOS 10"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426litString13936 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426litString13936_failAssert3436null14171 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426_mg13967_failAssert3445litString14137_failAssert3507() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_828 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    Release release = releases.get(1);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + " modified by test"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856 should have thrown ArrayIndexOutOfBoundsException");
                    release.setResources(__DSPOT_resources_828);
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426_mg13967 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdlitNum13856_failAssert3426_mg13967_failAssert3445litString14137 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13868_failAssert3432litString13938_failAssert3454litNum14150_failAssert3527() throws Exception {
        try {
            {
                {
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    Release release = releases.get(0);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + " modified by test"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868_failAssert3432litString13938 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13868_failAssert3432litString13938_failAssert3454litNum14150 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433litString13937_failAssert3477litNum14156_failAssert3539() throws Exception {
        try {
            {
                {
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    Release release = releases.get(0);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + "Atos test release description"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433litString13937 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433litString13937_failAssert3477litNum14156 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978_failAssert3492litString14134_failAssert3547() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_832 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    Release release = releases.get(0);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + "Atos test: Swift Developer"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
                    release.setResources(__DSPOT_resources_832);
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978_failAssert3492litString14134 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978_failAssert3492null14217_failAssert3563() throws Exception {
        try {
            {
                {
                    List<Resource> __DSPOT_resources_832 = Collections.singletonList(new Resource());
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    Release release = releases.get(0);
                    String originalDescription = release.getDescription();
                    release.setDescription(((release.getDescription()) + " modified by test"));
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    release.setDescription(originalDescription);
                    release = AmplReplanControllerProxyTest.proxy.updateReleaseOfProjectById(release, AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869 should have thrown IllegalArgumentException");
                    release.setResources(__DSPOT_resources_832);
                }
                org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateReleasesOfProjectByIdnull13869_failAssert3433_mg13978_failAssert3492null14217 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid release", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        Skill skill = skills.get(0);
        String originalDescription = skill.getDescription();
        assertEquals("Atos test: Swift development of iOS", originalDescription);
        skill.setDescription(((skill.getDescription()) + ":"));
        skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        skill.setDescription(originalDescription);
        skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        assertEquals("Atos test: Swift development of iOS", originalDescription);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitNum14986_failAssert3690() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(1);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitNum14986 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdnull14995_failAssert3696() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(0);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + " modified by test"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdnull14995 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985litNum15055_failAssert3700() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(1);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + ":"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985litNum15055 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985null15079_failAssert3706() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(0);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + ":"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            skill.setDescription(originalDescription);
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15079 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985null15081_failAssert3707() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            Skill skill = skills.get(0);
            String originalDescription = skill.getDescription();
            skill.setDescription(((skill.getDescription()) + ":"));
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            skill.setDescription(originalDescription);
            skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15081 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985litNum15055_failAssert3700null15212_failAssert3745() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                Skill skill = skills.get(1);
                String originalDescription = skill.getDescription();
                skill.setDescription(((skill.getDescription()) + ":"));
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                skill.setDescription(originalDescription);
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985litNum15055 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985litNum15055_failAssert3700null15212 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985null15079_failAssert3706litNum15219_failAssert3756() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                Skill skill = skills.get(0);
                String originalDescription = skill.getDescription();
                skill.setDescription(((skill.getDescription()) + ":"));
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                skill.setDescription(originalDescription);
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15079 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15079_failAssert3706litNum15219 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateSkillsOfProjectByIdlitString14985null15081_failAssert3707litNum15217_failAssert3768() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                Skill skill = skills.get(0);
                String originalDescription = skill.getDescription();
                skill.setDescription(((skill.getDescription()) + ":"));
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                skill.setDescription(originalDescription);
                skill = AmplReplanControllerProxyTest.proxy.updateSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15081 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testUpdateSkillsOfProjectByIdlitString14985null15081_failAssert3707litNum15217 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392() throws Exception {
        Double __DSPOT_availability_851 = 0.6395468426119268;
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Resource resource = resources.get(0);
        String originalDescription = resource.getDescription();
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
        resource.setDescription(((resource.getDescription()) + " modified by test"));
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setDescription(originalDescription);
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setAvailability(__DSPOT_availability_851);
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdlitNum14386_failAssert3568() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(1);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdlitNum14386 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectByIdnull14397_failAssert3574() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(0);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testUpdateResourceOfProjectByIdnull14397 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392litString14473() throws Exception {
        Double __DSPOT_availability_851 = 0.6395468426119268;
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Resource resource = resources.get(0);
        String originalDescription = resource.getDescription();
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
        resource.setDescription(((resource.getDescription()) + " modified by tst"));
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setDescription(originalDescription);
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setAvailability(__DSPOT_availability_851);
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392litNum14510_failAssert3578() throws Exception {
        try {
            Double __DSPOT_availability_851 = 0.6395468426119268;
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(1);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setAvailability(__DSPOT_availability_851);
            org.junit.Assert.fail("testUpdateResourceOfProjectById_mg14392litNum14510 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392null14533_failAssert3584() throws Exception {
        try {
            Double __DSPOT_availability_851 = 0.6395468426119268;
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(0);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by test"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setAvailability(__DSPOT_availability_851);
            org.junit.Assert.fail("testUpdateResourceOfProjectById_mg14392null14533 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392litString14473litNum14716() throws Exception {
        Double __DSPOT_availability_851 = 1.6395468426119268;
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        Resource resource = resources.get(0);
        String originalDescription = resource.getDescription();
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
        resource.setDescription(((resource.getDescription()) + " modified by tst"));
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setDescription(originalDescription);
        resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource.setAvailability(__DSPOT_availability_851);
        assertEquals("Atos test: Swift developer with experience on iOS 10", originalDescription);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392litString14473litNum14741_failAssert3627() throws Exception {
        try {
            Double __DSPOT_availability_851 = 0.6395468426119268;
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(1);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by tst"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setAvailability(__DSPOT_availability_851);
            org.junit.Assert.fail("testUpdateResourceOfProjectById_mg14392litString14473litNum14741 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testUpdateResourceOfProjectById_mg14392litString14473null14777_failAssert3633() throws Exception {
        try {
            Double __DSPOT_availability_851 = 0.6395468426119268;
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            Resource resource = resources.get(0);
            String originalDescription = resource.getDescription();
            resource.setDescription(((resource.getDescription()) + " modified by tst"));
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setDescription(originalDescription);
            resource = AmplReplanControllerProxyTest.proxy.updateResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource.setAvailability(__DSPOT_availability_851);
            org.junit.Assert.fail("testUpdateResourceOfProjectById_mg14392litString14473null14777 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3388_failAssert910() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3388 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3391_failAssert911() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3391 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);

            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456_failAssert915() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900null3526_failAssert928() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900null3526 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455_failAssert933() throws Exception {
        try {
            {
                Integer __DSPOT_code_122 = -342650539;
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375 should have thrown ArrayIndexOutOfBoundsException");
                feature.setCode(__DSPOT_code_122);
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905null3514_failAssert941() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905null3514 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914litNum3477_failAssert995() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914litNum3477 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914_mg3511_failAssert1004() throws Exception {
        try {
            {
                Date __DSPOT_deadline_135 = new Date("$S oY.>c^U!$Cz2lvLY3");
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);

                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394 should have thrown IllegalArgumentException");
                feature.setDeadline(__DSPOT_deadline_135);
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914_mg3511 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456_failAssert915null3823_failAssert1014() throws Exception {
        try {
            {
                {
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456_failAssert915null3823 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456_failAssert915null3836_failAssert1015() throws Exception {
        try {
            {
                {
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3369_failAssert900litNum3456_failAssert915null3836 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455_failAssert933null3829_failAssert1029() throws Exception {
        try {
            {
                {
                    Integer __DSPOT_code_122 = null;
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375 should have thrown ArrayIndexOutOfBoundsException");
                    feature.setCode(__DSPOT_code_122);
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455_failAssert933null3829 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455_failAssert933null3849_failAssert1031() throws Exception {
        try {
            {
                {
                    Integer __DSPOT_code_122 = -342650539;
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375 should have thrown ArrayIndexOutOfBoundsException");
                    feature.setCode(__DSPOT_code_122);
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdlitNum3375_failAssert905_mg3455_failAssert933null3849 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914litNum3477_failAssert995litNum3795_failAssert1044() throws Exception {
        try {
            {
                {
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394 should have thrown IllegalArgumentException");
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914litNum3477 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914litNum3477_failAssert995litNum3795 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914_mg3511_failAssert1004litString3771_failAssert1050() throws Exception {
        try {
            {
                {
                    Date __DSPOT_deadline_135 = new Date("Atos Project Test");
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);

                    org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394 should have thrown IllegalArgumentException");
                    feature.setDeadline(__DSPOT_deadline_135);
                }
                org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914_mg3511 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfFeatureByIdOfProjectByIdnull3394_failAssert914_mg3511_failAssert1004litString3771 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependencies = new ArrayList<>();
        boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        assertTrue(o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum1_failAssert0() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum1 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum13_failAssert10() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum13 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdnull28_failAssert16() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdnull28 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum103_failAssert20() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum103 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123_failAssert25() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147_failAssert30() throws Exception {
        try {
            Date __DSPOT_deadline_15 = new Date("gpbL[{$QV5:Wz2[|+mr6");
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature.setDeadline(__DSPOT_deadline_15);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null181_failAssert32() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null181 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null188_failAssert35() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependencies = new ArrayList<>();
            boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null188 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum103_failAssert20litNum390_failAssert101() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum103 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum103_failAssert20litNum390 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123_failAssert25_mg387_failAssert119() throws Exception {
        try {
            {
                Integer __DSPOT_code_35 = -439235821;
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123 should have thrown ArrayIndexOutOfBoundsException");
                feature.setCode(__DSPOT_code_35);
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123_failAssert25_mg387 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123_failAssert25null465_failAssert127() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5litNum123_failAssert25null465 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147_failAssert30litString386_failAssert131() throws Exception {
        try {
            {
                Date __DSPOT_deadline_15 = new Date("Atos test release description");
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature.setDeadline(__DSPOT_deadline_15);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147_failAssert30litString386 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147_failAssert30_mg479_failAssert157() throws Exception {
        try {
            {
                List<Skill> __DSPOT_requiredSkills_69 = Collections.singletonList(new Skill());
                Date __DSPOT_deadline_15 = new Date("gpbL[{$QV5:Wz2[|+mr6");
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature.setDeadline(__DSPOT_deadline_15);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147 should have thrown IllegalArgumentException");
                feature.setRequiredSkills(__DSPOT_requiredSkills_69);
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5_mg147_failAssert30_mg479 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null188_failAssert35litNum407_failAssert191() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependencies = new ArrayList<>();
                boolean o_testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5__7 = dependencies.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null188 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum5null188_failAssert35litNum407 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        assertTrue(o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2323_failAssert617() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(1));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2323 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2335_failAssert627() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2335 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull2344_failAssert632() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull2344 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull2348_failAssert634() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdnull2348 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }
    
    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450_failAssert643() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2495_failAssert648() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2495 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2506_failAssert650() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2506 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2511_failAssert653() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2511 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638litNum2748_failAssert736() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638litNum2748 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638_mg2774_failAssert742() throws Exception {
        try {
            {
                Date __DSPOT_deadline_103 = new Date(";(?xw0]W#nkib%A@IY:W");
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(__DSPOT_deadline_103);
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638_mg2774 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638null2800_failAssert745() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2418_failAssert638null2800 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450_failAssert643_mg2748_failAssert751() throws Exception {
        try {
            {
                Date __DSPOT_deadline_100 = new Date(-1368023980, -1071949933, 891928193, -1710226138, 24742384, -726566497);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(__DSPOT_deadline_100);
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450_failAssert643_mg2748 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450_failAssert643null2794_failAssert756() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327litNum2450_failAssert643null2794 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2511_failAssert653litNum2770_failAssert804() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2511 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteResourcesOfReleaseByIdOfProjectByIdlitNum2327null2511_failAssert653litNum2770 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).toString());
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16)).toString());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__11);
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).toString());
        HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__16)).toString());
        assertTrue(o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__11);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum733__13)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum723_failAssert210() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(1));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum723 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum724_failAssert211() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(-1));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum724 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum735_failAssert220() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum735 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum736_failAssert221() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(-1).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum736 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull741_failAssert225() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull741 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull745_failAssert227() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull745 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908_failAssert230() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum830_failAssert231() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum830 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727null955_failAssert245() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727null955 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727null981_failAssert249() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727null981 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull741_failAssert225litNum805_failAssert322() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(-1));
                AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull741 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdnull741_failAssert225litNum805 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229litNum1446_failAssert410() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229litNum1446 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229litNum1469_failAssert414() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229litNum1469 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1484_failAssert416() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1484 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1504_failAssert418() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1504 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1507_failAssert419() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(null, releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum896_failAssert229null1507 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908_failAssert230litNum1447_failAssert423() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908_failAssert230litNum1447 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908_failAssert230null1482_failAssert426() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                HttpStatus o_testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727__16 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum727litNum908_failAssert230null1482 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
 
    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdlitString3019() throws Exception {
        Skill skill = new Skill();
        skill.setName(" modified by test");
        skill.setDescription("Atos Test: Swift development of iOS");
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        HttpStatus o_testAddDeleteSkillOfProjectByIdlitString3019__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteSkillOfProjectByIdlitString3019__8)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull3037_failAssert820() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull3037 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdnull3038_failAssert821() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdnull3038 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdlitString3019null3138_failAssert822() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName(" modified by test");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            HttpStatus o_testAddDeleteSkillOfProjectByIdlitString3019__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3138 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdlitString3019null3139_failAssert823() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName(" modified by test");
            skill.setDescription("Atos Test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            HttpStatus o_testAddDeleteSkillOfProjectByIdlitString3019__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3139 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdlitString3019null3138_failAssert822litString3309_failAssert880() throws Exception {
        try {
            {
                Skill skill = new Skill();
                skill.setName(" modified by test");
                skill.setDescription("Atos test: Swift Developer");
                skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                HttpStatus o_testAddDeleteSkillOfProjectByIdlitString3019__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3138 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3138_failAssert822litString3309 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillOfProjectByIdlitString3019null3139_failAssert823litString3309_failAssert890() throws Exception {
        try {
            {
                Skill skill = new Skill();
                skill.setName(" modified by test");
                skill.setDescription("Atos test: Swift Developer");
                skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                HttpStatus o_testAddDeleteSkillOfProjectByIdlitString3019__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3139 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillOfProjectByIdlitString3019null3139_failAssert823litString3309 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdlitString1713() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos Test: Swift development of iOS");
        resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testAddDeleteResourceOfProjectByIdlitString1713__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testAddDeleteResourceOfProjectByIdlitString1713__9)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdnull1744_failAssert485() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdnull1744 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdnull1745_failAssert486() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdnull1745 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdlitString1713null1922_failAssert487() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos Test: Swift development of iOS");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            HttpStatus o_testAddDeleteResourceOfProjectByIdlitString1713__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1922 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdlitString1713null1925_failAssert488() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos Test: Swift development of iOS");
            resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            HttpStatus o_testAddDeleteResourceOfProjectByIdlitString1713__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1925 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }
    
    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdlitString1713null1922_failAssert487litString2186_failAssert571() throws Exception {
        try {
            {
                Resource resource = new Resource();
                resource.setName("Atos Test: Swift development of iOS");
                resource.setDescription("Atos test release name");
                resource.setAvailability(80.0);
                resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                HttpStatus o_testAddDeleteResourceOfProjectByIdlitString1713__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1922 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1922_failAssert487litString2186 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteResourceOfProjectByIdlitString1713null1925_failAssert488litString2185_failAssert594() throws Exception {
        try {
            {
                Resource resource = new Resource();
                resource.setName("Atos Test: Swift development of iOS");
                resource.setDescription(" modified by test");
                resource.setAvailability(80.0);
                resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                HttpStatus o_testAddDeleteResourceOfProjectByIdlitString1713__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1925 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteResourceOfProjectByIdlitString1713null1925_failAssert488litString2185 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
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

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11);
        Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        assertTrue(o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4062_failAssert1075() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(1));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4062 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4074_failAssert1085() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4074 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdnull4082_failAssert1090() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdnull4082 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdnull4086_failAssert1092() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdnull4086 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151_failAssert1096() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178_failAssert1101() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4221_failAssert1106() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4221 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4235_failAssert1108() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4235 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4242_failAssert1111() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4242 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151_failAssert1096litNum4468_failAssert1190() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151_failAssert1096litNum4468 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151_failAssert1096null4518_failAssert1198() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4151_failAssert1096null4518 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178_failAssert1101_mg4470_failAssert1204() throws Exception {
        try {
            {
                Double __DSPOT_availability_210 = 0.3673320059283104;
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178 should have thrown ArrayIndexOutOfBoundsException");
                resource.setAvailability(__DSPOT_availability_210);
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178_failAssert1101_mg4470 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178_failAssert1101null4508_failAssert1208() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066litNum4178_failAssert1101null4508 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4242_failAssert1111litNum4492_failAssert1254() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4242 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testAddDeleteSkillsOfResourceByIdOfProjectByIdlitNum4066null4242_failAssert1111litNum4492 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notEmpty(features);
        Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        assertTrue(o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11709_failAssert2916() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11709 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdnull11725_failAssert2922() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11725 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11858_failAssert2931() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11858 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11870_failAssert2932() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11870 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11876_failAssert2935() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notEmpty(features);
            Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11876 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911litNum11791_failAssert2936() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                skillsToDelete.add(skills.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911litNum11791 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911_mg11828_failAssert2943() throws Exception {
        try {
            {
                Date __DSPOT_deadline_592 = new Date("C6HvQ{7`[>;YwP/8[Coz");
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                skillsToDelete.add(skills.get(0));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703 should have thrown ArrayIndexOutOfBoundsException");
                feature.setDeadline(__DSPOT_deadline_592);
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911_mg11828 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921_mg11855_failAssert2980() throws Exception {
        try {
            {
                List<Feature> __DSPOT_dependencies_613 = Collections.singletonList(new Feature());
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                skillsToDelete.add(skills.get(0));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722 should have thrown IllegalArgumentException");
                feature.setDependencies(__DSPOT_dependencies_613);
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921_mg11855 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926_mg12101_failAssert3012() throws Exception {
        try {
            {
                Integer __DSPOT_code_619 = 1555849796;
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789 should have thrown ArrayIndexOutOfBoundsException");
                feature.setCode(__DSPOT_code_619);
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926_mg12101 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926_mg12111_failAssert3013() throws Exception {
        try {
            {
                Date __DSPOT_deadline_621 = new Date("j.pbZs?{yo3o#YMTVY|P");
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789 should have thrown ArrayIndexOutOfBoundsException");
                feature.setDeadline(__DSPOT_deadline_621);
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926_mg12111 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926null12176_failAssert3019() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926null12176 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926null12194_failAssert3020() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707litNum11789_failAssert2926null12194 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11876_failAssert2935litNum12130_failAssert3062() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notEmpty(features);
                Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707__16 = skillsToDelete.add(skills.get(0));
                feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11876 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11707null11876_failAssert2935litNum12130 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911litNum11791_failAssert2936null12171_failAssert3076() throws Exception {
        try {
            {
                {
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(skills);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(null, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    List<Skill> skillsToDelete = new ArrayList<>();
                    skillsToDelete.add(skills.get(1));
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911litNum11791 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdlitNum11703_failAssert2911litNum11791_failAssert2936null12171 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921_mg11855_failAssert2980litNum12103_failAssert3100() throws Exception {
        try {
            {
                {
                    List<Feature> __DSPOT_dependencies_613 = Collections.singletonList(new Feature());
                    List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(skills);
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notEmpty(features);
                    Feature feature = AmplReplanControllerProxyTest.proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    List<Skill> skillsToDelete = new ArrayList<>();
                    skillsToDelete.add(skills.get(0));
                    feature = AmplReplanControllerProxyTest.proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(feature);
                    org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722 should have thrown IllegalArgumentException");
                    feature.setDependencies(__DSPOT_dependencies_613);
                }
                org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921_mg11855 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteSkillsOfFeatureByIdOfProjectByIdnull11722_failAssert2921_mg11855_failAssert2980litNum12103 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Feature> dependenciesToAdd = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7);
        Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        List<Feature> dependenciesToDelete = new ArrayList<>();
        boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(0));
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16);
        feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(feature);
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7);
        assertTrue(o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7280_failAssert1881() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(1));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7280 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7292_failAssert1891() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7292 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdnull7307_failAssert1897() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            dependenciesToDelete.add(features.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdnull7307 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7383_failAssert1901() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7383 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(1));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7462_failAssert1912() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7462 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7467_failAssert1915() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Feature> dependenciesToAdd = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
            Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(feature);
            List<Feature> dependenciesToDelete = new ArrayList<>();
            boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(0));
            feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7467 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7383_failAssert1901litNum7666_failAssert1981() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependenciesToAdd = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Feature> dependenciesToDelete = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7383 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7383_failAssert1901litNum7666 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906_mg7672_failAssert1999() throws Exception {
        try {
            {
                Integer __DSPOT_code_498 = 1190111293;
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependenciesToAdd = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Feature> dependenciesToDelete = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408 should have thrown ArrayIndexOutOfBoundsException");
                feature.setCode(__DSPOT_code_498);
            }
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906_mg7672 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906_mg7680_failAssert2000() throws Exception {
        try {
            {
                Date __DSPOT_deadline_499 = new Date("ErJ,Q*wO|INCdXv>?dZt");
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependenciesToAdd = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Feature> dependenciesToDelete = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408 should have thrown ArrayIndexOutOfBoundsException");
                feature.setDeadline(__DSPOT_deadline_499);
            }
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906_mg7680 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906null7722_failAssert2007() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependenciesToAdd = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(null, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Feature> dependenciesToDelete = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(1));
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284litNum7408_failAssert1906null7722 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7467_failAssert1915litNum7681_failAssert2038() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Feature> dependenciesToAdd = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__7 = dependenciesToAdd.add(features.get(0));
                Feature feature = AmplReplanControllerProxyTest.proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(feature);
                List<Feature> dependenciesToDelete = new ArrayList<>();
                boolean o_testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284__16 = dependenciesToDelete.add(features.get(0));
                feature = AmplReplanControllerProxyTest.proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7467 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteDependenciesOfFeatureByIdOfProjectByIdlitNum7284null7467_failAssert1915litNum7681 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554() throws Exception {
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Resource> resourcesToAdd = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11);
        Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        List<Resource> resourcesToDelete = new ArrayList<>();
        boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20);
        release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(release);
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11);
        assertTrue(o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10550_failAssert2596() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(1));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10550 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10562_failAssert2606() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10562 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdnull10575_failAssert2613() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10575 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655_failAssert2617() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684_failAssert2622() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(1));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10730_failAssert2627() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10730 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10744_failAssert2629() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10744 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10753_failAssert2632() throws Exception {
        try {
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Resource> resourcesToAdd = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
            Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(release);
            List<Resource> resourcesToDelete = new ArrayList<>();
            boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
            release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10753 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611_mg10716_failAssert2681() throws Exception {
        try {
            {
                Date __DSPOT_deadline_550 = new Date("]!qOeddHWm8&1a$RH&p;");
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                resourcesToDelete.add(resources.get(0));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571 should have thrown IllegalArgumentException");
                release.setDeadline(__DSPOT_deadline_550);
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611_mg10716 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655_failAssert2617litNum10978_failAssert2715() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(1));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655_failAssert2617litNum10978 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655_failAssert2617null11056_failAssert2724() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10655_failAssert2617null11056 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684_failAssert2622_mg10983_failAssert2730() throws Exception {
        try {
            {
                Date __DSPOT_deadline_558 = new Date(-239449135, 1084192896, -1187098048, 1135323118, 543729403, -1304718600);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(1));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684 should have thrown ArrayIndexOutOfBoundsException");
                release.setDeadline(__DSPOT_deadline_558);
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684_failAssert2622_mg10983 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684_failAssert2622null11041_failAssert2735() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(1));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554litNum10684_failAssert2622null11041 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of resources", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10753_failAssert2632litNum11008_failAssert2783() throws Exception {
        try {
            {
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Resource> resourcesToAdd = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__11 = resourcesToAdd.add(resources.get(0));
                Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(release);
                List<Resource> resourcesToDelete = new ArrayList<>();
                boolean o_testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554__20 = resourcesToDelete.add(resources.get(0));
                release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10753 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdlitNum10554null10753_failAssert2632litNum11008 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611_mg10716_failAssert2681litString10975_failAssert2799() throws Exception {
        try {
            {
                {
                    Date __DSPOT_deadline_550 = new Date("Atos test: Swift Developer");
                    List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(resources);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Resource> resourcesToAdd = new ArrayList<>();
                    resourcesToAdd.add(resources.get(0));
                    Release release = AmplReplanControllerProxyTest.proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    List<Resource> resourcesToDelete = new ArrayList<>();
                    resourcesToDelete.add(resources.get(0));
                    release = AmplReplanControllerProxyTest.proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(release);
                    org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571 should have thrown IllegalArgumentException");
                    release.setDeadline(__DSPOT_deadline_550);
                }
                org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611_mg10716 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteResourcesOfReleaseByIdOfProjectByIdnull10571_failAssert2611_mg10716_failAssert2681litString10975 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).toString());
        List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).toString());
        featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13)).toString());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912() throws Exception {
        List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(releases);
        Assert.notEmpty(releases);
        List<Feature> featuresToAdd = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__11 = featuresToAdd.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__11);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).toString());
        List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.notEmpty(features);
        int numberOfFeaturesOfRelease = featuresOfRelease.size();
        List<Feature> featuresToDelete = new ArrayList<>();
        boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__26 = featuresToDelete.add(features.get(0));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__26);
        HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).toString());
        featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(features);
        Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__11);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13)).toString());
        assertTrue(o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__26);
        assertEquals("OK", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(1));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7907_failAssert2061() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(460330538));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7907 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("460330538", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7914_failAssert2067() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7914 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7915_failAssert2068() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(-1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7915 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(1));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7922_failAssert2074() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(Integer.MAX_VALUE));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7922 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdnull7943_failAssert2092() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdnull7943 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdnull7947_failAssert2094() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            featuresToAdd.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            featuresToDelete.add(features.get(0));
            AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdnull7947 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8293_failAssert2100() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(Integer.MIN_VALUE));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8293 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8417_failAssert2101() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8417 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8119_failAssert2106() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8119 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8207_failAssert2107() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8207 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8179_failAssert2136() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8179 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8259_failAssert2138() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(1));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8259 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906null8545_failAssert2155() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906null8545 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912null8496_failAssert2158() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7912null8496 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906null8579_failAssert2161() throws Exception {
        try {
            List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(releases);
            Assert.notEmpty(releases);
            List<Feature> featuresToAdd = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.notEmpty(features);
            int numberOfFeaturesOfRelease = featuresOfRelease.size();
            List<Feature> featuresToDelete = new ArrayList<>();
            boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
            HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(features);
            Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906null8579 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(0));
                AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(1));
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                featuresToAdd.add(features.get(1));
                AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                featuresToDelete.add(features.get(0));
                AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9479_failAssert2265() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9479 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9480_failAssert2266() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9480 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9473_failAssert2267() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7902_failAssert2057null8584_failAssert2170null9473 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9463_failAssert2293() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9463 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9445_failAssert2294() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9445 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9467_failAssert2296() throws Exception {
        try {
            {
                {
                    List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(releases);
                    Assert.notEmpty(releases);
                    List<Feature> featuresToAdd = new ArrayList<>();
                    featuresToAdd.add(features.get(0));
                    AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(null, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(features);
                    Assert.notEmpty(features);
                    int numberOfFeaturesOfRelease = featuresOfRelease.size();
                    List<Feature> featuresToDelete = new ArrayList<>();
                    featuresToDelete.add(features.get(1));
                    AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                    Assert.notNull(null);
                    Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - 1)));
                    org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920 should have thrown ArrayIndexOutOfBoundsException");
                }
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7920_failAssert2072null8503_failAssert2169null9467 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of features", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9297_failAssert2327() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9297 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9346_failAssert2329() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9346 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9190_failAssert2330() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(Integer.MAX_VALUE));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9190 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9128_failAssert2331() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9128 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9362_failAssert2332() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MIN_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MIN_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8497_failAssert2098litNum9362 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8207_failAssert2107litNum9283_failAssert2387() throws Exception {
        try {
            {
                List<Feature> features = AmplReplanControllerProxyTest.proxy.getFeaturesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                List<Release> releases = AmplReplanControllerProxyTest.proxy.getReleasesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(releases);
                Assert.notEmpty(releases);
                List<Feature> featuresToAdd = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__11 = featuresToAdd.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__13 = AmplReplanControllerProxyTest.proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                List<Feature> featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(Integer.MAX_VALUE).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.notEmpty(features);
                int numberOfFeaturesOfRelease = featuresOfRelease.size();
                List<Feature> featuresToDelete = new ArrayList<>();
                boolean o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__26 = featuresToDelete.add(features.get(0));
                HttpStatus o_testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906__28 = AmplReplanControllerProxyTest.proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                featuresOfRelease = AmplReplanControllerProxyTest.proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(features);
                Assert.isTrue(((featuresOfRelease.size()) == (numberOfFeaturesOfRelease - (Integer.MAX_VALUE))));
                org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8207 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDeleteFeaturesOfReleaseByIdOfProjectByIdlitNum7906litNum8207_failAssert2107litNum9283 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("2147483647", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdlitString11353() throws Exception {
        Skill skill = new Skill();
        skill.setName("Atos Project Test");
        skill.setDescription("Atos test: Swift development of iOS");
        skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skill);
        HttpStatus o_testDeleteSkillOfProjectByIdlitString11353__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteSkillOfProjectByIdlitString11353__8)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdnull11371_failAssert2831() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdnull11371 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdnull11372_failAssert2832() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos test: Swift");
            skill.setDescription("Atos test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdnull11372 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdlitString11353null11480_failAssert2833() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos Project Test");
            skill.setDescription("Atos test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skill);
            HttpStatus o_testDeleteSkillOfProjectByIdlitString11353__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11480 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }
 
    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdlitString11353null11483_failAssert2834() throws Exception {
        try {
            Skill skill = new Skill();
            skill.setName("Atos Project Test");
            skill.setDescription("Atos test: Swift development of iOS");
            skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            HttpStatus o_testDeleteSkillOfProjectByIdlitString11353__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11483 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdlitString11353null11480_failAssert2833litString11644_failAssert2891() throws Exception {
        try {
            {
                Skill skill = new Skill();
                skill.setName("Atos Project Test");
                skill.setDescription("Atos test release name");
                skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skill);
                HttpStatus o_testDeleteSkillOfProjectByIdlitString11353__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11480 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11480_failAssert2833litString11644 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid skill", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteSkillOfProjectByIdlitString11353null11483_failAssert2834litString11643_failAssert2901() throws Exception {
        try {
            {
                Skill skill = new Skill();
                skill.setName("Atos Project Test");
                skill.setDescription("Atos test release description");
                skill = AmplReplanControllerProxyTest.proxy.addSkillOfProjectById(skill, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                HttpStatus o_testDeleteSkillOfProjectByIdlitString11353__8 = AmplReplanControllerProxyTest.proxy.deleteSkillByIdOfProjectById(skill.getId(), AmplReplanControllerProxyTest.projectId);
                org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11483 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteSkillOfProjectByIdlitString11353null11483_failAssert2834litString11643 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }


    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850() throws Exception {
        Resource resource = new Resource();
        resource.setName("Atos test: Swift developer with experience on iOS 10");
        resource.setDescription("Atos test: Swift developer with experience on iOS 10");
        resource.setAvailability(80.0);
        resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).toString());
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.isTrue((!(containsId(resources, resource.getId()))));
        assertEquals("OK", ((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).getReasonPhrase());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is1xxInformational());
        assertTrue(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is2xxSuccessful());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is3xxRedirection());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is4xxClientError());
        assertFalse(((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).is5xxServerError());
        assertEquals("200", ((HttpStatus) (o_testDeleteResourceOfProjectByIdlitString9850__9)).toString());
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdnull9881_failAssert2434() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(resources, resource.getId()))));
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdnull9881 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdnull9882_failAssert2435() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift Developer");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(resources, resource.getId()))));
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdnull9882 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10073_failAssert2437() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift developer with experience on iOS 10");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(resources, resource.getId()))));
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10073 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }
 
    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10076_failAssert2438() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift developer with experience on iOS 10");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(resources, resource.getId()))));
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10076 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10079_failAssert2439() throws Exception {
        try {
            Resource resource = new Resource();
            resource.setName("Atos test: Swift developer with experience on iOS 10");
            resource.setDescription("Atos test: Swift developer with experience on iOS 10");
            resource.setAvailability(80.0);
            resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.isTrue((!(containsId(null, resource.getId()))));
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10079 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10073_failAssert2437litString10335_failAssert2524() throws Exception {
        try {
            {
                Resource resource = new Resource();
                resource.setName("Atos test: Swift developer with experience on iOS 10");
                resource.setDescription("Atos test: Swift");
                resource.setAvailability(80.0);
                resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(null, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.isTrue((!(containsId(resources, resource.getId()))));
                org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10073 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10073_failAssert2437litString10335 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a valid resource", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10076_failAssert2438litString10334_failAssert2548() throws Exception {
        try {
            {
                Resource resource = new Resource();
                resource.setName("Atos test: Swift developer with experience on iOS 10");
                resource.setDescription(" modified by test");
                resource.setAvailability(80.0);
                resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.isTrue((!(containsId(resources, resource.getId()))));
                org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10076 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10076_failAssert2438litString10334 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Test(timeout = 30000)
    public void testDeleteResourceOfProjectByIdlitString9850null10079_failAssert2439litString10337_failAssert2572() throws Exception {
        try {
            {
                Resource resource = new Resource();
                resource.setName("Atos test: Swift developer with experience on iOS 10");
                resource.setDescription(" modified by test");
                resource.setAvailability(80.0);
                resource = AmplReplanControllerProxyTest.proxy.addResourceOfProjectById(resource, AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                HttpStatus o_testDeleteResourceOfProjectByIdlitString9850__9 = AmplReplanControllerProxyTest.proxy.deleteResourceByIdOfProjectById(resource.getId(), AmplReplanControllerProxyTest.projectId);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.isTrue((!(containsId(null, resource.getId()))));
                org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10079 should have thrown NullPointerException");
            }
            org.junit.Assert.fail("testDeleteResourceOfProjectByIdlitString9850null10079_failAssert2439litString10337 should have thrown NullPointerException");
        } catch (NullPointerException expected) {
            assertEquals(null, expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339() throws Exception {
        List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(skills);
        Assert.notEmpty(skills);
        List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resources);
        Assert.notEmpty(resources);
        List<Skill> skillsToAdd = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11);
        Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        List<Skill> skillsToDelete = new ArrayList<>();
        boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20);
        int numberOfSkills = resource.getSkills().size();
        resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
        Assert.notNull(resource);
        Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11);
        assertTrue(o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20);
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6335_failAssert1594() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(1));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6335 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6347_failAssert1604() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6347 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdnull6360_failAssert1614() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdnull6360 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdnull6364_failAssert1616() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdnull6364 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdnull6366_failAssert1618() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(null, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdnull6366 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437_failAssert1620() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464_failAssert1625() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(1));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492_failAssert1630() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 2)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6541_failAssert1635() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(null);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6541 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6559_failAssert1637() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6559 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6565_failAssert1639() throws Exception {
        try {
            List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(skills);
            Assert.notEmpty(skills);
            List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resources);
            Assert.notEmpty(resources);
            List<Skill> skillsToAdd = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
            Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            List<Skill> skillsToDelete = new ArrayList<>();
            boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
            int numberOfSkills = resource.getSkills().size();
            resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(null, resource.getId(), AmplReplanControllerProxyTest.projectId);
            Assert.notNull(resource);
            Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339null6565 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437_failAssert1620litNum6923_failAssert1769() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(1));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437_failAssert1620litNum6923 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437_failAssert1620null7012_failAssert1782() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(null);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(1).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6437_failAssert1620null7012 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this argument is required; it must not be null", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464_failAssert1625litNum6932_failAssert1788() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(1));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 2)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464_failAssert1625litNum6932 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            assertEquals("1", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464_failAssert1625null7009_failAssert1797() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(null, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(1));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 1)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464 should have thrown ArrayIndexOutOfBoundsException");
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6464_failAssert1625null7009 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492_failAssert1630_mg6922_failAssert1801() throws Exception {
        try {
            {
                Double __DSPOT_availability_451 = 0.018693381144411436;
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 2)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492 should have thrown IllegalArgumentException");
                resource.setAvailability(__DSPOT_availability_451);
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492_failAssert1630_mg6922 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("[Assertion failed] - this expression must be true", expected.getMessage());
        }
    }

    @Ignore
    @Test(timeout = 30000)
    public void testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492_failAssert1630null6973_failAssert1807() throws Exception {
        try {
            {
                List<Skill> skills = AmplReplanControllerProxyTest.proxy.getSkillsOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(skills);
                Assert.notEmpty(skills);
                List<Resource> resources = AmplReplanControllerProxyTest.proxy.getResourcesOfProjectById(AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resources);
                Assert.notEmpty(resources);
                List<Skill> skillsToAdd = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__11 = skillsToAdd.add(skills.get(0));
                Resource resource = AmplReplanControllerProxyTest.proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                List<Skill> skillsToDelete = new ArrayList<>();
                boolean o_testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339__20 = skillsToDelete.add(skills.get(0));
                int numberOfSkills = resource.getSkills().size();
                resource = AmplReplanControllerProxyTest.proxy.deleteSkillsOfResourceByIdOfProjectById(null, resource.getId(), AmplReplanControllerProxyTest.projectId);
                Assert.notNull(resource);
                Assert.isTrue(((resource.getSkills().size()) == (numberOfSkills - 2)));
                org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492 should have thrown IllegalArgumentException");
            }
            org.junit.Assert.fail("testDelecteSkillsOfResourceByIdOfProjectByIdlitNum6339litNum6492_failAssert1630null6973 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException expected) {
            assertEquals("Provide a not-empty list of skills", expected.getMessage());
        }
    }
}

