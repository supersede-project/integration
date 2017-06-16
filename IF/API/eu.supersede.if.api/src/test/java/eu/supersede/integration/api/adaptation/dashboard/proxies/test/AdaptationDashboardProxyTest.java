package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdaptationDashboardProxyTest {
	private AdaptationDashboardProxy <Object, Object> proxy;
	
	@Before
	public void setup() throws Exception{
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
	}

	@Test
	public void testGetAllAdaptations() throws Exception {
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		Assert.notEmpty(adaptations);
	}
	
	@Test
	public void testGetAdaptation() throws Exception {
		String id = "FC_1";
		Adaptation adaptation = proxy.getAdaptation(id);
		Assert.notNull(adaptation);
	}
	
	@Test
	public void testAddAdaptation() throws Exception {
		Adaptation adaptation = createAdaptation("1");
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		proxy.deleteAdaptation(adaptation.getFc_id());
	}

	private Adaptation createAdaptation(String fc_id) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setModel_system(ModelSystem.Siemens);
		adaptation.setName("AtosSmart_HSK_DualVM_MediumHigh");
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
		Assert.notEmpty(adaptations);
	}
	
	@Test
	public void testGetEnactment() throws Exception {
		String id = "FC_1";
		Enactment enactment = proxy.getEnactment(id);
		Assert.notNull(enactment);
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
