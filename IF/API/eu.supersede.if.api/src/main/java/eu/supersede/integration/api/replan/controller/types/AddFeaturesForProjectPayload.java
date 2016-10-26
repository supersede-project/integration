package eu.supersede.integration.api.replan.controller.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class AddFeaturesForProjectPayload {
	@JsonProperty ("evaluation_time")
	private String evaluationTime;
	private List<FeatureWP3> features;
	private List<Constraint> constraints;
	
	public AddFeaturesForProjectPayload(){
		features = new ArrayList<>();
		constraints = new ArrayList<>();
	}
	
	public String getEvaluationTime() {
		return evaluationTime;
	}
	public void setEvaluationTime(String evaluationTime) {
		this.evaluationTime = evaluationTime;
	}
	
	public List<FeatureWP3> getFeatures() {
		if (features == null)
			features = new ArrayList<>();
		return features;
	}

	public void setFeatures(List<FeatureWP3> features) {
		this.features = features;
	}
	
	public List<Constraint> getConstraints() {
		if (constraints == null)
			constraints = new ArrayList<>();
		return constraints;
	}

	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
}
