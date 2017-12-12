package eu.supersede.integration.api.feedback.repository.types;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;

import javax.persistence.*;



@JsonIgnoreProperties(ignoreUnknown = true)
public class AudioFeedback implements FileFeedback, MechanismFeedback {

    protected long id;

    @JsonIgnore
    private Feedback feedback;
    private long mechanismId;
    private int duration;
    private String path;
    private  int size;
    private String part;
    private String fileExtension;

    @JsonIgnore
    private Mechanism mechanism;

    @Override
    public String toString() {
        return String.format(
                "AudioFeedback[id=%d, feedbackId='%d']",
                id, feedback.getId());
    }

    public AudioFeedback() {
    }

    public AudioFeedback(Feedback feedback, long mechanismId, int duration) {
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.duration = duration;
    }

    public AudioFeedback(String path, int size, String part, String fileExtension, Feedback feedback, long mechanismId, int duration) {
        this.path = path;
        this.size = size;
        this.part = part;
        this.fileExtension = fileExtension;
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.duration = duration;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
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
