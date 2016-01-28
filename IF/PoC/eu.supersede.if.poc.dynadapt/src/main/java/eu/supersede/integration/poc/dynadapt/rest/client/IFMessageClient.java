package eu.supersede.integration.poc.dynadapt.rest.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import eu.supersede.integration.poc.dynadapt.DynAdaptProperty;

public class IFMessageClient {
	private RestTemplate restTemplate = new RestTemplate();
	private final static String AUTH_TOKEN = DynAdaptProperty.getProperty("is.authorization.token");

	//Note: S Object requires a correct JSON serialization
	//Note: Sending POST messages through ESB requires content-type header
	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + AUTH_TOKEN)
				.body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}

	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz) {
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.accept(MediaType.APPLICATION_JSON)
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
