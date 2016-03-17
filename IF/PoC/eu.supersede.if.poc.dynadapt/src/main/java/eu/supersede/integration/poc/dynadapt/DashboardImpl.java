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
package eu.supersede.integration.poc.dynadapt;

import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.supersede.integration.poc.dynadapt.proxies.DynAdapDMProxy;
import eu.supersede.integration.poc.dynadapt.proxies.DynAdapEnactProxy;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;

@Component
public class DashboardImpl {
	private static final Logger log = LoggerFactory.getLogger(DashboardImpl.class);
	private static DynAdapDMProxy dmProxy = new DynAdapDMProxy();
	private static DynAdapEnactProxy enactProxy = new DynAdapEnactProxy();
	
//	private IFMessageClient messageClient = new IFMessageClient();
//	private final static String DM_ENDPOINT = DynAdaptProperty.getProperty("dm.endpoint");
//	private final static String ENACT_ENDPOINT = DynAdaptProperty.getProperty("enactment.endpoint");

	public void run() {
		// TODO Auto-generated method stub
		log.info("Executing dashboard implementation");
		log.info("Getting available adaptation decisions");
		try {
			UUID systemId = UUID.randomUUID();
			Collection<AdaptationDecision> decisions = dmProxy.getAdaptationDecisions(systemId);
			if (!decisions.isEmpty()){
				enactProxy.triggerEnactmentForAdaptationDecision(decisions.iterator().next().getId(), systemId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private Collection<AdaptationDecision> getAdaptationDecisions(UUID systemId) throws URISyntaxException {
////		URI uri = new URI("http://localhost:8080/dm/adaptationDecisions/" + systemId);
//		URI uri = new URI(DM_ENDPOINT + "adaptationDecisions/" + systemId);
//		try {
//			ResponseEntity<AdaptationDecision[]> response = messageClient.getMessage(uri, AdaptationDecision[].class);
//			AdaptationDecision[] decisions = response.getBody();
//			if (response.getStatusCode().equals(HttpStatus.OK)) {
//				log.info("Located " + decisions.length + " decision(s)");
//				for (AdaptationDecision decision:decisions){
//					log.info("Decision: " + decision.toString());
//				}
//			} else {
//				log.info("There was a problem getting available adaptation decisions");
//			}
//			return (Collection<AdaptationDecision>) Arrays.asList(decisions);
//		} catch (RestClientException e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
	
//	public boolean triggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId) throws URISyntaxException {
////		URI uri = new URI("http://localhost:8080/enactment/triggerAdaptationDecision/" + 
////				decisionId +"/" + systemId);
//		URI uri = new URI(ENACT_ENDPOINT + "triggerAdaptationDecision/" + 
//				decisionId +"/" + systemId);
//		//Note, object whose String serialization is valid Json must be sent to postJsonMessage
//		ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage("{}", uri, AdaptationEnactment.class);
//		AdaptationEnactment ae = response.getBody();
//		boolean enactment = ae.isEnactmentResult();
//		if (response.getStatusCode().equals(HttpStatus.CREATED) && enactment) {
//			log.info("Successful enactment of decision: " + decisionId + ". Enactment: " + ae.toString());
//		} else {
//			log.info("There was a problem enacting decision: " + decisionId + ". Enactment: " + ae.toString());
//		}
//		return enactment;
//	}

}
