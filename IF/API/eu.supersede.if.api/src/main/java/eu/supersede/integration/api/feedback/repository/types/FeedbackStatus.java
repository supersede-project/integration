package eu.supersede.integration.api.feedback.repository.types;

public class FeedbackStatus {
	private String statusType;
	private int id;
	
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
