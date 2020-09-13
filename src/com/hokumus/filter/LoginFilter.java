package com.hokumus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hokumus.beans.LoginBean;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		LoginBean loginbean = (LoginBean) ((HttpServletRequest)request).getSession().getAttribute("loginbean");
		
		if(loginbean ==null  ) {
			
			String path = ((HttpServletRequest)request).getContextPath();
			((HttpServletResponse)response).sendRedirect(path+"/login.jsf");
		}
		chain.doFilter(request, response);
		// TODO Auto-generated method stub
		
	}

}
