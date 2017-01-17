package eu.supersede.integration.api.pubsub.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;
import eu.supersede.integration.api.pubsub.TopicSubscriber;
import eu.supersede.integration.api.pubsub.iTopicPublisher;

public class PubSubTest implements Runnable{
	private boolean messageReceived = false;
	
	@Before
    public void setup() throws Exception {
		(new Thread(new PubSubTest())).start();
    }

    @Test
    public void testPublishTextMessage() throws Exception{
    	startPublisher();
    }

	private void startPublisher() throws NamingException {
		TopicSubscriber subscriber = null;
		try {
			iTopicPublisher publisher = new TopicPublisher(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC, true);
			publisher.publishTextMesssageInTopic("Analysis event for DM: detected memory leak in managed system");
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (subscriber != null){
				try {
					subscriber.closeTopicConnection();
				} catch (JMSException e) {
					throw new RuntimeException("Error in closing topic connection", e);
				}
			}
		}
	}

	@Override
	public void run() {
		try {
			// Invoking Subscriber
			startSubscriber();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void startSubscriber() throws NamingException {
		TopicSubscriber subscriber = null;
		try {
			subscriber = new TopicSubscriber(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
			subscriber.openTopicConnection();
			TextMessageListener messageListener = new TextMessageListener();
			subscriber.createTopicSubscriptionAndKeepListening (messageListener);
			try {
				while (!messageReceived) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			subscriber.closeSubscription();
			subscriber.closeTopicConnection();
		} catch (JMSException e) {
			e.printStackTrace();
		}finally{
			if (subscriber != null){
				try {
					subscriber.closeTopicConnection();
				} catch (JMSException e) {
					throw new RuntimeException("Error in closing topic connection", e);
				}
			}
		}
	}
	
	public class TextMessageListener implements MessageListener {
		public void onMessage(Message message) {
			try {
				System.out.println("Got the Message : " + ((TextMessage) message).getText());
				messageReceived = true;
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
