package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.naming.NamingException;

import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicSubscriber;

public class AdaptationSubscriber extends TopicSubscriber implements iAdaptationSubscriber {

	public AdaptationSubscriber(String platform) throws NamingException {
		super(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC, platform);
	}
	
	public AdaptationSubscriber() throws NamingException {
		super(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC);
	}

	public AdaptationSubscriber(boolean openConnection, String platform)
			throws NamingException, JMSException {
		super(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC, platform);
		if (openConnection)
			openTopicConnection();
	}
	
	public AdaptationSubscriber(boolean openConnection)
			throws NamingException, JMSException {
		super(SubscriptionTopic.ANALISIS_DM_ADAPTATION_EVENT_TOPIC);
		if (openConnection)
			openTopicConnection();
	}

	@Override
	public void createAdaptationAlertSubscriptionAndKeepListening(MessageListener messageListener) {
		createTopicSubscriptionAndKeepListening (messageListener);
	}

	@Override
	public void createAdaptationAlertSubscriptionAndCloseAfterAWhile(MessageListener messageListener,
			int timeInMilliseconds) throws InterruptedException {
		createTopicSubscriptionAndCloseAfterAWhile(messageListener, timeInMilliseconds);
	}

	@Override
	public AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndKeepListening() {
		AdaptationAlertMessageListener messageListener = new AdaptationAlertMessageListener();
		createTopicSubscriptionAndKeepListening(messageListener);
		return messageListener;
	}

	@Override
	public AdaptationAlertMessageListener createAdaptationAlertSubscriptionAndCloseAfterAWhile(int timeInMilliseconds)
			throws InterruptedException {
		AdaptationAlertMessageListener messageListener = new AdaptationAlertMessageListener();
		createTopicSubscriptionAndCloseAfterAWhile(messageListener, timeInMilliseconds);
		return messageListener;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}