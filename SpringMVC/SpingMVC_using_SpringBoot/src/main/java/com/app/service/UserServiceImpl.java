package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.app.dao.IUserRepository;
import com.app.dto.UserCreateDTO;
import com.app.dto.UserUpdateDTO;
import com.app.exception.InvalidCredentialsException;
import com.app.exception.UserNotFoundException;
import com.app.pojos.RoleEnum;
import com.app.pojos.User;

public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	public String authenticateAndGetRedirect(String email, String password, HttpSession session) {

		User user = userRepo.findByEmailAndPasswod(email, password)
				.orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

		// store in session
		session.setAttribute("userDetails", user);

		RoleEnum role = user.getRole();

		switch (role) {
		case ADMIN:
			return "redirect:/admin/status";

		case AUTHOR:
			return "redirect:/author/status";

		default:
			return "redirect:/customer/status";
		}
	}

	@Override
	public List<User> getAllAuthors() {

		return userRepo.findByRole(RoleEnum.AUTHOR);
	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public long countByRole(RoleEnum admin) {

		return userRepo.countByRole(admin);
	}

	@Override
	public void deleteUser(Long id) {

		try {

			if (!userRepo.existsById(id)) {
				throw new UserNotFoundException("User not found with id: " + id);
			}

			userRepo.deleteById(id);

		} catch (DataIntegrityViolationException ex) {
			throw new RuntimeException("Cannot delete user. It is linked with other records.");
		}
	}

	@Override
	public User getUserById(Long id) {

		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	}

	@Override
	public void updateUser(UserUpdateDTO user) {

		User existingUser = userRepo.findById(user.getId())
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + user.getId()));

		// Update only editable fields
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setEmail(user.getEmail());
		existingUser.setRole(user.getRole());

		// ⚠️ Password handling (IMPORTANT)
		if (user.getPassword() != null && !user.getPassword().isBlank()) {
			existingUser.setPassword(user.getPassword());
		}

		userRepo.save(existingUser);

	}

	@Override
	public void addUser(@Valid UserCreateDTO dto) {
		// Optional: check duplicate email
		if (userRepo.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("Email already exists!");
		}

		User user = new User();
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setEmail(dto.getEmail());

		// ⚠️ later replace with BCrypt
		user.setPassword(dto.getPassword());

		user.setRole(dto.getRole());

		user.setRegisterDate(LocalDate.now());

		userRepo.save(user);

	}

}
