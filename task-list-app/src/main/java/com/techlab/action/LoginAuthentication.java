package com.techlab.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.entity.User;
import com.techlab.service.CurrentUserService;
import com.techlab.service.LoginService;
import com.techlab.service.UserService;

public class LoginAuthentication implements Action, SessionAware {
	private String username;
	private String password;
	private String message;
	private SessionMap<String, Object> sessionMap;
	@Autowired
	private LoginService loginsvc;
	@Autowired
	private UserService usersvc;
	private boolean isAdmin;

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = (SessionMap<String, Object>) session;

	}

	@Override
	public String execute() throws Exception {
		List<User> users = new ArrayList<User>();
		users = usersvc.getUsers();
		loginsvc.addtoUsersList(users);
		User user = usersvc.getUserByUserName(username);

		Boolean isUserValid = loginsvc.doAuthentication(this.username, this.password, this.sessionMap, isAdmin);

		if (LoginDp() != null) {
			return "input";
		}
		if (isUserValid.equals(true) && isAdmin) {
			return "admin";
		}
		if (isUserValid.equals(true) && !isAdmin && !user.getBlocked()) {
			
			
			System.out.println("user id is " + user.getId());
			CurrentUserService currentusr = new CurrentUserService();
			currentusr.setCurrentUserId(user.getId());
			System.out.println("inside log "+ user.getBlocked());
			return "user";
		}
		
		if (isUserValid.equals(true) && !isAdmin && user.getBlocked()) {
			return "blocked";
		}

		this.message = "enter Valid username and password";
		return "input";

	}

	public String getMessage() {
		return message;
	}

	public String LoginDp() {
		if (this.username != null & this.password != null) {
			if (this.username.equals("")) {
				this.message = "Please enter Username";
				return "input";
			}
			if (this.password.equals("")) {
				System.out.println("inside passn do");
				this.message = "Please Enter Password";
				return "input";
			}
		}
		return null;

	}

}