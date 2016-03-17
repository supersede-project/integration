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
package eu.supersede.integration.poc.dynadapt.proxies;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

import eu.supersede.integration.poc.dynadapt.services.iDynAdaptEnact;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.poc.dynadapt.types.TopRankedAdaptationDecision;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class DynAdapEnactProxy implements iDynAdaptEnact {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String ENACT_ENDPOINT = IntegrationProperty.getProperty("enactment.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DynAdapEnactProxy.class);
	
	//Synchronous API
    
	@Override
	public ResponseEntity<AdaptationEnactment> triggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerAdaptationDecision/" + 
					decisionId +"/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage("{}", uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (response.getStatusCode().equals(HttpStatus.CREATED) && enactment) {
				log.info("Successful enactment of decision: " + decisionId + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decisionId + ". Enactment: " + ae.toString());
			}
			return response;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecision(
			TopRankedAdaptationDecision decision, UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerTopRankedAdaptationDecision/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage(decision, uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (enactment) {
				log.info("Successful enactment of decision: " + decision.getUuid() + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decision.getUuid() + ". Enactment: " + ae.toString());
			}
			return ae;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	//This method receives a JSON AdaptationDecision payload (not explicit) and produces a JSON response
	public AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecision(
			AdaptationDecision decision, UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerTopRankedAdaptationDecision/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage(decision, uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (enactment) {
				log.info("Successful enactment of decision: " + decision.getId() + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decision.getId() + ". Enactment: " + ae.toString());
			}
			return ae;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	//This method receives a JSON AdaptationDecision payload (explicit) and produces a JSON response
	@Override
	public AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsJSON(AdaptationDecision decision,
			UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerTopRankedAdaptationDecisionAsJSON/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage(decision, uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (enactment) {
				log.info("Successful enactment of decision: " + decision.getId() + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decision.getId() + ". Enactment: " + ae.toString());
			}
			return ae;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

	//This method receives a XML AdaptationDecision payload (explicit) and produces a XML response
	@Override
	public AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsXML(AdaptationDecision decision,
			UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerTopRankedAdaptationDecisionAsXML/" + systemId);

			ResponseEntity<AdaptationEnactment> response = messageClient.postXmlMessage(decision, uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (enactment) {
				log.info("Successful enactment of decision: " + decision.getId() + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decision.getId() + ". Enactment: " + ae.toString());
			}
			return ae;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Asynchronous API
	public ListenableFuture<ResponseEntity<AdaptationEnactment>> asynchronousTriggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId) {
        try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerAdaptationDecision/" + 
					decisionId +"/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ListenableFuture<ResponseEntity<AdaptationEnactment>> response = messageClient.asyncPostJsonMessage("{}", uri, AdaptationEnactment.class);
			return response;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}

//class AdaptationEnactmentAdapter extends ListenableFutureAdapter<AdaptationEnactment, ResponseEntity<AdaptationEnactment>> {
//	private static final Logger log = LoggerFactory.getLogger(AdaptationEnactmentAdapter.class);
//	
//    public AdaptationEnactmentAdapter(ListenableFuture<ResponseEntity<AdaptationEnactment>> adaptationEnactment) {
//        super(adaptationEnactment);
//    }
// 
//    @Override
//    protected AdaptationEnactment adapt(ResponseEntity<AdaptationEnactment> response) throws ExecutionException {
//    	return response.getBody();
//    }
//}
