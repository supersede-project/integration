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
package eu.supersede.integration.api.monitoring.monitors.proxies;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;
import eu.supersede.integration.api.monitoring.manager.types.DiskMonitorConfiguration;
import eu.supersede.integration.properties.IntegrationProperty;

public class DiskMonitorProxy<T, S> extends MonitorProxy implements IDiskMonitor {
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.disk.endpoint");
	IMonitor proxy;

	public DiskMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public DiskMonitorConfiguration createMonitorConfiguration(DiskMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (DiskMonitorConfiguration) createMonitorConfiguration(new DiskMonitorConfigurationRequest(conf),
				DiskMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public DiskMonitorConfiguration updateMonitorConfiguration(DiskMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (DiskMonitorConfiguration) updateMonitorConfiguration(new DiskMonitorConfigurationRequest(conf),
				DiskMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public boolean deleteMonitorConfiguration(DiskMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return deleteMonitorConfiguration(new DiskMonitorConfigurationRequest(conf));
	}

}

class DiskMonitorConfigurationRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "DiskMonitoringConfProf")
	DiskMonitorConfiguration diskMonitoringConfiguration;


	public DiskMonitorConfigurationRequest(DiskMonitorConfiguration diskMonitoringConfiguration) {
		this.diskMonitoringConfiguration = diskMonitoringConfiguration;
	}

	public DiskMonitorConfigurationRequest() {

	}

	@Override
	public void setId(Integer id) {
		diskMonitoringConfiguration.setId(id);
	}

	@Override
	public Integer getId() {
		return diskMonitoringConfiguration.getId();
	}

	@Override
	@JsonIgnore
	public DiskMonitorConfiguration getConfiguration() {
		return diskMonitoringConfiguration;
	}
	
	@Override
	public String toString (){
		return "{\"DiskMonitoringConfProf\": { "
				+ "\"toolName\":\"" + diskMonitoringConfiguration.getToolName() + "\","
				+ "\"timeSlot\":\"" + diskMonitoringConfiguration.getTimeSlot() + "\","
				+ "\"kafkaEndpoint\":\"" + diskMonitoringConfiguration.getKafkaEndpoint() + "\","
				+ "\"kafkaTopic\":\"" + diskMonitoringConfiguration.getKafkaTopic() + "\","
				+ "\"user\":\"" + diskMonitoringConfiguration.getUser() + "\","
				+ "\"host\":\"" + diskMonitoringConfiguration.getHost() + "\","
				+ "\"instructions\":\"" + diskMonitoringConfiguration.getInstructions() + "}}";				
	}
	
	private String asCommaSeparateList (List<String> list){
		return list.stream().map(i -> "\"" + i + "\"").collect(Collectors.joining(", "));
	}
}

class DiskMonitorConfigurationResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "DiskMonitoringConfProfResult")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public DiskMonitorConfigurationResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public DiskMonitorConfigurationResponse() {

	}
}