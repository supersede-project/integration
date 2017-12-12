package eu.supersede.integration.api.monitoring.manager.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QoSMonitorConfiguration extends MonitorConfiguration {
	@JsonProperty (value="QoS")
	private MonitorSpecificConfiguration monitorSpecificConfiguration;
}
