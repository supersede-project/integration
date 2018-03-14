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

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.mdm.proxies.MetadataManagementProxy;
import eu.supersede.integration.api.mdm.types.CER_Rule;
import eu.supersede.integration.api.mdm.types.ECA_Rule;
import eu.supersede.integration.api.mdm.types.Event;
import eu.supersede.integration.api.mdm.types.Feedback;
import eu.supersede.integration.api.mdm.types.FeedbackClassification;
import eu.supersede.integration.api.mdm.types.KafkaTopic;
import eu.supersede.integration.api.mdm.types.Release;

public class MetadataManagementProxyTest {
	// private static final Logger log =
	// LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private static MetadataManagementProxy<?, ?> proxy;

	@BeforeClass
	public static void setup() throws Exception {
		proxy = new MetadataManagementProxy<Object, Object>();
	}

	@Test
	public void testRegisterRelease() throws Exception {
		Release release = new Release();
		release.setEvent("TwitterMonitor");
		release.setSchemaVersion("Sample_Version_1"); 
		//String jsonInstances = "{\\\"SocialNetworksMonitoredData\\\":{\\\"idOutput\\\":\\\"12345\\\",\\\"confId\\\":\\\"67890\\\",\\\"searchTimeStamp\\\":\\\"2016-07-19 17:23:00.000\\\",\\\"numDataItems\\\":1,\\\"DataItems\\\":[{\\\"idItem\\\":\\\"6253282\\\",\\\"timeStamp\\\":\\\"2016-05-25 20:03\\\",\\\"message\\\":\\\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\\\",\\\"author\\\":\\\"@SnoopDogg\\\",\\\"link\\\":\\\"https:\\/\\/twitter.com\\/SnoopDogg\\/status\\/734894106967703552\\\"}]}}";
		String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
		release.setJsonInstances(jsonInstances);
		release.setDispatch(true);
		release.setDispatcherPath("/path/to/dispatcher.txt");
		KafkaTopic result = proxy.registerRelease(release );
		Assert.notNull(result);
	}
	
	@Test
	public void testGelAllReleases() throws Exception {
		List<Release> result = proxy.getAllReleases();
		Assert.notNull(result);
		Assert.notEmpty(result);
	}
	
	@Test
	public void testGelAllECARules() throws Exception {
		List<ECA_Rule> result = proxy.getAllECARules();
		Assert.notNull(result);
		Assert.notEmpty(result);
	}
	
	@Test
	public void testGetECARule() throws Exception {
		List<ECA_Rule> rules = proxy.getAllECARules();
		Assert.notNull(rules);
		Assert.notEmpty(rules);
		
		ECA_Rule result = proxy.getECARule(rules.get(0).getEca_ruleID()); 
		Assert.notNull(result);
	}
	
	@Test
	public void testGelAllCERRules() throws Exception {
		List<CER_Rule> result = proxy.getAllCERRules();
		Assert.notNull(result);
//		Assert.notEmpty(result);
	}
	
//	@Ignore
//	@Test
//	public void testGetCERRule() throws Exception {
//		List<CER_Rule> rules = proxy.getAllCERRules();
//		Assert.notNull(rules);
//		Assert.notEmpty(rules);
//		
//		CER_Rule result = proxy.getCERRule(rules.get(0).getCer_ruleID()); 
//		Assert.notNull(result);
//	}
	
	@Test
	public void testGelAllEvents() throws Exception {
		List<Event> result = proxy.getAllEvents();
		Assert.notNull(result);
		Assert.notEmpty(result);
	}
	
	@Test
	public void testGetEvent() throws Exception {
		List<Event> events = proxy.getAllEvents();
		Assert.notNull(events);
		Assert.notEmpty(events);
		
		Event result = proxy.getEvent(events.get(0).getEventID()); 
		Assert.notNull(result);
	}
	
	@Test
	public void testJsonInstances(){
		String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
		System.out.println(jsonInstances);
	}
	
	@Test
	public void testSendFiles() throws Exception{
		Path filePath = FileSystems.getDefault().getPath("src/test/resources/files", "list1s.txt");
		boolean result = proxy.sendFile(filePath);
		Assert.isTrue(result);
	}
	
	@Test
	public void testRealtimeFeedbackClassification() throws Exception{
		Feedback feedback = new Feedback("hello, I don't like this");
		FeedbackClassification result = proxy.getRealtimeFeedbackClassification(feedback);
		Assert.notNull(result);
	}
	
	@Test
	public void createEvent() throws Exception {
		Event event = new Event();
		event.setEvent("TwitterMonitor");
		String jsonInstances = "{\"SocialNetworksMonitoredData\":{\"idOutput\":\"12345\",\"confId\":\"67890\",\"searchTimeStamp\":\"2016-07-19 17:23:00.000\",\"numDataItems\":1,\"DataItems\":[{\"idItem\":\"6253282\",\"timeStamp\":\"2016-05-25 20:03\",\"message\":\"Game on. Big ten network in 10 mins. Hoop for water. Flint we got ya back\",\"author\":\"@SnoopDogg\",\"link\":\"https://twitter.com/SnoopDogg/status/734894106967703552\"}]}}";
		event.setJsonInstances(jsonInstances);
		event.setPlatform("senercon");
		KafkaTopic result = proxy.createEvent(event);
		Assert.notNull(result);
	}
}
