package com.techlab.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entity.SubTask;
import com.techlab.entity.Task;
import com.techlab.repository.SubTaskRepository;
import com.techlab.viewmodel.UpdateSubtaskVM;
@Service
public class SubTaskService {
	@Autowired
	private SubTaskRepository subtaskrepository;
	
	public List<SubTask> getSubtasks(){
		return subtaskrepository.getSubTasks();
	}
	
	public void addSubtask(String title,String date,Task task) {
		subtaskrepository.addSubTask(title, date,task);
	}
	
	public void deleteSubtask(String id) {
		subtaskrepository.deleteTask(id);
	}
	
	public void updateSubtask(UpdateSubtaskVM subtaskUpdateInfo,String id) {
		subtaskrepository.updateSubTask(subtaskUpdateInfo,id);
	}
	
	public SubTask getSubtaskById(String id) {
		return subtaskrepository.searchTask(id);
	}
	
	

}
