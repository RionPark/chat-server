package com.dev.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.chat.service.UserService;
import com.dev.chat.vo.UserVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users/join")
	public UserVO insertUser( @Valid @ModelAttribute UserVO user) {
		return userService.insertUser(user);
	}
	
	@PostMapping("/users/login")
	public UserVO login(@RequestBody UserVO user) {
		return userService.login(user);
	}
}
