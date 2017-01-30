package eu.supersede.integration.api.pubsub.adaptation;

import javax.jms.JMSException;
import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.pubsub.iTopicMessageAgent;

public interface iAdaptationPublisher extends iTopicMessageAgent{
	void publishAdaptationAlertMesssage(eu.supersede.integration.api.adaptation.types.Alert alert) 
		throws JMSException, NamingException, JsonProcessingException;
}