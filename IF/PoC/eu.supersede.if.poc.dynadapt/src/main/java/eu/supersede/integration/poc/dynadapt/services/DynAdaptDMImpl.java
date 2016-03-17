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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import eu.supersede.integration.poc.dynadapt.proxies.DynAdapEnactProxy;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.poc.dynadapt.types.CollectionOfDecisions;

@RestController
@RequestMapping(value="/dm")
public class DynAdaptDMImpl implements iDynAdaptDM {
	private static final Logger log = LoggerFactory.getLogger(DynAdaptDMImpl.class);
	static Collection<AdaptationDecision> currentDecisions = new ArrayList<AdaptationDecision>();
	static final int A_MINUTE = 1000*60;
	static Random random = new Random();
	private static Map<String, String> decisions = new HashMap<>();
	private static DynAdapEnactProxy enactProxy = new DynAdapEnactProxy();
	
	//Service generates random (1 to 10) adaptation decisions: Collection<UUID> every minute
	static{
		ComputeDecisionsTask task = new ComputeDecisionsTask();
		Timer timer = new Timer();
		log.info("Scheduled ComputeDecisionsTask");
		timer.schedule(task, Calendar.getInstance().getTime(), A_MINUTE);
		
		//Populating decisions
		decisions.put("Decrease Video Resolution", "Reconfigure player: reduce video resolution during playing");
		decisions.put("Increment number of CDNs", "Reconfigure backend topology: increase number of CDNs by 10");
		decisions.put("Switch to local regional CDN", "Reconfigure backend topology: activate video content dispatching using closest regional CDN");
		decisions.put("Decrease frames", "Reconfigure player: reduce video streaming frames per second by 10%");
		decisions.put("Reconfigure streaming balance", "Reconfigure backend topology: redistribute streaming workload to closest regional CDN network");
		
	}
	
	@Override
	//Only returns JSON representation, expressed explicitly
	@RequestMapping(value="/adaptationDecisions/{systemId}", method=RequestMethod.GET, headers="Accept=application/json" )
	public @ResponseBody Collection<AdaptationDecision> getAdaptationDecisions(@PathVariable UUID systemId) {
		log.info("getAdaptationDecisions processed for system: " + systemId);
		if (currentDecisions.isEmpty()) computeDecisions();
		
		return currentDecisions;
	}
	
	@Override
	//Only returns XML representation, expressed explicitly
	@RequestMapping(value="/allAdaptationDecisions/{systemId}", method=RequestMethod.GET, 
			headers="Accept=application/xml", produces="application/xml")
	public @ResponseBody CollectionOfDecisions getAllAdaptationDecisions(@PathVariable UUID systemId) {
		log.info("getAdaptationDecisions processed for system: " + systemId);
		if (currentDecisions.isEmpty()) computeDecisions();
		return new CollectionOfDecisions(currentDecisions);
	}
	
	@Override
	//Accepts both JSON and XML representations
	@RequestMapping(value="/topRankedAdaptationDecision/{systemId}", method=RequestMethod.GET, 
		headers="Accept=application/json, application/xml", produces = {"application/json", "application/xml"})
	public @ResponseBody AdaptationDecision getTopRankedAdaptationDecision(@PathVariable UUID systemId) {
		log.info("getAdaptationDecisions processed for system: " + systemId);
		if (currentDecisions.isEmpty()) computeDecisions();
		return currentDecisions.iterator().next();
	}
	
	public static Collection<AdaptationDecision> computeDecisions(){
		currentDecisions.clear();
		int number = random.nextInt(10);
		for (int i=0; i<number; i++){
			currentDecisions.add(computeDecision(UUID.randomUUID()));
		}
		log.info("Computed " + number + " adaptation decisions");
		return currentDecisions;
	}

	private static AdaptationDecision computeDecision(UUID id) {
		int index = random.nextInt(decisions.size());
		String name = (String) decisions.keySet().toArray()[index];
		AdaptationDecision ad = new AdaptationDecision();
		ad.setId(id);
		ad.setName(name);
		ad.setDescription(decisions.get(name));
		ad.setPriority(random.nextInt(5));
		ad.setSupervised(random.nextBoolean());
		
		return ad;
	}
	
}

class ComputeDecisionsTask extends TimerTask{
	private static final Logger log = LoggerFactory.getLogger(ComputeDecisionsTask.class);
	private static boolean firstInvocation = false;
	private static DynAdapEnactProxy enactProxy = new DynAdapEnactProxy();
	
	public ComputeDecisionsTask(){
	}

	@Override
	public void run() {
		log.info("Launching scheduled ComputeDecisionsTask");
		Collection<AdaptationDecision> decisions = DynAdaptDMImpl.computeDecisions();
		
		if (!firstInvocation){
			firstInvocation = true;
			return;
		}
		
		log.info("Requested to enact top ranked decision");
		if (decisions.iterator().hasNext()){
			AdaptationDecision decision = decisions.iterator().next();
			
			//To be sent without ESB mediation
//			TopRankedAdaptationDecision topDecision = new TopRankedAdaptationDecision();
//			topDecision.setUuid(decision.getId());
//			topDecision.setDecisionName(decision.getName());
//			topDecision.setDecisionDescription(decision.getDescription());
//			topDecision.setPriority(decision.getPriority());
//			topDecision.setStatus(0);
//			topDecision.setSupervisionRequired(decision.isSupervised());
//			enactProxy.triggerTopRankedEnactmentForAdaptationDecision(topDecision, UUID.randomUUID());
			
			//To be sent with ESB mediation
			enactProxy.triggerTopRankedEnactmentForAdaptationDecision(decision, UUID.randomUUID());
			
//			//To be sent asynchronously
			log.info("BEFORE Invoking asynchronousTriggerEnactmentForAdaptationDecision. Not-blocking");
			asynchronousTriggerEnactmentForAdaptationDecision (decision.getId(), UUID.randomUUID());
			log.info("AFTER Invoking asynchronousTriggerEnactmentForAdaptationDecision. Not-blocking");
		}
	}
		
	DeferredResult<ResponseEntity<?>> asynchronousTriggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId){
		ListenableFuture<ResponseEntity<AdaptationEnactment>> enactmentAdapter = enactProxy.asynchronousTriggerEnactmentForAdaptationDecision (decisionId, systemId);
		DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
		enactmentAdapter.addCallback(
                new ListenableFutureCallback<ResponseEntity<AdaptationEnactment>>() {
                    @Override
                    public void onSuccess(ResponseEntity<AdaptationEnactment> response) {
                    	log.info("ASYNCHRONOUS response received"); 
                    	AdaptationEnactment ae = response.getBody();
                    	boolean enactment = ae.isEnactmentResult();
                		if (enactment) {
                			log.info("Successful enactment of decision: " + ae.getDecisionId() + ". Enactment: " + ae.toString());
                		} else {
                			log.info("There was a problem enacting decision: " + ae.getDecisionId() + ". Enactment: " + ae.toString());
                		}
                		deferredResult.setResult(response);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                    	log.info("There was a problem obtaining the enacting decision");
                    	ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                    	deferredResult.setResult(response);
                    }
                }
        );
		return deferredResult;
		
	}
}
