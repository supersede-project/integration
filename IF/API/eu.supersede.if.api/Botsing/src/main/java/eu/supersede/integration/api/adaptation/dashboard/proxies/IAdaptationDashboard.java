package eu.supersede.integration.api.adaptation.dashboard.proxies;

import java.util.List;

import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;

public interface IAdaptationDashboard {
	//Adaptations
	List<Adaptation> getAllAdaptations () throws Exception;
	Adaptation addAdaptation (Adaptation adaptation) throws Exception;
	Adaptation getAdaptation (String id) throws Exception;
	void deleteAdaptation (String id) throws Exception;
	
	//Enactments
	List<Enactment> getAllEnactments () throws Exception;
	Enactment addEnactment (Enactment adaptation) throws Exception;
	Enactment getEnactment (String id) throws Exception;
	void deleteEnactment (String id) throws Exception;
}
