package eu.supersede.integration.api.pubsub.test;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.adaptation.types.Condition;
import eu.supersede.integration.api.adaptation.types.DataID;
import eu.supersede.integration.api.adaptation.types.ModelSystem;
import eu.supersede.integration.api.adaptation.types.Operator;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationAlertMessageListener;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.AdaptationSubscriber;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationPublisher;
import eu.supersede.integration.api.pubsub.adaptation.iAdaptationSubscriber;
import eu.supersede.integration.exception.IFException;
import eu.supersede.integration.federation.SupersedeFederation;

public class AdaptationAlertPubSubTest implements Runnable{
	private boolean messageReceived = false;
	private boolean subscriptionDone = false;
	private static  SupersedeFederation federation = new SupersedeFederation();
	
	@Before
    public void setup() throws Exception {
		(new Thread(this)).start();
    }

    @Test
    public void testPublishAdaptionAlertMessage() throws Exception{
    	startPublisher();
    }

	private void startPublisher() throws NamingException, JsonProcessingException {
		iAdaptationPublisher publisher = null;
		try {
			try {
				while (!subscriptionDone) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			publisher = new AdaptationPublisher(true, federation.getLocalFederatedSupersedePlatform().getPlatform());
			Alert alert = createAlert();
			publisher.publishAdaptationAlertMesssage(alert);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startSubscriber() throws Exception {
		iAdaptationSubscriber subscriber = null;
		try {
			subscriber = new AdaptationSubscriber();
			subscriber.openTopicConnection();
			AdaptationAlertMessageListener messageListener 
				= subscriber.createAdaptationAlertSubscriptionAndKeepListening();
			subscriptionDone = true;
			try {
				while (!messageListener.areMessageReceived()) {
					Thread.sleep(1000); //FIXME Configure sleeping time
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Alert alert = messageListener.getNextAlert();
			if (alert == null) {
				throw new IFException ("Alert not received");
			}
			System.out.println("Received alert: " + alert);
			messageReceived = true;
			subscriber.closeSubscription();
			subscriber.closeTopicConnection();
		} catch (JMSException e) {
			e.printStackTrace();
			throw e;
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
		
		alert.setId("id1");
		alert.setApplicationId("appId1");
		alert.setTimestamp(1481717773760L);
		alert.setTenant(ModelSystem.Atos);
		
		List<Condition> conditions = new ArrayList<Condition>();
		DataID dataId = new DataID();
		dataId.setNameComponent("CMS");
		dataId.setNameQualityMonitored("cpu_usage");
		conditions.add (new Condition(dataId, Operator.GEq, 10.5));
		alert.setConditions(conditions);
		
		return alert;
	}
}
