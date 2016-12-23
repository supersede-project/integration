package eu.supersede.integration.api.feedback.repository.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import ch.uzh.ifi.feedback.library.rest.Service.ItemBase;
import ch.uzh.ifi.feedback.library.rest.annotations.DbAttribute;
import ch.uzh.ifi.feedback.library.rest.annotations.DbIgnore;
import ch.uzh.ifi.feedback.library.rest.validation.Id;
import ch.uzh.ifi.feedback.library.rest.validation.NotNull;

@JsonInclude(Include.NON_NULL)
public abstract class FileFeedback extends ItemBase<FileFeedback> {

	@Id
	protected Integer id = null;
	
	protected String path;
	
	protected Integer size = null;
		
	@NotNull
	protected String name;
	
	@DbIgnore
	@NotNull
	protected String part;
	
	@DbAttribute("file_extension")
	@NotNull
	protected String fileExtension;
	

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
