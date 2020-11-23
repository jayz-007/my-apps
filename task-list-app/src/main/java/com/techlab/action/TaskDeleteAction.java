package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.service.TaskService;

public class TaskDeleteAction implements Action {
	private String deleteTask;
	@Autowired
	private TaskService tasksvc;
	
	public void setDeleteTask(String id) {
		this.deleteTask=id;
	}
	
	public String getDeleteTask() {
		return deleteTask;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		tasksvc.deleteTask(deleteTask);
		return "success";
	}
	

}
