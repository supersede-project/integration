package eu.supersede.integration.api.common.types;

import java.util.Arrays;
import java.util.List;

public class Email {
	String subject = "";
    String to = "";
    String cc = "";
    String bcc = "";
    String body = "";
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	
	public void addToRecipient(String recipient){
		to = to + "," + recipient;
	}
	
	public List<String> getToRecipients() {
		return Arrays.asList(to.split(","));
	}
	
//	public void setTo(String to) {
//		this.to = to;
//	}
	public String getCc() {
		return cc;
	}
	
	public void addCcRecipient(String recipient){
		cc = cc + "," + recipient;
	}
	
	public List<String> getCcRecipients() {
		return Arrays.asList(cc.split(","));
	}
	
//	public void setCc(String cc) {
//		this.cc = cc;
//	}
	public String getBcc() {
		return bcc;
	}
	
	public void addBccRecipient(String recipient){
		bcc = bcc + "," + recipient;
	}
	
	public List<String> getBccRecipients() {
		return Arrays.asList(bcc.split(","));
	}
	
	
	
//	public void setBcc(String bcc) {
//		this.bcc = bcc;
//	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
