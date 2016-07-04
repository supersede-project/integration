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
package eu.supersede.integration.api.proxies.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import eu.supersede.integration.api.common.proxies.MailProxy;
import eu.supersede.integration.api.common.types.Email;
import eu.supersede.integration.api.datastore.proxies.FEDataStoreProxy;
import eu.supersede.integration.api.security.IFAuthenticationManager;
import eu.supersede.integration.api.security.types.AuthorizationToken;
import eu.supersede.integration.application.SpringAppTest;
import eu.supersede.integration.properties.IntegrationProperty;

public class MailProxyTest {
	private static final Logger log = LoggerFactory.getLogger(MailProxyTest.class);
	private IFAuthenticationManager am;
	private AuthorizationToken token;
	
    @Before
    public void setup() throws Exception {
    	String admin = System.getProperty("is.admin.user");
		String password = System.getProperty("is.admin.passwd");
        am = new IFAuthenticationManager(admin, password);
        token = am.getAuthorizationToken(admin, password, "");
    }

    @Test
    public void testSendEmail() throws Exception{
    	Email email = new Email();
    	email.addToRecipient("jesus.gorronogoitia@atos.net");
    	email.addToRecipient("jgorro@gmail.com");
//    	email.addCcRecipient("jgorro@gmail.com");
//    	email.addBccRecipient("jgorro@gmail.com");
    	email.setSubject("Test, Email sent through WSO2 ESB");
    	email.setBody("This message has been sent by requesting to WSO2 ESB to dispatch the message");
    	log.info("Testing sending email");
		new MailProxy().sendEmail(email, token);
    }
}
