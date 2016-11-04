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
package eu.supersede.integration.api.feedback.proxies;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;

import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.StatusOption;
import eu.supersede.integration.api.feedback.types.ApiUser;
import eu.supersede.integration.api.feedback.types.ApiUserPermission;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackRepositoryProxy <T,S> extends IFServiceProxy<T,S> implements IFeedbackRepository {
	private final static String SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.repository.endpoint");

	@Override
	public String authenticate (String user, String password) throws Exception{
		Assert.hasText(user, "Provide a valid user");
		Assert.hasText(user, "Provide a valid password");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "authenticate");
		JSONObject accountJson = new JSONObject();
		accountJson.put("name", user);
		accountJson.put("password", password);
		return postJSONObjectAndReturnValueForJsonLabel(accountJson.toString(), uri, HttpStatus.CREATED, "token");
	}
	
	@Override
	public List<Feedback> listAllFeedbacksForApplication(Integer idApplication, String token) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/feedbacks");
		return getJSONObjectsListForType(Feedback[].class, uri, HttpStatus.OK, token);
	}

	
	@Override
	public Feedback getFeedbackForApplication(Integer idFeedback, Integer idApplication, String token) throws Exception {
		Assert.notNull(idFeedback, "Provide a valid feedback id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/feedbacks/" + idFeedback);
		return getJSONObjectForType(Feedback.class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public byte[] downloadAttachement(String attachmentName, String token) throws Exception {
		Assert.notNull(attachmentName, "Provide a valid attachment name");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "attachments/" + attachmentName);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}

	@Override
	public byte[] downloadScreenshot(String screenshotName, String token, boolean base64) throws Exception {
		Assert.notNull(screenshotName, "Provide a valid screenshot name");
		Assert.notNull(token, "Provide a valid token");
		String suri = SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "screenshots/" + screenshotName;
		if (base64) suri += "/base64";
		URI uri = new URI(suri);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}

	@Override
	public byte[] downloadAudio(String audioName, String token) throws Exception {
		Assert.notNull(audioName, "Provide a valid audio name");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "audios/" + audioName);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}
	
	@Override
	public Feedback createFeedbackForApplication(Feedback feedback, 
			Map<String, Path> attachmentsPaths, Map<String, Path> screenshotsPaths, 
			Map<String, Path> audiosPaths, Integer idApplication, String token) throws Exception {
		Assert.notNull(feedback, "Provide a valid feedback");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		Assert.notNull(attachmentsPaths, "Provide valid attachments");
		Assert.notNull(screenshotsPaths, "Provide valid screenshots");
		Assert.notNull(audiosPaths, "Provide valid audios");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/feedbacks");
		
		LinkedMultiValueMap<String, Object> parts = 
		          new LinkedMultiValueMap<String, Object>();
		
		parts.add("json", convertToJSON (feedback));
		
		for (String key: attachmentsPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(attachmentsPaths.get(key))));
		}
	
		for (String key: screenshotsPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(screenshotsPaths.get(key))));
		}
		
		for (String key: audiosPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(audiosPaths.get(key))));
		}
		
		return sendMultipartFormDataMessage(uri, Feedback.class, parts, HttpMethod.POST);
	}

	@Override
	public List<ApiUser> listAllAPIUsers() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users");
		return getJSONObjectsListForType(ApiUser[].class, uri, HttpStatus.OK);
	}

	@Override
	public ApiUser createAPIUser(ApiUser user) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users");
		return insertandReturnJSONObject(user, uri, HttpStatus.CREATED);
	}

	@Override
	public ApiUser updateAPIUser(ApiUser user, String token) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users");
		return updateJSONObject(user, uri, HttpStatus.OK, token);
	}

	@Override
	public ApiUser getAPIUser(Integer userId) throws Exception {
		Assert.notNull(userId, "Provide a valid api user id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users/" + userId);
		return getJSONObjectForType(ApiUser.class, uri, HttpStatus.OK);
	}

	@Override
	public void deleteAPIUser(Integer userId, String token) throws Exception {
		Assert.notNull(userId, "Provide a valid api user id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users/" + userId);
		deleteUriResource(uri, HttpStatus.OK, token);		
	}

	@Override
	public List<ApiUserPermission> listApplicationPermissionsOfApiUser(Integer userId) throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users/" + userId + "/permissions");
		return getJSONObjectsListForType(ApiUserPermission[].class, uri, HttpStatus.OK);
	}

	@Override
	public ApiUserPermission createApplicationPermissionOfApiUser(ApiUserPermission permission, Integer userId, String token)
			throws Exception {
		Assert.notNull(permission, "Provide a valid user permission");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users/" + userId + "/permissions");
		return insertandReturnJSONObject(permission, uri, HttpStatus.CREATED, token);
	}

	@Override
	public void deleteApplicationPermissionsOfApiUser(Integer permissionId, Integer userId) throws Exception {
		Assert.notNull(permissionId, "Provide a valid api user permission id");
		Assert.notNull(userId, "Provide a valid api user id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/api_users/" + userId + "/permissions/" + permissionId);
		deleteUriResource(uri, HttpStatus.OK);	
	}

	@Override
	public Status getGeneralStatusOfFeedbackInApplication(Integer idFeedback, Integer idApplication, String token) throws Exception {
		Assert.notNull(idFeedback, "Provide a valid feedback id");
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/feedbacks/" + idFeedback + "/status");
		return getJSONObjectForType(Status.class, uri, HttpStatus.OK, token);
	}

	@Override
	public Status getUserSpecificStatusOfFeedbackInApplication(Integer idFeedback, Integer idApplication, Integer idUser, String token)
			throws Exception {
		Assert.notNull(idFeedback, "Provide a valid feedback id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUser, "Provide a valid user id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/feedbacks/" + idFeedback + "/api_users/" + idUser + "/status");
		return getJSONObjectForType(Status.class, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Status> listAllUserSpecificStatusOfFeedbackInApplication(Integer idApplication, Integer idUser, String token)
			throws Exception {
		Assert.notNull(idUser, "Provide a valid user id");
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/api_users/" + idUser + "/states");
		return getJSONObjectsListForType(Status[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public void deleteFeedbackStatusInApplication(Integer idApplication, Integer idStatus, String token) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idStatus, "Provide a valid status id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/states/" + idStatus);
		deleteUriResource(uri, HttpStatus.OK, token);	
	}

	@Override
	public Status updateFeedbackStatusInApplication(Status status, Integer idApplication, String token) throws Exception {
		Assert.notNull(status, "Provide a valid status");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + idApplication + "/states");
		return updateJSONObject(status, uri, HttpStatus.OK, token);
	}

	@Override
	public List<StatusOption> listAllStatusOptions() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/status_options");
		return getJSONObjectsListForType(StatusOption[].class, uri, HttpStatus.OK);
	}

	@Override
	public StatusOption createStatusOption(StatusOption statusOption, String token) throws Exception {
		Assert.notNull(statusOption, "Provide a valid status option");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/status_options");
		return insertandReturnJSONObject(statusOption, uri, HttpStatus.CREATED, token);
	}

	@Override
	public StatusOption updateStatusOption(StatusOption statusOption, String token) throws Exception {
		Assert.notNull(statusOption, "Provide a valid status option");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/status_options");
		return updateJSONObject(statusOption, uri, HttpStatus.OK, token);
	}

	@Override
	public void deleteStatusOption(Integer idStatusOption, String token) throws Exception {
		Assert.notNull(idStatusOption, "Provide a valid status option id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/status_options/" + idStatusOption);
		deleteUriResource(uri, HttpStatus.OK, token);	
	}
}
