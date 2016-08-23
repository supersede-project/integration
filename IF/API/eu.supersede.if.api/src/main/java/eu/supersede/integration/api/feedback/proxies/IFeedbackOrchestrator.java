package eu.supersede.integration.api.feedback.proxies;

import java.util.List;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;

public interface IFeedbackOrchestrator {
	public List<Application> GetAllApplications() throws Exception;
	public Application GetApplicationById(Integer id) throws Exception;
	public Application InsertApplication(Integer appId, Application app) throws Exception;
	public Application UpdateApplication(Application app) throws Exception;
}
