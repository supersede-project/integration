package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.*;
import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;

public class AdaptationPublisher extends TopicPublisher implements iAdaptationPublisher{

	public AdaptationPublisher() throws NamingException {
		super (SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC);
	}
	
	public AdaptationPublisher(boolean openConnection) throws NamingException, JMSException {
		super (SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC);
		if (openConnection)
			openTopicConnection();
	}

	@Override
	public void publishAdaptationAlertMesssage(Alert alert) throws JMSException, NamingException, JsonProcessingException {
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		// create or use the topic
		System.out.println("Publishing on the Topic " + subscriptionTopic.getTopic());
		Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
		javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);
		String json = JsonUtils.serializeObjectAsJsonString(alert);
		TextMessage textMessage = topicSession.createTextMessage(json);
		topicPublisher.publish(textMessage);
		System.out.println("Publishing adaptation alert message: " + textMessage);
		topicPublisher.close();
		topicSession.close();
	}

}