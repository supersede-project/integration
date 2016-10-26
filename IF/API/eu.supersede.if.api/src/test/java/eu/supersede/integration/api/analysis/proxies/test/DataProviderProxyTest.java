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

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.api.analysis.proxies.DataProviderProxy;
import eu.supersede.integration.api.analysis.types.MonitoringData;

public class DataProviderProxyTest {
	private DataProviderProxy proxy;
	
	
    @Before
    public void setup() throws Exception {
        proxy = new DataProviderProxy();
    }

    @Test
    public void testIngestMonitoringData() throws Exception{
    	List<MonitoringData> dataList = createMonitoringDataList();
		String timeStamp = Calendar.getInstance().getTime().toString();
		int outputId = 2;
		int confId = 3;
		String topic = "atos";
		proxy.ingestMonitoringData(dataList, timeStamp, outputId, confId, topic);
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
