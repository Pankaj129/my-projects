package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:email and u.password=:password";
		System.out.println("dao : " + email + " " + password);
		User user = null;
		try {
			user = sessionFactory.getCurrentSession().createQuery(jpql, User.class).setParameter("email", email.trim())
					.setParameter("password", password.trim()).uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUserWithSpecificRole(RoleEnum role) {
		String jpql = "select u from User u where u.role=:rl";
		return sessionFactory.getCurrentSession().createQuery(jpql, User.class).setParameter("rl", role)
				.getResultList();
	}

}
