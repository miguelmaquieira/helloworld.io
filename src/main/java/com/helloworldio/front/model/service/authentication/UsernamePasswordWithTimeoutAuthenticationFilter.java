package com.helloworldio.front.model.service.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class UsernamePasswordWithTimeoutAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	private boolean postOnly;

	@Override
	public void setPostOnly(boolean postOnly) {
		super.setPostOnly(postOnly);
		this.postOnly = postOnly;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (postOnly && !"POST".equals(request.getMethod())) {
			throw new AuthenticationServiceException("Authentication method not supported: "
					+ request.getMethod());
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if (username == null) {
			username = "";
		} else {
			username = username.trim();
		}
		if (password == null) {
			password = "";
		}

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		setDetails(request, authRequest);

		return getAuthenticationManager().authenticate(authRequest);
	}
}