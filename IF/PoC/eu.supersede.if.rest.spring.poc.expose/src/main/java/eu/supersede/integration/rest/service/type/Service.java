package eu.supersede.integration.rest.service.type;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Service {
	
	URI uri;
	String name;
	String description;
	Boolean available;
	List<Operation> operations = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Override
	public String toString(){
		StringBuffer description = new StringBuffer()
			.append("Service{")
			.append("URI: " + uri + ", ")
			.append("name: " + name + ", ")
			.append("description: " + this.description + ", ")
			.append("is availble: " + available + ", ")
			.append("has operations: {");
		for (Operation op: operations){
			description.append(op);
		}
        description.append("}}");
		return description.toString();
	}
	
	@Override 
	public boolean equals (Object o){
		return (o instanceof Service) && 
		this.uri.equals (((Service)o).uri);
	}
}
