package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

/**
 * Created by snadal on 20/01/17.
 */
public enum ActionTypes implements Serializable{
    ALERT_EVOLUTION("Software Evolution Alert"),
    ALERT_DYNAMIC_ADAPTATION("Dynamic Adaptation Alert"),
    ALERT_MONITOR_DETERMINISTIC_RECONFIGURATION("Monitors Deterministic Reconfiguration Alert"),
    ALERT_MONITOR_NON_DETERMINISTIC_RECONFIGURATION("Monitors Non-deterministic Reconfiguration Alert"),
    ALERT_FEEDBACK_RECONFIGURATION("Feedback Reconfiguration Alert");

    private String element;

    ActionTypes(String element) {
            this.element = element;
        }

    public String val() {
            return element;
        }
}
