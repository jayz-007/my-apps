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

import com.techlab.entity.Task;
import com.techlab.entity.User;
import com.techlab.service.CurrentUserService;
import com.techlab.viewmodel.TaskUpdateVM;

@Repository
@Transactional
public class TaskRepository {
	@Autowired
	private SessionFactory factory;
	
	
	private List<Task> tasks = new ArrayList<Task>();
	
	public List<Task> getTasks() {
		Session session = factory.openSession();
		try {
			tasks = session.createQuery("from Task").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return tasks;
	}
	
	public void deleteTask(String id) {
		Task currentTask = searchTask(id);

		factory.getCurrentSession().delete(currentTask);
	}
	
	public Task searchTask(String id) {
		getTasks();
		for (Task taskInfo : tasks) {
			if (taskInfo.getId().toString().equals(id)) {

				return taskInfo;

			}
		}
		return null;
	}
	
	public void addTask(String title,String date,User user) {
		Task addTask = new Task();
		addTask.setDate(date);
		addTask.setDone(false);
		addTask.setId(UUID.randomUUID().toString());
		addTask.setTitle(title);
		System.out.println(user+" is user");
		addTask.setUser(user);
		factory.getCurrentSession().save(addTask);

	}
	
	public void updateTask(TaskUpdateVM taskUpdateInfo,String id) {
		System.out.println(id +"is id");
		
		Task currentTask = searchTask(id);
		currentTask.setDate(taskUpdateInfo.getDate());
		currentTask.setDone(taskUpdateInfo.getDone());
		currentTask.setSubTask(taskUpdateInfo.getSubTask());
		currentTask.setTitle(taskUpdateInfo.getTitle());

		factory.getCurrentSession().update(currentTask);
		
		
		
	}



}