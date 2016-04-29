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
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.datasource.poc.authentication.json.JsonUtils;
import eu.supersede.integration.datasource.poc.authentication.types.Role;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class SupersedeDSRolesxUsersProxy {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT = IntegrationProperty.getProperty("supersede.ds.rolesxusers");
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSRolesxUsersProxy.class);

	public void addRoleForUser (Role role, User user){
		try {
			ResponseEntity<String> response = createRoleForUser (role, user);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role " + role.getName() + " added to user " + user.getLogin());
			} else {
				log.info("There was a problem adding the role " + role.getName() + " to user " + user.getLogin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addUserForRole (Role role, User user){
		try {
			ResponseEntity<String> response = createRoleForUser (role, user);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("User " + user.getLogin() + " added to role " + role.getName());
			} else {
				log.info("There was a problem adding the user " + user.getLogin() + " to role " + role.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ResponseEntity<String> createRoleForUser (Role role, User user){
		ResponseEntity<String> response = null;
		try {
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			Assert.isTrue(user.getUserId()>0, "User id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "role/" + role.getRoleId() + "/user/" + user.getUserId());
			response = messageClient.postJsonMessage("{}", uri, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public void deleteRoleForUser (Role role, User user){
		try {
			ResponseEntity<String> response = removeRoleForUser (role, user);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role " + role.getName() + " removed from user " + user.getLogin());
			} else {
				log.info("There was a problem deleting the role " + role.getName() + " for user " + user.getLogin());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUserForRole (User user, Role role){
		try {
			ResponseEntity<String> response = removeRoleForUser (role, user);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("User " + user.getLogin() + " removed from role " + role.getName());
			} else {
				log.info("There was a problem deleting the user " + user.getLogin() + " for role " + role.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllRolesForUser (User user){
		try {
			List<Integer> roleIds = getAllRolesForUser(user);
			for (Integer id: roleIds){
				Role role = new Role();
				role.setRoleId(id.intValue());
				deleteRoleForUser(role, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUserForRole (Role role, User user){
		try {
			ResponseEntity<String> response = removeRoleForUser (role, user);
			if (response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
				log.info("Role " + role.getName() + " removed from user " + user.getLogin());
			} else {
				log.info("There was a problem deleting the user " + user.getLogin() + " from role " + role.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllUsersForRole (Role role){
		try {
			List<Integer> userIds = getAllUsersForRole(role);
			for (Integer id: userIds){
				User user = new User();
				user.setUserId(id.intValue());
				deleteUserForRole(user, role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ResponseEntity<String> removeRoleForUser (Role role, User user){
		ResponseEntity<String> response = null;
		try {
			Assert.isTrue(role.getRoleId()>0, "Role id cannot be unasigned");
			Assert.isTrue(user.getUserId()>0, "User id cannot be unasigned");
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "role/" + role.getRoleId() + "/user/" + user.getUserId());
			response = messageClient.deleteJsonMessage(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public boolean roleHasUser (Role role, User user){
		boolean result = false;
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "role/" + role.getRoleId());
			ResponseEntity<String> response = messageClient.getMessage(uri, String.class, MediaType.APPLICATION_JSON);
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("There was a problem getting users for the role " + role.getName());
			}
			String usersIds = JsonUtils.evaluatePathInJson(response.getBody(), "/userId").asText();
			result = matchId (user.getUserId(), usersIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean userHasRole (User user, Role role){
		boolean result = false;
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "user/" + user.getUserId());
			ResponseEntity<String> response = messageClient.getMessage(uri, String.class, MediaType.APPLICATION_JSON);
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("There was a problem getting roles for the user " + user.getUserId());
			}
			String rolesIds = JsonUtils.evaluatePathInJson(response.getBody(), "/roleId").asText();
			result = matchId (role.getRoleId(), rolesIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Integer> getAllRolesForUser(User user){
		List<Integer> result = null;
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "user/" + user.getUserId());
			ResponseEntity<String> response = messageClient.getMessage(uri, String.class, MediaType.APPLICATION_JSON);
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("There was a problem getting roles for the user " + user.getLogin());
			}
			String rolesIds = JsonUtils.evaluatePathInJson(response.getBody(), "/roleId").asText();
			result = getArray (rolesIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Integer> getAllUsersForRole(Role role){
		List<Integer> result = null;
		try {
			URI uri = new URI(SUPERSEDE_DS_ROLEXxUSERS_ENDPOINT + "role/" + role.getRoleId());
			ResponseEntity<String> response = messageClient.getMessage(uri, String.class, MediaType.APPLICATION_JSON);
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("There was a problem getting users for the role " + role.getName());
			}
			String userIds = JsonUtils.evaluatePathInJson(response.getBody(), "/userId").asText();
			result = getArray (userIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	private List<Integer> getArray(String ids) {
		ids = ids.substring(1, ids.length()-1);
		StringTokenizer st = new StringTokenizer(ids, ",");
		List<Integer> result = new ArrayList<Integer>();
		while (st.hasMoreTokens()){
			result.add(Integer.parseInt(st.nextToken()));
		}
		return result;
	}

	private boolean matchId(int id, String ids) {
		ids = ids.substring(1, ids.length()-1);
		StringTokenizer st = new StringTokenizer(ids, ",");
		boolean result = false;
		while (st.hasMoreTokens()){
			if (id == Integer.parseInt(st.nextToken())){
				result = true;
				break;
			}
		}
		return result;
	}
}
