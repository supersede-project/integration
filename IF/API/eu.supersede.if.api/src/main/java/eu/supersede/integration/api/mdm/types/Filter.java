package eu.supersede.integration.api.mdm.types;

import java.io.Serializable;

public class Filter implements Serializable{
	private String comparator;
	private String leftOperand;
	private String rightOperand;
	private CER_Event event;
	
	public String getComparator() {
		return comparator;
	}
	public void setComparator(String comparator) {
		this.comparator = comparator;
	}
	public String getLeftOperand() {
		return leftOperand;
	}
	public void setLeftOperand(String leftOperand) {
		this.leftOperand = leftOperand;
	}
	public String getRightOperand() {
		return rightOperand;
	}
	public void setRightOperand(String rightOperand) {
		this.rightOperand = rightOperand;
	}
	public CER_Event getEvent() {
		return event;
	}
	public void setEvent(CER_Event event) {
		this.event = event;
	}
}

