package com.supermarket.service;

import java.util.List;

import com.supermarket.dto.SystemUserDTO;


public interface SystemUserService {

	public SystemUserDTO addUser(SystemUserDTO systemUserDTO);
	public SystemUserDTO getUser(Long userId);
	public SystemUserDTO getUserByUserName(String username);
	public List<SystemUserDTO> getAllUsers();
	public String deleteUserById(Long id);
	public SystemUserDTO updateUser(SystemUserDTO systemUserDTO,Long userId);
	public SystemUserDTO loginUser(SystemUserDTO systemUserDTO);
	
}
