package eu.supersede.integration.api.adaptation.types;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;

public class AdaptabilityModel extends IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Date creationDate;
	private Date lastModificationDate;
	private String fileExtension;
	private String systemId;
	private String featureId;
	private String modelContent;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastModificationDate() {
		return lastModificationDate;
	}
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}

}
