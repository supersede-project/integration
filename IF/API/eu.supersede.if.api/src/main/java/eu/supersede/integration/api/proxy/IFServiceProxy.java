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
package eu.supersede.integration.api.proxy;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.fe.FrontendSession;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.rest.client.IFMessageClient;

public abstract class IFServiceProxy<T, S> {
	protected IFMessageClient messageClient = IFMessageClient.getInstance();
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public <T> List<T> getJSONObjectsListForType(Class<T[]> type, URI uri, HttpStatus expectedStatus) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T[]> response = messageClient.getJSONMessage(uri, type);
			T[] objects = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + objects.length + " JSON object(s) for type " + type);
			} else {
				log.info("There was a problem getting JSON object(s) in uri: " + uri);
			}
			return (List<T>) Arrays.asList(objects);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> List<T> getJSONObjectsListForType(Class<T[]> type, URI uri, HttpStatus expectedStatus, FrontendSession session) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T[]> response = messageClient.getJSONMessage(uri, type, session);
			T[] objects = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + objects.length + " JSON object(s) for type " + type);
			} else {
				log.info("There was a problem getting JSON object(s) in uri: " + uri);
			}
			return (List<T>) Arrays.asList(objects);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> List<T> getJSONObjectsListForType(Class<T[]> type, URI uri, HttpStatus expectedStatus, String token) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T[]> response = messageClient.getJSONMessage(uri, type, token);
			T[] objects = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + objects.length + " JSON object(s) for type " + type);
			} else {
				log.info("There was a problem getting JSON object(s) in uri: " + uri);
			}
			return (List<T>) Arrays.asList(objects);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> List<T> getObjectsListForType(Class<T[]> type, URI uri, HttpStatus expectedStatus, MediaType objectMediaType, AuthorizationToken authenticationToken) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T[]> response = messageClient.getMessage(uri, type, objectMediaType, authenticationToken);
			T[] objects = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + objects.length + " object(s) for type " + type);
			} else {
				log.info("There was a problem getting object(s) in uri: " + uri);
			}
			return (List<T>) Arrays.asList(objects);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T getJSONObjectForType(Class<T> type, URI uri, HttpStatus expectedStatus) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = messageClient.getJSONMessage(uri, type);
			T object = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + type + " JSON object: " + object);
			} else {
				log.info("There was a problem getting JSON object in uri: " + uri);
			}
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T getJSONObjectForType(Class<T> type, URI uri, HttpStatus expectedStatus, FrontendSession session) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = messageClient.getJSONMessage(uri, type, session);
			T object = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + type + " JSON object: " + object);
			} else {
				log.info("There was a problem getting JSON object in uri: " + uri);
			}
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T getJSONObjectForType(Class<T> type, URI uri, HttpStatus expectedStatus, String token) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = messageClient.getJSONMessage(uri, type, token);
			T object = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + type + " JSON object: " + object);
			} else {
				log.info("There was a problem getting JSON object in uri: " + uri);
			}
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T getObjectForType(Class<T> type, URI uri, HttpStatus expectedStatus, MediaType objectMediaType, AuthorizationToken authenticationToken) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = messageClient.getMessage(uri, type, objectMediaType, authenticationToken);
			T object = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located " + type + " JSON object: " + object);
			} else {
				log.info("There was a problem getting JSON object in uri: " + uri);
			}
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public byte[] getObjectAsInputStream(URI uri, HttpStatus expectedStatus, String token) {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<byte[]> response = messageClient.getMessage(uri, byte[].class, MediaType.APPLICATION_OCTET_STREAM, token);
			byte[] object = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Located object: " + object);
			} else {
				log.info("There was a problem getting object in uri: " + uri);
			}
			return object;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T insertandReturnJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		T result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = 
					messageClient.postJsonMessage(object, uri, object.getClass());
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T insertandReturnJSONObject(T object, Class<T> type, URI uri, HttpStatus expectedStatus, FrontendSession session) throws Exception {
		T result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = 
					messageClient.postJsonMessageReturningSameType(object, uri, type, session);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T insertandReturnJSONObject(T object, URI uri, HttpStatus expectedStatus, String token) throws Exception {
		T result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			Assert.hasText(token, "Provide a valid token");
			ResponseEntity<T> response = 
					messageClient.postJsonMessage(object, uri, object.getClass(), token);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T,S> S insertJSONObjectAndReturnAnotherType(T object, Class<S> returnedType, URI uri, HttpStatus expectedStatus) throws Exception {
		S result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<S> response = 
					messageClient.postJsonMessage(object, uri, returnedType);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
				log.info("Result obtained: " + result);
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> boolean insertJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.postJsonMessage(object, uri, object.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
				result = true;
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public boolean insertJSONObject(String json, URI uri, HttpStatus expectedStatus, FrontendSession session) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(json, "Provide a valid json ");
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.postJsonMessage(json, uri, String.class, session);
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + json);
				result = true;
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public <T> String insertJSONObjectAndReturnValueForJsonLabel(T object, URI uri, HttpStatus expectedStatus, String label) throws Exception {
		String result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			Assert.notNull(expectedStatus, "Provide a valid expectedStatus");
			Assert.notNull(label, "Provide a valid label");
			ResponseEntity<String> response = 
					messageClient.postJsonMessage(object, uri, String.class);
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
				JSONObject json = new JSONObject(response.getBody());
				result = json.get(label).toString();
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> String postJSONObjectAndReturnValueForJsonLabel(T object, URI uri, HttpStatus expectedStatus, String label) throws Exception {
		String result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			Assert.notNull(expectedStatus, "Provide a valid expectedStatus");
			Assert.notNull(label, "Provide a valid label");
			ResponseEntity<String> response = 
					messageClient.postJsonMessage(object, uri, object.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully posted JSON object " + object);
				JSONObject json = new JSONObject(response.getBody());
				result = json.getString(label);
			} else {
				log.info("There was a problem posting JSON object " + object + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> Boolean postJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		Boolean result = false;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.postJsonMessage(object, uri, String.class);
			JSONObject json = new JSONObject(response.getBody());
			String message = json.getString("message");
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully posted JSON object " + object);
				if (message != null){
					log.info(message);
				}
			} else {
				log.info("There was a problem posting JSON object " + result + " in URI: " + uri);
				if (message != null){
					log.info(message);
				}
			}
			return result;
		} catch (HttpClientErrorException|HttpServerErrorException e) {
			log.error(e.getMessage(), e);
			JSONObject json = new JSONObject(e.getResponseBodyAsString());
			String message = json.getString("message");
			if (message != null){
				log.error(message);
			}
			throw new Exception (message);
		}
	}
	
	public <T> T updateAndReturnJSONObject(T object, URI uri, HttpStatus expectedStatus, String token) throws Exception {
		T result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			Assert.hasText(token, "Provide a valid token");
			ResponseEntity<T> response = 
					messageClient.putJsonMessage(object, uri, object.getClass(), token);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully updated JSON object " + object);
			} else {
				log.info("There was a problem updating JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T updateAndReturnJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		T result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = 
					messageClient.putJsonMessage(object, uri, object.getClass());
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully updated JSON object " + object);
			} else {
				log.info("There was a problem updating JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T,S> S updateJSONObjectAndReturnAnotherType(T object, Class<S> returnedType, URI uri, HttpStatus expectedStatus) throws Exception {
		S result = null;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<S> response = 
					messageClient.putJsonMessage(object, uri, returnedType);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully updated JSON object " + object);
			} else {
				log.info("There was a problem updating JSON object " + result + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> void updateJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.putJsonMessage(object, uri, object.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully updated JSON object " + object);
			} else {
				log.info("There was a problem updating JSON object " + object + " in URI: " + uri);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T postJSONStringForReturnType(Class<T> type, String jsonInput, URI uri, HttpStatus expectedStatus) throws Exception {
		T result = null;
		try {
			Assert.notNull(jsonInput, "Provide a valid json object");
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = 
					messageClient.postJsonMessage(jsonInput, uri, type);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + jsonInput);
			} else {
				log.info("There was a problem inserting JSON object " + jsonInput + " in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public boolean postJSONString(String jsonInput, URI uri, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(jsonInput, "Provide a valid json object");
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<Boolean> response = 
					messageClient.postJsonMessage(jsonInput, uri, jsonInput.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + jsonInput);
				result = true;
			} else {
				log.info("There was a problem inserting JSON object " + jsonInput + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public boolean postXMLString(String xmlInput, URI uri, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(xmlInput, "Provide a valid XML object");
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<Boolean> response = 
					messageClient.postXmlMessage(xmlInput, uri, xmlInput.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted XML object " + xmlInput);
				result = true;
			} else {
				log.info("There was a problem inserting XML object " + xmlInput + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	/**
	 * Sends a post message with an array of values encoded as form
	 * @param query
	 * @param valueLabel
	 * @param values
	 * @param expectedStatus
	 * @return
	 * @throws Exception
	 */
	public <T> boolean postFormURLEncoded(URI query, Map<String,List<T>> values, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(query, "Provide a valid query");
			Assert.notNull(values, "Provide a valid values");
			Assert.notNull(expectedStatus, "Provide a valid expectedStatus");
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, T> map= new LinkedMultiValueMap<String, T>();
			for (String parameter: values.keySet()){
				for (T value:values.get(parameter))
					map.add(parameter, value);
			}

			HttpEntity<MultiValueMap<String, T>> request = new HttpEntity<MultiValueMap<String, T>>(map, headers);

			ResponseEntity<String> response = messageClient.postForEntity( query, request , String.class );
			
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully posted query " + query);
				result = true;
			} else {
				log.info("There was a problem posting query query");
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public <T, S> T getFormURLEncoded(String uri, Map<String, S> parameters, HttpStatus expectedStatus, Class<T> returnType) throws Exception {
		try {
			Assert.notNull(uri, "Provide a valid uri");
			Assert.notNull(parameters, "Provide a valid parameters");
			Assert.notNull(expectedStatus, "Provide a valid expectedStatus");
			Assert.notNull(returnType, "Provide a valid returnType");

			ResponseEntity<T> response = messageClient.getForEntity( uri, returnType,  parameters);
			
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully get uri " + uri);
			} else {
				log.info("There was a problem getting uri");
			}
			return response.getBody();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public <T> T deleteUriResourceForReturnType(Class<T> type, URI uri, HttpStatus expectedStatus) throws Exception {
		T result = null;
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<T> response = 
					messageClient.deleteJsonMessage(uri, type);
			result = response.getBody();
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully delete in uri " + uri);
			} else {
				log.info("There was a problem deleting in URI: " + uri);
				result = null;
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
	public boolean deleteUriResource(URI uri, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.deleteJsonMessage(uri);
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully delete in uri " + uri);
				result = true;
			} else {
				log.info("There was a problem deleting in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public boolean deleteUriResource(URI uri, HttpStatus expectedStatus, FrontendSession session) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.deleteJsonMessage(uri, session);
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully delete in uri " + uri);
				result = true;
			} else {
				log.info("There was a problem deleting in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public boolean deleteUriResource(URI uri, HttpStatus expectedStatus, String token) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<String> response = 
					messageClient.deleteJsonMessage(uri, token);
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully delete in uri " + uri);
				result = true;
			} else {
				log.info("There was a problem deleting in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	public <T> T sendMultipartFormDataMessage(URI uri, Class<T> returnType, LinkedMultiValueMap<String, Object> parts, HttpMethod method) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity =
		          new HttpEntity<LinkedMultiValueMap<String, Object>>(parts, headers);
		
		ResponseEntity<T> response =
				messageClient.exchange(uri, 
		                  method, requestEntity, returnType);
		return response.getBody();
	}
	
	public boolean sendMultipartFormDataMessage(URI uri, LinkedMultiValueMap<String, Object> parts, HttpMethod method, HttpStatus expectedStatus) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity =
		          new HttpEntity<LinkedMultiValueMap<String, Object>>(parts, headers);
		
		ResponseEntity<String> response =
				messageClient.exchange(uri, 
		                  method, requestEntity, String.class);
		return response.getStatusCode().equals(expectedStatus);
	}

	public <T> String convertToJSON(T object) throws JsonProcessingException {
		return messageClient.convertToJSON(object);
	}

}