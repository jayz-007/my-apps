package com.techlab.service;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class CurrentTaskService {
	private SessionMap<String, Object> sessionMap;

	public CurrentTaskService() {
		// TODO Auto-generated constructor stub
		this.sessionMap = (SessionMap<String, Object>) ActionContext.getContext().getSession();
	}

	public void setCurrentTaskId(String currentTaskid) {
		sessionMap.put("currentTaskId", currentTaskid);
	}

	public String getCurrentTaskId() {
		HttpSession currentSession = ServletActionContext.getRequest().getSession(false);
		return currentSession.getAttribute("currentTaskId").toString();

	}

}
