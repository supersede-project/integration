package eu.supersede.integration.api.feedback.orchestrator.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


public class ApiUserPermission {
    private long id;

    @JsonIgnore
    private ApiUser apiUser;

    @JsonIgnore
    private Application application;

    private boolean hasPermission;

    public ApiUserPermission() {
    }

    public ApiUserPermission(ApiUser apiUser, Application application, boolean hasPermission) {
        this.apiUser = apiUser;
        this.application = application;
        this.hasPermission = hasPermission;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public boolean hasPermission() {
        return hasPermission;
    }

    public void setPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }
}