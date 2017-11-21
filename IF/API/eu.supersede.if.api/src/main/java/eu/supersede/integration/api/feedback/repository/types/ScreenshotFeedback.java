package eu.supersede.integration.api.feedback.repository.types;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreenshotFeedback implements FileFeedback, MechanismFeedback {

    protected long id;

    @JsonIgnore

    private Feedback feedback;
    private long mechanismId;
    private String path;
    private  int size;
    private String part;
    private String fileExtension;
    private List<TextAnnotation> textAnnotations;

    @JsonIgnore
    private Mechanism mechanism;

    @Override
    public String toString() {
        return String.format(
                "ScreenshotFeedback[id=%d, feedbackId='%d', mechanismId='%d', path='%s', fileExtension='%s']",
                id, feedback.getId(), mechanismId, path, fileExtension);
    }

    public ScreenshotFeedback() {
    }

    public ScreenshotFeedback(Feedback feedback, long mechanismId, List<TextAnnotation> textAnnotations) {
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
    }

    public ScreenshotFeedback(String part, Feedback feedback, long mechanismId, List<TextAnnotation> textAnnotations) {
        this.part = part;
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
    }

    public ScreenshotFeedback(String path, int size, String part, String fileExtension, Feedback feedback, long mechanismId, List<TextAnnotation> textAnnotations) {
        this.path = path;
        this.size = size;
        this.part = part;
        this.fileExtension = fileExtension;
        this.feedback = feedback;
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
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

    public List<TextAnnotation> getTextAnnotations() {
        return textAnnotations;
    }

    public void setTextAnnotations(List<TextAnnotation> textAnnotations) {
        this.textAnnotations = textAnnotations;
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
