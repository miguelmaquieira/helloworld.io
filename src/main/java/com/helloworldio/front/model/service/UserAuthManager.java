package com.helloworldio.front.model.service;

import com.helloworldio.front.web.domain.SignUser;
import com.helloworldio.front.web.domain.SignupUser;

public interface UserAuthManager {
	
	public boolean processUserAuthentication(SignUser user);
	public boolean validateUserData(SignupUser user);
	public boolean createUser(SignupUser user, boolean validate);
}
