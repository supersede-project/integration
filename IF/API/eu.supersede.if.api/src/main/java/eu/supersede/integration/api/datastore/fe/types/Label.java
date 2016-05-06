package eu.supersede.integration.api.datastore.fe.types;

public class Label {
	int profile_label_id;
	String label;
	String lang;
	public int getProfile_label_id() {
		return profile_label_id;
	}
	public void setProfile_label_id(int profile_label_id) {
		this.profile_label_id = profile_label_id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
}
