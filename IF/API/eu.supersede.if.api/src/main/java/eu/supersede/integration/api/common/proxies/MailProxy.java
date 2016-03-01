package eu.supersede.integration.api.common.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.api.common.types.Email;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class MailProxy implements iMail {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String MAIL_ENDPOINT = IntegrationProperty.getProperty("mail.endpoint");
	private static final Logger log = LoggerFactory.getLogger(MailProxy.class);
	
	@Override
	public void sendEmail(Email email) throws Exception{

		URI uri = new URI(MAIL_ENDPOINT + "send");
		EmailPayload payload = new EmailPayload();
		payload.setEmail(email);
		ResponseEntity<String> response = messageClient.postJsonMessage(payload, uri);
		if (!response.getStatusCode().equals(HttpStatus.ACCEPTED)) {
			log.error("There was a problem sending the email");
			throw new Exception ("Send Email: There was a problem sending the email");
		}
	
	}
}

class EmailPayload{
	Email email;

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
}
