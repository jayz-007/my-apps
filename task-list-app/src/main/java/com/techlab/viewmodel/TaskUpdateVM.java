package com.techlab.viewmodel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.techlab.entity.SubTask;

public class TaskUpdateVM {
	private String title;
	private String date;
	private boolean done;
	
	
	private Set<SubTask> subTask= new HashSet<SubTask>();
	
	public Set<SubTask> getSubTask() {
		return subTask;
	}

	public void setSubTask(Set<SubTask> subTask) {
		this.subTask = subTask;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
