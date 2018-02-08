package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

public class ActionParameter implements Serializable{
	private String attribute;
	private CER_Event event;
	
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public CER_Event getEvent() {
		return event;
	}
	public void setEvent(CER_Event event) {
		this.event = event;
	}
}


