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
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class FeedbackOrchestratorProxy implements IFeedbackOrchestrator {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.orchestrator.endpoint");
	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxy.class);


	@Override
	public List<Application> GetAllApplications() throws Exception {
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
	public Application GetApplicationById(Integer id) throws Exception {
		try {
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
	public Application InsertApplication(Integer appId, Application app) throws Exception {
		Application result = app;
		try {
			Assert.notNull(app, "Provide a valid application");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<Boolean> response = 
					messageClient.postJsonMessage(app, uri, Application.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully inserted application " + app.getId());
			} else {
				log.info("There was a problem inserting application " + app.getId());
				app = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Application UpdateApplication(Application app) throws Exception {
		Application result = app;
		try {
			Assert.notNull(app, "Provide a valid application");
			URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<Boolean> response = 
					messageClient.putJsonMessage(app, uri, Application.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Successfully sent application " + app.getId());
			} else {
				log.info("There was a problem sending application " + app.getId());
				app = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
