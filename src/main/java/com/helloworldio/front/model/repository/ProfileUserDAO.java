package com.helloworldio.front.model.repository;


import com.helloworldio.front.model.domain.HWProfileUser;

public interface ProfileUserDAO {

	public void saveUser(HWProfileUser user);
	public void updateUserData(String userId, String property, Object value);
	public HWProfileUser getUserDataByUserId(String userId);
}
