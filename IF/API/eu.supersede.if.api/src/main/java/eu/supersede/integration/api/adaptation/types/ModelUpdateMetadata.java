package eu.supersede.integration.api.adaptation.types;

import java.util.Map;

public class ModelUpdateMetadata {
	String sender;
	String timeStamp;
	Map<String, String> values;
	
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
	public Map<String, String> getValues() {
		return values;
	}
	public void setValues(Map<String, String> values) {
		this.values = values;
	}
}
