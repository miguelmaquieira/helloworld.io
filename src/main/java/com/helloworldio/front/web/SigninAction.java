package com.helloworldio.front.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

import com.helloworldio.front.model.service.UserAuthManager;
import com.helloworldio.front.web.domain.SigninUser;

@Component("signinAction")
public class SigninAction extends BaseAction {

	@Autowired
	private UserAuthManager userAuthentication;
	
	@Autowired
	private ShaPasswordEncoder encoder;
	
	public boolean validateUser(SigninUser user, MessageContext messageContext) {
		String hash = encoder.encodePassword(user.getPassword(), user.getEmail());
		user.setPassword(hash);
		boolean authenticateUser = userAuthentication.processUserAuthentication(user);
		if (!authenticateUser) {
			messageContext.addMessage(new MessageBuilder().error().code("singin.validation.userpass.error").build());
		}
		return authenticateUser;
	}
}
