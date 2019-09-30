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
import eu.supersede.integration.api.analysis.types.MonitoringData;

public interface IDataProvider {
	public void ingestData(String data, String topic);
	public void ingestData(JSONObject data, String topic);
	public void ingestData(JSONArray items, String itemsLabel, String topic);
	public void ingestMonitoringData(List<MonitoringData> dataList, String timeStamp, int outputId, int confId, String topic);
}
