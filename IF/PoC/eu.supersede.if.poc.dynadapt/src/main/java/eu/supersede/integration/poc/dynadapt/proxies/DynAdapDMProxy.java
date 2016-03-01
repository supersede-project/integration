package eu.supersede.integration.poc.dynadapt.proxies;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import eu.supersede.integration.poc.dynadapt.services.iDynAdaptDM;
import eu.supersede.integration.poc.dynadapt.types.AdaptationDecision;
import eu.supersede.integration.poc.dynadapt.types.CollectionOfDecisions;
import eu.supersede.integration.properties.IntegrationProperty;
import eu.supersede.integration.rest.client.IFMessageClient;

public class DynAdapDMProxy implements iDynAdaptDM {
	private IFMessageClient messageClient = new IFMessageClient();
	private final static String DM_ENDPOINT = IntegrationProperty.getProperty("dm.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DynAdapDMProxy.class);
	
	//Only returns JSON representation, expressed explicitly
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

	//Only returns XML representation, expressed explicitly
	@Override
	public CollectionOfDecisions getAllAdaptationDecisions(UUID systemId) {
		try {
			URI uri = new URI(DM_ENDPOINT + "allAdaptationDecisions/" + systemId);
			ResponseEntity<CollectionOfDecisions> response = 
					messageClient.getMessage(uri, CollectionOfDecisions.class, MediaType.APPLICATION_XML);
			CollectionOfDecisions decisions = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located " + decisions.getCollection().size() + " decision(s)");
				for (AdaptationDecision decision:decisions.getCollection()){
					log.info("Decision: " + decision.toString());
				}
			} else {
				log.info("There was a problem getting available adaptation decisions");
			}
			return decisions;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//Accepts both JSON and XML representations (client implemented for JSON)
	@Override
	public AdaptationDecision getTopRankedAdaptationDecision(UUID systemId) {
		try {
			URI uri = new URI(DM_ENDPOINT + "topRankedAdaptationDecision/" + systemId);
			ResponseEntity<AdaptationDecision> response = messageClient.getMessage(uri, AdaptationDecision.class);
			AdaptationDecision decision = response.getBody();
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				log.info("Located decision: " + decision);
			} else {
				log.info("There was a problem getting top ranked adaptation decision");
			}
			return decision;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
