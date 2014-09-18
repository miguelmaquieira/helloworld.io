package com.helloworldio.front.model.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.helloworldio.front.model.domain.HWProfileUser;
import com.helloworldio.front.model.domain.HWProfileUserImpl;
import com.helloworldio.front.model.domain.HWUser;
import com.helloworldio.front.model.domain.HWUserImpl;
import com.helloworldio.front.model.repository.ProfileUserDAO;
import com.helloworldio.front.model.repository.UserDAO;
import com.helloworldio.front.model.service.UserAuthManager;
import com.helloworldio.front.web.domain.SignUser;
import com.helloworldio.front.web.domain.SignupUser;

@Service("authManager")
public class UserAuthenticationBase implements UserAuthManager, UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ProfileUserDAO profileUserDAO;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Resource(name = "beanMapper")
	private Mapper mapper;

	@Override
	public boolean processUserAuthentication(SignUser user) {
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);	
			return true;
		} catch (AuthenticationException ae) {
			return false;
		}
	}
	
	@Override
	public boolean createUser(SignupUser user, boolean validate) {
		boolean userCreated = true;
		if (validate && userDAO.userExists(user.getEmail())) {
			userCreated = false;
		} else {
			userCreated = createNewUser(user);
			if (userCreated) {
				createNewProfile(user);
			}
		}
		return userCreated;
	}
	
	@Override
	public boolean validateUserData(SignupUser user) {
		return !userDAO.userExists(user.getEmail());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		HWUser user = userDAO.getUserCredentialsByUserId(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No such user with 'id' provided '%s'", username));
		}
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		User userDetails = new User(user.getEmail(), user.getPassword(), authorities);
		return userDetails;
	}
	
	private boolean createNewUser(SignupUser user) {
		boolean userCreated = true;
		HWUser userJPA = mapper.map(user, HWUserImpl.class);
		try {
			BeanUtils.copyProperties(userJPA, user);
			userDAO.saveUser(userJPA);
		} catch (IllegalAccessException iae) {
			// TODO logs
			iae.printStackTrace();
			userCreated = false;
		} catch (InvocationTargetException e) {
			// TODO logs
			e.printStackTrace();
			userCreated = false;
		}
		return userCreated;
	}
	
	private boolean createNewProfile(SignupUser user) {
		boolean userCreated = true;
		HWProfileUser userJPA = mapper.map(user, HWProfileUserImpl.class);
		try {
			BeanUtils.copyProperties(userJPA, user);
			profileUserDAO.saveUser(userJPA);
		} catch (IllegalAccessException iae) {
			// TODO logs
			iae.printStackTrace();
			userCreated = false;
		} catch (InvocationTargetException e) {
			// TODO logs
			e.printStackTrace();
			userCreated = false;
		}
		return userCreated;
	}
}
