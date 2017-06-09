package eu.supersede.integration.api.adaptation.dashboad.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Action {
	private String fc_id;
	@JsonProperty ("ac_id")
	private String action_id;
	private String name;
	private String description;
	private boolean enabled;
	private Adaptation adaptation;
	
	public Action(){}
	
	public String getFc_id() {
		return fc_id;
	}

	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}

	public String getAction_id() {
		return action_id;
	}

	public void setAction_id(String action_id) {
		this.action_id = action_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Adaptation getAdaptation() {
		return adaptation;
	}
	
	public void setAdaptation(Adaptation adaptation) {
		this.adaptation = adaptation;
	}
}
