package com.helloworldio.front.model.service;

import java.io.Serializable;

import com.helloworldio.front.web.domain.ProfileUser;

public interface UserManager extends Serializable {

	public ProfileUser getUserData(String userId);
	public void updateProfileUserProperty(String userId, String property, Object value);
	public void updateProfileUser(ProfileUser profileUser);
	
}
