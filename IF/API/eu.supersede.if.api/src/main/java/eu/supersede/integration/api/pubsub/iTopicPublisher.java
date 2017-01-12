package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;
import javax.naming.NamingException;

public interface iTopicPublisher extends iTopicMessageAgent{

	void publishTextMesssageInTopic(String message) throws JMSException, NamingException;

}