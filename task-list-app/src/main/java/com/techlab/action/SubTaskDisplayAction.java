package com.techlab.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.entity.SubTask;
import com.techlab.entity.Task;
import com.techlab.service.CurrentTaskService;
import com.techlab.service.SubTaskService;
import com.techlab.service.TaskService;
import com.techlab.viewmodel.UpdateSubtaskVM;

public class SubTaskDisplayAction implements Action {
	private String currentTaskId;
	@Autowired
	private TaskService tasksvc;
	private Set<SubTask> subtasks = new HashSet<SubTask>();
	@Autowired
	private SubTaskService subtasksvc;
	private String id;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		return "success";
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<SubTask> getSubtasks() {
		if (currentTaskId != null) {
			new CurrentTaskService().setCurrentTaskId(currentTaskId);
		}
		Task task = tasksvc.getTaskById(new CurrentTaskService().getCurrentTaskId());
		this.subtasks = task.getSubTask();
		return subtasks;
	}

	public String doCheck() {
		SubTask subtask = subtasksvc.getSubtaskById(id);
		UpdateSubtaskVM updateSubTask = new UpdateSubtaskVM();
		updateSubTask.setTitle(subtask.getTitle());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		if (subtask.getDate() == null) {
			updateSubTask.setDate(now.toString());
			updateSubTask.setDone(true);
		} else {
			updateSubTask.setDate(null);
			updateSubTask.setDone(false);
		}

		updateSubTask.setDone(true);
		subtasksvc.updateSubtask(updateSubTask, id);
		
		return "success";

	}

	public void setCurrentTaskId(String id) {
		this.currentTaskId = id;
	}

	public String getCurrentTaskId() {
		return currentTaskId;
	}

}
