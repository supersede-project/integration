package eu.supersede.integration.api.replan.optimizer.types;

import eu.supersede.integration.api.replan.controller.types.ReplanBaseObject;

public class Skill extends ReplanBaseObject{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
