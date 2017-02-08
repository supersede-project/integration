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
import org.springframework.http.HttpStatus;
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
	private final static String SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT = 
			IntegrationProperty.getProperty("replan_controller.endpoint");


	@Override
	public Project getProjectById(int projectId) throws Exception{
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId);
		return getJSONObjectForType(Project.class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features");
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Feature> getFeaturesOfProjectById(int projectId, FeatureStatus status) throws Exception {
		String suri = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features";
		if (status != null)
			suri += "?status=" + status;
		URI uri = new URI(suri);
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature getFeatureByIdOfProjectById(int featureId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId);
		return getJSONObjectForType(Feature.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Release> getReleasesOfProjectById(int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases");
		return getJSONObjectsListForType(Release[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Feature> getFeaturesOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features");
		return getJSONObjectsListForType(Feature[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Plan getPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/plan");
		return getJSONObjectForType(Plan.class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<Skill> getSkillsOfProjectById(int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills");
		return getJSONObjectsListForType(Skill[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<Resource> getResourcesOfProjectById(int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources");
		return getJSONObjectsListForType(Resource[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Project updateProject(Project project) throws Exception{
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + project.getId());
		return updateAndReturnJSONObject(project, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature updateFeatureOfProjectById(Feature feature, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + feature.getId());
		return updateAndReturnJSONObject(feature, uri, HttpStatus.OK);
	}
	
	@Override
	public Release updateReleaseOfProjectById(Release release, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + release.getId());
		return updateAndReturnJSONObject(release, uri, HttpStatus.OK);
	}
	
	@Override
	public Skill updateSkillOfProjectById(Skill skill, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills/" + skill.getId());
		return updateAndReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource updateResourceOfProjectById(Resource resource, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resource.getId());
		return updateAndReturnJSONObject(resource, uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/skills");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		
		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature addDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/dependencies");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");

		return postJSONStringForReturnType(Feature.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addReleaseOfProjectById(Release release, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases");
		
		return insertJSONObject(release, uri, HttpStatus.ACCEPTED);
	}
	
	@Override
	public Release addResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/resources");
		JSONArray jsonArray = createJSONArrayOfIdentifiers(resources, "resource_id");

		return postJSONStringForReturnType(Release.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features");
		
		JSONArray jsonArray = createJSONArrayOfIdentifiers(features, "feature_id");
		
		return postJSONString(jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Skill addSkillOfProjectById(Skill skill, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills");
		
		return insertandReturnJSONObject(skill, uri, HttpStatus.OK);
	}
	
	@Override
	public Resource addResourceOfProjectById(Resource resource, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources");
		
		return insertandReturnJSONObject(resource, uri, HttpStatus.OK);
	}

	@Override
	public Resource addSkillOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception {
		URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId + "/skills");
		
		JSONArray jsonArray = createJSONArrayOfIdentifiers(skills, "skill_id");
		
		return postJSONStringForReturnType(Resource.class, jsonArray.toString(), uri, HttpStatus.OK);
	}
	
	@Override
	public Feature deleteSkillsOfFeatureByIdOfProjectById(List<Skill> skills, int featureId, int projectId) throws Exception {
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skill_id");

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public Feature deleteDependenciesOfFeatureByIdOfProjectById(List<Feature> features, int featureId, int projectId) throws Exception {
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/" + featureId + "/dependencies?";
		uriString = addURIQueryArray(uriString, features, "feature_id");

		return deleteUriResourceForReturnType(Feature.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean deleteReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId);
		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Release deleteResourcesOfReleaseByIdOfProjectById(List<Resource> resources, int releaseId, int projectId) throws Exception {
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/resources?";
		uriString = addURIQueryArray(uriString, resources, "ResourceId");

		return deleteUriResourceForReturnType(Release.class, new URI(uriString), HttpStatus.OK);
	}
	
	
	@Override
	public boolean deleteFeaturesOfReleaseByIdOfProjectById(List<Feature> features, int releaseId, int projectId) throws Exception {
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/features?";
		uriString = addURIQueryArray(uriString, features, "featureId");

		return deleteUriResource(new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean cancelLastPlanOfReleaseByIdOfProjectById(int releaseId, int projectId) throws Exception {
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/releases/" + releaseId + "/plan");

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteSkillByIdOfProjectById(int skillId, int projectId) throws Exception {
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/skills/" + skillId);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public boolean deleteResourceByIdOfProjectById(int resourceId, int projectId) throws Exception {
		URI uri = new URI (SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId);

		return deleteUriResource(uri, HttpStatus.OK);
	}
	
	@Override
	public Resource deleteSkillsOfResourceByIdOfProjectById(List<Skill> skills, int resourceId, int projectId) throws Exception {
		String uriString = SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/resources/" + resourceId + "/skills?";
		uriString = addURIQueryArray(uriString, skills, "skillId");

		return deleteUriResourceForReturnType(Resource.class, new URI(uriString), HttpStatus.OK);
	}
	
	@Override
	public boolean addFeaturesToProjectById(AddFeaturesForProjectPayload payload, int projectId) throws Exception {
		boolean result = false;
		try {
			URI uri = new URI(SUPERSEDE_REPLAN_CONTROLLER_ENDPOINT + "projects/" + projectId + "/features/");
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
}
