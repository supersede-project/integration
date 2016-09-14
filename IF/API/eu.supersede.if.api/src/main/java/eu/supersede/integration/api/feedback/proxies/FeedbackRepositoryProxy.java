package eu.supersede.integration.api.feedback.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class FeedbackRepositoryProxy implements IFeedbackRepository {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.repository.endpoint");
	private static final Logger log = LoggerFactory.getLogger(FeedbackRepositoryProxy.class);

	
	@Override
	public List<Feedback> getAllFeedbacks() throws Exception {
		try {
			URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks");
			ResponseEntity<Feedback[]> response = 
					messageClient.getJSONMessage(uri, Feedback[].class);
			Feedback[] feedbacks = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + feedbacks.length + " feedback(s)");
			} else {
				log.info("There was a problem getting all feedbacks");
			}
			return (List<Feedback>) Arrays.asList(feedbacks);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public List<Feedback> getAllFeedbacksForApplication(Integer applicationId) throws Exception {
//		try {
//			Assert.notNull(applicationId, "Provide a valid application id");
//			URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/applications/" + applicationId + "/feedbacks");
//			ResponseEntity<Feedback[]> response = 
//					messageClient.getJSONMessage(uri, Feedback[].class);
//			Feedback[] feedbacks = response.getBody();
//			if (response.getStatusCode().equals(HttpStatus.OK)) {
//				log.info("Located " + feedbacks.length + " feedback(s)");
//			} else {
//				log.info("There was a problem getting all feedbacks");
//			}
//			return (List<Feedback>) Arrays.asList(feedbacks);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public Feedback getFeedbackById(Integer id) throws Exception {
		try {
			Assert.notNull(id, "Provide a valid feedback id");
			URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks/" + id);
			ResponseEntity<Feedback> response = 
					messageClient.getJSONMessage(uri, Feedback.class);
			Feedback feedback = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located feedback " + feedback.getId());
			} else {
				log.info("There was a problem getting feedback " + id);
			}
			return feedback;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Feedback insertFeedback(Feedback feedback) throws Exception {
		Feedback result = feedback;
		try {
			Assert.notNull(feedback, "Provide a valid feedback");
			URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks");
//			AuthorizationToken authenticationToken = null;
			ResponseEntity<Feedback> response = 
					messageClient.postJsonMessage(feedback, uri, Feedback.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				result = response.getBody();
				log.info("Successfully inserted feedback " + result.getTitle());
			} else {
				log.info("There was a problem inserting feedback " + feedback.getTitle());
				result = null;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	@Override
//	public void deleteFeedback(Integer id) throws Exception {
//		try {
//			Assert.notNull(id, "Provide a valid feedback id");
//			URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks" + id);
////			AuthorizationToken authenticationToken = null;
//			ResponseEntity<String> response = 
//					messageClient.deleteJsonMessage(uri);
//			if (response.getStatusCode().equals(HttpStatus.OK)) {
//				log.info("Successfully deleted feedback " + id);
//			} else {
//				log.info("There was a problem deleting feedback " + id);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
