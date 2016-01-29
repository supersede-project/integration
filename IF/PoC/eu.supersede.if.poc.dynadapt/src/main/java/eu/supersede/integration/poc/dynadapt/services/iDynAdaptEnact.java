package eu.supersede.integration.poc.dynadapt.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;

public interface iDynAdaptEnact {
	ResponseEntity<AdaptationEnactment> triggerEnactmentForAdaptationDecision (UUID decisionId, UUID systemId);
}
