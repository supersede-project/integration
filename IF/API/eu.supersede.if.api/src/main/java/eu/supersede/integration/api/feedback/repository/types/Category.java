package eu.supersede.integration.api.feedback.repository.types;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.validation.Id;

public class Category {

	@Id
	private long id;
	
	private String text;
	
	@DbAttribute("category_feedback_id")
	private transient Integer categoryFeedbackId;
	
	private CategoryType categoryType;	
}