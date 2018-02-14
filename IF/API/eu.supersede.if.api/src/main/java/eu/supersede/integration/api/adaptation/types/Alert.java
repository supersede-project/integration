package eu.supersede.integration.api.adaptation.types;

import java.util.List;

public class Alert {

	String id;
	String applicationId;
	long timestamp;
	ModelSystem tenant;
	List<Condition> conditions;
	List<ActionOnFeature> actionFeatures;
	List<ActionOnAttribute> actionAttributes;
	List<AttachedValue> attachedValues;

	public Alert(String id, String applicationId, long timestamp, ModelSystem tenant, List<Condition> conditions,
			List<ActionOnFeature> actionFeatures, List<ActionOnAttribute> actionAttributes,
			List<AttachedValue> attachedValues) {
		super();
		this.id = id;
		this.applicationId = applicationId;
		this.timestamp = timestamp;
		this.tenant = tenant;
		this.conditions = conditions;
		// this.requests = requests;
		this.actionFeatures = actionFeatures;
		this.actionAttributes = actionAttributes;
		this.attachedValues = attachedValues;
	}

	public Alert() {}

	public String getId() {
		return this.id;
	}

	public String getApplicationId() {
		return this.applicationId;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public ModelSystem getTenant() {
		return this.tenant;
	}

	public List<Condition> getConditions() {
		return this.conditions;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setTenant(ModelSystem tenant) {
		this.tenant = tenant;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<ActionOnFeature> getActionFeatures() {
		return this.actionFeatures;
	}

	public void setActionFeatures(List<ActionOnFeature> actionFeatures) {
		this.actionFeatures = actionFeatures;
	}

	public List<ActionOnAttribute> getActionAttributes() {
		return this.actionAttributes;
	}

	public void setActionAttributes(List<ActionOnAttribute> actionAttributes) {
		this.actionAttributes = actionAttributes;
	}

	public List<AttachedValue> getAttachedValues() {
		return this.attachedValues;
	}

	public void setAttachedValues(List<AttachedValue> attachedValues) {
		this.attachedValues = attachedValues;
	}

}
