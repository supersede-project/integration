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
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackOrchestratorProxyTest {
//	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private FeedbackOrchestratorProxy proxy;
	private String token;
	
    @Before
    public void setup() throws Exception {
        proxy = new FeedbackOrchestratorProxy();
        String user = "api_user";
    	String password = "password";
    	token = proxy.authenticate(user, password);
    }

    @Test
    public void testGetAllApplications() throws Exception{
    	List<Application> result = proxy.getAllApplications();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetApplicationById() throws Exception{
    	Application result = proxy.getApplicationById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testInsertApplication() throws Exception{
    	Application app = createApplication();
    	Application result = proxy.insertApplication(app, token);
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
    public void testGetAllConfigurations() throws Exception{
    	List<Configuration> result = proxy.getAllConfigurations();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetConfigurationById() throws Exception{
    	Configuration result = proxy.getConfigurationById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetAllConfigurationsForApplicationById() throws Exception{
    	List<Configuration> result = proxy.getAllConfigurationsForApplicationById(1);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetAllGeneralConfigurations() throws Exception{
    	List<GeneralConfiguration> result = proxy.getAllGeneralConfigurations();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetGeneralConfigurationById() throws Exception{
    	GeneralConfiguration result = proxy.getGeneralConfigurationById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetGeneralConfigurationForApplicationById() throws Exception{
    	GeneralConfiguration result = proxy.getGeneralConfigurationForApplicationById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testUpdateGeneralConfigurations() throws Exception{
    	GeneralConfiguration generalConfiguration = updateGeneralConfiguration();
		GeneralConfiguration result = proxy.updateGeneralConfigurations(generalConfiguration, token);
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
    public void testGetAllFeedbackMechanisms() throws Exception{
    	List<FeedbackMechanism> result = proxy.getAllFeedbackMechanisms();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackMechanismById() throws Exception{
    	FeedbackMechanism result = proxy.getFeedbackMechanismById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetAllFeedbackMechanismsForConfigurationById() throws Exception{
    	List<FeedbackMechanism> result = proxy.getAllFeedbackMechanismsForConfigurationById(1);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testInsertFeedbackMechanismForConfigurationById() throws Exception{
    	FeedbackMechanism fm = createFeedbackMechanism();
    	FeedbackMechanism result = proxy.insertFeedbackMechanismForConfigurationById(1, fm, token);
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
    public void testUpdateFeedbackMechanismForConfigurationById() throws Exception{
    	FeedbackMechanism fm = createFeedbackMechanism();
    	fm.setId(10);
    	fm.setActive(true);
    	fm.getParameters().get(0).setId(76);
    	fm.getParameters().get(0).setValue(Double.valueOf(20.0));
    	fm.getParameters().remove(1);
    	FeedbackMechanism result = proxy.updateFeedbackMechanismForConfigurationById(1, fm, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetAllFeedbackParameters() throws Exception{
    	List<FeedbackParameter> result = proxy.getAllFeedbackParameters();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetFeedbackParameterById() throws Exception{
    	FeedbackParameter result = proxy.getFeedbackParameterById(1);
    	Assert.notNull(result);
    }
    
    @Test
    public void testGetAllFeedbackParametersForFeedbackMechanismById() throws Exception{
    	List<FeedbackParameter> result = proxy.getAllFeedbackParametersForFeedbackMechanismById(1);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testGetAllFeedbackParametersForGeneralConfigurationById() throws Exception{
    	List<FeedbackParameter> result = proxy.getAllFeedbackParametersForGeneralConfigurationById(1);
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
    
    @Test
    public void testInsertFeedbackParameterForGeneralConfigurationById() throws Exception{
    	FeedbackParameter fp = createFeedbackParameter("test", "test");
    	FeedbackParameter result = proxy.insertFeedbackParameterForGeneralConfigurationById(1, fp, token);
    	Assert.notNull(result);
    }
    
    private FeedbackParameter createFeedbackParameter(String key, Object value) {
    	FeedbackParameter fp = new FeedbackParameter();
    	fp.setKey(key);
    	fp.setValue(value);
    	return fp;
	}

	@Test
    public void testInsertFeedbackParameterForFeedbackMechanismById() throws Exception{
		FeedbackParameter fp = createFeedbackParameter("test", "test");
    	FeedbackParameter result = proxy.insertFeedbackParameterForFeedbackMechanismById(1, fp, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testUpdateFeedbackParameter() throws Exception{
    	FeedbackParameter fp = createFeedbackParameter("test", "test");
    	fp.setId(10);
    	fp.setValue(Double.valueOf(100.0));
    	FeedbackParameter result = proxy.updateFeedbackParameter(fp, token);
    	Assert.notNull(result);
    }
    
    @Test
    public void testAuthenticate() throws Exception{
    	String user = "api_user";
    	String password = "password";
    	String token = proxy.authenticate(user, password);
    	Assert.notNull(token);
    }

}
