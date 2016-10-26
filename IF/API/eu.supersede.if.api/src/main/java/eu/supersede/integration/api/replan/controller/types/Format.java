package eu.supersede.integration.api.replan.controller.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Format {
	STRING("string"), INTEGER("integer"), NUMBER("number"), DATETIME("date-time");
	private String format;
	private Format(String format){
		this.format = format;
	}

	@Override
	@JsonValue
	public String toString(){
		return format;
	}
}
