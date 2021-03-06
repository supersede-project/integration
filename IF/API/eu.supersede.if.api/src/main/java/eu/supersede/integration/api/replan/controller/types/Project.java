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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project extends ReplanBaseObject{
	@JsonProperty ("effort_unit")
	private String effortUnit;
	@JsonProperty ("hours_per_effort_unit")
	private Double hoursPerEffortUnit;
	@JsonProperty ("hours_per_week_and_full_time_resource")
	private Double hoursPerWeekFullTimeResource;
	private List<Resource> resources;
	
	public Project()
	{
		resources = new ArrayList<>();
	}
	
	public String getEffortUnit() {
		return effortUnit;
	}
	public void setEffortUnit(String effortUnit) {
		this.effortUnit = effortUnit;
	}
	public Double getHoursPerEffortUnit() {
		return hoursPerEffortUnit;
	}
	public void setHoursPerEffortUnit(Double hoursPerEffortUnit) {
		this.hoursPerEffortUnit = hoursPerEffortUnit;
	}
	public Double getHoursPerWeekFullTimeResource() {
		return hoursPerWeekFullTimeResource;
	}
	public void setHoursPerWeekFullTimeResource(Double hoursPerWeekFullTimeResource) {
		this.hoursPerWeekFullTimeResource = hoursPerWeekFullTimeResource;
	}
	public List<Resource> getResources() {
		if (resources == null)
			resources = new ArrayList<>();
		
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}
