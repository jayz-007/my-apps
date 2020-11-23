package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.opensymphony.xwork2.Action;
import com.techlab.entity.User;
import com.techlab.service.UserService;
import com.techlab.viewmodel.UpdateUserVM;

public class BlockUserAction implements Action {
	private String blockUserId;
	@Autowired
	private UserService usersvc;
	
	public void setBlockUserId(String id) {
		this.blockUserId=id;
		System.out.println("blocked id " +blockUserId);
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String doBlockUnblockUser() {
		User user = usersvc.getUserById(blockUserId);
		UpdateUserVM uservm = new UpdateUserVM();
		uservm.setFirstname(user.getFirstname());
		uservm.setLastname(user.getLastname());
		uservm.setPassword(user.getPassword());
		uservm.setEmail(user.getEmail());
		uservm.setTask(user.getTask());
		
		if(user.getBlocked()) {
			System.out.println("blocking user");
			uservm.setBlocked(false);
		}
		else {
			uservm.setBlocked(true);
		}
		
		usersvc.updateUser(uservm, blockUserId);
		return "success";

	}
	

}
