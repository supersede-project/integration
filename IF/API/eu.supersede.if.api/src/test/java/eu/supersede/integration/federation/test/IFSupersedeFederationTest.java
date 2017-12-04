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
package eu.supersede.integration.federation.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.federation.SupersedeFederation;


public class IFSupersedeFederationTest {
	private static final Logger log = LoggerFactory.getLogger(IFSupersedeFederationTest.class);
	private static SupersedeFederation federation;
	
    @BeforeClass
    public static void setup() throws Exception {
        federation = new SupersedeFederation();
    }

	@Test
    public void testSupersedeFederation() throws Exception{
    	List<SupersedePlatform> platforms = federation.getFederatedSupersedePlatforms();
    	Assert.notEmpty(platforms);
    	
    	SupersedePlatform localPlatform = federation.getLocalFederatedSupersedePlatform();
    	Assert.notNull(localPlatform);
    	
    }
    
}
