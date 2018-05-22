package eu.supersede.integration.api.adaptation.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tenant {
	ATOS ("atos"), SIEMENS("siemens"), SENERCON ("senercon"), FBK ("fbk"), REVIEW ("review"), SUPERSEDE ("supersede");
	private String id;
	
	Tenant(String id){
		this.id = id;
	}
	
	@Override
	@JsonValue
	public String toString(){
		return this.id;
	}
	
	public String getId(){
		return this.id;
	}
	
}
