package com.helloworldio.front.web.domain;

import java.io.Serializable;

public class Language implements Serializable {

	private static final long serialVersionUID = -7913848372924444712L;
	
	private String name;
	private String locale;
	private String icon;
	
	public Language() {}
	
	public Language(String name, String locale) {
		this.name = name;
		this.locale = locale;
	}
	
	public Language(String name, String locale, String icon) {
		this.name = name;
		this.locale = locale;
		this.icon = icon;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public static Language fromString(String languageDef) {
		return null;
	}
}
