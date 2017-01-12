package eu.supersede.integration.api.pubsub;

public enum SubscriptionTopic {
	ANALISIS_DM_EVENT_TOPIC ("analysis.event.dm.topic");
	String topic;
	SubscriptionTopic (String topic){
		this.topic = topic;
	}
	
	@Override
	public String toString(){
		return topic;
	}
	
	public String getTopic(){
		return topic;
	}
}
