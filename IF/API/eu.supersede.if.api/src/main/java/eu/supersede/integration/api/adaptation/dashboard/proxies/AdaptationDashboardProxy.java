package eu.supersede.integration.api.adaptation.dashboard.proxies;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.adaptation.dashboad.types.Adaptation;
import eu.supersede.integration.api.fe.FrontendAuthentication;
import eu.supersede.integration.api.fe.FrontendSession;
import eu.supersede.integration.api.fe.IFErrorHandler;
import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

	public class AdaptationDashboardProxy <T, S> extends IFServiceProxy<T, S> implements IAdaptationDashboard {
		private final Logger log = LoggerFactory.getLogger(this.getClass());
		private final static String SUPERSEDE_ADAPTATION_DASHBOARD_ENDPOINT = 
			IntegrationProperty.getProperty("adaptation.dashboard.endpoint");
		private FrontendSession feSession = null;
		private FrontendAuthentication feAuthentication = null;
		
		
		public AdaptationDashboardProxy(String user, String password, String tenant) throws Exception{
			messageClient.setErrorHandler(new IFErrorHandler());
			feAuthentication = new FrontendAuthentication<>();
			feSession = feAuthentication.login(user, password, tenant);
		}

		@Override
		public List<Adaptation> getAllAdaptations() throws Exception{
			URI uri = new URI (SUPERSEDE_ADAPTATION_DASHBOARD_ENDPOINT + "adaptation");
			log.debug("Sending message getAllAdaptations to Adaptation Dashboard at uri " + uri);
			
			return getJSONObjectsListForType (Adaptation[].class, uri, HttpStatus.OK, feSession);
		}

		@Override
		public Adaptation addAdaptation(Adaptation adaptation) throws IOException {
			// TODO Auto-generated method stub
			return null;
		}
}
