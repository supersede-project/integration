package eu.supersede.integration.api.datastore.fe.types;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Notification {
	Date creation_time;
	boolean email_sent;
	boolean read;
	int user_id;
	String link;
	int notification_id;
	String message;
	
	public Date getCreation_time() {
		return creation_time;
	}
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	public void setCreation_time(Date creation_time) {
		this.creation_time = creation_time;
	}
	public boolean isEmail_sent() {
		return email_sent;
	}
	public void setEmail_sent(boolean email_sent) {
		this.email_sent = email_sent;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
