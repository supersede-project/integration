package eu.supersede.integration.api.feedback.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


public class UserGroup {
    private long id;

    private String name;

    private List<User> users;

    private boolean active;

    @JsonIgnore
    private Application application;

    public UserGroup() {
    }

    public UserGroup(String name, List<User> users, Application application) {
        this.name = name;
        this.users = users;
        this.application = application;
    }

    public boolean containsUserWithUserIdentification(String userIdentification) {
        return this.getUsers() != null && this.getUsers().stream().filter(user -> user.getUserIdentification().equals(userIdentification)).count() > 0;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
