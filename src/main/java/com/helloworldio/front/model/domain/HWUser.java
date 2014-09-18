package com.helloworldio.front.model.domain;

import java.io.Serializable;

public interface HWUser extends Serializable {

	public String getEmail();
	public String getToken();
	public String getPassword();
	public void setPassword(String password);
	
	public void setEmail(String email);
	public void setToken(String token);
	public int getStatus();
	public void setStatus(int status);
	
}
