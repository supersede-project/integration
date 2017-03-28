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
package eu.supersede.integration.api.security.test;

//import org.apache.axiom.om.OMAbstractFactory;
//import org.apache.axiom.om.OMElement;
//import org.apache.axiom.om.OMFactory;
//import org.apache.axiom.om.impl.builder.StAXOMBuilder;
//import org.apache.axis2.context.ConfigurationContext;
//import org.apache.axis2.context.ConfigurationContextFactory;
//import org.apache.neethi.Policy;
//import org.apache.neethi.PolicyEngine;
//import org.apache.rahas.RahasConstants;
//import org.apache.rahas.Token;
//import org.apache.rahas.TrustUtil;
//import org.apache.rahas.client.STSClient;
//import org.apache.rampart.policy.model.RampartConfig;
//import org.apache.ws.secpolicy.Constants;
//import org.opensaml.XML;

public class IdentitySTSClientTest {
//	/**
//	 * @param args
//	 */
//
//	final static String RELYING_PARTY_SERVICE_EPR = "http://192.168.145.13:8280/services/echo";
//	final static String STS_EPR = "https://192.168.145.13:9445/services/wso2carbon-sts";
//
//	/**
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) throws Exception {
//		ConfigurationContext confContext = null;
//		Policy stsPolicy = null;
//		STSClient stsClient = null;
//		Policy servicePolicy = null;
//		Token responseToken = null;
//		String trustStore = null;
//
//		// You need to import the Identity Server, public certificate to this
//		// key store.
//		trustStore = "client-truststore.jks";
//		// We are accessing STS over HTTPS - so need to set trustStore
//		// parameters.
//		System.setProperty("javax.net.ssl.trustStore", trustStore);
//		System.setProperty("javax.net.ssl.trustStorePassword", "$2pRSid#");
//
//		// Create configuration context - you will have Rampart module engaged
//		// in the client.axis2.xml
//		confContext = ConfigurationContextFactory.createConfigurationContextFromFileSystem("repo",
//				"axis2_client.xml");
//
//		stsClient = new STSClient(confContext);
//
//		stsClient.setRstTemplate(getRSTTemplate());
//		stsClient.setAction(RahasConstants.WST_NS_05_02 + RahasConstants.RST_ACTION_SCT);
//
//		// This is the security policy we applied to Identity Server STS.
//		// You can see it by
//		// https://[IDENTITY_SERVER]/services/wso2carbon-sts?wsdl
//		stsPolicy = loadPolicy("sts.policy.xml");
//
//		// This is the security of the relying party web service.
//		// This policy will accept a security token issued from Identity Server
//		// STS
//		servicePolicy = loadPolicy("service.policy.xml");
//
//		responseToken = stsClient.requestSecurityToken(servicePolicy, STS_EPR, stsPolicy, RELYING_PARTY_SERVICE_EPR);
//
//		System.out.println(responseToken.getToken());
//
//	}
//
//	private static Policy loadPolicy(String xmlPath) throws Exception {
//		StAXOMBuilder builder = null;
//		Policy policy = null;
//		RampartConfig rc = null;
//		builder = new StAXOMBuilder(xmlPath);
//		policy = PolicyEngine.getPolicy(builder.getDocumentElement());
//		rc = new RampartConfig();
//		rc.setUser("admin");
//		// You need to have password call-back class to provide the user
//		// password
//		rc.setPwCbClass(PWCBHandler.class.getName());
//		policy.addAssertion(rc);
//		return policy;
//	}
//
//	private static OMElement getRSTTemplate() throws Exception {
//		OMFactory fac = OMAbstractFactory.getOMFactory();
//		OMElement elem = fac.createOMElement(Constants.RST_TEMPLATE);
//		TrustUtil.createTokenTypeElement(RahasConstants.VERSION_05_02, elem).setText(XML.SAML_NS);
//		TrustUtil.createKeyTypeElement(RahasConstants.VERSION_05_02, elem, RahasConstants.KEY_TYPE_SYMM_KEY);
//		TrustUtil.createKeySizeElement(RahasConstants.VERSION_05_02, elem, 256);
//		return elem;
//	}
}
