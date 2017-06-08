package eu.supersede.integration.api.fe.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;

public class FrontendAuthenticationTest {

	@Test
	public void testLogin() throws Exception {
		FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
		FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
		Assert.notNull(frontEndSession);
	}

}
