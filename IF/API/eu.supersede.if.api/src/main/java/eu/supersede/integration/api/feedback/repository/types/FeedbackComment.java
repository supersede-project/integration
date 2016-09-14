package eu.supersede.integration.api.feedback.repository.types;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;

@JsonInclude(Include.NON_NULL)
public class FeedbackComment {

	@Id
	private long id;

	@DbAttribute("feedback_id")
	private transient long feedbackId;

	@NotNull
	private String comment;

	@DbAttribute("user_identification")
	private String userIdentification;

	@DbAttribute("created_at")
	private Timestamp createdAt;
}