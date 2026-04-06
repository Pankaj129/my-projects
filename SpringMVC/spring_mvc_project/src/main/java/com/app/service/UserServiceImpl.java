package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.RoleEnum;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String password) {
		System.out.println("service : " + email + " " + password);
		System.out.println(
				"Is Transaction Active: " + org.springframework.transaction.support.TransactionSynchronizationManager
						.isActualTransactionActive());
		return userDao.validateUser(email, password);
	}

	@Override
	public List<User> getAllAuthors(RoleEnum role) {

		return userDao.getAllUserWithSpecificRole(role);
	}

}
