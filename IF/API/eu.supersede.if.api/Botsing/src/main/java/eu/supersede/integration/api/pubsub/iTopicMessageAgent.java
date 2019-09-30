package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;

public interface iTopicMessageAgent {

	void openTopicConnection() throws JMSException;

	void closeTopicConnection() throws JMSException;

}