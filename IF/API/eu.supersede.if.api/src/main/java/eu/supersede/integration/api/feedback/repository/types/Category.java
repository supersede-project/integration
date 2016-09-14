package eu.supersede.integration.api.feedback.repository.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.validation.Id;

@JsonInclude(Include.NON_NULL)
public class Category {

	@Id
	private long id;
	
	private String text;
	
	@DbAttribute("category_feedback_id")
	private transient Integer categoryFeedbackId;
	
	private CategoryType categoryType;	
}