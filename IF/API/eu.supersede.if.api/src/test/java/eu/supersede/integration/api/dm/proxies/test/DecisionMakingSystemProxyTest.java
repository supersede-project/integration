package eu.supersede.integration.api.dm.proxies.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.proxies.DecisionMakingSystemProxy;
import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.AlertLevel;

public class DecisionMakingSystemProxyTest {
	private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxyTest.class);
	private DecisionMakingSystemProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new DecisionMakingSystemProxy();
    }

    @Test
    public void testNotifyAlert() throws Exception{
    	Alert alert = new Alert(AlertLevel.Normal, "1", "Message", 10.0 );
    	boolean result = proxy.notifyAlert(alert);
    	Assert.isTrue(result);
    }

}
