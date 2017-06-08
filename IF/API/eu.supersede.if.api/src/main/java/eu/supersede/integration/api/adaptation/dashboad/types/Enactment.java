package eu.supersede.integration.api.adaptation.dashboad.types;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.AdaptationDashboardJsonDateSerializer;
import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

public class Enactment {

	private String fc_id;
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = AdaptationDashboardJsonDateSerializer.class)
	private Date enactment_request_time;
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = AdaptationDashboardJsonDateSerializer.class)
	private Date enactment_completion_time;
	private boolean result;
	private Adaptation adaptation;
	
	public Enactment(){}
	
	public String getFc_id() {
		return fc_id;
	}
	
	public void setFc_id(String fc_id) {
		this.fc_id = fc_id;
	}

	public Date getEnactment_request_time() {
		return this.enactment_request_time;
	}

	public void setEnactment_request_time(Date enactment_request_timestamp) {
		this.enactment_request_time = enactment_request_timestamp;
	}

	public Date getEnactment_completion_time() {
		return this.enactment_completion_time;
	}

	public void setEnactment_completion_time(Date enactment_completion_time) {
		this.enactment_completion_time = enactment_completion_time;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Adaptation getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(Adaptation adaptation) {
		this.adaptation = adaptation;
	}
}
