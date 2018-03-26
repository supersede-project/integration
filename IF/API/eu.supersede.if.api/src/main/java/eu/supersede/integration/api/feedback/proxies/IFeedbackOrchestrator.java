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

import eu.supersede.integration.api.feedback.orchestrator.types.ApiUser;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Message;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;

public interface IFeedbackOrchestrator {
	//Authentication
	String authenticate(String user, String password) throws Exception;
	
	//API User
	List<ApiUser> getApiUsers () throws Exception;
	ApiUser createApiUser (ApiUser user) throws Exception;
	ApiUser updateApiUser (ApiUser user) throws Exception;
	ApiUser getApiUser (long idUser) throws Exception;
	void deleteApiUser (long idUser) throws Exception;
	
	//API User Permissions
	List<ApiUserPermission> getApiUserPermissions (long idUser) throws Exception;
	ApiUserPermission createApiUserPermission (ApiUserPermission permission, long idUser) throws Exception;
	ApiUserPermission updateApiUserPermission (ApiUserPermission permission, long idUser) throws Exception;
	ApiUserPermission getApiUserPermission (long idUser, long idUserPermission) throws Exception;
	void deleteApiUserPermission (long idUser, long idUserPermission) throws Exception;
	
	//Applications
	List<Application> getApplications() throws Exception;
	Application createApplication(Application app) throws Exception;
	Application updateApplication(Application app) throws Exception;
	Application importApplication(Application app) throws Exception;
	void deleteApplication(long idApplication) throws Exception;
	Application getApplicationWithConfiguration(long idApplication) throws Exception;
	Application getApplicationWithConfigurationForAllLanguages(long idApplication) throws Exception;
	Application getApplicationForUser(long idApplication, long idUser) throws Exception;
	Application getApplicationForUserGroup(long idApplication, long idGroup) throws Exception;
	List<Application> searchApplicationsByName(String name) throws Exception;
	
	// General Configurations
	GeneralConfiguration getGeneralConfigurationOfApplication(long idApplication) throws Exception;
	GeneralConfiguration createGeneralConfigurationOfApplication(GeneralConfiguration generalConfiguration, long idApplication) throws Exception;
	GeneralConfiguration updateGeneralConfigurationOfApplication(GeneralConfiguration generalConfiguration, long idApplication)
			throws Exception;
	GeneralConfiguration getGeneralConfigurationOfApplication(long idApplication, long idGeneralConfiguration) throws Exception;
	void deleteGeneralConfigurationOfApplication(long idApplication, long idGeneralConfiguration) throws Exception;
	
	// Configurations
	List<Configuration> getConfigurations(long idApplication) throws Exception;
	Configuration createConfiguration(Configuration configuration, long idApplication) throws Exception;
	Configuration updateConfiguration(Configuration configuration, long idApplication) throws Exception;
	Configuration getConfiguration(long idApplication, long idConfiguration) throws Exception;
	void deleteConfiguration(long idApplication, long idConfiguration) throws Exception;
	
	Configuration createPullConfigurationForUserInfo(Message message, long idApplication, long idUser) throws Exception;
	
	// General Configuration of Configurations
	GeneralConfiguration getGeneralConfigurationOfConfiguration(long idApplication, long idConfiguration) throws Exception;
	GeneralConfiguration createGeneralConfigurationOfConfiguration(GeneralConfiguration generalConfiguration, long idApplication, long idConfiguration) throws Exception;
	GeneralConfiguration updateGeneralConfigurationOfConfiguration(GeneralConfiguration generalConfiguration, long idApplication, long idConfiguration) throws Exception;
	GeneralConfiguration getGeneralConfigurationOfConfiguration(long idApplication, long idConfiguration, long idGeneralConfiguration) throws Exception;
	void deleteGeneralConfigurationsOfConfiguration(long idApplication, long idConfiguration, long idGeneralConfiguration) throws Exception;
	
	//Configuration Mechanisms
	List<Mechanism> getMechanismsOfConfiguration(long idApplication, long idConfiguration) throws Exception;
	Mechanism createMechanismOfConfiguration(Mechanism Mechanism, long idApplication, long idConfiguration) throws Exception;
	Mechanism updateMechanismOfConfiguration(Mechanism Mechanism, long idApplication, long idConfiguration) throws Exception;
	Mechanism getMechanismOfConfiguration(long idApplication, long idConfiguration, long idMechanism) throws Exception;
	void deleteMechanismOfConfiguration(long idApplication, long idConfiguration, long idMechanism) throws Exception;
	
	//Application Mechanisms
	List<Mechanism> getMechanismsOfApplication(long idApplication) throws Exception;
	Mechanism createMechanismOfApplication(Mechanism Mechanism, long idApplication) throws Exception;
	Mechanism updateMechanismOfApplication(Mechanism Mechanism, long idApplication) throws Exception;
	Mechanism getMechanismOfApplication(long idApplication, long idMechanism) throws Exception;
	void deleteMechanismOfApplication(long idApplication, long idMechanism) throws Exception;
	
	//Mechanism parameter
	List<Parameter> getMechanismParameters(long idApplication, long idMechanism) throws Exception;

	//Parameters
	List<Parameter> getParameters() throws Exception;
	Parameter createParameter(Parameter Parameter) throws Exception;
	Parameter updateParameter(Parameter Parameter) throws Exception;
	Parameter getParameter(long idParameter) throws Exception;
	void deleteParameter(long idParameter) throws Exception;
	
	//Users
	List<User> getUsers(long idApplication) throws Exception;
	void createUser (User user, long idApplication) throws Exception;
	User updateUser (User user, long idApplication) throws Exception;
	User getUser (long idApplication, long idUser) throws Exception;
	void deleteUser (long idApplication, long idUser) throws Exception;
	User updateUser (User user, long idApplication, long idUser) throws Exception;
	
	//Groups
	List<UserGroup> getUserGroups(long idApplication) throws Exception;
	void createUserGroup (UserGroup userGroup, long idApplication) throws Exception;
	UserGroup updateUserGroup (UserGroup userGroup, long idApplication) throws Exception;
	UserGroup getUserGroup (long idApplication, long idUserGroup) throws Exception;
	void deleteUserGroup (long idApplication, long idUserGroup) throws Exception;
	UserGroup updateUserGroup (UserGroup user, long idApplication, long idUserGroup) throws Exception;
	
	//Parameter reordering/switching
	List<Parameter> switchOrderOfParametersOfMechanism(long idApplication, long idMechanism, long idParam1, long idParam2) throws Exception;
	List<Parameter> reorderParameterOfMechanism(long idApplication, long idMechanism, long idParam, long order) throws Exception;
	List<Parameter> switchOrderOfParametersOfGeneralConfiguration(long idApplication, long idGeneralConfiguration, long idParam1, long idParam2) throws Exception;
	List<Parameter> reorderParameterOfGeneralConfiguration(long idApplication, long idGeneralConfiguration, long idParam, long order) throws Exception;
	List<Parameter> switchOrderOfParametersOfParameter(long idApplication, long idParam, long idParam1, long idParam2) throws Exception;
	List<Parameter> reorderParameterOfParameter(long idApplication, long idParam1, long idParam2, long order) throws Exception;

}
