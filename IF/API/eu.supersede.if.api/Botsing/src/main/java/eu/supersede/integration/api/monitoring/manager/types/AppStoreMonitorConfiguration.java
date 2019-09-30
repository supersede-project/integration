package eu.supersede.integration.api.monitoring.manager.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppStoreMonitorConfiguration extends MonitorSpecificConfiguration{
	String appId;
	
	public String getappId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
}
