package eu.supersede.integration.api.feedback.proxies;

import java.util.List;

import eu.supersede.integration.api.feedback.repository.types.Feedback;

public interface IFeedbackRepository {
	public List<Feedback> GetAllFeedbacks() throws Exception;
	public List<Feedback> GetAllFeedbacksForApplication(Integer applicationId) throws Exception;
	public Feedback GetByFeedbackId(Integer id) throws Exception;
	public Feedback InsertFeedback(Feedback feedback) throws Exception;
	public void DeleteFeedback(Integer id) throws Exception;
}
