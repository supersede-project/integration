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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="collection")
public class CollectionOfDecisions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Collection<AdaptationDecision> collection = new ArrayList<>();
	
	public CollectionOfDecisions(){
		
	}
	
	public CollectionOfDecisions(Collection<AdaptationDecision> collection){
		this.collection = collection;
	}

	@XmlElement (name="decision")
	public Collection<AdaptationDecision> getCollection() {
		return collection;
	}
}

//@XmlRootElement (name="collection")
//public class CollectionOfDecisions<T>{
//	/**
//	 * 
//	 */
//	private Collection<T> collection = new ArrayList<>();
//	
//	public CollectionOfDecisions(){
//		
//	}
//	
//	public CollectionOfDecisions(Collection<T> collection){
//		this.collection = collection;
//	}
//
//	@XmlAnyElement
//	public Collection<T> getCollection() {
//		return collection;
//	}
//
//}
