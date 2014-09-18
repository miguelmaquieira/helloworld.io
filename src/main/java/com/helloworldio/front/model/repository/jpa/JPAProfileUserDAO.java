package com.helloworldio.front.model.repository.jpa;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.helloworldio.front.model.domain.HWProfileUser;
import com.helloworldio.front.model.repository.ProfileUserDAO;

@Repository(value = "profileUserDao")
public class JPAProfileUserDAO implements ProfileUserDAO {
	
	Logger log = LoggerFactory.getLogger("helloworld.io");
	
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveUser(HWProfileUser user) {
		entityManager.merge(user);
	}
	
	@Transactional(readOnly = true)
	@Override
	public HWProfileUser getUserDataByUserId(String userId) {
		return getUser(userId);
	}
	
	private HWProfileUser getUser(String userId) {
		TypedQuery<HWProfileUser> query = entityManager.createQuery("SELECT u FROM HWProfileUserImpl u WHERE u.userId = :userIdParam", HWProfileUser.class);
		query.setParameter("userIdParam", userId);
		List<HWProfileUser> results = query.getResultList();
		HWProfileUser user = null;
		if (results != null && results.size() > 0) {
			user = results.get(0);
		}
		return user;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateUserData(String userId, String property, Object value) {
		HWProfileUser user = getUser(userId);
		try {
			BeanUtils.setProperty(user, property, value);
		} catch (IllegalAccessException iae) {
			log.warn("Exception updating property: " + property + " for user: " + userId, iae);
		} catch (InvocationTargetException ite) {
			log.warn("Exception updating property: " + property + " for user: " + userId, ite);
		}
		saveUser(user);
	}	
}
