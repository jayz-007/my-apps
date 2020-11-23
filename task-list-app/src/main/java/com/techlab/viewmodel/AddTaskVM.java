package com.techlab.viewmodel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.techlab.entity.SubTask;
import com.techlab.entity.User;

public class AddTaskVM {
	private String title;
	private Date date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
