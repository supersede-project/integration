package eu.supersede.integration.api.adaptation.types;

public class ActionOnAttribute {

	public String getId() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public AttributeAction getTypeaction() {
		return typeaction;
	}

	public void setTypeaction(AttributeAction typeaction) {
		this.typeaction = typeaction;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}


	String					id;
	AttributeAction			typeaction;
	double 					value;
	
	public ActionOnAttribute() {}

	public ActionOnAttribute(
			String 			id, 
			AttributeAction typeaction, 
			double 			value) {
		super();
		this.id = id;
		this.typeaction = typeaction;
		this.value = value;
	}
	
	
}
