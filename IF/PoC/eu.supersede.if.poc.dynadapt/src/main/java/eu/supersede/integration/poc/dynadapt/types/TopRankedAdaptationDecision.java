package eu.supersede.integration.poc.dynadapt.types;

import java.util.UUID;

public class TopRankedAdaptationDecision {

	private UUID uuid;
	private String decisionName;
	private String decisionDescription;
	private boolean supervisionRequired;
	private int priority;
	private int status;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getDecisionName() {
		return decisionName;
	}

	public void setDecisionName(String decisionName) {
		this.decisionName = decisionName;
	}

	public String getDecisionDescription() {
		return decisionDescription;
	}

	public void setDecisionDescription(String decisionDescription) {
		this.decisionDescription = decisionDescription;
	}

	public boolean isSupervisionRequired() {
		return supervisionRequired;
	}

	public void setSupervisionRequired(boolean supervisionRequired) {
		this.supervisionRequired = supervisionRequired;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
    public String toString() {
		return "AdaptationDecision{" +
                "uuid=" + uuid +
                ", decisionName='" + decisionName + '\'' +
                ", decisionDescription='" + decisionDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", supervisionRequired='" + supervisionRequired + '\'' +
                ", status='" + status + '\'' +
                '}';
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}