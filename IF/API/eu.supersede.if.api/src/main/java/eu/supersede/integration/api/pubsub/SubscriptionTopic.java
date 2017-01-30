package eu.supersede.integration.api.pubsub;


public enum SubscriptionTopic {
	ANALISIS_DM_EVOLUTION_EVENT_TOPIC ("analysis.event.dm.evolution.topic", eu.supersede.integration.api.dm.types.Alert.class),
	ANALISIS_DM_ADAPTATION_EVENT_TOPIC ("analysis.event.dm.adaptation.topic", eu.supersede.integration.api.adaptation.types.Alert.class);
	String topic;
	Class messageType;
	
	<T> SubscriptionTopic (String topic, Class<T> messageType){
		this.topic = topic;
		this.messageType = messageType;
	}
	
	@Override
	public String toString(){
		return topic;
	}
	
	public String getTopic(){
		return topic;
	}
	
	public <T> Class<T> getMessageType(){
		return this.messageType;
	}
}
