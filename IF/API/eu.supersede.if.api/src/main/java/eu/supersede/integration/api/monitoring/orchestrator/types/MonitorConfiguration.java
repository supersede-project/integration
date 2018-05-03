/*******************************************************************************
 * Copyright (c) 2016 Universitat Politécnica de Catalunya (UPC)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * 	Quim Motger (UPC) - main development
 * 	
 * Initially developed in the context of SUPERSEDE EU project
 * www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.monitoring.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eu.supersede.integration.api.feedback.orchestrator.types.OrchestratorItem;
import eu.supersede.integration.api.monitoring.manager.types.Method;

//@Serialize(MonitorConfigurationSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class MonitorConfiguration extends OrchestratorItem<MonitorConfiguration> {

	private Integer id;
	private Integer monitorToolId;
	private String configSender;
	private String timeStamp;
	private String timeSlot;
	private String kafkaEndpoint;
	private String kafkaTopic;
	private String state;
	private String keywordExpression;
	private String packageName;
	private String appId;
	private String url;
	private Method method;
	private Integer monitorManagerId;
	
	public Integer getMonitorManagerId() {
		return monitorManagerId;
	}

	public void setMonitorManagerId(Integer monitorManagerId) {
		this.monitorManagerId = monitorManagerId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getKeywordExpression() {
		return keywordExpression;
	}

	public void setKeywordExpression(String keywordExpression) {
		this.keywordExpression = keywordExpression;
	}

	/*public List<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}*/
	
	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getKafkaEndpoint() {
		return kafkaEndpoint;
	}

	public void setKafkaEndpoint(String kafkaEndpoint) {
		this.kafkaEndpoint = kafkaEndpoint;
	}

	public String getKafkaTopic() {
		return kafkaTopic;
	}

	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getMonitorToolId() {
		return monitorToolId;
	}

	public void setMonitorToolId(Integer monitorToolId) {
		this.monitorToolId = monitorToolId;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getConfigSender() {
		return configSender;
	}

	public void setConfigSender(String configSender) {
		this.configSender = configSender;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
