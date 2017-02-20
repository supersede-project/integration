package eu.supersede.integration.api.pubsub.test;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
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
import eu.supersede.integration.api.pubsub.evolution.EvolutionAlertMessageListener;
import eu.supersede.integration.api.pubsub.evolution.EvolutionPublisher;
import eu.supersede.integration.api.pubsub.evolution.EvolutionSubscriber;
import eu.supersede.integration.api.pubsub.evolution.iEvolutionPublisher;
import eu.supersede.integration.api.pubsub.evolution.iEvolutionSubscriber;

public class EvolutionAlertPubSubTest implements Runnable{
	private boolean messageReceived = false;
	private boolean subscriptionDone = false;
	
	@Before
    public void setup() throws Exception {
		(new Thread(this)).start();
    }

    @Test
    public void testPublishEvolutionAlertMessage() throws Exception{
    	startPublisher();
    }

	private void startPublisher() throws NamingException, JsonProcessingException {
		iEvolutionPublisher publisher = null;
		try {
			try {
				while (!subscriptionDone) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			publisher = new EvolutionPublisher(true);
			Alert alert = createAlert();
			publisher.publishEvolutionAlertMesssage(alert);
			try {
				while (!messageReceived) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (publisher != null){
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
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private void startSubscriber() throws NamingException {
		iEvolutionSubscriber subscriber = null;
		try {
			subscriber = new EvolutionSubscriber();
			subscriber.openTopicConnection();
			EvolutionAlertMessageListener messageListener 
				= subscriber.createEvolutionAlertSubscriptionAndKeepListening();
			subscriptionDone = true;
			try {
				while (!messageListener.isMessageReceived()) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Received alert with id: " + messageListener.getAlert().getID());
			messageReceived = true;
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

	
	private Alert createAlert() {
		Alert alert = new Alert();
		
		alert.setID("id1");
		alert.setApplicationID("appId1");
		alert.setTimestamp(1481717773760L);
		alert.setTenant("Delta");
		
		List<Condition> conditions = new ArrayList<Condition>();
		conditions.add (new Condition(DataID.UNSPECIFIED, Operator.GEq, 10.5));
		alert.setConditions(conditions);
		
		List<UserRequest> requests = new ArrayList<>();
		String[] feedbackIDs = new String[]{"feedbackId1"};
		String[] features = new String[]{"UI","backend"};
		requests.add(new UserRequest("id1", RequestClassification.FeatureRequest, 
				0.5, "description string", 1, 2, 0, feedbackIDs, features));
		alert.setRequests(requests);
		
		return alert;
	}
}
