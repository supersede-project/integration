package eu.supersede.integration.api.adaptation.types;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.ModelRepositoryJsonTimeStampSerializer;

public class ModelUpdateMetadata {
	String sender;
	
	Date timeStamp;
	Map<String, Object> values;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	
	@JsonSerialize(using = ModelRepositoryJsonTimeStampSerializer.class)
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Map<String, Object> getValues() {
		return values;
	}
	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
}
