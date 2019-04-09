package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
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
	private static Adaptation createdAdaptation;
	private static Enactment createdEnactment;
	
	@BeforeClass
	public static void setup() throws Exception{
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
		
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		List<Enactment> enactments = proxy.getAllEnactments();
		//Cleaning adaptations and enactments
		for (Enactment e: enactments){
			proxy.deleteEnactment(e.getFc_id());
		}
		for (Adaptation a: adaptations){
			proxy.deleteAdaptation(a.getFc_id());
		}
		
		//Creating adaptation
		createdAdaptation = createAdaptation(1);
		proxy.addAdaptation(createdAdaptation);
		adaptations = proxy.getAllAdaptations();
		
		adaptationId = adaptations.get(0).getFc_id();
		Assert.notNull(adaptationId);
	
		
		//Creating enactment
		createdEnactment = createEnactment(createdAdaptation.getFc_id());
		proxy.addEnactment(createdEnactment);
		enactments = proxy.getAllEnactments();
		
		enactmentId = enactments.get(0).getFc_id();
		Assert.notNull(enactmentId);
	}
	
	@AfterClass
	public static void cleanup() throws Exception{
		if (createdEnactment != null)
			assertEquals(proxy.deleteEnactment(createdAdaptation.getFc_id()), HttpStatus.OK);
		
		if (createdAdaptation != null)
			assertEquals(proxy.deleteAdaptation(createdAdaptation.getFc_id()), HttpStatus.OK);
	}

	@Test
	public void testGetAllAdaptations() throws Exception {
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		Assert.notEmpty(adaptations);
	}
	
	@Test
	public void testGetAdaptation() throws Exception {
		Adaptation adaptation = createAdaptation(3);
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		adaptation = proxy.getAdaptation(adaptation.getFc_id());
		Assert.notNull(adaptation);
		
		assertEquals(proxy.deleteAdaptation(adaptation.getFc_id()), HttpStatus.OK);
	}
	
	@Test
	public void testAddAdaptation() throws Exception {
		Adaptation adaptation = createAdaptation(4);
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		assertEquals(proxy.deleteAdaptation(adaptation.getFc_id()), HttpStatus.OK);
	}

	private static Adaptation createAdaptation(Integer fc_id) {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id(fc_id);
		adaptation.setComputation_timestamp(Calendar.getInstance().getTime());
		adaptation.setModel_system(ModelSystem.Atos_HSK);
		adaptation.setName("Medium load configuration for HSK service");
		adaptation.setRank(1.0);
		adaptation.getActions().add(createAction());
		return adaptation;
	}

	private static Action createAction() {
		Action action = new Action ();
		action.setAction_id("vm2_b_high");
		action.setDescription("Medium load configuration for HSK service");
		action.setName("VM2_B_HighConfiguration");
		action.setEnabled(true);
		
		return action;
	}
	
	@Test
	public void testGetAllEnactments() throws Exception {
		List<Enactment> enactments = proxy.getAllEnactments();
		Assert.notNull(enactments);
	}
	
	@Test
	public void testGetEnactment() throws Exception {
		List<Enactment> enactments = proxy.getAllEnactments();
		Assert.notNull(enactments);
		Enactment enactment = proxy.getEnactment(enactments.get(0).getFc_id());
		Assert.notNull(enactment);
	}
	
	@Test
	public void testAddEnactment() throws Exception {
		Adaptation adaptation = createAdaptation(2);
		//Remove if enactment exists
		if (proxy.getEnactment(adaptation.getFc_id())!=null) {
			proxy.deleteEnactment(adaptation.getFc_id());
		}
		adaptation = proxy.addAdaptation(adaptation);
		
		Enactment enactment = createEnactment(adaptation.getFc_id());
		enactment = proxy.addEnactment(enactment);
		Assert.notNull(enactment); 
		
		assertEquals(proxy.deleteEnactment(adaptation.getFc_id()), HttpStatus.OK);
		assertEquals(proxy.deleteAdaptation(adaptation.getFc_id()), HttpStatus.OK);
	}

	private static Enactment createEnactment(String fc_id) {
		Enactment enactment = new Enactment();
		enactment.setFc_id(fc_id);
		enactment.setEnactment_completion_time(Calendar.getInstance().getTime());
		enactment.setEnactment_request_time(Calendar.getInstance().getTime());
		enactment.setResult(true);
		return enactment;
	}

}
