package eu.supersede.integration.poc.dynadapt.proxies;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.poc.dynadapt.services.iDynAdaptEnact;
import eu.supersede.integration.poc.dynadapt.types.AdaptationEnactment;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class DynAdapEnactProxy implements iDynAdaptEnact {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String ENACT_ENDPOINT = IntegrationProperty.getProperty("enactment.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DynAdapEnactProxy.class);
	
	@Override
	public ResponseEntity<AdaptationEnactment> triggerEnactmentForAdaptationDecision(UUID decisionId, UUID systemId) {
		try {
			URI uri = new URI(ENACT_ENDPOINT + "triggerAdaptationDecision/" + 
					decisionId +"/" + systemId);
			//Note, object whose String serialization is valid Json must be sent to postJsonMessage
			ResponseEntity<AdaptationEnactment> response = messageClient.postJsonMessage("{}", uri, AdaptationEnactment.class);
			AdaptationEnactment ae = response.getBody();
			boolean enactment = ae.isEnactmentResult();
			if (response.getStatusCode().equals(HttpStatus.CREATED) && enactment) {
				log.info("Successful enactment of decision: " + decisionId + ". Enactment: " + ae.toString());
			} else {
				log.info("There was a problem enacting decision: " + decisionId + ". Enactment: " + ae.toString());
			}
			return response;
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}

}
