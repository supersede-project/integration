package eu.supersede.integration.api.feedback.orchestrator.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import eu.supersede.integration.api.monitoring.manager.types.Method;

import javax.validation.constraints.NotNull;


@JsonInclude(Include.NON_NULL)
public class MonitorConfiguration {

    @JsonIgnore
    private long id;

    @JsonIgnore
    private MonitorTool monitorTool;

    private long monitorManagerId;
    
    @NotNull
    private String configSender;
    @NotNull
    private String timeStamp;
    @NotNull
    private String timeSlot;
    private String kafkaEndpoint;
    @NotNull
    private String kafkaTopic;
    @NotNull
    private String state;

    /*
     * SocialNetwork params
     */
    private String keywordExpression;
    //private List<String> accounts;

    /*
     * MarketPlaces params
     */
    private String packageName;
    private String appId;
    
    /*
     * QoS params
     */
    private String url;
    private Method method;

    public MonitorConfiguration() {
    }

    public MonitorConfiguration(MonitorTool monitorTool, String configSender, String timeStamp, String timeSlot, String kafkaEndpoint, String kafkaTopic, String state, String keywordExpression, String packageName, String appId, String url) {
        this.monitorTool = monitorTool;
        this.configSender = configSender;
        this.timeStamp = timeStamp;
        this.timeSlot = timeSlot;
        this.kafkaEndpoint = kafkaEndpoint;
        this.kafkaTopic = kafkaTopic;
        this.state = state;
        this.keywordExpression = keywordExpression;
        this.packageName = packageName;
        this.appId = appId;
        this.url = url;
    }

    public MonitorConfiguration(MonitorTool monitorTool, long monitorManagerId, String configSender, String timeStamp, String timeSlot, String kafkaEndpoint, String kafkaTopic, String state, String keywordExpression, String packageName, String appId, String url, Method method) {
        this.monitorTool = monitorTool;
        this.monitorManagerId = monitorManagerId;
        this.configSender = configSender;
        this.timeStamp = timeStamp;
        this.timeSlot = timeSlot;
        this.kafkaEndpoint = kafkaEndpoint;
        this.kafkaTopic = kafkaTopic;
        this.state = state;
        this.keywordExpression = keywordExpression;
        this.packageName = packageName;
        this.appId = appId;
        this.url = url;
        this.method = method;
    }

    @Override
    public String toString() {
        return String.format(
                "MonitorConfiguration[id=%d, monitorTool='%s', configSender='%s', " +
                        "timeStamp='%s', timeSlot='%s', kafkaEndpoint='%s', " +
                        "kafkaTopic='%s', state='%s', keywordExpression='%s', packageName='%s', appId='%s', url='%s']",
                id, monitorTool, configSender,
                timeStamp, timeSlot, kafkaEndpoint,
                kafkaTopic, state, keywordExpression, packageName, appId, url);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MonitorTool getMonitorTool() {
        return monitorTool;
    }

    public void setMonitorTool(MonitorTool monitorTool) {
        this.monitorTool = monitorTool;
    }

    public String getConfigSender() {
        return configSender;
    }

    public void setConfigSender(String configSender) {
        this.configSender = configSender;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getKafkaEndpoint() {
        return kafkaEndpoint;
    }

    public void setKafkaEndpoint(String kafkaEndpoint) {
        this.kafkaEndpoint = kafkaEndpoint;
    }

    public String getKafkaTopic() {
        return kafkaTopic;
    }

    public void setKafkaTopic(String kafkaTopic) {
        this.kafkaTopic = kafkaTopic;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getKeywordExpression() {
        return keywordExpression;
    }

    public void setKeywordExpression(String keywordExpression) {
        this.keywordExpression = keywordExpression;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getUrl() {
    	return url;
    }
    
    public void setUrl(String url) {
    	this.url = url;
    }
    
    public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
    
    public long getMonitorManagerId() {
    	return monitorManagerId;
    }
    
    public void setMonitorManagerId(long id) {
    	this.monitorManagerId = id;
    }
}
