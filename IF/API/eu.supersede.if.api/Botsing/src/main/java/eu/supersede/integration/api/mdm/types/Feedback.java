package eu.supersede.integration.api.mdm.types;

public class Feedback {
	String feedback;
	
	public Feedback (){
		
	}
	
	public Feedback (String feedback){
		this.feedback = feedback;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	} 
}
