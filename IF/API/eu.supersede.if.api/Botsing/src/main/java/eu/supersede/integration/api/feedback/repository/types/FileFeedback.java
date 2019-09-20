package eu.supersede.integration.api.feedback.repository.types;


public interface FileFeedback {
    String getPart();
    void setPath(String path);
    void setSize(int size);
    String getFileExtension();
    void setFileExtension(String fileExtension);
}
