package com.zsgs.mailmaster.data.dto;

public class Mail 
{
	private int id;
	private String sender;
	private String recipient;
	private String subject;
	private String body;
	private String timestamp;
	
	public Mail(int id, String sender, String recipient, String subject, String body, String timestamp) 
	{
		this.id = id;
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.body = body;
		this.timestamp = timestamp;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Mail{" +
				"id=" + id +
				", sender='" + sender + '\'' +
				", recipient='" + recipient + '\'' +
				", subject='" + subject + '\'' +
				", body='" + body + '\'' +
				", timestamp='" + timestamp + '\'' +
				'}';
	}
}
