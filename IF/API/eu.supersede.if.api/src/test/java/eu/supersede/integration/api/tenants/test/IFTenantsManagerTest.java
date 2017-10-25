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
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.tenants.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;

import eu.supersede.integration.api.tenants.IFTenantsManager;

@Ignore
public class IFTenantsManagerTest {
	static IFTenantsManager tm;
	
	@BeforeClass
    public static void setup() throws Exception {
		// Set Identity Server user/password as Java launcher properties:
		// -Dis.admin.user=
		// -Dis.admin.passwd=
		// for each tenant organization, use its admin account
		String admin = System.getProperty("is.admin.user");
		String password = System.getProperty("is.admin.passwd");
        tm = new IFTenantsManager(admin, password);
    }
	
	//Authentication Test
	@Test
    public void getAllTenantsTest() throws Exception{
		List<TenantInfoBean> tenants = tm.getAllTenants();
    	Assert.notEmpty(tenants);
    	System.out.println("Located " + tenants.size() + " tenants");
    }
	
}
