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
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.Method;
import eu.supersede.integration.api.monitoring.monitors.proxies.HttpMonitorProxy;

public class HttpMonitorProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static HttpMonitorProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new HttpMonitorProxy<Object, Object>();
	}

	@Ignore
	@Test
	public void testCreateAndDeleteMonitorConfiguration() throws Exception {
		HttpMonitorConfiguration conf = createMonitorConfiguration();
		HttpMonitorConfiguration result = proxy.createMonitorConfiguration(conf);
		Assert.notNull(result);
		Assert.isTrue(result.getId()>0);
		proxy.deleteMonitorConfiguration(conf);
	}
	
	@Test
	public void testCreateAndDeleteMonitorConfigurationMultipart() throws Exception {
		HttpMonitorConfiguration conf = createMonitorConfiguration();
		Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
		HttpMonitorConfiguration result = proxy.createMonitorConfiguration(conf, file );
		Assert.notNull(result);
		Assert.isTrue(result.getId()>0);
		proxy.deleteMonitorConfiguration(conf);
	}
	
	@Ignore
	@Test
	public void testUpdateMonitorConfiguration() throws Exception {
		HttpMonitorConfiguration conf = createMonitorConfiguration();
		HttpMonitorConfiguration result = proxy.createMonitorConfiguration(conf);
		Assert.notNull(result);
		result.setTimeSlot(6000);
		result = proxy.updateMonitorConfiguration(result);
		Assert.notNull(result);
		Assert.isTrue(result.getTimeSlot() == 6000);
	}
	
	@Test
	public void testUpdateMonitorConfigurationMultipart() throws Exception {
		HttpMonitorConfiguration conf = createMonitorConfiguration();
		Path file = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
		HttpMonitorConfiguration result = proxy.createMonitorConfiguration(conf, file);
		Assert.notNull(result);
		result.setTimeSlot(6000);
		result = proxy.updateMonitorConfiguration(result);
		Assert.notNull(result);
		Assert.isTrue(result.getTimeSlot() == 6000);
	}

	private HttpMonitorConfiguration createMonitorConfiguration() throws MalformedURLException {
		HttpMonitorConfiguration conf = new HttpMonitorConfiguration();
		conf.setToolName("ApacheHttp");
		conf.setTimeSlot(3000);
		conf.setKafkaTopic("http");
		conf.setUrl("http://lab-supersede.atos-sports.tv:8000/handshake_test.php");
		conf.setMethod(Method.GET);
		return conf;
	}

}
