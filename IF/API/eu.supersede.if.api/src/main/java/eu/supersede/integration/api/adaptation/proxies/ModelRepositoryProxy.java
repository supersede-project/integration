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
package eu.supersede.integration.api.adaptation.proxies;

import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.types.GenericModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ITypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;
import eu.supersede.integration.api.proxy.IFServiceProxy;
//import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;

public class ModelRepositoryProxy <T, S> extends IFServiceProxy<T, S> implements IModelRepository {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_MODELREPOSITORY_ENDPOINT = 
			IntegrationProperty.getProperty("modelrepository.endpoint");

	@Override
	public IModel[] createModelInstances(ModelType modelType, ModelMetadata metadata) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		Assert.notNull(metadata, "Provide a valid model metadata");
		URI uri = new URI (SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType);
		log.debug("Sending message createModelInstances with metadata: " + metadata + " for modelType: " + modelType + " to ModelRepository at uri " + uri);
		return (IModel[]) insertJSONObjectAndReturnAnotherType(metadata, modelType.getTypeArrayClass(), uri, HttpStatus.CREATED);
	}

	@Override
	public IModel updateModelInstance(ModelType modelType, ModelUpdateMetadata metadata, String modelId) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		Assert.notNull(metadata, "Provide a valid model update metadata");
		Assert.notNull(modelId, "Provide a valid model id");
		URI uri = new URI (SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType + "/" + modelId);
		log.debug("Sending message updateModelInstance with metadata: " + metadata + " for modelId: " + modelId + " for modelType: " + modelType + " to ModelRepository at uri " + uri);
		return (IModel) updateJSONObjectAndReturnAnotherType(metadata, modelType.getTypeClass(), uri, HttpStatus.OK);
	}

	@Override
	public IModel getModelInstance(ModelType modelType, String modelId) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		Assert.notNull(modelId, "Provide a valid model id");
		URI uri = new URI (SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType + "/" + modelId);
		log.debug("Sending message getModelInstance for modelId: " + modelId + " for modelType: " + modelType + " to ModelRepository at uri " + uri);
		return (IModel) getJSONObjectForType(modelType.getTypeClass(), uri, HttpStatus.OK);
	}

	@Override
	public void deleteModelInstance(ModelType modelType, String modelId) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		Assert.notNull(modelId, "Provide a valid model id");
		URI uri = new URI (SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType + "/" + modelId);
		log.debug("Sending message deleteModelInstance for modelId: " + modelId + " for modelType: " + modelType + " to ModelRepository at uri " + uri);
		deleteUriResource(uri, HttpStatus.OK);
	}

	@Override
	/**
	 * SystemId and status are optional
	 */
	public List<IModel> getModelInstances(ModelType modelType, ModelSystem systemId, Status status) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		String suri = SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType + "?";

		if (systemId != null){
			suri += "systemId=" + systemId;
		}
		
		if (status != null){
			if (systemId !=null){
				suri += "&";
			}
			suri += "status=" + status;
		}
		
		log.debug("Sending message getModelInstances with modelType: " + modelType 
			+ " with systemId: " + systemId 
			+ " with status: " + status
			+ " to ModelRepository at uri " + suri);
		return  (List<IModel>) getJSONObjectsListForType((Class<T[]>) modelType.getTypeArrayClass(), new URI (suri), HttpStatus.OK);
	}

	@Override
	public <S extends GenericModel> List<IModel> getModelInstances (ModelType modelType, S metadata) throws Exception {
		Assert.notNull(modelType, "Provide a valid model type");
		Assert.notNull(metadata, "Provide a valid metadata");
		String suri = SUPERSEDE_MODELREPOSITORY_ENDPOINT + "models/" + modelType + "?";

		boolean addParameterSeparator = false;
		try{
			if (metadata.getValue("systemId")!=null){
				suri += "systemId=" + URLEncoder.encode(metadata.getValue("systemId").toString(), "UTF-8");
				addParameterSeparator = true;
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("status")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "status=" + URLEncoder.encode(metadata.getValue("status").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("featureId")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "featureId=" + URLEncoder.encode(metadata.getValue("featureId").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("name")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "name=" + URLEncoder.encode(metadata.getValue("name").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
			
		try{
			if (metadata.getValue("url")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "url=" + URLEncoder.encode(metadata.getValue("url").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("authorId")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "authorId=" + URLEncoder.encode(metadata.getValue("authorId").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("creationDate")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "creationDate=" + URLEncoder.encode(metadata.getValue("creationDate").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("lastModificationDate")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "lastModificationDate=" + URLEncoder.encode(metadata.getValue("lastModificationDate").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("fileExtension")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "fileExtension=" + URLEncoder.encode(metadata.getValue("fileExtension").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		try{
			if (metadata.getValue("relativePath")!=null){
				if (addParameterSeparator)
					suri += "&";
				else
					addParameterSeparator = true;
				suri += "relativePath=" + URLEncoder.encode(metadata.getValue("relativePath").toString(), "UTF-8");
			}
		}catch (Exception e){
			//Ignored
		}
		
		log.debug("Sending message getModelInstances with modelType: " + modelType 
			+ " with metadata: " + metadata 
			+ " to ModelRepository at uri " + suri);
		return  (List<IModel>) getJSONObjectsListForType((Class<T[]>) modelType.getTypeArrayClass(), new URI (suri), HttpStatus.OK);
	}

	@Override
	public IModel getModelInstance(ITypedModelId modelId) throws Exception {
		return getModelInstance(modelId.getModelType(), modelId.getNumber());
	}
	
	@Override
	public IModel getModelInstance(ModelType modelType, ModelSystem system, String relativePath) throws Exception {
		GenericModel metadata = new GenericModel();
		metadata.setRelativePath(relativePath);
		List<IModel> results = getModelInstances (modelType, metadata);
		if (results.size()>0)
			return results.get(0);
		else
			return null;
	}
}
