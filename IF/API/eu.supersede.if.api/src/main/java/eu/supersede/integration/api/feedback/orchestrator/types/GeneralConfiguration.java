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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.Service.IDbItem;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.Unique;
//import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
//import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
//import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
//import ch.uzh.ifi.feedback.library.rest.annotations.Serialize;
//import ch.uzh.ifi.feedback.library.rest.validation.Id;
//import ch.uzh.ifi.feedback.library.rest.validation.NotNull;
//import ch.uzh.ifi.feedback.library.rest.validation.Unique;
//import ch.uzh.ifi.feedback.library.rest.validation.Validate;
//import ch.uzh.ifi.feedback.orchestrator.model.FeedbackParameter;
//import ch.uzh.ifi.feedback.orchestrator.model.GeneralConfiguration;
//import ch.uzh.ifi.feedback.orchestrator.model.OrchestratorItem;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;
//import ch.uzh.ifi.feedback.orchestrator.serialization.ApplicationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.serialization.GeneralConfigurationSerializationService;
//import ch.uzh.ifi.feedback.orchestrator.validation.GeneralConfigurationValidator;
//
//@Validate(GeneralConfigurationValidator.class)
//@Serialize(GeneralConfigurationSerializationService.class)
@JsonInclude(Include.NON_NULL)
public class GeneralConfiguration extends OrchestratorItem<GeneralConfiguration>{
	
	@Id
	@DbAttribute("general_configurations_id")
	private Integer id;
	@DbIgnore
	private List<FeedbackParameter> parameters;
	@Unique
	private String name;
	
	public GeneralConfiguration()
	{
		parameters = new ArrayList<FeedbackParameter>();
	}
	
	public List<FeedbackParameter> getParameters() {
		if (parameters == null)
			parameters = new ArrayList<>();
		
		return parameters;
	}
	public void setParameters(List<FeedbackParameter> parameters) {
		this.parameters = parameters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	@Override
//	public GeneralConfiguration Merge(GeneralConfiguration original) {
//		for(FeedbackParameter param : original.getParameters())
//		{
//			try{
//				List<FeedbackParameter> parameters = getParameters();
//				Optional<FeedbackParameter> newParam = getParameters().stream().filter(p -> param.getId().equals(p.getId())).findFirst();
//				
//				if(!newParam.isPresent())
//				{
//					getParameters().add(param);
//				}else{ 
//					newParam.get().Merge(param);
//				}
//			} catch(NullPointerException e)
//			{
//				e.printStackTrace();
//			}
//		
//		}
//		
//		super.Merge(original);
//		
//		return this;
//	}
	
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
