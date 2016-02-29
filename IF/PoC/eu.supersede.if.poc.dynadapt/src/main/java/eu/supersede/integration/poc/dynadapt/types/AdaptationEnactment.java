package eu.supersede.integration.poc.dynadapt.types;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AdaptationDecision")
public class AdaptationEnactment {
	
	private UUID decisionId;
	private Date enactmentTimestamp;
	private boolean enactmentResult;
	private String failureReason;
	
	@XmlElement
	public UUID getDecisionId() {
		return decisionId;
	}

	public void setDecisionId(UUID decisionId) {
		this.decisionId = decisionId;
	}

	@XmlElement
	public Date getEnactmentTimestamp() {
		return enactmentTimestamp;
	}

	public void setEnactmentTimestamp(Date enactmentTimestamp) {
		this.enactmentTimestamp = enactmentTimestamp;
	}

	@XmlElement
	public boolean isEnactmentResult() {
		return enactmentResult;
	}

	public void setEnactmentResult(boolean enactmentResult) {
		this.enactmentResult = enactmentResult;
	}

	@XmlElement
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
