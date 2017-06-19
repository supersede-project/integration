package eu.supersede.integration.api.adaptation.dashboard.proxies.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import eu.supersede.integration.api.adaptation.dashboad.types.Action;
import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.adaptation.dashboad.types.Enactment;
import eu.supersede.integration.api.adaptation.dashboard.proxies.AdaptationDashboardProxy;
import eu.supersede.integration.api.adaptation.types.ModelSystem;

public class AdaptationDashboardResetTest {
	private AdaptationDashboardProxy <Object, Object> proxy;
	
	@Before
	public void setup() throws Exception{
		proxy = new AdaptationDashboardProxy<>("adaptation", "adaptation", "atos");
	}

	@Test
	public void testResetDashboard() throws Exception {
		//Delete adaptations
		List<Adaptation> adaptations = proxy.getAllAdaptations();
		for (Adaptation adaptation: adaptations){
			Enactment enactment = proxy.getEnactment(adaptation.getFc_id());
			if (enactment!=null)
				proxy.deleteEnactment(adaptation.getFc_id());
			proxy.deleteAdaptation(adaptation.getFc_id());
		}
		
		//Create Atos adaptation
		Adaptation adaptation = createAtosAdaptation();
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		Enactment enactment = createAtosEnactment(adaptation);
		enactment = proxy.addEnactment(enactment);
		Assert.notNull(enactment); 
		
		//Create Siemens adaptation
		adaptation = createSiemensAdaptation();
		adaptation = proxy.addAdaptation(adaptation);
		Assert.notNull(adaptation); 
		
		enactment = createSiemensEnactment(adaptation);
		enactment = proxy.addEnactment(enactment);
		Assert.notNull(enactment); 
	}
	

	private Adaptation createAtosAdaptation() {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id("1");
		Calendar computation = Calendar.getInstance();
		adaptation.setComputation_timestamp(computation.getTime());
		adaptation.setModel_system(ModelSystem.Atos_HSK);
		adaptation.setName("AtosSmart_HSK_SingleVM_LowLoad");
		adaptation.setRank(1.0);
		adaptation.getActions().add(createAtosAction());
		return adaptation;
	}

	private Action createAtosAction() {
		Action action = new Action ();
		action.setAction_id("lowloadconfigurationinvm2_a");
		action.setDescription("Low load configuration for HSK service in single VM");
		action.setName("LowLoadConfigurationinVM2_A");
		action.setEnabled(true);
		
		return action;
	}

	private Enactment createAtosEnactment(Adaptation adaptation) {
		Enactment enactment = new Enactment();
		enactment.setFc_id(adaptation.getFc_id());
		Calendar completion_time = Calendar.getInstance();
		Calendar request_time = Calendar.getInstance();
		request_time.add(Calendar.MINUTE, 5);
		completion_time.setTimeInMillis(60000);
		enactment.setEnactment_completion_time(completion_time.getTime());
		enactment.setEnactment_request_time(request_time.getTime());
		enactment.setResult(true);
		return enactment;
	}
	
	private Adaptation createSiemensAdaptation() {
		Adaptation adaptation = new Adaptation();
		adaptation.setFc_id("2");
		Calendar computation = Calendar.getInstance();
		computation.add(Calendar.MINUTE, 10);
		adaptation.setComputation_timestamp(computation.getTime());
		adaptation.setModel_system(ModelSystem.Siemens);
		adaptation.setName("Siemens C1");
		adaptation.setRank(1.0);
		adaptation.getActions().add(createSiemensAction());
		return adaptation;
	}

	private Action createSiemensAction() {
		Action action = new Action ();
		action.setAction_id("c1");
		action.setDescription("GetMetheorologicalData composition for 90% availability");
		action.setName("SC1");
		action.setEnabled(true);
		
		return action;
	}

	private Enactment createSiemensEnactment(Adaptation adaptation) {
		Enactment enactment = new Enactment();
		enactment.setFc_id(adaptation.getFc_id());
		Calendar completion_time = Calendar.getInstance();
		Calendar request_time = Calendar.getInstance();
		request_time.add(Calendar.MINUTE, 6);
		completion_time.setTimeInMillis(30000);
		enactment.setEnactment_completion_time(completion_time.getTime());
		enactment.setEnactment_request_time(request_time.getTime());
		enactment.setResult(true);
		return enactment;
	}

}
