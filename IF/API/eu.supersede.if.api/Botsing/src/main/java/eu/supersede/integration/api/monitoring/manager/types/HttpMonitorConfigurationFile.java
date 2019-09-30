package eu.supersede.integration.api.monitoring.manager.types;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpMonitorConfigurationFile extends MonitorSpecificConfiguration{
	
	String server;
	String protocol;
	Integer textContentSize;
	List<String> listOfEvents;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public Integer getTextContentSize() {
		return textContentSize;
	}
	public void setTextContentSize(Integer textContentSize) {
		this.textContentSize = textContentSize;
	}
	
	@JsonProperty(value = "ListOfEvents")
	public List<String> getListOfEvents() {
		if (listOfEvents == null)
			return new ArrayList<>();
		return listOfEvents;
	}
	public void setListOfEvents(List<String> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}
	
	@JsonIgnore
	public Integer getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(Integer timeSlot) {
		this.timeSlot = timeSlot;
	}

}
