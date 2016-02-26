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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.supersede.integration.poc.dynadapt.proxies.DynAdapEnactProxy;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.TopRankedAdaptationDecision;

@RestController
@RequestMapping(value="/dm")
public class DynAdaptDMImpl implements iDynAdaptDM {
	private static final Logger log = LoggerFactory.getLogger(DynAdaptDMImpl.class);
	static Collection<AdaptationDecision> currentDecisions = new ArrayList<AdaptationDecision>();
	static final int A_MINUTE = 1000*60;
	static Random random = new Random();
	private static Map<String, String> decisions = new HashMap<>();
	
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
	@RequestMapping(value="/adaptationDecisions/{systemId}", method=RequestMethod.GET)
	public Collection<AdaptationDecision> getAdaptationDecisions(@PathVariable UUID systemId) {
		log.info("getAdaptationDecisions processed for system: " + systemId);
		if (currentDecisions.isEmpty()) computeDecisions();
		return currentDecisions;
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
	private static DynAdapEnactProxy enactProxy = new DynAdapEnactProxy();
	private static boolean firstInvocation = false;
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
			TopRankedAdaptationDecision topDecision = new TopRankedAdaptationDecision();
			topDecision.setUuid(decision.getId());
			topDecision.setDecisionName(decision.getName());
			topDecision.setDecisionDescription(decision.getDescription());
			topDecision.setPriority(decision.getPriority());
			topDecision.setStatus(0);
			topDecision.setSupervisionRequired(decision.isSupervised());
			enactProxy.triggerTopRankedEnactmentForAdaptationDecision(topDecision, UUID.randomUUID());
	}
		
}
}
