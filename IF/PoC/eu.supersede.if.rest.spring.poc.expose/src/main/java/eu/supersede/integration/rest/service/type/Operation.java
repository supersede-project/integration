package eu.supersede.integration.rest.service.type;

public class Operation {

	String name;
	String returnType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
		return (o instanceof Operation) && 
		this.name.equals (((Operation)o).name) && this.returnType.equals(((Operation)o).returnType);
	}
}
