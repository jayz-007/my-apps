package com.techlab.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class CurrentUserService {
	private SessionMap<String, Object> sessionMap;
	public CurrentUserService() {
		// TODO Auto-generated constructor stub
		this.sessionMap = (SessionMap<String, Object>) ActionContext.getContext().getSession();
	}
	
	
	
	public void setCurrentUserId(String currentUserID) {
		sessionMap.put("currentUserId", currentUserID);
	}
	
	public String getCurrentUSerId() {
		HttpSession currentSession = ServletActionContext.getRequest().getSession(false);
		
		return currentSession.getAttribute("currentUserId").toString();
	}
	


	

}
