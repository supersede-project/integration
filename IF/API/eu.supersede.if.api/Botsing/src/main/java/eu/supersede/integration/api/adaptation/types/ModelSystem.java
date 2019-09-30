package eu.supersede.integration.api.adaptation.types;

public enum ModelSystem {
	Supersede ("Supersede", Tenant.SUPERSEDE),
	MonitoringReconfiguration ("MonitoringReconfiguration", Tenant.SUPERSEDE),
	FeedbackGatheringReconfiguration ("FeedbackGatheringReconfiguration", Tenant.SUPERSEDE),
	Siemens ("Siemens", Tenant.SIEMENS),
	Siemens_Buildings ("Siemens_Buildings", Tenant.SIEMENS),
	Siemens_Types ("Siemens_Types", Tenant.SIEMENS),
	Siemens_GetMinMaxDates ("Siemens_GetMinMaxDates", Tenant.SIEMENS),
	Atos ("Atos", Tenant.ATOS),
	Atos_HSK ("Atos_HSK", Tenant.ATOS),
	Senercon ("Senercon", Tenant.SENERCON),
	AtosMonitoringEnabling ("AtosMonitoringEnabling", Tenant.ATOS),
	AtosMonitoringTimeSlot ("AtosMonitoringTimeSlot", Tenant.ATOS),
	SiemensMonitoring ("SiemensMonitoring", Tenant.SIEMENS),
	SenerconMonitoring ("SenerconMonitoring", Tenant.SENERCON),
	AtosFG ("AtosFG", Tenant.ATOS),
	SiemensFG ("SiemensFG", Tenant.SIEMENS),
	SenerconFG ("SenerconFG", Tenant.SENERCON),
	SenerconFGcat ("SenerconFGcat", Tenant.SENERCON),
	SiemensFGcat ("SiemensFGcat", Tenant.SIEMENS),
	AtosFGcat ("AtosFGcat", Tenant.ATOS),
	Health ("Health", Tenant.SUPERSEDE);
	
	String id;
	Tenant tenant;
	
	ModelSystem(String id, Tenant tenant){
		this.id = id;
		this.tenant = tenant;
	}
	
	@Override
	public String toString(){
		return id;
	}
	
	public String getId(){
		return id;
	}
	
	public Tenant getTenant(){
		return tenant;
	}
}
