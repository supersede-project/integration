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
package eu.supersede.integration.api.datastore.proxies.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.api.datastore.proxies.IFDataStoreProxy;
import eu.supersede.integration.api.security.IFAccount;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;

@Ignore
public class IFDataStoreProxyTest {
	private static final Logger log = LoggerFactory.getLogger(IFDataStoreProxyTest.class);
	private static IFDataStoreProxy<Object, Object> proxy;
	private static IFAuthenticationManager am;
	private static AuthorizationToken token;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new IFDataStoreProxy<Object, Object>();
		String admin = IFAccount.getUser();
		String password = IFAccount.getPassword();
		am = new IFAuthenticationManager(admin, password);
		token = am.getAuthorizationToken(admin, password, "");
	}
	
	@Ignore
	@Test
	public void testGetSupersedePlatforms() throws Exception {
		List<SupersedePlatform> platforms = proxy.getSupersedePlatforms(token);
		Assert.notEmpty(platforms);
		for (SupersedePlatform platform : platforms)
			log.debug("Platform: " + platform);
	}

	@Test
	@Ignore
	public void testCreateGetDeleteSupersedePlatform() throws Exception {
		SupersedePlatform platform = testInsertSupersedePlatform();
		platform = testGetSupersedePlatform(platform.getPlatform());
		testDeleteSupersedePlatform(platform.getPlatform());
	}

	@Test
	@Ignore
	public void setupSupersedePlatforms() throws Exception {
		// Reset platforms
		resetPlatforms();

		// Populate Supersede platforms
		populatePlatforms();
	}

	private void populatePlatforms() throws Exception {
		SupersedePlatform platform = createPlatform("development", "admin", "$up3r$3d3", "supersede.es.atos.net:5676");
		assertEquals(proxy.insertSupersedePlatform(platform, token), HttpStatus.ACCEPTED);
		platform = createPlatform("production", "admin", "$up3r$3d3", "platform.supersede.eu:5676");
		assertEquals(proxy.insertSupersedePlatform(platform, token), HttpStatus.ACCEPTED);
		platform = createPlatform("senercon", "admin", "admin2", "mb_senercon.supersede.eu:5676");
		assertEquals(proxy.insertSupersedePlatform(platform, token), HttpStatus.ACCEPTED);
	}

	private void resetPlatforms() throws Exception {
		List<SupersedePlatform> platforms = proxy.getSupersedePlatforms(token);
		for (SupersedePlatform platform : platforms) {
			proxy.deleteSupersedePlatform(platform.getPlatform(), token);
		}
		platforms = proxy.getSupersedePlatforms(token);
		Assert.isTrue(platforms.isEmpty());
	}

	private SupersedePlatform testGetSupersedePlatform(String platformId) throws Exception {
		SupersedePlatform platform = proxy.getSupersedePlatform(platformId, token);
		Assert.notNull(platform);
		log.debug("Platform: " + platform);
		return platform;
	}

	private SupersedePlatform testInsertSupersedePlatform() throws Exception {
		SupersedePlatform platform = createPlatform("test", "supersede", "password_test", "test.supersede.eu:5676");
		assertEquals(proxy.insertSupersedePlatform(platform, token), HttpStatus.ACCEPTED);
		return platform;
	}

	private SupersedePlatform createPlatform(String platformName, String mb_user, String mb_password, String mb_url) {
		SupersedePlatform platform = new SupersedePlatform();
		platform.setPlatform(platformName);
		platform.setMb_User(mb_user);
		platform.setMb_password(mb_password);
		platform.setMb_url(mb_url);
		return platform;
	}

	private void testDeleteSupersedePlatform(String platformId) throws Exception {
		assertEquals(proxy.deleteSupersedePlatform(platformId, token), HttpStatus.ACCEPTED);
	}

}
