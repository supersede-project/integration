package eu.supersede.integration.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.RequestEntity.HeadersBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import eu.supersede.integration.rest.client.type.HelloMessage;
import eu.supersede.integration.rest.client.type.Quote;
import eu.supersede.integration.rest.client.type.Service;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	
    	// Testing Quotes
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
        
//        // Testing Greeting
//        String name = "Friend";
//        HelloMessage message = restTemplate.getForObject("http://localhost:8080/eu.supersede.if.rest.spring.poc-0.1.0/greeting?name=" + name, 
//        		HelloMessage.class);
//        log.info(message.toString());
        
        // Testing Service Manager
        testServiceManager();
    }

    
	private void testServiceManager() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Create Service
		Service service = new Service();
    	service.setUri(new URI("http://localhost/supersede/services/dm/validateSuggestedDecisions2"));
    	service.setName("validateSuggestedDecisions");
    	service.setDescription("Request DM to verify the viability of suggested decisions");
    	service.setAvailable(true);
    	
//		restTemplate.put("http://localhost:8080/services/", service);

		
		RequestEntity request = RequestEntity.put(new URI("http://localhost:8080/services/")).accept(MediaType.APPLICATION_JSON).body(service);
		String uuid = restTemplate.exchange(request, String.class).getBody().replace("\"", "");
		
		log.info("Service "+ uuid + " created for URI: " + service.getUri());
		
		// Read Service
		ResponseEntity<Service> response = restTemplate.getForEntity(
			"http://localhost:8080/services/" + uuid, 
			Service.class);
		if (response.getStatusCode().equals(HttpStatus.FOUND)){
			log.info("Located service for URI: " + response.getBody().getUri());
		}else{
			log.info("Service for uuid: " + uuid + " not located");
		}
		
		// List Service
		ResponseEntity<Service[]> response2 = restTemplate.getForEntity(
			"http://localhost:8080/services/", Service[].class);
		Service[] services = response2.getBody();
		if (response.getStatusCode().equals(HttpStatus.FOUND)){
			log.info("Located " + services.length + " service(s)");
		}else{
			log.info("There was a problem getting available services");
		}
		
		//Delete a Service
		String url = "http://localhost:8080/services/" + uuid;
//		restTemplate.delete(url);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, "");
	    if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
			log.info("Deleted service " + uuid);
		}else{
			log.info("There was a problem deleting the service");
		}
		
		//Remove all services
	    url = "http://localhost:8080/services/";
	    responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, "");
	    if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
			log.info("Deleted all services");
		}else{
			log.info("There was a problem deleting the services");
		}
	}
}
