package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;
import javax.jms.MessageListener;

public interface iTopicSubscriber extends iTopicMessageAgent{

	void closeSubscription() throws JMSException;

	void createTextMessageTopicSubscriptionAndKeepListening() throws Exception;

	void createTopicSubscriptionAndKeepListening(MessageListener messageListener) throws Exception;

	void createTextMessageTopicSubscriptionAndCloseAfterAWhile(int timeInMilliseconds) throws Exception;

	void createTopicSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
			throws Exception;

}