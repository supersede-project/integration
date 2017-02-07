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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationRequest;
import eu.supersede.integration.api.monitoring.manager.types.MonitorConfigurationResponse;
import eu.supersede.integration.api.proxy.IFServiceProxy;

public abstract class MonitorProxy<T, S> extends IFServiceProxy<T, S> implements IMonitor {
	private static final Logger log = LoggerFactory.getLogger(MonitorProxy.class);
	private String endpoint;

	protected MonitorProxy(String endpoint) {
		this.endpoint = endpoint;
	}

	// @Override
	// public SocialNetworksMonitoringConfiguration
	// createMonitorConfiguration(SocialNetworksMonitoringConfiguration conf)
	// throws Exception {
	// Assert.notNull(conf, "Provide a valid monitor configuration");
	// URI uri = new URI(endpoint + "configuration");
	// SocialNetworksMonitoringConfigurationResponse response =
	// insertJSONObjectAndReturnAnotherType(
	// new SocialNetworksMonitoringConfigurationRequest(conf),
	// SocialNetworksMonitoringConfigurationResponse.class, uri, HttpStatus.OK);
	// if (response != null &&
	// response.getSocialNetworksMonitoringConfProfResult() != null
	// && response.getSocialNetworksMonitoringConfProfResult().getIdConf() !=
	// null) {
	// conf.setId(response.getSocialNetworksMonitoringConfProfResult().getIdConf());
	// return conf;
	// } else {
	// if (response != null &&
	// response.getSocialNetworksMonitoringConfProfResult() != null) {
	// log.error(response.getSocialNetworksMonitoringConfProfResult().getMessage());
	// }
	// return null;
	// }
	// }

	@Override
	public <T extends MonitorConfigurationRequest, S extends MonitorConfigurationResponse> T createMonitorConfiguration(
			T conf, Class<S> responseType) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(endpoint + "configuration");
		S response = insertJSONObjectAndReturnAnotherType(conf, responseType, uri, HttpStatus.OK);
		if (response != null && response.getResult() != null && response.getResult().getIdConf() != null) {
			conf.setId(response.getResult().getIdConf());
			return conf;
		} else {
			if (response != null && response.getResult() != null) {
				log.error(response.getResult().getMessage());
			}else{
				log.error("There was a problem creating monitor configuration " + conf + " in uri: " + uri);
			}
			return null;
		}
	}

	// @Override
	// public TwitterMonitorConfiguration
	// updateMonitorConfiguration(TwitterMonitorConfiguration conf)
	// throws Exception {
	// Assert.notNull(conf, "Provide a valid monitor configuration");
	// URI uri = new URI(endpoint + "configuration/" + conf.getId());
	// SocialNetworksMonitoringConfigurationResponse response =
	// updateJSONObjectAndReturnAnotherType(
	// new SocialNetworksMonitoringConfigurationRequest(conf),
	// SocialNetworksMonitoringConfigurationResponse.class, uri, HttpStatus.OK);
	// if (response != null &&
	// response.getSocialNetworksMonitoringConfProfResult() != null
	// && response.getSocialNetworksMonitoringConfProfResult().getIdConf() !=
	// null) {
	// conf.setId(response.getSocialNetworksMonitoringConfProfResult().getIdConf());
	// return conf;
	// } else {
	// if (response != null &&
	// response.getSocialNetworksMonitoringConfProfResult() != null) {
	// log.error(response.getSocialNetworksMonitoringConfProfResult().getMessage());
	// }
	// return null;
	// }
	// }

	@Override
	public <T extends MonitorConfigurationRequest, S extends MonitorConfigurationResponse> T updateMonitorConfiguration(
			T conf, Class<S> responseType) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(endpoint + "configuration/" + conf.getId());
		S response = updateJSONObjectAndReturnAnotherType(conf, responseType, uri, HttpStatus.OK);
		if (response != null && response.getResult() != null && response.getResult().getIdConf() != null) {
			return conf;
		} else {
			if (response != null && response.getResult() != null) {
				log.error(response.getResult().getMessage());
			}else{
				log.error("There was a problem updating monitor configuration " + conf + " in uri: " + uri);
			}
			return null;
		}
	}

	// @Override
	// public void deleteMonitorConfiguration(TwitterMonitorConfiguration conf)
	// throws Exception {
	// Assert.notNull(conf, "Provide a valid monitor configuration");
	// URI uri = new URI(endpoint + "configuration/" + conf.getId());
	// deleteUriResource(uri, HttpStatus.OK);
	// }

	@Override
	public <T extends MonitorConfigurationRequest> void deleteMonitorConfiguration(T conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(endpoint + "configuration/" + conf.getId());
		deleteUriResource(uri, HttpStatus.OK);
	}
}
