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
package eu.supersede.integration.api.replan.controller.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

public class Plan extends ReplanIdentifiableObject{
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonProperty ("created_at")
	private Date creationDate;
	@JsonProperty ("release_id")
	private Integer releaseId;
	private List<Job> jobs;
	
	public Plan()
	{
		jobs = new ArrayList<>();
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}
	public List<Job> getJobs() {
		if (jobs == null)
			jobs = new ArrayList<>();
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}
