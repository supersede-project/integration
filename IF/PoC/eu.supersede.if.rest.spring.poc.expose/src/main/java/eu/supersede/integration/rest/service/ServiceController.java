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
	
	//SERVICES
	//ADD
	@RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<UUID> createService(@RequestBody Service service) {
		
		if (service.getUri() == null || service.getUri().toString().isEmpty() || service.getName() == null || service.getName().isEmpty()){
			log.info("Cannot register a service without uri and name");
			throw new IncompleteRequestException();
		}
				
		if (!services.containsKey(service.getUuid())){
			log.info("Registering service for URI: " + service.getUri() + " and UUID: " + service.getUuid());
			services.put(service.getUuid(), service);
		}else{
			log.info("Service already registered: " + service.getUuid());
		}
		
		return new ResponseEntity<UUID>(service.getUuid(), HttpStatus.CREATED);
    }
	
	//READ
	@RequestMapping(value="/{uuid}", method=RequestMethod.GET)
    public ResponseEntity<Service> getService(@PathVariable UUID uuid){
		log.info("Returning service for uuid: " + uuid);
		Service service = services.get(uuid);
		if (service == null)
			throw new ServiceNotFoundException(uuid);
		
		return new ResponseEntity<Service>(service, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public Collection<Service> listServices(){
		log.info("Returning list of services");
		return services.values();
	}
	
	//UPDATE
	@RequestMapping(value="/", method=RequestMethod.PUT)
    public ResponseEntity<UUID> updateService(@RequestBody Service service) {
		log.info("Requested to update service : " + service.getUuid());
		
		if (service.getUri() == null || service.getUri().toString().isEmpty() || service.getName() == null || service.getName().isEmpty()){
			log.info("Cannot register a service without uri and name");
			throw new IncompleteRequestException();
		}
				
		if (services.containsKey(service.getUuid())){
			log.info("Updating service for URI: " + service.getUri() + " and UUID: " + service.getUuid());
			service.setUuid(service.getUuid());
			services.put(service.getUuid(), service);
		}else{
			log.info("Service not found");
			throw new ServiceNotFoundException(service.getUuid());
		}
		
		return new ResponseEntity<UUID>(service.getUuid(), HttpStatus.ACCEPTED);
    }
	
	//DELETE
	@RequestMapping(value="/{uuid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeService (@PathVariable UUID uuid){
		log.info("Removing service for uuid: " + uuid);
		Service service = services.get(uuid);
		if (service == null)
			throw new ServiceNotFoundException(uuid);
		else
			services.remove(uuid);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteServices(){
		log.info("Deleting list of services");
		services.clear();
		
		return new ResponseEntity<String> (HttpStatus.ACCEPTED);
	}
	
	
	// OPERATIONS
	// ADD
	@RequestMapping(value="/{uuid}/operations", method=RequestMethod.POST)
	public ResponseEntity<UUID> createOperationForService (
		@PathVariable UUID uuid,
		@RequestBody Operation operation 
		){
		
		Service service = services.get(uuid);
		if (service == null){
			log.info("Service for uuid: " + uuid + " not found");
			throw new ServiceNotFoundException(uuid);
		}
		
		if (!service.getOperations().contains(operation)){
			log.info("Added operation " + operation.getUuid() + " to Service : " + uuid);
			service.getOperations().add(operation);
		}
		
		return new ResponseEntity<UUID>(operation.getUuid(), HttpStatus.CREATED);
	}
	
	// READ
	@RequestMapping(value="/{suuid}/operations/{ouuid}", method=RequestMethod.GET)
    public ResponseEntity<Operation> getOperationForService(@PathVariable UUID suuid, @PathVariable UUID ouuid){
		log.info("Returning operation " + ouuid + " for service " + suuid);
		Service service = services.get(suuid);
		if (service == null){
			log.info ("Service " + suuid + " not found");
			throw new ServiceNotFoundException(suuid);
		}
		Operation op = service.getOperation (ouuid);
		if (op == null){
			log.info ("Operation " + ouuid + " not found");
			throw new OperationNotFoundException(ouuid);
		}
		
		return new ResponseEntity<Operation>(op, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/{uuid}/operations/", method=RequestMethod.GET)
    public Collection<Operation> listOperationsForService(@PathVariable UUID uuid){
		log.info("Returning list of operators for service: " + uuid);
		Service service = services.get(uuid);
		if (service == null)
			throw new ServiceNotFoundException(uuid);
		return service.getOperations();
	}
	
	// UPDATE
	@RequestMapping(value="/{suuid}/operations/", method=RequestMethod.PUT)
    public ResponseEntity<UUID> updateOperation(@PathVariable UUID suuid, @RequestBody Operation op) {
		Service service = services.get(suuid);
		if (service == null){
			log.info("Service for uuid: " + suuid + " not found");
			throw new ServiceNotFoundException(suuid);
		}
		
		if (!service.getOperations().contains(op)){
			throw new OperationNotFoundException(op.getUuid());
		}else{
			log.info("Update operation " + op.getUuid() + " for Service: " + suuid);
			service.replaceOperation(op);
		}
		
		return new ResponseEntity<UUID>(op.getUuid(), HttpStatus.ACCEPTED);
		
    }
	
	// DELETE
	@RequestMapping(value="/{suuid}/operations/{ouuid}", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeOperation (@PathVariable UUID suuid, @PathVariable UUID ouuid){
		log.info("Removing operation uuid: " + ouuid + " for service uuid: " + suuid);
		Service service = services.get(suuid);
		if (service == null)
			throw new ServiceNotFoundException(suuid);
		else{
			Operation op = service.getOperation(ouuid);
			if (op == null)
				throw new OperationNotFoundException(ouuid);
			else
				service.removeOperation(op);
		}
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/{uuid}/operations", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteOperations(UUID suuid){
		log.info("Deleting list of operation");
		Service service = services.get(suuid);
		if (service == null)
			throw new ServiceNotFoundException(suuid);
		else{
			service.getOperations().clear();
		}
		
		return new ResponseEntity<String> (HttpStatus.ACCEPTED);
	}
	
	
	// EXCEPTIONS
	
	@ResponseStatus(value=HttpStatus.PARTIAL_CONTENT, reason="Service URI or name missed") 
	public class IncompleteRequestException extends RuntimeException {

	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Service not found") 
	public class ServiceNotFoundException extends RuntimeException {
		UUID uuid;
		public ServiceNotFoundException(UUID uuid){
			super ("Service for UUID " + uuid + " not found");
			this.uuid = uuid;
		}
		
		public String toString (){
			return "Service for UUID " + uuid + " not found";
		}
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Operation not found") 
	public class OperationNotFoundException extends RuntimeException {
		UUID uuid;
		public OperationNotFoundException(UUID uuid){
			super ("Operation for UUID " + uuid + " not found");
			this.uuid = uuid;
		}
		
		public String toString (){
			return "Operation for UUID " + uuid + " not found";
		}
	}

}
