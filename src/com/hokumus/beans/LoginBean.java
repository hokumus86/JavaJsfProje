package com.hokumus.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "loginbean")
@SessionScoped
public class LoginBean {

	private String username = "hokumus";
	private String password = "123";
	private boolean islogedin;

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

	public boolean isIslogedin() {
		return islogedin;
	}

	public void setIslogedin(boolean islogedin) {
		this.islogedin = islogedin;
	}
	
	public String toLogin() {
		if(username.equals("hokumus1")&& password.equals("1234")) {
			System.out.println("login baþarýlý");
			islogedin = true;
			System.out.println(username +" " + password);
		}else {
			System.out.println("baþarýsýz");
		}
		
		return null;
	}

}
