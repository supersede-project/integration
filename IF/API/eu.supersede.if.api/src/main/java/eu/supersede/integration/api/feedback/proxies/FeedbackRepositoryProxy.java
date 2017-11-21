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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;

import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.feedback.repository.types.Status;
import eu.supersede.integration.api.feedback.repository.types.StatusOption;
import eu.supersede.integration.api.feedback.types.ApiUser;
import eu.supersede.integration.api.feedback.types.ApiUserPermission;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackRepositoryProxy <T,S> extends IFServiceProxy<T,S> implements IFeedbackRepository {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.repository.endpoint");
	private String token;
	private String language = "en";
	
	public FeedbackRepositoryProxy(String user, String password) throws Exception {
		this(user, password, "en");
	}

	public FeedbackRepositoryProxy(String user, String password, String language) throws Exception {
		this.token = authenticate(user, password);
		if (token == null)
			throw new IFException("Failed authentication in Orchestrator");
		this.language = language;
	}

	// Authentication


	@Override
	public String authenticate (String user, String password) throws Exception{
		Assert.hasText(user, "Provide a valid user");
		Assert.hasText(user, "Provide a valid password");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "authenticate");
		JSONObject accountJson = new JSONObject();
		accountJson.put("name", user);
		accountJson.put("password", password);
		log.debug("Sending message authenticate with user: " + user
				+ " with password: " + (password != null? "not null":"null")
				+ " with password: " + (password != null && !password.isEmpty()? "not empty":"empty")
				+ " to FeedbackRepository at uri " + uri);
		return postJSONObjectAndReturnValueForJsonLabel(accountJson.toString(), uri, HttpStatus.OK, "token");
	}
	
	@Override
	public List<Feedback> getFeedbacksForApplication(Integer idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks");
		log.debug("Sending message listAllFeedbacksForApplication with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return getJSONObjectsListForType(Feedback[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public List<Feedback> getFeedbacksForApplicationWithOrchestratorConfiguration(Integer idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks/full");
		log.debug("Sending message listAllFeedbacksForApplication with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return getJSONObjectsListForType(Feedback[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public List<Feedback> getFeedbacksForApplicationByUser(Integer idApplication, String idUser) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + 
				language + "/applications/" + idApplication + "/feedbacks/user_identification/" + idUser);
		log.debug("Sending message listAllFeedbacksForApplication with idApplication: " + idApplication
				+ " with idUser: " + idUser
				+ " to FeedbackRepository at uri " + uri);
		return getJSONObjectsListForType(Feedback[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public Feedback getFeedbackForApplication(Integer idFeedback, Integer idApplication) throws Exception {
		Assert.notNull(idFeedback, "Provide a valid feedback id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks/" + idFeedback);
		log.debug("Sending message getFeedbackForApplication with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackRepository at uri " + uri);
		return getJSONObjectForType(Feedback.class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public byte[] downloadAttachment(String attachmentName, Integer idApplication) throws Exception {
		Assert.notNull(attachmentName, "Provide a valid attachment name");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks/attachments/" + attachmentName);
		log.debug("Sending message downloadAttachement with attachmentName: " + attachmentName
				+ " with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}

	@Override
	public byte[] downloadScreenshot(String screenshotName, Integer idApplication) throws Exception {
		Assert.notNull(screenshotName, "Provide a valid screenshot name");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		String suri = SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks/screenshots/" + screenshotName;
		URI uri = new URI(suri);
		log.debug("Sending message downloadScreenshot with screenshotName: " + screenshotName
				+ " with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}

	@Override
	public byte[] downloadAudio(String audioName, Integer idApplication) throws Exception {
		Assert.notNull(audioName, "Provide a valid audio name");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks/audios/" + audioName);
		log.debug("Sending message downloadAudio with audioName: " + audioName
				+ " with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return getObjectAsInputStream(uri, HttpStatus.OK, token);
	}
	
	@Override
	public Feedback createFeedbackForApplication(Feedback feedback, 
			Map<String, Path> attachmentsPaths, Map<String, Path> screenshotsPaths, 
			Map<String, Path> audiosPaths, Integer idApplication) throws Exception {
		Assert.notNull(feedback, "Provide a valid feedback");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		Assert.notNull(attachmentsPaths, "Provide valid attachments");
		Assert.notNull(screenshotsPaths, "Provide valid screenshots");
		Assert.notNull(audiosPaths, "Provide valid audios");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language + "/applications/" + idApplication + "/feedbacks");
		
		LinkedMultiValueMap<String, Object> parts = 
		          new LinkedMultiValueMap<String, Object>();
		
		HttpHeaders xmlHeaders = new HttpHeaders();
        xmlHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> jsonEntity = new HttpEntity<String>(convertToJSON (feedback), xmlHeaders);
		
		parts.add("json", jsonEntity);
		
//		parts.add("json", convertToJSON (feedback));
		
		for (String key: attachmentsPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(attachmentsPaths.get(key))));
		}
	
		for (String key: screenshotsPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(screenshotsPaths.get(key))));
		}
		
		for (String key: audiosPaths.keySet()){
			parts.add(key, new ByteArrayResource(Files.readAllBytes(audiosPaths.get(key))));
		}
		
		log.debug("Sending message createFeedbackForApplication with feedback: " + feedback
				+ " with attachmentsPaths: " + attachmentsPaths
				+ " with screenshotsPaths: " + screenshotsPaths
				+ " with audiosPaths: " + audiosPaths
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackRepository at uri " + uri);
		return sendMultipartFormDataMessage(uri, Feedback.class, parts, HttpMethod.POST, token);
	}
	
	public void deleteFeedback(Integer idApplication, Integer idFeedback) throws Exception{
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idFeedback, "Provide a valid idFeedback");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + language 
				+ "/applications/" + idApplication + "/feedbacks/" + idFeedback);
		log.debug("Sending message deleteFeedback with idApplication: " + idApplication 
				+ " and idFeedback: " + idFeedback
				+ " to FeedbackRepository at uri " + uri);
		deleteUriResource(uri, HttpStatus.OK, token);
	}
}
