package eu.supersede.integration.rest.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class IFMessageClient {
	private RestTemplate restTemplate = new RestTemplate();

	public <T, S> ResponseEntity<T> postJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}
	
	public <T, S> ResponseEntity<T> putJsonMessage(S object, URI uri) {
		RequestEntity<S> request = RequestEntity.put(uri).accept(MediaType.APPLICATION_JSON).body(object);
		return (ResponseEntity<T>) restTemplate.exchange(request, String.class);
	}

	public <T> ResponseEntity<T> getMessage(URI uri, Class<T> clazz) {
		return (ResponseEntity<T>) restTemplate.getForEntity(uri, clazz);
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
