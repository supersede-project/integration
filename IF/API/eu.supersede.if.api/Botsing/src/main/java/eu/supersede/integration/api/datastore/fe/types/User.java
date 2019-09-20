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
package eu.supersede.integration.api.datastore.fe.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.NillableObjectJsonDeserializer;
import eu.supersede.integration.api.json.NotificationArrayJsonDeserializer;
import eu.supersede.integration.api.json.ProfileArrayJsonDeserializer;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
	int user_id;
	String username;
	String first_name;
	String last_name;
	String locale;
	String email;
	List<Profile> profiles;
	List<Notification> notifications;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String name) {
		this.username = name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String name) {
		this.first_name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	@JsonDeserialize(using = NillableObjectJsonDeserializer.class)
	public void setLast_name(String name) {
		this.last_name = name;
	}
	public String getLocale() {
		return locale;
	}
	@JsonDeserialize(using = NillableObjectJsonDeserializer.class)
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Profile> getProfiles() {
		return profiles;
	}
	@JsonDeserialize(using = ProfileArrayJsonDeserializer.class)
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	@JsonDeserialize(using = NotificationArrayJsonDeserializer.class)
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
}
