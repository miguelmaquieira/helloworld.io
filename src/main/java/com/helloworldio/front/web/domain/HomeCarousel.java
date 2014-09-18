package com.helloworldio.front.web.domain;

import java.io.Serializable;

public class HomeCarousel implements Serializable {
	
	private static final long serialVersionUID = 8144340671615415724L;
	
	private int index;
	private boolean active;
	private String image;
	private String caption;
	
	public HomeCarousel(int index, boolean active, String image, String caption) {
		this.index = index;
		this.active = active;
		this.image = image;
		this.caption = caption;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}

}
