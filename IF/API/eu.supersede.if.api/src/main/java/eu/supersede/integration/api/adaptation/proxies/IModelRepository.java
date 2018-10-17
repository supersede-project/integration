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

import java.util.List;

import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.adaptation.types.GenericModel;
import eu.supersede.integration.api.adaptation.types.IModel;
import eu.supersede.integration.api.adaptation.types.ITypedModelId;
import eu.supersede.integration.api.adaptation.types.ModelMetadata;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.ModelType;
import eu.supersede.integration.api.adaptation.types.ModelUpdateMetadata;
import eu.supersede.integration.api.adaptation.types.Status;

public interface IModelRepository {
	IModel[] createModelInstances (ModelType modelType, ModelMetadata metadata) throws Exception;
	IModel updateModelInstance (ModelType modelType, ModelUpdateMetadata metadata, String modelId) throws Exception;
	IModel getModelInstance (ModelType modelType, String modelId) throws Exception;
	List<IModel> getModelInstances (ModelType modelType, ModelSystem systemId, Status status) throws Exception;
	<T extends GenericModel> List<IModel> getModelInstances (ModelType modelType, T metadata) throws Exception;
	HttpStatus deleteModelInstance (ModelType modelType, String modelId) throws Exception;
	IModel getModelInstance(ITypedModelId modelId) throws Exception;
	public IModel getModelInstance(ModelType modelType, ModelSystem system, String relativePath) throws Exception;
}

