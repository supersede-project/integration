package eu.supersede.integration.api.replan.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

public class Plan extends ReplanIdentifiableObject{
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonProperty ("created_at")
	private Date creationDate;
	@JsonProperty ("release_id")
	private Integer releaseId;
	private List<Job> jobs;
	
	public Plan()
	{
		jobs = new ArrayList<>();
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(Integer releaseId) {
		this.releaseId = releaseId;
	}
	public List<Job> getJobs() {
		if (jobs == null)
			jobs = new ArrayList<>();
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

}
