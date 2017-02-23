package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import eu.supersede.integration.api.adaptation.types.Alert;
import eu.supersede.integration.api.json.JsonUtils;

public class AdaptationAlertMessageListener implements MessageListener{
	private static final Logger log = Logger.getLogger(AdaptationAlertMessageListener.class);
	private Alert alert;
	private boolean messageReceived = false;
	
	public void onMessage(Message message) {
		try {
			String json = ((TextMessage) message).getText();
			log.debug("Got the Json Message : " + json);
			this.alert = JsonUtils.deserializeJsonStringAsObject(json, Alert.class);
			messageReceived = true;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 
	}
	
	public Alert getAlert (){
		return this.alert;
	}
	
	public boolean isMessageReceived (){
		return this.messageReceived;
	}
	
	public void resetMessageReceived(){
		this.messageReceived = false;
	}
}
