package eu.supersede.integration.api.replan.controller.types;

public enum FeatureStatus {
	ANY, PENDING, SCHEDULED;
	
	public String toString (){
		return this.name().toLowerCase();
	}
}
