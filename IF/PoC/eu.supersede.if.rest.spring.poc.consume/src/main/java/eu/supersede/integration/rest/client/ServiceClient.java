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

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
public class ServiceClient implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(ServiceClient.class);
	private RestTemplate restTemplate = new RestTemplate();
	private IFMessageClient messageClient = new IFMessageClient();

	public static void main(String args[]) {
		SpringApplication.run(ServiceClient.class);
	}

	@Override
	public void run(String... strings) throws Exception {

		// Testing Quotes
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		log.info(quote.toString());

		// // Testing Greeting
		// String name = "Friend";
		// HelloMessage message =
		// restTemplate.getForObject("http://localhost:8080/eu.supersede.if.rest.spring.poc-0.1.0/greeting?name="
		// + name,
		// HelloMessage.class);
		// log.info(message.toString());

		// Testing Service Manager
		testServiceManager();
	}

	// private String addService (Service service) throws URISyntaxException{
	// RequestEntity request = RequestEntity.post(new
	// URI("http://localhost:8080/services/")).accept(MediaType.APPLICATION_JSON).body(service);
	// String uuid = restTemplate.exchange(request,
	// String.class).getBody().replace("\"", "");
	//
	// log.info("Service "+ uuid + " created for URI: " + service.getUri());
	// return uuid;
	// }

	// SERVICES - CREATE
	private String createService(Service service) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/");
		ResponseEntity<String> response = messageClient.postJsonMessage(service, uri);
		String uuid = response.getBody().replace("\"", "");
		log.info("Service " + uuid + " created for URI: " + service.getUri());
		return uuid;
	}

	// SERVICES - UPDATE
	private void updateService(Service service) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/");
		ResponseEntity<String> response = messageClient.putJsonMessage(service, uri);
		log.info("Service " + service.getUuid() + " updated");
	}

	// private Service readService (String uuid){
	// ResponseEntity<Service> response = restTemplate.getForEntity(
	// "http://localhost:8080/services/" + uuid,
	// Service.class);
	// if (response.getStatusCode().equals(HttpStatus.FOUND)){
	// log.info("Located service for URI: " + response.getBody().getUri());
	// }else{
	// log.info("Service for uuid: " + uuid + " not located");
	// }
	//
	// return response.getBody();
	// }

	// SERVICES - READ
	private Service readService(String uuid) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/" + uuid);
		ResponseEntity<Service> response = messageClient.getMessage(uri, Service.class);
		if (response.getStatusCode().equals(HttpStatus.FOUND)) {
			log.info("Located service for URI: " + response.getBody().getUri());
		} else {
			log.info("Service for uuid: " + uuid + " not located");
		}

		return response.getBody();
	}

	// private Service[] getServices (){
	// ResponseEntity<Service[]> response = restTemplate.getForEntity(
	// "http://localhost:8080/services/", Service[].class);
	// Service[] services = response.getBody();
	// if (response.getStatusCode().equals(HttpStatus.FOUND)){
	// log.info("Located " + services.length + " service(s)");
	// }else{
	// log.info("There was a problem getting available services");
	// }
	// return services;
	// }

	// SERVICES - READ
	private Service[] getServices() throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/");
		ResponseEntity<Service[]> response = messageClient.getMessage(uri, Service[].class);
		Service[] services = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.FOUND)) {
			log.info("Located " + services.length + " service(s)");
		} else {
			log.info("There was a problem getting available services");
		}
		return services;
	}

	// private boolean removeService(String uuid){
	// String url = "http://localhost:8080/services/" + uuid;
	// boolean result = false;
	//// restTemplate.delete(url);
	//
	// HttpHeaders headers = new HttpHeaders();
	// headers.add("Content-Type", "application/json");
	// headers.add("Accept", "*/*");
	// HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	// ResponseEntity<String> responseEntity = restTemplate.exchange(url,
	// HttpMethod.DELETE, requestEntity, String.class, "");
	// if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
	// log.info("Deleted service " + uuid);
	// result = true;
	// }else{
	// log.info("There was a problem deleting the service");
	// }
	//
	// return result;
	// }

	// SERVICES - REMOVE
	private boolean removeService(String uuid) throws URISyntaxException {
		boolean result = false;
		URI uri = new URI("http://localhost:8080/services/" + uuid);
		ResponseEntity<String> responseEntity = messageClient.deleteJsonMessage(uri);
		if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)) {
			log.info("Deleted service " + uuid);
			result = true;
		} else {
			log.info("There was a problem deleting the service");
		}
		return result;
	}

	// private boolean removeAllServices (){
	// boolean result = false;
	// String url = "http://localhost:8080/services/";
	// HttpHeaders headers = new HttpHeaders();
	// headers.add("Content-Type", "application/json");
	// headers.add("Accept", "*/*");
	// HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
	// ResponseEntity<String> responseEntity = restTemplate.exchange(url,
	// HttpMethod.DELETE, requestEntity, String.class, "");
	// if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)){
	// log.info("Deleted all services");
	// result = true;
	// }else{
	// log.info("There was a problem deleting the services");
	// }
	// return result;
	// }

	// SERVICES - REMOVE
	private boolean removeAllServices() throws URISyntaxException {
		boolean result = false;
		URI uri = new URI("http://localhost:8080/services/");
		ResponseEntity<String> responseEntity = messageClient.deleteJsonMessage(uri);
		if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)) {
			log.info("Deleted all services");
			result = true;
		} else {
			log.info("There was a problem deleting the services");
		}
		return result;
	}

	// private String addOperationForService (String uuid, Operation op) throws
	// URISyntaxException{
	// RequestEntity request = RequestEntity.post(new
	// URI("http://localhost:8080/services/" + uuid +
	// "/operations/")).accept(MediaType.APPLICATION_JSON).body(op);
	// String opUuid = restTemplate.exchange(request,
	// String.class).getBody().replace("\"", "");
	//
	// log.info("Operation " + opUuid + " created for service: " + uuid);
	// return uuid;
	// }

	// OPERATIONS - CREATE
	private String createOperationForService(String uuid, Operation op) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/" + uuid + "/operations/");
		ResponseEntity<String> response = messageClient.postJsonMessage(op, uri);
		String opUuid = response.getBody().replace("\"", "");

		log.info("Operation " + opUuid + " created for service: " + uuid);
		return opUuid;
	}

	// OPERATIONS - UPDATE
	private void updateOperationForService(Operation operation, String suuid) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/" + suuid + "/operations/");
		ResponseEntity<String> response = messageClient.putJsonMessage(operation, uri);
		log.info("Operation " + operation.getUuid() + " updated");
	}

	// OPERATIONS - READ
	private Operation readOperationForService(String ouuid, String suuid) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/" + suuid + "/operations/" + ouuid);
		ResponseEntity<Operation> response = messageClient.getMessage(uri, Operation.class);
		if (response.getStatusCode().equals(HttpStatus.FOUND)) {
			log.info("Located operation for ouuid: " + response.getBody().getUuid());
		} else {
			log.info("Operation for ouuid: " + ouuid + " not located");
		}

		return response.getBody();
	}

	private Operation[] getOperations(String suuid) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/services/" + suuid + "/operations/");
		ResponseEntity<Operation[]> response = messageClient.getMessage(uri, Operation[].class);
		Operation[] operations = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.FOUND)) {
			log.info("Located " + operations.length + " operation(s)");
		} else {
			log.info("There was a problem getting available operations");
		}
		return operations;
	}

	// OPERATIONS - REMOVE
	private boolean removeOperation(String suuid, String ouuid) throws URISyntaxException {
		boolean result = false;
		URI uri = new URI("http://localhost:8080/services/" + suuid + "/operations/" + ouuid);
		ResponseEntity<String> responseEntity = messageClient.deleteJsonMessage(uri);
		if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)) {
			log.info("Deleted operation " + ouuid);
			result = true;
		} else {
			log.info("There was a problem deleting the service");
		}
		return result;
	}

	private boolean removeAllOperations(String suuid) throws URISyntaxException {
		boolean result = false;
		URI uri = new URI("http://localhost:8080/services/" + suuid);
		ResponseEntity<String> responseEntity = messageClient.deleteJsonMessage(uri);
		if (responseEntity.getStatusCode().equals(HttpStatus.ACCEPTED)) {
			log.info("Deleted all operations");
			result = true;
		} else {
			log.info("There was a problem deleting the operations");
		}
		return result;
	}

	// MAIN TEST
	private void testServiceManager() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		// Create Service 1
		Service service = new Service();
		service.setUri(new URI("http://localhost/supersede/services/dm/dynamicAdaptation"));
		service.setName("DynamicAdaptationDecisionMaking");
		service.setDescription("Provides Decision Making support for dynamic adaptation");
		service.setAvailable(true);

		String suuid = createService(service);

		// Create Service 2
		service = new Service();
		service.setUri(new URI("http://localhost/supersede/services/enactment/dynamicAdaptation"));
		service.setName("DynamicAdaptationEnactment");
		service.setDescription("Enact dynamic adaptation actions");
		service.setAvailable(true);

		suuid = createService(service);

		// Update Service
		service.setName("DynamicAdaptationEnactmentUpdated");
		updateService(service);

		// Create Operation
		Operation operation = new Operation();
		operation.setName("computeDynamicAdaptationActions");
		operation.setReturnType("Collection<DAAction>");

		String ouuid = createOperationForService(suuid, operation);
		
		// Update Operation
		operation.setName("computeDynamicAdaptationActionsModified");
		updateOperationForService(operation, suuid);

		// Read Service
		service = readService(suuid);
		
		// Read Operation
		Operation op = readOperationForService(ouuid, suuid);

		// List all services
		Service[] services = getServices();
		
		// List all operations
		Operation[] operations = getOperations(suuid);

		// Delete operation
		boolean result = removeOperation(suuid, ouuid);
		
		// Delete a Service
		result = removeService(suuid);

		// Remove all services
		result = removeAllServices();
	}
}
