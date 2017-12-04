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

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.api.datastore.proxies.IFDataStoreProxy;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;


public class IFDataStoreProxyTest {
	private static final Logger log = LoggerFactory.getLogger(IFDataStoreProxyTest.class);
	private static IFDataStoreProxy<Object, Object> proxy;
	private static IFAuthenticationManager am;
	private static AuthorizationToken token;
	
    @BeforeClass
    public static void setup() throws Exception {
        proxy = new IFDataStoreProxy<Object, Object> ();
        String admin = System.getProperty("is.admin.user");
		String password = System.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken(admin, password, "");
    }

    @Test
    public void testGetSupersedePlatforms() throws Exception{
    	List<SupersedePlatform> platforms = proxy.getSupersedePlatforms(token);
    	Assert.notEmpty(platforms);
    	for (SupersedePlatform platform: platforms)
    		log.debug("Platform: " + platform);
    }
    
    @Test
    public void testGetSupersedePlatform() throws Exception{
    	String platformId = "test";
    	SupersedePlatform platform = proxy.getSupersedePlatform(platformId, token);
    	Assert.notNull(platform);
    	log.debug("Platform: " + platform);
    }
    
    @Test
    public void testInsertSupersedePlatform() throws Exception{
    	SupersedePlatform platform = new SupersedePlatform();
    	platform.setPlatform("test");
    	platform.setMb_User("supersede");
    	platform.setMb_password("password_test");
    	Boolean result = proxy.insertSupersedePlatform(platform, token);
    	Assert.isTrue (result);
    }
    
}
