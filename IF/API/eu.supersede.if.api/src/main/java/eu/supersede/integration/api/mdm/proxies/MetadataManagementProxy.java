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
package eu.supersede.integration.api.mdm.proxies;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;

import eu.supersede.integration.api.mdm.types.ECA_Rule;
import eu.supersede.integration.api.mdm.types.Feedback;
import eu.supersede.integration.api.mdm.types.KafkaTopic;
import eu.supersede.integration.api.mdm.types.Release;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class MetadataManagementProxy<T, S> extends IFServiceProxy<T, S> implements IMetadataManagement {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final static String SUPERSEDE_MDM_ENDPOINT = IntegrationProperty
			.getProperty("metadata.management.endpoint");

	@Override
	public KafkaTopic registerRelease (Release release) throws Exception {
		Assert.notNull(release, "Provide a valid release");
		URI uri = new URI(SUPERSEDE_MDM_ENDPOINT + "release");
		log.debug("Sending message registerRelease with release: " + release +
				" to MetadataManagement at uri " + uri);
		return insertJSONObjectAndReturnAnotherType(release, KafkaTopic.class, uri,  HttpStatus.OK);
	}

	@Override
	public List<Release> getAllReleases() throws Exception {
		URI uri = new URI(SUPERSEDE_MDM_ENDPOINT + "release");
		log.debug("Sending message getAllReleases to MetadataManagement at uri " + uri);
		return getJSONObjectsListForType(Release[].class, uri, HttpStatus.OK);
	}

	@Override
	public List<ECA_Rule> getAllECARules() throws Exception {
		URI uri = new URI(SUPERSEDE_MDM_ENDPOINT + "eca_rule");
		log.debug("Sending message getAllECARules to MetadataManagement at uri " + uri);
		return getJSONObjectsListForType(ECA_Rule[].class, uri, HttpStatus.OK);
	}

	@Override
	public boolean getRealtimeFeedbackClassification(Feedback feedback) throws Exception {
		Assert.notNull(feedback, "Provide a valid feedback");
		URI uri = new URI(SUPERSEDE_MDM_ENDPOINT + "classify/feedback");
		log.debug("Sending message getRealtimeFeedbackClassification for feedback: " + feedback +
				" to MetadataManagement at uri " + uri);
		return insertJSONObject(feedback, uri,  HttpStatus.OK);
	}

	@Override
	public boolean sendFile(Path filePath) throws Exception {
		Assert.notNull(filePath, "Provide a valid filePath");
		
		URI uri = new URI(SUPERSEDE_MDM_ENDPOINT + "files");
		
		LinkedMultiValueMap<String, Object> parts = 
		          new LinkedMultiValueMap<String, Object>();
		
		Resource file = new ByteArrayResource(Files.readAllBytes(filePath)){
            @Override
            public String getFilename(){
                return filePath.getFileName().toString();
            }
        };
		
		HttpHeaders xmlHeaders = new HttpHeaders();
        xmlHeaders.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<Resource> fileEntity = new HttpEntity<Resource>(file, xmlHeaders);
		
		parts.add("file", fileEntity);
		
		log.debug("Sending message sendFile with filePath: " + filePath
				+ " to MetadataManagement at uri " + uri);
		return sendMultipartFormDataMessage(uri, parts, HttpMethod.POST, HttpStatus.OK);
	}
	
}
