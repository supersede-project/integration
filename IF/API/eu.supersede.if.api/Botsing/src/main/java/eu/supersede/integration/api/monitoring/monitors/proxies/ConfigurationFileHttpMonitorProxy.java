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
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfigurationFile;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.properties.IntegrationProperty;

public class ConfigurationFileHttpMonitorProxy<T, S> extends MonitorProxy implements IConfigurationFileHttpMonitor {
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.configurationfilehttp.endpoint");
	IMonitor proxy;

	public ConfigurationFileHttpMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public HttpMonitorConfigurationFile createHTMLMonitorConfigurationFile(HttpMonitorConfigurationFile conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (HttpMonitorConfigurationFile) createMonitorConfiguration(new HttpMonitorConfigurationFileRequest(conf),
				HttpMonitorConfigurationFileResponse.class).getConfiguration();
	}

	@Override
	public HttpMonitorConfigurationFile updateHTMLMonitorConfigurationFile(HttpMonitorConfigurationFile conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (HttpMonitorConfigurationFile) updateMonitorConfiguration(new HttpMonitorConfigurationFileRequest(conf),
				HttpMonitorConfigurationFileResponse.class).getConfiguration();
	}

}

class HttpMonitorConfigurationFileRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "UserEventsConfProf")
	HttpMonitorConfigurationFile httpMonitorConfigurationFile;

	public HttpMonitorConfigurationFileRequest(HttpMonitorConfigurationFile configurationFileHttpMonitorConfiguration) {
		this.httpMonitorConfigurationFile = configurationFileHttpMonitorConfiguration;
	}

	public HttpMonitorConfigurationFileRequest() {

	}

	@Override
	public void setId(Integer id) {
		httpMonitorConfigurationFile.setId(id);
	}

	@Override
	public Integer getId() {
		return httpMonitorConfigurationFile.getId();
	}

	@Override
	@JsonIgnore
	public HttpMonitorConfigurationFile getConfiguration() {
		return httpMonitorConfigurationFile;
	}
	
	@Override
	public String toString (){
		return "{\"UserEventsConfProf\": { "
				+ "\"toolName\":\"" + httpMonitorConfigurationFile.getToolName() + "\","
				+ "\"kafkaEndpoint\":\"" + httpMonitorConfigurationFile.getKafkaEndpoint() + "\","
				+ "\"kafkaTopic\":\"" + httpMonitorConfigurationFile.getKafkaTopic() + "\","
				+ "\"server\":\"" + httpMonitorConfigurationFile.getServer() + "\","
				+ "\"protocol\":\"" + httpMonitorConfigurationFile.getProtocol() + "\","
				+ "\"textContentSize\":\"" + httpMonitorConfigurationFile.getTextContentSize() + "\","
				+ "\"ListOfEvents\":[" + asCommaSeparateList(httpMonitorConfigurationFile.getListOfEvents()) + "]}"; 
	}
	
	private String asCommaSeparateList (List<String> list){
		return list.stream().map(i -> "\"" + i + "\"").collect(Collectors.joining(", "));
	}
}

class HttpMonitorConfigurationFileResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "UserEventsConfProfResults")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public HttpMonitorConfigurationFileResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public HttpMonitorConfigurationFileResponse() {

	}
}