package eu.supersede.integration.poc.dynadapt.proxies.test;

import java.util.Collection;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import eu.supersede.integration.poc.dynadapt.Dashboard;
import eu.supersede.integration.poc.dynadapt.proxies.DynAdapDMProxy;
import eu.supersede.integration.poc.dynadapt.proxies.DynAdapEnactProxy;
import eu.supersede.integration.poc.dynadapt.test.SpringAppTest;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.poc.dynadapt.types.CollectionOfDecisions;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Dashboard.class)
//@WebAppConfiguration
@WebIntegrationTest
public class DynAdapEnactProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DynAdapEnactProxyTest.class);
	private static boolean ready = false;
	
	public static void setReady(boolean ready){
		DynAdapEnactProxyTest.ready = ready;
	}
	
    @Before
    public void setup() throws Exception {
 
    }

    @Test
    public void testTriggerTopRankedEnactmentForAdaptationDecisionAsXML() throws Exception{
    	log.info("Testing testTriggerTopRankedEnactmentForAdaptationDecisionAsXML");
		Collection<AdaptationDecision> decisions = new DynAdapDMProxy().getAdaptationDecisions(UUID.randomUUID());
		Assert.assertTrue(!decisions.isEmpty());
		AdaptationEnactment enactment = 
				new DynAdapEnactProxy().triggerTopRankedEnactmentForAdaptationDecisionAsXML(decisions.iterator().next(), UUID.randomUUID());

		Assert.assertTrue(enactment!=null);
    }
    
    @Test
    public void testTriggerTopRankedEnactmentForAdaptationDecisionAsJSON() throws Exception{
    	log.info("Testing testTriggerTopRankedEnactmentForAdaptationDecisionAsJSON");
		Collection<AdaptationDecision> decisions = new DynAdapDMProxy().getAdaptationDecisions(UUID.randomUUID());
		Assert.assertTrue(!decisions.isEmpty());
		AdaptationEnactment enactment = 
				new DynAdapEnactProxy().triggerTopRankedEnactmentForAdaptationDecisionAsJSON(decisions.iterator().next(), UUID.randomUUID());

		Assert.assertTrue(enactment!=null);
    }
}
