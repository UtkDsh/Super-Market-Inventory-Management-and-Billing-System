package com.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.dto.SystemUserDTO;
import com.supermarket.service.SystemUserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/user")
public class SystemUserController {

	@Autowired
	private SystemUserService uservice;
	
	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> createUser(@RequestBody SystemUserDTO systemUserDTO)
	{
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(uservice.addUser(systemUserDTO));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could"
					+ "not create User");
		}
	}
		
		@GetMapping("/getuserbyid/{userId}")
		public ResponseEntity<?> getUser(@PathVariable Long userId)
		{
			try {
				return ResponseEntity.status(HttpStatus.OK).body(uservice.getUser(userId));
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
			}
		}
		
		@GetMapping("/getuserbyusername/{userName}")
		public ResponseEntity<?> getUserbyusername(@PathVariable String userName)
		{
			try {
				return ResponseEntity.status(HttpStatus.OK).body(uservice.getUserByUserName(userName)
						);
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
			}
		}
		
		
		@GetMapping("/getallusers")
		public ResponseEntity<?> getallusers()
		{
			try {
				
				return ResponseEntity.status(HttpStatus.OK).body(uservice.getAllUsers());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found");
			}
		}
		
		@DeleteMapping("/deleteuserbyid/{userId}")
		public ResponseEntity<?> deleteuser(@PathVariable Long userId)
		{
			try {
				
				return ResponseEntity.status(HttpStatus.OK).body(uservice.deleteUserById(userId));
			} catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User could not be deleted");
			}
		}
		
		
		@PutMapping("/updateuser/{userId}")
		public ResponseEntity<?> updateUser(@RequestBody SystemUserDTO systemUserDTO,@PathVariable Long userId)
		{
			try {
				return ResponseEntity.status(HttpStatus.OK).body(uservice.updateUser(systemUserDTO, userId));
				
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not update User");
			}
		}
		
		
	}
	
	
	
	
	

