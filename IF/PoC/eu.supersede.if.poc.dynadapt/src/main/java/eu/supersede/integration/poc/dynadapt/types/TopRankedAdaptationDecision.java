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
package eu.supersede.integration.poc.dynadapt.types;

import java.util.UUID;

public class TopRankedAdaptationDecision {

	private UUID uuid;
	private String decisionName;
	private String decisionDescription;
	private boolean supervisionRequired;
	private int priority;
	private int status;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getDecisionName() {
		return decisionName;
	}

	public void setDecisionName(String decisionName) {
		this.decisionName = decisionName;
	}

	public String getDecisionDescription() {
		return decisionDescription;
	}

	public void setDecisionDescription(String decisionDescription) {
		this.decisionDescription = decisionDescription;
	}

	public boolean isSupervisionRequired() {
		return supervisionRequired;
	}

	public void setSupervisionRequired(boolean supervisionRequired) {
		this.supervisionRequired = supervisionRequired;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
    public String toString() {
		return "AdaptationDecision{" +
                "uuid=" + uuid +
                ", decisionName='" + decisionName + '\'' +
                ", decisionDescription='" + decisionDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", supervisionRequired='" + supervisionRequired + '\'' +
                ", status='" + status + '\'' +
                '}';
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}