package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.MessageListener;

import eu.supersede.integration.api.pubsub.iTopicSubscriber;

public interface iAdaptationSubscriber extends iTopicSubscriber{	
	//Adaptation Alert Subscriptor
	void createAdaptationAlertSubscriptionAndKeepListening(MessageListener messageListener) throws Exception;
	void createAdaptationAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
		throws InterruptedException, Exception;
	AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndKeepListening() throws Exception;
	AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
			throws Exception;
}