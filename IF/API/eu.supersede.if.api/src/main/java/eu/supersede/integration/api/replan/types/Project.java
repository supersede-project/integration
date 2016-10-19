package eu.supersede.integration.api.replan.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project extends ReplanBaseObject{
	@JsonProperty ("effort_unit")
	private String effortUnit;
	@JsonProperty ("hours_per_effort_unit")
	private Double hoursPerEffortUnit;
	@JsonProperty ("hours_per_week_and_full_time_resource")
	private Double hoursPerWeekFullTimeResource;
	private List<Resource> resources;
	
	public Project()
	{
		resources = new ArrayList<>();
	}
	
	public String getEffortUnit() {
		return effortUnit;
	}
	public void setEffortUnit(String effortUnit) {
		this.effortUnit = effortUnit;
	}
	public Double getHoursPerEffortUnit() {
		return hoursPerEffortUnit;
	}
	public void setHoursPerEffortUnit(Double hoursPerEffortUnit) {
		this.hoursPerEffortUnit = hoursPerEffortUnit;
	}
	public Double getHoursPerWeekFullTimeResource() {
		return hoursPerWeekFullTimeResource;
	}
	public void setHoursPerWeekFullTimeResource(Double hoursPerWeekFullTimeResource) {
		this.hoursPerWeekFullTimeResource = hoursPerWeekFullTimeResource;
	}
	public List<Resource> getResources() {
		if (resources == null)
			resources = new ArrayList<>();
		
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
}
