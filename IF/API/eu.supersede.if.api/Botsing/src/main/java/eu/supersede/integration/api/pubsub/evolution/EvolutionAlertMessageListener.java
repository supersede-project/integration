package eu.supersede.integration.api.pubsub.evolution;

import java.util.LinkedList;
import java.util.Queue;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;

public class EvolutionAlertMessageListener implements MessageListener{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private Queue<Alert> alerts;
	
	public EvolutionAlertMessageListener(){
        alerts = new LinkedList<>();
    }
	
	public void onMessage(Message message) {
		try {
			String json = ((TextMessage) message).getText();
			log.debug("Got the Json Message : " + json);
			alerts.offer(JsonUtils.deserializeJsonStringAsObject(json, Alert.class));
			log.debug("Queue a number of alerts: " + alerts.size());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 
	}
	
	public Alert getNextAlert(){
        return alerts.poll();
    }
	
	public boolean areMessageReceived (){
		return alerts.size() > 0;
	}
}
