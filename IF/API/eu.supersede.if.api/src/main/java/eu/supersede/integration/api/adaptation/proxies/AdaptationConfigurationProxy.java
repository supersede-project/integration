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
package eu.supersede.integration.api.adaptation.proxies;


import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.types.AdaptationMode;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class AdaptationConfigurationProxy <T, S> extends IFServiceProxy<T, S> implements IAdaptationConfiguration {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_ADAPTATION_CONFIGURATION_ENDPOINT = 
			IntegrationProperty.getProperty("adaptation.configuration.endpoint");

	@Override
	public AdaptationMode getAdaptationConfigurationMode() throws Exception{
		URI uri = new URI(SUPERSEDE_ADAPTATION_CONFIGURATION_ENDPOINT);
		log.debug("Sending message getAdaptationConfigurationMode to DM Optimizer at uri " + uri);
		return getJSONObjectForType(AdaptationMode.class, uri, HttpStatus.OK);
	}
	
	@Override
	public void setAdaptationConfigurationMode(AdaptationMode mode) throws Exception{
		Assert.notNull(mode, "Provide a valid adaptation mode");
		URI uri = new URI(SUPERSEDE_ADAPTATION_CONFIGURATION_ENDPOINT);
		log.debug("Sending message setAdaptationConfigurationMode to DM Optimizer at uri " + uri);
		updateJSONObject(mode, uri, HttpStatus.OK);
	}

}
