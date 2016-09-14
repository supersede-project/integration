package eu.supersede.integration.api.feedback.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackMechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackParameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class FeedbackOrchestratorProxy implements IFeedbackOrchestrator {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.orchestrator.endpoint");
	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxy.class);


	@Override
	public List<Application> getAllApplications() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
			ResponseEntity<Application[]> response = 
					messageClient.getJSONMessage(uri, Application[].class);
			Application[] applications = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + applications.length + " application(s)");
			} else {
				log.info("There was a problem getting all applications");
			}
			return (List<Application>) Arrays.asList(applications);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Application getApplicationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid application id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id);
			ResponseEntity<Application> response = 
					messageClient.getJSONMessage(uri, Application.class);
			Application application = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located application " + application.getId());
			} else {
				log.info("There was a problem getting application " + id);
			}
			return application;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Application insertApplication(Application app) throws Exception {
		Application result = null;
		try {
			Assert.notNull(app, "Provide a valid application");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<Application> response = 
					messageClient.postJsonMessage(app, uri, Application.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully inserted application " + app.getId());
			} else {
				log.info("There was a problem inserting application " + result.getId());
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public Application updateApplication(Application app) throws Exception {
//		Application result = app;
//		try {
//			Assert.notNull(app, "Provide a valid application");
//			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
////			AuthorizationToken authenticationToken = null;
//			ResponseEntity<Boolean> response = 
//					messageClient.putJsonMessage(app, uri, Application.class);
//			if (response.getStatusCode().equals(HttpStatus.OK)) {
//				log.info("Successfully sent application " + app.getId());
//			} else {
//				log.info("There was a problem sending application " + app.getId());
//				app = null;
//			}
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}


	@Override
	public List<Configuration> getAllConfigurations() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations");
			ResponseEntity<Configuration[]> response = 
					messageClient.getJSONMessage(uri, Configuration[].class);
			Configuration[] configurations = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + configurations.length + " configuration(s)");
			} else {
				log.info("There was a problem getting all configurations");
			}
			return (List<Configuration>) Arrays.asList(configurations);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Configuration getConfigurationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id);
			ResponseEntity<Configuration> response = 
					messageClient.getJSONMessage(uri, Configuration.class);
			Configuration configuration = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located configuration " + configuration.getId());
			} else {
				log.info("There was a problem getting configuration " + id);
			}
			return configuration;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Configuration> getAllConfigurationsForApplicationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid application id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id + "/configurations");
			ResponseEntity<Configuration[]> response = 
					messageClient.getJSONMessage(uri, Configuration[].class);
			Configuration[] configurations = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + configurations.length + " configuration(s) for application " + id);
			} else {
				log.info("There was a problem getting all configurations for application " + id);
			}
			return (List<Configuration>) Arrays.asList(configurations);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<GeneralConfiguration> getAllGeneralConfigurations() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations");
			ResponseEntity<GeneralConfiguration[]> response = 
					messageClient.getJSONMessage(uri, GeneralConfiguration[].class);
			GeneralConfiguration[] generalConfigurations = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + generalConfigurations.length + " general configuration(s)");
			} else {
				log.info("There was a problem getting all general configurations");
			}
			return (List<GeneralConfiguration>) Arrays.asList(generalConfigurations);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id);
			ResponseEntity<GeneralConfiguration> response = 
					messageClient.getJSONMessage(uri, GeneralConfiguration.class);
			GeneralConfiguration general_configurations = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located general configuration " + general_configurations.getId());
			} else {
				log.info("There was a problem getting general configuration " + id);
			}
			return general_configurations;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationForApplicationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid application id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + id + "/general_configuration");
			ResponseEntity<GeneralConfiguration> response = 
					messageClient.getJSONMessage(uri, GeneralConfiguration.class);
			GeneralConfiguration generalConfiguration = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located general configuration for application " + id);
			} else {
				log.info("There was a problem getting general configurations for application " + id);
			}
			return (GeneralConfiguration) generalConfiguration;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public GeneralConfiguration updateGeneralConfigurations(GeneralConfiguration generalConfiguration)
			throws Exception {
		GeneralConfiguration result = null;
		try {
			Assert.notNull(generalConfiguration, "Provide a valid general configuration");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<GeneralConfiguration> response = 
					messageClient.putJsonMessage(generalConfiguration, uri, GeneralConfiguration.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully updated general configuration " + generalConfiguration.getId());
			} else {
				log.info("There was a problem updating general configuration " + generalConfiguration.getId());
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FeedbackMechanism> getAllFeedbackMechanisms() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms");
			ResponseEntity<FeedbackMechanism[]> response = 
					messageClient.getJSONMessage(uri, FeedbackMechanism[].class);
			FeedbackMechanism[] feedbackMechanisms = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbackMechanisms.length + " feedback mechanism(s)");
			} else {
				log.info("There was a problem getting all feedback mechanisms");
			}
			return (List<FeedbackMechanism>) Arrays.asList(feedbackMechanisms);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackMechanism getFeedbackMechanismById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid feedback mechanism id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id);
			ResponseEntity<FeedbackMechanism> response = 
					messageClient.getJSONMessage(uri, FeedbackMechanism.class);
			FeedbackMechanism feedbackMechanism = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located feedback mechanism " + feedbackMechanism.getId());
			} else {
				log.info("There was a problem getting feedback mechanism " + id);
			}
			return feedbackMechanism;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FeedbackMechanism> getAllFeedbackMechanismsForConfigurationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
			ResponseEntity<FeedbackMechanism[]> response = 
					messageClient.getJSONMessage(uri, FeedbackMechanism[].class);
			FeedbackMechanism[] feedbackMechanisms = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbackMechanisms.length + " feedback mechanism(s) for configuration " + id);
			} else {
				log.info("There was a problem getting all feedback mechanisms for configuration " + id);
			}
			return (List<FeedbackMechanism>) Arrays.asList(feedbackMechanisms);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackMechanism insertFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism) throws Exception {
		FeedbackMechanism result = null;
		try {
			Assert.notNull(feedbackMechanism, "Provide a valid feedback mechanism");
			Assert.notNull(id, "Provide a valid configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<FeedbackMechanism> response = 
					messageClient.postJsonMessage(feedbackMechanism, uri, FeedbackMechanism.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully inserted feedback mechanism " + result.getId());
			} else {
				log.info("There was a problem inserting feedback mechanism");
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackMechanism updateFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism) throws Exception {
		FeedbackMechanism result = null;
		try {
			Assert.notNull(feedbackMechanism, "Provide a valid feedback mechanism");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + id + "/mechanisms");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<FeedbackMechanism> response = 
					messageClient.putJsonMessage(feedbackMechanism, uri, FeedbackMechanism.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully updated feedback mechanism " + feedbackMechanism.getId());
			} else {
				log.info("There was a problem updating feedback mechanism " + feedbackMechanism.getId());
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FeedbackParameter> getAllFeedbackParameters() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters");
			ResponseEntity<FeedbackParameter[]> response = 
					messageClient.getJSONMessage(uri, FeedbackParameter[].class);
			FeedbackParameter[] feedbackParameters = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbackParameters.length + " feedback parameter(s)");
			} else {
				log.info("There was a problem getting all feedback parameters");
			}
			return (List<FeedbackParameter>) Arrays.asList(feedbackParameters);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackParameter getFeedbackParameterById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid feedback parameter id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters/" + id);
			ResponseEntity<FeedbackParameter> response = 
					messageClient.getJSONMessage(uri, FeedbackParameter.class);
			FeedbackParameter feedbackParameter = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located feedback parameter " + feedbackParameter.getId());
			} else {
				log.info("There was a problem getting feedback parameter " + id);
			}
			return feedbackParameter;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FeedbackParameter> getAllFeedbackParametersForFeedbackMechanismById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid feedback mechanism id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id + "/parameters");
			ResponseEntity<FeedbackParameter[]> response = 
					messageClient.getJSONMessage(uri, FeedbackParameter[].class);
			FeedbackParameter[] feedbackParameters = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbackParameters.length + " feedback parameter(s) for feedback mechanism " + id);
			} else {
				log.info("There was a problem getting all feedback parameters for feedback mechanism " + id);
			}
			return (List<FeedbackParameter>) Arrays.asList(feedbackParameters);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<FeedbackParameter> getAllFeedbackParametersForGeneralConfigurationById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid general configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id + "/parameters");
			ResponseEntity<FeedbackParameter[]> response = 
					messageClient.getJSONMessage(uri, FeedbackParameter[].class);
			FeedbackParameter[] feedbackParameters = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbackParameters.length + " feedback parameter(s) for general configuration " + id);
			} else {
				log.info("There was a problem getting all feedback parameters for general configuration " + id);
			}
			return (List<FeedbackParameter>) Arrays.asList(feedbackParameters);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackParameter insertFeedbackParameterForGeneralConfigurationById(Integer id,
			FeedbackParameter feedbackParameter) throws Exception {
		FeedbackParameter result = null;
		try {
			Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
			Assert.notNull(id, "Provide a valid general configuration id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + id + "/parameters");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<FeedbackParameter> response = 
					messageClient.postJsonMessage(feedbackParameter, uri, FeedbackParameter.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully inserted feedback parameter " + result.getId());
			} else {
				log.info("There was a problem inserting feedback parameter");
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackParameter insertFeedbackParameterForFeedbackMechanismById(Integer id,
			FeedbackParameter feedbackParameter) throws Exception {
		FeedbackParameter result = null;
		try {
			Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
			Assert.notNull(id, "Provide a valid feedback mechanism id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + id + "/parameters");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<FeedbackParameter> response = 
					messageClient.postJsonMessage(feedbackParameter, uri, FeedbackParameter.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully inserted feedback parameter " + result.getId());
			} else {
				log.info("There was a problem inserting feedback parameter");
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public FeedbackParameter updateFeedbackParameter(FeedbackParameter feedbackParameter) throws Exception {
		FeedbackParameter result = null;
		try {
			Assert.notNull(feedbackParameter, "Provide a valid feedback parameter");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<FeedbackParameter> response = 
					messageClient.putJsonMessage(feedbackParameter, uri, FeedbackParameter.class);
			result = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully updated feedback parameter " + feedbackParameter.getId());
			} else {
				log.info("There was a problem updating feedback parameter " + feedbackParameter.getId());
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
