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
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AddFeaturesForProjectPayload {
	@JsonProperty ("evaluation_time")
	private String evaluationTime;
	private List<FeatureWP3> features;
	private List<Constraint> constraints;
	
	public AddFeaturesForProjectPayload(){
		features = new ArrayList<>();
		constraints = new ArrayList<>();
	}
	
	public String getEvaluationTime() {
		return evaluationTime;
	}
	public void setEvaluationTime(String evaluationTime) {
		this.evaluationTime = evaluationTime;
	}
	
	public List<FeatureWP3> getFeatures() {
		if (features == null)
			features = new ArrayList<>();
		return features;
	}

	public void setFeatures(List<FeatureWP3> features) {
		this.features = features;
	}
	
	public List<Constraint> getConstraints() {
		if (constraints == null)
			constraints = new ArrayList<>();
		return constraints;
	}

	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
}
