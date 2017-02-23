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
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.mdm.types.ECA_Rule;
import eu.supersede.integration.api.mdm.types.KafkaTopic;
import eu.supersede.integration.api.mdm.types.Release;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class MetadataManagementProxy<T, S> extends IFServiceProxy<T, S> implements IMetadataManagement {
	private static final Logger log = Logger.getLogger(MetadataManagementProxy.class);

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
	
}
