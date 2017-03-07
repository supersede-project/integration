package eu.supersede.integration.api.adaptation.types;

public enum ModelSystem {
	Supersede ("Supersede"),
	MonitoringReconfiguration ("MonitoringReconfiguration"),
	FeedbackGatheringReconfiguration ("FeedbackGatheringReconfiguration"),
	Siemens ("Siemens"),
	Atos ("Atos"),
	Senercon ("Senercon"),
	Health ("Health");
	
	String id;
	ModelSystem(String id){
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id;
	}
	
	public String getId(){
		return id;
	}
}
