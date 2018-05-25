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

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;
import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.properties.IntegrationProperty;

public class HttpMonitorProxy<T, S> extends MonitorProxy implements IHttpMonitor {
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.http.endpoint");
	IMonitor proxy;

	public HttpMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public HttpMonitorConfiguration createMonitorConfiguration(HttpMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (HttpMonitorConfiguration) createMonitorConfiguration(new HttpMonitorConfigurationRequest(conf),
				HttpMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public HttpMonitorConfiguration updateMonitorConfiguration(HttpMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (HttpMonitorConfiguration) updateMonitorConfiguration(new HttpMonitorConfigurationRequest(conf),
				HttpMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public boolean deleteMonitorConfiguration(HttpMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return deleteMonitorConfiguration(new HttpMonitorConfigurationRequest(conf));
	}
	
	@Override
	public HttpMonitorConfiguration createMonitorConfiguration(HttpMonitorConfiguration conf, Path file) throws Exception {
		Assert.notNull(conf, "Provide a valid HttpMonitorConfiguration conf");
		Assert.notNull(file, "Provide a valid Path file");
		
		return (HttpMonitorConfiguration) sendMonitorConfigurationMultipart(new HttpMonitorConfigurationRequest(conf), file, 
				HttpMonitorConfigurationResponse.class, HttpMethod.POST).getConfiguration();
	}
	
	@Override
	public HttpMonitorConfiguration updateMonitorConfiguration(HttpMonitorConfiguration conf, Path file) throws Exception {
		Assert.notNull(conf, "Provide a valid HttpMonitorConfiguration conf");
		Assert.notNull(file, "Provide a valid Path file");
		
		return (HttpMonitorConfiguration) sendMonitorConfigurationMultipart(new HttpMonitorConfigurationRequest(conf), file, 
				HttpMonitorConfigurationResponse.class, HttpMethod.POST).getConfiguration();
	}

}

class HttpMonitorConfigurationRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "HttpMonitoringConfProf")
	HttpMonitorConfiguration httpMonitoringConfiguration;

//	public HttpMonitorConfiguration getTwitterMonitorConfiguration() {
//		return httpMonitoringConfiguration;
//	}
//
//	public void setTwitterMonitorConfiguration(HttpMonitorConfiguration httpMonitoringConfiguration) {
//		this.httpMonitoringConfiguration = httpMonitoringConfiguration;
//	}

	public HttpMonitorConfigurationRequest(HttpMonitorConfiguration httpMonitoringConfiguration) {
		this.httpMonitoringConfiguration = httpMonitoringConfiguration;
	}

	public HttpMonitorConfigurationRequest() {

	}

	@Override
	public void setId(Integer id) {
		httpMonitoringConfiguration.setId(id);
	}

	@Override
	public Integer getId() {
		return httpMonitoringConfiguration.getId();
	}

	@Override
	@JsonIgnore
	public HttpMonitorConfiguration getConfiguration() {
		return httpMonitoringConfiguration;
	}
	
	@Override
	public String toString (){
		return "{\"HttpMonitoringConfProf\": { "
				+ "\"toolName\":\"" + httpMonitoringConfiguration.getToolName() + "\","
				+ "\"timeSlot\":\"" + httpMonitoringConfiguration.getTimeSlot() + "\","
				+ "\"kafkaEndpoint\":\"" + httpMonitoringConfiguration.getKafkaEndpoint() + "\","
				+ "\"kafkaTopic\":\"" + httpMonitoringConfiguration.getKafkaTopic() + "\","
				+ "\"url\":\"" + httpMonitoringConfiguration.getUrl() + "}}"; 
				
	}
	
	private String asCommaSeparateList (List<String> list){
		return list.stream().map(i -> "\"" + i + "\"").collect(Collectors.joining(", "));
	}
}

class HttpMonitorConfigurationResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "HttpMonitoringConfProfResult")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public HttpMonitorConfigurationResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public HttpMonitorConfigurationResponse() {

	}
}