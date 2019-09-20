package eu.supersede.integration.api.fe;

public class FrontendSession {
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getXsfrToken() {
		return xsfrToken;
	}
	public void setXsfrToken(String xsfrToken) {
		this.xsfrToken = xsfrToken;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	String session;
	String xsfrToken;
	String tenantId;
}