package eu.supersede.integration.api.replan.optimizer.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;
import eu.supersede.integration.api.json.CustomJsonDateSerializer;
import eu.supersede.integration.api.json.ReplanFeatureReleaseJsonDeserializer;
import eu.supersede.integration.api.replan.types.ReplanBaseObject;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Feature extends ReplanBaseObject{
	private Integer code;
	private Double effort;
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date deadline;
	private Priority priority;
	@JsonProperty ("requiredSkills")
	private List<Skill> requiredSkills;
	@JsonProperty ("dependsOn")
	private List<Feature> dependencies;
	@JsonProperty ("release")
	private Integer releaseId;
	private Double setDuration;
	
	public Feature()
	{
		requiredSkills = new ArrayList<>();
		dependencies = new ArrayList<>();
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Double getEffort() {
		return effort;
	}
	public void setEffort(Double effort) {
		this.effort = effort;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public List<Skill> getRequiredSkills() {
		if (requiredSkills == null)
			requiredSkills = new ArrayList<>();
		return requiredSkills;
	}
	public void setRequiredSkills(List<Skill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public List<Feature> getDependencies() {
		if (dependencies == null)
			dependencies = new ArrayList<>();
		return dependencies;
	}

	public void setDependencies(List<Feature> dependencies) {
		this.dependencies = dependencies;
	}

	public Integer getReleaseId() {
		return releaseId;
	}

	@JsonDeserialize(using = ReplanFeatureReleaseJsonDeserializer.class)
	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}

	public void setDuration(Double duration) {
		this.setDuration = duration;
	}
	
	public Double getDuration(){
		return this.setDuration;
	}
	
}
