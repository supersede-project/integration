package eu.supersede.integration.api.adaptation.types;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;
import eu.supersede.integration.api.json.ModelRepositoryJsonDateSerializer;

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
	@JsonSerialize(using = ModelRepositoryJsonDateSerializer.class)
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
