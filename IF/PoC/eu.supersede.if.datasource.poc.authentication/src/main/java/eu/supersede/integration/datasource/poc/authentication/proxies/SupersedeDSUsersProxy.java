package eu.supersede.integration.datasource.poc.authentication.proxies;

import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.datasource.poc.authentication.json.JsonUtils;
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
			ResponseEntity<User[]> response = messageClient.getMessage(uri, User[].class, MediaType.APPLICATION_XML);
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
	
	public User getUser(int userId) {
		try {
			Assert.isTrue(userId>0, "User id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_USERS_ENDPOINT + userId);
			ResponseEntity<User> response = messageClient.getMessage(uri, User.class, MediaType.APPLICATION_XML);
			User user = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located user: " + user.getLogin());
			} else {
				log.info("There was a problem getting the supersede user for id: " + userId);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int createUser (User user){
		try {
			URI uri = new URI(SUPERSEDE_DS_USERS_ENDPOINT);
			ResponseEntity<String> response = messageClient.postJsonMessage(user, uri, String.class);
			String userId = JsonUtils.evaluatePathInJson(response.getBody(), "/UserRecord/UserID");
			int result = Integer.parseInt(userId);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("User: " + user.getLogin() + " created");
			} else {
				log.info("There was a problem creating the supersede user for login: " + user.getLogin());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public void updateUser (User user){
		try {
			Assert.notNull(user, "User cannot be null");
			Assert.isTrue(user.getUserId()>0, "User id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_USERS_ENDPOINT + user.getUserId());
			ResponseEntity<String> response = messageClient.putJsonMessage(user, uri);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("User: " + user.getLogin() + " updated");
			} else {
				log.info("There was a problem updating the supersede user for login: " + user.getLogin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser (User user){
		try {
			Assert.isTrue(user.getUserId()>0, "User id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_USERS_ENDPOINT + user.getUserId());
			ResponseEntity<String> response = messageClient.deleteJsonMessage(uri);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("User: " + user.getLogin() + " deleted");
			} else {
				log.info("There was a problem deleting the supersede user for login: " + user.getLogin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
