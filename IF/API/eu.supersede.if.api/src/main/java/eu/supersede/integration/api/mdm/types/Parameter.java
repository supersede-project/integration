package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

public class Parameter implements Serializable{
	String value;
	String key;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}
