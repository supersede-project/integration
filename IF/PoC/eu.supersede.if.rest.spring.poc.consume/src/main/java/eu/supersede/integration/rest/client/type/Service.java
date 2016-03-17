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

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Service {
	UUID uuid;
	URI uri;
	String name;
	String description;
	Boolean available;
	List<Operation> operations = new ArrayList<>();
	
	public Service(){
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
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	@XmlElement
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Override
	public String toString(){
		StringBuffer description = new StringBuffer()
			.append("Service{")
			.append("URI: " + uri + ", ")
			.append("name: " + name + ", ")
			.append("description: " + this.description + ", ")
			.append("is availble: " + available + ", ")
			.append("has operations: {");
		for (Operation op: operations){
			description.append(op);
		}
        description.append("}}");
		return description.toString();
	}
	
	@Override 
	public boolean equals (Object o){
		return (o instanceof Service) && 
		this.uri.equals (((Service)o).uri);
	}

	public void setUuid(String suuid) {
		this.uuid = UUID.fromString(suuid);
	}
}
