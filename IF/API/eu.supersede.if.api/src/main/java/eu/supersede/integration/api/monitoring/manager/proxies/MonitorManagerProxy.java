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
package eu.supersede.integration.api.monitoring.manager.proxies;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorType;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class MonitorManagerProxy<T extends MonitorSpecificConfiguration, S> extends IFServiceProxy<T, S> implements IMonitorManager {
	private final static String SUPERSEDE_MONITOR_MANAGER_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.manager.endpoint");

	@Override
	public <T extends MonitorSpecificConfiguration> T createMonitorConfiguration(T conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		MonitorConfiguration monitorConf = new MonitorConfiguration();
		monitorConf.setMonitorSpecificConfiguration(conf);
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/");
		String id = insertJSONObjectAndReturnValueForJsonLabel (monitorConf, uri, HttpStatus.CREATED, "idConf");
		conf.setId(Integer.valueOf(id));
		return conf;
	}


	@Override
	public <T extends MonitorSpecificConfiguration> void updateMonitorConfiguration(MonitorSpecificConfiguration conf, String id) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		Assert.notNull(id, "Provide a valid monitor configuration id");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/" + id);
		MonitorConfiguration monitorConf = new MonitorConfiguration();
		monitorConf.setMonitorSpecificConfiguration(conf);
		updateJSONObject(monitorConf, uri, HttpStatus.OK);
	}


	@Override
	public void deleteMonitorConfiguration(MonitorSpecificConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		Assert.notNull(conf.getId(), "Provide a valid monitor configuration id");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/" + conf.getId());
		deleteUriResource(uri, HttpStatus.OK);
	}


	private String getType(MonitorSpecificConfiguration conf) throws Exception{
		if (conf instanceof TwitterMonitorConfiguration){
			return MonitorType.Twitter.toString();
		}else if (conf instanceof GooglePlayMonitorConfiguration){
			return MonitorType.GooglePlay.toString();
		}else if (conf instanceof AppStoreMonitorConfiguration){
			return MonitorType.AppStore.toString();
		}else{
			throw new Exception ("Type " + conf.getClass() + " is not a valid Monitor configuration");
		}
	}
}
