package com.supermarket.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.dto.SystemUserDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/register")
public class RegisterController {

	@PostMapping("/registeruser")
	public void loginUser(SystemUserDTO userdto)
	{
		
	}
	
}
