package com.pk.main.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pk.main.dao.UserDAO;
import com.pk.main.model.UserDetail;

/**
 * @author PranaySK
 */

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	UserDAO userDAO;

	@Transactional
	@Override
	public Integer saveUser(UserDetail userDetail) throws Exception {
		return userDAO.saveUser(userDetail);
	}

	@Override
	public UserDetail getUserDetail(Integer userId) throws ResourceNotFoundException {
		return userDAO.getUserDetail(userId);
	}

	@Transactional
	@Override
	public Integer store(MultipartFile file, Integer userId, HttpSession session) throws Exception {
		Path rootLocation = Paths.get("src/main/resources/images/");
		// Get the file and save it somewhere
		Path path = Paths.get(rootLocation + File.separator + file.getName());
		Files.write(path, file.getBytes());
		UserDetail userDetail = this.getUserDetail(userId);
		String[] nameExtension = file.getContentType().split("/");
		String profileImage = userId + "." + nameExtension[1];
		System.out.println("ProfileImage :: " + profileImage);

		if (userDetail.getUserId() > 0) {
			if (null == userDetail.getProfileImage() || userDetail.getProfileImage().isBlank()) {
				try {
					Files.copy(file.getInputStream(), rootLocation.resolve(profileImage));
					int result = userDAO.updateProfileImage(profileImage, userId);
					return (result > 0) ? result : -5;
				} catch (Exception exception) {
					throw new Exception("Error while uploading image :: " + exception.getMessage());
				}
			} else {
				try {
					Files.delete(rootLocation.resolve(userDetail.getProfileImage()));
					Files.copy(file.getInputStream(), rootLocation.resolve(profileImage));
					int result = userDAO.updateProfileImage(profileImage, userId);
					return (result > 0) ? result : -5;
				} catch (Exception exception) {
					throw new Exception(
							"Error while uploading image when image is already Exists :: " + exception.getMessage());
				}
			}
		} else {
			return 0;
		}
	}

}
