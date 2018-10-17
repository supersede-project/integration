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
package eu.supersede.integration.api.monitoring.orchestrator.proxies;

import java.util.List;

import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorTool;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorType;

public interface IMonitoringOrchestrator {
	//Monitor Types
	List<MonitorType> listAllMonitorTypes() throws Exception;
	MonitorType createMonitorType (MonitorType monitorType) throws Exception;
	MonitorType getMonitorType (String monitorTypeName) throws Exception;
	HttpStatus deleteMonitorType (MonitorType monitorType) throws Exception;
	
	//Monitor Tools
	MonitorTool createMonitorToolForMonitorType (MonitorTool monitorTool, String monitorTypeName) throws Exception;
	MonitorTool getMonitorToolForMonitorType (String monitorToolName, String monitorTypeName) throws Exception;
	HttpStatus deleteMonitorToolForMonitorType (MonitorTool monitorTool, String monitorTypeName) throws Exception;
	
	//Monitor Configurations
	MonitorConfiguration createMonitorConfigurationForMonitorToolAndMonitorType (MonitorConfiguration monitorConfiguration, 
			String monitorToolName, String monitorTypeName) throws Exception;
	MonitorConfiguration getMonitorConfigurationForMonitorToolAndMonitorType (Integer configurationId, String monitorToolName, String monitorTypeName) throws Exception;
	MonitorConfiguration updateMonitorConfigurationForMonitorToolAndMonitorType (MonitorConfiguration monitorConfiguration, String monitorToolName, String monitorTypeName) throws Exception;
	HttpStatus deleteMonitorConfigurationForMonitorToolAndMonitorType (MonitorConfiguration monitorConfiguration, String monitorToolName, String monitorTypeName) throws Exception;
}
