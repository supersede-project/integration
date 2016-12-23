package eu.supersede.integration.api.mdm.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaTopic {
	@JsonProperty ("kafkaTopic")
	String topic;

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}
