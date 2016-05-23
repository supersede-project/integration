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
package eu.supersede.integration.api.tenants;


import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.httpclient.contrib.ssl.EasySSLProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;

import eu.supersede.integration.properties.IntegrationProperty;

public class IFTenantsManager {
	private static String IS_ENDPOINT =  IntegrationProperty.getProperty("is.server.endpoint");
	private static Log log = LogFactory.getLog(IFTenantsManager.class);
	private TenantMgtAdminServiceStub stub = null;
	
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
	
	public IFTenantsManager(String admin, String password){
		Assert.isTrue(admin!=null && !admin.isEmpty(), "IS admin user not provided");
		Assert.isTrue(password!=null && !password.isEmpty(), "IS admin password not provided");
		try {
			if (stub == null) {
				stub = new TenantMgtAdminServiceStub(null, IS_ENDPOINT + "TenantMgtAdminService");
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

    public List<TenantInfoBean> getAllTenants() throws TenantMgtAdminServiceExceptionException{
    	List<TenantInfoBean> result = null;
    	try {
			result = Arrays.asList(stub.retrieveTenants());
		} catch (RemoteException | TenantMgtAdminServiceExceptionException e) {
			handleException("", e);
		}
        return result;
    }
    
    public boolean doesExistTenantDomain (String tenantDomain) throws TenantMgtAdminServiceExceptionException{
    	boolean result = false;
    	try {
			List<TenantInfoBean> tenants = getAllTenants();
			for (TenantInfoBean tenant: tenants){
				if (tenant.getTenantDomain().equals(tenantDomain)){
					result = true;
					break;
				}
			}
		} catch (TenantMgtAdminServiceExceptionException e) {
			handleException("Error checking tenant domain existence", e);
		}
    	return result;
    }
    
    private String[] handleException(String msg, Exception e) throws TenantMgtAdminServiceExceptionException {
        log.error(e.getMessage(), e);
        throw new TenantMgtAdminServiceExceptionException(msg, e);
    }

}
