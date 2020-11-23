package com.techlab.viewmodel;

import java.util.HashSet;
import java.util.Set;


import com.techlab.entity.Task;

public class AddUserVM {
	
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	private Set<Task> task= new HashSet<Task>();
	
	
	public Set<Task> getTask() {
		return task;
	}
	public void setTask(Set<Task> task) {
		this.task = task;
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String usermame) {
		this.username = usermame;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
