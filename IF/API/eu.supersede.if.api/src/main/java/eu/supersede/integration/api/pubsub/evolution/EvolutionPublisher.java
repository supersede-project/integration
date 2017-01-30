package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.*;
import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;

public class EvolutionPublisher extends TopicPublisher implements iEvolutionPublisher{

	public EvolutionPublisher() throws NamingException {
		super (SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
	}
	
	public EvolutionPublisher(boolean openConnection) throws NamingException, JMSException {
		super (SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
		if (openConnection)
			openTopicConnection();
	}

	@Override
	public void publishEvolutionAlertMesssage(Alert alert) throws JMSException, NamingException, JsonProcessingException {
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		// create or use the topic
		System.out.println("Publishing on the Topic " + subscriptionTopic.getTopic());
		Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
		javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);
		String json = JsonUtils.serializeObjectAsJsonString(alert);
		TextMessage textMessage = topicSession.createTextMessage(json);
		topicPublisher.publish(textMessage);
		System.out.println("Publishing evolution alert message: " + textMessage);
		topicPublisher.close();
		topicSession.close();
	}

}