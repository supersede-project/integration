package eu.supersede.integration.api.mdm.types;
/**
 * Created by snadal on 20/01/17.
 */
public enum PredicatesTypes {
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
