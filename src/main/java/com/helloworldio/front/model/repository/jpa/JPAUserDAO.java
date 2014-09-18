package com.helloworldio.front.model.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.helloworldio.front.model.domain.HWUser;
import com.helloworldio.front.model.repository.UserDAO;

@Repository(value = "userDao")
public class JPAUserDAO implements UserDAO {
	
	Logger log = LoggerFactory.getLogger("helloworld.io");
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveUser(HWUser user) {
		entityManager.merge(user);
	}

	@Transactional(readOnly = true)
	@Override
	public HWUser getUser(String email, String hashkey) {
		HWUser user = getUser(email);
		if (user != null) {
			if (!hashkey.equals(user.getPassword())) {
				user = null;
			}
		}
		return user;
	}

	@Transactional(readOnly = true)
	@Override
	public boolean userExists(String email) {
		return getUser(email) != null;
	}
	
	@Transactional(readOnly = true)
	@Override
	public HWUser getUserCredentialsByUserId(String userId) {
		return getUser(userId);
	}
	
	private HWUser getUser(String email) {
		TypedQuery<HWUser> query = entityManager.createQuery("SELECT u FROM HWUserImpl u WHERE u.email = :emailParam", HWUser.class);
		query.setParameter("emailParam", email);
		List<HWUser> results = query.getResultList();
		HWUser user = null;
		if (results != null && results.size() > 0) {
			user = results.get(0);
		}
		return user;
	}
}
