package eu.supersede.integration.poc.dynadapt.services;

import java.util.Collection;
import java.util.UUID;

public interface iDynAdaptDM {
	Collection<UUID> getAdaptationDecisions (UUID systemId);
}
