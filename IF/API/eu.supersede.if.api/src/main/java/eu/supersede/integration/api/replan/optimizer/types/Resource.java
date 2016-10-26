package eu.supersede.integration.api.replan.optimizer.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.supersede.integration.api.replan.controller.types.ReplanBaseObject;

public class Resource extends ReplanBaseObject{
	@JsonProperty ("weekAvailability")
	private Double availability;
	private List<Skill> skills;
	
	public Resource()
	{
		skills = new ArrayList<>();
	}
	
	public Double getAvailability() {
		return availability;
	}
	public void setAvailability(Double availability) {
		this.availability = availability;
	}
	public List<Skill> getSkills() {
		if (skills == null)
			skills = new ArrayList<>();
		
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}
