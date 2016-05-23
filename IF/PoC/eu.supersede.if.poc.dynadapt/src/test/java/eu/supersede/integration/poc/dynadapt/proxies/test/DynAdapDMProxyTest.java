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
package eu.supersede.integration.poc.dynadapt.proxies.test;

import java.util.Collection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.poc.dynadapt.Dashboard;
import eu.supersede.integration.poc.dynadapt.proxies.DynAdapDMProxy;
import eu.supersede.integration.poc.dynadapt.test.SpringAppTest;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.CollectionOfDecisions;
import eu.supersede.integration.properties.IntegrationProperty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Dashboard.class)
//@WebAppConfiguration
@WebIntegrationTest
public class DynAdapDMProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DynAdapDMProxyTest.class);
	private static boolean ready = false;
	private static IFAuthenticationManager am;
	private static AuthorizationToken token;
	
	public static void setReady(boolean ready){
		DynAdapDMProxyTest.ready = ready;
	}
	
    @Before
    public void setup() throws Exception {
    	String admin = IntegrationProperty.getProperty("is.admin.user");
		String password = IntegrationProperty.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken("yosu", "yosupass", "");
    }

    @Test
    public void testGetAdaptationDecisions() throws Exception{
    	log.info("Testing testGetAdaptationDecisions");
		Collection<AdaptationDecision> decisions = new DynAdapDMProxy().getAdaptationDecisions(UUID.randomUUID(), token);
		Assert.assertTrue(!decisions.isEmpty());
    }
    
    @Test
    public void testGetAllAdaptationDecisions() throws Exception{
    	log.info("Testing testGetAllAdaptationDecisions");
    	CollectionOfDecisions decisions = new DynAdapDMProxy().getAllAdaptationDecisions(UUID.randomUUID(), token);
    	Assert.assertTrue(!decisions.getCollection().isEmpty());
    }
}
