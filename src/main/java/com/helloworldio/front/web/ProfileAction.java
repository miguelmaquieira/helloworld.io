package com.helloworldio.front.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.helloworldio.common.support.ReloadableAdvancedResourceBundleMessageSource;
import com.helloworldio.front.model.service.UserManager;
import com.helloworldio.front.web.domain.ProfileUser;

@Component("profileAction")
public class ProfileAction extends BaseAction {

	@Autowired
	private UserManager userManager;
	
	@Autowired
	private ReloadableAdvancedResourceBundleMessageSource messageResource;
	
	public ProfileUser loadProfileData() {
		
		Authentication credentials = SecurityContextHolder.getContext().getAuthentication();
		String userId = credentials.getName();
		
		ProfileUser profileUser = userManager.getUserData(userId);
		String genderCode = profileUser.getGender();
		if (genderCode != null) {
			String gender = messageResource.getMessage(genderCode, null, LocaleContextHolder.getLocale());
			profileUser.setGender(gender);
		}
		
		return profileUser;
	}
}
