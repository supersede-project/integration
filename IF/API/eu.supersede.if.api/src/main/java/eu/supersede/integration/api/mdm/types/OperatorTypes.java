package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

/**
 * Created by snadal on 20/01/17.
 */
public enum OperatorTypes implements Serializable{
    VALUE("Value"),
    ENGLISH_FEEDBACK_CLASSIFIER_LABEL("English Feedback Classifier Label"),
    ENGLISH_FEEDBACK_CLASSIFIER_ACCURACY("English Feedback Classifier Accuracy"),
    ENGLISH_OVERALL_SENTIMENT("English Overall Sentiment"),
    ENGLISH_POSITIVE_SENTIMENT("English Positive Sentiment"),
    ENGLISH_NEGATIVE_SENTIMENT("English Negative Sentiment"),
    FEATURE_EXTRACTION("Extract Features (Topics)"),
    AVERAGE_DISK_CONSUMPTION("Average feedback disk consumption today"),
    GERMAN_FEEDBACK_CLASSIFIER_LABEL("German Feedback Classifier Label"),
    GERMAN_FEEDBACK_CLASSIFIER_ACCURACY("German Feedback Classifier Accuracy"),
    GERMAN_OVERALL_SENTIMENT("German Overall Sentiment"),
    GERMAN_POSITIVE_SENTIMENT("German Positive Sentiment"),
    GERMAN_NEGATIVE_SENTIMENT("German Negative Sentiment"),
    ONTOLOGICAL_DISTANCE("Ontological Distance");

    private String element;

    OperatorTypes(String element) {
            this.element = element;
        }

    public String val() {
            return element;
        }
}
