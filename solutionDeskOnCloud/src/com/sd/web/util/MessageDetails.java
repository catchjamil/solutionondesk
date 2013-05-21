package com.sd.web.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MessageDetails {
	

	private Date received;
	private String from;
	private List<String> to = new ArrayList<String>();
	private List<String> cc = new ArrayList<String>();
	private List<String> bcc = new ArrayList<String>();
	

	public String getToRecp() {
		return toRecp;
	}
	public void setToRecp(String toRecp) {
		this.toRecp = toRecp;
	}
	public String getCcRecp() {
		return ccRecp;
	}
	public void setCcRecp(String ccRecp) {
		this.ccRecp = ccRecp;
	}
	public String getBccRecp() {
		return bccRecp;
	}
	public void setBccRecp(String bccRecp) {
		this.bccRecp = bccRecp;
	}
	private String toRecp;
	private String ccRecp;
	private String bccRecp;
	
	private String subject;
	private String body;
	private List<EmailAttachment> attachments = new ArrayList<EmailAttachment>();

	 public Date getReceived() {
		return received;
	}
	public void setReceived(Date received) {
		this.received = received;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public List<String> getCc() {
		return cc;
	}
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	public List<String> getBcc() {
		return bcc;
	}
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public List<EmailAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<EmailAttachment> attachments) {
		this.attachments = attachments;
	}

}
