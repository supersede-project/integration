package eu.supersede.integration.rest.service;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.integration.rest.service.type.Operation;
import eu.supersede.integration.rest.service.type.Service;


@RestController
@RequestMapping(value="/services")
public class ServiceController {

	static Map<UUID, Service> services = new HashMap<>();
	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
	
//	@RequestMapping(value="/", method=RequestMethod.PUT)
//    public ResponseEntity<UUID> addServiceForParameters(	
//    	@RequestParam(value="uri") URI uri, 
//    	@RequestParam(value="name") String name,
//    	@RequestParam(value="description", defaultValue="") String description, 
//    	@RequestParam(value="available", defaultValue="false") boolean available) {
//        	
//		if (uri == null || uri.toString().isEmpty() || name == null || name.isEmpty()){
//			log.info("Cannot register a service without uri and name");
//			throw new IncompleteRequestException();
//		}
//		
//		Service service = new Service();
//		service.setUri(uri);
//		service.setName(name);
//		service.setDescription(description);
//		service.setAvailable(available);
//				
//		if (!services.containsKey(service.getUri())){
//			log.info("Registering service: " + uri);
//			services.put(service.getUuid(), service);
//		}else{
//			log.info("Service already registered: " + uri);
//		}
//		
//		return new ResponseEntity<UUID>(service.getUuid(), HttpStatus.CREATED);
//    }
	
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<UUID> addService(@RequestBody Service service) {
		
		if (service.getUri() == null || service.getUri().toString().isEmpty() || service.getName() == null || service.getName().isEmpty()){
			log.info("Cannot register a service without uri and name");
			throw new IncompleteRequestException();
		}
				
		if (!services.containsKey(service.getUri())){
			log.info("Registering service for URI: " + service.getUri() + " and UUID: " + service.getUuid());
			services.put(service.getUuid(), service);
		}else{
			log.info("Service already registered: " + service.getUri());
		}
		
		return new ResponseEntity<UUID>(service.getUuid(), HttpStatus.CREATED);
    }
	
	@RequestMapping(value="/{uuid}", method=RequestMethod.GET)
    public ResponseEntity<Service> getService(@PathVariable UUID uuid){
		log.info("Returning service for uuid: " + uuid);
		Service service = services.get(uuid);
		if (service == null)
			throw new ServiceNotFoundException();
		
		return new ResponseEntity<Service>(service, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public Collection<Service> listServices(){
		log.info("Returning list of services");
		return services.values();
	}
	
	@RequestMapping(value="/{uuid}", method=RequestMethod.DELETE)
	public ResponseEntity removeService (@PathVariable UUID uuid){
		log.info("Removing service for uuid: " + uuid);
		Service service = services.get(uuid);
		if (service == null)
			throw new ServiceNotFoundException();
		else
			services.remove(uuid);
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
    public ResponseEntity deleteServices(){
		log.info("Deleting list of services");
		services.clear();
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/{uuid}/operations", method=RequestMethod.POST)
	public ResponseEntity<UUID> addOperationForService (
		@PathVariable UUID uuid,
		@RequestBody Operation operation 
		){
		
		Service service = services.get(uuid);
		if (service == null){
			log.info("Service for uuid: " + uuid + " not found");
			throw new ServiceNotFoundException();
		}
		
		if (!service.getOperations().contains(operation)){
			log.info("Added operation " + operation.getName() + " to Service for uri: " + uuid);
			service.getOperations().add(operation);
		}
		
		return new ResponseEntity<UUID>(operation.getUuid(), HttpStatus.CREATED);
	}
	
	@ResponseStatus(value=HttpStatus.PARTIAL_CONTENT, reason="Service URI or name missed") 
	public class IncompleteRequestException extends RuntimeException {

	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Service for URI not found") 
	public class ServiceNotFoundException extends RuntimeException {

	}

}
