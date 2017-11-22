package com.senior.sample;

import java.io.Serializable;

public class User implements Serializable {

	private String email;
	
	private String username;
	
	private String password;

	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + "]";
	}
}
