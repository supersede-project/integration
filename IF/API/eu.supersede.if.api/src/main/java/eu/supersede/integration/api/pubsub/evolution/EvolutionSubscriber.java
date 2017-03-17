package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TopicSession;
import javax.naming.NamingException;

import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicSubscriber;

public class EvolutionSubscriber extends TopicSubscriber implements iEvolutionSubscriber {

	public EvolutionSubscriber() throws NamingException {
		super(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
	}

	public EvolutionSubscriber(boolean openConnection)
			throws NamingException, JMSException {
		super(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
		if (openConnection)
			openTopicConnection();

	}

	@Override
	public void createEvolutionAlertSubscriptionAndKeepListening(MessageListener messageListener) {
		createTopicSubscriptionAndKeepListening (messageListener);
	}

	@Override
	public void createEvolutionAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener,
			int timeInMilliseconds) throws InterruptedException {
		createTopicSubscriptionAndCloseAfterAWhile(messageListener, timeInMilliseconds);
	}

	@Override
	public EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndKeepListening() {
		EvolutionAlertMessageListener messageListener = new EvolutionAlertMessageListener();
		createTopicSubscriptionAndKeepListening(messageListener);
		return messageListener;
	}

	@Override
	public EvolutionAlertMessageListener createEvolutionAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
			throws InterruptedException {
		EvolutionAlertMessageListener messageListener = new EvolutionAlertMessageListener();
		createTopicSubscriptionAndCloseAfterAWhile(messageListener, timeInMilliseconds);
		return messageListener;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}