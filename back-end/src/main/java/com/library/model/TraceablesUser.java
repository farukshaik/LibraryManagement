package com.library.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class TraceablesUser extends User {

	public TraceablesUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username=username;
		this.password=password;
		
	}

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
