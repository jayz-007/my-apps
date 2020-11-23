package com.techlab.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlab.entity.User;
import com.techlab.viewmodel.UpdateUserVM;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	private SessionFactory factory;
	private List<User> users = new ArrayList<User>();

	public UserRepository() {
		System.out.println("repo created");
		// TODO Auto-generated constructor stub
	}

	public List<User> getUsers() {
		System.out.println(factory);
		Session session = factory.openSession();
		try {
			System.out.println("inside get");
			users = session.createQuery("from User").list();
			System.out.println(users.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return users;
	}

	public void deleteUser(String id) {
		User currentUser = searchUser(id);

		factory.getCurrentSession().delete(currentUser);
	}

	public User searchUser(String id) {
		// getUsers();//orginal text
		getUsers();
		System.out.println(id);
		for (User userInfo : users) {
			if (userInfo.getId().toString().equals(id)) {
				return userInfo;

			}
		}
		return null;
	}

	public User searchUserByUserName(String username) {
		// getUsers();//orginal text
		getUsers();
		System.out.println(username);
		for (User userInfo : users) {
			if (userInfo.getUsername().equals(username)) {
				System.out.println("found suer");
				return userInfo;

			}
		}
		return null;
	}
	
	public User searchUserByEmailID(String email) {
		// getUsers();//orginal text
		getUsers();
		for (User userInfo : users) {
			if (userInfo.getEmail().equals(email)) {
				return userInfo;

			}
		}
		return null;
	}

	public void addUser(String firstName, String lastName, String email, String usermame, String password)
			throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SystemException {
		User addUser = new User();
		addUser.setEmail(email);
		addUser.setFirstName(firstName);
		addUser.setId(UUID.randomUUID().toString());
		addUser.setLastName(lastName);
		addUser.setPassword(password);
		addUser.setUsermame(usermame);
		System.out.println(addUser);

		factory.getCurrentSession().save(addUser);

	}

	public void updateUser(UpdateUserVM userUpdateInfo, String updateUser) {

		User currentUser = searchUser(updateUser);

		currentUser.setEmail(userUpdateInfo.getEmail());
		currentUser.setFirstName(userUpdateInfo.getFirstname());
		currentUser.setLastName(userUpdateInfo.getLastname());
		currentUser.setPassword(userUpdateInfo.getPassword());
		currentUser.setTask(userUpdateInfo.getTask());
		currentUser.setBlocked(userUpdateInfo.getBlocked());

		factory.getCurrentSession().update(currentUser);
		
		System.out.println("blocked user  success"+ currentUser.getBlocked());

	}

}