package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

/**
 * Created by snadal on 20/01/17.
 */
public enum PredicatesTypes implements Serializable{
    GT(">"),
    EQ("="),
    LT("<"),
    CONTAINS("Contains");

    private String element;

    PredicatesTypes(String element) {
            this.element = element;
        }

    public String val() {
            return element;
        }
}
