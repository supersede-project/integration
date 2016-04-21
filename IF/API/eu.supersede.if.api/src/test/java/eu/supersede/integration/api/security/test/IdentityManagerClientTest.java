package eu.supersede.integration.api.security.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import eu.supersede.integration.api.security.IdentityManagerClient;

public class IdentityManagerClientTest {
	private static final Logger log = LoggerFactory.getLogger(IdentityManagerClientTest.class);

    @Before
    public void setup() throws Exception {
        
    }

    @Test
    public void testAuthenticateUserAccount() throws Exception{
    	Assert.isTrue(IdentityManagerClient.authenticateUserAccount("yosu", "yosutest"));
    }
}
