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
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile;
import eu.supersede.integration.api.monitoring.monitors.proxies.ConfigurationFileHttpMonitorProxy;

public class ConfigurationFileHttpMonitorProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private ConfigurationFileHttpMonitorProxy<?, ?> proxy;

	@Before
	public void setup() throws Exception {
		proxy = new ConfigurationFileHttpMonitorProxy<Object, Object>();
	}
	
	@Test
	public void testCreateMonitorConfiguration() throws Exception {
		HttpMonitorConfigurationFile conf = createMonitorConfiguration();
		HttpMonitorConfigurationFile result = proxy.createHTMLMonitorConfigurationFile(conf);
		Assert.notNull(result);
	}

	private HttpMonitorConfigurationFile createMonitorConfiguration() throws MalformedURLException {
		HttpMonitorConfigurationFile conf = new HttpMonitorConfigurationFile();
		conf.setToolName("HTMLMonitor");
		conf.setKafkaEndpoint(new URL("http://localhost:9092"));
		conf.setKafkaTopic("http");
		conf.setServer("production");
		conf.setProtocol("HTTPS");
		conf.setTextContentSize(150);
		conf.setListOfEvents(Arrays.asList("change", "input", "submit"));
		return conf;
	}

}
