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

import eu.supersede.integration.api.replan.controller.types.Job;

public class PlanningSolution {
	private List<PlannedFeature> jobs;
	
	public List<PlannedFeature> getJobs() {
		if (jobs == null)
			jobs = new ArrayList<>();
		return jobs;
	}
	public void setJobs(List<PlannedFeature> jobs) {
		this.jobs = jobs;
	}
}
