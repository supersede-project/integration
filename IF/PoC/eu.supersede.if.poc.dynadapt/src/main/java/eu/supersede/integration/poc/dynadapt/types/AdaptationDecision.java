package eu.supersede.integration.poc.dynadapt.types;

import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AdaptationDecision")
public class AdaptationDecision {

	private UUID id;
	private String name;
	private String description;
	private boolean supervised;
	private int priority;
	
	@XmlElement
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public boolean isSupervised() {
		return supervised;
	}

	public void setSupervised(boolean supervised) {
		this.supervised = supervised;
	}

	@XmlElement
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
    public String toString() {
		return "AdaptationDecision{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", supervised='" + supervised + '\'' +
                '}';
	}
}