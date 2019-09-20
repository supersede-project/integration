package eu.supersede.integration.api.feedback.orchestrator.types;

import javax.validation.constraints.NotNull;
import java.util.List;



public class MonitorType {

    private long id;

    @NotNull
    private String name;

    private List<MonitorTool> monitorTools;

    public MonitorType() {
    }

    public MonitorType(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MonitorTool> getMonitorTools() {
        return monitorTools;
    }

    public void setMonitorTools(List<MonitorTool> monitorTools) {
        this.monitorTools = monitorTools;
    }
}
