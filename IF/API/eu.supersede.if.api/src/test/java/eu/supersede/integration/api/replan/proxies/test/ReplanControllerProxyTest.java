package eu.supersede.integration.api.replan.proxies.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.replan.proxies.IReplanController;
import eu.supersede.integration.api.replan.proxies.ReplanControllerProxy;
import eu.supersede.integration.api.replan.types.Feature;
import eu.supersede.integration.api.replan.types.Plan;
import eu.supersede.integration.api.replan.types.Project;
import eu.supersede.integration.api.replan.types.Release;
import eu.supersede.integration.api.replan.types.Resource;
import eu.supersede.integration.api.replan.types.Skill;

public class ReplanControllerProxyTest {
	private static final Logger log = LoggerFactory.getLogger(ReplanControllerProxyTest.class);
	private IReplanController proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new ReplanControllerProxy();
    }

    @Test
    public void testGetProjectById() throws Exception{
    	Project project = proxy.getProjectById(1);
    	Assert.notNull(project);
    }
    
    @Test
    public void testGetFeaturesOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    }

    @Test
    public void testGetFeatureByIdOfProjectById() throws Exception{
    	Feature feature = proxy.getFeatureByIdOfProjectById(1, 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testGetReleasesOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    }
    
    @Test
    public void testGetFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfReleaseByIdOfProjectById(1, 1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    }
    
    @Test
    public void testGetPlanOfReleaseByIdOfProjectById() throws Exception{
    	Plan plan = proxy.getPlanOfReleaseByIdOfProjectById(1, 1);
    	Assert.notNull(plan);
    }
    
    @Test
    public void testGetSkillsOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    }
    
    @Test
    public void testGetResourcesOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    }
    
    @Test
    public void testUpdateProject() throws Exception{
    	Project project = proxy.getProjectById(1);
    	Assert.notNull(project);
    	project.setDescription(project.getDescription() + " modified by test");
    	project = proxy.updateProject(project);
    	Assert.notNull(project);
    }
    
    @Test
    public void testUpdateFeatureOfProjectById() throws Exception{
    	Feature feature = proxy.getFeatureByIdOfProjectById(1, 1);
    	Assert.notNull(feature);
    	feature.setDescription(feature.getDescription() + " modified by test");
    	proxy.updateFeatureOfProjectById(feature, 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testUpdateReleasesOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	Release release = releases.get(0);
    	release.setDescription(release.getDescription() + " modified by test");
    	release = proxy.updateReleaseOfProjectById(release, 1);
    	Assert.notNull(release);
    }
    
    @Test
    public void testUpdateSkillsOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	Skill skill = skills.get(0);
    	skill.setDescription(skill.getDescription() + " modified by test");
    	skill = proxy.updateSkillOfProjectById(skill, 1);
    	Assert.notNull(skill);
    }
    
    @Test
    public void testUpdateResourceOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	Resource resource = resources.get(0);
    	resource.setDescription(resource.getDescription() + " modified by test");
    	resource = proxy.updateResourceOfProjectById(resource, 1);
    	Assert.notNull(resource);
    }
    
    @Test
    public void testAddSkillsOfFeatureByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	Feature feature = proxy.addSkillsOfFeatureByIdOfProjectById(skills, 1, 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testAddDependenciesOfFeatureByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	Assert.isTrue (features.size()>2);
    	
    	List<Feature> dependencies = new ArrayList<>();
    	dependencies.add(features.get(0));
    	Feature feature = proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(1).getId(), 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testAddReleaseOfProjectById() throws Exception{
    	Release release = new Release();
    	release.setName("Release April 2017");
    	release.setDescription("M24 Release");
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(2016, 4, 30);
    	release.setDeadline(calendar.getTime());
    	
    	release = proxy.addReleaseOfProjectById(release, 1);
    	Assert.notNull(release);
    }
    
    @Test
    public void testAddResourcesOfReleaseByIdOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Resource> resourcesToAdd = new ArrayList<>();
    	resourcesToAdd.add(resources.get(0));
    	Release release = proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), 1);
    	Assert.notNull(release);
    }
    
    @Test
    public void testAddFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Feature> featuresToAdd = new ArrayList<>();
    	featuresToAdd.add(features.get(0));
    	boolean result = proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), 1);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testAddSkillOfProjectById() throws Exception{
    	Skill skill = new Skill();
    	skill.setName("Swift");
    	skill.setDescription("Swift development of iOS");
    	
    	skill = proxy.addSkillOfProjectById(skill, 1);
    	Assert.notNull(skill);
    }
    
    @Test
    public void testAddResourceOfProjectById() throws Exception{
    	Resource resource = new Resource();
    	resource.setName("Swift Developer");
    	resource.setDescription("Swift developer with experience on iOS 10");
    	resource.setAvailability(80.0);
    	
    	resource = proxy.addResourceOfProjectById(resource, 1);
    	Assert.notNull(resource);
    }
    
    @Test
    public void testAddSkillsOfResourceByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Skill> skillsToAdd = new ArrayList<>();
    	skillsToAdd.add(skills.get(0));
    	Resource resource = proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), 1);
    	Assert.notNull(resource);
    }
    
    @Test
    public void testDeleteSkillsOfFeatureByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	Feature feature = proxy.addSkillsOfFeatureByIdOfProjectById(skills, 1, 1);
    	Assert.notNull(feature);
    	
    	List<Skill> skillsToDelete = new ArrayList<>();
    	skillsToDelete.add(skills.get(0));
    	
    	feature = proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testDeleteDependenciesOfFeatureByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	Assert.isTrue(features.size()>=2);
    	
    	List<Feature> dependenciesToAdd = new ArrayList<>();
    	dependenciesToAdd.add(features.get(1));
    	
    	Feature feature = proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), 1);
    	Assert.notNull(feature);
    	
    	List<Feature> dependenciesToDelete = new ArrayList<>();
    	dependenciesToDelete.add(features.get(1));
    	
    	feature = proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), 1);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testDeleteReleaseByIdOfProjectById() throws Exception{
    	Release release = new Release();
    	release.setName("Release April 2017");
    	release.setDescription("M24 Release");
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(2016, 4, 30);
    	release.setDeadline(calendar.getTime());
    	
    	release = proxy.addReleaseOfProjectById(release, 1);
    	Assert.notNull(release);
    	
    	Boolean result = proxy.deleteReleaseByIdOfProjectById(release.getId(), 1);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testDeleteResourcesOfReleaseByIdOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Resource> resourcesToAdd = new ArrayList<>();
    	resourcesToAdd.add(resources.get(0));
    	Release release = proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), 1);
    	Assert.notNull(release);
    	
    	List<Resource> resourcesToDelete = new ArrayList<>();
    	resourcesToDelete.add(resources.get(0));
    	
    	release = proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), 1);
    	Assert.notNull(release);
    }
    
    @Test
    public void testDeleteFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(1);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Feature> featuresToAdd = new ArrayList<>();
    	featuresToAdd.add(features.get(0));
    	boolean result = proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), 1);
    	Assert.isTrue(result);
    	
    	List<Feature> featuresOfRelease = proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), 1);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	int numberOfFeaturesOfRelease = featuresOfRelease.size();
    	
    	List<Feature> featuresToDelete = new ArrayList<>();
    	featuresToDelete.add(features.get(0));
    	
    	result = proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), 1);
    	Assert.isTrue(result);
    	
    	featuresOfRelease = proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), 1);
    	Assert.notNull(features);
    	
    	Assert.isTrue(featuresOfRelease.size() == numberOfFeaturesOfRelease - 1);
    }
    
    @Test
    public void testCancelLastPlanOfReleaseByIdOfProjectById() throws Exception{
    	Plan plan = proxy.getPlanOfReleaseByIdOfProjectById(1, 1);
    	Assert.notNull(plan);
    	
    	Boolean result = proxy.cancelLastPlanOfReleaseByIdOfProjectById(1, 1);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testDeleteSkillOfProjectById() throws Exception{
    	Skill skill = new Skill();
    	skill.setName("Swift");
    	skill.setDescription("Swift development of iOS");
    	
    	skill = proxy.addSkillOfProjectById(skill, 1);
    	Assert.notNull(skill);
    	
    	boolean result = proxy.deleteSkillByIdOfProjectById(skill.getId(), 1);
    	Assert.isTrue(result);
    }
    
    @Test
    public void tesDeleteResourceOfProjectById() throws Exception{
    	Resource resource = new Resource();
    	resource.setName("Swift Developer");
    	resource.setDescription("Swift developer with experience on iOS 10");
    	resource.setAvailability(80.0);
    	
    	resource = proxy.addResourceOfProjectById(resource, 1);
    	Assert.notNull(resource);
    	
    	boolean result = proxy.deleteResourceByIdOfProjectById(resource.getId(), 1);
    	Assert.isTrue(result);
    }
    
    
    @Test
    public void testDelecteSkillsOfResourceByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(1);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	List<Resource> resources = proxy.getResourcesOfProjectById(1);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Skill> skillsToAdd = new ArrayList<>();
    	skillsToAdd.add(skills.get(0));
    	Resource resource = proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), 1);
    	Assert.notNull(resource);
    	
    	List<Skill> skillsToDelete = new ArrayList<>();
    	skillsToDelete.add(skills.get(0));
    	
    	int numberOfSkills = resource.getSkills().size();
    	resource = proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), 1);
    	Assert.notNull(resource);
    	Assert.isTrue(resource.getSkills().size() == numberOfSkills - 1);
    }
}
