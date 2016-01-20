package eu.supersede.integration.poc.dynadapt.services;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enactment")
public class DynAdaptEnactImpl implements iDynAdaptEnact {
	private static final Logger log = LoggerFactory.getLogger(DynAdaptEnactImpl.class);

	//@Override
	@RequestMapping(value="/triggerAdaptationDecision/{decisionId}/{systemId}", method=RequestMethod.POST)
	public ResponseEntity<Boolean> triggerEnactmentForAdaptationDecision(@PathVariable UUID decisionId, @PathVariable UUID systemId) {
		// Acknowledge triggering of enactment decision, returning random triggering result (success, failure)
		log.info("Enactment of decision: " + decisionId + " for system: " + systemId);
		
		//Computing enactment result
		boolean result = new Random().nextBoolean();
		log.info("Enactment of decision: " + decisionId + " was: " + (result?"successful":"failed"));
		return new ResponseEntity<Boolean>(result, HttpStatus.CREATED);
	}
}
