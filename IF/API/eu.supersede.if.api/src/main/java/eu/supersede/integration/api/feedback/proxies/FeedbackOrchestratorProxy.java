package eu.supersede.integration.api.feedback.proxies;

import java.net.URI;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackMechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackParameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.proxy.IFServiceProxy;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackOrchestratorProxy <T> extends IFServiceProxy<T> implements IFeedbackOrchestrator {
	private final static String SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.orchestrator.endpoint");


	@Override
	public List<Application> getAllApplications() throws Exception{
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
		return getJSONObjectsListForType(Application[].class, uri, HttpStatus.OK);
	}
	
	
	@Override
	public Application getApplicationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK);
	}

	@Override
	public Application insertApplication(Application app, String token) throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
		return insertandReturnJSONObject(app, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Configuration> getAllConfigurations() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations");
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public Configuration getConfigurationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id);
		return getJSONObjectForType(Configuration.class, uri, HttpStatus.OK);
	}

	@Override
	public List<Configuration> getAllConfigurationsForApplicationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id + "/configurations");
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<GeneralConfiguration> getAllGeneralConfigurations() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations");
		return getJSONObjectsListForType(GeneralConfiguration[].class, uri, HttpStatus.OK);
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK);
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationForApplicationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id + "/general_configuration");
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK);
	}

	@Override
	public GeneralConfiguration updateGeneralConfigurations(GeneralConfiguration generalConfiguration, String token)
			throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid general configuration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations");
		return updateJSONObject(generalConfiguration, uri, HttpStatus.OK, token);
	}

	@Override
	public List<FeedbackMechanism> getAllFeedbackMechanisms() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms");
		return getJSONObjectsListForType(FeedbackMechanism[].class, uri, HttpStatus.OK);
	}

	@Override
	public FeedbackMechanism getFeedbackMechanismById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid feedback mechanism id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id);
		return getJSONObjectForType(FeedbackMechanism.class, uri, HttpStatus.OK);
	}

	@Override
	public List<FeedbackMechanism> getAllFeedbackMechanismsForConfigurationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
		return getJSONObjectsListForType(FeedbackMechanism[].class, uri, HttpStatus.OK);
	}

	@Override
	public FeedbackMechanism insertFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception {
		Assert.notNull(feedbackMechanism, "Provide a valid feedback mechanism");
		Assert.notNull(id, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
		return insertandReturnJSONObject(feedbackMechanism, uri, HttpStatus.OK, token);
	}

	@Override
	public FeedbackMechanism updateFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception {
		Assert.notNull(feedbackMechanism, "Provide a valid feedback mechanism");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
		return updateJSONObject(feedbackMechanism, uri, HttpStatus.OK, token);
	}

	@Override
	public List<FeedbackParameter> getAllFeedbackParameters() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters");
		return getJSONObjectsListForType(FeedbackParameter[].class, uri, HttpStatus.OK);
	}

	@Override
	public FeedbackParameter getFeedbackParameterById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid feedback parameter id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters/" + id);
		return getJSONObjectForType(FeedbackParameter.class, uri, HttpStatus.OK);
	}

	@Override
	public List<FeedbackParameter> getAllFeedbackParametersForFeedbackMechanismById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid feedback mechanism id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id + "/parameters");
		return getJSONObjectsListForType(FeedbackParameter[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public List<FeedbackParameter> getAllFeedbackParametersForGeneralConfigurationById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid general configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id + "/parameters");
		return getJSONObjectsListForType(FeedbackParameter[].class, uri, HttpStatus.OK);
	}
	
	@Override
	public FeedbackParameter insertFeedbackParameterForGeneralConfigurationById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception {
		Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
		Assert.notNull(id, "Provide a valid general configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id + "/parameters");
		return insertandReturnJSONObject(feedbackParameter, uri, HttpStatus.OK, token);
	}

	@Override
	public FeedbackParameter insertFeedbackParameterForFeedbackMechanismById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception {
		Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
		Assert.notNull(id, "Provide a valid feedback mechanism id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id + "/parameters");
		return insertandReturnJSONObject(feedbackParameter, uri, HttpStatus.OK, token);
	}

	@Override
	public FeedbackParameter updateFeedbackParameter(FeedbackParameter feedbackParameter, String token) throws Exception {
		Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters");
		return updateJSONObject(feedbackParameter, uri, HttpStatus.OK, token);
	}
	
	@Override
	public String authenticate (String user, String password) throws Exception{
		Assert.hasText(user, "Provide a valid user");
		Assert.hasText(user, "Provide a valid password");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "authenticate");
		JSONObject accountJson = new JSONObject();
		accountJson.put("name", user);
		accountJson.put("password", password);
		return postJSONObjectAndReturnValueForJsonLabel(accountJson.toString(), uri, HttpStatus.OK, "token");
	}

}
