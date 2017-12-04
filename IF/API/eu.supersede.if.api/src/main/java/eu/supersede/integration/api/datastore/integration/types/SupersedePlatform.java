package eu.supersede.integration.api.datastore.integration.types;

public class SupersedePlatform {
	String platform;
	String mb_user;
	String mb_password;
	String mb_url;
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getMb_user() {
		return mb_user;
	}
	public void setMb_User(String mb_user) {
		this.mb_user = mb_user;
	}
	public String getMb_password() {
		return mb_password;
	}
	public void setMb_password(String mb_password) {
		this.mb_password = mb_password;
	}
	
	public String getMb_url() {
		return mb_url;
	}
	public void setMb_url(String mb_url) {
		this.mb_url = mb_url;
	}
	@Override
	public String toString(){
		return "SupersedePlatform[" 
				+ "platform: " + platform 
				+ ", mb_user: " + mb_user 
				+ ", mb_password: " + mb_password
				+ ", mb_url: " + mb_url + "]";
	}
}
