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
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.RolesCollection;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class SupersedeDSRolesProxy {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_DS_ROLES_ENDPOINT = IntegrationProperty.getProperty("supersede.ds.roles");
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesProxy.class);
	private SupersedeDSRolesxUsersProxy rolesxUsersProxy = new SupersedeDSRolesxUsersProxy();
	
	//Only returns JSON representation, expressed explicitly
	public RolesCollection getRoles() {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT);
			ResponseEntity<Role[]> response = messageClient.getMessage(uri, Role[].class, MediaType.APPLICATION_XML);
			Role[] collection = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + collection.length + " roles(s)");
			} else {
				log.info("There was a problem getting supersede roles");
			}
			return new RolesCollection (Arrays.asList(collection));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Role getRole(int roleId) {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + roleId);
			ResponseEntity<Role> response = messageClient.getMessage(uri, Role.class, MediaType.APPLICATION_XML);
			Role role = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located role: " + role.getName());
			} else {
				log.info("There was a problem getting the supersede role for id: " + roleId);
			}
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Role getRoleWithUsers(int roleId) {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + roleId + "/withUsers");
			ResponseEntity<Role> response = messageClient.getMessage(uri, Role.class, MediaType.APPLICATION_XML);
			Role role = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located role: " + role.getName());
			} else {
				log.info("There was a problem getting the supersede role for id: " + roleId);
			}
			return role;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int createRole (Role role){
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT);
			ResponseEntity<String> response = messageClient.postJsonMessage(role, uri, String.class);
			String roleId = JsonUtils.evaluatePathInJson(response.getBody(), "/RoleRecord/RoleID").asText();
			int result = Integer.parseInt(roleId);
			role.setRoleId(result);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Role: " + role.getName() + " created");
			} else {
				log.info("There was a problem creating the supersede role for name: " + role.getName());
			}
			
			if (response.getStatusCode().equals(HttpStatus.OK) && role.getUsers() != null){
				User[] users = role.getUsers();
				for (int i=0; i<users.length; i++){
					User user = users[i];
					rolesxUsersProxy.addUserForRole(role, user);
				}
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public void updateRole (Role role){
		try {
			Assert.notNull(role, "Role cannot be null");
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + role.getRoleId());
			ResponseEntity<String> response = messageClient.putJsonMessage(role, uri);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role: " + role.getName() + " updated");
			} else {
				log.info("There was a problem updating the supersede role for name: " + role.getName());
			}
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED) && role.getUsers()!= null){
				User[] users = role.getUsers();
				rolesxUsersProxy.deleteAllUsersForRole(role);
				for (int i=0; i<users.length; i++){
					User user = users[i];
					rolesxUsersProxy.addUserForRole(role, user);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRole (Role role){
		try {
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			// Relations between users and roles have to be removed first
			rolesxUsersProxy.deleteAllUsersForRole(role);
						
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + role.getRoleId());
			ResponseEntity<String> response = messageClient.deleteJsonMessage(uri);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role: " + role.getName() + " deleted");
			} else {
				log.info("There was a problem deleting the supersede role for name: " + role.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
