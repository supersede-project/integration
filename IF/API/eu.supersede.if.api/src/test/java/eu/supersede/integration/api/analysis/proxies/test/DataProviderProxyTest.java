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
