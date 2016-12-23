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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import ch.uzh.ifi.feedback.library.rest.validation.Unique;
import ch.uzh.ifi.feedback.library.rest.Service.IDbItem;
import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
import ch.uzh.ifi.feedback.library.rest.validation.Unique;
import ch.uzh.ifi.feedback.library.rest.validation.Validate;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ApplicationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ConfigurationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.validation.ConfigurationValidator;
//
//@Validate(ConfigurationValidator.class)
//@Serialize(ConfigurationSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class Configuration extends OrchestratorItem<Configuration> {
	
	@Id
	@DbAttribute("configurations_id")
	private Integer id;
	
	private boolean active;
	
	@Unique
	private String name;
	
	@NotNull
	private ConfigurationType type;
	@DbIgnore
	private List<FeedbackMechanism> mechanisms;
	@DbIgnore
	private GeneralConfiguration generalConfiguration;
	
	@DbAttribute("general_configurations_id")
	private transient Integer generalConfigurationId;
	
	@DbAttribute("applications_id")
	private transient Integer applicationId;
	
	@DbAttribute("user_groups_id")
	private transient Integer userGroupsId;
	
	public Configuration(){
		mechanisms = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String applicationName) {
		this.name = applicationName;
	}

	@JsonProperty ("mechanisms")
	public List<FeedbackMechanism> getFeedbackMechanisms() {
		if (mechanisms == null)
			mechanisms = new ArrayList<>();
		
		return mechanisms;
	}

	public ConfigurationType getType() {
		return type;
	}

	public void setType(ConfigurationType type) {
		this.type = type;
	}

	public GeneralConfiguration getGeneralConfiguration() {
		return generalConfiguration;
	}

	public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
		this.generalConfiguration = generalConfiguration;
	}

	public Integer getGeneralConfigurationId() {
		return generalConfigurationId;
	}

	public void setGeneralConfigurationId(Integer generalConfigurationId) {
		this.generalConfigurationId = generalConfigurationId;
	}
	
//	@Override
//	public Configuration Merge(Configuration original) {
//		for(FeedbackMechanism mechanism : original.getFeedbackMechanisms())
//		{
//			Optional<FeedbackMechanism> newMechanism = getFeedbackMechanisms().stream().filter(p -> p.getId().equals(mechanism.getId())).findFirst();
//			if(!newMechanism.isPresent())
//			{
//				mechanisms.add(mechanism);
//			}else{ 
//				newMechanism.get().Merge(mechanism);
//			}
//		}
//		
//		if(generalConfiguration != null){
//			generalConfiguration.Merge(original.getGeneralConfiguration());
//		}else{
//			generalConfiguration = original.getGeneralConfiguration();
//		}
//		
//		super.Merge(original);
//		
//		return this;
//	}

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}