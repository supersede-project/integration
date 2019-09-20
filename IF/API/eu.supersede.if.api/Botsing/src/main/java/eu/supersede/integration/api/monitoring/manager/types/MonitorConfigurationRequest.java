package eu.supersede.integration.api.monitoring.manager.types;

public interface MonitorConfigurationRequest {
	public void setId(Integer id);
	public Integer getId();
	public MonitorSpecificConfiguration getConfiguration();
}
