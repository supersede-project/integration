package eu.supersede.integration.api.mdm.types;

public class SchemaRelease {
	String event;
	String schemaVersion;
	String jsonInstances;
	
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
	
}
