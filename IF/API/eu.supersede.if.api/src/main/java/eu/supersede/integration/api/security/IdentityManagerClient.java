package eu.supersede.integration.api.security;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.wso2.carbon.um.ws.api.stub.ClaimValue;
import org.wso2.carbon.um.ws.api.stub.RemoteUserStoreManagerServiceStub;
import org.wso2.carbon.um.ws.api.stub.RemoteUserStoreManagerServiceUserStoreExceptionException;
import org.wso2.carbon.um.ws.api.stub.UserStoreException;

import eu.supersede.integration.properties.IntegrationProperty;

public class IdentityManagerClient {
	private static RemoteUserStoreManagerServiceStub stub;
	private static String IS_ENDPOINT =  IntegrationProperty.getProperty("is.server.endpoint");
	
	static{
		try {
			if (stub == null) {
				stub = new RemoteUserStoreManagerServiceStub(null, IS_ENDPOINT + "RemoteUserStoreManagerService");
				HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
				basicAuth.setUsername(IntegrationProperty.getProperty("is.admin.user"));
				basicAuth.setPassword(IntegrationProperty.getProperty("is.admin.passwd"));
				basicAuth.setPreemptiveAuthentication(true);

				final Options clientOptions = stub._getServiceClient().getOptions();
				clientOptions.setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
				stub._getServiceClient().setOptions(clientOptions);
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
;
	public static boolean authenticateUserAccount(String username, String passwd) {
		try {
			return stub.authenticate(username, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addUser(String userName, String credential, String[] roleList, ClaimValue[] claimValues,
            String profileName, boolean requirePasswordChange) throws RemoteException,
            RemoteUserStoreManagerServiceUserStoreExceptionException {

        stub.addUser(userName, (String) credential, roleList, claimValues,
                profileName, requirePasswordChange);
    }

}
