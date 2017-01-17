package eu.supersede.integration.api.pubsub;

public enum SubscriptionTopic {
	ANALISIS_DM_EVOLUTION_EVENT_TOPIC ("analysis.event.dm.evolution.topic"),
	ANALISIS_DM_ADAPTATION_EVENT_TOPIC ("analysis.event.dm.adaptation.topic");
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
