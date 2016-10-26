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
package eu.supersede.integration.api.feedback.proxies;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.repository.types.Feedback;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackRepositoryProxy <T,S> extends IFServiceProxy<T,S> implements IFeedbackRepository {
	private final static String SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.repository.endpoint");

	@Override
	public List<Feedback> getAllFeedbacks() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks");
		return getJSONObjectsListForType(Feedback[].class, uri, HttpStatus.OK);
	}

	
	@Override
	public Feedback getFeedbackById(Integer id) throws Exception {
		Assert.notNull(id, "Provide a valid feedback id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks/" + id);
		return getJSONObjectForType(Feedback.class, uri, HttpStatus.OK);
	}
	
	public Feedback insertFeedback(Feedback feedback) throws Exception {
		Assert.notNull(feedback, "Provide a valid feedback");
		URI uri = new URI(SUPERSEDE_FEEDBACK_REPOSITORY_ENDPOINT + "en/feedbacks");
		return insertandReturnJSONObject(feedback, uri, HttpStatus.OK);
	}

}
