package eu.supersede.integration.api.mdm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Release {
	String event;
	String schemaVersion;
	String jsonInstances;
	String kafkaTopic;
	String releaseID;
	String graph;
	boolean dispatch;
	String dispatcherPath;
	String platform;
	
	public String getKafkaTopic() {
		return kafkaTopic;
	}
	public void setKafkaTopic(String kafkaTopic) {
		this.kafkaTopic = kafkaTopic;
	}
	public String getReleaseID() {
		return releaseID;
	}
	public void setReleaseID(String releaseID) {
		this.releaseID = releaseID;
	}
	public String getGraph() {
		return graph;
	}
	public void setGraph(String graph) {
		this.graph = graph;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public String getJsonInstances() {
		return jsonInstances;
	}
	public void setJsonInstances(String jsonInstances) {
		this.jsonInstances = jsonInstances;
	}
	public boolean isDispatch() {
		return dispatch;
	}
	public void setDispatch(boolean dispatch) {
		this.dispatch = dispatch;
	}
	public String getDispatcherPath() {
		return dispatcherPath;
	}
	public void setDispatcherPath(String dispatcherPath) {
		this.dispatcherPath = dispatcherPath;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}
