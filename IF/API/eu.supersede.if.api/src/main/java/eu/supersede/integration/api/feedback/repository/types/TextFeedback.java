package eu.supersede.integration.api.feedback.repository.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.validation.Id;

@JsonInclude(Include.NON_NULL)
public class TextFeedback {

	@Id
	private Integer id;

	@DbAttribute("feedback_id")
	private transient Integer feedbackId;

	private String text;

	@DbAttribute("mechanism_id")
	private Integer mechanismId;
	
	public TextFeedback() {}

	public TextFeedback(Integer id, Integer feedbackId, String text, Integer mechanismId) {
		super();
		this.id = id;
		this.feedbackId = feedbackId;
		this.text = text;
		this.mechanismId = mechanismId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getMechanismId() {
		return mechanismId;
	}

	public void setMechanismId(Integer mechanismId) {
		this.mechanismId = mechanismId;
	}
}