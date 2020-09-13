package com.hokumus.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginbean")
@SessionScoped
public class LoginBean {

	private String username = "hokumus1";
	private String password = "1234";
	private boolean islogedin;

	@ManagedProperty(value = "#{navigationsbean}")
	private NavigationsBean navigationbean;

	public NavigationsBean getNavigationbean() {
		return navigationbean;
	}

	public void setNavigationbean(NavigationsBean navigationbean) {
		this.navigationbean = navigationbean;
	}

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
		if (username.equals("hokumus1") && password.equals("1234")) {
			System.out.println("login baþarýlý");
			islogedin = true;
			System.out.println(username + " " + password);
			return navigationbean.redirectIndex();
		}
		FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		// To to login page
		return navigationbean.redirectIndex();

	}

}
