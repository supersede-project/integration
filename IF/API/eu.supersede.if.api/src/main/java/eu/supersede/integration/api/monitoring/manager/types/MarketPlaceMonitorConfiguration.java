package eu.supersede.integration.api.monitoring.manager.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketPlaceMonitorConfiguration extends MonitorConfiguration {
	@JsonProperty (value="MarketPlaces")
	private MonitorSpecificConfiguration monitorSpecificConfiguration;
}
