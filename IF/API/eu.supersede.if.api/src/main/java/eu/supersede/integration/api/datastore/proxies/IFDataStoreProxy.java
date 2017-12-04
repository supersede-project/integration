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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.api.datastore.util.PasswordCrypt;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class IFDataStoreProxy<T, S> extends IFServiceProxy<T, S> implements IFDataStore {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_IF_DS_ENDPOINT = IntegrationProperty.getProperty("if.datastore.endpoint");
	private final static String SUPERSEDE_IF_DS_KEY = IntegrationProperty.getProperty("if.datastore.key");
	

	@Override
	public List<SupersedePlatform> getSupersedePlatforms(AuthorizationToken authenticationToken)
			throws Exception {
		
		Assert.notNull(authenticationToken, "Provide a valid authentication token");
		Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
		Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
		URI uri = new URI(SUPERSEDE_IF_DS_ENDPOINT + "mb/accounts");

		log.debug("Sending message getSupersedePlatforms to IFDataStore at uri " + uri);
		List<SupersedePlatform> platforms =  getObjectsListForType(SupersedePlatform[].class, uri, HttpStatus.OK, MediaType.APPLICATION_XML,
				authenticationToken);
		
		//Decrypt platforms mb_password
		for (SupersedePlatform platform: platforms)
			platform.setMb_password(PasswordCrypt.decryptPassword(platform.getMb_password(), SUPERSEDE_IF_DS_KEY));
		
		return platforms;
	}

	@Override
	public SupersedePlatform getSupersedePlatform(String platformId, AuthorizationToken authenticationToken) throws Exception {
		try {
			Assert.notNull(platformId, "PlatformId id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			URI uri = new URI(SUPERSEDE_IF_DS_ENDPOINT + "mb/accounts/" + platformId);

			log.debug("Sending message getSupersedePlatform with platformId: " + platformId + " to IFDataStore at uri "
					+ uri);
			SupersedePlatform platform = getObjectForType(SupersedePlatform.class, uri, HttpStatus.OK, MediaType.APPLICATION_XML,
					authenticationToken);
			
			//Decrypt platform mb_password
			platform.setMb_password(PasswordCrypt.decryptPassword(platform.getMb_password(), SUPERSEDE_IF_DS_KEY));
			
			return platform;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public boolean insertSupersedePlatform(SupersedePlatform platform, AuthorizationToken authenticationToken) throws Exception {
		try {
			Assert.notNull(platform, "Platform id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			
			//Encrypt platform mb_password
			platform.setMb_password(PasswordCrypt.encryptPassword(platform.getMb_password(), SUPERSEDE_IF_DS_KEY));
			
			URI uri = new URI(SUPERSEDE_IF_DS_ENDPOINT + "mb/accounts?" + 
					"platform=" + platform.getPlatform() + "&" + 
					"user=" + platform.getMb_user() + "&" + 
					"password=" + platform.getMb_password() + "&" + 
					"mb_url=" + platform.getMb_url());

			log.debug("Sending message insertSupersedePlatform with platformId: " + platform.getPlatform()
					+ " ,mb_user: " + platform.getMb_user() + " ,mb_password: " + platform.getMb_password()
					+ " ,mb_url: " + platform.getMb_url()
					+ " to IFDataStore at uri " + uri);
			
			return insertJSONObject("{}", uri, HttpStatus.ACCEPTED, authenticationToken.getAccessToken());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
	
	@Override
	public boolean deleteSupersedePlatform(String platformId, AuthorizationToken authenticationToken) throws Exception {
		try {
			Assert.notNull(platformId, "PlatformId id cannot be unasigned");
			Assert.notNull(authenticationToken, "Provide a valid authentication token");
			Assert.notNull(authenticationToken.getAccessToken(), "Provide a valid authentication token");
			Assert.isTrue(!authenticationToken.getAccessToken().isEmpty(), "Provide a valid authentication token");
			URI uri = new URI(SUPERSEDE_IF_DS_ENDPOINT + "mb/accounts/" + platformId);

			log.debug("Sending message deleteSupersedePlatform with platformId: " + platformId + " to IFDataStore at uri "
					+ uri);
			return deleteUriResource(uri, HttpStatus.ACCEPTED, authenticationToken.getAccessToken()); 
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
	}
}
