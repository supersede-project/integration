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
package eu.supersede.integration.api.feedback.orchestrator.types;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;

public abstract class OrchestratorItem<T> extends ItemBase<T> implements IOrchestratorItem<T> {

	@DbAttribute("current_version")
	private transient boolean currentVersion;
	
	@DbAttribute("created_at")
	private Timestamp createdAt;
	
	@Override
	public abstract Integer getId();

	@Override
	public abstract void setId(Integer id);

	public boolean isCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(boolean currentVersion) {
		this.currentVersion = currentVersion;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
