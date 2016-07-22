package eu.supersede.integration.api.dm.proxies;

import eu.supersede.integration.api.dm.types.Alert;

public interface IDecisionMakingSystem {
	public boolean notifyAlert( Alert alert );
}
