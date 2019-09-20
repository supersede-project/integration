package eu.supersede.integration.api.feedback.repository.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;

public class RatingFeedback implements MechanismFeedback {

    private long id;

    @JsonIgnore
    private Feedback feedback;

    private String title;
    private int rating;
    private long mechanismId;

    @JsonIgnore
    private Mechanism mechanism;

    @Override
    public String toString() {
        return String.format(
                "RatingFeedback[id=%d]",
                id);
    }

    public RatingFeedback() {
    }

    public RatingFeedback(Feedback feedback, String title, int rating, long mechanismId) {
        this.feedback = feedback;
        this.title = title;
        this.rating = rating;
        this.mechanismId = mechanismId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
