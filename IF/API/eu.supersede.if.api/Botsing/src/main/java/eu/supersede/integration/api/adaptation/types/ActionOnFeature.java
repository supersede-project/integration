package eu.supersede.integration.api.adaptation.types;

public class ActionOnFeature {

	public String getId() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public FeatureAction getTypeaction() {
		return typeaction;
	}
	public void setTypeaction(FeatureAction typeaction) {
		this.typeaction = typeaction;
	}
	
	String					id;
	FeatureAction			typeaction;
	
	public ActionOnFeature(){}
	
	public ActionOnFeature(
			String 			id, 
			FeatureAction 	typeaction) {
		super();
		this.id = id;
		this.typeaction = typeaction;
	}
	
}
