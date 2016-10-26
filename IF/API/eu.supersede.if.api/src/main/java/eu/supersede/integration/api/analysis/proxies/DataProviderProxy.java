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

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.api.analysis.types.MonitoringData;
import eu.supersede.integration.properties.IntegrationProperty;


public class DataProviderProxy implements IDataProvider{
	private final static String SUPERSEDE_DATAPROVIDER_ENDPOINT = IntegrationProperty.getProperty("dataprovider.endpoint");
	private static final Logger log = LoggerFactory.getLogger(DataProviderProxy.class);
	private KafkaClient kafka;
	
	public DataProviderProxy (){
		kafka = new KafkaClient (SUPERSEDE_DATAPROVIDER_ENDPOINT);
	}
	
	/**
	 * Generates a json formatted message for a list of monitoring data and sends it to Analysis DataProvider
	 * @param dataList			a list with the data to retrieve
	 * @param timeStamp			the timestamp of the search
	 * @param producer			the producer to communicate 
	 * @param outputId			the id of the response data
	 * @param confId			the id of the configuration
	 * @param topic				the topic for the Kafka communication
	 */
	@Override
	public void ingestMonitoringData(List<MonitoringData> dataList, String timeStamp,
			int outputId, int confId, String topic) {
		JSONArray items = new JSONArray();
		for (MonitoringData item : dataList) {
			JSONObject jsonItem = new JSONObject();
			
			jsonItem.put("idItem", item.getId());
			jsonItem.put("timeStamp", item.getTimeStamp());
			jsonItem.put("message", item.getMessage());
			jsonItem.put("author", item.getAuthor());
			jsonItem.put("link", item.getLink());
			
			items.put(jsonItem);
		}
		
		JSONObject mainInfo = new JSONObject();
		
		mainInfo.put("idOutput", String.valueOf(outputId));
		mainInfo.put("confId", String.valueOf(confId));
		mainInfo.put("searchTimeStamp", timeStamp);
		mainInfo.put("numDataItems", dataList.size());
		mainInfo.put("DataItems", items);
		
		JSONObject jsonData = new JSONObject();
		
		jsonData.put("SocialNetworksMonitoredData", mainInfo);
		
		log.debug("Sending message " + jsonData + " to DataProvider on topic " + topic);
		kafka.sendMessage(jsonData, topic);
	}

}
