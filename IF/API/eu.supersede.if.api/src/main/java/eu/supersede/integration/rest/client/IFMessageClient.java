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
package eu.supersede.integration.rest.client;

import java.io.File;
import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.security.types.AuthorizationToken;

public class IFMessageClient {
//	private RestTemplate restTemplate = new RestTemplate();
	private RestTemplate restTemplate;
	private AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
//	private final static String AUTH_TOKEN = IntegrationProperty.getProperty("is.authorization.token");
	private static IFMessageClient instance = new IFMessageClient();
	private ObjectMapper objectMapper;
	
	private IFMessageClient (){
		objectMapper = new ObjectMapper();
		// configure your ObjectMapper here
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);

		restTemplate = new RestTemplate();    

		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setPrettyPrint(false);
		messageConverter.setObjectMapper(objectMapper);
		
		messageConverter.setSupportedMediaTypes(
                Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_OCTET_STREAM}));
		
		restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
		restTemplate.getMessageConverters().add(messageConverter);
	}
	
	public static IFMessageClient getInstance(){
		return instance;
	}
	
	// SYNCRONOUS MESSAGING
	
	//Note: S Object requires a correct JSON serialization
	//Note: Sending POST messages through ESB requires content-type header
	//Returned payload is an String
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> postXmlMessage(S object, URI uri, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri, Class clazz, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.post(uri)
//				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri, Class clazz) {
		RequestEntity<S> request = RequestEntity.post(uri)
//				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri, Class clazz, String token) {
		RequestEntity<S> request = RequestEntity.post(uri)
//				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", token)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> postXmlMessage(S object, URI uri, Class clazz, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri, Class clazz, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.put(uri).
//				accept(MediaType.APPLICATION_JSON).
				contentType(MediaType.APPLICATION_JSON).
				header("Authorization", "Bearer " + token.getAccessToken()).
				body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri, Class clazz) {
		RequestEntity<S> request = RequestEntity.put(uri).
//				accept(MediaType.APPLICATION_JSON).
				contentType(MediaType.APPLICATION_JSON).
//				header("Authorization", "Bearer " + token.getAccessToken()).
				body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri, Class clazz, String token) {
		RequestEntity<S> request = RequestEntity.put(uri).
//				accept(MediaType.APPLICATION_JSON).
				contentType(MediaType.APPLICATION_JSON).
				header("Authorization", token).
				body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> putXmlMessage(S object, URI uri, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.put(uri).
				accept(MediaType.APPLICATION_XML).
				contentType(MediaType.APPLICATION_XML).
				header("Authorization", "Bearer " + token.getAccessToken()).
				body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, AuthorizationToken.class);
	}

	/**
	 * Send GET message to uri, accepting an object of class clazz in JSON representation
	 * @param uri URI of GET message
	 * @param clazz Class representing returned object
	 */
	public <T> ResponseEntity<T> getJSONMessage(URI uri, Class<T> clazz, AuthorizationToken token) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.build();
		return restTemplate.exchange(request, clazz);
	}
	
	public <T> ResponseEntity<T> getJSONMessage(URI uri, Class<T> clazz) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_JSON)
				.build();
		return restTemplate.exchange(request, clazz);

	}
	
	public <T> ResponseEntity<T> getJSONMessage(URI uri, Class<T> clazz, String token) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", token)
				.build();
		return restTemplate.exchange(request, clazz);
	}
	
	public <T> ResponseEntity<T> getXMLMessage(URI uri, Class<T> clazz, AuthorizationToken token) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_XML)
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer " + token.getAccessToken())
				.build();
		return restTemplate.exchange(request, clazz);

//		return (ResponseEntity<T>) restTemplate.getForEntity(uri, clazz);
	}
	
	/**
	 * Send GET message to uri, accepting an object of class clazz in type representation
	 * @param uri URI of GET message
	 * @param clazz Class representing returned object
	 * @param type The media type representation accepted for returned object
	 */
	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz, MediaType type, AuthorizationToken token) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(type)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.build();
		return restTemplate.exchange(request, clazz);
	}
	
	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz, MediaType type, String token) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(type)
				.header("Authorization", token)
				.build();
		return restTemplate.exchange(request, clazz);
	}
	
	
	public ResponseEntity<String> deleteJsonMessage (URI uri, AuthorizationToken token){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Authorization", "Bearer " + token.getAccessToken());
    	HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        return restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
    }
	
	public ResponseEntity<String> deleteJsonMessage (URI uri){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    	HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        return restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
    }
	
	public <T> ResponseEntity<T> deleteJsonMessage(URI uri, Class<T> clazz) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    	HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        return restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, clazz);
	}
	
	public ResponseEntity<String> deleteMessage (URI uri, AuthorizationToken token){
    	RequestEntity request = (RequestEntity) RequestEntity.delete(uri).header("Authorization", "Bearer " + token.getAccessToken());
        return restTemplate.exchange(request, String.class);
    }
	
	
	//ASYNCHRONOUS MESSAGING
	public <T, S> ListenableFuture<ResponseEntity<T>> asyncPostJsonMessage(S object, URI uri, Class clazz, AuthorizationToken token) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + token.getAccessToken())
				.body(object);
		return (ListenableFuture<ResponseEntity<T>>) asyncRestTemplate.exchange(uri, HttpMethod.POST, request, clazz);
	}

	public <T> ResponseEntity<T> exchange(URI uri, HttpMethod method,
			HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity, Class<T> clazz) {
		return restTemplate.exchange(uri, 
                method, requestEntity, clazz);
	}

	public <T> String convertToJSON(T object) throws JsonProcessingException {
		// TODO Auto-generated method stub
		return objectMapper.writeValueAsString(object);
	}
}
