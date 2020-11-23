package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.User;
import com.techlab.service.UserService;
import com.techlab.viewmodel.UpdateUserVM;

public class UserUpdateAction implements Action,ModelDriven<UpdateUserVM> {
	private String updateUser;
	private User user;
	private UpdateUserVM updateusr;
	@Autowired
	private UserService usersvc;

	public void setUpdateUser(String id) {
		this.updateUser = id;
	}

	public String getUpdateUser() {
		return updateUser;
	}
	
	public User getUser() {
		return this.user;
	}

	@Override
	public UpdateUserVM getModel() {
		// TODO Auto-generated method stub
		this.updateusr = new UpdateUserVM();
		return updateusr;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.user = usersvc.getUserById(updateUser);
		System.out.println(user.getFirstname());
		return "success";
	}
	
	public String doUpdate() {
		usersvc.updateUser(updateusr,updateUser);
		return "success";
	}
}
