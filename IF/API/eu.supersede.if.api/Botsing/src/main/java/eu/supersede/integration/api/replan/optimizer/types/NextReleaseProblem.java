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
package eu.supersede.integration.api.replan.optimizer.types;

import java.util.ArrayList;
import java.util.List;

public class NextReleaseProblem {
	
	private Integer nbWeeks;
	private Double hoursPerWeek;
	private List<Feature> features;
	private List<Resource> resources;
	private PlanningSolution currentPlan;
	private AlgorithmParameters algorithmParameters;
	
	public Integer getNbWeeks() {
		return nbWeeks;
	}
	public void setNbWeeks(Integer nbWeeks) {
		this.nbWeeks = nbWeeks;
	}
	public Double getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(Double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public List<Resource> getResources() {
		if (resources == null)
			resources = new ArrayList<>();
		
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public List<Feature> getFeatures() {
		if (features == null)
			features = new ArrayList<>();
		
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	
	public PlanningSolution getCurrentPlan() {
		return currentPlan;
	}
	public void setCurrentPlan(PlanningSolution currentPlan) {
		this.currentPlan = currentPlan;
	}
	public AlgorithmParameters getAlgorithmParameters() {
		return algorithmParameters;
	}
	public void setAlgorithmParameters(AlgorithmParameters algorithmParameters) {
		this.algorithmParameters = algorithmParameters;
	}
}
