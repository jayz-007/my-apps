package com.techlab.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class LogoutAction implements Action, SessionAware {
	private SessionMap<String, Object> sessionMap;

	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = (SessionMap<String, Object>) session;

	}
	
	@Override
	public String execute() throws Exception {
		sessionMap.put("loggedIn", null);
		sessionMap.put("isAdmin", null);
		return "success";
	}

	
}
