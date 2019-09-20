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


import java.nio.file.Path;

import org.springframework.http.HttpMethod;

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;

public interface IMonitor {
//	TwitterMonitorConfiguration createMonitorConfiguration (TwitterMonitorConfiguration conf) throws Exception;
//	TwitterMonitorConfiguration updateMonitorConfiguration (TwitterMonitorConfiguration conf) throws Exception;
//	void deleteMonitorConfiguration (TwitterMonitorConfiguration conf) throws Exception;
	
	public <T extends MonitorConfigurationRequest, S extends MonitorConfigurationResponse> T createMonitorConfiguration(T conf, Class<S> responseType)
			throws Exception;
	public <T extends MonitorConfigurationRequest, S extends MonitorConfigurationResponse> T updateMonitorConfiguration(T conf, Class<S> responseType)
			throws Exception;
	public <T extends MonitorConfigurationRequest> void deleteMonitorConfiguration(T conf) throws Exception;
	
	public <T extends MonitorConfigurationRequest, S extends MonitorConfigurationResponse> T sendMonitorConfigurationMultipart 
	(T conf, Path file, Class<S> responseType, HttpMethod method) throws Exception;
}
