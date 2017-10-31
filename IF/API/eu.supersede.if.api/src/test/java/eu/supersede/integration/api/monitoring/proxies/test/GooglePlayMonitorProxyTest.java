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
package eu.supersede.integration.api.monitoring.proxies.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.monitors.proxies.GooglePlayMonitorProxy;

public class GooglePlayMonitorProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static GooglePlayMonitorProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new GooglePlayMonitorProxy<Object, Object>();
	}

	@Test
	public void testCreateAndDeleteMonitorConfiguration() throws Exception {
		GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
		GooglePlayMonitorConfiguration result = proxy.createMonitorConfiguration(conf);
		Assert.notNull(result);
		Assert.isTrue(result.getId()>0);
		proxy.deleteMonitorConfiguration(conf);
	}
	
	@Test
	public void testUpdateMonitorConfiguration() throws Exception {
		GooglePlayMonitorConfiguration conf = createMonitorConfiguration();
		GooglePlayMonitorConfiguration result = proxy.createMonitorConfiguration(conf);
		Assert.notNull(result);
		result.setTimeSlot(60);
		result = proxy.updateMonitorConfiguration(result);
		Assert.notNull(result);
		Assert.isTrue(result.getTimeSlot() == 60);
	}
	
	private GooglePlayMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
		GooglePlayMonitorConfiguration conf = new GooglePlayMonitorConfiguration();
		conf.setToolName("AppTweak");
		conf.setTimeSlot(30);
		conf.setKafkaEndpoint(new URL("http://localhost:9092"));
		conf.setKafkaTopic("MarketPlace");
		conf.setPackageName("com.facebook.katana");;
		return conf;
	}

}
