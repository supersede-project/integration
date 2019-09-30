package eu.supersede.integration.api.adaptation.types;

public class AttachedValue {

	private String idData;
	private String value;

	public AttachedValue() {
	}

	public AttachedValue(String idData, String value) {
		super();
		this.idData = idData;
		this.value = value;
	}

	public String getIdData() {
		return this.idData;
	}

	public void setIdData(String idData) {
		this.idData = idData;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
