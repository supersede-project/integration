package eu.supersede.integration.datasource.poc.authentication.proxies;

import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.datasource.poc.authentication.json.JsonUtils;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.RolesCollection;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class SupersedeDSRolesProxy {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_DS_ROLES_ENDPOINT = IntegrationProperty.getProperty("supersede.ds.roles");
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesProxy.class);
	
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
	
	public int insertRole (Role role){
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT);
			ResponseEntity<String> response = messageClient.postJsonMessage(role, uri, String.class);
			String roleId = JsonUtils.evaluatePathInJson(response.getBody(), "/RoleRecord/RoleID");
			int result = Integer.parseInt(roleId);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Role: " + role.getName() + " created");
			} else {
				log.info("There was a problem creating the supersede role for name: " + role.getName());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
