package eu.supersede.integration.api.feedback.repository.types;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;

public interface MechanismFeedback {
    public long getMechanismId();
    public void setMechanismId(long mechanismId);

    public Mechanism getMechanism();
    public void setMechanism(Mechanism mechanism);
}
