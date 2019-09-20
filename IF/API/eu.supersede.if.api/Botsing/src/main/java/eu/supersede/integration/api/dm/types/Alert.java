package eu.supersede.integration.api.dm.types;

import java.util.List;

public class Alert {
	
	public List<UserRequest> getRequests() {
		return this.requests;
	}


	public void setRequests(List<UserRequest> requests) {
		this.requests = requests;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	public void setTenant(String tenant) {
		this.tenant = tenant;
	}


	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}


	String				id;
	String				applicationId;
	long				timestamp;
	String				tenant;
	List<Condition>		conditions;
	List<UserRequest>	requests;
	
	
	public Alert(	String id, String applicationId, long timestamp, 
					String tenant, List<Condition> conditions, List<UserRequest>	requests ) {
		super();
		this.id = id;
		this.applicationId = applicationId;
		this.timestamp = timestamp;
		this.tenant = tenant;
		this.conditions = conditions;
		this.requests = requests;
	}


	public Alert() {}
	
	
	public String getId() {
		return this.id;
	}


	public String getApplicationId() {
		return this.applicationId;
	}


	public long getTimestamp() {
		return this.timestamp;
	}


	public String getTenant() {
		return this.tenant;
	}


	public List<Condition> getConditions() {
		return this.conditions;
	}


}
