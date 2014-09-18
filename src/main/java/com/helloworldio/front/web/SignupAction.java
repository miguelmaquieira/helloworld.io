package com.helloworldio.front.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

import com.helloworldio.front.model.service.UserAuthManager;
import com.helloworldio.front.web.domain.SignupUser;

@Component("signupAction")
public class SignupAction extends BaseAction {
	
	@Autowired
	private UserAuthManager userAuthManager;
	
	@Autowired
	private ShaPasswordEncoder encoder;
	
	public boolean validateUser(SignupUser user, MessageContext messageContext) {
		boolean valid = userAuthManager.validateUserData(user);
		if (!valid) {
			messageContext.addMessage(new MessageBuilder().error().code("singup.validation.email.error").build());
		}
		return valid;
	}

	public boolean createUser(SignupUser user, MessageContext messageContext) {
		String hash = encoder.encodePassword(user.getPassword(), user.getEmail());
		user.setPassword(hash);
		return userAuthManager.createUser(user, false);
	}
}
