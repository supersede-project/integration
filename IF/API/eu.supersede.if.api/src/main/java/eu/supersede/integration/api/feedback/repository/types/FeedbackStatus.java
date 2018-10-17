package eu.supersede.integration.api.feedback.repository.types;

public class FeedbackStatus {
	private String statusType;
	private Integer id;

	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
