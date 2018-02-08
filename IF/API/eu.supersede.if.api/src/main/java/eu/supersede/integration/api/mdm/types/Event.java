package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Serializable{

    private String eventID;
    private String jsonInstances;
    private String kafkaTopic;
    private String dispatch;
    private String dispatcherStrategy;
    private String dispatcherPath;
    private String event;
    private String platform;
    private String graph;
    List<Attribute> attributes;
    
    
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getJsonInstances() {
		return jsonInstances;
	}
	public void setJsonInstances(String jsonInstances) {
		this.jsonInstances = jsonInstances;
	}
	public String getKafkaTopic() {
		return kafkaTopic;
	}
	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}
	public String getDispatch() {
		return dispatch;
	}
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
	}
	public String getDispatcherStrategy() {
		return dispatcherStrategy;
	}
	public void setDispatcherStrategy(String dispatcherStrategy) {
		this.dispatcherStrategy = dispatcherStrategy;
	}
	public String getDispatcherPath() {
		return dispatcherPath;
	}
	public void setDispatcherPath(String dispatcherPath) {
		this.dispatcherPath = dispatcherPath;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getGraph() {
		return graph;
	}
	public void setGraph(String graph) {
		this.graph = graph;
	}
	public List<Attribute> getAttributes() {
		if (attributes == null)
			attributes = new ArrayList<>();
		return attributes;
	}
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
}
