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
package eu.supersede.integration.poc.dynadapt.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.poc.dynadapt.types.TopRankedAdaptationDecision;

public interface iDynAdaptEnact {
	ResponseEntity<AdaptationEnactment> triggerEnactmentForAdaptationDecision (UUID decisionId, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecision (TopRankedAdaptationDecision decision, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsJSON(AdaptationDecision decision, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsXML(AdaptationDecision decision, UUID systemId);
}
