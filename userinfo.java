package com.phase1.project1.simplilearn;

import java.io.Serializable;

public class userinfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String loginSite;
	private String  userloggedIn;
	private String user_name;
	private String password;
	
	public userinfo() {}

	public userinfo(String loginSite, String userloggedIn, String user_name, String password) {
		this.loginSite = loginSite;
		this.userloggedIn = userloggedIn;
		this.user_name = user_name;
		this.password = password;
	}

	public String getSiteName() {
		return loginSite;
	}

	public void setSiteName(String loginSite) {
		this.loginSite = loginSite;
	}

	public String getUserLoggedIn() {
		return userloggedIn;
	}

	public void setUserLoggedIn(String userloggedIn) {
		this.userloggedIn = userloggedIn;
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
		return "UserCredentials [LoginSite=" + loginSite + 
				", UserloggedIn=" + userloggedIn + 
				", username=" + user_name
				+ ", password=" + password + "]";
	}

}

