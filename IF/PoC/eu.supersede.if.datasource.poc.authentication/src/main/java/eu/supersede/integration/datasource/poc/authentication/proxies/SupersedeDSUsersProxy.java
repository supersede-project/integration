package eu.supersede.integration.datasource.poc.authentication.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.datasource.poc.authentication.types.UsersCollection;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class SupersedeDSUsersProxy {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_DS_USERS_ENDPOINT = IntegrationProperty.getProperty("supersede.ds.users");
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSUsersProxy.class);
	
	//Only returns JSON representation, expressed explicitly
	public UsersCollection getUsers() {
		try {
			URI uri = new URI(SUPERSEDE_DS_USERS_ENDPOINT);
			ResponseEntity<User[]> response = messageClient.getMessage(uri, User[].class);
			User[] collection = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + collection.length + " user(s)");
			} else {
				log.info("There was a problem getting supersede users");
			}
			return new UsersCollection (Arrays.asList(collection));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
