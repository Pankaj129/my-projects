package com.app.service;

import java.util.List;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;

public interface IUserService {
	
	User authenticateUser(String email, String password);
	
	List<User> getAllAuthors(RoleEnum role);

}
