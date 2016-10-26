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
package eu.supersede.integration.api.dm.proxies.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.AlertLevel;

public class DecisionMakingSystemProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxyTest.class);
	private DecisionMakingSystemProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new DecisionMakingSystemProxy();
    }

    @Test
    public void testNotifyAlert() throws Exception{
    	Alert alert = new Alert(AlertLevel.Normal, "1", "Message", 10.0 );
    	boolean result = proxy.notifyAlert(alert);
    	Assert.isTrue(result);
    }

}
