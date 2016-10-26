package eu.supersede.integration.api.replan.controller.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;
import eu.supersede.integration.api.json.CustomJsonDateSerializer;
import eu.supersede.integration.api.json.ReplanFeatureReleaseJsonDeserializer;

public class FeatureWP3 extends ReplanBaseObject{
	private Double effort;
	private Priority priority;
	private List<Property> properties;
	
	@JsonProperty ("hard_dependencies")
	private List<Integer> hardDependencies;
	
	@JsonProperty ("soft_dependencies")
	private List<SoftDependency> softDependencies;
	
	private String arguments;
	
	public FeatureWP3(){
		properties = new ArrayList<>();
		hardDependencies = new ArrayList<>();
		softDependencies = new ArrayList<>();
	}
	
	public Double getEffort() {
		return effort;
	}
	public void setEffort(Double effort) {
		this.effort = effort;
	}
	
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public List<Property> getProperties() {
		if (properties == null)
			properties = new ArrayList<>();
		return properties;
	}
	public void setRequiredSkills(List<Property> properties) {
		this.properties = properties;
	}

	public List<Integer> getHardDependencies() {
		if (hardDependencies == null)
			hardDependencies = new ArrayList<>();
		return hardDependencies;
	}

	public void setHardDependencies(List<Integer> hardDependencies) {
		this.hardDependencies = hardDependencies;
	}
	
	public List<SoftDependency> getSoftDependencies() {
		if (softDependencies == null)
			softDependencies = new ArrayList<>();
		return softDependencies;
	}

	public void setSoftDependencies(List<SoftDependency> softDependencies) {
		this.softDependencies = softDependencies;
	}

	public String getArguments() {
		return arguments;
	}

	public void setArguments(String arguments) {
		this.arguments = arguments;
	}
	
}
