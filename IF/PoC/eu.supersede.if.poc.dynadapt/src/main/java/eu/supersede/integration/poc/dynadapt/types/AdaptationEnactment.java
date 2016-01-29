package eu.supersede.integration.poc.dynadapt.types;

import java.util.Date;
import java.util.UUID;

public class AdaptationEnactment {
	
	private UUID decisionId;
	private Date enactmentTimestamp;
	private boolean enactmentResult;
	private String failureReason;
	
	
	public UUID getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(UUID decisionId) {
		this.decisionId = decisionId;
	}

	public Date getEnactmentTimestamp() {
		return enactmentTimestamp;
	}

	public void setEnactmentTimestamp(Date enactmentTimestamp) {
		this.enactmentTimestamp = enactmentTimestamp;
	}

	public boolean isEnactmentResult() {
		return enactmentResult;
	}

	public void setEnactmentResult(boolean enactmentResult) {
		this.enactmentResult = enactmentResult;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	@Override
    public String toString() {
		return "AdaptationDecision{" +
                "id=" + decisionId +
                ", enactmentTimestamp='" + enactmentTimestamp + '\'' +
                ", enactmentResult='" + enactmentResult + '\'' +
                ", failureReason='" + failureReason + '\'' +
                '}';
	}
}
