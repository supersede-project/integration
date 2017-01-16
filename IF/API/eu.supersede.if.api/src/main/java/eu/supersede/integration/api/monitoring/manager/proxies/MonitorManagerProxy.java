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

import eu.supersede.integration.api.monitoring.manager.types.MonitorConfiguration;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class MonitorManagerProxy<T, S> extends IFServiceProxy<T, S> implements IMonitorManager {
	private final static String SUPERSEDE_MONITOR_MANAGER_ENDPOINT = IntegrationProperty
			.getProperty("monitoring.manager.endpoint");

	@Override
	public void createMonitorConfiguration(MonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + "configuration");
		insertJSONObject(conf, uri, HttpStatus.OK);
	}


	@Override
	public void updateMonitorConfiguration(MonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + "configuration");
		updateJSONObject(conf, uri, HttpStatus.OK);
	}


	@Override
	public void deleteMonitorConfiguration(MonitorConfiguration conf) throws Exception {
		Assert.notNull(conf, "Provide a valid monitor configuration");
		URI uri = new URI(SUPERSEDE_MONITOR_MANAGER_ENDPOINT + "configuration");
		deleteUriResource(uri, HttpStatus.OK);
	}
}
