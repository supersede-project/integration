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
package eu.supersede.integration.api.replan.controller.proxies;

import java.util.List;

import eu.supersede.integration.api.replan.controller.exception.ReplanControllerException;
import eu.supersede.integration.api.replan.controller.types.AddFeaturesForProjectPayload;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;

public interface IReplanController {
	List<Project> getAllProjects() throws Exception;
	// APIs with projectId
	Project getProjectById(int projectId) throws Exception;
	Project createProject(Project project) throws Exception;
	Project updateProject(Project project) throws Exception;
	boolean deleteProjectById(int projectId) throws Exception;
	List<Feature> getFeaturesOfProjectById (int projectId) throws Exception;
	List<Feature> getFeaturesOfProjectById (int projectId, FeatureStatus status) throws Exception;
	Feature getFeatureByIdOfProjectById(int featureId, int projectId) throws Exception;
	List<Release> getReleasesOfProjectById(int projectId) throws Exception;
	Release getReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception;
	List<Feature> getFeaturesOfReleaseByIdOfProjectById(int featureId, int projectId) throws Exception;
	Plan getPlanOfReleaseByIdOfProjectById(int featureId, int projectId) throws Exception;
	List<Skill> getSkillsOfProjectById(int projectId) throws Exception;
	List<Resource> getResourcesOfProjectById(int projectId) throws Exception;
	Feature createFeatureOfProjectById(Feature feature, int projectId) throws Exception;
	Feature updateFeatureOfProjectById(Feature feature, int projectId) throws Exception;
	boolean deleteFeatureByIdOfProjectById(int featureId, int projectId) throws Exception;
	Release updateReleaseOfProjectById(Release release, int projectId) throws Exception;
	Skill updateSkillOfProjectById(Skill skill, int projectId) throws Exception;
	Resource updateResourceOfProjectById(Resource resource, int projectId) throws Exception;
	Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception;
	Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId)
			throws Exception;
	boolean addReleaseOfProjectById(Release release, int projectId) throws Exception;
	Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId)
			throws Exception;
	boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId)
			throws Exception;
	Skill addSkillOfProjectById(Skill skill, int projectId) throws Exception;
	Resource addResourceOfProjectById(Resource resource, int projectId) throws Exception;
	Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception;
	Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception;
	Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId)
			throws Exception;
	boolean deleteReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception;
	Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId)
			throws Exception;
	boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId)
			throws Exception;
	boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception;
	boolean deleteSkillByIdOfProjectById(int skillId, int projectId) throws Exception;
	boolean deleteResourceByIdOfProjectById(int resourceId, int projectId) throws Exception;
	Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception;
	boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, int projectId) throws ReplanControllerException;
	
	// APIs with tenantId
	Project getProjectById(String tenantId) throws Exception;
	boolean deleteProjectById(String tenantId) throws Exception;
	List<Feature> getFeaturesOfProjectById (String tenantId) throws Exception;
	List<Feature> getFeaturesOfProjectById (String tenantId, FeatureStatus status) throws Exception;
	Feature getFeatureByIdOfProjectById(int featureId, String tenantId) throws Exception;
	List<Release> getReleasesOfProjectById(String tenantId) throws Exception;
	Release getReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception;
	List<Feature> getFeaturesOfReleaseByIdOfProjectById(int featureId, String tenantId) throws Exception;
	Plan getPlanOfReleaseByIdOfTenantById(int featureId, String tenantId) throws Exception;
	Plan getPlanOfReleaseByIdOfTenantById(int releaseId, String tenantId, Boolean forceNew) throws Exception; 
	List<Skill> getSkillsOfProjectById(String tenantId) throws Exception;
	List<Resource> getResourcesOfProjectById(String tenantId) throws Exception;
	Feature createFeatureOfProjectById(Feature feature, String tenantId) throws Exception;
	Feature updateFeatureOfProjectById(Feature feature, String tenantId) throws Exception;
	boolean deleteFeatureByIdOfProjectById(int featureId, String tenantId) throws Exception;
	Release updateReleaseOfProjectById(Release release, String tenantId) throws Exception;
	Skill updateSkillOfProjectById(Skill skill, String tenantId) throws Exception;
	Resource updateResourceOfProjectById(Resource resource, String tenantId) throws Exception;
	Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, String tenantId) throws Exception;
	Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, String tenantId)
			throws Exception;
	boolean addReleaseOfProjectById(Release release, String tenantId) throws Exception;
	Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, String tenantId)
			throws Exception;
	boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, String tenantId)
			throws Exception;
	Skill addSkillOfProjectById(Skill skill, String tenantId) throws Exception;
	Resource addResourceOfProjectById(Resource resource, String tenantId) throws Exception;
	Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, String tenantId) throws Exception;
	Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, String tenantId) throws Exception;
	Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, String tenantId)
			throws Exception;
	boolean deleteReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception;
	Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, String tenantId)
			throws Exception;
	boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, String tenantId)
			throws Exception;
	boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception;
	boolean deleteSkillByIdOfProjectById(int skillId, String tenantId) throws Exception;
	boolean deleteResourceByIdOfProjectById(int resourceId, String tenantId) throws Exception;
	Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, String tenantId) throws Exception;
	boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, String tenantId) throws ReplanControllerException;
}

