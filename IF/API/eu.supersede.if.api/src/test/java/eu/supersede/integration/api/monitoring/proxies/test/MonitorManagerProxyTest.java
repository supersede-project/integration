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

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.monitoring.manager.proxies.MonitorManagerProxy;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import org.junit.Assert;

public class MonitorManagerProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static MonitorManagerProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new MonitorManagerProxy<MonitorSpecificConfiguration, Object>();
	}

	@Test
	public void testCreateUpdateAndDeleteTwitterMonitorConfiguration() throws Exception {
		TwitterMonitorConfiguration conf = createTwitterMonitorConfiguration();
		conf = proxy.createMonitorConfiguration(conf);
		Assert.assertNotNull(conf);
		conf.setTimeSlot(60);
		assertEquals(proxy.updateMonitorConfiguration(conf), HttpStatus.OK);
		assertEquals(proxy.deleteMonitorConfiguration(conf), HttpStatus.OK);
	}

	private TwitterMonitorConfiguration createTwitterMonitorConfiguration() throws MalformedURLException {
		TwitterMonitorConfiguration twitterConf = new TwitterMonitorConfiguration();
		twitterConf.setToolName("TwitterAPI");
		twitterConf.setTimeSlot(30);
		twitterConf.setKafkaEndpoint(new URL("http://localhost:9092"));
		twitterConf.setKafkaTopic("tweeterMonitoring");
		twitterConf.setKeywordExpression("(olympics) AND (streaming)");

		return twitterConf;
	}

	@Ignore
	@Test
	public void testCreateUpdateAndDeleteHttpMonitorConfiguration() throws Exception {
		HttpMonitorConfiguration conf = createHttpMonitorConfiguration();
		conf = proxy.createMonitorConfiguration(conf);
		Assert.assertNotNull(conf);
		conf.setTimeSlot(60);
		assertEquals(proxy.updateMonitorConfiguration(conf), HttpStatus.OK);
		assertEquals(proxy.deleteMonitorConfiguration(conf), HttpStatus.OK);
	}

	private HttpMonitorConfiguration createHttpMonitorConfiguration() throws MalformedURLException {
		HttpMonitorConfiguration httpConf = new HttpMonitorConfiguration();
		httpConf.setToolName("ApacheHttp");
		httpConf.setTimeSlot(30000);
		httpConf.setKafkaTopic("httpStress");
		httpConf.setUrl("http://lab-supersede.atos-sports.tv:8000/handshake_test.php");
		httpConf.setMethod(Method.GET);

		return httpConf;
	}

}
