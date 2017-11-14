package eu.supersede.integration.api.feedback.orchestrator.types;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;



public class ConfigurationUserGroup {

    private long id;
    @JsonIgnore
    private Configuration configuration;
    private UserGroup userGroup;
    private boolean active;
    private Date createdAt;
    private Date updatedAt;

    protected void onCreate() {
        createdAt = new Date();
    }

    protected void onUpdate() {
        updatedAt = new Date();
    }

    public ConfigurationUserGroup() {
    }

    public ConfigurationUserGroup(Configuration configuration, UserGroup userGroup, boolean active, Date createdAt, Date updatedAt) {
        this.configuration = configuration;
        this.userGroup = userGroup;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ConfigurationUserGroup(Configuration configuration, UserGroup userGroup, boolean active) {
        this.configuration = configuration;
        this.userGroup = userGroup;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}



