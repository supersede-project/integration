package eu.supersede.integration.api.dm.proxies;

import demo.unsecured.model.Alert;

public interface IDecisionMakingSystem {
	public boolean notifyAlert( Alert alert );
}
