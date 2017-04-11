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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.proxies.ModelRepositoryProxy;
import eu.supersede.integration.api.adaptation.types.AdaptabilityModel;
import eu.supersede.integration.api.adaptation.types.BaseModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ITypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.TypedModelId;

public class ModelRepositoryProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private ModelRepositoryProxy<?, ?> proxy;

	@Before
	public void setup() throws Exception {
		proxy = new ModelRepositoryProxy<Object, Object>();
	}
	
	@Test
	public void testCreateGetAndDeleteAdaptationModel() throws Exception {
		//Create model
		ModelMetadata metadata = createAdatabilityModelMetadata();
		IModel[] result = proxy.createModelInstances(ModelType.AdaptabilityModel, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		AdaptabilityModel am = (AdaptabilityModel) result[0];
		
		//Read created model
		am = (AdaptabilityModel) proxy.getModelInstance(ModelType.AdaptabilityModel, am.getId());
		Assert.notNull(am);
		
		//Delete created model
		proxy.deleteModelInstance(ModelType.AdaptabilityModel, am.getId());
	}
	
	@Test
	public void testCreateGetAndDeleteBaseModel() throws Exception {
		//Create model
		ModelMetadata metadata = createBaseModelMetadata();
		IModel[] result = proxy.createModelInstances(ModelType.BaseModel, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		BaseModel am = (BaseModel) result[0];
		
		//Read created model
		am = (BaseModel) proxy.getModelInstance(ModelType.BaseModel, am.getId());
		Assert.notNull(am);
		
		//Delete created model
		proxy.deleteModelInstance(ModelType.BaseModel, am.getId());
	}
	
	@Test
	public void testCreateUpdateAndDeleteAdaptationModel() throws Exception {
		//Create model
		ModelMetadata metadata = createAdatabilityModelMetadata();
		IModel[] result = proxy.createModelInstances(ModelType.AdaptabilityModel, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		AdaptabilityModel am = (AdaptabilityModel) result[0];
		
		//Update created model
		ModelUpdateMetadata mum = createModelupdateMetadata();
		am = (AdaptabilityModel) proxy.updateModelInstance(ModelType.AdaptabilityModel, mum, am.getId());
		Assert.notNull(am);
		
		//Delete created model
		proxy.deleteModelInstance(ModelType.AdaptabilityModel, am.getId());
	}
	
	@Test
	public void testGetAllAdaptationModels() throws Exception {
		List<IModel> result = proxy.getModelInstances(ModelType.AdaptabilityModel, ModelSystem.MonitoringReconfiguration, null);
		Assert.notNull(result);
		Assert.notEmpty(result);
	}
	
	@Test
	public void testGetAllBaseModels() throws Exception {
		List<IModel> result = proxy.getModelInstances(ModelType.BaseModel, null, null);
		Assert.notNull(result);
		Assert.notEmpty(result);
		
		Collections.sort(result);
		
		IModel model = proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
		Assert.notNull(model);
	}
	
	@Test
	public void testGetAllBaseModelsWithQueryMetadata() throws Exception {
		BaseModel metadata = new BaseModel();
		metadata.setName("BaseModelA");
		metadata.setAuthorId("SUPERSEDE");
		List<IModel> result = proxy.getModelInstances(ModelType.BaseModel, metadata);
		Assert.notNull(result);
		Assert.notEmpty(result);
		
		Collections.sort(result);
		
		IModel model = proxy.getModelInstance(ModelType.BaseModel, result.get(0).getValue("id").toString());
		Assert.notNull(model.getValue("id"));
	}
	
	@Test
	public void testGetBaseModelsForSystem() throws Exception {
		List<IModel> result = proxy.getModelInstances(ModelType.BaseModel, ModelSystem.MonitoringReconfiguration, null);
		Assert.notNull(result);
		Assert.notEmpty(result);
	}
	
	@Test
	public void getModelInstance() throws Exception {
		ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, "1");
		IModel result = proxy.getModelInstance(modelId);
		Assert.notNull(result);
	}
	
	@Test
	public void getModelInstance2() throws Exception {
		ITypedModelId modelId = new TypedModelId(ModelType.BaseModel, "1");
		IModel result = proxy.getModelInstance(ModelType.BaseModel, ModelSystem.MonitoringReconfiguration, "/path/to/model");
		Assert.notNull(result);
	}

	private ModelUpdateMetadata createModelupdateMetadata() {
		ModelUpdateMetadata mum = new ModelUpdateMetadata();
		mum.setSender("Adapter");
		mum.setTimeStamp(Calendar.getInstance().getTime());
		
		Map<String, String> values = new HashMap<>();
		values.put("authorId", "marc");
		values.put("featureId", "GooglePlay_API");
		mum.setValues(values);
		
		return mum;
	}

	private ModelMetadata createAdatabilityModelMetadata() throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("Adapter");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createAdaptabilityModelMetadataInstances();
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}

	private List<IModel> createAdaptabilityModelMetadataInstances() throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		AdaptabilityModel am = new AdaptabilityModel();
		modelInstances.add(am);
		
		am.setName("googleplay_api_googleplay_tool");
		am.setAuthorId("zavala");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.AdaptabilityModel.getExtension());
		am.setSystemId(ModelSystem.MonitoringReconfiguration);
		am.setFeatureId("GooglePlay");
		am.setRelativePath("path/to/model");
		am.setDependencies(new ArrayList<TypedModelId>());
		am.setModelContent(getAdaptabilityModelContent());
		
		return modelInstances;
	}

	private String getAdaptabilityModelContent() throws IOException {
		File f = new File("");
		List<String> lines = Files.readAllLines(
			Paths.get(f.getAbsolutePath() + 
				"/src/test/resources/files/timeslot_twitter.aspect"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		return content;
	}
	
	private ModelMetadata createBaseModelMetadata() throws IOException {
		ModelMetadata metadata = new ModelMetadata();
		
		metadata.setSender("Adapter");
		metadata.setTimeStamp(Calendar.getInstance().getTime());
		List<IModel> modelInstances = createBaseModelMetadataInstances();
		metadata.setModelInstances(modelInstances);
		
		return metadata;
	}

	private List<IModel> createBaseModelMetadataInstances() throws IOException {
		List<IModel> modelInstances = new ArrayList<>();
		BaseModel am = new BaseModel();
		modelInstances.add(am);
		
		am.setName("ATOS Base Model");
		am.setAuthorId("yosu");
		am.setCreationDate(Calendar.getInstance().getTime());
		am.setLastModificationDate(Calendar.getInstance().getTime());
		am.setFileExtension(ModelType.BaseModel.getExtension());
		am.setSystemId(ModelSystem.Atos);
		am.setStatus("not adapted");
		am.setModelContent(getBaseModelContent());
		
		return modelInstances;
	}

	private String getBaseModelContent() throws IOException {
		File f = new File("");
		List<String> lines = Files.readAllLines(
			Paths.get(f.getAbsolutePath() + 
				"/src/test/resources/files/atos_base_model.uml"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		content = content.replace("\"","'");
		return content;
	}
	
}
