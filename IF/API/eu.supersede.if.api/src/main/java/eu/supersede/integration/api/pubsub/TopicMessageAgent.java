package eu.supersede.integration.api.pubsub;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class TopicMessageAgent implements iTopicMessageAgent {
	protected SubscriptionTopic subscriptionTopic;
	protected String initialContextFactory = "org.wso2.andes.jndi." + "PropertiesFileInitialContextFactory";
	protected String connectionString = "amqp:" + "//admin:$up3r$3d3@clientID/carbon?brokerlist='tcp://supersede.es.atos.net:5676'";
	protected Properties properties;
	protected InitialContext ctx;
	protected TopicConnection topicConnection;
	
	protected TopicMessageAgent(SubscriptionTopic subscriptionTopic) throws NamingException{
		this.subscriptionTopic = subscriptionTopic;
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
		if (topicConnection!=null){
			closeTopicConnection();
		}
		try {
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ctx
					.lookup("QueueConnectionFactory");
			topicConnection = topicConnectionFactory.createTopicConnection();
		} catch (NamingException e) {
			throw new RuntimeException("Error in initial context lookup", e);
		} catch (JMSException e) {
			throw new RuntimeException("Error in JMS operations", e);
		} finally {
			
		}
	}
	
	/* (non-Javadoc)
	 * @see eu.supersede.integration.api.pubsub.iTopicMessageAgent#closeTopicConnection()
	 */
	@Override
	public void closeTopicConnection() throws JMSException{
		if (topicConnection != null)
			topicConnection.close();
	}
}
