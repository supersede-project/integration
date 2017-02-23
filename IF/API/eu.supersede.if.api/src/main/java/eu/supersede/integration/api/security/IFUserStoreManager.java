/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
/*
 * Copyright - WSO, Inc. (http://wso.com)
 *
 * Licensed under the Apache License, Version .0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Adaptation of org.wso2.carbon.um.ws.api WSUserStoreManager 
 * developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.security;


import java.util.Date;
import java.util.Map;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.httpclient.contrib.ssl.EasySSLProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.wso2.carbon.um.ws.api.WSRealmUtil;
import org.wso2.carbon.um.ws.api.stub.ClaimDTO;
import org.wso2.carbon.um.ws.api.stub.ClaimValue;
import org.wso2.carbon.um.ws.api.stub.PermissionDTO;
import org.wso2.carbon.um.ws.api.stub.RemoteUserStoreManagerServiceStub;
import org.wso2.carbon.user.api.ClaimManager;
import org.wso2.carbon.user.api.Properties;
import org.wso2.carbon.user.api.RealmConfiguration;
import org.wso2.carbon.user.core.Permission;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.claim.Claim;
import org.wso2.carbon.user.core.tenant.Tenant;

import eu.supersede.integration.properties.IntegrationProperty;

public class IFUserStoreManager implements UserStoreManager{
	private static String IS_ENDPOINT =  IntegrationProperty.getProperty("is.server.endpoint");
	private static Logger log = Logger.getLogger(IFUserStoreManager.class);
	private RemoteUserStoreManagerServiceStub stub = null;
	
	static {
		EasySSLProtocolSocketFactory easySSLProtocolSocketFactory;
		try {
		     easySSLProtocolSocketFactory = new EasySSLProtocolSocketFactory();
		     Protocol.unregisterProtocol("https");
		     Protocol.registerProtocol("https", new Protocol("https",
		                  (ProtocolSocketFactory) easySSLProtocolSocketFactory, 443));
		}
		catch (Exception e) {
		      e.printStackTrace();
		}
	}
	
	public IFUserStoreManager(String admin, String password){
		Assert.hasText(admin, "IS admin user not provided");
		Assert.hasText(password, "IS admin password not provided");
		try {
			if (stub == null) {
				stub = new RemoteUserStoreManagerServiceStub(null, IS_ENDPOINT + "RemoteUserStoreManagerService");
				HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
				basicAuth.setUsername(admin);
				basicAuth.setPassword(password);
				basicAuth.setPreemptiveAuthentication(true);

				final Options clientOptions = stub._getServiceClient().getOptions();
				clientOptions.setProperty(HTTPConstants.AUTHENTICATE, basicAuth);
				stub._getServiceClient().setOptions(clientOptions);
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

    public void addUser(String userName, Object credential, String[] roleList,
            Map<String, String> claims, String profileName, boolean requirePasswordChange)
            throws UserStoreException {
        try {
            if (!(credential instanceof String)) {
                throw new UserStoreException("Unsupported type of password");
            }
            String password = (String) credential;
            ClaimValue[] claimValues = WSRealmUtil.convertMapToClaimValue(claims);
            log.debug("Sending message addUser with userName: " + userName 
            	+ " with roleList: " + roleList 
            	+ " with claims: " + claims 
            	+ " with profileName: " + profileName 
            	+ " with requirePasswordChange: " + requirePasswordChange 
            	+ " to UserStoreManager");
            stub.addUser(userName, password, roleList, claimValues, profileName,
                    requirePasswordChange);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void addRole(String roleName, String[] userList, Permission[] permissions)
            throws UserStoreException {
        try {
        	log.debug("Sending message addRole with roleName: " + roleName 
            	+ " with userList: " + userList 
            	+ " with permissions: " + permissions 
            	+ " to UserStoreManager");
            stub.addRole(roleName, userList, convertPermission(permissions));
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    public void addUser(String userName, Object credential, String[] roleList,
            Map<String, String> claims, String profileName) throws UserStoreException {
        if (!(credential instanceof String)) {
            throw new UserStoreException("Unsupported type of password");
        }
        try {
        	log.debug("Sending message addUser with userName: " + userName 
            	+ " with roleList: " + roleList 
            	+ " with claims: " + claims 
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
            stub.addUser(userName, (String) credential, roleList, WSRealmUtil
                    .convertMapToClaimValue(claims), profileName, false);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    public boolean authenticate(String userName, Object credential) throws UserStoreException {
        if (!(credential instanceof String)) {
            throw new UserStoreException("Unsupported type of password");
        }
        try {
        	log.debug("Sending message authenticate with userName: " + userName 
            	+ " with credential: " + credential != null && !credential.toString().isEmpty()?" not empty":"empty"
            	+ " to UserStoreManager");
            return stub.authenticate(userName, (String) credential);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return false;
    }

    public void deleteRole(String roleName) throws UserStoreException {
        try {
        	log.debug("Sending message deleteRole with roleName: " + roleName 
                + " to UserStoreManager");
            stub.deleteRole(roleName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    public void deleteUser(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message deleteUser with userName: " + userName 
                    + " to UserStoreManager");
            stub.deleteUser(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void deleteUserClaimValue(String userName, String claimURI, String profileName)
            throws UserStoreException {
        try {
        	log.debug("Sending message deleteUserClaimValue with userName: " + userName 
            	+ " with claimURI: " + claimURI 
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
            stub.deleteUser(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void deleteUserClaimValues(String userName, String[] claims, String profileName)
            throws UserStoreException {
        try {
        	log.debug("Sending message deleteUserClaimValues with userName: " + userName 
            	+ " with claims: " + claims 
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
            stub.deleteUserClaimValues(userName, claims, profileName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    public String[] getAllProfileNames() throws UserStoreException {
        try {
        	log.debug("Sending message getAllProfileNames to UserStoreManager");
            return stub.getAllProfileNames();
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getHybridRoles() throws UserStoreException {
        try {
        	log.debug("Sending message getHybridRoles to UserStoreManager");
            return stub.getHybridRoles();
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getAllSecondaryRoles() throws UserStoreException {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Date getPasswordExpirationTime(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message getPasswordExpirationTime with userName: " + userName 
                + " to UserStoreManager");
            long time = stub.getPasswordExpirationTime(userName);
            if(time != -1) {
                return new Date(time);
            }
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getProfileNames(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message getProfileNames with userName: " + userName 
                    + " to UserStoreManager");
            return stub.getProfileNames(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getRoleListOfUser(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message getRoleListOfUser with userName: " + userName 
                    + " to UserStoreManager");
            return stub.getRoleListOfUser(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getRoleNames() throws UserStoreException {
        try {
        	log.debug("Sending message getRoleNames to UserStoreManager");
            return stub.getRoleNames();
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public String[] getRoleNames(boolean b) throws UserStoreException {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getTenantId() throws UserStoreException {
        try {
        	log.debug("Sending message getTenantId to UserStoreManager");
            return stub.getTenantId();
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return -1;
    }

    public int getTenantId(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message getTenantId with userName: " + userName 
                    + " to UserStoreManager");
            return stub.getTenantIdofUser(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return -1;
    }

    public String getUserClaimValue(String userName, String claim, String profileName)
            throws UserStoreException {
        try {
        	log.debug("Sending message getUserClaimValue with userName: " + userName 
            	+ " with claim: " + claim
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
            return stub.getUserClaimValue(userName, claim, profileName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return profileName;
    }

    public Claim[] getUserClaimValues(String userName, String profileName)
            throws UserStoreException {
        try {
        	log.debug("Sending message getUserClaimValues with userName: " + userName 
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
        	ClaimDTO[] claims = stub.getUserClaimValues(userName, profileName);
        	if (claims != null)
        		return WSRealmUtil.convertToClaims(claims);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public Map<String, String> getUserClaimValues(String userName, String[] claims,
            String profileName) throws UserStoreException {
        try {
        	log.debug("Sending message getUserClaimValues with userName: " + userName 
    			+ " with claims: " + claims
            	+ " with profileName: " + profileName
            	+ " to UserStoreManager");
            return WSRealmUtil.
                convertClaimValuesToMap(stub.getUserClaimValuesForClaims(userName, claims, profileName));
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public int getUserId(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message getUserId with userName: " + userName 
                + " to UserStoreManager");
            return stub.getUserId(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return -1;
    }

    public String[] getUserListOfRole(String roleName) throws UserStoreException {
        try {
        	log.debug("Sending message getUserListOfRole with roleName: " + roleName 
                + " to UserStoreManager");
            return stub.getUserListOfRole(roleName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public boolean isExistingRole(String roleName, boolean isSharedRole) throws UserStoreException {
        try {
        	log.debug("Sending message isExistingRole with roleName: " + roleName 
    			+ " with isSharedRole: " + isSharedRole
                + " to UserStoreManager");
            return stub.isExistingRole(roleName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return false;
    }

    public boolean isExistingUser(String userName) throws UserStoreException {
        try {
        	log.debug("Sending message isExistingUser with userName: " + userName 
                + " to UserStoreManager");
            return stub.isExistingUser(userName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return false;
    }

    public boolean isReadOnly() throws UserStoreException {
        try {
        	log.debug("Sending message isReadOnly to UserStoreManager");
            return stub.isReadOnly();
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return false;
    }

    public String[] listUsers(String filter, int maxItemLimit) throws UserStoreException {
        try {
        	log.debug("Sending message listUsers with filter: " + filter 
    			+ " with maxItemLimit: " + maxItemLimit
                + " to UserStoreManager");
            return stub.listUsers(filter, maxItemLimit);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        return null;
    }

    public void setUserClaimValue(String userName, String claimURI, String claimValue,
            String profileName) throws UserStoreException {
        try {
        	log.debug("Sending message setUserClaimValue with userName: " + userName 
    			+ " with claimURI: " + claimURI
    			+ " with claimValue: " + claimValue
    			+ " with profileName: " + profileName
                + " to UserStoreManager");
            stub.setUserClaimValue(userName, claimURI, claimValue, profileName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    public void setUserClaimValues(String userName, Map<String, String> claims, String profileName)
            throws UserStoreException {
        try {
        	log.debug("Sending message setUserClaimValues with userName: " + userName 
    			+ " with claims: " + claims
    			+ " with profileName: " + profileName
                + " to UserStoreManager");
            stub.setUserClaimValues(userName, WSRealmUtil.convertMapToClaimValue(claims),
                    profileName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void updateCredential(String userName, Object newCredential, Object oldCredential)
            throws UserStoreException {
        if (!(newCredential instanceof String) || !(oldCredential instanceof String)) {
            throw new UserStoreException("Unsupported type of password");
        }
        try {
        	log.debug("Sending message updateCredential with userName: " + userName 
        		+ " with newCredential: " + newCredential != null && !newCredential.toString().isEmpty()?" not empty":"empty"
        		+ " with oldCredential: " + oldCredential != null && !oldCredential.toString().isEmpty()?" not empty":"empty"
                + " to UserStoreManager");
            stub.updateCredential(userName, (String) newCredential, (String) oldCredential);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void updateCredentialByAdmin(String userName, Object newCredential)
            throws UserStoreException {
        if (!(newCredential instanceof String)) {
            throw new UserStoreException("Unsupported type of password");
        }

        try {
        	log.debug("Sending message updateCredentialByAdmin with userName: " + userName 
    			+ " with newCredential: " + newCredential != null && !newCredential.toString().isEmpty()?" not empty":"empty"
                + " to UserStoreManager");
            stub.updateCredentialByAdmin(userName, (String) newCredential);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void updateRoleListOfUser(String userName, String[] deletedRoles, String[] newRoles)
            throws UserStoreException {
        try {
        	log.debug("Sending message updateRoleListOfUser with userName: " + userName 
    			+ " with deletedRoles: " + deletedRoles
    			+ " with newRoles: " + newRoles
                + " to UserStoreManager");
            stub.updateRoleListOfUser(userName, deletedRoles, newRoles);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void updateUserListOfRole(String roleName, String[] deletedUsers, String[] newUsers)
            throws UserStoreException {
        try {
        	log.debug("Sending message updateUserListOfRole with roleName: " + roleName 
    			+ " with deletedRoles: " + deletedUsers
    			+ " with newRoles: " + newUsers
                + " to UserStoreManager");
            stub.updateUserListOfRole(roleName, deletedUsers, newUsers);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
    }

    public void updateRoleName(String roleName, String newRoleName) throws UserStoreException {
        try {
        	log.debug("Sending message updateRoleName with roleName: " + roleName 
    			+ " with newRoleName: " + newRoleName
                + " to UserStoreManager");
            stub.updateRoleName(roleName, newRoleName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }

    }

    /**
     * This method is to check whether multiple profiles are allowed with a particular user-store.
     * For an example, currently, JDBC user store supports multiple profiles and where as ApacheDS
     * does not allow.
     * @return
     */
    public boolean isMultipleProfilesAllowed() {
        return true;
    }

    private PermissionDTO[] convertPermission(Permission[] permissions) {
        if (permissions == null) {
            return null;
        }
        PermissionDTO[] perms = new PermissionDTO[permissions.length];
        for (int i = 0; i < permissions.length; i++) {
            perms[i] = new org.wso2.carbon.um.ws.api.stub.PermissionDTO();
            perms[i].setAction(permissions[i].getAction());
            perms[i].setResourceId(permissions[i].getResourceId());
        }
        return perms;

    }

    private String[] handleException(String msg, Exception e) throws UserStoreException {
        log.error(e.getMessage(), e);
        throw new UserStoreException(msg, e);
    }

    public Map<String, String> getProperties(Tenant tenant) throws UserStoreException {
        // TODO Auto-generated method stub
        return null;
    }

    public void addRole(String roleName, String[] userList,
                        org.wso2.carbon.user.api.Permission[] permissions, boolean isSharedRole)
            throws org.wso2.carbon.user.core.UserStoreException {
        addRole(roleName, userList, Permission[].class.cast(permissions));

    }

    public Map<String, String> getProperties(org.wso2.carbon.user.api.Tenant tenant)
            throws org.wso2.carbon.user.core.UserStoreException {
        return getProperties(Tenant.class.cast(tenant));
    }

    public void addRememberMe(String userName, String token)
            throws org.wso2.carbon.user.api.UserStoreException {
        // TODO Auto-generated method stub
        
    }

    public boolean isValidRememberMeToken(String userName, String token)
            throws org.wso2.carbon.user.api.UserStoreException {
        // TODO Auto-generated method stub
        return false;
    }

    public ClaimManager getClaimManager() throws org.wso2.carbon.user.api.UserStoreException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isSCIMEnabled() throws org.wso2.carbon.user.api.UserStoreException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean isBulkImportSupported() throws UserStoreException {
        // TODO Auto-generated method stub
        return false;
    }

    public String[] getUserList(String claim, String claimValue, String profileName)
                                                                        throws UserStoreException {
        try {
            return stub.getUserList(claim, claimValue, profileName);
        } catch (Exception e) {
            handleException(e.getMessage(), e);
        }
        
        return null;
    }

    public UserStoreManager getSecondaryUserStoreManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public UserStoreManager getSecondaryUserStoreManager(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addSecondaryUserStoreManager(String s, UserStoreManager userStoreManager) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setSecondaryUserStoreManager(UserStoreManager userStoreManager) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public RealmConfiguration getRealmConfiguration() {
        return null;
    }

    public Properties getDefaultUserStoreProperties() {
	    return null;
    }

	@Override
    public void addRole(String roleName, String[] userList,
                        org.wso2.carbon.user.api.Permission[] permissions)
                                                                          throws org.wso2.carbon.user.api.UserStoreException {
		addRole(roleName, userList, permissions, false);
    }

	@Override
    public boolean isExistingRole(String roleName) throws UserStoreException {
	    return isExistingRole(roleName, false);
    }

    public boolean isSharedGroupEnabled() {
	    return false;
    }

}
