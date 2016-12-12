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

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.orchestrator.proxies.MonitoringOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorTool;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorType;

public class MonitoringOrchestratorProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private MonitoringOrchestratorProxy<?, ?> proxy;

	@Before
	public void setup() throws Exception {
		proxy = new MonitoringOrchestratorProxy<Object, Object>();
	}

	@Test
	public void testListAllMonitorTypes() throws Exception {
		List<MonitorType> result = proxy.listAllMonitorTypes();
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testCreateGetDeleteMonitorType() throws Exception {
		MonitorType monitorType = new MonitorType();
		monitorType.setName("MonitorTypeTest");
		MonitorType result = proxy.createMonitorType(monitorType);
		Assert.notNull(result);

		result = proxy.getMonitorType(result.getName());
		Assert.notNull(result);

		proxy.deleteMonitorType(result);
	}

	@Test
	public void testCreateGetDeleteMonitorTool() throws Exception {
		MonitorType monitorType = new MonitorType();
		monitorType.setName("MonitorTypeTest2");
		MonitorType monitorTypeResult = proxy.createMonitorType(monitorType);
		Assert.notNull(monitorTypeResult);

		MonitorTool monitorTool = new MonitorTool();
		monitorTool.setName("TwitterAPITest2");
		monitorTool.setMonitorName("TwitterAPIMonitorTest2");

		MonitorTool monitorToolResult = proxy.createMonitorToolForMonitorType(monitorTool, monitorType.getName());
		Assert.notNull(monitorToolResult);

		monitorToolResult = proxy.getMonitorToolForMonitorType(monitorToolResult.getName(), monitorType.getName());
		Assert.notNull(monitorToolResult);

		proxy.deleteMonitorToolForMonitorType(monitorToolResult, monitorType.getName());

		proxy.deleteMonitorType(monitorTypeResult);
	}

	@Test
	public void testCreateGetUpdateDeleteMonitorConfiguration() throws Exception {
		MonitorType monitorType = new MonitorType();
		monitorType.setName("MonitorTypeForTest3");
		MonitorType monitorTypeResult = proxy.createMonitorType(monitorType);
		Assert.notNull(monitorTypeResult);

		MonitorTool monitorTool = new MonitorTool();
		monitorTool.setName("TwitterAPIForTest3");
		monitorTool.setMonitorName("TwitterAPIMonitorForTest3");

		MonitorTool monitorToolResult = proxy.createMonitorToolForMonitorType(monitorTool, monitorType.getName());
		Assert.notNull(monitorToolResult);

		MonitorConfiguration conf = new MonitorConfiguration();
		conf.setKafkaEndpoint("http://localhost:9092");
		conf.setKafkaTopic("olympicGamesTwitterMonitoring");
		conf.setKeywordExpression("keyword1 AND keyword2");
		conf.setState("active");
		conf.setTimeSlot("300");
		conf.setConfigSender("WP4");
		conf.setTimeStamp("Sat June 08 02:16:57 2016");

		MonitorConfiguration monitorConfigurationResult = proxy.createMonitorConfigurationForMonitorToolAndMonitorType(
				conf, monitorTool.getName(), monitorType.getName());
		Assert.notNull(monitorConfigurationResult);

		monitorConfigurationResult = proxy.getMonitorConfigurationForMonitorToolAndMonitorType(
				monitorConfigurationResult.getId(), monitorTool.getName(), monitorType.getName());
		Assert.notNull(monitorConfigurationResult);

		monitorConfigurationResult.setTimeSlot("100");
		
		monitorConfigurationResult = proxy.updateMonitorConfigurationForMonitorToolAndMonitorType(
					monitorConfigurationResult, monitorTool.getName(), monitorType.getName());
		Assert.notNull(monitorConfigurationResult);

		proxy.deleteMonitorConfigurationForMonitorToolAndMonitorType(monitorConfigurationResult, monitorTool.getName(),
				monitorType.getName());

		proxy.deleteMonitorToolForMonitorType(monitorToolResult, monitorType.getName());

		proxy.deleteMonitorType(monitorTypeResult);
	}

}
