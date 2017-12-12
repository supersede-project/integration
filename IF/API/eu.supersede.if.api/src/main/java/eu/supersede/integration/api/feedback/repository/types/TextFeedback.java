package eu.supersede.integration.api.feedback.repository.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;

public class TextFeedback implements MechanismFeedback {
    private long id;

    @JsonIgnore
    private Feedback feedback;
    private String text;
    private long mechanismId;

    @JsonIgnore
    private Mechanism mechanism;

    public TextFeedback() {

    }

    public TextFeedback(Feedback feedback, String text, long mechanismId) {
        this.feedback = feedback;
        this.text = text;
        this.mechanismId = mechanismId;
    }

    @Override
    public String toString() {
        return String.format(
                "TextFeedback[id=%d, feedbackId='%d', text='%s', mechanismId='%d']",
                id, feedback.getId(), text, mechanismId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getMechanismId() {
        return mechanismId;
    }

    public void setMechanismId(long mechanismId) {
        this.mechanismId = mechanismId;
    }

    @Override
    public Mechanism getMechanism() {
        return mechanism;
    }

    @Override
    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }
}
