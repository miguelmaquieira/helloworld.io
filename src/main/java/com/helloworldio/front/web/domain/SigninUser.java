package com.helloworldio.front.web.domain;

import org.springframework.stereotype.Component;

@Component("signinUser")
public class SigninUser extends SignUser {

	private static final long serialVersionUID = -7081617990665398850L;
	
	private boolean remember;
	
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
}
