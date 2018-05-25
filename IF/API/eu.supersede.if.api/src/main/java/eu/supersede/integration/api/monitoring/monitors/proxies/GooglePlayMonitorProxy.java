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

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;
import eu.supersede.integration.properties.IntegrationProperty;

public class GooglePlayMonitorProxy<T, S> extends MonitorProxy implements IGooglePlayMonitor { 
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.googleplay.endpoint");
	
	IMonitor proxy;

	public GooglePlayMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public GooglePlayMonitorConfiguration createMonitorConfiguration(GooglePlayMonitorConfiguration conf) throws Exception {
		return (GooglePlayMonitorConfiguration) createMonitorConfiguration(new GooglePlayMonitorConfigurationRequest(conf),
				GooglePlayMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public GooglePlayMonitorConfiguration updateMonitorConfiguration(GooglePlayMonitorConfiguration conf) throws Exception {
		return (GooglePlayMonitorConfiguration) updateMonitorConfiguration(new GooglePlayMonitorConfigurationRequest(conf),
				GooglePlayMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public boolean deleteMonitorConfiguration(GooglePlayMonitorConfiguration conf) throws Exception {
		return deleteMonitorConfiguration(new GooglePlayMonitorConfigurationRequest(conf));
	}

}

class GooglePlayMonitorConfigurationRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "GooglePlayConfProf")
	GooglePlayMonitorConfiguration googlePlayMonitoringConfiguration;

	public GooglePlayMonitorConfiguration getGooglePlayMonitorConfiguration() {
		return googlePlayMonitoringConfiguration;
	}

	public void setGooglePlayMonitorConfiguration(GooglePlayMonitorConfiguration googlePlayMonitoringConfiguration) {
		this.googlePlayMonitoringConfiguration = googlePlayMonitoringConfiguration;
	}

	public GooglePlayMonitorConfigurationRequest(GooglePlayMonitorConfiguration googlePlayMonitoringConfiguration) {
		this.googlePlayMonitoringConfiguration = googlePlayMonitoringConfiguration;
	}

	public GooglePlayMonitorConfigurationRequest() {

	}

	@Override
	public void setId(Integer id) {
		googlePlayMonitoringConfiguration.setId(id);
	}

	@Override
	public Integer getId() {
		return googlePlayMonitoringConfiguration.getId();
	}

	@Override
	public GooglePlayMonitorConfiguration getConfiguration() {
		return getGooglePlayMonitorConfiguration();
	}
}

class GooglePlayMonitorConfigurationResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "GooglePlayConfProfResult")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public GooglePlayMonitorConfigurationResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public GooglePlayMonitorConfigurationResponse() {

	}
}