package com.techlab.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.techlab.entity.SubTask;
import com.techlab.entity.Task;
import com.techlab.service.SubTaskService;
import com.techlab.service.TaskService;
import com.techlab.viewmodel.TaskUpdateVM;
import com.techlab.viewmodel.UpdateSubtaskVM;

public class SubTaskUpdateAction implements Action,ModelDriven<UpdateSubtaskVM> {
	private String updateSubTask;
	private SubTask subtask;
	private UpdateSubtaskVM updatedSubTask;
	@Autowired
	private SubTaskService subtasksvc;


	public void setUpdateSubTask(String id) {
		this.updateSubTask = id;
	}

	public String getUpdateSubTask() {
		return updateSubTask;
	}

	public SubTask getSubtask() {
		return this.subtask;
	}
		@Override
		public UpdateSubtaskVM getModel() {
			// TODO Auto-generated method stub
			this.updatedSubTask = new UpdateSubtaskVM();
			return updatedSubTask;
		}

		@Override
		public String execute() throws Exception {
			// TODO Auto-generated method stub
			System.out.println("id is "+updateSubTask);
			this.subtask = subtasksvc.getSubtaskById(updateSubTask);
			System.out.println(subtask+"is subtask");
			return "success";
		}
		
		public String doUpdate() {
		subtasksvc.updateSubtask(updatedSubTask, updateSubTask);
		return "success";
		}
}
