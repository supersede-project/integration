package eu.supersede.integration.api.fe;

import java.net.URI;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClientException;

import eu.supersede.integration.api.proxy.IFServiceProxy;
import eu.supersede.integration.properties.IntegrationProperty;

public class FrontendAuthentication <T, S> extends IFServiceProxy<T, S> implements IFrontend {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final static String SUPERSEDE_FRONTEND_ENDPOINT = 
		IntegrationProperty.getProperty("frontend.endpoint");
	
	public FrontendAuthentication(){
		messageClient.setErrorHandler(new IFErrorHandler());
	}
	
	@Override
	public FrontendSession login(String user, String password, String tenant) throws Exception {
		
		Assert.notNull(user, "Provide a valid user");
		Assert.notNull(password, "Provide a valid password");
		URI uri = new URI (SUPERSEDE_FRONTEND_ENDPOINT + "login");
		log.debug("Sending message login with user: " + user + " for tenant: " + tenant + " to Frontend at uri " + uri);
		
		FrontendSession frontEndSession = new FrontendSession();
		frontEndSession.setTenantId(tenant);
		frontEndSession.setSession(
			getLoginSession(user, password, tenant, uri));
		
		uri = new URI (SUPERSEDE_FRONTEND_ENDPOINT + "user");
		log.debug("Sending message login with user: " + user + " for tenant: " + tenant + " to Frontend at uri " + uri);
		
		frontEndSession.setXsfrToken(
				getXsfrToken(frontEndSession.getSession(), user, password, tenant, uri));
		
		return frontEndSession;
	}
	
	@Override
	public void addRequirement (String requirement, FrontendSession session) throws Exception{
		URI uri = new URI ("http://supersede.es.atos.net:8080/supersede-dm-app/requirement");
		
		insertJSONObject(requirement, uri, HttpStatus.CREATED, session);
	}
	
	
//	public boolean insertJSONObjectWithAuthentication(String json, URI uri, HttpStatus expectedStatus, FrontendSession session) throws Exception {
//		boolean result = false;
//		try {
//			Assert.notNull(json, "Provide a valid json ");
//			Assert.notNull(uri, "Provide a valid uri");
//			ResponseEntity<String> response = 
//					postJsonMessageWithAuthentication(json, uri, String.class, session);
//			if (response.getStatusCode().equals(expectedStatus)) {
//				log.info("Successfully inserted JSON object " + json);
//				result = true;
//			} else {
//				log.info("There was a problem inserting JSON object " + result + " in URI: " + uri);
//			}
//			return result;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			return false;
//		}
//	}
	
	private String getLoginSession(String user, String password, String tenant, URI uri) {
		try {
			//Encode user/password in base64
			String base64 = Base64.getEncoder().encodeToString((user + ":" + password).getBytes("utf-8"));
			ResponseEntity<String> response = sendLoginMessage(uri, base64, tenant, String.class);
			//Get session from headers
			HttpHeaders headers = response.getHeaders();
			List<String> cookies = headers.get(HttpHeaders.SET_COOKIE);
			Optional<String> session_cookie = cookies.stream().filter(cookie->cookie.contains("SESSION")).findFirst();	
			String session = null;
			if (session_cookie.isPresent()){
				session = session_cookie.get().substring(session_cookie.get().indexOf("=") + 1, session_cookie.get().indexOf(";"));
			}
			return session;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	private String getXsfrToken(String session, String user, String password, String tenant, URI uri) {
		try {
			//Encode user/password in base64
			String base64 = Base64.getEncoder().encodeToString((user + ":" + password).getBytes("utf-8"));
			ResponseEntity<String> response = sendUserMessage(uri, base64, tenant, session, String.class);
			//Get XSFR_TOKEN from headers
			HttpHeaders headers = response.getHeaders();
			List<String> cookies = headers.get(HttpHeaders.SET_COOKIE);
			Optional<String> xsfrToken_cookie = cookies.stream().filter(cookie->cookie.contains("XSRF-TOKEN")).findFirst();	
			String xsfrToken = null;
			if (xsfrToken_cookie.isPresent()){
				xsfrToken = xsfrToken_cookie.get().substring(xsfrToken_cookie.get().indexOf("=") + 1, xsfrToken_cookie.get().indexOf(";"));
			}
			return xsfrToken;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
	
	private <T> ResponseEntity<T> sendLoginMessage(URI uri, String base64, String tenant, Class<T> clazz) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.header(HttpHeaders.AUTHORIZATION, "Basic " + base64)
				.header("TenantId", tenant)
				.build();
		return messageClient.exchange(request, clazz);
	}
	
	private <T> ResponseEntity<T> sendUserMessage(URI uri, String base64, String tenant, String session, Class<T> clazz) throws RestClientException{
		RequestEntity<T> request = (RequestEntity<T>) RequestEntity.get(uri)
				.header(HttpHeaders.AUTHORIZATION, "Basic " + base64)
				.header("TenantId", tenant)
				.header(HttpHeaders.COOKIE, "SESSION=" + session)
				.build();
		return messageClient.exchange(request, clazz);
	}
	
//	public <T, S> ResponseEntity<T> postJsonMessageWithAuthentication(S object, URI uri, Class<S> clazz, FrontendSession session) {
//		RequestEntity<S> request = RequestEntity.post(uri)
//				.contentType(MediaType.APPLICATION_JSON)
//				.header(HttpHeaders.COOKIE, "SESSION=" + session.getSession())
//				.header("x-xsrf-token", session.getXsfrToken())
//				.body(object);
//		return (ResponseEntity<T>) messageClient.exchange(request, clazz);
//	}
	
	public static void main (String[] args) throws Exception{
		FrontendAuthentication<String, String> fea = new FrontendAuthentication<>();
		FrontendSession frontEndSession = fea.login("wp_admin", "9jqUuNrZ", "atos");
		String requirement = "{\"name\":\"ciao\",\"description\":\"descrizione\"}";
		fea.addRequirement(requirement, frontEndSession);
	}
}
