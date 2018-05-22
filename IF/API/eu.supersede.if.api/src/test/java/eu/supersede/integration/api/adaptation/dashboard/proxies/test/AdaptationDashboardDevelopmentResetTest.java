package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;

public class AdaptationDashboardDevelopmentResetTest {
	private static AdaptationDashboardProxy <Object, Object> proxy;
	
	@BeforeClass
	public static void setup() throws Exception{
//		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
	}

	@Test
	public void testResetAtosDashboard() throws Exception {
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		
		//Delete adaptations
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		for (Adaptation adaptation: adaptations){
			Enactment enactment = proxy.getEnactment(adaptation.getFc_id());
			if (enactment!=null)
				proxy.deleteEnactment(adaptation.getFc_id());
			proxy.deleteAdaptation(adaptation.getFc_id());
		}
	}
	
	@Test
	public void testResetSiemensDashboard() throws Exception {
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "siemens");
		
		//Delete adaptations
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		for (Adaptation adaptation: adaptations){
			Enactment enactment = proxy.getEnactment(adaptation.getFc_id());
			if (enactment!=null)
				proxy.deleteEnactment(adaptation.getFc_id());
			proxy.deleteAdaptation(adaptation.getFc_id());
		}
	}
	
	@Test
	public void testResetSenerconDashboard() throws Exception {
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "senercon");
		
		//Delete adaptations
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		for (Adaptation adaptation: adaptations){
			Enactment enactment = proxy.getEnactment(adaptation.getFc_id());
			if (enactment!=null)
				proxy.deleteEnactment(adaptation.getFc_id());
			proxy.deleteAdaptation(adaptation.getFc_id());
		}
	}

}
