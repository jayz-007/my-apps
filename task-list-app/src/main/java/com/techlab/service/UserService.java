package com.techlab.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlab.entity.User;
import com.techlab.repository.UserRepository;
import com.techlab.viewmodel.UpdateUserVM;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	public void addUser(String firstName,String lastName,String email,String usermame,String password) {
		try {userRepository.addUser(firstName, lastName, email, usermame, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public User getUserById(String id) {
		return userRepository.searchUser(id);
	}
	
	public User getUserByEmail(String email) {
		return userRepository.searchUser(email);
	}
	
	public void updateUser(UpdateUserVM userUpdateInfo,String updateUser) {
		userRepository.updateUser(userUpdateInfo, updateUser);
	}
	
	public void deleteUser(String id) {
		userRepository.deleteUser(id);
	}
	
	public User getUserByUserName(String username) {
		 return userRepository.searchUserByUserName(username);
	}

}
