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
package eu.supersede.integration.api.feedback.repository.types;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

@JsonInclude(Include.NON_NULL)
public class ContextInformation {

	
	private long id;	

	private String resolution;
	
	private String userAgent;
	
	private String androidVersion;

	private Date localTime;
	
	private String timeZone;
	
	private Float devicePixelRatio;
	
	private String country;
	
	private String region;
		
    private String url;
    
    private String metaData;
    
    public ContextInformation() {
    }
	
    public ContextInformation(String resolution, String userAgent, 
    		String androidVersion, Date date, String timeZone, Float devicePixelRatio, 
    		String country, String region, String url, String metaData) {
        this.resolution = resolution;
        this.userAgent = userAgent;
        this.androidVersion = androidVersion;
        this.localTime = date;
        this.timeZone = timeZone;
        this.devicePixelRatio = devicePixelRatio;
        this.country = country;
        this.region = region;
        this.url = url;
        this.metaData = metaData;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAndroidVersion() {
		return androidVersion;
	}

	public void setAndroidVersion(String androidVersion) {
		this.androidVersion = androidVersion;
	}

	public Date getLocalTime() {
		return localTime;
	}

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Float getDevicePixelRatio() {
		return devicePixelRatio;
	}

	public void setDevicePixelRatio(Float devicePixelRatio) {
		this.devicePixelRatio = devicePixelRatio;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
}