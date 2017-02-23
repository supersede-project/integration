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
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.fe.types.Notification;
import eu.supersede.integration.api.datastore.fe.types.Profile;
import eu.supersede.integration.api.datastore.fe.types.User;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;


public class FEDataStoreProxy<T,S> extends IFServiceProxy<T,S> {
	private static final Logger log = Logger.getLogger(FEDataStoreProxy.class);
	private final static String SUPERSEDE_FE_DS_ENDPOINT = IntegrationProperty.getProperty("fe.datastore.endpoint");

	public List<User> getUsers(String tenantId, boolean lazy, AuthorizationToken authenticationToken)
			throws URISyntaxException {

		Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
		Assert.notNull(authenticationToken, "Provide a valid authentication token");
		Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
		Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
		String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/users";
		if (lazy)
			suri = suri + "_lazy";
		URI uri = new URI(suri);

		log.debug("Sending message getUsers with tenantId: " + tenantId 
				+ ", lazy: " + lazy  + ", authenticationToken: " + authenticationToken 
				+ " to FEDataStore at uri " + uri);
		return getObjectsListForType(User[].class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
	}
	
	public User getUser(String tenantId, int userId, boolean lazy, AuthorizationToken authenticationToken) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(userId >= -1, "User id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/users";
			if (lazy)
				suri = suri + "_lazy";
			suri = suri + "/" + userId;
			URI uri = new URI(suri);
			log.debug("Sending message getUser with tenantId: " + tenantId + ", userId: " + userId 
					+ ", lazy: " + lazy  + ", authenticationToken: " + authenticationToken 
					+ " to FEDataStore at uri " + uri);
			return getObjectForType(User.class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
		}catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public List<Notification> getNotifications(String tenantId, AuthorizationToken authenticationToken) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/notifications";
			URI uri = new URI(suri);
			log.debug("Sending message getNotifications with tenantId: " + tenantId 
					+ ", authenticationToken: " + authenticationToken 
					+ " to FEDataStore at uri " + uri);
			return getObjectsListForType(Notification[].class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public Notification getNotification(String tenantId, int notificationId, AuthorizationToken authenticationToken) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(notificationId > -1, "Notification id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/notifications/" + notificationId;
			URI uri = new URI(suri);
			log.debug("Sending message getNotification with tenantId: " + tenantId 
					+ ", notificationId: " + notificationId 
					+ ", authenticationToken: " + authenticationToken 
					+ " to FEDataStore at uri " + uri);
			return getObjectForType(Notification.class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}	
			
	public List<Profile> getProfiles(String tenantId, AuthorizationToken authenticationToken) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/profiles";
			URI uri = new URI(suri);
			log.debug("Sending message getProfiles with tenantId: " + tenantId 
					+ ", authenticationToken: " + authenticationToken 
					+ " to FEDataStore at uri " + uri);
			return getObjectsListForType(Profile[].class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	public Profile getProfile(String tenantId, int profileId, AuthorizationToken authenticationToken) {
		try {
			Assert.isTrue(tenantId == null || !tenantId.equals(""), "Tenant id cannot be unasigned");
			Assert.isTrue(profileId >= -1, "Profile id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			String suri = SUPERSEDE_FE_DS_ENDPOINT + "tenant/" + tenantId + "/profiles/" + profileId;
			URI uri = new URI(suri);
			log.debug("Sending message getProfile with tenantId: " + tenantId 
					+ ", profileId: " + profileId
					+ ", authenticationToken: " + authenticationToken 
					+ " to FEDataStore at uri " + uri);
			return getObjectForType(Profile.class, uri, HttpStatus.OK, MediaType.APPLICATION_XML, authenticationToken);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
}
