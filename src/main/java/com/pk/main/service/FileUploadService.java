package com.pk.main.service;

import javax.servlet.http.HttpSession;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import com.pk.main.model.UserDetail;

/**
 * @author PranaySK
 */

public interface FileUploadService {

	public Integer saveUser(UserDetail userDetail) throws Exception;

	public UserDetail getUserDetail(Integer userId) throws ResourceNotFoundException;

	public Integer store(MultipartFile file, Integer userId, HttpSession session) throws Exception;

}
