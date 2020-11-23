package com.techlab.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.User;
import com.techlab.service.CurrentUserService;
import com.techlab.service.TaskService;
import com.techlab.service.UserService;
import com.techlab.viewmodel.AddTaskVM;

public class TaskAddAction implements Action, ModelDriven<AddTaskVM> {
	private AddTaskVM addtask;
	private String validationMessage;
	@Autowired
	private TaskService tasksvc;
	@Autowired
	private UserService usr;

	

	@Override
	public AddTaskVM getModel() {
		// TODO Auto-generated method stub
		this.addtask = new AddTaskVM();
		return addtask;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

	public String doAdd() {
		if (doValidation()) {
			User user = usr.getUserById(new CurrentUserService().getCurrentUSerId());

			

			tasksvc.addTask(addtask.getTitle(), null, user);
			return "success";
		}
		return "input";

	}

	public boolean doValidation() {
		if (addtask.getTitle().equals("")) {
			this.validationMessage = "Enter Task title";
			return false;
		}
		return true;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

}
