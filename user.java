package com.phase1.project1.simplilearn;

public class user {
	private String user_name;
	private String password;
	
	public user() {}

	public user(String user_name, String password) {
		this.user_name = user_name;
		this.password = password;
	}

	public String getUsername() {
		return user_name;
	}

	public void setUsername(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "user [username=" + user_name + ", password=" + password + "]";
	}


}

