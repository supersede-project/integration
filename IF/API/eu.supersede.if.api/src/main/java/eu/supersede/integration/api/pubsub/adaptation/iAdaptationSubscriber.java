package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.MessageListener;

import eu.supersede.integration.api.pubsub.iTopicSubscriber;

public interface iAdaptationSubscriber extends iTopicSubscriber{	
	//Adaptation Alert Subscriptor
	void createAdaptationAlertSubscriptionAndKeepListening(MessageListener messageListener);
	void createAdaptationAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
		throws InterruptedException;
	AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndKeepListening();
	AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
			throws InterruptedException;
}