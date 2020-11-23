package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.service.UserService;

public class DeleteUserAction implements Action {
	private String deleteUser;
	@Autowired
	private UserService usersvc;
	
	public void setDeleteUser(String id) {
		this.deleteUser=id;
	}
	
	public String getDeleteUser() {
		return deleteUser;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		usersvc.deleteUser(deleteUser);
		return "success";
	}
	
	

}
