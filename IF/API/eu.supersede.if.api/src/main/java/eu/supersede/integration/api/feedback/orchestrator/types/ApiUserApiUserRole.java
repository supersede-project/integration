package eu.supersede.integration.api.feedback.orchestrator.types;




public class ApiUserApiUserRole {

    private long id;

    private ApiUser apiUser;

    private ApiUserRole apiUserRole;

    public ApiUserApiUserRole() {
    }

    public ApiUserApiUserRole(ApiUser apiUser, ApiUserRole apiUserRole) {
        this.apiUser = apiUser;
        this.apiUserRole = apiUserRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApiUser getApiUser() {
        return apiUser;
    }

    public void setApiUser(ApiUser apiUser) {
        this.apiUser = apiUser;
    }

    public ApiUserRole getApiUserRole() {
        return apiUserRole;
    }

    public void setApiUserRole(ApiUserRole apiUserRole) {
        this.apiUserRole = apiUserRole;
    }
}