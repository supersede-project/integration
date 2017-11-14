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
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;

public interface IFeedbackOrchestrator {
	//Applications
	List<Application> listAllApplications() throws Exception;

	Application getApplication(long idApplication) throws Exception;

	Application createApplication(Application app) throws Exception;

	// public Application updateApplication(Application app) throws Exception;
	
	// Configurations
	List<Configuration> listAllConfigurations() throws Exception;

	Configuration getConfiguration(long idConfiguration) throws Exception;

	List<Configuration> listConfigurationsInApplication(long idApplication) throws Exception;
	
	Configuration updateConfigurationInApplication(Configuration configuration, long idApplication) throws Exception;
	
	Configuration createConfigurationInApplication(Configuration configuration, long idApplication) throws Exception;
	
	List<Configuration> listConfigurationsInApplicationForUserGroup(long idApplication, long idUserGroup) throws Exception;
	
	List<Configuration> listConfigurationsInApplicationForUser(long idApplication, long idUser) throws Exception;
	
	Configuration createConfigurationInApplicationForUserGroup(Configuration configuration, long idApplication, long idUserGroup) throws Exception;

	// General Configurations
//	public List<GeneralConfiguration> listAllGeneralConfigurations() throws Exception;

	GeneralConfiguration getGeneralConfiguration(long idGeneralConfiguration) throws Exception;

	GeneralConfiguration getGeneralConfigurationInApplication(long idApplication) throws Exception;
	
	GeneralConfiguration getGeneralConfigurationInConfiguration(long idConfiguration) throws Exception;

	GeneralConfiguration updateGeneralConfigurationInApplication(GeneralConfiguration generalConfiguration, long idApplication)
			throws Exception;
	
	//Mechanisms
	List<Mechanism> listAllMechanisms() throws Exception;

	Mechanism getMechanism(long idMechanism) throws Exception;

	List<Mechanism> listAllMechanismsInConfiguration(long idConfiguration) throws Exception;

	Mechanism createMechanismInConfigurationInApplication(
			Mechanism Mechanism, long idConfiguration, long idApplication) throws Exception;

	Mechanism updateMechanismInConfigurationInApplication(
			Mechanism Mechanism, long idConfiguration, long idApplication) throws Exception;

	//Parameters
	List<Parameter> listAllParameters() throws Exception;

	Parameter getParameter(long idParameter) throws Exception;

	List<Parameter> listAllParametersInMechanism(long idMechanism) throws Exception;

	List<Parameter> listAllParametersInGeneralConfiguration(long idGeneralConfiguration) throws Exception;

	Parameter createParameterInGeneralConfigurationInApplication(
			Parameter Parameter, long idGeneralConfiguration, long idApplication) throws Exception;

	Parameter createParameterInMechanismInApplication(
			Parameter Parameter, long idMechanism, long idApplication) throws Exception;

	Parameter updateParameterInApplication(Parameter Parameter, long idApplication) throws Exception;

	//Authentication
	String authenticate(String user, String password) throws Exception;
	
	//Users and Groups
	List<User> listAllUsers() throws Exception;
	
	User updateUser (User user) throws Exception;
	
	List<UserGroup> listAllUserGroups() throws Exception;
	
	UserGroup getUserGroup (long idGroup) throws Exception;
	
	UserGroup createUserGroup(UserGroup group) throws Exception;
}
