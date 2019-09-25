package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;

public class EvolutionPublisher extends TopicPublisher implements iEvolutionPublisher{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public EvolutionPublisher(String platform) throws NamingException {
		super (SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC, platform);
	}
	
	public EvolutionPublisher(boolean openConnection, String platform) throws NamingException, JMSException {
		super (SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC, platform);
		if (openConnection)
			openTopicConnection();
	}

	@Override
	public boolean publishEvolutionAlertMesssage(Alert alert) throws JMSException, NamingException, JsonProcessingException {
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		// create or use the topic
		log.debug("Publishing on the Topic " + subscriptionTopic.getTopic());
		Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
		javax.jms.TopicPublisher topicPublisher = topicSession.createPublisher(topic);
		String json = JsonUtils.serializeObjectAsJsonString(alert);
		TextMessage textMessage = topicSession.createTextMessage(json);
		topicPublisher.publish(textMessage);
		log.debug("Publishing evolution alert message: " + textMessage);
		topicPublisher.close();
		topicSession.close();
		return true;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}