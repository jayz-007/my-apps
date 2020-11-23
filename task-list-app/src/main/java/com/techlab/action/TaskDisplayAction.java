package com.techlab.action;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlab.entity.Task;
import com.techlab.entity.User;
import com.techlab.service.CurrentUserService;
import com.techlab.service.TaskService;
import com.techlab.service.UserService;
import com.techlab.viewmodel.TaskUpdateVM;

public class TaskDisplayAction implements Action {
	private String id;
	private String userId;
	@Autowired
	private UserService usr;
	private Set<Task> tasks = new HashSet<Task>();
	@Autowired
	private TaskService tasksvc;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		return "success";
	}

	public Set<Task> getTasks() {
		if (userId != null) {
			new CurrentUserService().setCurrentUserId(userId);
		}
		User User = usr.getUserById(new CurrentUserService().getCurrentUSerId());
		this.tasks = User.getTask();
		return tasks;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String doCheck() {
		Task task = tasksvc.getTaskById(id);
		TaskUpdateVM updateTask = new TaskUpdateVM();
		updateTask.setTitle(task.getTitle());
		updateTask.setSubTask(task.getSubTask());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		if (task.getDate()==null) {
			updateTask.setDate(now.toString());
			updateTask.setDone(true);
		} else {
			updateTask.setDate(null);
			updateTask.setDone(false);
		}

		updateTask.setDone(true);
	
		tasksvc.updateTask(updateTask, id);

		return "success";
	}

	public void setUserId(String id) {
		System.out.println(id);
		this.userId = id;
	}

	public String getUserId() {
		return userId;
	}

}
