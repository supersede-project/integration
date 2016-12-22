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
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.proxy.IFServiceProxy;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class AdapterProxy <T, S> extends IFServiceProxy<T, S> implements IAdapter {
	private final static String SUPERSEDE_ADAPTER_ENDPOINT = 
			IntegrationProperty.getProperty("adapter.endpoint");

//	private String addURIQueryArray (String uriString, List<String> ids, String idLabel){
//		boolean queryStarted = false;
//		for (String id: ids){
//			if (queryStarted){
//				uriString = uriString + "&";
//			}
//			uriString = uriString + idLabel + "=" + id;
//			queryStarted = true;
//		}
//		
//		return uriString;
//	}


	@Override
	public boolean enactAdaptationDecisionActions(String systemId, List<String> adaptationDecisionActionIds,
			String featureConfigurationId) throws Exception {
		Assert.notNull(systemId, "Provide a valid system id");
		Assert.notNull(adaptationDecisionActionIds, "Provide valid adaptationDecisionActionIds");
		Assert.notEmpty(adaptationDecisionActionIds, "Provide not empty adaptationDecisionActionIds");
		Assert.notNull(featureConfigurationId, "Provide a valid featureConfigurationId");
		String uriString = SUPERSEDE_ADAPTER_ENDPOINT + "adaptationDecisionActions/featureConfiguration/" + featureConfigurationId + "/system/" + systemId + "?";
//		uriString = addURIQueryArray(uriString, adaptationDecisionActionIds, "adaptationDecisionActionIds");
		
		return postFormURLEncoded(new URI(uriString), "adaptationDecisionActionIds", adaptationDecisionActionIds, HttpStatus.OK);
	}
}
