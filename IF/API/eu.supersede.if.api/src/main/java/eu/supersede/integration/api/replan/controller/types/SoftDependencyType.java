package eu.supersede.integration.api.replan.controller.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SoftDependencyType {
	FUNCTIONAL("functional"), COST("cost"), VALUE("value");
	private String type;
	private SoftDependencyType(String type){
		this.type = type;
	}

	@Override
	@JsonValue
	public String toString(){
		return type;
	}
}
