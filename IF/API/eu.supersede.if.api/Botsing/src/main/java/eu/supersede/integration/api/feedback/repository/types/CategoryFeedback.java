package eu.supersede.integration.api.feedback.repository.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;


public class CategoryFeedback implements MechanismFeedback {

    private long id;

    @JsonIgnore
    private Feedback feedback;
    private long mechanismId;
    private Long parameterId;
    private String text;

    @JsonIgnore
    private Mechanism mechanism;

    @JsonIgnore
    private String categoryValue;

    @Override
    public String toString() {
        return String.format(
                "CategoryFeedback[id=%d]",
                id);
    }

    public CategoryFeedback() {
    }

    public CategoryFeedback(Feedback feedback, long mechanismId, Long parameterId, String text) {
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.parameterId = parameterId;
        this.text = text;
    }

    public CategoryFeedback(Feedback feedback, long mechanismId, String text) {
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.text = text;
    }

    public CategoryFeedback(Feedback feedback, long mechanismId, Long parameterId) {
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.parameterId = parameterId;
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

    public long getMechanismId() {
        return mechanismId;
    }

    public void setMechanismId(long mechanismId) {
        this.mechanismId = mechanismId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Mechanism getMechanism() {
        return mechanism;
    }

    @Override
    public void setMechanism(Mechanism mechanism) {
        this.mechanism = mechanism;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }
}
