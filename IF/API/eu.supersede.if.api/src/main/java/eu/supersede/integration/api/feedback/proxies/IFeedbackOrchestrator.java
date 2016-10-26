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

import java.util.List;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackMechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackParameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;

public interface IFeedbackOrchestrator {
	public List<Application> getAllApplications() throws Exception;

	public Application getApplicationById(Integer id) throws Exception;

	public Application insertApplication(Application app, String token) throws Exception;

	// public Application updateApplication(Application app) throws Exception;
	public List<Configuration> getAllConfigurations() throws Exception;

	public Configuration getConfigurationById(Integer id) throws Exception;

	public List<Configuration> getAllConfigurationsForApplicationById(Integer id) throws Exception;

	public List<GeneralConfiguration> getAllGeneralConfigurations() throws Exception;

	public GeneralConfiguration getGeneralConfigurationById(Integer id) throws Exception;

	public GeneralConfiguration getGeneralConfigurationForApplicationById(Integer id) throws Exception;

	public GeneralConfiguration updateGeneralConfigurations(GeneralConfiguration generalConfiguration, String token)
			throws Exception;

	public List<FeedbackMechanism> getAllFeedbackMechanisms() throws Exception;

	public FeedbackMechanism getFeedbackMechanismById(Integer id) throws Exception;

	public List<FeedbackMechanism> getAllFeedbackMechanismsForConfigurationById(Integer id) throws Exception;

	public FeedbackMechanism insertFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception;

	public FeedbackMechanism updateFeedbackMechanismForConfigurationById(Integer id,
			FeedbackMechanism feedbackMechanism, String token) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParameters() throws Exception;

	public FeedbackParameter getFeedbackParameterById(Integer id) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParametersForFeedbackMechanismById(Integer id) throws Exception;

	public List<FeedbackParameter> getAllFeedbackParametersForGeneralConfigurationById(Integer id) throws Exception;

	public FeedbackParameter insertFeedbackParameterForGeneralConfigurationById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception;

	public FeedbackParameter insertFeedbackParameterForFeedbackMechanismById(Integer id,
			FeedbackParameter feedbackParameter, String token) throws Exception;

	public FeedbackParameter updateFeedbackParameter(FeedbackParameter feedbackParameter, String token)
			throws Exception;

	String authenticate(String user, String password) throws Exception;
}
