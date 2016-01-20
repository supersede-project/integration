package eu.supersede.integration.poc.dynadapt.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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

@RestController
@RequestMapping(value="/dm")
public class DynAdaptDMImpl implements iDynAdaptDM {
	private static final Logger log = LoggerFactory.getLogger(DynAdaptDMImpl.class);
	static Collection<UUID> currentDecisions = new ArrayList<UUID>();
	static final int A_MINUTE = 1000*60;
	
	//Service generates random (1 to 10) adaptation decisions: Collection<UUID> every minute
	static{
		ComputeDecisionsTask task = new ComputeDecisionsTask();
		Timer timer = new Timer();
		log.info("Scheduled ComputeDecisionsTask");
		timer.schedule(task, Calendar.getInstance().getTime(), A_MINUTE);
	}
	
	@Override
	@RequestMapping(value="/adaptationDecisions/{systemId}", method=RequestMethod.GET)
	public Collection<UUID> getAdaptationDecisions(@PathVariable UUID systemId) {
		log.info("getAdaptationDecisions processed for system: " + systemId);
		if (currentDecisions.isEmpty()) computeDecisions();
		return currentDecisions;
	}
	
	public static void computeDecisions(){
		currentDecisions.clear();
		int number = new Random().nextInt(10);
		for (int i=0; i<number; i++){
			currentDecisions.add(UUID.randomUUID());
		}
		log.info("Computed " + number + " adaptation decisions");
	}
}

class ComputeDecisionsTask extends TimerTask{
	private static final Logger log = LoggerFactory.getLogger(ComputeDecisionsTask.class);
	
	public ComputeDecisionsTask(){
	}

	@Override
	public void run() {
		log.info("Launching scheduled ComputeDecisionsTask");
		DynAdaptDMImpl.computeDecisions();
	}
}
