package eu.supersede.integration.rest.service.type;

import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Operation {

	UUID uuid;
	String name;
	String returnType;
	
	public Operation(){
		this.uuid = UUID.randomUUID();
	}
	
	public Operation(UUID uuid){
		this.uuid = uuid;
	}
	
	@XmlElement
	public UUID getUuid() {
		return uuid;
	}
	
	public void setUuid(UUID ouuid) {
		this.uuid = ouuid;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	@Override
	public String toString(){
		StringBuffer description = new StringBuffer()
			.append("Operation{")
			.append("name: " + this.name + ", ")
			.append("returnType: " + returnType )
			.append("}");
		return description.toString();
	}
	
	@Override 
	public boolean equals (Object o){
		return (o instanceof Operation) && this.uuid.equals(((Operation)o).uuid);
	}
}
