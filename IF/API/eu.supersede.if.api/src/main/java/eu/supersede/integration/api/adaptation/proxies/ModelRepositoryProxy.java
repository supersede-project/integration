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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
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
}
