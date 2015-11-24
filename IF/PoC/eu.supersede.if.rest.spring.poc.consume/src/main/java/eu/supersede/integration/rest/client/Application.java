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
import eu.supersede.integration.rest.client.type.Operation;
import eu.supersede.integration.rest.client.type.Quote;
import eu.supersede.integration.rest.client.type.Service;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private RestTemplate restTemplate = new RestTemplate();
	
    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... strings) throws Exception {
    	
    	// Testing Quotes
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

    
    private String addService (Service service) throws URISyntaxException{
    	RequestEntity request = RequestEntity.post(new URI("http://localhost:8080/services/")).accept(MediaType.APPLICATION_JSON).body(service);
		String uuid = restTemplate.exchange(request, String.class).getBody().replace("\"", "");
		
		log.info("Service "+ uuid + " created for URI: " + service.getUri());
		return uuid;
    }
    
    private String addOperationForService (String uuid, Operation op) throws URISyntaxException{
    	RequestEntity request = RequestEntity.post(new URI("http://localhost:8080/services/" + uuid + "/operations/")).accept(MediaType.APPLICATION_JSON).body(op);
		String opUuid = restTemplate.exchange(request, String.class).getBody().replace("\"", "");
		
		log.info("Operation " + opUuid + " created for service: " + uuid);
		return uuid;
    }
    
    private Service readService (String uuid){
    	ResponseEntity<Service> response = restTemplate.getForEntity(
    			"http://localhost:8080/services/" + uuid, 
    			Service.class);
		if (response.getStatusCode().equals(HttpStatus.FOUND)){
			log.info("Located service for URI: " + response.getBody().getUri());
		}else{
			log.info("Service for uuid: " + uuid + " not located");
		}
		
		return response.getBody();
    }
    
    private Service[] getServices (){
    	ResponseEntity<Service[]> response = restTemplate.getForEntity(
    			"http://localhost:8080/services/", Service[].class);
    		Service[] services = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.FOUND)){
			log.info("Located " + services.length + " service(s)");
		}else{
			log.info("There was a problem getting available services");
		}
		return services;
    }
    
    private boolean removeService(String uuid){
    	String url = "http://localhost:8080/services/" + uuid;
    	boolean result = false;
//		restTemplate.delete(url);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, "");
	    if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
			log.info("Deleted service " + uuid);
			result = true;
		}else{
			log.info("There was a problem deleting the service");
		}
		
	    return result;
    }
    
    private boolean removeAllServices (){
    	boolean result = false;
    	String url = "http://localhost:8080/services/";
    	HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");
	    headers.add("Accept", "*/*");
		HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
    	ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class, "");
	    if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
			log.info("Deleted all services");
			result = true;
		}else{
			log.info("There was a problem deleting the services");
		}
	    return result;
    }
    
	private void testServiceManager() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		
		// Create Service 1
		Service service = new Service();
    	service.setUri(new URI("http://localhost/supersede/services/dm/dynamicAdaptation"));
    	service.setName("DynamicAdaptationDecisionMaking");
    	service.setDescription("Provides Decision Making support for dynamic adaptation");
    	service.setAvailable(true);
    	
    	String uuid = addService(service);
		
		// Create Service 2
		service = new Service();
    	service.setUri(new URI("http://localhost/supersede/services/enactment/dynamicAdaptation"));
    	service.setName("DynamicAdaptationEnactment");
    	service.setDescription("Enact dynamic adaptation actions");
    	service.setAvailable(true);
    	
    	addService (service);
    	
    	// Create Operation
    	Operation operation = new Operation ();
    	operation.setName("computeDynamicAdaptationActions");
    	operation.setReturnType("Collection<DAAction>");

    	addOperationForService (uuid, operation);
    	
		// Read Service
		service = readService(uuid);
		
		// List all services
		Service[] services = getServices();
		
		//Delete a Service
		boolean result = removeService (uuid);
		
		//Remove all services
	    result = removeAllServices();
	}
}
