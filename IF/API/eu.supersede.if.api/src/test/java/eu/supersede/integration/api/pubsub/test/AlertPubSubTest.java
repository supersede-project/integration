package eu.supersede.integration.api.pubsub.test;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.dm.types.Condition;
import eu.supersede.integration.api.dm.types.DataID;
import eu.supersede.integration.api.dm.types.Operator;
import eu.supersede.integration.api.dm.types.RequestClassification;
import eu.supersede.integration.api.dm.types.UserRequest;
import eu.supersede.integration.api.json.JsonUtils;
import eu.supersede.integration.api.pubsub.SubscriptionTopic;
import eu.supersede.integration.api.pubsub.TopicPublisher;
import eu.supersede.integration.api.pubsub.TopicSubscriber;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.federation.SupersedeFederation;

public class AlertPubSubTest implements Runnable {
	private boolean messageReceived = false;
	private boolean subscriptionDone = false;
	private static SupersedeFederation federation = new SupersedeFederation();
	private int num_attempts = 5;

	@Before
	public void setup() throws Exception {
		(new Thread(this)).start();
	}

	@Test
	public void testPublishAlertMessage() throws Exception {
		startPublisher();
	}

	private void startPublisher() throws NamingException, JsonProcessingException, IFException {
		TopicPublisher publisher = null;
		try {
			try {
				while (!subscriptionDone) {
					Thread.sleep(1000); // FIXME Configure sleeping time
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			publisher = new TopicPublisher(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC, true,
					federation.getLocalFederatedSupersedePlatform().getPlatform());
			Alert alert = createAlert();
			String json = JsonUtils.serializeObjectAsJsonString(alert);
			if (json == null) {
				throw new IFException("Alert could not be serialized in JSON");
			}
			publisher.publishTextMesssageInTopic(json);
			try {
				while (!messageReceived && num_attempts-->0) {
					Thread.sleep(1000); // FIXME Configure sleeping time
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (messageReceived == false) {
				throw new RuntimeException("Message was not published"); 
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (publisher != null) {
				try {
					publisher.closeTopicConnection();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startSubscriber() throws Exception {
		TopicSubscriber subscriber = null;
		try {
			subscriber = new TopicSubscriber(SubscriptionTopic.ANALISIS_DM_EVOLUTION_EVENT_TOPIC);
			subscriber.openTopicConnection();
			AlertMessageListener messageListener = new AlertMessageListener();
			subscriber.createTopicSubscriptionAndKeepListening(messageListener);
			subscriptionDone = true;
			try {
				while (!messageReceived) {
					Thread.sleep(1000); // FIXME Configure sleeping time
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			subscriber.closeSubscription();
			
			subscriber.closeTopicConnection();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (subscriber != null) {
				try {
					subscriber.closeTopicConnection();
				} catch (JMSException e) {
					throw new RuntimeException("Error in closing topic connection", e);
				}
			}
		}
	}

	public class AlertMessageListener implements MessageListener {
		private Alert alert;

		public void onMessage(Message message) {
			try {
				String json = ((TextMessage) message).getText();
				System.out.println("Got the Json Message : " + json);
				// TODO Deserialize the message onto an Alert object
				this.alert = JsonUtils.deserializeJsonStringAsObject(json, Alert.class);
				messageReceived = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public Alert getAlert() {
			return this.alert;
		}

	}

	private Alert createAlert() {
		Alert alert = new Alert();

		alert.setId("id1");
		alert.setApplicationId("appId1");
		alert.setTimestamp(1481717773760L);
		alert.setTenant("Delta");

		List<Condition> conditions = new ArrayList<Condition>();
		conditions.add(new Condition(DataID.UNSPECIFIED, Operator.GEq, 10.5));
		alert.setConditions(conditions);

		List<UserRequest> requests = new ArrayList<>();
		String[] feedbackIDs = new String[] { "feedbackId1" };
		String[] features = new String[] { "UI", "backend" };
		requests.add(new UserRequest("id1", RequestClassification.FeatureRequest, 0.5, "description string", 1, 2, 0,
				feedbackIDs, features));
		alert.setRequests(requests);

		return alert;
	}
}
