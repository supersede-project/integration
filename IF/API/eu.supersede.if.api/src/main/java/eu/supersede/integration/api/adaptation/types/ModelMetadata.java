package eu.supersede.integration.api.adaptation.types;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

public class ModelMetadata {
	String sender;
	Date timeStamp;
	List<IModel> modelInstances;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public List<IModel> getModelInstances() {
		return modelInstances;
	}
	public void setModelInstances(List<IModel> modelInstances) {
		this.modelInstances = modelInstances;
	}
}
