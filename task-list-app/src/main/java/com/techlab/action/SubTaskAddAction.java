package com.techlab.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.Task;
import com.techlab.service.CurrentTaskService;
import com.techlab.service.SubTaskService;
import com.techlab.service.TaskService;
import com.techlab.viewmodel.AddSubTaskVM;

public class SubTaskAddAction implements Action, ModelDriven<AddSubTaskVM> {

	private AddSubTaskVM addsubtask;
	private String validationMessage;
	@Autowired
	private SubTaskService subtasksvc;
	@Autowired
	private TaskService tasksvc;

	@Override
	public AddSubTaskVM getModel() {
		// TODO Auto-generated method stub
		this.addsubtask = new AddSubTaskVM();
		return addsubtask;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String doAdd() {
		if (doValidation()) {
			Task task = tasksvc.getTaskById(new CurrentTaskService().getCurrentTaskId());

			subtasksvc.addSubtask(addsubtask.getTitle(), null, task);
			return "success";
		}
		return "input";

	}

	public boolean doValidation() {
		if (addsubtask.getTitle().equals("")) {
			this.validationMessage = "Enter Task title";
			return false;
		}
		return true;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

}
