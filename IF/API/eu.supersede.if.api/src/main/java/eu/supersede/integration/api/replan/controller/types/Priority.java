package eu.supersede.integration.api.replan.controller.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
	ONE (1), TWO (2), THREE (3), FOUR (4), FIVE (5);
	private Integer value;
	private Priority(Integer value){
		this.value = value;
	}
	
	public Integer getValue (){
		return value;
	}
	
	@Override
	@JsonValue
	public String toString(){
		return String.valueOf(value);
	}
}
