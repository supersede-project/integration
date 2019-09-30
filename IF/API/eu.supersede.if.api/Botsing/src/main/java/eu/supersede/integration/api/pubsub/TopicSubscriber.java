package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TopicSubscriber extends TopicMessageAgent implements iTopicSubscriber {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private javax.jms.TopicSubscriber topicSubscriber;
	private TopicSession topicSession;


//	public static void main(String[] args) throws NamingException {
//		iTopicSubscriber subscriber = null;
//		try {
//			subscriber = new TopicSubscriber(SubscriptionTopic.ANALISIS_DM_EVENT_TOPIC);
//			subscriber.openTopicConnection();
//			TextMessageListener messageListener = ((TopicSubscriber)subscriber).new TextMessageListener();
//			subscriber.createTopicSubscriptionAndKeepListening(messageListener);
//			try {
//				while (true) {
//					Thread.sleep(1000); // FIXME Configure sleeping time
//				}
//			} catch (InterruptedException e) {
//				log.error(e.getMessage(), e);
//			}
//			subscriber.closeSubscription();
//			subscriber.closeTopicConnection();
//		} catch (JMSException e) {
//			log.error(e.getMessage(), e);
//		} finally {
//			if (subscriber != null) {
//				try {
//					subscriber.closeTopicConnection();
//				} catch (JMSException e) {
//					throw new RuntimeException("Error in closing topic connection", e);
//				}
//			}
//		}
//	}

	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicSubscriber#closeSubscription()
	 */
	@Override
	public void closeSubscription() throws JMSException {
		topicSubscriber.close();
		topicSession.close();
		topicSubscriber = null;
		topicSession = null;
	}

	public TopicSubscriber(SubscriptionTopic subscriptionTopic,  String platform) throws NamingException {
		super(subscriptionTopic, platform);
	}
	
	public TopicSubscriber(SubscriptionTopic subscriptionTopic) throws NamingException {
		super(subscriptionTopic);
	}

	public TopicSubscriber(SubscriptionTopic subscriptionTopic, boolean openConnection,  String platform)
			throws NamingException, JMSException {
		super(subscriptionTopic, platform);
		if (openConnection)
			openTopicConnection();

	}
	
	public TopicSubscriber(SubscriptionTopic subscriptionTopic, boolean openConnection)
			throws NamingException, JMSException {
		super(subscriptionTopic);
		if (openConnection)
			openTopicConnection();

	}

	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicSubscriber#createTextMessageTopicSubscriptionAndKeepListening()
	 */
	@Override
	public void createTextMessageTopicSubscriptionAndKeepListening() {
		TextMessageListener messageListener = new TextMessageListener();
		createTopicSubscriptionAndKeepListening(messageListener);
	}

	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicSubscriber#createTopicSubscriptionAndKeepListening(javax.jms.MessageListener)
	 */
	@Override
	public void createTopicSubscriptionAndKeepListening(MessageListener messageListener) {
		try {
			if (topicSession != null && topicSubscriber != null) {
				log.debug("Closing Topic Connection for Topic " + subscriptionTopic.getTopic());
				closeSubscription();
			}

			log.debug("Creating Topic Connection for Topic " + subscriptionTopic.getTopic());
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
			// start the connection
			topicConnection.start();

			// create a topic subscriber
			topicSubscriber = topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(messageListener);
		} catch (JMSException e) {
			log.error(e.getMessage(), e);
		} catch (NamingException e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicSubscriber#createTextMessageTopicSubscriptionAndCloseAfterAWhile(int)
	 */
	@Override
	public void createTextMessageTopicSubscriptionAndCloseAfterAWhile(int timeInMilliseconds) throws InterruptedException {
		TextMessageListener messageListener = new TextMessageListener();
		createTopicSubscriptionAndCloseAfterAWhile(messageListener, timeInMilliseconds);
	}

	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicSubscriber#createTopicSubscriptionAndCloseAfterAWhile(javax.jms.MessageListener, int)
	 */
	@Override
	public void createTopicSubscriptionAndCloseAfterAWhile(MessageListener messageListener, int timeInMilliseconds)
			throws InterruptedException {
		try {
			if (topicSession != null && topicSubscriber != null) {
				log.debug("Closing Topic Connection for Topic " + subscriptionTopic.getTopic());
				closeSubscription();
			}

			log.debug("Creating Topic Connection for Topic " + subscriptionTopic.getTopic());
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
			// start the connection
			topicConnection.start();

			// create a topic subscriber
			topicSubscriber = topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(messageListener);

			Thread.sleep(timeInMilliseconds);

			topicSubscriber.close();
			topicSession.close();
		} catch (JMSException e) {
			log.error(e.getMessage(), e);
		} catch (NamingException e) {
			log.error(e.getMessage(), e);
		}
	}

	protected class TextMessageListener implements MessageListener {
		public void onMessage(Message message) {
			try {
				log.debug("Got the Message : " + ((TextMessage) message).getText());
			} catch (JMSException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}