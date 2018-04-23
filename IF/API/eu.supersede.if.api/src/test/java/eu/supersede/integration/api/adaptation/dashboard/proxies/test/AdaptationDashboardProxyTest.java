package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdaptationDashboardProxyTest {
	private static AdaptationDashboardProxy <Object, Object> proxy;
	private static String adaptationId;
	private static String enactmentId;
	
	@BeforeClass
	public static void setup() throws Exception{
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		Assert.notEmpty(adaptations);
		adaptationId = adaptations.get(0).getFc_id();
		Assert.notNull(adaptationId);

//		
//		List<Enactment> enactments = proxy.getAllEnactments();
//		Assert.notEmpty(enactments);
//		enactmentId = enactments.get(0).getFc_id();
//		Assert.notNull(enactmentId);

	}

	@Test
	public void testGetAllAdaptations() throws Exception {
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		Assert.notEmpty(adaptations);
	}
	
	@Test
	public void testGetAdaptation() throws Exception {
		Adaptation adaptation = proxy.getAdaptation(adaptationId);
		Assert.notNull(adaptation);
	}
	
	@Test
	public void testAddAdaptation() throws Exception {
		Adaptation adaptation = createAdaptation("905");
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		proxy.deleteAdaptation(adaptation.getFc_id());
	}

	private Adaptation createAdaptation(String fc_id) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setModel_system(ModelSystem.AtosMonitoring);
		adaptation.setName("Medium load configuration for HSK service");
		adaptation.setRank(1.0);
		adaptation.getActions().add(createAction());
		return adaptation;
	}

	private Action createAction() {
		Action action = new Action ();
		action.setAction_id("vm2_b_high");
		action.setDescription("Medium load configuration for HSK service");
		action.setName("VM2_B_HighConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
	@Test
	public void testGetAllEnactments() throws Exception {
		List<Enactment> adaptations = proxy.getAllEnactments();
		Assert.notNull(adaptations);
	}
	
	@Test
	public void testGetEnactment() throws Exception {
		Enactment enactment = proxy.getEnactment(enactmentId);
//		Assert.notNull(enactment);
	}
	
	@Test
	public void testAddEnactment() throws Exception {
		Adaptation adaptation = createAdaptation("2");
		adaptation = proxy.addAdaptation(adaptation);
		
		Enactment enactment = createEnactment(adaptation.getFc_id());
		enactment = proxy.addEnactment(enactment);
		Assert.notNull(enactment); 
		
		proxy.deleteEnactment(adaptation.getFc_id());
		proxy.deleteAdaptation(adaptation.getFc_id());
	}

	private Enactment createEnactment(String fc_id) {
		Enactment enactment = new Enactment();
		enactment.setFc_id(fc_id);
		enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
		enactment.setEnactment_request_time(Calendar.getInstance().getTime());
		enactment.setResult(true);
		return enactment;
	}

}
