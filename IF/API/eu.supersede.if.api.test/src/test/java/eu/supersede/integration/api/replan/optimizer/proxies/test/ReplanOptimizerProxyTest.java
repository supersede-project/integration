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
package eu.supersede.integration.api.replan.optimizer.proxies.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.replan.optimizer.proxies.IReplanOptimizer;
import eu.supersede.integration.api.replan.optimizer.proxies.ReplanOptimizerProxy;
import eu.supersede.integration.api.replan.optimizer.types.NextReleaseProblem;
import eu.supersede.integration.api.replan.optimizer.types.PlanningSolution;
import eu.supersede.integration.api.replan.optimizer.types.Priority;
import eu.supersede.integration.api.replan.optimizer.types.Resource;
import eu.supersede.integration.api.replan.optimizer.types.Skill;
import eu.supersede.integration.api.replan.optimizer.types.Feature;

public class ReplanOptimizerProxyTest {
	private static final Logger log = LoggerFactory.getLogger(ReplanOptimizerProxyTest.class);
	private IReplanOptimizer proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new ReplanOptimizerProxy();
    }

    @Test
    public void testGetProjectById() throws Exception{
    	NextReleaseProblem nrProblem = createNextReleaseProblem();
		PlanningSolution solution = proxy.optimizePlan(nrProblem);
    	Assert.notNull(solution);
    }

	private NextReleaseProblem createNextReleaseProblem() {
		NextReleaseProblem nrProblem = new NextReleaseProblem();
		
		nrProblem.setHoursPerWeek(40.0);
		nrProblem.setNbWeeks(4);
		
		nrProblem.getFeatures().addAll(createFeatures());
		nrProblem.getResources().addAll(createResources());
				
		return nrProblem;
	}
	
	

	private Collection<Feature> createFeatures() {
		List<Feature> features = new ArrayList<>();
		Feature f1 = new Feature();
		f1.setName("1");
		f1.setDuration (10.0);
		
		Priority priority1 = new Priority();
		priority1.setLevel (4);
		priority1.setScore (5);
		f1.setPriority (priority1);
		
		List<Skill> skills = new ArrayList<>();
		Skill s1 = new Skill();
		s1.setName("1");
		skills.add(s1);
		Skill s3 = new Skill();
		s3.setName("3");
		skills.add(s3);
		f1.getRequiredSkills().addAll(skills);
		
		features.add(f1);
		
		Feature f2 = new Feature();
		f2.setName("2");
		f2.setDuration (20.0);
	
		Priority priority2 = new Priority();
		priority2.setLevel (2);
		priority2.setScore (4);
		f2.setPriority (priority2);
		
		f2.getRequiredSkills().addAll(skills);
		
		features.add(f2);
		
		return features;
	}

	private Collection<Resource> createResources() {
		List<Resource> resources = new ArrayList<>();
		
		Skill s1 = new Skill();
		s1.setName("1");
		Skill s2 = new Skill();
		s2.setName("2");
		Skill s3 = new Skill();
		s3.setName("3");
		
		
		Resource r1 = new Resource();
		r1.setName("1");
		List<Skill> skills = new ArrayList<>();
		skills.add(s1);
		skills.add(s2);
		
		r1.getSkills().addAll(skills);
		r1.setAvailability(75.0);
		resources.add(r1);
		
		Resource r2 = new Resource();
		r2.setName("2");
		skills = new ArrayList<>();
		skills.add(s2);
		skills.add(s3);
		
		r2.getSkills().addAll(skills);
		r2.setAvailability(55.0);
		resources.add(r2);
		
		Resource r3 = new Resource();
		r3.setName("3");
		skills = new ArrayList<>();
		skills.add(s1);
		skills.add(s3);
		
		r3.getSkills().addAll(skills);
		r3.setAvailability(90.0);
		resources.add(r3);
		
		return resources;
	}			
    
}
