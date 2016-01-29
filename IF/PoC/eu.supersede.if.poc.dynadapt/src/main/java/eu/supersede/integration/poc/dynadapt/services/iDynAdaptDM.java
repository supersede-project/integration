package eu.supersede.integration.poc.dynadapt.services;

import java.util.Collection;
import java.util.UUID;

import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;

public interface iDynAdaptDM {
	Collection<AdaptationDecision> getAdaptationDecisions (UUID systemId);
}
