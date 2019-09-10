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
import java.util.UUID;

import org.joda.time.field.UnsupportedDurationField;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.proxies.MonitoringOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorTool;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorType;

public class MonitoringOrchestratorProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static MonitoringOrchestratorProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		String user = "superadmin";
		String password = "password";
		proxy = new MonitoringOrchestratorProxy<Object, Object>(user, password);
	}

	@Test
	public void testListAllMonitorTypes() throws Exception {
		//Populate with a monitor type
		createMonitorType();
		
		List<MonitorType> result = proxy.listAllMonitorTypes();
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testCreateGetDeleteMonitorType() throws Exception {
		MonitorType result = createMonitorType();

		result = proxy.getMonitorType(result.getName());
		Assert.notNull(result);

		proxy.deleteMonitorType(result);
	}

	private MonitorType createMonitorType() throws Exception {
		String monitorTypeName = UUID.randomUUID().toString() ;
		//Remote monitor if exist
		try{
			MonitorType mt = proxy.getMonitorType(monitorTypeName);
			if (mt != null){
				proxy.deleteMonitorType(mt);
			}
		}catch (Exception ex){
			//Ignore - monitor type does not exist
		}
		
		MonitorType monitorType = new MonitorType();
		monitorType.setName(monitorTypeName);
		MonitorType result = proxy.createMonitorType(monitorType);
		Assert.notNull(result);
		return result;
	}

	@Test
	public void testCreateGetDeleteMonitorTool() throws Exception {
		MonitorType monitorType = createMonitorType();
		MonitorTool monitorTool = createMonitorTool(monitorType);

		monitorTool = proxy.getMonitorToolForMonitorType(monitorTool.getName(), monitorType.getName());
		Assert.notNull(monitorTool);

		proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());

		proxy.deleteMonitorType(monitorType);
	}

	private MonitorTool createMonitorTool(MonitorType monitorType) throws Exception {
		
		//Remote monitor if exist
		String monitorToolName = UUID.randomUUID().toString() ;
		try{
			MonitorTool mt = proxy.getMonitorToolForMonitorType(monitorToolName, monitorType.getName());
			if (mt != null){
				proxy.deleteMonitorToolForMonitorType(mt, monitorType.getName());
			}
		}catch (Exception ex){
			//Ignore - monitor tool does not exist
		}
		
		MonitorTool monitorTool = new MonitorTool();
		monitorTool.setName(monitorToolName);
		monitorTool.setMonitorName("Twitter");

		monitorTool = proxy.createMonitorToolForMonitorType(monitorTool, monitorType.getName());
		Assert.notNull(monitorTool);
		return monitorTool;
	}


	@Test
	@Ignore
	public void testCreateGetUpdateDeleteMonitorConfiguration() throws Exception {
		
		MonitorType monitorType = createMonitorType();
		MonitorTool monitorTool = createMonitorTool(monitorType);

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

		proxy.deleteMonitorToolForMonitorType(monitorTool, monitorType.getName());

		proxy.deleteMonitorType(monitorType);
	}

}
