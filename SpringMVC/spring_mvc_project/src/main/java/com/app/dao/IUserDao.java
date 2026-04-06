package com.app.dao;

import java.util.List;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;

public interface IUserDao {

	User validateUser(String email, String password);

	List<User> getAllUserWithSpecificRole(RoleEnum role);

}
