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

import java.util.List;

import eu.supersede.integration.api.adaptation.types.ModelSystem;

public interface IAdapter {
	boolean enactAdaptationDecisionActions(ModelSystem systemId, List<String> adaptationDecisionActionIds,
			String featureConfigurationId) throws Exception;

	boolean enactAdaptationDecisionActionsForFC(ModelSystem system, String featureConfigurationId) throws Exception;

	boolean enactAdaptationDecisionActionsInFCasString(ModelSystem system, List<String> adaptationDecisionActionIds,
			String featureConfigurationAsString, String featureConfigurationId) throws Exception;

	boolean enactAdaptationFCasString(ModelSystem system, String featureConfigurationAsString,
			String featureConfigurationId) throws Exception;
}
