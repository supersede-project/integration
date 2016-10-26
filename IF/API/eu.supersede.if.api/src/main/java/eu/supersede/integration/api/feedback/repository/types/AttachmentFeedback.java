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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;

@JsonInclude(Include.NON_NULL)
public class AttachmentFeedback {

	@Id
	private long id;

	@DbAttribute("feedback_id")
	private transient Integer feedbackId;

	@NotNull
	private String path;

	@NotNull
	private long size;

	@NotNull
	@DbAttribute("file_extension")
	private String fileExtension;

	private String name;

	private String part;

	@DbAttribute("mechanism_id")
	private long mechanismId;

	public AttachmentFeedback(long id, Integer feedbackId, String path, long size, String fileExtension, String name,
			String part, long mechanismId) {
		super();
		this.id = id;
		this.feedbackId = feedbackId;
		this.path = path;
		this.size = size;
		this.fileExtension = fileExtension;
		this.name = name;
		this.part = part;
		this.mechanismId = mechanismId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public long getMechanismId() {
		return mechanismId;
	}

	public void setMechanismId(long mechanismId) {
		this.mechanismId = mechanismId;
	}
}