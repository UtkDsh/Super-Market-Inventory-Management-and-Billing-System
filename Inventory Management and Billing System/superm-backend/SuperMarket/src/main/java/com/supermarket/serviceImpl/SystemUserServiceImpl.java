package com.supermarket.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dto.SystemUserDTO;
import com.supermarket.entity.SystemUser;
import com.supermarket.repository.SystemUserRepo;
import com.supermarket.service.SystemUserService;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private SystemUserRepo urepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public SystemUserDTO addUser(SystemUserDTO systemUserDTO) {
	
		SystemUser usr=new SystemUser();
		usr=modelMapper.map(systemUserDTO, SystemUser.class);
		urepo.save(usr);
		systemUserDTO=modelMapper.map(usr, SystemUserDTO.class);
		return systemUserDTO;
		
	}

	@Override
	public SystemUserDTO getUser(Long userId) {
		
		SystemUser usr=urepo.findBySystemUserId(userId);
		SystemUserDTO usrdto=modelMapper.map(usr, SystemUserDTO.class);
		return usrdto;
		
	}

	@Override
	public String deleteUserById(Long id) {
		
		urepo.deleteById(id);
		return "User deleted Successfully";
		
	}

	@Override
	public SystemUserDTO loginUser(SystemUserDTO systemUserDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SystemUserDTO> getAllUsers() {
		
		List<SystemUser> users=urepo.findAll();
		List<SystemUserDTO> usrsdto=users.stream().map(e->modelMapper.map(e, SystemUserDTO.class))
				.collect(Collectors.toList());
		return usrsdto;
		
	}

	@Override
	public SystemUserDTO updateUser(SystemUserDTO systemUserDTO, Long userId) {
		
		SystemUser existinguser=urepo.findBySystemUserId(userId);
		modelMapper.map( systemUserDTO,existinguser);
		urepo.save(existinguser);
		return modelMapper.map(existinguser,SystemUserDTO.class);
	}

	@Override
	public SystemUserDTO getUserByUserName(String username) {
		SystemUser usr=urepo.findBySystemUserName(username);
		SystemUserDTO usrdto=modelMapper.map(usr, SystemUserDTO.class);
		return usrdto;
	}

	
}
