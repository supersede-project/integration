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

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorTool;
import eu.supersede.integration.api.monitoring.orchestrator.types.MonitorType;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.exception.IFException;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class MonitoringOrchestratorProxy<T, S> extends IFServiceProxy<T, S> implements IMonitoringOrchestrator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.orchestrator.endpoint");
	
	private String token;

	public MonitoringOrchestratorProxy(String user, String password) throws Exception {
		this(user, password, "en");
	}

	public MonitoringOrchestratorProxy(String user, String password, String language) throws Exception {
		FeedbackOrchestratorProxy<?, ?> foProxy = new FeedbackOrchestratorProxy<Object, Object>(user, password);
		this.token = foProxy.authenticate(user, password);
		if (token == null)
			throw new IFException("Failed authentication in Orchestrator");
	}

	@Override
	public List<MonitorType> listAllMonitorTypes() throws Exception {
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes");
		log.debug("Sending message listAllMonitorTypes to MonitoringOrchestrator at uri " + uri);
		return getJSONObjectsListForType(MonitorType[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public MonitorType createMonitorType(MonitorType monitorType) throws Exception {
		Assert.notNull(monitorType, "Provide a valid monitor type");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes");
		log.debug("Sending message createMonitorType with monitorType: " + monitorType + " to MonitoringOrchestrator at uri " + uri);
		return insertandReturnJSONObject(monitorType, uri, HttpStatus.CREATED, token);
	}

	@Override
	public MonitorType getMonitorType(String monitorTypeName) throws Exception {
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName);
		log.debug("Sending message getMonitorType with monitorTypeName: " + monitorTypeName + " to MonitoringOrchestrator at uri " + uri);
		return getJSONObjectForType(MonitorType.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteMonitorType(MonitorType monitorType) throws Exception {
		Assert.notNull(monitorType.getName(), "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorType.getName());
		log.debug("Sending message deleteMonitorType with monitorType: " + monitorType + " to MonitoringOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	@Override
	public MonitorTool createMonitorToolForMonitorType(MonitorTool monitorTool, String monitorTypeName)
			throws Exception {
		Assert.notNull(monitorTool, "Provide a valid monitor tool");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools");
		log.debug("Sending message createMonitorToolForMonitorType with monitorTool: " + monitorTool 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return insertandReturnJSONObject(monitorTool, uri, HttpStatus.CREATED, token);
	}

	@Override
	public MonitorTool getMonitorToolForMonitorType(String monitorToolName, String monitorTypeName) throws Exception {
		Assert.notNull(monitorToolName, "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorToolName);
		log.debug("Sending message getMonitorToolForMonitorType with monitorToolName: " + monitorToolName 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return getJSONObjectForType(MonitorTool.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteMonitorToolForMonitorType(MonitorTool monitorTool, String monitorTypeName) throws Exception {
		Assert.notNull(monitorTool.getName(), "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorTool.getName());
		log.debug("Sending message deleteMonitorToolForMonitorType with monitorTool: " + monitorTool 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	@Override
	public MonitorConfiguration createMonitorConfigurationForMonitorToolAndMonitorType(
			MonitorConfiguration monitorConfiguration, String monitorToolName, String monitorTypeName)
			throws Exception {
		Assert.notNull(monitorConfiguration, "Provide a valid monitor configuration");
		Assert.notNull(monitorToolName, "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorToolName + "/ToolConfigurations");
		log.debug("Sending message createMonitorConfigurationForMonitorToolAndMonitorType with monitorConfiguration: " + monitorConfiguration 
				+ ", with monitorToolName: " + monitorToolName 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return insertandReturnJSONObject(monitorConfiguration, uri, HttpStatus.CREATED, token);
	}

	@Override
	public MonitorConfiguration getMonitorConfigurationForMonitorToolAndMonitorType(Integer configurationId,
			String monitorToolName, String monitorTypeName) throws Exception {
		Assert.notNull(configurationId, "Provide a valid monitor configuration id");
		Assert.notNull(monitorToolName, "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorToolName + "/ToolConfigurations/" + configurationId);
		log.debug("Sending message getMonitorConfigurationForMonitorToolAndMonitorType with configurationId: " + configurationId 
				+ ", with monitorToolName: " + monitorToolName 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return getJSONObjectForType(MonitorConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public MonitorConfiguration updateMonitorConfigurationForMonitorToolAndMonitorType(
			MonitorConfiguration monitorConfiguration, String monitorToolName, String monitorTypeName)
			throws Exception {
		Assert.notNull(monitorConfiguration.getId(), "Provide a valid monitor configuration id");
		Assert.notNull(monitorToolName, "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorToolName + "/ToolConfigurations/" + monitorConfiguration.getId());
		log.debug("Sending message updateMonitorConfigurationForMonitorToolAndMonitorType with monitorConfiguration: " + monitorConfiguration 
				+ ", with monitorToolName: " + monitorToolName 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(monitorConfiguration, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteMonitorConfigurationForMonitorToolAndMonitorType(MonitorConfiguration monitorConfiguration,
			String monitorToolName, String monitorTypeName) throws Exception {
		Assert.notNull(monitorConfiguration.getId(), "Provide a valid monitor configuration id");
		Assert.notNull(monitorToolName, "Provide a valid monitor tool name");
		Assert.notNull(monitorTypeName, "Provide a valid monitor type name");
		URI uri = new URI(SUPERSEDE_MONITORING_ORCHESTRATOR_ENDPOINT + "MonitorTypes/" + monitorTypeName + "/Tools/"
				+ monitorToolName + "/ToolConfigurations/" + monitorConfiguration.getId());
		log.debug("Sending message deleteMonitorConfigurationForMonitorToolAndMonitorType with monitorConfiguration: " + monitorConfiguration 
				+ ", with monitorToolName: " + monitorToolName 
				+ ", with monitorTypeName: " + monitorTypeName 
				+ " to MonitoringOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
}
