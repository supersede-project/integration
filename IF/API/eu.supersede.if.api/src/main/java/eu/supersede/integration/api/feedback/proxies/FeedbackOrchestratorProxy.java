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

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.proxy.IFServiceProxy;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackOrchestratorProxy <T,S> extends IFServiceProxy<T,S> implements IFeedbackOrchestrator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT = 
			IntegrationProperty.getProperty("feedback.orchestrator.endpoint");
	private String token;
	
	public FeedbackOrchestratorProxy (String user, String password) throws Exception{
    	this.token = authenticate(user, password);
	}

	@Override
	public List<Application> listAllApplications() throws Exception{
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
		log.debug("Sending message listAllApplications to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Application[].class, uri, HttpStatus.OK);
	}
	
	
	@Override
	public Application getApplication(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication);
		log.debug("Sending message getApplication with idApplication: " + idApplication 
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK);
	}

	@Override
	public Application createApplication(Application app) throws Exception {
		Assert.notNull(app, "Provide a valid application");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications");
		log.debug("Sending message createApplication with app: " + app
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(app, uri, HttpStatus.CREATED, token);
	}

	@Override
	public List<Configuration> listAllConfigurations() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations");
		log.debug("Sending message listAllConfigurations to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public Configuration getConfiguration(long idConfiguration) throws Exception {
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + idConfiguration);
		log.debug("Sending message getConfiguration with idConfiguration: " + idConfiguration 
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Configuration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Configuration> listConfigurationsInApplication(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/configurations");
		log.debug("Sending message listConfigurationsInApplication with idApplication: " + idApplication 
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK, token);
	}
	

	@Override
	public Configuration updateConfigurationInApplication(Configuration configuration, long idApplication) throws Exception {
		Assert.notNull(configuration, "Provide a valid configuration");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/configurations");
		log.debug("Sending message updateConfigurationInApplication with configuration: " + configuration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(configuration, uri, HttpStatus.OK, token);
	}


	@Override
	public Configuration createConfigurationInApplication(Configuration configuration, long idApplication) throws Exception {
		Assert.notNull(configuration, "Provide a valid configuration");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/configurations");
		log.debug("Sending message createConfigurationInApplication with configuration: " + configuration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(configuration, uri, HttpStatus.CREATED, token);
	}
	

	@Override
	public List<Configuration> listConfigurationsInApplicationForUserGroup(long idApplication, long idUserGroup)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUserGroup, "Provide a valid user group id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/user_groups/" + idUserGroup + "/configurations");
		log.debug("Sending message listConfigurationsInApplicationForUserGroup with idApplication: " + idApplication
				+ " with idUserGroup: " + idUserGroup
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK, token);
	}


	@Override
	public List<Configuration> listConfigurationsInApplicationForUser(long idApplication, long idUser)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUser, "Provide a valid user id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/users/" + idUser + "/configurations");
		log.debug("Sending message listConfigurationsInApplicationForUser with idApplication: " + idApplication
				+ " with idUser: " + idUser
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK, token);
	}


	@Override
	public Configuration createConfigurationInApplicationForUserGroup(Configuration configuration,
			long idApplication, long idUserGroup) throws Exception {
		Assert.notNull(configuration, "Provide a valid configuration");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUserGroup, "Provide a valid user group id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/user_groups/" + idUserGroup + "/configurations");
		log.debug("Sending message createConfigurationInApplicationForUserGroup with configuration: " + configuration
				+ " with idApplication: " + idApplication
				+ " with idUserGroup: " + idUserGroup
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(configuration, uri, HttpStatus.CREATED, token);
	}


//	@Override
//	public List<GeneralConfiguration> listAllGeneralConfigurations() throws Exception {
//		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations");
//		return getJSONObjectsListForType(GeneralConfiguration[].class, uri, HttpStatus.OK);
//	}

	@Override
	public GeneralConfiguration getGeneralConfiguration(long idGeneralConfiguration) throws Exception {
		Assert.notNull(idGeneralConfiguration, "Provide a valid general configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + idGeneralConfiguration);
		log.debug("Sending message getGeneralConfiguration with idGeneralConfiguration: " + idGeneralConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationInApplication(long idGeneralConfiguration) throws Exception {
		Assert.notNull(idGeneralConfiguration, "Provide a valid general configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idGeneralConfiguration + "/general_configuration");
		log.debug("Sending message getGeneralConfigurationInApplication with idGeneralConfiguration: " + idGeneralConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public GeneralConfiguration getGeneralConfigurationInConfiguration(long idConfiguration) throws Exception {
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + idConfiguration + "/general_configuration");
		log.debug("Sending message getGeneralConfigurationInConfiguration with idConfiguration: " + idConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);

		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration updateGeneralConfigurationInApplication(GeneralConfiguration generalConfiguration, long idApplication)
			throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid general configuration");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/general_configurations");
		log.debug("Sending message updateGeneralConfigurationInApplication with generalConfiguration: " + generalConfiguration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(generalConfiguration, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Mechanism> listAllMechanisms() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms");
		log.debug("Sending message listAllMechanisms to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Mechanism[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism getMechanism(long idMechanism) throws Exception {
		Assert.notNull(idMechanism, "Provide a valid feedback mechanism id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + idMechanism);
		log.debug("Sending message getMechanism with idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Mechanism.class, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Mechanism> listAllMechanismsInConfiguration(long idConfiguration) throws Exception {
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/configurations/" + idConfiguration + "/mechanisms");
		log.debug("Sending message listAllMechanismsInConfiguration with idConfiguration: " + idConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Mechanism[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism createMechanismInConfigurationInApplication(
			Mechanism Mechanism, long idConfiguration, long idApplication) throws Exception {
		Assert.notNull(Mechanism, "Provide a valid feedback mechanism");
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/configurations/" + idConfiguration + "/mechanisms");
		log.debug("Sending message createMechanismInConfigurationInApplication with idConfiguration: " + idConfiguration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(Mechanism, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Mechanism updateMechanismInConfigurationInApplication(
			Mechanism Mechanism, long idConfiguration, long idApplication) throws Exception {
		Assert.notNull(Mechanism, "Provide a valid feedback mechanism");
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/configurations/" + idConfiguration + "/mechanisms");
		log.debug("Sending message updateMechanismInConfigurationInApplication with idConfiguration: " + idConfiguration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(Mechanism, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> listAllParameters() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters");
		log.debug("Sending message listAllParameters to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Parameter[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Parameter getParameter(long idParameter) throws Exception {
		Assert.notNull(idParameter, "Provide a valid feedback parameter id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/parameters/" + idParameter);
		log.debug("Sending message getParameter with feedback parameter id: " + idParameter
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Parameter.class, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> listAllParametersInMechanism(long idMechanism) throws Exception {
		Assert.notNull(idMechanism, "Provide a valid feedback mechanism id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/mechanisms/" + idMechanism + "/parameters");
		log.debug("Sending message listAllParametersInMechanism with idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Parameter[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public List<Parameter> listAllParametersInGeneralConfiguration(long idConfiguration) throws Exception {
		Assert.notNull(idConfiguration, "Provide a valid configuration id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/general_configurations/" + idConfiguration + "/parameters");
		log.debug("Sending message listAllParametersInGeneralConfiguration with idConfiguration: " + idConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Parameter[].class, uri, HttpStatus.OK, token);
	}
	
	@Override
	public Parameter createParameterInGeneralConfigurationInApplication(
			Parameter Parameter, long idGeneralConfiguration, long idApplication) throws Exception {
		Assert.notNull(Parameter, "Provide a valid feedback parameter");
		Assert.notNull(idGeneralConfiguration, "Provide a valid general configuration id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/general_configurations/" + idGeneralConfiguration + "/parameters");
		log.debug("Sending message createParameterInGeneralConfigurationInApplication with Parameter: " + Parameter
				+ " with idGeneralConfiguration: " + idGeneralConfiguration
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(Parameter, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Parameter createParameterInMechanismInApplication(
			Parameter Parameter, long idMechanism, long idApplication) throws Exception {
		Assert.notNull(Parameter, "Provide a valid feedback parameter");
		Assert.notNull(idMechanism, "Provide a valid feedback mechanism id");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/mechanisms/" + idMechanism + "/parameters");
		log.debug("Sending message createParameterInMechanismInApplication with Parameter: " + Parameter
				+ " with idMechanism: " + idMechanism
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(Parameter, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Parameter updateParameterInApplication(Parameter Parameter, long idApplication) throws Exception {
		Assert.notNull(Parameter, "Provide a valid feedback parameter");
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/applications/" + idApplication + "/parameters");
		log.debug("Sending message updateParameterInApplication with Parameter: " + Parameter
				+ " with idApplication: " + idApplication
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(Parameter, uri, HttpStatus.OK, token);
	}
	
	@Override
	public String authenticate (String user, String password) throws Exception{
		Assert.hasText(user, "Provide a valid user");
		Assert.hasText(user, "Provide a valid password");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "authenticate");
		JSONObject accountJson = new JSONObject();
		accountJson.put("name", user);
		accountJson.put("password", password);
		log.debug("Sending message authenticate with user: " + user
				+ " with password: " + (password != null? "not null":"null")
				+ " with password: " + (password != null && !password.isEmpty()? "not empty":"empty")
				+ " to FeedbackOrchestrator at uri " + uri);
		return postJSONObjectAndReturnValueForJsonLabel(accountJson.toString(), uri, HttpStatus.OK, "token");
	}

	@Override
	public List<User> listAllUsers() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/users");
		log.debug("Sending message listAllUsers to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(User[].class, uri, HttpStatus.OK, token);
	}


	@Override
	public User updateUser(User user) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/users");
		log.debug("Sending message updateUser with user: " + user
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(user, uri, HttpStatus.OK, token);
	}


	@Override
	public List<UserGroup> listAllUserGroups() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/user_groups");
		log.debug("Sending message listAllUserGroups to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(UserGroup[].class, uri, HttpStatus.OK, token);
	}


	@Override
	public UserGroup getUserGroup(long idGroup) throws Exception {
		Assert.notNull(idGroup, "Provide a valid user group id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/user_groups/" + idGroup);
		log.debug("Sending message getUserGroup with idGroup: " + idGroup
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(UserGroup.class, uri, HttpStatus.OK, token);
	}


	@Override
	public UserGroup createUserGroup(UserGroup group) throws Exception {
		Assert.notNull(group, "Provide a valid user group");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "en/user_groups");
		log.debug("Sending message createUserGroup with group: " + group
				+ " with token: " + token
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(group, uri, HttpStatus.CREATED, token);
	}
}
