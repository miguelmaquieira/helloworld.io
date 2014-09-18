package com.helloworldio.front.model.repository;

import com.helloworldio.front.model.domain.HWUser;

public interface UserDAO {
	
	public void saveUser(HWUser user);
	public HWUser getUser(String email, String hashkey);
	public HWUser getUserCredentialsByUserId(String userId);
	public boolean userExists(String email);

}
