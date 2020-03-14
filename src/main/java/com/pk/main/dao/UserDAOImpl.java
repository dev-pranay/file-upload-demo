package com.pk.main.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import com.pk.main.model.UserDetail;

/**
 * @author PranaySK
 */

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer saveUser(UserDetail userDetail) throws Exception {
		try {
			return (Integer) sessionFactory.getCurrentSession().save(userDetail);
		} catch (Exception e) {
			throw new Exception("Exception in saving data into the database " + e.getMessage());
		}
	}

	@Override
	public UserDetail getUserDetail(Integer userId) {
		try {
			return sessionFactory.getCurrentSession().get(UserDetail.class, userId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Exception in getting data from the database " + e.getMessage());
		}
	}

	@Override
	public Integer updateProfileImage(String profileImage, Integer userId) throws Exception {
		Integer result = 0;
		try {
			@SuppressWarnings("unchecked")
			Query<UserDetail> query = sessionFactory.getCurrentSession()
					.createQuery("update UserDetail set profileImage = :profileImage where userId = :userId");
			query.setParameter("profileImage", profileImage);
			query.setParameter("userId", userId);
			result = query.executeUpdate();

			return (result > 0) ? result : -result;

		} catch (Exception e) {
			throw new Exception("Exception while updating profileImage from DAO " + e.getMessage());
		}
	}

}
