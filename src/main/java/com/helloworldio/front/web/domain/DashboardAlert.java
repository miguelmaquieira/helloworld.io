package com.helloworldio.front.web.domain;

import java.io.Serializable;

public class DashboardAlert implements Serializable {

	private static final long serialVersionUID = 5742066483967565839L;
	
	private String icon;
	private String message;
	private String since;
	
	public DashboardAlert(String message, String since, String icon) {
		this.message = message;
		this.since = since;
		this.icon = icon;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSince() {
		return since;
	}
	public void setSince(String since) {
		this.since = since;
	}
}
