package eu.supersede.integration.api.feedback.proxies;

import java.util.List;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackMechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackParameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;

public interface IFeedbackOrchestrator {
	public List<Application> getAllApplications() throws Exception;

	public Application getApplicationById(Integer id) throws Exception;

	public Application insertApplication(Application app, String token) throws Exception;

	// public Application updateApplication(Application app) throws Exception;
	public List<Configuration> getAllConfigurations() throws Exception;

	public Configuration getConfigurationById(Integer id) throws Exception;

	public List<Configuration> getAllConfigurationsForApplicationById(Integer id) throws Exception;

	public List<GeneralConfiguration> getAllGeneralConfigurations() throws Exception;

	public GeneralConfiguration getGeneralConfigurationById(Integer id) throws Exception;

	public GeneralConfiguration getGeneralConfigurationForApplicationById(Integer id) throws Exception;

	public GeneralConfiguration updateGeneralConfigurations(GeneralConfiguration generalConfiguration, String token)
			throws Exception;

	public List<FeedbackMechanism> getAllFeedbackMechanisms() throws Exception;

	public FeedbackMechanism getFeedbackMechanismById(Integer id) throws Exception;

	public List<FeedbackMechanism> getAllFeedbackMechanismsForConfigurationById(Integer id) throws Exception;

	public FeedbackMechanism insertFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception;

	public FeedbackMechanism updateFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParameters() throws Exception;

	public FeedbackParameter getFeedbackParameterById(Integer id) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParametersForFeedbackMechanismById(Integer id) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParametersForGeneralConfigurationById(Integer id) throws Exception;

	public FeedbackParameter insertFeedbackParameterForGeneralConfigurationById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception;

	public FeedbackParameter insertFeedbackParameterForFeedbackMechanismById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception;

	public FeedbackParameter updateFeedbackParameter(FeedbackParameter feedbackParameter, String token)
			throws Exception;

	String authenticate(String user, String password) throws Exception;
}
