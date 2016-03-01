package eu.supersede.integration.api.proxies.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import eu.supersede.integration.api.common.proxies.MailProxy;
import eu.supersede.integration.api.common.types.Email;
import eu.supersede.integration.application.SpringAppTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAppTest.class)
@WebAppConfiguration
public class MailProxyTest {
	private static final Logger log = LoggerFactory.getLogger(MailProxyTest.class);

    @Before
    public void setup() throws Exception {
        
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
		new MailProxy().sendEmail(email);
    }
}
