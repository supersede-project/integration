package eu.supersede.integration.api.feedback.repository.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;

@JsonInclude(Include.NON_NULL)
public class TextAnnotation extends ItemBase<TextAnnotation> {

	@Id
	private Integer id;
	
	@DbAttribute("screenshot_feedbacks_id")
	private transient Integer screenshotId;
	
	@DbAttribute("reference_number")
	private Integer referenceNumber;
	
	@NotNull
	private String text;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScreenshotId() {
		return screenshotId;
	}

	public void setScreenshotId(Integer screenshotId) {
		this.screenshotId = screenshotId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Integer referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

}
