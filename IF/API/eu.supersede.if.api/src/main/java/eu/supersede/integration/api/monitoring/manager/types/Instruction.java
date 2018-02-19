package eu.supersede.integration.api.monitoring.manager.types;

public class Instruction {
	String label;
	String instruction;
	
	public Instruction(String label, String instruction) {
		super();
		this.instruction = instruction;
		this.label = label;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
