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

import eu.supersede.integration.api.monitoring.manager.types.HttpMonitorConfiguration;

public interface IHttpMonitor {
	public HttpMonitorConfiguration createMonitorConfiguration(HttpMonitorConfiguration conf)
			throws Exception;
	public HttpMonitorConfiguration updateMonitorConfiguration(HttpMonitorConfiguration conf)
			throws Exception;
	public void deleteMonitorConfiguration(HttpMonitorConfiguration conf) throws Exception;
	public HttpMonitorConfiguration createMonitorConfiguration(HttpMonitorConfiguration conf, Path file) throws Exception;
	public HttpMonitorConfiguration updateMonitorConfiguration(HttpMonitorConfiguration conf, Path file) throws Exception;
}
