package eu.supersede.integration.api.replan.optimizer.types;

public enum AlgorithmType {
    NSGAII("NSGA-II"), MOCell("MOCell"), SPEA2("SPEA2"), PESA2("PESA2"), SMSEMOA("SMSEMOA");

    private String name;

    AlgorithmType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static AlgorithmType fromName(String name) {
        switch (name) {
            case "NSGA-II":
                return NSGAII;
            case "MOCell":
                return MOCell;
            case "SPEA2":
                return SPEA2;
            case "PESA2":
                return PESA2;
            case "SMSEMOA":
                return SMSEMOA;
        }
        return null;
    }
}