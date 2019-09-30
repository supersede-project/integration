package eu.supersede.integration.api.feedback.repository.types;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import eu.supersede.integration.api.feedback.orchestrator.types.Mechanism;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ScreenshotFeedback implements FileFeedback, MechanismFeedback {

    protected long id;
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
                "ScreenshotFeedback[id=%d, mechanismId='%d', path='%s', fileExtension='%s']",
                id, mechanismId, path, fileExtension);
    }

    public ScreenshotFeedback() {
    }

    public ScreenshotFeedback(long mechanismId, List<TextAnnotation> textAnnotations) {
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
    }

    public ScreenshotFeedback(String part, long mechanismId, List<TextAnnotation> textAnnotations) {
        this.part = part;
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
    }

    public ScreenshotFeedback(String path, int size, String part, String fileExtension, long mechanismId, List<TextAnnotation> textAnnotations) {
        this.path = path;
        this.size = size;
        this.part = part;
        this.fileExtension = fileExtension;
        this.mechanismId = mechanismId;
        this.textAnnotations = textAnnotations;
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
