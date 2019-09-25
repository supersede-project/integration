package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.MessageListener;

import eu.supersede.integration.api.pubsub.iTopicSubscriber;

public interface iEvolutionSubscriber extends iTopicSubscriber{
	//Adaptation Alert Subscriptor
	void createEvolutionAlertSubscriptionAndKeepListening(MessageListener messageListener) throws Exception;
	void createEvolutionAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
		throws Exception;
	EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndKeepListening() throws Exception;
	EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
		throws Exception;
}