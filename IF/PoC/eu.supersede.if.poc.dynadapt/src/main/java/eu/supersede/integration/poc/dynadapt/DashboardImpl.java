package eu.supersede.integration.poc.dynadapt;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import eu.supersede.integration.poc.dynadapt.rest.client.IFMessageClient;

@Component
public class DashboardImpl {
	private static final Logger log = LoggerFactory.getLogger(DashboardImpl.class);
	private IFMessageClient messageClient = new IFMessageClient();
	
	public void run() {
		// TODO Auto-generated method stub
		log.info("Executing dashboard implementation");
		log.info("Getting available adaptation decisions");
		try {
			UUID systemId = UUID.randomUUID();
			Collection<UUID> decisions = getAdaptationDecisions(systemId);
			if (!decisions.isEmpty()){
				triggerEnactmentForAdaptationDecision(decisions.iterator().next(), systemId);
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Collection<UUID> getAdaptationDecisions(UUID systemId) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/dm/adaptationDecisions/" + systemId);
		ResponseEntity<UUID[]> response = messageClient.getMessage(uri, UUID[].class);
		UUID[] decisions = response.getBody();
		if (response.getStatusCode().equals(HttpStatus.OK)) {
			log.info("Located " + decisions.length + " decision(s)");
			for (UUID decision:decisions){
				log.info("Decision: " + decision);
			}
		} else {
			log.info("There was a problem getting available adaptation decisions");
		}
		return (Collection<UUID>) Arrays.asList(decisions);
	}
	
	public boolean triggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/enactment/triggerAdaptationDecision/" + 
				decisionId +"/" + systemId);
		ResponseEntity<String> response = messageClient.postJsonMessage("", uri);
		boolean enactment = Boolean.getBoolean(response.getBody());
		if (response.getStatusCode().equals(HttpStatus.CREATED) && enactment) {
			log.info("Successful enactment of decision: " + decisionId);
		} else {
			log.info("There was a problem enacting decision: " + decisionId);
		}
		return enactment;
	}

}
