package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.MessageListener;

import eu.supersede.integration.api.pubsub.iTopicSubscriber;

public interface iEvolutionSubscriber extends iTopicSubscriber{
	//Adaptation Alert Subscriptor
	void createEvolutionAlertSubscriptionAndKeepListening(MessageListener messageListener);
	void createEvolutionAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
		throws InterruptedException;
	EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndKeepListening();
	EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
		throws InterruptedException;
}