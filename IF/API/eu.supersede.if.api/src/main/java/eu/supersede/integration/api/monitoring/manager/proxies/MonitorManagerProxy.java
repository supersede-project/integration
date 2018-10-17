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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.AppStoreMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.GooglePlayMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MarketPlaceMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorSpecificConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.MonitorType;
import eu.supersede.integration.api.monitoring.manager.types.QoSMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.SocialNetworkMonitorConfiguration;
import eu.supersede.integration.api.monitoring.manager.types.TwitterMonitorConfiguration;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.properties.IntegrationProperty;

public class MonitorManagerProxy<T extends MonitorSpecificConfiguration, S> extends IFServiceProxy<T, S> implements IMonitorManager {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_MONITOR_MANAGER_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.manager.endpoint");

	@Override
	public <T extends MonitorSpecificConfiguration> T createMonitorConfiguration(T conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		MonitorConfiguration monitorConf = factoryCreateMonitorConfiguration(conf);
		
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/");
		log.debug("Sending message createMonitorConfiguration with conf: " + conf + " to MonitorManager at uri " + uri);
		String id = insertJSONObjectAndReturnValueForJsonLabel (monitorConf, uri, HttpStatus.CREATED, "id");
		conf.setId(Integer.valueOf(id));
		return conf;
	}

	private <T extends MonitorSpecificConfiguration> MonitorConfiguration factoryCreateMonitorConfiguration(T conf) throws IFException {
		MonitorConfiguration monitorConf = null;
		if (conf instanceof TwitterMonitorConfiguration)
			monitorConf = new SocialNetworkMonitorConfiguration();
		else if (conf instanceof AppStoreMonitorConfiguration || conf instanceof GooglePlayMonitorConfiguration)
			monitorConf = new MarketPlaceMonitorConfiguration();
		else if (conf instanceof HttpMonitorConfiguration)
			monitorConf = new QoSMonitorConfiguration();
		else
			throw new IFException("The following MonitorSpecificConfiguration is not supported: " + conf.getClass());
		monitorConf.setMonitorSpecificConfiguration(conf); 
		return monitorConf;
	}

	@Override
	public <T extends MonitorSpecificConfiguration> HttpStatus updateMonitorConfiguration(MonitorSpecificConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		Assert.notNull(conf.getId(), "Provide a valid monitor configuration id");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/" + conf.getId());
		MonitorConfiguration monitorConf = factoryCreateMonitorConfiguration(conf);
		log.debug("Sending message updateMonitorConfiguration with conf: " + conf + " to MonitorManager at uri " + uri);
		return updateJSONObject(monitorConf, uri, HttpStatus.OK);
	}


	@Override
	public HttpStatus deleteMonitorConfiguration(MonitorSpecificConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		Assert.notNull(conf.getId(), "Provide a valid monitor configuration id");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + getType (conf) + "/configuration/" + conf.getId());
		log.debug("Sending message deleteMonitorConfiguration with conf: " + conf + " to MonitorManager at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK);
	}


	private String getType(MonitorSpecificConfiguration conf) throws Exception{
		if (conf instanceof TwitterMonitorConfiguration){
			return MonitorType.Twitter.toString();
		}else if (conf instanceof GooglePlayMonitorConfiguration){
			return MonitorType.GooglePlay.toString();
		}else if (conf instanceof AppStoreMonitorConfiguration){
			return MonitorType.AppStore.toString();
		}else if (conf instanceof HttpMonitorConfiguration){
			return MonitorType.HttpMonitor.toString();
		}else{
			throw new Exception ("Type " + conf.getClass() + " is not a valid Monitor configuration");
		}
	}
}
