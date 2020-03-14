package com.pk.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pk.main.model.UserDetail;
import com.pk.main.service.FileUploadService;

/**
 * @author PranaySK
 */

@RestController
@RequestMapping("/api")
public class FileUploadController {

	@Autowired
	private FileUploadService userService;

	@PostMapping("/saveUser")
	public int saveUser(@RequestBody UserDetail userDetail) throws Exception {
		return userService.saveUser(userDetail);
	}

	@PostMapping("/uploadImage/{userId}")
	public int handleFileUpload(@PathVariable int userId, @RequestParam("file") MultipartFile file, HttpSession session)
			throws Exception {
		return userService.store(file, userId, session);
	}

}
