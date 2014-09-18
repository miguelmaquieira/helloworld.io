package com.helloworldio.front.web.domain;

import java.io.Serializable;

public class DashboardMessage implements Serializable {
	
	private static final long serialVersionUID = -9215272533962379645L;
	
	private String messageText;
	private String from;
	private String date;
	
	public DashboardMessage(String message, String from, String date) {
		this.messageText = message;
		this.from = from;
		this.date = date;
	}
	
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String message) {
		this.messageText = message;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
