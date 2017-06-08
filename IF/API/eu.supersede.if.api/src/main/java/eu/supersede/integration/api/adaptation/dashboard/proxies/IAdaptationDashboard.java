package eu.supersede.integration.api.adaptation.dashboard.proxies;

import java.util.List;

import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;

public interface IAdaptationDashboard {
	List<Adaptation> getAllAdaptations () throws Exception;
	Adaptation addAdaptation (Adaptation adaptation) throws Exception;
}
