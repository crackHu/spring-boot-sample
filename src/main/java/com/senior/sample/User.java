package com.senior.sample;

public class User {

	private String email;
	
	private String username;
	
	private String password;

	public User() {
		super();
	}

	public User(String username) {
		super();
		this.username = username;
	}

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
