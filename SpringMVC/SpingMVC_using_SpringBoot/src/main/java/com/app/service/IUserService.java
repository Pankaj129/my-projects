package com.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.app.dto.UserCreateDTO;
import com.app.dto.UserUpdateDTO;
import com.app.pojos.RoleEnum;
import com.app.pojos.User;

public interface IUserService {
	String authenticateAndGetRedirect(String email, String password, HttpSession session);

	List<User> getAllAuthors();

	List<User> getAllUsers();

	long countByRole(RoleEnum admin);

	void deleteUser(Long id);

	User getUserById(Long id);

	void updateUser(UserUpdateDTO user);

	void addUser(@Valid UserCreateDTO dto);
}
