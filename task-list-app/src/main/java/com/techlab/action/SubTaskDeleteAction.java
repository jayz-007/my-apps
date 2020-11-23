package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.service.SubTaskService;
import com.techlab.service.TaskService;

public class SubTaskDeleteAction implements Action {
	private String deleteSubTask;
	@Autowired
	private SubTaskService subtasksvc;

	public void setDeleteSubTask(String id) {
		this.deleteSubTask = id;
	}

	public String getDeleteSubTask() {
		return deleteSubTask;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		subtasksvc.deleteSubtask(deleteSubTask);
		return "success";
	}

}
