package eu.supersede.integration.api.pubsub.test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.Test;
import org.mockejb.jms.TextMessageImpl;

import eu.supersede.integration.api.pubsub.evolution.EvolutionAlertMessageListener;

public class EvolutionAlertMessageListenerTest {
	@Test
	public void testParsingAlerts() throws IOException, JMSException{
		EvolutionAlertMessageListener listener = new EvolutionAlertMessageListener();
		//Alert1
		Path path = FileSystems.getDefault().getPath("src/test/resources/json", "alert1.json");
		String json = new String(Files.readAllBytes(path));
		TextMessage message = new TextMessageImpl(json);
		listener.onMessage(message);
		
		//Alert2
		path = FileSystems.getDefault().getPath("src/test/resources/json", "alert2.json");
		json = new String(Files.readAllBytes(path));
		message = new TextMessageImpl(json);
		listener.onMessage(message);
	}
}

