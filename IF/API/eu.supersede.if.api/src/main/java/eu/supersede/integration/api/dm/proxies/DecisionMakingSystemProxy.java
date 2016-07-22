package eu.supersede.integration.api.dm.proxies;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class DecisionMakingSystemProxy implements IDecisionMakingSystem {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String SUPERSEDE_DMGAME_ENDPOINT = IntegrationProperty.getProperty("dmgame.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DecisionMakingSystemProxy.class);
	
	@Override
	public boolean notifyAlert(Alert alert) {
		boolean result = false;
		try {
			Assert.notNull(alert, "Provide a valid alert");
			String suri = SUPERSEDE_DMGAME_ENDPOINT + "alert";
			URI uri = new URI(suri);
			AuthorizationToken authenticationToken = null;
			ResponseEntity<Boolean> response = 
					messageClient.postJsonMessage(alert, uri, Boolean.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				result = true;
				log.info("Successfully sent alert " + alert.getId());
			} else {
				log.info("There was a problem sending alert " + alert.getId());
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
