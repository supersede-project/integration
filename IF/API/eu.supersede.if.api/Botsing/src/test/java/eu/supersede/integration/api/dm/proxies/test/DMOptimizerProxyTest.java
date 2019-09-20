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

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.dm.proxies.DMOptimizerProxy;
import eu.supersede.integration.api.dm.types.FeatureConfiguration;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationPublisher;
import eu.supersede.integration.federation.SupersedeFederation;

public class DMOptimizerProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DMOptimizerProxyTest.class);
	private static DMOptimizerProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new DMOptimizerProxy<Object, Object>();
	}

	private boolean subscriptionDone = false;
	private static  SupersedeFederation federation = new SupersedeFederation();

	private void runPublisher() throws NamingException, JsonProcessingException {
		iAdaptationPublisher publisher = null;
		try {
			publisher = new AdaptationPublisher(true, federation.getLocalFederatedSupersedePlatform().getPlatform());
			Alert alert = createAlert();
			publisher.publishAdaptationAlertMesssage(alert);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (publisher != null){
				try {
					publisher.closeTopicConnection();
				} catch (JMSException e) {
					throw new RuntimeException("Error in closing topic connection", e);
				}
			}
		}
	}
	
	private Alert createAlert() {
		Alert alert = new Alert();
		
		alert.setId("id1");
		alert.setApplicationId("appId1");
		alert.setTimestamp(1481717773760L);
		alert.setTenant(ModelSystem.Atos_HSK);
		
		List<Condition> conditions = new ArrayList<Condition>();
		DataID dataId = new DataID();
		dataId.setNameComponent("HSK");
		dataId.setNameQualityMonitored("response_time");
		conditions.add (new Condition(dataId, Operator.GEq, 10.0));
		alert.setConditions(conditions);
		
		return alert;
	}

	
//	@Test
//	public void testOptimize() throws Exception {
//		String system = "Atos_HSK";
//		String featureModelURI = "input/atos_hsk/SmartPlatformFM_HSK.yafm";
//		String featureConfigurationURI = "input/atos_hsk/SmartPlatformFC_HSK_LowLoad.yafc";
//		String alertAttribute = "response_time";
//		String alertThresholdValue = "10";
//		boolean multiObjective = false;
//		FeatureConfiguration result = proxy.optimize(system, featureModelURI, featureConfigurationURI, alertAttribute,
//				alertThresholdValue, multiObjective);
//		Assert.notNull(result);
//	}
	
	@Test
	public void testOptimize() throws Exception {
		runPublisher();
	}

}
