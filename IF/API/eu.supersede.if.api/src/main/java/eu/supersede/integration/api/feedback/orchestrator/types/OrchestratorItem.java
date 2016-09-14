package eu.supersede.integration.api.feedback.orchestrator.types;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import eu.supersede.integration.api.json.CustomJsonTimestampDeserializer;

public abstract class OrchestratorItem<T> extends ItemBase<T> implements IOrchestratorItem<T> {

	@DbAttribute("current_version")
	private transient boolean currentVersion;
	
	@DbAttribute("created_at")
	private Timestamp createdAt;
	
	@Override
	public abstract Integer getId();

	@Override
	public abstract void setId(Integer id);

	public boolean isCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(boolean currentVersion) {
		this.currentVersion = currentVersion;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	@JsonDeserialize(using = CustomJsonTimestampDeserializer.class)
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
