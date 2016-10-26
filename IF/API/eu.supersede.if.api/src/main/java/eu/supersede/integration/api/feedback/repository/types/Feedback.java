/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.feedback.repository.types;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;
//import ch.uzh.ifi.feedback.repository.serialization.FeedbackSerializationService;
//
//@Serialize(FeedbackSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class Feedback {

	@NotNull
	private String title;
	@Id
	private Integer id;

	@NotNull
	@DbAttribute("application_id")
	private long applicationId;

	@DbAttribute("user_identification")
	@NotNull
	private String userIdentification;

	@DbAttribute("created_at")
	private Timestamp createdAt;

	@DbAttribute("updated_at")
	private Timestamp updatedAt;

	@DbAttribute("configuration_id")
	private long configurationId;
	
	private String language;

	@DbAttribute("context_information_id")
	private ContextInformation contextInformation;
	
	@DbIgnore
	private List<TextFeedback> textFeedbacks;
	@DbIgnore
	private List<RatingFeedback> ratingFeedbacks;
	@DbIgnore
	private List<ScreenshotFeedback> screenshotFeedbacks;
	@DbIgnore
	private List<FeedbackComment> feedbackComments;
	@DbIgnore
	private List<AttachmentFeedback> attachmentFeedbacks;
	@DbIgnore
	private List<AudioFeedback> audioFeedbacks;
	@DbIgnore
	private List<CategoryFeedback> categoryFeedbacks;

	public Feedback() {}
	
	public Feedback(String title, Integer id, Integer applicationId, String userIdentification, Timestamp createdAt,
			Timestamp updatedAt, String language, ContextInformation contextInformation,
			List<TextFeedback> textFeedbacks, List<RatingFeedback> ratings, List<ScreenshotFeedback> screenshots,
			List<FeedbackComment> feedbackComments, List<AttachmentFeedback> attachmentFeedbacks,
			List<AudioFeedback> audioFeedbacks, List<CategoryFeedback> categoryFeedbacks) {
		super();
		this.title = title;
		this.id = id;
		this.applicationId = applicationId;
		this.userIdentification = userIdentification;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.language = language;
		this.contextInformation = contextInformation;
		this.textFeedbacks = textFeedbacks;
		this.ratingFeedbacks = ratings;
		this.screenshotFeedbacks = screenshots;
		this.feedbackComments = feedbackComments;
		this.attachmentFeedbacks = attachmentFeedbacks;
		this.audioFeedbacks = audioFeedbacks;
		this.categoryFeedbacks = categoryFeedbacks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getApplicationId() {
		return applicationId;
	}
	
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	
	public long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(long configurationId) {
		this.configurationId = configurationId;
	}

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public ContextInformation getContextInformation() {
		return contextInformation;
	}

	public void setContextInformation(ContextInformation contextInformation) {
		this.contextInformation = contextInformation;
	}

	public List<TextFeedback> getTextFeedbacks() {
		return textFeedbacks;
	}

	public void setTextFeedbacks(List<TextFeedback> textFeedbacks) {
		this.textFeedbacks = textFeedbacks;
	}

	public List<RatingFeedback> getRatingFeedbacks() {
		return ratingFeedbacks;
	}

	public void setRatings(List<RatingFeedback> ratingFeedbacks) {
		this.ratingFeedbacks = ratingFeedbacks;
	}

	public List<ScreenshotFeedback> getScreenshotFeedbacks() {
		return screenshotFeedbacks;
	}

	public void setScreenshots(List<ScreenshotFeedback> screenshotFeedbacks) {
		this.screenshotFeedbacks = screenshotFeedbacks;
	}

	public List<FeedbackComment> getFeedbackComments() {
		return feedbackComments;
	}

	public void setFeedbackComments(List<FeedbackComment> feedbackComments) {
		this.feedbackComments = feedbackComments;
	}

	public List<AttachmentFeedback> getAttachmentFeedbacks() {
		return attachmentFeedbacks;
	}

	public void setAttachmentFeedbacks(List<AttachmentFeedback> attachmentFeedbacks) {
		this.attachmentFeedbacks = attachmentFeedbacks;
	}

	public List<AudioFeedback> getAudioFeedbacks() {
		return audioFeedbacks;
	}

	public void setAudioFeedbacks(List<AudioFeedback> audioFeedbacks) {
		this.audioFeedbacks = audioFeedbacks;
	}

	public List<CategoryFeedback> getCategoryFeedbacks() {
		return categoryFeedbacks;
	}

	public void setCategoryFeedbacks(List<CategoryFeedback> categoryFeedbacks) {
		this.categoryFeedbacks = categoryFeedbacks;
	}

	public void addScreenshotFeedback(ScreenshotFeedback screenshotFeedback) {
		this.screenshotFeedbacks.add(screenshotFeedback);
	}

	public void addRatingFeedback(RatingFeedback ratingFeedback) {
		this.ratingFeedbacks.add(ratingFeedback);
	}

	public void addTextFeedback(TextFeedback textFeedback) {
		this.textFeedbacks.add(textFeedback);
	}
}