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

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.proxies.DMOptimizerProxy;
import eu.supersede.integration.api.dm.types.FeatureConfiguration;

public class DMOptimizerProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DMOptimizerProxyTest.class);
	private static DMOptimizerProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new DMOptimizerProxy<Object, Object>();
	}

	
	@Test
	public void testOptimize() throws Exception {
		String system = "Atos_HSK";
		String featureModelURI = "input/atos_hsk/SmartPlatformFM_HSK.yafm";
		String featureConfigurationURI = "input/atos_hsk/SmartPlatformFC_HSK_LowLoad.yafc";
		String alertAttribute = "response_time";
		String alertThresholdValue = "10";
		boolean multiObjective = false;
		FeatureConfiguration result = proxy.optimize(system, featureModelURI, featureConfigurationURI, alertAttribute,
				alertThresholdValue, multiObjective);
		Assert.notNull(result);
	}

}
