package eu.supersede.integration.poc.dynadapt.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.poc.dynadapt.services.iDynAdaptDM;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class DynAdapDMProxy implements iDynAdaptDM {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String DM_ENDPOINT = IntegrationProperty.getProperty("dm.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DynAdapDMProxy.class);
	
	@Override
	public Collection<AdaptationDecision> getAdaptationDecisions(UUID systemId) {
		try {
			URI uri = new URI(DM_ENDPOINT + "adaptationDecisions/" + systemId);
			ResponseEntity<AdaptationDecision[]> response = messageClient.getMessage(uri, AdaptationDecision[].class);
			AdaptationDecision[] decisions = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + decisions.length + " decision(s)");
				for (AdaptationDecision decision:decisions){
					log.info("Decision: " + decision.toString());
				}
			} else {
				log.info("There was a problem getting available adaptation decisions");
			}
			return (Collection<AdaptationDecision>) Arrays.asList(decisions);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
