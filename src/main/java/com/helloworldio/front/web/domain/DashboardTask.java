package com.helloworldio.front.web.domain;

import java.io.Serializable;

public class DashboardTask implements Serializable {

	private static final long serialVersionUID = 7149083269617826338L;
	
	private String name;
	private int progress;
	private String status;
	
	public DashboardTask(String name, int progress, String status) {
		this.name = name;
		this.progress = progress;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
