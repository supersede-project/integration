package eu.supersede.integration.api.datastore.proxies;

import java.util.List;

import org.springframework.http.HttpStatus;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.api.security.types.AuthorizationToken;

public interface IFDataStore {
	public List<SupersedePlatform> getSupersedePlatforms(AuthorizationToken authenticationToken)
			throws Exception;

	public SupersedePlatform getSupersedePlatform(String platformId, AuthorizationToken authenticationToken)
			throws Exception;
	
	public HttpStatus insertSupersedePlatform(SupersedePlatform platform, AuthorizationToken authenticationToken)
			throws Exception;
	
	HttpStatus deleteSupersedePlatform(String platformId, AuthorizationToken authenticationToken) throws Exception;
}
