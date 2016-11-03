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

import eu.supersede.integration.api.feedback.repository.types.Feedback;
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
	public List<Feedback> getAllFeedbacksForApplication(Integer idApplication, String token) throws Exception {
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
	public byte[] downloadScreenshot(String screenshotName, String token) throws Exception {
		Assert.notNull(screenshotName, "Provide a valid screenshot name");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "screenshots/" + screenshotName);
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
		
		Feedback response = sendMultipartFormDataMessage(uri, Feedback.class, parts, HttpMethod.POST);
		
		return response;
	}

}
