/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.replan.controller.proxies.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.replan.controller.proxies.IReplanController;
import eu.supersede.integration.api.replan.controller.proxies.ReplanControllerProxy;
import eu.supersede.integration.api.replan.controller.types.AddFeaturesForProjectPayload;
import eu.supersede.integration.api.replan.controller.types.Constraint;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.FeatureWP3;
import eu.supersede.integration.api.replan.controller.types.Format;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Priority;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Property;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
import eu.supersede.integration.api.replan.controller.types.SoftDependency;
import eu.supersede.integration.api.replan.controller.types.SoftDependencyType;

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
        proxy = new ReplanControllerProxy();
        //Create test project
        Project project = createProject();
    	project = proxy.createProject(project);
    	Assert.notNull(project);
    	Assert.notNull(project.getId());
    	projectId = project.getId();
    	
        //Create skills
    	Skill skill = new Skill();
    	skill.setName("Atos test: Swift");
    	skill.setDescription("Atos test: Swift development of iOS");
    	
    	//Create Resource
    	Resource resource = new Resource();
    	resource.setName("Atos test: Swift Developer");
    	resource.setDescription("Atos test: Swift developer with experience on iOS 10");
    	resource.setAvailability(80.0);
    	
    	resource = proxy.addResourceOfProjectById(resource, projectId);
    	Assert.notNull(resource);
    	Assert.notNull(resource.getId());
    	resourceId = resource.getId();
    	
    	//Create feature
    	Feature feature = createFeature();
    	feature = proxy.createFeatureOfProjectById(feature, projectId);
    	Assert.notNull(feature);
    	Assert.notNull(feature.getId());
    	featureId = feature.getId();
    	
    	//Create Release
    	Release release = createRelease();
    	boolean result = proxy.addReleaseOfProjectById(release, projectId);
    	Assert.isTrue(result);
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notEmpty(releases);
    	Assert.notNull(releases.get(0).getId());
    	releaseId = releases.get(0).getId();
    	
    	skill = proxy.addSkillOfProjectById(skill, projectId);
    	Assert.notNull(skill);
    	skillId = skill.getId();
    }
    
    @AfterClass
    public static void cleanup() throws Exception {
    	//Clean test project skill
    	Assert.isTrue(proxy.deleteSkillByIdOfProjectById(skillId, projectId));
    	
    	//Clean test project feature
    	Assert.isTrue(proxy.deleteFeatureByIdOfProjectById(featureId, projectId));
    	
    	//Clean test project resource
    	Assert.isTrue(proxy.deleteResourceByIdOfProjectById(resourceId, projectId));
    	
    	//Clean test project release
    	Assert.isTrue(proxy.deleteReleaseByIdOfProjectById(releaseId, projectId));
    	
        //Clean test project
    	Assert.isTrue(proxy.deleteProjectById(projectId));
    }

    @Test
    public void testGetAllProjects() throws Exception{
    	List<Project> projects = proxy.getAllProjects();
    	Assert.notNull(projects);
    	Assert.notEmpty(projects);
    }
    
    @Test
    public void testGetProjectById() throws Exception{
    	Project project = proxy.getProjectById(projectId);
    	Assert.notNull(project);
    }
    
    @Test
    public void testGetFeaturesOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	features = proxy.getFeaturesOfProjectById(projectId, FeatureStatus.PENDING);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    }

    @Test
    public void testGetFeatureByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notEmpty(features);
    	
    	Feature feature = proxy.getFeatureByIdOfProjectById(features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testGetReleasesOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    }
    
    @Test
    public void testGetReleaseByIdOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notEmpty(releases);
    	
    	Release release = proxy.getReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
    	Assert.notNull(release);
    }
    
    @Test
    public void testGetFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notEmpty(releases);
    	
    	List<Feature> features = proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
    	Assert.notNull(features);
    }
    
    @Test
    public void testGetPlanOfReleaseByIdOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notEmpty(releases);
    	
    	Plan plan = proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
    	Assert.notNull(plan);
    }
    
//    @Test
//    public void testGetPlanOfReleaseByIdOfTenantById() throws Exception{
//    	
//    	
//    	List<Release> releases = proxy.getReleasesOfProjectById("senercon");
//    	Assert.notEmpty(releases);
//    	
//    	Plan plan = proxy.getPlanOfReleaseByIdOfTenantById(releases.get(0).getId(), "senercon");
//    	Assert.notNull(plan);
//    }
    
//    @Test
//    public void testGetPlanOfReleaseByIdOfTenantByIdForcingNew() throws Exception{
//    	List<Release> releases = proxy.getReleasesOfProjectById("senercon");
//    	Assert.notEmpty(releases);
//    	
//    	Plan plan = proxy.getPlanOfReleaseByIdOfTenantById(releases.get(0).getId(), "senercon", true);
//    	Assert.notNull(plan);
//    }
    
    @Test
    public void testGetSkillsOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    }
    
    @Test
    public void testGetResourcesOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    }
    
    @Test
    public void testCreateAndDeleteProject() throws Exception{
    	Project project = createProject();
    	project = proxy.createProject(project);
    	Assert.notNull(project);
    	Assert.notNull(project.getId());
    	Assert.isTrue(proxy.deleteProjectById(project.getId()));
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

    @Test
    public void testCreateAndDeleteFeatureForProject() throws Exception{
    	Project project = createProject();
    	project = proxy.createProject(project);
    	Assert.notNull(project);
    	Assert.notNull(project.getId());
    	Feature feature = createFeature();
    	feature = proxy.createFeatureOfProjectById(feature, project.getId());
    	Assert.notNull(feature);
    	Assert.notNull(feature.getId());
    	Assert.isTrue(proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
    	Assert.isTrue(proxy.deleteProjectById(project.getId()));
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

	// TODO: create, modify, delete
	@Test
    public void testUpdateProject() throws Exception{
		Project project = createProject();
    	project = proxy.createProject(project);
    	Assert.notNull(project);
    	Assert.notNull(project.getId());
    	project.setDescription(project.getDescription() + " modified by test");
    	project = proxy.updateProject(project);
    	Assert.notNull(project);
    	Assert.isTrue(proxy.deleteProjectById(project.getId()));
    }
    
    @Ignore @Test
    public void testUpdateFeatureOfProjectById() throws Exception{
    	Project project = createProject();
    	project = proxy.createProject(project);
    	Assert.notNull(project);
    	Assert.notNull(project.getId());
    	
    	Feature feature = createFeature();
    	feature = proxy.createFeatureOfProjectById(feature, project.getId());
    	Assert.notNull(feature);
    	Assert.notNull(feature.getId());
    	
    	List<Feature> features = proxy.getFeaturesOfProjectById(project.getId());
    	Assert.notEmpty(features);
    	
    	feature = proxy.getFeatureByIdOfProjectById(features.get(0).getId(), project.getId());
    	Assert.notNull(feature);
    	feature.setDescription(feature.getDescription() + " modified by test");
    	proxy.updateFeatureOfProjectById(feature, projectId);
    	Assert.notNull(feature);
    	
    	Assert.isTrue(proxy.deleteFeatureByIdOfProjectById(feature.getId(), project.getId()));
    	Assert.isTrue(proxy.deleteProjectById(project.getId()));
    }
    
    @Test
    public void testUpdateReleasesOfProjectById() throws Exception{
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	Release release = releases.get(0);
    	String originalDescription = release.getDescription();
    	release.setDescription(release.getDescription() + " modified by test");
    	release = proxy.updateReleaseOfProjectById(release, projectId);
    	Assert.notNull(release);
    	release.setDescription (originalDescription);
    	release = proxy.updateReleaseOfProjectById(release, projectId);
    	Assert.notNull(release);
    }
    
    @Test
    public void testUpdateSkillsOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	Skill skill = skills.get(0);
    	String originalDescription = skill.getDescription();
    	skill.setDescription(skill.getDescription() + " modified by test");
    	skill = proxy.updateSkillOfProjectById(skill, projectId);
    	Assert.notNull(skill);
    	skill.setDescription(originalDescription);
    	skill = proxy.updateSkillOfProjectById(skill, projectId);
    	Assert.notNull(skill);
    }
    
    @Test
    public void testUpdateResourceOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	Resource resource = resources.get(0);
    	String originalDescription = resource.getDescription();
    	resource.setDescription(resource.getDescription() + " modified by test");
    	resource = proxy.updateResourceOfProjectById(resource, projectId);
    	Assert.notNull(resource);
    	resource.setDescription(originalDescription);
    	resource = proxy.updateResourceOfProjectById(resource, projectId);
    	Assert.notNull(resource);
    }
    
    @Test
    public void testAddDeleteSkillsOfFeatureByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notEmpty(features);
    	
    	Feature feature = proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    	
    	feature = proxy.deleteSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testAddDeleteDependenciesOfFeatureByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Feature> dependencies = new ArrayList<>();
    	dependencies.add(features.get(0));
    	Feature feature = proxy.addDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    	
    	feature = proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependencies, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    }
    
//    @Test
//    public void testAddReleaseOfProjectById() throws Exception{
//    	Release release = new Release();
//    	release.setName("Release April 2017");
//    	release.setDescription("M24 Release");
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTime (new Date());
//    	calendar.add(Calendar.DATE, 1);
//    	release.setDeadline(calendar.getTime());
//    	
//    	boolean result = proxy.addReleaseOfProjectById(release, projectId);
//    	Assert.isTrue(result);
//    }
    
    @Test
    public void testAddDeleteResourcesOfReleaseByIdOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Resource> resourcesToAdd = new ArrayList<>();
    	resourcesToAdd.add(resources.get(0));
    	Release release = proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
    	Assert.notNull(release);
    	
    	release = proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
    	Assert.notNull(release);
    }
    
    @Test
    public void testAddDeleteFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Feature> featuresToAdd = new ArrayList<>();
    	featuresToAdd.add(features.get(0));
    	boolean result = proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
    	Assert.isTrue(result);
    	
    	result = proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testAddDeleteSkillOfProjectById() throws Exception{
    	Skill skill = new Skill();
    	skill.setName("Atos test: Swift");
    	skill.setDescription("Atos Test: Swift development of iOS");
    	
    	skill = proxy.addSkillOfProjectById(skill, projectId);
    	Assert.notNull(skill);
    	
    	boolean result = proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testAddDeleteResourceOfProjectById() throws Exception{
    	Resource resource = new Resource();
    	resource.setName("Atos test: Swift Developer");
    	resource.setDescription("Atos Test: Swift developer with experience on iOS 10");
    	resource.setAvailability(80.0);
    	
    	resource = proxy.addResourceOfProjectById(resource, projectId);
    	Assert.notNull(resource);
    	
    	boolean result = proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId);
    	Assert.isTrue(result);
    }
    
    @Test
    public void testAddDeleteSkillsOfResourceByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Skill> skillsToAdd = new ArrayList<>();
    	skillsToAdd.add(skills.get(0));
    	Resource resource = proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
    	Assert.notNull(resource);
    	
    	resource = proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
    	Assert.notNull(resource);
    }
    
    @Test
    public void testDeleteSkillsOfFeatureByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	//GetFeatures of project
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notEmpty (features);
    	
    	Feature feature = proxy.addSkillsOfFeatureByIdOfProjectById(skills, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    	
    	List<Skill> skillsToDelete = new ArrayList<>();
    	skillsToDelete.add(skills.get(0));
    	
    	feature = proxy.deleteSkillsOfFeatureByIdOfProjectById(skillsToDelete, feature.getId(), projectId);
    	Assert.notNull(feature);
    }
    
    @Test
    public void testDeleteDependenciesOfFeatureByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Feature> dependenciesToAdd = new ArrayList<>();
    	dependenciesToAdd.add(features.get(0));
    	
    	Feature feature = proxy.addDependenciesOfFeatureByIdOfProjectById(dependenciesToAdd, features.get(0).getId(), projectId);
    	Assert.notNull(feature);
    	
    	List<Feature> dependenciesToDelete = new ArrayList<>();
    	dependenciesToDelete.add(features.get(0));
    	
    	feature = proxy.deleteDependenciesOfFeatureByIdOfProjectById(dependenciesToDelete, feature.getId(), projectId);
    	Assert.notNull(feature);
    }
    
//    @Test
//    public void testDeleteReleaseByIdOfProjectById() throws Exception{
//    	Release release = new Release();
//    	release.setName("Release April 2017");
//    	release.setDescription("M24 Release");
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTime (new Date());
//    	calendar.add(Calendar.DATE, 1);
//    	release.setDeadline(calendar.getTime());
//    	
//    	boolean result = proxy.addReleaseOfProjectById(release, projectId);
//    	Assert.isTrue(result);
//    	
//    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
//    	release = releases.get(releases.size()-1);
//    	
//    	result = proxy.deleteReleaseByIdOfProjectById(release.getId(), projectId);
//    	Assert.isTrue(result);
//    }
    
    @Test
    public void testDeleteResourcesOfReleaseByIdOfProjectById() throws Exception{
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Resource> resourcesToAdd = new ArrayList<>();
    	resourcesToAdd.add(resources.get(0));
    	Release release = proxy.addResourcesOfReleaseByIdOfProjectById(resourcesToAdd, releases.get(0).getId(), projectId);
    	Assert.notNull(release);
    	
    	List<Resource> resourcesToDelete = new ArrayList<>();
    	resourcesToDelete.add(resources.get(0));
    	
    	release = proxy.deleteResourcesOfReleaseByIdOfProjectById(resourcesToDelete, release.getId(), projectId);
    	Assert.notNull(release);
    }
    
    @Test
    public void testDeleteFeaturesOfReleaseByIdOfProjectById() throws Exception{
    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	
    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
    	Assert.notNull(releases);
    	Assert.notEmpty(releases);
    	
    	List<Feature> featuresToAdd = new ArrayList<>();
    	featuresToAdd.add(features.get(0));
    	boolean result = proxy.addFeaturesOfReleaseByIdOfProjectById(featuresToAdd, releases.get(0).getId(), projectId);
    	Assert.isTrue(result);
    	
    	List<Feature> featuresOfRelease = proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
    	Assert.notNull(features);
    	Assert.notEmpty(features);
    	int numberOfFeaturesOfRelease = featuresOfRelease.size();
    	
    	List<Feature> featuresToDelete = new ArrayList<>();
    	featuresToDelete.add(features.get(0));
    	
    	result = proxy.deleteFeaturesOfReleaseByIdOfProjectById(featuresToDelete, releases.get(0).getId(), projectId);
    	Assert.isTrue(result);
    	
    	featuresOfRelease = proxy.getFeaturesOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
    	Assert.notNull(features);
    	
    	Assert.isTrue(featuresOfRelease.size() == numberOfFeaturesOfRelease - 1);
    }
    
//    @Test
//    public void testCancelLastPlanOfReleaseByIdOfProjectById() throws Exception{
//    	List<Release> releases = proxy.getReleasesOfProjectById(projectId);
//    	Assert.notEmpty(releases);
//    	
//    	Plan plan = proxy.getPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
//    	Assert.notNull(plan);
//    	
//    	Boolean result = proxy.cancelLastPlanOfReleaseByIdOfProjectById(releases.get(0).getId(), projectId);
//    	Assert.isTrue(result);
//    }
    
    @Test
    public void testDeleteSkillOfProjectById() throws Exception{
    	Skill skill = new Skill();
    	skill.setName("Atos test: Swift");
    	skill.setDescription("Atos test: Swift development of iOS");
    	
    	skill = proxy.addSkillOfProjectById(skill, projectId);
    	Assert.notNull(skill);
    	
    	boolean result = proxy.deleteSkillByIdOfProjectById(skill.getId(), projectId);
    	Assert.isTrue(result);
    }
    
    @Test
    public void tesDeleteResourceOfProjectById() throws Exception{
    	Resource resource = new Resource();
    	resource.setName("Atos test: Swift Developer");
    	resource.setDescription("Atos test: Swift developer with experience on iOS 10");
    	resource.setAvailability(80.0);
    	
    	resource = proxy.addResourceOfProjectById(resource, projectId);
    	Assert.notNull(resource);
    	
    	boolean result = proxy.deleteResourceByIdOfProjectById(resource.getId(), projectId);
    	Assert.isTrue(result);
    }
    
    
    @Test
    public void testDelecteSkillsOfResourceByIdOfProjectById() throws Exception{
    	List<Skill> skills = proxy.getSkillsOfProjectById(projectId);
    	Assert.notNull(skills);
    	Assert.notEmpty(skills);
    	
    	List<Resource> resources = proxy.getResourcesOfProjectById(projectId);
    	Assert.notNull(resources);
    	Assert.notEmpty(resources);
    	
    	List<Skill> skillsToAdd = new ArrayList<>();
    	skillsToAdd.add(skills.get(0));
    	Resource resource = proxy.addSkillOfResourceByIdOfProjectById(skillsToAdd, resources.get(0).getId(), projectId);
    	Assert.notNull(resource);
    	
    	List<Skill> skillsToDelete = new ArrayList<>();
    	skillsToDelete.add(skills.get(0));
    	
    	int numberOfSkills = resource.getSkills().size();
    	resource = proxy.deleteSkillsOfResourceByIdOfProjectById(skillsToAdd, resource.getId(), projectId);
    	Assert.notNull(resource);
    	Assert.isTrue(resource.getSkills().size() == numberOfSkills - 1);
    }
    
//    @Ignore
//    @Test
//    public void testAddFeaturesToProjectById() throws Exception{
//    	AddFeaturesForProjectPayload payload = new AddFeaturesForProjectPayload();
//    	payload.setEvaluationTime("2016-10-21");
//    	
//    	int featureId = 1;
//    	
//    	List<Feature> features = proxy.getFeaturesOfProjectById(projectId);
//    	if (!features.isEmpty()){
//    		featureId = features.get(features.size()-1).getId() + 1;
//    	}
//    	
//    	FeatureWP3 feature1 = new FeatureWP3();
//    	feature1.setId(featureId);
//    	feature1.setName("New login form");
//    	feature1.setEffort(5.0);
//    	feature1.setPriority(Priority.FIVE);
//    	
//    	Property property1 = new Property();
//    	property1.setKey("description");
//    	property1.setValue("New login for mobile devices");
//    	property1.setFormat(Format.STRING);
//    	
//    	feature1.getProperties().add(property1);
//    	feature1.setArguments("Some managers have asked for this feature");
//    	
//    	payload.getFeatures().add(feature1);
//    	
//    	FeatureWP3 feature2 = new FeatureWP3();
//    	feature2.setId(++featureId);;
//    	feature2.setName("Welcome page");
//    	feature2.setEffort(23.0);
//    	feature2.setPriority(Priority.TWO);
//    	
//    	Property property2 = new Property();
//    	property2.setKey("deadline");
//    	property2.setValue("2016-12-28");
//    	property2.setFormat(Format.DATETIME);
//    	
//    	feature2.getProperties().add(property2);
//    	
//    	SoftDependency sd = new SoftDependency();
//    	sd.setId(1008);
//    	sd.setType(SoftDependencyType.FUNCTIONAL);
//    	sd.setValue(2.0);
//    	
//    	feature2.getSoftDependencies().add(sd);
//    	
//    	payload.getFeatures().add(feature2);
//    	
//    	FeatureWP3 feature3 = new FeatureWP3();
//    	feature3.setId(++featureId);;
//    	feature3.setName("Mobile version");
//    	feature3.setEffort(45.0);
//    	feature3.setPriority(Priority.TWO);
//    	feature3.getHardDependencies().add(1008);
//    	feature3.getHardDependencies().add(2009);
//    	
//    	payload.getFeatures().add(feature3);
//    	
//    	Constraint cons = new Constraint();
//    	cons.setVariable("deadline");
//    	cons.setOperator("<");
//    	cons.setValue(2017.0);
//    	
//    	payload.getConstraints().add(cons);
//    	
//		proxy.addFeaturesToProjectById(payload, projectId);
//    }
}

