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
package eu.supersede.integration.api.analysis.proxies.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.api.analysis.proxies.DataProviderProxy;
import eu.supersede.integration.api.analysis.types.MonitoringData;

public class DataProviderProxyTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	private static DataProviderProxy proxy;
	
	
    @BeforeClass
    public static void setup() throws Exception {
        proxy = new DataProviderProxy();
    }

    @Test
    @Ignore
    public void testIngestMonitoringData() throws Exception{
    	List<MonitoringData> dataList = createMonitoringDataList();
		String timeStamp = Calendar.getInstance().getTime().toString();
		int outputId = 2;
		int confId = 3;
		String topic = "atos";
		proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
    }
    
    @Test
    @Ignore
    public void testIngestJsonData() throws Exception{
    	JSONObject jsonData = createMonitoringDataListAsJson();
		String topic = "atos";
		proxy.ingestData(jsonData, topic);
    }
    
    @Test
    @Ignore
    public void testIngestData() throws Exception{
    	JSONObject jsonData = createMonitoringDataListAsJson();
		String topic = "atos";
		proxy.ingestData(jsonData.toString(), topic);
    }
    
    @Test
    @Ignore
    public void testIngestDataSequence() throws Exception{
    	JSONObject jsonData = createMonitoringDataListAsJson();
		String topic = "atos";
		Long startTime = System.currentTimeMillis();
		int iterations = 1000;
		for (int i=0; i<=iterations; i++){
			proxy.ingestData(jsonData.toString(), topic);
		}
		Long endTime = System.currentTimeMillis();
		log.debug("Sent " + iterations + " Json messages to DataProvider in " + (endTime - startTime) + " miliseconds");
    }
    
    private JSONObject createMonitoringDataListAsJson(){
    	List<MonitoringData> dataList = createMonitoringDataList();
		String timeStamp = Calendar.getInstance().getTime().toString();
		int outputId = 2;
		int confId = 3;
    	
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
		
		return jsonData;
    }

	private List<MonitoringData> createMonitoringDataList() {
		List<MonitoringData> data  = new ArrayList<>();
		
		int max_data = 10;
		int index = 0;
		while (index++<max_data){
			data.add( createRandomMonitoringData());
		}
		
		return data;
	}

	private MonitoringData createRandomMonitoringData() {
		Random random = new Random();
		String id = "id" + random.nextInt(1000);
		String message = "monitoring message from monitor " + random.nextInt(1000);
		Date date = Calendar.getInstance().getTime();
		String link = "https://twitter.com/" + random.nextInt(1000);
		return new MonitoringData(id, date.toString(), message, "twitter_monitor", link);
	}

}
