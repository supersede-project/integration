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

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.orchestrator.types.Configuration;
import eu.supersede.integration.api.feedback.orchestrator.types.ConfigurationType;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackMechanism;
import eu.supersede.integration.api.feedback.orchestrator.types.FeedbackParameter;
import eu.supersede.integration.api.feedback.orchestrator.types.GeneralConfiguration;
import eu.supersede.integration.api.feedback.orchestrator.types.User;
import eu.supersede.integration.api.feedback.orchestrator.types.UserGroup;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackOrchestratorProxyTest {
//	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private FeedbackOrchestratorProxy<?, ?> proxy;
	private String token;
	private Integer applicationId = 3;
	private Integer configurationId = 4;
	private Integer generalConfigurationId = 6;
	private Integer mechanismId = 5;
	private Integer parameterId = 40;
	private Integer userId = 1;
	private Integer userGroupId = 1;
	
    @Before
    public void setup() throws Exception {
        proxy = new FeedbackOrchestratorProxy<Object, Object>();
        String user = "api_user";
    	String password = "password";
    	token = proxy.authenticate(user, password);
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
    	Application result = proxy.createApplication(app, token);
    	Assert.notNull(result);
    }
    
    private Application createApplication() {
    	Application app = new Application ();
    	app.setName("Test Website " + new Random().nextInt(1000));
    	app.setState(1);
    	
    	List<FeedbackParameter> fps = new ArrayList<>();
    	fps.add(createFeedbackParameter("reviewActive", Integer.valueOf(1)));
    	fps.add(createFeedbackParameter("mainColor", "#00ff00"));
    	
    	app.setGeneralConfiguration(createGeneralConfiguration(fps));
    	app.getConfigurations().add(createConfiguration (ConfigurationType.PUSH, createGeneralConfiguration(fps), new ArrayList<FeedbackMechanism>()));
		return app;
	}
    
    private GeneralConfiguration createGeneralConfiguration (List<FeedbackParameter> parameters){
    	GeneralConfiguration gc = new GeneralConfiguration();
    	gc.setParameters(parameters);
    	return gc;
    }
    
    private Configuration createConfiguration (ConfigurationType type, GeneralConfiguration gc, List<FeedbackMechanism> mechanisms){
    	Configuration conf = new Configuration ();
    	conf.setType(type);
    	conf.setGeneralConfiguration(gc);
    	conf.getFeedbackMechanisms().addAll(mechanisms);
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
    	FeedbackMechanism mechanism = new FeedbackMechanism();
    	mechanism.setId(5);
    	mechanism.setActive(false);
    	mechanism.setCanBeActivated(true);
    	FeedbackParameter parameter = new FeedbackParameter();
    	parameter.setId(44);
    	parameter.setKey("title");
    	parameter.setValue("Enter your rating here");
    	mechanism.getParameters().add(parameter);
    	configuration.getFeedbackMechanisms().add(mechanism);
    	Configuration result = proxy.updateConfigurationInApplication(configuration, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testCreateConfigurationInApplication() throws Exception{
    	Configuration conf = createConfiguration();
    	
    	Configuration result = proxy.createConfigurationInApplication(conf, applicationId, token);
    	Assert.notNull(result);
    }

	private Configuration createConfiguration() {
		Configuration conf = new Configuration();
    	conf.setType(ConfigurationType.PULL);
    	conf.setActive(true);
    	GeneralConfiguration genConf = new GeneralConfiguration();
    	
    	FeedbackParameter p1 = new FeedbackParameter();
    	p1.setKey("reviewActive");
    	p1.setValue(0);
    	genConf.getParameters().add(p1);
    	
    	FeedbackParameter p2 = new FeedbackParameter();
    	p2.setKey("likelihood");
    	p2.setValue(0.2);
    	genConf.getParameters().add(p2);
    	
    	FeedbackParameter p3 = new FeedbackParameter();
    	p3.setKey("askOnAppStartup");
    	p3.setValue(0);
    	genConf.getParameters().add(p3);
    	
    	conf.setGeneralConfiguration(genConf);
    	
    	FeedbackMechanism mechanism = new FeedbackMechanism();
    	mechanism.setType("RATING_TYPE");
    	mechanism.setActive(true);
    	mechanism.setOrder(1);
    	mechanism.setCanBeActivated(false);
    	
    	FeedbackParameter p4 = new FeedbackParameter();
    	p4.setKey("title");
    	p4.setValue("Rate your user experience");
    	mechanism.getParameters().add(p4);
    	
    	FeedbackParameter p5 = new FeedbackParameter();
    	p5.setKey("ratingIcon");
    	p5.setValue("star");
    	mechanism.getParameters().add(p5);
    	
    	FeedbackParameter p6 = new FeedbackParameter();
    	p6.setKey("maxRating");
    	p6.setValue(5);
    	mechanism.getParameters().add(p6);
    	
    	FeedbackParameter p7 = new FeedbackParameter();
    	p7.setKey("defaultRating");
    	p7.setValue(2);
    	p7.setEditableByUser(false);
    	p7.setDefaultValue(0);
    	mechanism.getParameters().add(p7);
    	
    	conf.getFeedbackMechanisms().add(mechanism);
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
    	
    	Configuration result = proxy.createConfigurationInApplicationForUserGroup(conf, applicationId, userGroupId, token);
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
		GeneralConfiguration result = proxy.updateGeneralConfigurationInApplication(generalConfiguration, applicationId, token);
    	Assert.notNull(result);
    }
    
    private GeneralConfiguration updateGeneralConfiguration (){
    	GeneralConfiguration gc = new GeneralConfiguration();
    	gc.setId(4);
    	
    	List<FeedbackParameter> parameters = new ArrayList<>();
    	
    	FeedbackParameter p1 = new FeedbackParameter();
    	p1.setId(62);
    	p1.setKey("reviewActive");
    	p1.setValue(new Integer (1));
    	
    	parameters.add(p1);
    	
    	gc.setParameters(parameters);
    	return gc;
    }
    
    @Test
    public void testListAllFeedbackMechanisms() throws Exception{
    	List<FeedbackMechanism> result = proxy.listAllFeedbackMechanisms();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackMechanism() throws Exception{
    	FeedbackMechanism result = proxy.getFeedbackMechanism(mechanismId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllFeedbackMechanismsInConfiguration() throws Exception{
    	List<FeedbackMechanism> result = proxy.listAllFeedbackMechanismsInConfiguration(configurationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testCreateFeedbackMechanismInConfigurationInApplication() throws Exception{
    	FeedbackMechanism fm = createFeedbackMechanism();
    	FeedbackMechanism result = proxy.createFeedbackMechanismInConfigurationInApplication(fm, configurationId, applicationId, token);
    	Assert.notNull(result);
    }
    
    private FeedbackMechanism createFeedbackMechanism(){
    	FeedbackMechanism fm = new FeedbackMechanism();
    	fm.setType("AUDIO_TYPE");
    	fm.setActive(true);
    	fm.setOrder(2);
    	fm.setCanBeActivated(false);
    	List<FeedbackParameter> parameters = new ArrayList<>();
    	
    	FeedbackParameter p1 = new FeedbackParameter();
    	p1.setKey("maxTime");
    	p1.setValue(new Double (10.0));
    	p1.setDefaultValue(new Double (30.0));
    	p1.setEditableByUser(false);
    	p1.setLanguage("en");
    	parameters.add(p1);
    	
    	FeedbackParameter p2 = new FeedbackParameter();
    	p2.setKey("maxSizeMb");
    	p2.setValue(new Double (20.0));
    	p2.setDefaultValue(new Double (30.0));
    	p2.setEditableByUser(false);
    	p2.setLanguage("en");
    	parameters.add(p2);
    	
    	fm.setParameters(parameters);
    	
    	return fm;
    }
    
    @Test
    public void testUpdateFeedbackMechanismInConfigurationInApplication() throws Exception{
    	FeedbackMechanism fm = createFeedbackMechanism();
    	fm.setId(5);
    	fm.setActive(true);
    	fm.getParameters().get(0).setId(43);
    	fm.getParameters().get(0).setValue(Double.valueOf(250.0));
    	fm.getParameters().remove(1);
    	FeedbackMechanism result = proxy.updateFeedbackMechanismInConfigurationInApplication(fm, configurationId, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllFeedbackParameters() throws Exception{
    	List<FeedbackParameter> result = proxy.listAllFeedbackParameters();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackParameter() throws Exception{
    	FeedbackParameter result = proxy.getFeedbackParameter(parameterId);
    	Assert.notNull(result);
    }
    
    @Test
    public void testListAllFeedbackParametersInFeedbackMechanism() throws Exception{
    	List<FeedbackParameter> result = proxy.listAllFeedbackParametersInFeedbackMechanism(mechanismId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testListAllFeedbackParametersInGeneralConfiguration() throws Exception{
    	List<FeedbackParameter> result = proxy.listAllFeedbackParametersInGeneralConfiguration(generalConfigurationId);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testCreateFeedbackParameterForGeneralConfiguration() throws Exception{
    	FeedbackParameter fp = createFeedbackParameter("test", "test");
    	FeedbackParameter result = proxy.createFeedbackParameterInGeneralConfigurationInApplication(fp, generalConfigurationId, applicationId, token);
    	Assert.notNull(result);
    }
    
    private FeedbackParameter createFeedbackParameter(String key, Object value) {
    	FeedbackParameter fp = new FeedbackParameter();
    	fp.setKey(key);
    	fp.setValue(value);
    	return fp;
	}

	@Test
    public void testCreateFeedbackParameterInFeedbackMechanismInApplication() throws Exception{
		FeedbackParameter fp = createFeedbackParameter("test", "test");
    	FeedbackParameter result = proxy.createFeedbackParameterInFeedbackMechanismInApplication(fp, mechanismId, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testUpdateFeedbackParameter() throws Exception{
    	FeedbackParameter fp = createFeedbackParameter("test", "test");
    	fp.setId(40);
    	fp.setValue(Double.valueOf(100.0));
    	FeedbackParameter result = proxy.updateFeedbackParameterInApplication(fp, applicationId, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testAuthenticate() throws Exception{
    	String user = "api_user";
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
    	user.setGroupId(1);
    	User result = proxy.updateUser(user, token);
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
    	UserGroup result = proxy.createUserGroup(group, token);
    	Assert.notNull(result);
    }
}
