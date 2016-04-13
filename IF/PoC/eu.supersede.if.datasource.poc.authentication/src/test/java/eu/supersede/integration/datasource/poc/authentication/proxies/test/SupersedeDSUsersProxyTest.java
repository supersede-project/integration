package eu.supersede.integration.datasource.poc.authentication.proxies.test;

import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.supersede.integration.datasource.poc.authentication.DataStoreApp;
import eu.supersede.integration.datasource.poc.authentication.proxies.SupersedeDSUsersProxy;
import eu.supersede.integration.datasource.poc.authentication.types.User;
import eu.supersede.integration.datasource.poc.authentication.types.UsersCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DataStoreApp.class)
@WebIntegrationTest
public class SupersedeDSUsersProxyTest {
	private static final Logger log = LoggerFactory.getLogger(SupersedeDSUsersProxyTest.class);

    @Before
    public void setup() throws Exception {
 
    }

    @Test
    public void testGetUsers() throws Exception{
    	log.info("Testing testGetAdaptationDecisions");
		UsersCollection collection = new SupersedeDSUsersProxy().getUsers();
		Assert.assertTrue(!collection.getUsers().isEmpty());
    }
}
