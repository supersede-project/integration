package eu.supersede.integration.api.pubsub;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.properties.IntegrationProperty;

public abstract class TopicMessageAgent implements iTopicMessageAgent {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	protected SubscriptionTopic subscriptionTopic;
	protected String initialContextFactory = "org.wso2.andes.jndi." + "PropertiesFileInitialContextFactory";
	protected String connectionString;
	protected Properties properties;
	protected InitialContext ctx;
	protected TopicConnection topicConnection;
	
	protected TopicMessageAgent(SubscriptionTopic subscriptionTopic, String platform) throws NamingException{
		this.subscriptionTopic = subscriptionTopic;
		connectionString = IntegrationProperty.getMBConnection(platform);
		properties = new Properties();
		properties.put("java.naming.factory.initial", initialContextFactory);
		properties.put("connectionfactory.QueueConnectionFactory", connectionString);
		properties.put("topic." + subscriptionTopic.getTopic(), subscriptionTopic.getTopic());
		ctx = new InitialContext(properties);
	}
	
	protected TopicMessageAgent(SubscriptionTopic subscriptionTopic) throws NamingException{
		this.subscriptionTopic = subscriptionTopic;
		connectionString = IntegrationProperty.getMBConnection();
		properties = new Properties();
		properties.put("java.naming.factory.initial", initialContextFactory);
		properties.put("connectionfactory.QueueConnectionFactory", connectionString);
		properties.put("topic." + subscriptionTopic.getTopic(), subscriptionTopic.getTopic());
		ctx = new InitialContext(properties);
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicMessageAgent#openTopicConnection()
	 */
	@Override
	public void openTopicConnection () throws JMSException{
		
		closeTopicConnection();
		
		try {
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ctx
					.lookup("QueueConnectionFactory");
			topicConnection = topicConnectionFactory.createTopicConnection();
			log.debug("Open topic connection with Message Broker");
		} catch (NamingException e) {
			closeTopicConnection();
			throw new RuntimeException("Error in initial context lookup", e);
		} catch (JMSException e) {
			closeTopicConnection();
			throw new RuntimeException("Error in JMS operations", e);
		} finally {
			
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicMessageAgent#closeTopicConnection()
	 */
	@Override
	public void closeTopicConnection() throws JMSException{
		if (topicConnection != null){
			topicConnection.close();
			log.debug("Close topic connection with Message Broker");
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		closeTopicConnection();
	}
	
}
