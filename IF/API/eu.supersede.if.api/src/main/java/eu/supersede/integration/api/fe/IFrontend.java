package eu.supersede.integration.api.fe;

public interface IFrontend {
	FrontendSession login(String user, String password, String tenant) throws Exception;
	void addRequirement(String requirement, FrontendSession session) throws Exception;
}
