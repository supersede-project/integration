package eu.supersede.integration.api.feedback.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.List;


public class MonitorTool {

    private long id;

    @NotNull
    private String name;

    private List<MonitorConfiguration> monitorConfigurations;

    @JsonIgnore
    private MonitorType monitorType;

    private String monitorName;

    public MonitorTool() {
    }

    public MonitorTool(String name, List<MonitorConfiguration> monitorConfigurations, MonitorType monitorType, String monitorName) {
        this.name = name;
        this.monitorConfigurations = monitorConfigurations;
        this.monitorType = monitorType;
        this.monitorName = monitorName;
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

    public List<MonitorConfiguration> getMonitorConfigurations() {
        return monitorConfigurations;
    }

    public void setMonitorConfigurations(List<MonitorConfiguration> monitorConfigurations) {
        this.monitorConfigurations = monitorConfigurations;
    }

    public MonitorType getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(MonitorType monitorType) {
        this.monitorType = monitorType;
    }

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }
}
