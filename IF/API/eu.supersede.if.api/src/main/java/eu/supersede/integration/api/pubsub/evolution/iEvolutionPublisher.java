package eu.supersede.integration.api.pubsub.evolution;

import javax.jms.JMSException;
import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.supersede.integration.api.pubsub.iTopicMessageAgent;

public interface iEvolutionPublisher extends iTopicMessageAgent{
	boolean publishEvolutionAlertMesssage(eu.supersede.integration.api.dm.types.Alert alert) 
		throws JMSException, NamingException, JsonProcessingException;
}