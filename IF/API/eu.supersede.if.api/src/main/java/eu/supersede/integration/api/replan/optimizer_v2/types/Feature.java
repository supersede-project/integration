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
package eu.supersede.integration.api.replan.optimizer_v2.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Feature{
	private String name;
	private Double duration;
	private Priority priority;
	@JsonProperty ("required_skills")
	private List<Skill> requiredSkills;
	@JsonProperty ("depends_on")
	private List<Feature> dependencies;
	
	public Feature()
	{
		requiredSkills = new ArrayList<>();
		dependencies = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getDuration() {
		return duration;
	}
	public void setDuration(Double duration) {
		this.duration = duration;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public List<Skill> getRequiredSkills() {
		if (requiredSkills == null)
			requiredSkills = new ArrayList<>();
		return requiredSkills;
	}
	public void setRequiredSkills(List<Skill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public List<Feature> getDependencies() {
		if (dependencies == null)
			dependencies = new ArrayList<>();
		return dependencies;
	}

	public void setDependencies(List<Feature> dependencies) {
		this.dependencies = dependencies;
	}
	
}
