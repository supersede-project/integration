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
import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.TriggerType;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackOrchestratorProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static FeedbackOrchestratorProxy<?, ?> proxy;
	private static long applicationId = 8;
	private static long configurationId = 9;
	private static long generalConfigurationId = 8;
	private static long mechanismId = 5;
	private static long parameterId = 47;
	private static long userId = 1;
	private static long userGroupId = 1;
	
    @BeforeClass
    public static void setup() throws Exception {
    	String user = "superadmin";
     	String password = "password";
        proxy = new FeedbackOrchestratorProxy<Object, Object>(user, password);
        
        Application app = createApplication();
    	Application result = proxy.createApplication(app);
    	applicationId = result.getId();
    	generalConfigurationId = result.getGeneralConfiguration().getId();
    	configurationId = result.getConfigurations().get(0).getId();
    	parameterId = result.getGeneralConfiguration().getParameters().get(0).getId();
    	
    	log.info("Testing FeedbackOrchestratorProxy with these artifacts: (applicationId: " + applicationId + ", generalConfigurationId: " + 
    			generalConfigurationId + ", configurationId: " + configurationId + ", parameterId: " + parameterId + ")");
    }

    @Test
    public void testListAllApplications() throws Exception{
    	List<Application> result = proxy.listAllApplications();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetApplication() throws Exception{
    	Application result = proxy.getApplication(applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateApplication() throws Exception{
    	Application app = createApplication();
    	Application result = proxy.createApplication(app);
    	Assert.notNull(result);
    }
    
    private static Application createApplication() {
    	Application app = new Application ();
    	app.setName("Test Website " + new Random().nextInt(1000));
    	app.setState(1);
    	
    	List<Parameter> fps = new ArrayList<>();
    	fps.add(createParameter("reviewActive", "1"));
    	fps.add(createParameter("mainColor", "#00ff00"));
    	
    	app.setGeneralConfiguration(createGeneralConfiguration(fps));
    	app.setConfigurations(new ArrayList<Configuration>());
    	app.getConfigurations().add(createConfiguration (
    		TriggerType.PUSH, createGeneralConfiguration(fps), new ArrayList<Mechanism>()));
		return app;
	}
    
    private static GeneralConfiguration createGeneralConfiguration (List<Parameter> parameters){
    	GeneralConfiguration gc = new GeneralConfiguration();
    	gc.setParameters(parameters);
    	return gc;
    }
    
    private static Configuration createConfiguration (TriggerType type, GeneralConfiguration gc, List<Mechanism> mechanisms){
    	Configuration conf = new Configuration ();
    	conf.setType(type);
    	conf.setGeneralConfiguration(gc);
    	conf.getMechanisms().addAll(mechanisms);
    	return conf;
    }

	@Test
    public void testListAllConfigurations() throws Exception{
    	List<Configuration> result = proxy.listAllConfigurations();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetConfiguration() throws Exception{
    	Configuration result = proxy.getConfiguration(configurationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListConfigurationsInApplication() throws Exception{
    	List<Configuration> result = proxy.listConfigurationsInApplication(applicationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testUpdateConfigurationInApplication() throws Exception{
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
    	Configuration result = proxy.updateConfigurationInApplication(configuration, applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateConfigurationInApplication() throws Exception{
    	Configuration conf = createConfiguration();
    	
    	Configuration result = proxy.createConfigurationInApplication(conf, applicationId);
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
    public void testListConfigurationsInApplicationForUserGroup() throws Exception{
    	List<Configuration> result = proxy.listConfigurationsInApplicationForUserGroup(applicationId, userGroupId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testListConfigurationsInApplicationForUser() throws Exception{
    	List<Configuration> result = proxy.listConfigurationsInApplicationForUser(applicationId, userId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testCreateConfigurationInApplicationForUserGroup() throws Exception{
    	Configuration conf = createConfiguration();
    	
    	Configuration result = proxy.createConfigurationInApplicationForUserGroup(conf, applicationId, userGroupId);
    	Assert.notNull(result);
    }
    
//    @Test
//    public void testListAllGeneralConfigurations() throws Exception{
//    	List<GeneralConfiguration> result = proxy.listAllGeneralConfigurations();
//    	Assert.notNull(result);
//    	Assert.isTrue(!result.isEmpty());
//    }
    
    @Test
    public void testGetGeneralConfiguration() throws Exception{
    	GeneralConfiguration result = proxy.getGeneralConfiguration(generalConfigurationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetGeneralConfigurationInApplication() throws Exception{
    	GeneralConfiguration result = proxy.getGeneralConfigurationInApplication(applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetGeneralConfigurationInConfiguration() throws Exception{
    	GeneralConfiguration result = proxy.getGeneralConfigurationInConfiguration(configurationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testUpdateGeneralConfigurationInApplication() throws Exception{
    	GeneralConfiguration generalConfiguration = updateGeneralConfiguration();
		GeneralConfiguration result = proxy.updateGeneralConfigurationInApplication(generalConfiguration, applicationId);
    	Assert.notNull(result);
    }
    
    private GeneralConfiguration updateGeneralConfiguration (){
    	GeneralConfiguration gc = new GeneralConfiguration();
    	gc.setId(generalConfigurationId);
    	
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
    public void testListAllMechanisms() throws Exception{
    	List<Mechanism> result = proxy.listAllMechanisms();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetMechanism() throws Exception{
    	Mechanism result = proxy.getMechanism(mechanismId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllFeedbackMechanismsInConfiguration() throws Exception{
    	List<Mechanism> result = proxy.listAllMechanismsInConfiguration(configurationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testCreateFeedbackMechanismInConfigurationInApplication() throws Exception{
    	Mechanism fm = createFeedbackMechanism();
    	Mechanism result = proxy.createMechanismInConfigurationInApplication(fm, configurationId, applicationId);
    	Assert.notNull(result);
    }
    
    private Mechanism createFeedbackMechanism(){
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
    public void testUpdateFeedbackMechanismInConfigurationInApplication() throws Exception{
    	Mechanism fm = createFeedbackMechanism();
    	fm.setId(5);
    	fm.setActive(true);
    	fm.getParameters().get(0).setId(43);
    	fm.getParameters().get(0).setValue("250.0");
    	fm.getParameters().remove(1);
    	Mechanism result = proxy.updateMechanismInConfigurationInApplication(fm, configurationId, applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllParameters() throws Exception{
    	List<Parameter> result = proxy.listAllParameters();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetParameter() throws Exception{
    	Parameter result = proxy.getParameter(parameterId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllParametersInFeedbackMechanism() throws Exception{
    	List<Parameter> result = proxy.listAllParametersInMechanism(mechanismId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testListAllParametersInGeneralConfiguration() throws Exception{
    	List<Parameter> result = proxy.listAllParametersInGeneralConfiguration(generalConfigurationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testCreateParameterForGeneralConfiguration() throws Exception{
    	Parameter fp = createParameter("test", "test");
    	Parameter result = proxy.createParameterInGeneralConfigurationInApplication(fp, generalConfigurationId, applicationId);
    	Assert.notNull(result);
    }
    
    private static Parameter createParameter(String key, String value) {
    	Parameter fp = new Parameter();
    	fp.setKey(key);
    	fp.setValue(value);
    	return fp;
	}

	@Test
    public void testCreateParameterInFeedbackMechanismInApplication() throws Exception{
		Parameter fp = createParameter("test", "test");
    	Parameter result = proxy.createParameterInMechanismInApplication(fp, mechanismId, applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testUpdateParameter() throws Exception{
    	Parameter fp = createParameter("test", "test");
    	fp.setId(40);
    	fp.setValue("100.0");
    	Parameter result = proxy.updateParameterInApplication(fp, applicationId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testAuthenticate() throws Exception{
    	String user = "admin";
    	String password = "password";
    	String token = proxy.authenticate(user, password);
    	Assert.notNull(token);
    }
    
    @Test
    public void testListAllUsers() throws Exception{
    	List<User> result = proxy.listAllUsers();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testLUpdateUser() throws Exception{
    	User user = new User();
    	user.setId(1);
    	User result = proxy.updateUser(user);
    	Assert.notNull(result);
    }

    @Test
    public void testListAllUserGroups() throws Exception{
    	List<UserGroup> result = proxy.listAllUserGroups();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetUserGroup() throws Exception{
    	UserGroup result = proxy.getUserGroup(userGroupId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateUserGroup() throws Exception{
    	UserGroup group = new UserGroup();
    	group.setName("Supersede Test Group");
    	User u1 = new User();
    	u1.setName("u_test1");
    	group.getUsers().add (u1);
    	UserGroup result = proxy.createUserGroup(group);
    	Assert.notNull(result);
    }
}
