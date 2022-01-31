package org.iesalixar.drodriguezm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.drodriguezm.model.User;
import org.iesalixar.drodriguezm.dao.UserDao;

public class UserService {
	private UserDao userDao;

	public UserService(final Session session) {
		this.userDao = new UserDao(session);
	}

	public void insertNewUser(User user) {
		if (user != null && user.getId() == null) userDao.insert(user);
	}

	public void updateUser(User user) {
		if (user != null && user.getId() != null) userDao.update(user);
	}

	public void deleteUser(User user) {
		if (user != null && user.getId() != null) userDao.delete(user);
	}

	public User searchById(Long userId) {
		User user = null;
		if (userId != null) user = userDao.searchById(userId);		
		return user;
	}

	public List<User> searchAll() {		
		List<User> userList = new ArrayList<User>();
		userList = userDao.searchAll();
		return userList;
	}
	
	public List<User> searchByUserNameOrEmail(String userName, String email) {		
		List<User> users = null;
		
		if (userName != null && email != null) users = userDao.searchByUserNameOrEmail(userName, email);
		
		return users;
	}
}
