package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;

public class AdaptationDashboardProxyTest {
	private AdaptationDashboardProxy <Object, Object> proxy;
	
	@Before
	public void setup() throws Exception{
		proxy = new AdaptationDashboardProxy<>("wp_admin", "9jqUuNrZ", "atos");
	}

	@Test
	public void testGetAllAdaptations() throws Exception {
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		Assert.notEmpty(adaptations);
	}

}
