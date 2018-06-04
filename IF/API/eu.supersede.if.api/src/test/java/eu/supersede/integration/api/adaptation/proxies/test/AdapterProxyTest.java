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
package eu.supersede.integration.api.adaptation.proxies.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.proxies.AdapterProxy;
import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.FeatureConfiguration;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class AdapterProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static AdapterProxy<?, ?> proxy;
	private static AdaptationDashboardProxy <Object, Object> adaptationProxy;
	private static ModelRepositoryProxy<?, ?> modelRepositoryProxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new AdapterProxy<Object, Object>();
		adaptationProxy = new AdaptationDashboardProxy<Object, Object>("adaptation", "adaptation", "atos");
		modelRepositoryProxy = new ModelRepositoryProxy<Object, Object>();
	}

	@Test
	public void testEnactAdaptationDecisionActions() throws Exception {
		ModelSystem system = ModelSystem.Atos_HSK;
		
		//Upload new enacted FC
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		
//		//Create adaptation in dashboard
		Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
		adaptation = adaptationProxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		List<String> adaptationDecisionActionIds = new ArrayList<>();
		adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
		adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
		Boolean result = proxy.enactAdaptationDecisionActions(system, adaptationDecisionActionIds, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Test
	public void testEnactSelectedAdaptationDecisionsInFCGivenByString() throws Exception {
		ModelSystem system = ModelSystem.Atos_HSK;
		
		//Upload new enacted FC
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		
//		//Create adaptation in dashboard
		Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
		adaptation = adaptationProxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 

		
		List<String> adaptationDecisionActionIds = new ArrayList<>();
		adaptationDecisionActionIds.add("highloadconfigurationinvm2_a");
		adaptationDecisionActionIds.add("lowloadconfigurationinvm2_a");
		Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
		Boolean result = proxy.enactAdaptationDecisionActionsInFCasString(system, adaptationDecisionActionIds, featureConfigurationAsString, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Test
	public void testEnactFCGivenByString() throws Exception {
		ModelSystem system = ModelSystem.Atos_HSK;
		
		//Upload new enacted FC
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		
//		//Create adaptation in dashboard
		Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
		adaptation = adaptationProxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 

		
		Path fcPath = Paths.get("./src/test/resources/files/SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		String featureConfigurationAsString = new String(Files.readAllBytes(fcPath));
		Boolean result = proxy.enactAdaptationFCasString(system, featureConfigurationAsString, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Test
	public void testEnactAdaptationDecisionActionsForFC() throws Exception {
		//Upload new enacted FC
		String featureConfigurationId = uploadLatestComputedFC("SmartPlatformFC_HSK_SingleVM_HighLoad.yafc");
		
//		//Create adaptation in dashboard
		Adaptation adaptation = createAdaptation(featureConfigurationId, "SmartPlatformFC_HSK_SingleVM_HighLoad");
		adaptation = adaptationProxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
	
		
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Atos_HSK, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Ignore
	@Test
	public void testEnactSiemensBuildingFC() throws Exception {
		String featureConfigurationId = "4233";
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Siemens_Buildings, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Ignore
	@Test
	public void testEnactSiemensGetMinMaxFC() throws Exception {
		String featureConfigurationId = "4189";
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Siemens_GetMinMaxDates, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Ignore
	@Test
	public void testEnactSiemensTypesFC() throws Exception {
		String featureConfigurationId = "4187";
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.Siemens_Types, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Ignore
	@Test
	public void testEnactMonitoringEnablingFC() throws Exception {
		String featureConfigurationId = "4932";
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.AtosMonitoringEnabling, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	@Ignore
	@Test
	public void testEnactMonitoringTimeSlotFC() throws Exception {
		String featureConfigurationId = "4934";
		Boolean result = proxy.enactAdaptationDecisionActionsForFC(ModelSystem.AtosMonitoringTimeSlot, featureConfigurationId);
		Assert.isTrue(result);
	}
	
	private String uploadLatestComputedFC(String fcName) throws IOException, Exception {
		String userdir = System.getProperty("user.dir");
		
		ModelMetadata metadata = createFeatureConfigurationModelMetadata(fcName);
		IModel[] result = modelRepositoryProxy.createModelInstances(ModelType.FeatureConfiguration, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		FeatureConfiguration am = (FeatureConfiguration) result[0];
		
		return am.getId();
	}
	
	private ModelMetadata createFeatureConfigurationModelMetadata(String fcName) throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("DM Optimizer");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createFeatureConfigurationMetadataInstances(fcName);
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}

	private List<IModel> createFeatureConfigurationMetadataInstances(String fcName) throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		FeatureConfiguration am = new FeatureConfiguration();
		modelInstances.add(am);
		
		am.setName(fcName);
		am.setAuthorId("DM Optimizer");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.FeatureConfiguration.getExtension());
		am.setSystemId(ModelSystem.Atos_HSK);
		am.setStatus(Status.Computed.toString());
		am.setRelativePath("features/configurations");
		am.setDependencies(new ArrayList<TypedModelId>());
		am.setModelContent(getFeatureConfigurationContent(fcName));
		
		return modelInstances;
	}

	private String getFeatureConfigurationContent(String fcName) throws IOException {
		File f = new File("");
		List<String> lines = Files.readAllLines(
			Paths.get(f.getAbsolutePath() + 
				"/src/test/resources/files/" + fcName), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		return content;
	}
	
	private Adaptation createAdaptation(String fc_id, String name) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setModel_system(ModelSystem.Atos);
		adaptation.setName(name);
		adaptation.setRank(1.0);
		adaptation.getActions().add(createActionA());
		adaptation.getActions().add(createActionB());
		return adaptation;
	}
	
	private Action createActionA() {
		Action action = new Action ();
		action.setAction_id("highloadconfigurationinvm2_a");
		action.setDescription("High load configuration for HSK service");
		action.setName("VM2_A_HighConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
	private Action createActionB() {
		Action action = new Action ();
		action.setAction_id("lowloadconfigurationinvm2_a");
		action.setDescription("Low load configuration for HSK service");
		action.setName("VM2_A_LowConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
	private <S extends IModel> String getLastComputedFeatureConfigurationForSystem(ModelSystem system) throws Exception {
		@SuppressWarnings("unchecked")
		List<S> metadata = (List<S>) modelRepositoryProxy.getModelInstances(ModelType.FeatureConfiguration, system, Status.Computed);
		Collections.sort (metadata); //Sorted by modification date, or creating date or id, inverse order
		
		IModel iModel = metadata.get(0);
		if (iModel.getValue("id") == null){
			return null;
		}
		return (String)iModel.getValue("id");
	}
	
}
