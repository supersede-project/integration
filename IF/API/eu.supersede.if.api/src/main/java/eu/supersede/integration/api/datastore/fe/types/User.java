package eu.supersede.integration.api.datastore.fe.types;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.LocaleJsonDeserializer;
import eu.supersede.integration.api.json.NotificationArrayJsonDeserializer;
import eu.supersede.integration.api.json.ProfileArrayJsonDeserializer;

public class User {
	int user_id;
	String name;
	String password;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocale() {
		return locale;
	}
	@JsonDeserialize(using = LocaleJsonDeserializer.class)
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
