package eu.supersede.integration.api.analysis.proxies;

import java.util.Properties;
import org.json.JSONObject;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaClient {
	private Producer<String, String> producer;
	
	public KafkaClient (String kafkaEndpoint){
		producer = initProducer (kafkaEndpoint);
	}
	
	
	/**
	 * Creates and returns a new producer for kafka communication purposes
	 * @param kafkaEndpoint		the endpoint of the producer
	 * @return					the created producer
	 */
	private Producer<String, String> initProducer(String kafkaEndpoint) {
		Properties props = new Properties();
		props.put("metadata.broker.list", kafkaEndpoint);
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);
		
		return new Producer<String,String>(config);
	}
	
	/**
	 * Sends a message to a concrete Kafka topic
	 * @param jsonData	the message payload
	 * @param topic	the topic for the kafka communication
	 */
	public void sendMessage(JSONObject jsonData, String topic) {
		
		KeyedMessage<String, String> msg = new KeyedMessage<String, String>(topic, jsonData.toString());
		producer.send(msg);
		
	}
	
}
