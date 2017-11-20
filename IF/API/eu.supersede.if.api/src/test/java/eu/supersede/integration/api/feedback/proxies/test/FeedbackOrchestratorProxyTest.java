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
package eu.supersede.integration.api.feedback.proxies.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.ApiUser;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserApiUserRole;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserPermission;
import eu.supersede.integration.api.feedback.orchestrator.types.ApiUserRole;
import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.MechanismType;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.TriggerType;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackOrchestratorProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static FeedbackOrchestratorProxy<?, ?> proxy;
	private static long idApplicationBackup;
	private static long idApplication = 8;
	private static long idConfiguration = 9;
	private static long idGeneralConfiguration = 8;
	private static long idMechanism = 5;
	private static long idParameter = 47;
	private static long idUser = 1;
	private static long idUserGroup = 1;

	@BeforeClass
	public static void setup() throws Exception {
		String user = "superadmin";
		String password = "password";
		proxy = new FeedbackOrchestratorProxy<Object, Object>(user, password);

		Application app = createApplication();
		Application result = proxy.createApplication(app);
		idApplication = result.getId();
		idApplicationBackup = idApplication;
		idGeneralConfiguration = result.getGeneralConfiguration().getId();
		idConfiguration = result.getConfigurations().get(0).getId();
		idParameter = result.getGeneralConfiguration().getParameters().get(0).getId();

		log.info("Testing FeedbackOrchestratorProxy with these artifacts: (applicationId: " + idApplication
				+ ", generalConfigurationId: " + idGeneralConfiguration + ", configurationId: " + idConfiguration
				+ ", parameterId: " + idParameter + ")");
	}
	
	@AfterClass
	public static void dispose() throws Exception {
		proxy.deleteApplication(idApplicationBackup);
		log.info("Disposing created application: " + idApplicationBackup);
	}

	// Authentication

	@Test
	public void testAuthenticate() throws Exception {
		String user = "superadmin";
		String password = "password";
		String token = proxy.authenticate(user, password);
		Assert.notNull(token);
	}

	// API User

	@Test
	public void testGetAPIUsers() throws Exception {
		List<ApiUser> result = proxy.getApiUsers();
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetAPIUser() throws Exception {
		ApiUser result = proxy.getApiUser(idUser);
		Assert.notNull(result);
	}

	@Test
	public void testCreateUpdateDeleteAPIUser() throws Exception {
		// Create
		ApiUser user = createApiUser();
		ApiUser result = proxy.createApiUser(user);
		Assert.notNull(result);
		Assert.isTrue(result.getId() > 0);

		// Update
		result.setUsername(result.getUsername() + "Modified");
		result.setName(result.getName() + "Modified");
		result = proxy.updateApiUser(result);
		Assert.isTrue(result.getUsername().contains("Modified"));

		// Delete
		proxy.deleteApiUser(result.getId());
	}
	
	// API User permission
	
	@Test
	public void testGetAPIUserPermissions() throws Exception {
		List<ApiUserPermission> result = proxy.getApiUserPermissions(idUser);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	@Ignore
	public void testCreateUpdateDeleteAPIUserPermission() throws Exception {
		// Create
		ApiUser user = proxy.getApiUser(idUser);
		ApiUserPermission permission = createApiUserPermission(user);
		ApiUserPermission result = proxy.createApiUserPermission(permission, user.getId());
		Assert.notNull(result);
		Assert.isTrue(result.getId() > 0);

		// Update

		// Delete
	}
	
	//Applications
	
	@Test
	public void testGetApplications() throws Exception {
		List<Application> result = proxy.getApplications();
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetApplicationWithConfiguration() throws Exception {
		Application result = proxy.getApplicationWithConfiguration(idApplication);
		Assert.notNull(result);
	}

	@Test
	public void testGetApplicationWithConfigurationForAllLanguages() throws Exception {
		Application result = proxy.getApplicationWithConfigurationForAllLanguages(idApplication);
		Assert.notNull(result);
	}

	@Test
	public void testGetApplicationForUser() throws Exception {
		Application result = proxy.getApplicationForUser(idApplication, idUser);
		Assert.notNull(result);
	}

	@Test
	public void testGetApplicationForUserGroup() throws Exception {
		Application result = proxy.getApplicationForUserGroup(idApplication, idUserGroup);
		Assert.notNull(result);
	}

	@Test
	public void searchApplicationsByName() throws Exception {
		List<Application> result = proxy.searchApplicationsByName("Test Website 21");
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testCreateUpdateDeleteApplication() throws Exception {
		// Create
		Application app = createApplication();
		Application result = proxy.createApplication(app);
		Assert.notNull(result);
		
		// Update
//		result.setName(result.getName() + "Modified");
//		result = proxy.updateApplication(result);
//		Assert.isTrue(result.getName().contains("Modified"));
		
		// Delete
		log.debug("Removing application: " + result.getId());
		proxy.deleteApplication(result.getId());
	}

	@Test
	public void testImportApplication() throws Exception {
		// Import
		Application app = createApplication();
		Application result = proxy.importApplication(app);
		Assert.notNull(result);
	}
	
	//General Configuration in Application
	
	@Test
	public void testGetGeneralConfigurationOfApplication() throws Exception {
		GeneralConfiguration result = proxy.getGeneralConfigurationOfApplication(idApplication);
		Assert.notNull(result);
	}

	@Test
	public void testGetGeneralConfigurationOfApplicationById() throws Exception {
		GeneralConfiguration result = proxy.getGeneralConfigurationOfApplication(idApplication, idGeneralConfiguration);
		Assert.notNull(result);
	}
	
	@Test
	public void testCreateUpdateDeleteGeneralConfigurationOfApplication() throws Exception {
		//Create
		List<Parameter> parameters = createParameters();
		GeneralConfiguration genConf = createGeneralConfiguration(parameters);
		GeneralConfiguration result = proxy.createGeneralConfigurationOfApplication(genConf, idApplication);
		Assert.notNull(result);
		
		//Update
		result.setName(result.getName()+ "Modified");
		result = proxy.updateGeneralConfigurationOfApplication(result, idApplication);
		Assert.isTrue(result.getName().contains("Modified"));
		
		//Delete
		proxy.deleteGeneralConfigurationOfApplication(idApplication, result.getId());
	}
	
	// Configurations of Applications
	
	@Test
	public void testGetConfigurations() throws Exception {
		List<Configuration> result = proxy.getConfigurations(idApplication);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetConfiguration() throws Exception {
		Configuration result = proxy.getConfiguration(idApplication, idConfiguration);
		Assert.notNull(result);
	}
	
	@Test
	public void testCreateUpdateDeleteConfiguration() throws Exception {
		//Create
		List<Parameter> parameters = createParameters();
		GeneralConfiguration genConf = createGeneralConfiguration(parameters);
		List<Mechanism> mechanisms = createMechanisms(parameters);
		Configuration conf = createConfiguration(TriggerType.PULL, genConf, mechanisms);
		Configuration result = proxy.createConfiguration(conf, idApplication);
		Assert.notNull(result);
		
		//Update
		result.setName(result.getName()+ "Modified");
		result = proxy.updateConfiguration(result, idApplication);
		Assert.isTrue(result.getName().contains("Modified"));
		
		//Delete
		proxy.deleteConfiguration(idApplication, result.getId());
		
	}
	
	//Private methods
	
	private List<Mechanism> createMechanisms(List<Parameter> parameters) {
		List<Mechanism> result = new ArrayList<>();
		Mechanism m = new Mechanism(MechanismType.RATING_TYPE, Calendar.getInstance().getTime(), 
				Calendar.getInstance().getTime(), new ArrayList<>(), parameters);
		m.setActive(true);
		m.setOrder(4);
		
		return result;
	}
	
	private List<Parameter> createParameters() {
		List<Parameter> result = new ArrayList<>();
		
		Parameter p = new Parameter ("test", "test", 
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 
				"en", null, new ArrayList<Parameter>());
		result.add(p);
		
		p = new Parameter ("mainColor", "#00ff0f", 
				Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), 
				"en", null, new ArrayList<Parameter>());
		result.add(p);
		
		return result;
	}

	private ApiUser createApiUser() throws Exception {
		ApiUser user = new ApiUser("test", "test");

		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user.setUsername("test");

		// user.setApiUserPermissions(createListApiUserPermissions(user));
		user.setAuthorities(createAuthorities());

		return user;
	}

	private List<ApiUserRole> createAuthorities() {
		List<ApiUserRole> result = new ArrayList<>();
		result.add(ApiUserRole.ADMIN);
		return result;
	}

	private List<ApiUserPermission> createListApiUserPermissions(ApiUser user) throws Exception {
		List<ApiUserPermission> result = new ArrayList<>();
		result.add(createApiUserPermission(user));
		return result;
	}

	private ApiUserPermission createApiUserPermission(ApiUser user) throws Exception {
		Application application = proxy.getApplicationWithConfiguration(idApplication);
		ApiUserPermission permission = new ApiUserPermission(user, application, true);
		return permission;
	}

	private static Application createApplication() {
		Application app = new Application();
		app.setName("Test Website " + new Random().nextInt(1000));
		app.setState(1);

		List<Parameter> fps = new ArrayList<>();
		fps.add(createParameter("reviewActive", "1"));
		fps.add(createParameter("mainColor", "#00ff00"));

		app.setGeneralConfiguration(createGeneralConfiguration(fps));
		app.setConfigurations(new ArrayList<Configuration>());
		app.getConfigurations().add(
				createConfiguration(TriggerType.PUSH, createGeneralConfiguration(fps), new ArrayList<Mechanism>()));
		return app;
	}

	private static GeneralConfiguration createGeneralConfiguration(List<Parameter> parameters) {
		GeneralConfiguration gc = new GeneralConfiguration();
		gc.setName("GeneralConfiguration generated");
		gc.setCreatedAt (Calendar.getInstance().getTime());
		gc.setParameters(parameters);
		return gc;
	}

	private static Configuration createConfiguration(TriggerType type, GeneralConfiguration gc,
			List<Mechanism> mechanisms) {
		Configuration conf = new Configuration();
		conf.setType(type);
		conf.setGeneralConfiguration(gc);
		conf.getMechanisms().addAll(mechanisms);
		conf.setPullDefault(false);
		conf.setPushDefault(false);
		conf.setName("Configuration generated");
		
		return conf;
	}

	@Test
	public void testGetMechanismParameters() throws Exception {
		idApplication = 8;
		idMechanism = 28;
		List<Parameter> result = proxy.getMechanismParameters(idApplication, idMechanism);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testUpdateConfigurationInApplication() throws Exception {
		Configuration configuration = new Configuration();
		configuration.setId(4);
		Mechanism mechanism = new Mechanism();
		mechanism.setId(5);
		mechanism.setActive(false);
		Parameter parameter = new Parameter();
		parameter.setId(44);
		parameter.setKey("title");
		parameter.setValue("Enter your rating here");
		mechanism.getParameters().add(parameter);
		configuration.getMechanisms().add(mechanism);
		Configuration result = proxy.updateConfiguration(configuration, idApplication);
		Assert.notNull(result);
	}



	private Configuration createConfiguration() {
		Configuration conf = new Configuration();
		conf.setType(TriggerType.PULL);
		GeneralConfiguration genConf = new GeneralConfiguration();
		genConf.setParameters(new ArrayList<Parameter>());

		Parameter p1 = new Parameter();
		p1.setKey("reviewActive");
		p1.setValue("0");
		genConf.getParameters().add(p1);

		Parameter p2 = new Parameter();
		p2.setKey("likelihood");
		p2.setValue("0.2");
		genConf.getParameters().add(p2);

		Parameter p3 = new Parameter();
		p3.setKey("askOnAppStartup");
		p3.setValue("0");
		genConf.getParameters().add(p3);

		conf.setGeneralConfiguration(genConf);

		Mechanism mechanism = new Mechanism();
		mechanism.setActive(true);
		mechanism.setOrder(1);
		mechanism.setParameters(new ArrayList<Parameter>());

		Parameter p4 = new Parameter();
		p4.setKey("title");
		p4.setValue("Rate your user experience");
		mechanism.getParameters().add(p4);

		Parameter p5 = new Parameter();
		p5.setKey("ratingIcon");
		p5.setValue("star");
		mechanism.getParameters().add(p5);

		Parameter p6 = new Parameter();
		p6.setKey("maxRating");
		p6.setValue("5");
		mechanism.getParameters().add(p6);

		Parameter p7 = new Parameter();
		p7.setKey("defaultRating");
		p7.setValue("2");
		mechanism.getParameters().add(p7);

		conf.getMechanisms().add(mechanism);
		return conf;
	}

	@Test
	public void testCreateConfiguration() throws Exception {
		Configuration conf = createConfiguration();

		Configuration result = proxy.createConfiguration(conf, idApplication);
		Assert.notNull(result);
	}

	// @Test
	// public void testListAllGeneralConfigurations() throws Exception{
	// List<GeneralConfiguration> result = proxy.listAllGeneralConfigurations();
	// Assert.notNull(result);
	// Assert.isTrue(!result.isEmpty());
	// }

	

	@Test
	public void testGetGeneralConfigurationsOfConfiguration() throws Exception {
		GeneralConfiguration result = proxy.getGeneralConfigurationOfConfiguration(idApplication, idConfiguration);
		Assert.notNull(result);
	}

	@Test
	public void testGetGeneralConfigurationsOfConfigurationById() throws Exception {
		GeneralConfiguration result = proxy.getGeneralConfigurationOfConfiguration(idApplication, idConfiguration,
				idGeneralConfiguration);
		Assert.notNull(result);
	}

	@Test
	public void testUpdateGeneralConfigurationOfApplication() throws Exception {
		GeneralConfiguration generalConfiguration = updateGeneralConfiguration();
		GeneralConfiguration result = proxy.updateGeneralConfigurationOfApplication(generalConfiguration,
				idApplication);
		Assert.notNull(result);
	}

	private GeneralConfiguration updateGeneralConfiguration() {
		GeneralConfiguration gc = new GeneralConfiguration();
		gc.setId(idGeneralConfiguration);

		List<Parameter> parameters = new ArrayList<>();

		Parameter p1 = new Parameter();
		p1.setId(62);
		p1.setKey("reviewActive");
		p1.setValue("1");

		parameters.add(p1);

		gc.setParameters(parameters);
		return gc;
	}

	@Test
	public void testGetMechanismsOfApplication() throws Exception {
		idApplication = 8;
		List<Mechanism> result = proxy.getMechanismsOfApplication(idApplication);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetMechanismOfApplication() throws Exception {
		idApplication = 8;
		idMechanism = 28;
		Mechanism result = proxy.getMechanismOfApplication(idApplication, idMechanism);
		Assert.notNull(result);
	}

	@Test
	public void testGetMechanismsOfConfiguration() throws Exception {
		idApplication = 8;
		idConfiguration = 9;
		List<Mechanism> result = proxy.getMechanismsOfConfiguration(idApplication, idConfiguration);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetMechanismOfConfiguration() throws Exception {
		idApplication = 8;
		idConfiguration = 9;
		idMechanism = 29;
		Mechanism result = proxy.getMechanismOfConfiguration(idApplication, idConfiguration, idMechanism);
		Assert.notNull(result);
	}

	@Test
	public void testCreateMechanismOfConfiguration() throws Exception {
		Mechanism fm = createFeedbackMechanism();
		Mechanism result = proxy.createMechanismOfConfiguration(fm, idApplication, idConfiguration);
		Assert.notNull(result);
	}

	private Mechanism createFeedbackMechanism() {
		Mechanism fm = new Mechanism();
		fm.setActive(true);
		fm.setOrder(2);
		List<Parameter> parameters = new ArrayList<>();

		Parameter p1 = new Parameter();
		p1.setKey("maxTime");
		p1.setValue("10.0");
		p1.setLanguage("en");
		parameters.add(p1);

		Parameter p2 = new Parameter();
		p2.setKey("maxSizeMb");
		p2.setValue("20.0");
		p2.setLanguage("en");
		parameters.add(p2);

		fm.setParameters(parameters);

		return fm;
	}

	@Test
	public void testUpdateMechanismOfConfiguration() throws Exception {
		Mechanism fm = createFeedbackMechanism();
		fm.setId(5);
		fm.setActive(true);
		fm.getParameters().get(0).setId(43);
		fm.getParameters().get(0).setValue("250.0");
		fm.getParameters().remove(1);
		Mechanism result = proxy.updateMechanismOfConfiguration(fm, idApplication, idConfiguration);
		Assert.notNull(result);
	}

	@Test
	public void testGetParameters() throws Exception {
		List<Parameter> result = proxy.getParameters();
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetParameter() throws Exception {
		Parameter result = proxy.getParameter(idParameter);
		Assert.notNull(result);
	}

	@Test
	public void testGetParametersInFeedbackMechanism() throws Exception {
		List<Parameter> result = proxy.getMechanismParameters(idApplication, idMechanism);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	private static Parameter createParameter(String key, String value) {
		Parameter fp = new Parameter();
		fp.setKey(key);
		fp.setValue(value);
		return fp;
	}

	@Test
	public void testGetUsers() throws Exception {
		List<User> result = proxy.getUsers(idApplication);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setId(1);
		User result = proxy.updateUser(user, idApplication);
		Assert.notNull(result);
	}

	@Test
	public void testGetUserGroups() throws Exception {
		List<UserGroup> result = proxy.getUserGroups(idApplication);
		Assert.notNull(result);
		Assert.isTrue(!result.isEmpty());
	}

	@Test
	public void testGetUserGroup() throws Exception {
		UserGroup result = proxy.getUserGroup(idApplication, idUserGroup);
		Assert.notNull(result);
	}

	@Test
	public void testCreateUserGroup() throws Exception {
		UserGroup group = new UserGroup();
		group.setName("Supersede Test Group");
		User u1 = new User();
		u1.setName("u_test1");
		group.getUsers().add(u1);
		UserGroup result = proxy.createUserGroup(group, idApplication);
		Assert.notNull(result);
	}
}
