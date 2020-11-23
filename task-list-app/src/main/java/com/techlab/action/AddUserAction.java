package com.techlab.action;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.User;
import com.techlab.service.UserService;
import com.techlab.viewmodel.AddUserVM;

public class AddUserAction implements Action, ModelDriven<AddUserVM> {
	private AddUserVM addUser;
	private String validationMessage;
	@Autowired
	private UserService userService;
	private String confirmPasword;
	@Override
	public AddUserVM getModel() {
		// TODO Auto-generated method stub
		this.addUser = new AddUserVM();
		return addUser;
	}

	@Override 
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

	public String doAdd() {
		if (doValidation()) {
			userService.addUser(addUser.getFirstname(), addUser.getLastname(), addUser.getEmail(),
					addUser.getUsername(), addUser.getPassword());
			return "success";
		}
		return "input";
	}

	public boolean doValidation() {
		if (addUser.getFirstname().equals("")) {
			this.validationMessage = "Please Enter First Name";
			return false;
		}
		if (addUser.getLastname().equals("")) {
			this.validationMessage = "Please Enter Last name";
			return false;
		}
		if (addUser.getEmail().equals("")) {
			this.validationMessage = "Please Enter Email";
			return false;
		}
		
		if (!(addUser.getEmail().contains("@")&& addUser.getEmail().contains(".com"))) {
			this.validationMessage = "Please Enter valid Email";
			return false;
		}
		
		if (addUser.getUsername().equals("")) {
			this.validationMessage = " Please Enter Username ";
			return false;
		}
		if (addUser.getPassword().equals("")) {
			this.validationMessage = "Please Enter password";
			return false;
		}
		if(!addUser.getPassword().equals(confirmPasword)) {
			this.validationMessage ="Password doesn't match";
			return false;
		}
		
		User existingUser = userService.getUserByEmail(addUser.getEmail());
		if(!(existingUser==null)) {
			this.validationMessage = " Email Id already exists ";
			return false;
		}
		
		 existingUser = userService.getUserByUserName(addUser.getUsername());
		if(!(existingUser==null)) {
			this.validationMessage = " Username  already exists ";
			return false;
		}
		return true;
	}
	
	public String getValidationMessage() {
		return validationMessage;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPasword = confirmPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPasword;
	}

}
