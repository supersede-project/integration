package eu.supersede.integration.api.feedback.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration {
    private long id;
    private String name;
    private TriggerType type;
    private Date createdAt;
    private Date updatedAt;
    @JsonIgnore
    private List<ConfigurationMechanism> configurationMechanisms;

    @JsonIgnore
    private List<ConfigurationUserGroup> configurationUserGroups;

    @JsonIgnore
    private Application application;

    private GeneralConfiguration generalConfiguration;

    private boolean pullDefault;

    private boolean pushDefault;

    protected void onCreate() {
        createdAt = new Date();
    }

    protected void onUpdate() {
        updatedAt = new Date();
    }

    private ArrayList<Mechanism> mechanisms;

    public Configuration() {}

    public Configuration(String name, TriggerType type, Date createdAt, Date updatedAt, List<ConfigurationMechanism> configurationMechanisms, Application application) {
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.configurationMechanisms = configurationMechanisms;
        this.application = application;
    }

    public Configuration(String name, TriggerType type, List<ConfigurationMechanism> configurationMechanisms, Application application) {
        this.name = name;
        this.type = type;
        this.configurationMechanisms = configurationMechanisms;
        this.application = application;
    }

    public Configuration(String name, TriggerType type, Date createdAt, Date updatedAt, List<ConfigurationMechanism> configurationMechanisms, List<ConfigurationUserGroup> configurationUserGroups, Application application, GeneralConfiguration generalConfiguration, ArrayList<Mechanism> mechanisms) {
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.configurationMechanisms = configurationMechanisms;
        this.configurationUserGroups = configurationUserGroups;
        this.application = application;
        this.generalConfiguration = generalConfiguration;
        this.mechanisms = mechanisms;
    }

    public Configuration(String name, TriggerType type, Date createdAt, Date updatedAt, List<ConfigurationMechanism> configurationMechanisms, List<ConfigurationUserGroup> configurationUserGroups, Application application, GeneralConfiguration generalConfiguration, boolean pullDefault, boolean pushDefault, ArrayList<Mechanism> mechanisms) {
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.configurationMechanisms = configurationMechanisms;
        this.configurationUserGroups = configurationUserGroups;
        this.application = application;
        this.generalConfiguration = generalConfiguration;
        this.pullDefault = pullDefault;
        this.pushDefault = pushDefault;
        this.mechanisms = mechanisms;
    }

    @Override
    public String toString() {
        return String.format(
                "Configuration[id=%d, name='%s', type='%s', mechanisms='%s']",
                id, name, type, this.getMechanisms().stream().map(Object::toString)
                        .collect(Collectors.joining(", ")));
    }

    public void filterByLanguage(String language, String fallbackLanguage) {
        for(Mechanism mechanism : this.getMechanisms()) {
            mechanism.setParameters(mechanism.parametersByLanguage(language, fallbackLanguage));
        }
        if(this.generalConfiguration != null) {
            generalConfiguration.setParameters(generalConfiguration.parametersByLanguage(language, fallbackLanguage));
        }
    }

    public long getId() {
        return id;
    }

    public void setMechanisms(List<Mechanism> mechanisms) {
        if(this.configurationMechanisms == null) {
            this.configurationMechanisms = new ArrayList<ConfigurationMechanism>();
        }
        for(Mechanism mechanism : mechanisms) {
            ConfigurationMechanism configurationMechanism = new ConfigurationMechanism(this, mechanism, mechanism.isActive(), mechanism.getOrder(), new Date(), new Date());
            this.configurationMechanisms.add(configurationMechanism);
        }
    }

    public List<Mechanism> getMechanisms() {
        if (this.configurationMechanisms != null) {
            List<Mechanism> mechanisms = new ArrayList<>();
            this.configurationMechanisms.forEach(configurationMechanism -> {
                Mechanism mechanism = configurationMechanism.getMechanism();
                mechanism.setActive(configurationMechanism.isActive());
                mechanism.setOrder(configurationMechanism.getOrder());
                mechanisms.add(mechanism);
            });
            return mechanisms;
        }
        return new ArrayList<Mechanism>();
    }

    public void setUserGroups(ArrayList<UserGroup> userGroups) {
        if(this.configurationUserGroups == null) {
            this.configurationUserGroups = new ArrayList<ConfigurationUserGroup>();
        }
        for(UserGroup userGroup : userGroups) {
            ConfigurationUserGroup configurationUserGroup = new ConfigurationUserGroup(this, userGroup, userGroup.isActive(), new Date(), new Date());
            this.configurationUserGroups.add(configurationUserGroup);
        }
    }

    public List<UserGroup> getUserGroups() {
        if (this.configurationUserGroups != null) {
            List<UserGroup> userGroups = new ArrayList<>();
            this.configurationUserGroups.forEach(configurationUserGroup -> {
                UserGroup userGroup = configurationUserGroup.getUserGroup();
                userGroup.setActive(configurationUserGroup.isActive());
                userGroups.add(userGroup);
            });
            return userGroups;
        }
        return new ArrayList<UserGroup>();
    }

    public boolean containsUserWithUserIdentification(String userIdentification) {
        return this.getUserGroups() != null && this.getUserGroups().stream().filter(userGroup -> userGroup.containsUserWithUserIdentification(userIdentification)).count() > 0;
    }

    public boolean containsUserGroupWithId(long userGroupId) {
        return this.getUserGroups() != null && this.getUserGroups().stream().filter(userGroup -> userGroup.getId() == userGroupId).count() > 0;
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

    public TriggerType getType() {
        return type;
    }

    public void setType(TriggerType type) {
        this.type = type;
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public List<ConfigurationMechanism> getConfigurationMechanisms() {
        return configurationMechanisms;
    }

    public void setConfigurationMechanisms(List<ConfigurationMechanism> configurationMechanisms) {
        this.configurationMechanisms = configurationMechanisms;
    }

    public List<ConfigurationUserGroup> getConfigurationUserGroups() {
        return configurationUserGroups;
    }

    public void setConfigurationUserGroups(List<ConfigurationUserGroup> configurationUserGroups) {
        this.configurationUserGroups = configurationUserGroups;
    }

    public GeneralConfiguration getGeneralConfiguration() {
        return generalConfiguration;
    }

    public void setGeneralConfiguration(GeneralConfiguration generalConfiguration) {
        this.generalConfiguration = generalConfiguration;
    }

    public boolean isPullDefault() {
        return pullDefault;
    }

    public void setPullDefault(boolean pullDefault) {
        this.pullDefault = pullDefault;
    }

    public boolean isPushDefault() {
        return pushDefault;
    }

    public void setPushDefault(boolean pushDefault) {
        this.pushDefault = pushDefault;
    }
}
