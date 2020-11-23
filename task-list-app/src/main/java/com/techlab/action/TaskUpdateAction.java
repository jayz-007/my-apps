package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.Task;
import com.techlab.entity.User;
import com.techlab.service.CurrentUserService;
import com.techlab.service.TaskService;
import com.techlab.service.UserService;
import com.techlab.viewmodel.TaskUpdateVM;

public class TaskUpdateAction implements Action,ModelDriven<TaskUpdateVM>{
private String updateTask;
private Task task;
private TaskUpdateVM updatedTask;
@Autowired
private TaskService tasksvc;
@Autowired
private UserService usersvc;


public void setUpdateTask(String id) {
	this.updateTask = id;
}

public String getUpdateTask() {
	return updateTask;
}

public Task getTask() {
	return this.task;
}
	@Override
	public TaskUpdateVM getModel() {
		// TODO Auto-generated method stub
		this.updatedTask = new TaskUpdateVM();
		return updatedTask;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		this.task= tasksvc.getTaskById(updateTask);
		return "success";
	}
	
	public String doUpdate() {
		User user = usersvc.getUserById(new CurrentUserService().getCurrentUSerId());
	tasksvc.updateTask(updatedTask,updateTask);
	return "success";
	}

}
