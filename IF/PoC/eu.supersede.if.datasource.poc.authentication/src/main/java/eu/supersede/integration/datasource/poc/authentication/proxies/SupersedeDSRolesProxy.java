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
package eu.supersede.integration.datasource.poc.authentication.proxies;

import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.security.types.AuthorizationToken;
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
	public RolesCollection getRoles(AuthorizationToken token) {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT);
			ResponseEntity<Role[]> response = messageClient.getMessage(uri, Role[].class, MediaType.APPLICATION_XML, token);
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
	
	public Role getRole(int roleId, AuthorizationToken token) {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + roleId);
			ResponseEntity<Role> response = messageClient.getMessage(uri, Role.class, MediaType.APPLICATION_XML, token);
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
	
	public Role getRoleWithUsers(int roleId, AuthorizationToken token) {
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + roleId + "/withUsers");
			ResponseEntity<Role> response = messageClient.getMessage(uri, Role.class, MediaType.APPLICATION_XML, token);
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
	
	public int createRole (Role role, AuthorizationToken token){
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT);
			ResponseEntity<String> response = messageClient.postJsonMessage(role, uri, String.class, token);
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
					rolesxUsersProxy.addUserForRole(role, user, token);
				}
			}
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public void updateRole (Role role, AuthorizationToken token){
		try {
			Assert.notNull(role, "Role cannot be null");
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + role.getRoleId());
			ResponseEntity<String> response = messageClient.putJsonMessage(role, uri, token);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role: " + role.getName() + " updated");
			} else {
				log.info("There was a problem updating the supersede role for name: " + role.getName());
			}
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED) && role.getUsers()!= null){
				User[] users = role.getUsers();
				rolesxUsersProxy.deleteAllUsersForRole(role, token);
				for (int i=0; i<users.length; i++){
					User user = users[i];
					rolesxUsersProxy.addUserForRole(role, user, token);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRole (Role role, AuthorizationToken token){
		try {
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			// Relations between users and roles have to be removed first
			rolesxUsersProxy.deleteAllUsersForRole(role, token);
						
			URI uri = new URI(SUPERSEDE_DS_ROLES_ENDPOINT + role.getRoleId());
			ResponseEntity<String> response = messageClient.deleteJsonMessage(uri, token);
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
