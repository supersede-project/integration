package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;
import javax.jms.MessageListener;

public interface iTopicSubscriber extends iTopicMessageAgent{

	void closeSubscription() throws JMSException;

	void createTextMessageTopicSubscriptionAndKeepListening();

	void createTopicSubscriptionAndKeepListening(MessageListener messageListener);

	void createTextMessageTopicSubscriptionAndCloseAfterAWhile(int timeInMilliseconds) throws InterruptedException;

	void createTopicSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
			throws InterruptedException;

}