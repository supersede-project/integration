package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

/**
 * Created by snadal on 20/01/17.
 */
public enum OperatorTypes implements Serializable{
    VALUE("Value"),
    FEEDBACK_CLASSIFIER_LABEL("Feedback Classifier Label"),
    FEEDBACK_CLASSIFIER_ACCURACY("Feedback Classifier Accuracy"),
    OVERALL_SENTIMENT("Overall Sentiment"),
    POSITIVE_SENTIMENT("Positive Sentiment"),
    NEGATIVE_SENTIMENT("Negative Sentiment"),
    FEATURE_EXTRACTION("Extract Features (Topics)");

    private String element;

    OperatorTypes(String element) {
            this.element = element;
        }

    public String val() {
            return element;
        }
}
