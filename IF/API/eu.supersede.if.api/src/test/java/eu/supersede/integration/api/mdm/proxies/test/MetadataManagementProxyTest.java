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
package eu.supersede.integration.api.mdm.proxies.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.mdm.proxies.MetadataManagementProxy;
import eu.supersede.integration.api.mdm.types.KafkaTopic;
import eu.supersede.integration.api.mdm.types.SchemaRelease;

public class MetadataManagementProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private MetadataManagementProxy<?, ?> proxy;

	@Before
	public void setup() throws Exception {
		proxy = new MetadataManagementProxy<Object, Object>();
	}

	@Test
	public void testRegisterSchemaRelease() throws Exception {
		SchemaRelease release = new SchemaRelease();
		release.setEvent("TwitterMonitor");
		release.setSchemaVersion("Sample_Version_1"); 
		//String jsonInstances = "{\\\"SocialNetworksMonitoredData\\\":{\\\"idOutput\\\":\\\"12345\\\",\\\"confId\\\":\\\"67890\\\",\\\"searchTimeStamp\\\":\\\"2016-07-19 17:23:00.000\\\",\\\"numDataItems\\\":1,\\\"DataItems\\\":[{\\\"idItem\\\":\\\"6253282\\\",\\\"timeStamp\\\":\\\"2016-05-25 20:03\\\",\\\"message\\\":\\\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\\\",\\\"author\\\":\\\"@SnoopDogg\\\",\\\"link\\\":\\\"https:\\/\\/twitter.com\\/SnoopDogg\\/status\\/734894106967703552\\\"}]}}";
		String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
		release.setJsonInstances(jsonInstances);
		KafkaTopic result = proxy.registerSchemaRelease(release );
		Assert.notNull(result);
	}
	
	@Test
	public void testJsonInstances(){
		String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
		System.out.println(jsonInstances);
	}
	
}
