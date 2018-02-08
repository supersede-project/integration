package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

public class CER_Event implements Serializable{
    private String eventID;
    private String jsonInstances;
    private String dispatch;
    private String dispatcherStrategy;
    private String kafkaTopic;
    private String dispatcherPath;
    private String event;
    private String platform;
    private String graph;
    
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
	public String getKafkaTopic() {
		return kafkaTopic;
	}
	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
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
}

