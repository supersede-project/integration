/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.api.mail.types;

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
