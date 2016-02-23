package eu.supersede.integration.poc.dynadapt.types;

import java.util.UUID;

public class TopRankedAdaptationDecision {

	private UUID uuid;
	private String decisionName;
	private String decisionDescription;
	private boolean supervisionRequired;
	private int priority;
	private int status;
	
	public UUID getId() {
		return uuid;
	}

	public void setId(UUID id) {
		this.uuid = id;
	}

	public String getName() {
		return decisionName;
	}

	public void setName(String name) {
		this.decisionName = name;
	}

	public String getDescription() {
		return decisionDescription;
	}

	public void setDescription(String description) {
		this.decisionDescription = description;
	}

	public boolean isSupervised() {
		return supervisionRequired;
	}

	public void setSupervised(boolean supervised) {
		this.supervisionRequired = supervised;
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
                "id=" + uuid +
                ", name='" + decisionName + '\'' +
                ", description='" + decisionDescription + '\'' +
                ", priority='" + priority + '\'' +
                ", supervised='" + supervisionRequired + '\'' +
                '}';
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}