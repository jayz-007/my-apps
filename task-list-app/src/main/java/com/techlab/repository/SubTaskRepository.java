package com.techlab.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlab.entity.SubTask;
import com.techlab.entity.Task;
import com.techlab.viewmodel.UpdateSubtaskVM;
import com.techlab.viewmodel.UpdateUserVM;

@Repository
@Transactional
public class SubTaskRepository {
	@Autowired
	private SessionFactory factory;
	
	
	private List<SubTask> subtasks = new ArrayList<SubTask>();
	
	public List<SubTask> getSubTasks() {
		Session session = factory.openSession();
		try {
			subtasks = session.createQuery("from SubTask").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return subtasks;
	}
	
	public void deleteTask(String id) {
		SubTask currentTask = searchTask(id);

		factory.getCurrentSession().delete(currentTask);
	}
	
	public SubTask searchTask(String id) {
		getSubTasks();
		for (SubTask taskInfo : subtasks) {
			if (taskInfo.getId().toString().equals(id)) {

				return taskInfo;

			}
		}
		return null;
	}
	
	public void addSubTask(String title,String date,Task task) {
		SubTask addSubTask = new SubTask();
		addSubTask.setDate(date);
		addSubTask.setDone(false);
		addSubTask.setId(UUID.randomUUID().toString());
		addSubTask.setTitle(title);
		addSubTask.setTask(task);
		
		factory.getCurrentSession().save(addSubTask);

	}
	
	public void updateSubTask(UpdateSubtaskVM subtaskUpdateInfo,String id) {
		SubTask currentTask = searchTask(id);
		currentTask.setDate(subtaskUpdateInfo.getDate());
		currentTask.setDone(subtaskUpdateInfo.isDone());
		currentTask.setTitle(subtaskUpdateInfo.getTitle());

		factory.getCurrentSession().update(currentTask);
		
	}




}