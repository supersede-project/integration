package eu.supersede.integration.api.pubsub;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSession;
import javax.naming.NamingException;

public class TopicSubscriber extends TopicMessageAgent implements iTopicSubscriber {
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
//				e.printStackTrace();
//			}
//			subscriber.closeSubscription();
//			subscriber.closeTopicConnection();
//		} catch (JMSException e) {
//			e.printStackTrace();
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

	public TopicSubscriber(SubscriptionTopic subscriptionTopic) throws NamingException {
		super(subscriptionTopic);
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
				System.out.println("Closing Topic Connection for Topic " + subscriptionTopic.getTopic());
				closeSubscription();
			}

			System.out.println("Creating Topic Connection for Topic " + subscriptionTopic.getTopic());
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			Topic topic = (Topic) ctx.lookup(subscriptionTopic.getTopic());
			// start the connection
			topicConnection.start();

			// create a topic subscriber
			topicSubscriber = topicSession.createSubscriber(topic);
			topicSubscriber.setMessageListener(messageListener);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
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
				System.out.println("Closing Topic Connection for Topic " + subscriptionTopic.getTopic());
				closeSubscription();
			}

			System.out.println("Creating Topic Connection for Topic " + subscriptionTopic.getTopic());
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
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected class TextMessageListener implements MessageListener {
		public void onMessage(Message message) {
			try {
				System.out.println("Got the Message : " + ((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}