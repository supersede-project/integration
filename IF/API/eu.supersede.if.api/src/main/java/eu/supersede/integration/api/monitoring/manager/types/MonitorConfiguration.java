package eu.supersede.integration.api.monitoring.manager.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MonitorConfiguration {
	@JsonProperty (value="SocialNetworks")
	private MonitorSpecificConfiguration monitorSpecificConfiguration;
	public MonitorSpecificConfiguration getMonitorSpecificConfiguration() {
		return monitorSpecificConfiguration;
	}
	public void setMonitorSpecificConfiguration  (MonitorSpecificConfiguration monitorSpecificConfiguration) {
		this.monitorSpecificConfiguration = monitorSpecificConfiguration;
	}
}
