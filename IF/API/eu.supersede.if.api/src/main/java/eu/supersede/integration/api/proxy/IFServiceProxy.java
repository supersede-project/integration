package eu.supersede.integration.api.proxy;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.rest.client.IFMessageClient;

public abstract class IFServiceProxy<T> {
	private IFMessageClient messageClient = IFMessageClient.getInstance();
	private static final Logger log = LoggerFactory.getLogger(IFServiceProxy.class);

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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return null;
		}
	}
	
	public <T> boolean insertJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
		boolean result = false;
		try {
			Assert.notNull(object, "Provide a valid object of type " + object.getClass());
			Assert.notNull(uri, "Provide a valid uri");
			ResponseEntity<Boolean> response = 
					messageClient.postJsonMessage(object, uri, object.getClass());
			if (response.getStatusCode().equals(expectedStatus)) {
				log.info("Successfully inserted JSON object " + object);
				result = true;
			} else {
				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public <T> T updateJSONObject(T object, URI uri, HttpStatus expectedStatus) throws Exception {
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return false;
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
			e.printStackTrace();
			return null;
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
			e.printStackTrace();
			return false;
		}
	}

}