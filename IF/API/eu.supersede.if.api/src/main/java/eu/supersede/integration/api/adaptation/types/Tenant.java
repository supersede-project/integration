package eu.supersede.integration.api.adaptation.types;

public enum Tenant {
	ATOS ("atos"), SIEMENS("siemens"), SENERCON ("senercon"), FBK ("fbk"), SUPERSEDE ("supersede");
	private String id;
	
	Tenant(String id){
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
