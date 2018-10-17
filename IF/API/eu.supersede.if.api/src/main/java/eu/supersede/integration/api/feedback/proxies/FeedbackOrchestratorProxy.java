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
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import com.google.common.net.UrlEscapers;

import eu.supersede.integration.api.feedback.orchestrator.types.ApiUser;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Message;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.properties.IntegrationProperty;

public class FeedbackOrchestratorProxy<T, S> extends IFServiceProxy<T, S> implements IFeedbackOrchestrator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT = IntegrationProperty
			.getProperty("feedback.orchestrator.endpoint");
	private String token;
	private String language = "en";

	public FeedbackOrchestratorProxy(String user, String password) throws Exception {
		this(user, password, "en");
	}

	public FeedbackOrchestratorProxy(String user, String password, String language) throws Exception {
		this.token = authenticate(user, password);
		if (token == null)
			throw new IFException("Failed authentication in Orchestrator");
		this.language = language;
	}

	// Authentication

	@Override
	public String authenticate(String user, String password) throws Exception {
		Assert.hasText(user, "Provide a valid user");
		Assert.hasText(user, "Provide a valid password");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + "authenticate");
		JSONObject accountJson = new JSONObject();
		accountJson.put("name", user);
		accountJson.put("password", password);
		log.debug("Sending message authenticate with user: " + user + " with password: "
				+ (password != null ? "not null" : "null") + " with password: "
				+ (password != null && !password.isEmpty() ? "not empty" : "empty") + " to FeedbackOrchestrator at uri "
				+ uri);
		return postJSONObjectAndReturnValueForJsonLabel(accountJson.toString(), uri, HttpStatus.OK, "token");
	}

	// API User
	@Override
	public List<ApiUser> getApiUsers() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users");
		log.debug("Sending message getApiUsers to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(ApiUser[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public ApiUser createApiUser(ApiUser user) throws Exception {
		Assert.notNull(user, "Provide a valid ApiUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users");
		log.debug("Sending message createApiUser with ApiUser: " + user + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(user, uri, HttpStatus.CREATED, token);
	}

	@Override
	public ApiUser updateApiUser(ApiUser user) throws Exception {
		Assert.notNull(user, "Provide a valid ApiUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/");
		log.debug("Sending message updateApiUser with ApiUser: " + user + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(user, uri, HttpStatus.OK, token);
	}

	@Override
	public ApiUser getApiUser(long idUser) throws Exception {
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser);
		log.debug("Sending message getApiUser with idUser: " + idUser + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(ApiUser.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteApiUser(long idUser) throws Exception {
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser);
		log.debug("Sending message deleteAPIUser with idUser: " + idUser + " to FeedbackRepository at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	// API User Permissions
	@Override
	public List<ApiUserPermission> getApiUserPermissions(long idUser) throws Exception {
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(
				SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser + "/api_user_permissions");
		log.debug("Sending message getApiUserPermissions to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(ApiUserPermission[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public ApiUserPermission createApiUserPermission(ApiUserPermission permission, long idUser) throws Exception {
		Assert.notNull(permission, "Provide a valid ApiUserPermission");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(
				SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser + "/api_user_permissions");
		log.debug("Sending message createApiUserPermission with ApiUserPermission: " + permission + " and idUser: "
				+ idUser + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(permission, uri, HttpStatus.CREATED, token);
	}

	@Override
	public ApiUserPermission updateApiUserPermission(ApiUserPermission permission, long idUser) throws Exception {
		Assert.notNull(permission, "Provide a valid ApiUserPermission");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(
				SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser + "/api_user_permissions");
		log.debug("Sending message updateApiUser with ApiUserPermission: " + permission + " and idUser: " + idUser
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(permission, uri, HttpStatus.OK, token);
	}

	@Override
	public ApiUserPermission getApiUserPermission(long idUser, long idUserPermission) throws Exception {
		Assert.notNull(idUser, "Provide a valid idUser");
		Assert.notNull(idUserPermission, "Provide a valid idUserPermission");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser
				+ "/api_user_permissions/" + idUserPermission);
		log.debug("Sending message getApiUserPermission with idUser: " + idUser + " and idUserPermission: "
				+ idUserPermission + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(ApiUserPermission.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteApiUserPermission(long idUser, long idUserPermission) throws Exception {
		Assert.notNull(idUser, "Provide a valid idUser");
		Assert.notNull(idUserPermission, "Provide a valid idUserPermission");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/api_users/" + idUser
				+ "/api_user_permissions/" + idUserPermission);
		log.debug("Sending message deleteApiUserPermission with idUser: " + idUser + " and idUserPermission: "
				+ idUserPermission + " to FeedbackRepository at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	// Applications

	@Override
	public List<Application> getApplications() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications");
		log.debug("Sending message getApplications to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Application[].class, uri, HttpStatus.OK);
	}

	@Override
	public Application createApplication(Application app) throws Exception {
		Assert.notNull(app, "Provide a valid application");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications");
		log.debug("Sending message createApplication with app: " + app + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(app, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Application updateApplication(Application app) throws Exception {
		Assert.notNull(app, "Provide a valid application");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications");
		log.debug("Sending message updateApplication with app: " + app + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(app, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Application importApplication(Application app) throws Exception {
		Assert.notNull(app, "Provide a valid application");
		Assert.notNull(token, "Provide a valid token");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/import");
		log.debug("Sending message importApplication with app: " + app + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(app, uri, HttpStatus.CREATED, token);
	}

	@Override
	public HttpStatus deleteApplication(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication);
		log.debug("Sending message deleteApplication with idApplication: " + idApplication
				+ " to FeedbackRepository at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	@Override
	public Application getApplicationWithConfiguration(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(
				SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/full");
		log.debug("Sending message getApplicationWithConfiguration with idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK, token);
	}

	@Override
	public Application getApplicationWithConfigurationForAllLanguages(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/full/polylang");
		log.debug("Sending message getApplicationWithConfiguration with idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK, token);
	}

	@Override
	public Application getApplicationForUser(long idApplication, long idUser) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/user_identification/" + idUser);
		log.debug("Sending message getApplicationForUser with idApplication: " + idApplication + " with idUser: "
				+ idUser + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK, token);
	}

	@Override
	public Application getApplicationForUserGroup(long idApplication, long idGroup) throws Exception {
		Assert.notNull(idApplication, "Provide a valid application id");
		Assert.notNull(idGroup, "Provide a valid idGroup");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/user_group/" + idGroup);
		log.debug("Sending message getApplicationForUserGroup with idApplication: " + idApplication + " with idGroup: "
				+ idGroup + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Application.class, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Application> searchApplicationsByName(String name) throws Exception {
		Assert.notNull(name, "Provide a valid name");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/search/name/" 
				+ UrlEscapers.urlFragmentEscaper().escape(name));
		log.debug("Sending message searchApplicationsByName to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Application[].class, uri, HttpStatus.OK, token);
	}

	// General Configurations
	@Override
	public GeneralConfiguration getGeneralConfigurationOfApplication(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration");
		log.debug("Sending message getGeneralConfigurationsOfApplication to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration createGeneralConfigurationOfApplication(GeneralConfiguration generalConfiguration,
			long idApplication) throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid generalConfiguration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration");
		log.debug("Sending message createApiUserPermission with GeneralConfiguration: " + generalConfiguration
				+ " and idApplication: " + idApplication + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(generalConfiguration, uri, HttpStatus.CREATED, token);
	}

	@Override
	public GeneralConfiguration updateGeneralConfigurationOfApplication(GeneralConfiguration generalConfiguration,
			long idApplication) throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid generalConfiguration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration");
		log.debug("Sending message updateGeneralConfigurationOfApplication with GeneralConfiguration: "
				+ generalConfiguration + " and idApplication: " + idApplication + " to FeedbackOrchestrator at uri "
				+ uri);
		return updateAndReturnJSONObject(generalConfiguration, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationOfApplication(long idApplication, long idGeneralConfiguration)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idGeneralConfiguration, "Provide a valid idGeneralConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration/" + idGeneralConfiguration);
		log.debug("Sending message getGeneralConfigurationOfApplication with idApplication: " + idApplication
				+ " and idGeneralConfiguration: " + idGeneralConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteGeneralConfigurationOfApplication(long idApplication, long idGeneralConfiguration)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idGeneralConfiguration, "Provide a valid idGeneralConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration/" + idGeneralConfiguration);
		log.debug("Sending message deleteGeneralConfigurationOfApplication with idApplication: " + idApplication
				+ " and idGeneralConfiguration: " + idGeneralConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	// Configurations

	@Override
	public List<Configuration> getConfigurations(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations");
		log.debug("Sending message getConfigurations to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Configuration[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Configuration createConfiguration(Configuration configuration, long idApplication) throws Exception {
		Assert.notNull(configuration, "Provide a valid configuration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations");
		log.debug("Sending message createConfiguration with configuration: " + configuration + " and idApplication: "
				+ idApplication + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(configuration, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Configuration updateConfiguration(Configuration configuration, long idApplication) throws Exception {
		Assert.notNull(configuration, "Provide a valid configuration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations");
		log.debug("Sending message updateConfiguration with configuration: " + configuration + " and idApplication: "
				+ idApplication + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(configuration, uri, HttpStatus.OK, token);
	}

	@Override
	public Configuration getConfiguration(long idApplication, long idConfiguration) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration);
		log.debug("Sending message getConfiguration with idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Configuration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteConfiguration(long idApplication, long idConfiguration) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration);
		log.debug("Sending message deleteConfiguration with idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
	
	@Override
	public Configuration createPullConfigurationForUserInfo(Message message, long idApplication, long idUser) throws Exception {
		Assert.notNull(message, "Provide a valid message");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idUser + "/info");
		log.debug("Sending message createPullConfigurationForUserInfo with idApplication: " + idApplication + " and idUser: "
				+ idUser + " to FeedbackOrchestrator at uri " + uri);
		return insertJSONObjectAndReturnAnotherType (message, Configuration.class, uri, HttpStatus.CREATED, token);
	}


	// General Configuration of Configurations
	@Override
	public GeneralConfiguration getGeneralConfigurationOfConfiguration(long idApplication, long idConfiguration)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/general_configuration");
		log.debug("Sending message getGeneralConfigurationsOfConfigurations to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration createGeneralConfigurationOfConfiguration(GeneralConfiguration generalConfiguration,
			long idApplication, long idConfiguration) throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid generalConfiguration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/general_configuration");
		log.debug("Sending message createGeneralConfigurationsOfConfiguration with configuration: "
				+ generalConfiguration + " and idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(generalConfiguration, uri, HttpStatus.CREATED, token);
	}

	@Override
	public GeneralConfiguration updateGeneralConfigurationOfConfiguration(GeneralConfiguration generalConfiguration,
			long idApplication, long idConfiguration) throws Exception {
		Assert.notNull(generalConfiguration, "Provide a valid generalConfiguration");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/general_configuration");
		log.debug("Sending message updateGeneralConfigurationsOfConfiguration with generalConfiguration: "
				+ generalConfiguration + " and idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(generalConfiguration, uri, HttpStatus.OK, token);
	}

	@Override
	public GeneralConfiguration getGeneralConfigurationOfConfiguration(long idApplication, long idConfiguration,
			long idGeneralConfiguration) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		Assert.notNull(idGeneralConfiguration, "Provide a valid idGeneralConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/general_configuration/" + idGeneralConfiguration);
		log.debug("Sending message getGeneralConfigurationsOfConfiguration with idApplication: " + idApplication
				+ " and idConfiguration: " + idConfiguration + " and idGeneralConfiguration: " + idGeneralConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(GeneralConfiguration.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteGeneralConfigurationsOfConfiguration(long idApplication, long idConfiguration,
			long idGeneralConfiguration) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/general_configuration/" + idGeneralConfiguration);
		log.debug("Sending message deleteGeneralConfigurationsOfConfiguration with idApplication: " + idApplication
				+ " and idConfiguration: " + idConfiguration + " and idGeneralConfiguration: " + idGeneralConfiguration
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
	
	
	// Configuration Mechanisms
	
	@Override
	public List<Mechanism> getMechanismsOfConfiguration(long idApplication, long idConfiguration)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/configuration_mechanisms");
		log.debug("Sending message getMechanismsOfConfiguration to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Mechanism[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism createMechanismOfConfiguration(Mechanism mechanism, long idApplication, long idConfiguration)
			throws Exception {
		Assert.notNull(mechanism, "Provide a valid Mechanism");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/configuration_mechanisms");
		log.debug("Sending message createMechanismOfConfiguration with mechanism: "
				+ mechanism + " and idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(mechanism, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Mechanism updateMechanismOfConfiguration(Mechanism mechanism, long idApplication, long idConfiguration)
			throws Exception {
		Assert.notNull(mechanism, "Provide a valid Mechanism");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/configuration_mechanisms");
		log.debug("Sending message updateMechanismOfConfiguration with mechanism: "
				+ mechanism + " and idApplication: " + idApplication + " and idConfiguration: "
				+ idConfiguration + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(mechanism, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism getMechanismOfConfiguration(long idApplication, long idConfiguration, long idMechanism)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/configuration_mechanisms/" + idMechanism);
		log.debug("Sending message getMechanismOfConfiguration with idApplication: " + idApplication
				+ " and idConfiguration: " + idConfiguration + " and idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Mechanism.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteMechanismOfConfiguration(long idApplication, long idConfiguration, long idMechanism)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idConfiguration, "Provide a valid idConfiguration");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/configurations/" + idConfiguration + "/configuration_mechanisms/" + idMechanism);
		log.debug("Sending message deleteMechanismOfConfiguration with idApplication: " + idApplication
				+ " and idConfiguration: " + idConfiguration + " and idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	// Application Mechanisms
	
	@Override
	public List<Mechanism> getMechanismsOfApplication(long idApplication)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms");
		log.debug("Sending message getMechanismsOfApplication to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Mechanism[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism createMechanismOfApplication(Mechanism mechanism, long idApplication)
			throws Exception {
		Assert.notNull(mechanism, "Provide a valid Mechanism");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms");
		log.debug("Sending message createMechanismOfApplication with mechanism: "
				+ mechanism + " and idApplication: " + idApplication  + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(mechanism, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Mechanism updateMechanismOfApplication(Mechanism mechanism, long idApplication)
			throws Exception {
		Assert.notNull(mechanism, "Provide a valid Mechanism");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms");
		log.debug("Sending message updateMechanismOfApplication with mechanism: "
				+ mechanism + " and idApplication: " + idApplication + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(mechanism, uri, HttpStatus.OK, token);
	}

	@Override
	public Mechanism getMechanismOfApplication(long idApplication, long idMechanism)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms/" + idMechanism);
		log.debug("Sending message getMechanismOfApplication with idApplication: " + idApplication
				+ " and idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Mechanism.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteMechanismOfApplication(long idApplication, long idMechanism)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms/" + idMechanism);
		log.debug("Sending message deleteMechanismOfApplication with idApplication: " + idApplication
				+ " and idMechanism: " + idMechanism
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
	
	// Mechanism parameter
	
	@Override
	public List<Parameter> getMechanismParameters(long idApplication, long idMechanism)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms/" + idMechanism + "/parameters");
		log.debug("Sending message getMechanismParameter to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Parameter[].class, uri, HttpStatus.OK, token);
	}
	

	// Parameters
	
	@Override
	public List<Parameter> getParameters() throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/parameters");
		log.debug("Sending message getParameters to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(Parameter[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public Parameter createParameter(Parameter parameter) throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/parameters");
		log.debug("Sending message createParameter with parameter: "
				+ parameter + " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(parameter, uri, HttpStatus.CREATED, token);
	}

	@Override
	public Parameter updateParameter(Parameter parameter) throws Exception {
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/parameters");
		log.debug("Sending message updateParameter with parameter: "
				+ parameter + " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(parameter, uri, HttpStatus.OK, token);
	}

	@Override
	public Parameter getParameter(long idParameter) throws Exception {
		Assert.notNull(idParameter, "Provide a valid idParameter");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/parameters/" + idParameter);
		log.debug("Sending message getMechanismOfApplication with idParameter: " + idParameter
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(Parameter.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteParameter(long idParameter) throws Exception {
		Assert.notNull(idParameter, "Provide a valid idParameter");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/parameters/" + idParameter);
		log.debug("Sending message deleteParameter with idParameter: " + idParameter
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
	

	// Users	
	
	@Override
	public List<User> getUsers(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/users");
		log.debug("Sending message getUsers to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(User[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus createUser(User user, long idApplication) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/users");
		log.debug("Sending message createUser with user: " + user 
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertJSONObject(user, uri, HttpStatus.CREATED, token);
	}
	
	@Override
	public User updateUser(User user, long idApplication) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/users");
		log.debug("Sending message updateUser with user: " + user
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(user, uri, HttpStatus.OK, token);
	}

	@Override
	public User getUser(long idApplication, long idUser) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idUser, "Provide a valid idUser");

		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" 
				+ idApplication + "/users/" + idUser);
		log.debug("Sending message getUser with idUser: " + idUser
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(User.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteUser(long idApplication, long idUser) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idParameter");
		Assert.notNull(idUser, "Provide a valid idUser");

		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" 
				+ idApplication + "/users/" + idUser);
		log.debug("Sending message deleteUser with idUser: " + idUser
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	@Override
	public User updateUser(User user, long idApplication, long idUser) throws Exception {
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idUser, "Provide a valid idUser");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/users/" + idUser);
		log.debug("Sending message updateUser with user: " + user
				+ " and idApplication: " + idApplication
				+ " and idUser: " + idUser 
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(user, uri, HttpStatus.OK, token);
	}
	

	// Groups
	
	@Override
	public List<UserGroup> getUserGroups(long idApplication) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/user_groups");
		log.debug("Sending message getUserGroups to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectsListForType(UserGroup[].class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus createUserGroup(UserGroup userGroup, long idApplication) throws Exception {
		Assert.notNull(userGroup, "Provide a valid userGroup");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/user_groups");
		log.debug("Sending message createUserGroup with userGroup: " + userGroup 
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertJSONObject(userGroup, uri, HttpStatus.CREATED, token);
	}
	
	@Override
	public UserGroup updateUserGroup(UserGroup userGroup, long idApplication) throws Exception {
		Assert.notNull(userGroup, "Provide a valid userGroup");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/user_groups");
		log.debug("Sending message updateUserGroup with userGroup: " + userGroup
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(userGroup, uri, HttpStatus.OK, token);
	}

	@Override
	public UserGroup getUserGroup(long idApplication, long idUserGroup) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idUserGroup, "Provide a valid idUserGroup");

		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" 
				+ idApplication + "/user_groups/" + idUserGroup);
		log.debug("Sending message getUserGroup with idUserGroup: " + idUserGroup
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return getJSONObjectForType(UserGroup.class, uri, HttpStatus.OK, token);
	}

	@Override
	public HttpStatus deleteUserGroup(long idApplication, long idUserGroup) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idParameter");
		Assert.notNull(idUserGroup, "Provide a valid idUserGroup");

		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" 
				+ idApplication + "/user_groups/" + idUserGroup);
		log.debug("Sending message deleteUserGroup with idUserGroup: " + idUserGroup
				+ " and idApplication: " + idApplication
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}

	@Override
	public UserGroup updateUserGroup(UserGroup userGroup, long idApplication, long idUserGroup) throws Exception {
		Assert.notNull(userGroup, "Provide a valid userGroup");
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idUserGroup, "Provide a valid idUserGroup");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication + "/user_groups/" + idUserGroup);
		log.debug("Sending message updateUserGroup with idUserGroup: " + idUserGroup
				+ " and idApplication: " + idApplication
				+ " and userGroup: " + userGroup 
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(userGroup, uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> switchOrderOfParametersOfMechanism(long idApplication, long idMechanism, long idParam1,
			long idParam2) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		Assert.notNull(idParam1, "Provide a valid idParam1");
		Assert.notNull(idParam2, "Provide a valid idParam2");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms/" + idMechanism + "/parameters/" + idParam1 + "/switchOrder/" + idParam2);
		log.debug("Sending message switchOrderOfParametersOfMechanism with idApplication: " + idApplication 
				+ " and idMechanism: " + idMechanism 
				+ " and idParam1: " + idParam1 
				+ " and idParam2: " + idParam2 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> reorderParameterOfMechanism(long idApplication, long idMechanism, long idParam, long order)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idMechanism, "Provide a valid idMechanism");
		Assert.notNull(idParam, "Provide a valid idParam");
		Assert.notNull(order, "Provide a valid order");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/mechanisms/" + idMechanism + "/parameters/" + idParam + "/reorder/" + order);
		log.debug("Sending message reorderParameterOfMechanism with idApplication: " + idApplication 
				+ " and idMechanism: " + idMechanism 
				+ " and idParam1: " + idParam 
				+ " and order: " + order 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> switchOrderOfParametersOfGeneralConfiguration(long idApplication,
			long idGeneralConfiguration, long idParam1, long idParam2) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idGeneralConfiguration, "Provide a valid idGeneralConfiguration");
		Assert.notNull(idParam1, "Provide a valid idParam1");
		Assert.notNull(idParam2, "Provide a valid idParam2");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration/" + idGeneralConfiguration + "/parameters/" + idParam1 + "/switchOrder/" + idParam2);
		log.debug("Sending message switchOrderOfParametersOfGeneralConfiguration with idApplication: " + idApplication 
				+ " and idMechanism: " + idGeneralConfiguration 
				+ " and idParam1: " + idParam1 
				+ " and idParam2: " + idParam2 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);	}

	@Override
	public List<Parameter> reorderParameterOfGeneralConfiguration(long idApplication, long idGeneralConfiguration,
			long idParam, long order) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idGeneralConfiguration, "Provide a valid idGeneralConfiguration");
		Assert.notNull(idParam, "Provide a valid idParam");
		Assert.notNull(order, "Provide a valid order");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/general_configuration/" + idGeneralConfiguration + "/parameters/" + idParam + "/reorder/" + order);
		log.debug("Sending message reorderParameterOfGeneralConfiguration with idApplication: " + idApplication 
				+ " and idGeneralConfiguration: " + idGeneralConfiguration 
				+ " and idParam1: " + idParam 
				+ " and order: " + order 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> switchOrderOfParametersOfParameter(long idApplication, long idParam, long idParam1,
			long idParam2) throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idParam, "Provide a valid idParam");
		Assert.notNull(idParam1, "Provide a valid idParam1");
		Assert.notNull(idParam2, "Provide a valid idParam2");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/parameter/" + idParam + "/parameters/" + idParam1 + "/switchOrder/" + idParam2);
		log.debug("Sending message switchOrderOfParametersOfParameter with idApplication: " + idApplication 
				+ " and idMechanism: " + idParam 
				+ " and idParam1: " + idParam1 
				+ " and idParam2: " + idParam2 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);
	}

	@Override
	public List<Parameter> reorderParameterOfParameter(long idApplication, long idParam1, long idParam2, long order)
			throws Exception {
		Assert.notNull(idApplication, "Provide a valid idApplication");
		Assert.notNull(idParam1, "Provide a valid idParam1");
		Assert.notNull(idParam2, "Provide a valid idPara2m");
		Assert.notNull(order, "Provide a valid order");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/applications/" + idApplication
				+ "/parameter/" + idParam1 + "/parameters/" + idParam2 + "/reorder/" + order);
		log.debug("Sending message reorderParameterOfParameter with idApplication: " + idApplication 
				+ " and idParam1: " + idParam1 
				+ " and idParam2: " + idParam2
				+ " and order: " + order 
				+ " to FeedbackOrchestrator at uri " + uri);
		
		return updateJSONObjectAndReturnAnotherType("{}", new ArrayList<Parameter>().getClass(), uri, HttpStatus.OK, token);
	}
	
	//Mechanism parameter
	@Override
	public Parameter createParameterInMechanism (Parameter parameter, Integer mechanismId) throws Exception{
		Assert.notNull(parameter, "Provide a valid parameter");
		Assert.notNull(mechanismId, "Provide a valid mechanismId");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/mechanisms/" + mechanismId + "/parameters");
		log.debug("Sending message createParameterInMechanism with parameter: " + parameter 
				+ " and mechanismId: " + mechanismId
				+ " to FeedbackOrchestrator at uri " + uri);
		return insertandReturnJSONObject(parameter, uri, HttpStatus.CREATED, token);
	}
	
	@Override
	public Parameter updateParameterInMechanism (Parameter parameter, Integer mechanismId) throws Exception{
		Assert.notNull(parameter, "Provide a valid parameter");
		Assert.notNull(parameter.getId(), "Provide a valid parameter with not null id");
		Assert.notNull(mechanismId, "Provide a valid mechanismId");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/mechanisms/" + mechanismId + "/parameters/" + parameter.getId());
		log.debug("Sending message updateParameterInMechanism with parameter: " + parameter 
				+ " and mechanismId: " + mechanismId
				+ " to FeedbackOrchestrator at uri " + uri);
		return updateAndReturnJSONObject(parameter, uri, HttpStatus.OK, token);
	}
	
	@Override
	public HttpStatus deleteParameterInMechanism (long parameterId, Integer mechanismId) throws Exception{
		Assert.notNull(parameterId, "Provide a valid idParameter");
		URI uri = new URI(SUPERSEDE_FEEDBACK_ORCHESTRATOR_ENDPOINT + language + "/mechanisms/" + mechanismId + "/parameters/" + parameterId);
		log.debug("Sending message deleteParameterInMechanism with parameterId: " + parameterId
				+ " to FeedbackOrchestrator at uri " + uri);
		return deleteUriResource(uri, HttpStatus.OK, token);
	}
	
}
