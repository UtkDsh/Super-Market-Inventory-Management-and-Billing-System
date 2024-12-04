package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entity.SystemUser;

public interface SystemUserRepo extends JpaRepository<SystemUser, Long> {
	
	public SystemUser findBySystemUserId(Long id);
	public SystemUser findBySystemUserName(String name);
	public SystemUser findBySystemUserRole(String role);
	public String deleteBySystemUserId(Long id);

}
