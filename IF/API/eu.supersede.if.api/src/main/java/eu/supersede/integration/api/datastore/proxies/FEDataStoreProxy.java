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
package eu.supersede.integration.api.datastore.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.fe.types.Notification;
import eu.supersede.integration.api.datastore.fe.types.Profile;
import eu.supersede.integration.api.datastore.fe.types.User;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class FEDataStoreProxy{
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_FE_DS_ENDPOINT = IntegrationProperty.getProperty("fe.datastore.endpoint");
	private static final Logger log = LoggerFactory.getLogger(FEDataStoreProxy.class);
	
	
	public List<User> getUsers(String tenantId, boolean lazy) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/users";
			if (lazy) suri = suri + "_lazy";
			URI uri = new URI(suri);
			ResponseEntity<User[]> response = messageClient.getMessage(uri, User[].class, MediaType.APPLICATION_XML);
			User[] collection = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + collection.length + " user(s)");
			} else {
				log.info("There was a problem getting supersede users for tenant " + tenantId);
			}
			return Arrays.asList(collection);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUser(String tenantId, int userId, boolean lazy) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(userId>-1, "User id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/users";
			if (lazy) suri = suri + "_lazy";
			suri = suri + "/" + userId;
			URI uri = new URI(suri);
			ResponseEntity<User> response = messageClient.getMessage(uri, User.class, MediaType.APPLICATION_XML);
			User user = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located user: " + user.getName());
			} else {
				log.info("There was a problem getting the supersede user for id: " + userId + " and tenant: " + tenantId);
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Notification> getNotifications(String tenantId) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/notifications";
			URI uri = new URI(suri);
			ResponseEntity<Notification[]> response = messageClient.getMessage(uri, Notification[].class, MediaType.APPLICATION_XML);
			Notification[] collection = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + collection.length + " notifications(s)");
			} else {
				log.info("There was a problem getting supersede notifications for tenant " + tenantId);
			}
			return Arrays.asList(collection);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Notification getNotification(String tenantId, int notificationId) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(notificationId>-1, "Notification id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/notifications/" + notificationId;
			URI uri = new URI(suri);
			ResponseEntity<Notification> response = messageClient.getMessage(uri, Notification.class, MediaType.APPLICATION_XML);
			Notification notification = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located notification: " + notification.getNotification_id());
			} else {
				log.info("There was a problem getting the supersede notification for id: " + notificationId + " and tenant: " + tenantId);
			}
			return notification;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Profile> getProfiles(String tenantId) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/profiles";
			URI uri = new URI(suri);
			ResponseEntity<Profile[]> response = messageClient.getMessage(uri, Profile[].class, MediaType.APPLICATION_XML);
			Profile[] collection = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + collection.length + " profile(s)");
			} else {
				log.info("There was a problem getting supersede profile for tenant " + tenantId);
			}
			return Arrays.asList(collection);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Profile getProfile(String tenantId, int profileId) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(profileId>-1, "Profile id cannot be unasigned");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/profiles/" + profileId;
			URI uri = new URI(suri);
			ResponseEntity<Profile> response = messageClient.getMessage(uri, Profile.class, MediaType.APPLICATION_XML);
			Profile profile = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located profile: " + profile.getName());
			} else {
				log.info("There was a problem getting the supersede profile for id: " + profileId + " and tenant: " + tenantId);
			}
			return profile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
