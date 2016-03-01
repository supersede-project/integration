package eu.supersede.integration.poc.dynadapt.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.poc.dynadapt.types.TopRankedAdaptationDecision;

public interface iDynAdaptEnact {
	ResponseEntity<AdaptationEnactment> triggerEnactmentForAdaptationDecision (UUID decisionId, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecision (TopRankedAdaptationDecision decision, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsJSON(AdaptationDecision decision, UUID systemId);
	AdaptationEnactment triggerTopRankedEnactmentForAdaptationDecisionAsXML(AdaptationDecision decision, UUID systemId);
}
