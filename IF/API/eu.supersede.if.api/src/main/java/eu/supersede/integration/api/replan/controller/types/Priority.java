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

import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
	ONE (1), TWO (2), THREE (3), FOUR (4), FIVE (5);
	private Integer value;
	private Priority(Integer value){
		this.value = value;
	}
	
	public Integer getValue (){
		return value;
	}
	
	@Override
	@JsonValue
	public String toString(){
		return String.valueOf(value);
	}
}
