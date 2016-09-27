package eu.supersede.integration.api.replan.types;

import java.util.ArrayList;
import java.util.List;

public class Resource extends ReplanBaseObject{
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
			return new ArrayList<>();
		
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}
