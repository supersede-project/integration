package eu.supersede.integration.api.feedback.proxies;

import java.util.List;

import eu.supersede.integration.api.feedback.repository.types.Feedback;

public interface IFeedbackRepository {
	public List<Feedback> getAllFeedbacks() throws Exception;
//	public List<Feedback> getAllFeedbacksForApplication(Integer applicationId) throws Exception;
	public Feedback getFeedbackById(Integer id) throws Exception;
	public Feedback insertFeedback(Feedback feedback) throws Exception;
//	public void deleteFeedback(Integer id) throws Exception;
}
