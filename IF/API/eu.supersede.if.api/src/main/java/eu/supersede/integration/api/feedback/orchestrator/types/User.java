package eu.supersede.integration.api.feedback.orchestrator.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


public class User {
    private long id;

    private String name;

    private String userIdentification;

    @JsonIgnore
    private Application application;

    @JsonIgnore
    private UserGroup userGroup;

    public User() {
    }

    public User(String name, String userIdentification, Application application, UserGroup userGroup) {
        this.name = name;
        this.userIdentification = userIdentification;
        this.application = application;
        this.userGroup = userGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String userIdentification) {
        this.userIdentification = userIdentification;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}


