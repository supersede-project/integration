package eu.supersede.integration.api.replan.controller.types;

public abstract class ReplanIdentifiableObject {
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
