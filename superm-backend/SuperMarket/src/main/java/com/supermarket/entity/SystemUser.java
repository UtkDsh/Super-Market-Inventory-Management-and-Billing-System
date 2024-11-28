package com.supermarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SystemUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long systemUserId;
	private String systemUserName;
	private String systemUserPassword;
	private String systemUserRole;
	public Long getSystemUserId() {
		return systemUserId;
	}
	public void setSystemUserId(Long systemUserId) {
		this.systemUserId = systemUserId;
	}
	public String getSystemUserName() {
		return systemUserName;
	}
	public void setSystemUserName(String systemUserName) {
		this.systemUserName = systemUserName;
	}
	public String getSystemUserPassword() {
		return systemUserPassword;
	}
	public void setSystemUserPassword(String systemUserPassword) {
		this.systemUserPassword = systemUserPassword;
	}
	public String getSystemUserRole() {
		return systemUserRole;
	}
	public void setSystemUserRole(String systemUserRole) {
		this.systemUserRole = systemUserRole;
	}
	public SystemUser(Long systemUserId, String systemUserName, String systemUserPassword, String systemUserRole) {
		super();
		this.systemUserId = systemUserId;
		this.systemUserName = systemUserName;
		this.systemUserPassword = systemUserPassword;
		this.systemUserRole = systemUserRole;
	}
	
	public SystemUser()
	{
		
	}
	
	
}
