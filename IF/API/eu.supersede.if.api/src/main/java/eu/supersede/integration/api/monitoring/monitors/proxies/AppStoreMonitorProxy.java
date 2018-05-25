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

import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfigurationResult;
import eu.supersede.integration.properties.IntegrationProperty;

public class AppStoreMonitorProxy<T, S> extends MonitorProxy implements IAppStoreMonitor { 
	private final static String SUPERSEDE_MONITOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.monitor.appstore.endpoint");
	
	IMonitor proxy;

	public AppStoreMonitorProxy() {
		super(SUPERSEDE_MONITOR_ENDPOINT);
	}

	@Override
	public AppStoreMonitorConfiguration createMonitorConfiguration(AppStoreMonitorConfiguration conf) throws Exception {
		return (AppStoreMonitorConfiguration) createMonitorConfiguration(new AppStoreMonitorConfigurationRequest(conf),
				AppStoreMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public AppStoreMonitorConfiguration updateMonitorConfiguration(AppStoreMonitorConfiguration conf) throws Exception {
		return (AppStoreMonitorConfiguration) updateMonitorConfiguration(new AppStoreMonitorConfigurationRequest(conf),
				AppStoreMonitorConfigurationResponse.class).getConfiguration();
	}

	@Override
	public boolean deleteMonitorConfiguration(AppStoreMonitorConfiguration conf) throws Exception {
		return deleteMonitorConfiguration(new AppStoreMonitorConfigurationRequest(conf));
	}

}

class AppStoreMonitorConfigurationRequest implements MonitorConfigurationRequest {
	@JsonProperty(value = "AppStoreConfProf")
	AppStoreMonitorConfiguration appStoreMonitoringConfiguration;

	public AppStoreMonitorConfiguration getAppStoreMonitorConfiguration() {
		return appStoreMonitoringConfiguration;
	}

	public void setAppStoreMonitorConfiguration(AppStoreMonitorConfiguration appStoreMonitoringConfiguration) {
		this.appStoreMonitoringConfiguration = appStoreMonitoringConfiguration;
	}

	public AppStoreMonitorConfigurationRequest(AppStoreMonitorConfiguration appStoreMonitoringConfiguration) {
		this.appStoreMonitoringConfiguration = appStoreMonitoringConfiguration;
	}

	public AppStoreMonitorConfigurationRequest() {

	}

	@Override
	public void setId(Integer id) {
		appStoreMonitoringConfiguration.setId(id);
	}

	@Override
	public Integer getId() {
		return appStoreMonitoringConfiguration.getId();
	}

	@Override
	public AppStoreMonitorConfiguration getConfiguration() {
		return getAppStoreMonitorConfiguration();
	}
}

class AppStoreMonitorConfigurationResponse implements MonitorConfigurationResponse {
	@JsonProperty(value = "AppStoreConfProfResult")
	MonitorSpecificConfigurationResult result;

	@Override
	public MonitorSpecificConfigurationResult getResult() {
		return result;
	}

	public void setResult(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public AppStoreMonitorConfigurationResponse(MonitorSpecificConfigurationResult result) {
		this.result = result;
	}

	public AppStoreMonitorConfigurationResponse() {

	}
}