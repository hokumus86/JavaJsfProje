package com.hokumus.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigationsbean")
@SessionScoped
public class NavigationsBean {
	
	public String redirectIndex() {
		return "/AdminPanel/index.jsf?faces-redirect=true";
		
	}

}
