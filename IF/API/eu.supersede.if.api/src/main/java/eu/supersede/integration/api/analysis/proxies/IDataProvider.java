package eu.supersede.integration.api.analysis.proxies;

import java.util.List;

import eu.supersede.integration.api.analysis.types.MonitoringData;

public interface IDataProvider {
	public void ingestMonitoringData(List<MonitoringData> dataList, String timeStamp, int outputId, int confId, String topic);
}
