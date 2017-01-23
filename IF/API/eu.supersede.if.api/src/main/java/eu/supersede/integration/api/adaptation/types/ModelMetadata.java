package eu.supersede.integration.api.adaptation.types;

import java.util.List;

public class ModelMetadata {
	String sender;
	String timeStamp;
	List<IModel> modelInstances;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public List<IModel> getModelInstances() {
		return modelInstances;
	}
	public void setModelInstances(List<IModel> modelInstances) {
		this.modelInstances = modelInstances;
	}
}
