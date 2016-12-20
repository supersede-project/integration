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

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;


public class DecisionMakingSystemProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxyTest.class);
	private DecisionMakingSystemProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new DecisionMakingSystemProxy();
    }

    @Test
    public void testNotifyAlert() throws Exception{
    	Alert alert = createAlert();
    	boolean result = proxy.notifyAlert(alert);
    	Assert.isTrue(result);
    }

	private Alert createAlert() {
		Alert alert = new Alert();
		
		alert.setID("id1");
		alert.setApplicationID("appId1");
		alert.setTimestamp(1481717773760L);
		alert.setTenant("Delta");
		
		List<Condition> conditions = new ArrayList<Condition>();
		conditions.add (new Condition(DataID.UNSPECIFIED, Operator.GEq, 10.5));
		alert.setConditions(conditions);
		
		List<UserRequest> requests = new ArrayList<>();
		String[] feedbackIDs = new String[]{"feedbackId1"};
		String[] features = new String[]{"UI","backend"};
		requests.add(new UserRequest("id1", RequestClassification.FeatureRequest, 
				0.5, "description string", 1, 2, 0, feedbackIDs, features));
		alert.setRequests(requests);
		
		return alert;
	}

}
