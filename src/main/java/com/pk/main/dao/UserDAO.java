package com.pk.main.dao;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.pk.main.model.UserDetail;

/**
 * @author PranaySK
 */

public interface UserDAO {
	public Integer saveUser(UserDetail userDetail) throws Exception;

	public UserDetail getUserDetail(Integer userId) throws ResourceNotFoundException;

	public Integer updateProfileImage(String profileImage, Integer userId) throws Exception;
}
