package eu.supersede.integration.api.datastore.fe.types;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.LabelArrayJsonDeserializer;

public class Profile {
	int profile_id;
	String name;
	List<Label> labels;
	
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Label> getLabels() {
		return labels;
	}
	@JsonDeserialize(using = LabelArrayJsonDeserializer.class)
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
}
