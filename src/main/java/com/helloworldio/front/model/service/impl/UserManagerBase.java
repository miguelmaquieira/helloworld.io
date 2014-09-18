package com.helloworldio.front.model.service.impl;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloworldio.front.model.domain.HWProfileUser;
import com.helloworldio.front.model.domain.HWProfileUserImpl;
import com.helloworldio.front.model.repository.ProfileUserDAO;
import com.helloworldio.front.model.service.UserManager;
import com.helloworldio.front.web.domain.ProfileUser;

@Service("userManager")
public class UserManagerBase implements UserManager {

	private static final long serialVersionUID = -4718706274624738283L;
	
	@Autowired
	private ProfileUserDAO profileUserDAO;
	
	@Resource(name = "beanMapper")
	private Mapper mapper;

	@Override
	public ProfileUser getUserData(String userId) {
		HWProfileUser userData = profileUserDAO.getUserDataByUserId(userId);
		ProfileUser profile = null; 
		if (userData != null) {
			profile = mapper.map(userData, ProfileUser.class);
		}
		return profile;
	}
	
	@Override
	public void updateProfileUser(ProfileUser profileUser) {
		HWProfileUser user = mapper.map(profileUser, HWProfileUserImpl.class);
		profileUserDAO.saveUser(user);
	}
	
	@Override
	public void updateProfileUserProperty(String userId, String property, Object value) {
		profileUserDAO.updateUserData(userId, property, value);
	}
}
