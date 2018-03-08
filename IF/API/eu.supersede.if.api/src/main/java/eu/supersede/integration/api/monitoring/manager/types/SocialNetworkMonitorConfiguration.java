package eu.supersede.integration.api.monitoring.manager.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocialNetworkMonitorConfiguration extends MonitorConfiguration {
	@JsonProperty (value="SocialNetworks")
	private MonitorSpecificConfiguration monitorSpecificConfiguration;
}
