package eu.supersede.integration.rest.service;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.integration.rest.service.type.Operation;
import eu.supersede.integration.rest.service.type.Service;


@RestController
public class ServiceController {

	static Map<URI, Service> services = new HashMap<>();
	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@RequestMapping(value="/addService", method=RequestMethod.PUT)
    public boolean addService(	
    	@RequestParam(value="uri") URI uri, 
    	@RequestParam(value="name") String name,
    	@RequestParam(value="description", defaultValue="") String description, 
    	@RequestParam(value="available", defaultValue="false") boolean available) {
        
		boolean isNotRegistered = false;
		
		if (uri == null || name == null || name.isEmpty()){
			log.info("Cannot register a service without uri and name");
			return isNotRegistered;
		}
		
		Service service = new Service();
		service.setUri(uri);
		service.setName(name);
		service.setDescription(description);
		service.setAvailable(available);
				
		if (!services.containsKey(service.getUri())){
			log.info("Registering service: " + uri);
			services.put(service.getUri(), service);
			isNotRegistered = true;
		}else{
			log.info("Service already registered: " + uri);
		}
		
		return isNotRegistered;
    }
	
	@RequestMapping(value="/getService", method=RequestMethod.GET)
    public Service getServiceForUri(@RequestParam(value="uri") URI uri){
		log.info("Returning service for uri: " + uri);
		return services.get(uri);
	}
	
	@RequestMapping(value="/listServices", method=RequestMethod.GET)
    public Collection<Service> listServices(){
		log.info("Returning list of services");
		return services.values();
	}
	
	@RequestMapping(value="/addOperationForService", method=RequestMethod.PUT)
	public boolean addOperationForServiceUri (
		@RequestParam(value="name") String name, 
		@RequestParam(value="returnType") String returnType, 
		@RequestParam(value="uri") URI uri){
		
		Service service = services.get(uri);
		if (service == null){
			log.info("Service for uri: " + uri + " not found");
			return false;
		}
		
		Operation op = new Operation();
		op.setName(name);
		op.setReturnType(returnType);
		
		if (!service.getOperations().contains(op)){
			log.info("Added operation " + name + " to Service for uri: " + uri);
			service.getOperations().add(op);
		}
		
		return true;
	}
}
