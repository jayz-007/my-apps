package com.techlab.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.entity.User;
import com.techlab.service.UserService;

public class UserDisplayAction implements Action {
	@Autowired
	private UserService userService;
	List<User> users = new ArrayList<User>();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	public List<User> getUsers(){
		this.users = userService.getUsers();
		return users;
	}

}
