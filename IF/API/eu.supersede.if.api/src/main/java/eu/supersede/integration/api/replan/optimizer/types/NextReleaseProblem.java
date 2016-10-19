package eu.supersede.integration.api.replan.optimizer.types;

import java.util.ArrayList;
import java.util.List;

public class NextReleaseProblem {
	
	private Integer nbWeeks;
	private Double hoursPerWeek;
	private List<Feature> features;
	private List<Resource> resources;
	
	public Integer getNbWeeks() {
		return nbWeeks;
	}
	public void setNbWeeks(Integer nbWeeks) {
		this.nbWeeks = nbWeeks;
	}
	public Double getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(Double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public List<Resource> getResources() {
		if (resources == null)
			resources = new ArrayList<>();
		
		return resources;
	}
	public void setResources(List<Resource> features) {
		this.resources = resources;
	}
	
	public List<Feature> getFeatures() {
		if (features == null)
			features = new ArrayList<>();
		
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
