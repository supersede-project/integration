package eu.supersede.integration.rest.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import eu.supersede.integration.properties.IntegrationProperty;

public class IFMessageClient {
	private RestTemplate restTemplate = new RestTemplate();
	private final static String AUTH_TOKEN = IntegrationProperty.getProperty("is.authorization.token");

	//Note: S Object requires a correct JSON serialization
	//Note: Sending POST messages through ESB requires content-type header
	//Returned payload is an String
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + AUTH_TOKEN)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> postXmlMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML)
				.header("Authorization", "Bearer " + AUTH_TOKEN)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri, Class clazz) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + AUTH_TOKEN)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	public <T, S> ResponseEntity<T> postXmlMessage(S object, URI uri, Class clazz) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_XML)
				.contentType(MediaType.APPLICATION_XML)
				.header("Authorization", "Bearer " + AUTH_TOKEN)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, clazz);
	}
	
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> putXmlMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_XML).contentType(MediaType.APPLICATION_XML).body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}

	/**
	 * Send GET message to uri, accepting an object of class clazz in JSON representation
	 * @param uri URI of GET message
	 * @param clazz Class representing returned object
	 */
	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + AUTH_TOKEN).build();
		return restTemplate.exchange(request, clazz);

//		return (ResponseEntity<T>) restTemplate.getForEntity(uri, clazz);
	}
	
	/**
	 * Send GET message to uri, accepting an object of class clazz in type representation
	 * @param uri URI of GET message
	 * @param clazz Class representing returned object
	 * @param type The media type representation accepted for returned object
	 */
	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz, MediaType type) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(type)
				.header("Authorization", "Bearer " + AUTH_TOKEN).build();
		return restTemplate.exchange(request, clazz);

//		return (ResponseEntity<T>) restTemplate.getForEntity(uri, clazz);
	}
	
	public ResponseEntity<String> deleteJsonMessage (URI uri){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    	HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
        return restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
    }
	
	public ResponseEntity<String> deleteMessage (URI uri){
    	RequestEntity request = (RequestEntity) RequestEntity.delete(uri);
        return restTemplate.exchange(request, String.class);
    }
}
