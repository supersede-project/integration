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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;

@JsonInclude(Include.NON_NULL)
public class ScreenshotFeedback extends FileFeedback {

	@DbAttribute("feedback_id")
	private transient Integer feedbackId;

	@DbAttribute("mechanism_id")
	private Integer mechanismId;
	
	@DbIgnore
	private List<TextAnnotation> textAnnotations;

	public ScreenshotFeedback() {
		setTextAnnotations(new ArrayList<>());
	}

	public ScreenshotFeedback(Integer id, Integer feedbackId, String path, int size, String name, Integer mechanismId,
			String part, String fileExtension) {
		super();
		this.id = id;
		this.feedbackId = feedbackId;
		this.path = path;
		this.size = size;
		this.name = name;
		this.mechanismId = mechanismId;
		this.part = part;
		this.fileExtension = fileExtension;
		setTextAnnotations(new ArrayList<>());
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getMechanismId() {
		return mechanismId;
	}

	public void setMechanismId(Integer mechanismId) {
		this.mechanismId = mechanismId;
	}

	public List<TextAnnotation> getTextAnnotations() {
		if(textAnnotations == null)
			textAnnotations = new ArrayList<>();
		
		return textAnnotations;
	}

	public void setTextAnnotations(List<TextAnnotation> textAnnotations) {
		this.textAnnotations = textAnnotations;
	}
}