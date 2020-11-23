package com.techlab.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entity.Task;
import com.techlab.entity.User;
import com.techlab.repository.TaskRepository;
import com.techlab.viewmodel.TaskUpdateVM;
@Service
public class TaskService {
	@Autowired
	private TaskRepository taskrepository;
	
	public List<Task> getTasks(){
		return taskrepository.getTasks();
	}
	
	public void addTask(String title ,String date,User user) {
		taskrepository.addTask(title, date,user);
	}
	
	public void deleteTask(String id) {
		taskrepository.deleteTask(id);
	}
	
	public void updateTask(TaskUpdateVM taskUpdateInfo,String id) {
		taskrepository.updateTask(taskUpdateInfo,id);
	}
	
	public Task getTaskById(String id) {
		return taskrepository.searchTask(id);
	}

}
