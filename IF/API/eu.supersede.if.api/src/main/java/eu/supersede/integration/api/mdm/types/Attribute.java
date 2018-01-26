package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

public class Attribute implements Serializable{
	private String iri;
	private String name;
	public String getIri() {
		return iri;
	}
	public void setIri(String iri) {
		this.iri = iri;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
