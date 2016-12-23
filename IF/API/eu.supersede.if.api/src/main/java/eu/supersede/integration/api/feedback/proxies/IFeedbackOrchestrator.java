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
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;

public interface IFeedbackOrchestrator {
	//Applications
	List<Application> listAllApplications() throws Exception;

	Application getApplication(Integer idApplication) throws Exception;

	Application createApplication(Application app, String token) throws Exception;

	// public Application updateApplication(Application app) throws Exception;
	
	// Configurations
	List<Configuration> listAllConfigurations() throws Exception;

	Configuration getConfiguration(Integer idConfiguration) throws Exception;

	List<Configuration> listConfigurationsInApplication(Integer idApplication) throws Exception;
	
	Configuration updateConfigurationInApplication(Configuration configuration, Integer idApplication, String token) throws Exception;
	
	Configuration createConfigurationInApplication(Configuration configuration, Integer idApplication, String token) throws Exception;
	
	List<Configuration> listConfigurationsInApplicationForUserGroup(Integer idApplication, Integer idUserGroup) throws Exception;
	
	List<Configuration> listConfigurationsInApplicationForUser(Integer idApplication, Integer idUser) throws Exception;
	
	Configuration createConfigurationInApplicationForUserGroup(Configuration configuration, Integer idApplication, Integer idUserGroup, String token) throws Exception;

	// General Configurations
//	public List<GeneralConfiguration> listAllGeneralConfigurations() throws Exception;

	GeneralConfiguration getGeneralConfiguration(Integer idGeneralConfiguration) throws Exception;

	GeneralConfiguration getGeneralConfigurationInApplication(Integer idApplication) throws Exception;
	
	GeneralConfiguration getGeneralConfigurationInConfiguration(Integer idConfiguration) throws Exception;

	GeneralConfiguration updateGeneralConfigurationInApplication(GeneralConfiguration generalConfiguration, Integer idApplication, String token)
			throws Exception;
	
	//Mechanisms
	List<FeedbackMechanism> listAllFeedbackMechanisms() throws Exception;

	FeedbackMechanism getFeedbackMechanism(Integer idMechanism) throws Exception;

	List<FeedbackMechanism> listAllFeedbackMechanismsInConfiguration(Integer idConfiguration) throws Exception;

	FeedbackMechanism createFeedbackMechanismInConfigurationInApplication(
			FeedbackMechanism feedbackMechanism, Integer idConfiguration, Integer idApplication, String token) throws Exception;

	FeedbackMechanism updateFeedbackMechanismInConfigurationInApplication(
			FeedbackMechanism feedbackMechanism, Integer idConfiguration, Integer idApplication, String token) throws Exception;

	//Parameters
	List<FeedbackParameter> listAllFeedbackParameters() throws Exception;

	FeedbackParameter getFeedbackParameter(Integer idParameter) throws Exception;

	List<FeedbackParameter> listAllFeedbackParametersInFeedbackMechanism(Integer idMechanism) throws Exception;

	List<FeedbackParameter> listAllFeedbackParametersInGeneralConfiguration(Integer idGeneralConfiguration) throws Exception;

	FeedbackParameter createFeedbackParameterInGeneralConfigurationInApplication(
			FeedbackParameter feedbackParameter, Integer idGeneralConfiguration, Integer idApplication, String token) throws Exception;

	FeedbackParameter createFeedbackParameterInFeedbackMechanismInApplication(
			FeedbackParameter feedbackParameter, Integer idMechanism, Integer idApplication, String token) throws Exception;

	FeedbackParameter updateFeedbackParameterInApplication(FeedbackParameter feedbackParameter, Integer idApplication, String token) throws Exception;

	//Authentication
	String authenticate(String user, String password) throws Exception;
	
	//Users and Groups
	List<User> listAllUsers() throws Exception;
	
	User updateUser (User user, String token) throws Exception;
	
	List<UserGroup> listAllUserGroups() throws Exception;
	
	UserGroup getUserGroup (Integer idGroup) throws Exception;
	
	UserGroup createUserGroup(UserGroup group, String token) throws Exception;
}
