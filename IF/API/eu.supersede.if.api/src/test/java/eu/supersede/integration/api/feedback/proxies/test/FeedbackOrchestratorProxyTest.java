package eu.supersede.integration.api.feedback.proxies.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.feedback.orchestrator.types.Application;
import eu.supersede.integration.api.feedback.proxies.FeedbackOrchestratorProxy;

public class FeedbackOrchestratorProxyTest {
	private static final Logger log = LoggerFactory.getLogger(FeedbackOrchestratorProxyTest.class);
	private FeedbackOrchestratorProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new FeedbackOrchestratorProxy();
    }

    @Test
    public void testGetAllApplications() throws Exception{
    	List<Application> result = proxy.GetAllApplications();
    	Assert.notNull(result);
    	Assert.isTrue(!result.isEmpty());
    }
}
