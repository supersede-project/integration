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

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AdaptationDecision")
public class AdaptationEnactment {
	
	private UUID decisionId;
	private Date enactmentTimestamp;
	private boolean enactmentResult;
	private String failureReason;
	
	@XmlElement
	public UUID getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(UUID decisionId) {
		this.decisionId = decisionId;
	}

	@XmlElement
	public Date getEnactmentTimestamp() {
		return enactmentTimestamp;
	}

	public void setEnactmentTimestamp(Date enactmentTimestamp) {
		this.enactmentTimestamp = enactmentTimestamp;
	}

	@XmlElement
	public boolean isEnactmentResult() {
		return enactmentResult;
	}

	public void setEnactmentResult(boolean enactmentResult) {
		this.enactmentResult = enactmentResult;
	}

	@XmlElement
	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	@Override
    public String toString() {
		return "AdaptationDecision{" +
                "id=" + decisionId +
                ", enactmentTimestamp='" + enactmentTimestamp + '\'' +
                ", enactmentResult='" + enactmentResult + '\'' +
                ", failureReason='" + failureReason + '\'' +
                '}';
	}
}
