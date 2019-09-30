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
package eu.supersede.integration.api.replan.optimizer.proxies;

import java.net.URI;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;
import eu.supersede.integration.properties.IntegrationProperty;


public class ReplanOptimizerProxy <T,S> extends IFServiceProxy<T,S> implements IReplanOptimizer{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_REPLAN_OPTIMIZER_ENDPOINT = 
			IntegrationProperty.getProperty("replan_optimizer.endpoint");
	
	public PlanningSolution optimizePlan (NextReleaseProblem nrProblem) throws Exception{
		URI uri = new URI(SUPERSEDE_REPLAN_OPTIMIZER_ENDPOINT + "replan");		
		log.debug("Sending message optimizePlan with nrProblem: " + nrProblem + " to ReplanOptimizer at uri " + uri);
		return insertJSONObjectAndReturnAnotherType(nrProblem, PlanningSolution.class, uri, new ArrayList<HttpStatus>(){{add(HttpStatus.OK);}});
	}

}
