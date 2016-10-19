package eu.supersede.integration.api.replan.types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;
import eu.supersede.integration.api.json.CustomJsonDateSerializer;

public class Release extends ReplanBaseObject{
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date deadline;
	
	private List<Resource> resources;
	
	public Release()
	{
		resources = new ArrayList<>();
	}
	
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
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
