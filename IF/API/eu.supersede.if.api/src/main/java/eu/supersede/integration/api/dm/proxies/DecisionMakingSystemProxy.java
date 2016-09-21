package eu.supersede.integration.api.dm.proxies;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import eu.supersede.integration.api.dm.types.Alert;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class DecisionMakingSystemProxy <T> extends IFServiceProxy<T> implements IDecisionMakingSystem {
	private final static String SUPERSEDE_DMGAME_ENDPOINT = IntegrationProperty.getProperty("dmgame.endpoint");
	
	@Override
	public boolean notifyAlert(Alert alert)  {
		try {
			Assert.notNull(alert, "Provide a valid alert");
			String suri = SUPERSEDE_DMGAME_ENDPOINT + "alert";
			URI uri = new URI(suri);
			return insertJSONObject(alert, uri, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
