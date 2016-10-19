package eu.supersede.integration.api.replan.optimizer.types;

public class PlannedFeature {
	private Double beginHour;
	private Double endHour;
	private Resource resource;
	private Feature feature;
	public Double getBeginHour() {
		return beginHour;
	}
	public void setBeginHour(Double beginHour) {
		this.beginHour = beginHour;
	}
	public Double getEndHour() {
		return endHour;
	}
	public void setEndHour(Double endHour) {
		this.endHour = endHour;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
}
