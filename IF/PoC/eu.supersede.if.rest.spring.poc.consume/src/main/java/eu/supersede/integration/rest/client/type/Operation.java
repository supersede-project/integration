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
package eu.supersede.integration.rest.client.type;

import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operation {

	UUID uuid;
	String name;
	String returnType;
	
	public Operation(){
		uuid = UUID.randomUUID();
	}
	
	@XmlElement
	public UUID getUuid() {
		return uuid;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	@Override
	public String toString(){
		StringBuffer description = new StringBuffer()
			.append("Operation{")
			.append("name: " + this.name + ", ")
			.append("returnType: " + returnType )
			.append("}");
		return description.toString();
	}
	
	@Override 
	public boolean equals (Object o){
		return (o instanceof Operation) && 
		this.name.equals (((Operation)o).name) && this.returnType.equals(((Operation)o).returnType);
	}

	public void setUuid(String ouuid) {
		this.uuid = UUID.fromString(ouuid);
	}
}
