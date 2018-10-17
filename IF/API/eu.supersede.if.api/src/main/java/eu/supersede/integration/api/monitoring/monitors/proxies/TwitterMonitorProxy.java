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

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.properties.IntegrationProperty;

public class TwitterMonitorProxy<T, S> extends MonitorProxy implements ITwitterMonitor {
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.twitter.endpoint");
	IMonitor proxy;

	public TwitterMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public TwitterMonitorConfiguration createMonitorConfiguration(TwitterMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (TwitterMonitorConfiguration) createMonitorConfiguration(new TwitterMonitorConfigurationRequest(conf),
				TwitterMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public TwitterMonitorConfiguration updateMonitorConfiguration(TwitterMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return (TwitterMonitorConfiguration) updateMonitorConfiguration(new TwitterMonitorConfigurationRequest(conf),
				TwitterMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public HttpStatus deleteMonitorConfiguration(TwitterMonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		return deleteMonitorConfiguration(new TwitterMonitorConfigurationRequest(conf));
	}

}

class TwitterMonitorConfigurationRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "SocialNetworksMonitoringConfProf")
	TwitterMonitorConfiguration twitterMonitoringConfiguration;

	public TwitterMonitorConfiguration getTwitterMonitorConfiguration() {
		return twitterMonitoringConfiguration;
	}

	public void setTwitterMonitorConfiguration(TwitterMonitorConfiguration twitterMonitoringConfiguration) {
		this.twitterMonitoringConfiguration = twitterMonitoringConfiguration;
	}

	public TwitterMonitorConfigurationRequest(TwitterMonitorConfiguration twitterMonitoringConfiguration) {
		this.twitterMonitoringConfiguration = twitterMonitoringConfiguration;
	}

	public TwitterMonitorConfigurationRequest() {

	}

	@Override
	public void setId(Integer id) {
		twitterMonitoringConfiguration.setId(id);
	}

	@Override
	public Integer getId() {
		return twitterMonitoringConfiguration.getId();
	}

	@Override
	public TwitterMonitorConfiguration getConfiguration() {
		return getTwitterMonitorConfiguration();
	}
	
	@Override
	public String toString (){
		return "\"SocialNetworksMonitoringConfProf\": { "
				+ "\"toolName\":\"" + twitterMonitoringConfiguration.getToolName() + "\","
				+ "\"timeSlot\":\"" + twitterMonitoringConfiguration.getTimeSlot() + "\","
				+ "\"kafkaEndpoint\":\"" + twitterMonitoringConfiguration.getKafkaEndpoint() + "\","
				+ "\"kafkaTopic\":\"" + twitterMonitoringConfiguration.getKafkaTopic() + "\","
				+ "\"keywordExpression\":\"" + twitterMonitoringConfiguration.getKeywordExpression() + "\","
				+ "\"accounts\":[" + asCommaSeparateList(twitterMonitoringConfiguration.getAccounts()) + "]}}"; 
	}
	
	private String asCommaSeparateList (List<String> list){
		return list.stream().map(i -> "\"" + i + "\"").collect(Collectors.joining(", "));
	}
}

class TwitterMonitorConfigurationResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "SocialNetworksMonitoringConfProfResult")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public TwitterMonitorConfigurationResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public TwitterMonitorConfigurationResponse() {

	}
}