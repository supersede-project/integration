package eu.supersede.integration.poc.dynadapt.services;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

public interface iDynAdaptEnact {
	ResponseEntity<Boolean> triggerEnactmentForAdaptationDecision (UUID decisionId, UUID systemId);
}
