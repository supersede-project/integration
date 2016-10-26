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
