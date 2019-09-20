package eu.supersede.integration.api.adaptation.types;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import eu.supersede.integration.api.json.CustomJsonDateDeserializer;
import eu.supersede.integration.api.json.ModelRepositoryJsonDateSerializer;

@JsonInclude(Include.NON_NULL)
public class GenericModel extends IModel {
	
	private String id;
	private String name;
	private String authorId;
	private Date creationDate;
	private Date lastModificationDate;
	private String fileExtension;
	private ModelSystem systemId;
	private String modelContent;
	private String relativePath;
	private List<TypedModelId> dependencies = new ArrayList<TypedModelId>();
	
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
	@JsonSerialize(using = ModelRepositoryJsonDateSerializer.class)
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getLastModificationDate() {
		return lastModificationDate;
	}
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = ModelRepositoryJsonDateSerializer.class)
	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public ModelSystem getSystemId() {
		return systemId;
	}
	public void setSystemId(ModelSystem systemId) {
		this.systemId = systemId;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}
	public List<TypedModelId> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<TypedModelId> dependencies) {
		this.dependencies = dependencies;
	}

}
