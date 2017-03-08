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

import java.net.URI;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.api.replan.controller.exception.ReplanControllerDuplicatedIdException;
import eu.supersede.integration.api.replan.controller.exception.ReplanControllerException;
import eu.supersede.integration.api.replan.controller.types.AddFeaturesForProjectPayload;
import eu.supersede.integration.api.replan.controller.types.Feature;
import eu.supersede.integration.api.replan.controller.types.FeatureStatus;
import eu.supersede.integration.api.replan.controller.types.Plan;
import eu.supersede.integration.api.replan.controller.types.Project;
import eu.supersede.integration.api.replan.controller.types.Release;
import eu.supersede.integration.api.replan.controller.types.ReplanIdentifiableObject;
import eu.supersede.integration.api.replan.controller.types.Resource;
import eu.supersede.integration.api.replan.controller.types.Skill;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class ReplanControllerProxy <T, S> extends IFServiceProxy<T, S> implements IReplanController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT = 
			IntegrationProperty.getProperty("replan_controller.endpoint");


	//Methods with int projectId
	
	@Override
	public Project getProjectById(int projectId) throws Exception{
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId);
		log.debug("Sending message getProjectById with projectId: " + projectId 
			+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Project.class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(int projectId) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features");
		log.debug("Sending message getFeaturesOfProjectById with projectId: " + projectId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(int projectId, FeatureStatus status) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		Assert.notNull(status, "Provide a valid status");
		String suri = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features";
		if (status != null)
			suri += "?status=" + status;
		URI uri = new URI(suri);
		log.debug("Sending message getFeaturesOfProjectById with projectId: " + projectId 
				+ " with status: " + status
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature getFeatureByIdOfProjectById(int featureId, int projectId) throws Exception {
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId);
		log.debug("Sending message getFeatureByIdOfProjectById with featureId: " + featureId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Feature.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Release> getReleasesOfProjectById(int projectId) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases");
		log.debug("Sending message getReleasesOfProjectById with projectId: " + projectId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Release[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Feature> getFeaturesOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features");
		log.debug("Sending message getFeaturesOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Plan getPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/plan");
		log.debug("Sending message getPlanOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Plan.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Skill> getSkillsOfProjectById(int projectId) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills");
		log.debug("Sending message getSkillsOfProjectById with projectId: " + projectId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Skill[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Resource> getResourcesOfProjectById(int projectId) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources");
		log.debug("Sending message getResourcesOfProjectById with projectId: " + projectId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Resource[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Project updateProject(Project project) throws Exception{
		Assert.notNull(project, "Provide a valid project");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + project.getId());
		log.debug("Sending message updateProject with project: " + project 
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(project, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature updateFeatureOfProjectById(Feature feature, int projectId) throws Exception {
		Assert.notNull(feature, "Provide a valid feature");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + feature.getId());
		log.debug("Sending message updateFeatureOfProjectById with feature: " + feature 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(feature, uri, HttpStatus.OK);
	}
	
	@Override
	public Release updateReleaseOfProjectById(Release release, int projectId) throws Exception {
		Assert.notNull(release, "Provide a valid release");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + release.getId());
		log.debug("Sending message updateReleaseOfProjectById with release: " + release 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(release, uri, HttpStatus.OK);
	}
	
	@Override
	public Skill updateSkillOfProjectById(Skill skill, int projectId) throws Exception {
		Assert.notNull(skill, "Provide a valid skill");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills/" + skill.getId());
		log.debug("Sending message updateSkillOfProjectById with skill: " + skill 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource updateResourceOfProjectById(Resource resource, int projectId) throws Exception {
		Assert.notNull(resource, "Provide a valid resource");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resource.getId());
		log.debug("Sending message updateResourceOfProjectById with resource: " + resource 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(resource, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/skills");
		log.debug("Sending message addSkillsOfFeatureByIdOfProjectById with skills: " + skills 
				+ " with featureId: " + featureId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		
		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/dependencies");
		log.debug("Sending message addDependenciesOfFeatureByIdOfProjectById with features: " + features 
				+ " with featureId: " + featureId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");

		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addReleaseOfProjectById(Release release, int projectId) throws Exception {
		Assert.notNull(release, "Provide a valid release");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases");
		log.debug("Sending message addReleaseOfProjectById with release: " + release 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return insertJSONObject(release, uri, HttpStatus.ACCEPTED);
	}
	
	@Override
	public Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId) throws Exception {
		Assert.notEmpty(resources, "Provide a not-empty list of resources");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/resources");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(resources, "resource_id");
		log.debug("Sending message addResourcesOfReleaseByIdOfProjectById with resources: " + resources 
				+ " with releaseId: " + releaseId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return postJSONStringForReturnType(Release.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");
		log.debug("Sending message addFeaturesOfReleaseByIdOfProjectById with resources: " + features 
				+ " with releaseId: " + releaseId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return postJSONString(jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Skill addSkillOfProjectById(Skill skill, int projectId) throws Exception {
		Assert.notNull(skill, "Provide a valid skill");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills");
		log.debug("Sending message addSkillOfProjectById with skill: " + skill 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return insertandReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource addResourceOfProjectById(Resource resource, int projectId) throws Exception {
		Assert.notNull(resource, "Provide a valid resource");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources");
		log.debug("Sending message addSkillOfProjectById with resource: " + resource 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return insertandReturnJSONObject(resource, uri, HttpStatus.OK);
	}

	@Override
	public Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId + "/skills");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		log.debug("Sending message addSkillOfResourceByIdOfProjectById with skills: " + skills 
				+ " with resourceId: " + resourceId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return postJSONStringForReturnType(Resource.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skill_id");
		log.debug("Sending message deleteSkillsOfFeatureByIdOfProjectById with skills: " + skills 
				+ " with featureId: " + featureId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/dependencies?";
		uriString = addURIQueryArray(uriString, features, "feature_id");
		log.debug("Sending message deleteDependenciesOfFeatureByIdOfProjectById with features: " + features 
				+ " with featureId: " + featureId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean deleteReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId);
		log.debug("Sending message deleteReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		
		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId) throws Exception {
		Assert.notEmpty(resources, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/resources?";
		uriString = addURIQueryArray(uriString, resources, "ResourceId");
		log.debug("Sending message deleteResourcesOfReleaseByIdOfProjectById with resources: " + resources 
				+ " with releaseId: " + releaseId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Release.class, new URI(uriString), HttpStatus.OK);
	}
	
	
	@Override
	public boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features?";
		uriString = addURIQueryArray(uriString, features, "featureId");
		log.debug("Sending message deleteFeaturesOfReleaseByIdOfProjectById with features: " + features 
				+ " with releaseId: " + releaseId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResource(new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/plan");
		log.debug("Sending message cancelLastPlanOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteSkillByIdOfProjectById(int skillId, int projectId) throws Exception {
		Assert.notNull(skillId, "Provide a valid skillId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills/" + skillId);
		log.debug("Sending message deleteSkillByIdOfProjectById with skillId: " + skillId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteResourceByIdOfProjectById(int resourceId, int projectId) throws Exception {
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId);
		log.debug("Sending message deleteResourceByIdOfProjectById with resourceId: " + resourceId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(projectId, "Provide a valid projectId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skillId");
		log.debug("Sending message deleteSkillsOfResourceByIdOfProjectById with skills: " + skills 
				+ " with resourceId: " + resourceId
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Resource.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, int projectId) throws ReplanControllerException {
		boolean result = false;
		Assert.notNull(payload, "Provide a valid payload");
		Assert.notNull(projectId, "Provide a valid projectId");
		try {
			URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/");
			log.debug("Sending message addFeaturesToProjectById with payload: " + payload 
					+ " with projectId: " + projectId
					+ " to ReplanController at uri " + uri);
			result = postJSONObject(payload, uri, HttpStatus.OK);
		} catch (Exception e) {
			if (e.getMessage().contains("Already exists features"))
				throw new  ReplanControllerDuplicatedIdException (e.getMessage());
			else
				throw new ReplanControllerException (e.getMessage());
		}
		return result;
	}
	
	private <T extends ReplanIdentifiableObject> String addURIQueryArray (String uriString, List<T> tokens, String idLabel){
		boolean queryStarted = false;
		for (T token: tokens){
			if (queryStarted){
				uriString = uriString + "&";
			}
			uriString = uriString + idLabel + "[]=" + token.getId();
			queryStarted = true;
		}
		
		return uriString;
	}
	
	private <T extends ReplanIdentifiableObject> JSONArray createJSONArrayOfIdentifiers (List<T> tokens, String idLabel){
		JSONArray jsonArray = new JSONArray();
		for (T token : tokens) {
			JSONObject jsonItem = new JSONObject();
			jsonItem.put(idLabel, token.getId());
			jsonArray.put(jsonItem);
		}
		
		return jsonArray;
	}

	@Override
	public Release getReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId);
		return getJSONObjectForType(Release.class, uri, HttpStatus.OK);
	}

	@Override
	public List<Project> getAllProjects() throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects");
		log.debug("Sending message getAllProjects to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Project[].class, uri, HttpStatus.OK);
	}

	@Override
	public Project createProject(Project project) throws Exception {
		Assert.notNull(project, "Provide a valid project");
		Assert.isTrue(project.getResources()==null ||  project.getResources().isEmpty(), "Features are not accepted in new created projects");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects");
		log.debug("Sending message createProject with project: " + project 
				+ " to ReplanController at uri " + uri);
		return insertandReturnJSONObject(project, uri, HttpStatus.OK);
	}

	@Override
	public boolean deleteProjectById(int projectId) throws Exception {
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId);
		log.debug("Sending message deleteProjectById with projectId: " + projectId 
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}

	@Override
	public Feature createFeatureOfProjectById(Feature feature, int projectId) throws Exception {
		Assert.notNull(feature, "Provide a valid feature");
		Assert.notNull(projectId, "Provide a valid projectId");
		Assert.isTrue(feature.getRequiredSkills()==null ||  feature.getRequiredSkills().isEmpty(), "Required Skills are not accepted in new created features");
		Assert.isTrue(feature.getDependencies()==null ||  feature.getDependencies().isEmpty(), "Dependencies are not accepted in new created features");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/create_one");
		log.debug("Sending message createFeatureOfProjectById with feature: " + feature 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);
		return insertandReturnJSONObject(feature, uri, HttpStatus.OK);
	}

	@Override
	public boolean deleteFeatureByIdOfProjectById(int featureId, int projectId) throws Exception {
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(projectId, "Provide a valid projectId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId);
		log.debug("Sending message deleteFeatureByIdOfProjectById with featureId: " + featureId 
				+ " with projectId: " + projectId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}


	// Methods with String tenantId
	//Methods with int projectId
	
	@Override
	public Project getProjectById(String tenantId) throws Exception{
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId);
		log.debug("Sending message getProjectById with tenantId: " + tenantId 
			+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Project.class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(String tenantId) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features");
		log.debug("Sending message getFeaturesOfProjectById with tenantId: " + tenantId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(String tenantId, FeatureStatus status) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		Assert.notNull(status, "Provide a valid status");
		String suri = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features";
		if (status != null)
			suri += "?status=" + status;
		URI uri = new URI(suri);
		log.debug("Sending message getFeaturesOfProjectById with tenantId: " + tenantId 
				+ " with status: " + status
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature getFeatureByIdOfProjectById(int featureId, String tenantId) throws Exception {
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId);
		log.debug("Sending message getFeatureByIdOfProjectById with featureId: " + featureId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Feature.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Release> getReleasesOfProjectById(String tenantId) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases");
		log.debug("Sending message getReleasesOfProjectById with tenantId: " + tenantId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Release[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Feature> getFeaturesOfReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/features");
		log.debug("Sending message getFeaturesOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Plan getPlanOfReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/plan");
		log.debug("Sending message getPlanOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return getJSONObjectForType(Plan.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Skill> getSkillsOfProjectById(String tenantId) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/skills");
		log.debug("Sending message getSkillsOfProjectById with tenantId: " + tenantId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Skill[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Resource> getResourcesOfProjectById(String tenantId) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources");
		log.debug("Sending message getResourcesOfProjectById with tenantId: " + tenantId 
				+ " to ReplanController at uri " + uri);
		return getJSONObjectsListForType(Resource[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature updateFeatureOfProjectById(Feature feature, String tenantId) throws Exception {
		Assert.notNull(feature, "Provide a valid feature");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + feature.getId());
		log.debug("Sending message updateFeatureOfProjectById with feature: " + feature 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(feature, uri, HttpStatus.OK);
	}
	
	@Override
	public Release updateReleaseOfProjectById(Release release, String tenantId) throws Exception {
		Assert.notNull(release, "Provide a valid release");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + release.getId());
		log.debug("Sending message updateReleaseOfProjectById with release: " + release 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(release, uri, HttpStatus.OK);
	}
	
	@Override
	public Skill updateSkillOfProjectById(Skill skill, String tenantId) throws Exception {
		Assert.notNull(skill, "Provide a valid skill");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/skills/" + skill.getId());
		log.debug("Sending message updateSkillOfProjectById with skill: " + skill 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource updateResourceOfProjectById(Resource resource, String tenantId) throws Exception {
		Assert.notNull(resource, "Provide a valid resource");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources/" + resource.getId());
		log.debug("Sending message updateResourceOfProjectById with resource: " + resource 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return updateAndReturnJSONObject(resource, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, String tenantId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId + "/skills");
		log.debug("Sending message addSkillsOfFeatureByIdOfProjectById with skills: " + skills 
				+ " with featureId: " + featureId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		
		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, String tenantId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId + "/dependencies");
		log.debug("Sending message addDependenciesOfFeatureByIdOfProjectById with features: " + features 
				+ " with featureId: " + featureId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");

		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addReleaseOfProjectById(Release release, String tenantId) throws Exception {
		Assert.notNull(release, "Provide a valid release");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases");
		log.debug("Sending message addReleaseOfProjectById with release: " + release 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return insertJSONObject(release, uri, HttpStatus.ACCEPTED);
	}
	
	@Override
	public Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, String tenantId) throws Exception {
		Assert.notEmpty(resources, "Provide a not-empty list of resources");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/resources");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(resources, "resource_id");
		log.debug("Sending message addResourcesOfReleaseByIdOfProjectById with resources: " + resources 
				+ " with releaseId: " + releaseId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return postJSONStringForReturnType(Release.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, String tenantId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/features");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");
		log.debug("Sending message addFeaturesOfReleaseByIdOfProjectById with resources: " + features 
				+ " with releaseId: " + releaseId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return postJSONString(jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Skill addSkillOfProjectById(Skill skill, String tenantId) throws Exception {
		Assert.notNull(skill, "Provide a valid skill");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/skills");
		log.debug("Sending message addSkillOfProjectById with skill: " + skill 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return insertandReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource addResourceOfProjectById(Resource resource, String tenantId) throws Exception {
		Assert.notNull(resource, "Provide a valid resource");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources");
		log.debug("Sending message addSkillOfProjectById with resource: " + resource 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return insertandReturnJSONObject(resource, uri, HttpStatus.OK);
	}

	@Override
	public Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, String tenantId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources/" + resourceId + "/skills");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		log.debug("Sending message addSkillOfResourceByIdOfProjectById with skills: " + skills 
				+ " with resourceId: " + resourceId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return postJSONStringForReturnType(Resource.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, String tenantId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skill_id");
		log.debug("Sending message deleteSkillsOfFeatureByIdOfProjectById with skills: " + skills 
				+ " with featureId: " + featureId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, String tenantId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId + "/dependencies?";
		uriString = addURIQueryArray(uriString, features, "feature_id");
		log.debug("Sending message deleteDependenciesOfFeatureByIdOfProjectById with features: " + features 
				+ " with featureId: " + featureId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean deleteReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId);
		log.debug("Sending message deleteReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		
		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, String tenantId) throws Exception {
		Assert.notEmpty(resources, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/resources?";
		uriString = addURIQueryArray(uriString, resources, "ResourceId");
		log.debug("Sending message deleteResourcesOfReleaseByIdOfProjectById with resources: " + resources 
				+ " with releaseId: " + releaseId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Release.class, new URI(uriString), HttpStatus.OK);
	}
	
	
	@Override
	public boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, String tenantId) throws Exception {
		Assert.notEmpty(features, "Provide a not-empty list of features");
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/features?";
		uriString = addURIQueryArray(uriString, features, "featureId");
		log.debug("Sending message deleteFeaturesOfReleaseByIdOfProjectById with features: " + features 
				+ " with releaseId: " + releaseId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResource(new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception {
		Assert.notNull(releaseId, "Provide a valid releaseId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId + "/plan");
		log.debug("Sending message cancelLastPlanOfReleaseByIdOfProjectById with releaseId: " + releaseId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteSkillByIdOfProjectById(int skillId, String tenantId) throws Exception {
		Assert.notNull(skillId, "Provide a valid skillId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/skills/" + skillId);
		log.debug("Sending message deleteSkillByIdOfProjectById with skillId: " + skillId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteResourceByIdOfProjectById(int resourceId, String tenantId) throws Exception {
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources/" + resourceId);
		log.debug("Sending message deleteResourceByIdOfProjectById with resourceId: " + resourceId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, String tenantId) throws Exception {
		Assert.notEmpty(skills, "Provide a not-empty list of skills");
		Assert.notNull(resourceId, "Provide a valid resourceId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/resources/" + resourceId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skillId");
		log.debug("Sending message deleteSkillsOfResourceByIdOfProjectById with skills: " + skills 
				+ " with resourceId: " + resourceId
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uriString);

		return deleteUriResourceForReturnType(Resource.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, String tenantId) throws ReplanControllerException {
		boolean result = false;
		Assert.notNull(payload, "Provide a valid payload");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		try {
			URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/");
			log.debug("Sending message addFeaturesToProjectById with payload: " + payload 
					+ " with tenantId: " + tenantId
					+ " to ReplanController at uri " + uri);
			result = postJSONObject(payload, uri, HttpStatus.OK);
		} catch (Exception e) {
			if (e.getMessage().contains("Already exists features"))
				throw new  ReplanControllerDuplicatedIdException (e.getMessage());
			else
				throw new ReplanControllerException (e.getMessage());
		}
		return result;
	}

	@Override
	public Release getReleaseByIdOfProjectById(int releaseId, String tenantId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/releases/" + releaseId);
		return getJSONObjectForType(Release.class, uri, HttpStatus.OK);
	}

	@Override
	public boolean deleteProjectById(String tenantId) throws Exception {
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId);
		log.debug("Sending message deleteProjectById with tenantId: " + tenantId 
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}

	@Override
	public Feature createFeatureOfProjectById(Feature feature, String tenantId) throws Exception {
		Assert.notNull(feature, "Provide a valid feature");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		Assert.isTrue(feature.getRequiredSkills()==null ||  feature.getRequiredSkills().isEmpty(), "Required Skills are not accepted in new created features");
		Assert.isTrue(feature.getDependencies()==null ||  feature.getDependencies().isEmpty(), "Dependencies are not accepted in new created features");
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/create_one");
		log.debug("Sending message createFeatureOfProjectById with feature: " + feature 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);
		return insertandReturnJSONObject(feature, uri, HttpStatus.OK);
	}

	@Override
	public boolean deleteFeatureByIdOfProjectById(int featureId, String tenantId) throws Exception {
		Assert.notNull(featureId, "Provide a valid featureId");
		Assert.notNull(tenantId, "Provide a valid tenantId");
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + tenantId + "/features/" + featureId);
		log.debug("Sending message deleteFeatureByIdOfProjectById with featureId: " + featureId 
				+ " with tenantId: " + tenantId
				+ " to ReplanController at uri " + uri);

		return deleteUriResource(uri, HttpStatus.OK);
	}

}
