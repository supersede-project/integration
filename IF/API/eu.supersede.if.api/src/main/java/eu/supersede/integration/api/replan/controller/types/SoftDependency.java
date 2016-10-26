package eu.supersede.integration.api.replan.controller.types;

public class SoftDependency extends ReplanIdentifiableObject{
	SoftDependencyType type;
	Double value;
	public SoftDependencyType getType() {
		return type;
	}
	public void setType(SoftDependencyType type) {
		this.type = type;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
}
