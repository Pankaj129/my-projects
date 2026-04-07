package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.UserCreateDTO;
import com.app.dto.UserUpdateDTO;
import com.app.pojos.RoleEnum;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;

	@GetMapping("/users")
	public String adminDashboard(Model model) {
		List<User> users = userService.getAllUsers();

		model.addAttribute("users", users);
		model.addAttribute("totalUsers", users.size());
		model.addAttribute("adminCount", userService.countByRole(RoleEnum.ADMIN));
		model.addAttribute("authorCount", userService.countByRole(RoleEnum.AUTHOR));
		model.addAttribute("customerCount", userService.countByRole(RoleEnum.CUSTOMER));
		return "admin/dashboard";
	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/admin/users";
	}

	@GetMapping("/users/view/{id}")
	public String viewUser(@PathVariable Long id, Model model) {

		User user = userService.getUserById(id);

		model.addAttribute("user", user);

		return "admin/view-user";
	}

	@GetMapping("/users/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {

		User user = userService.getUserById(id);

		UserUpdateDTO dto = new UserUpdateDTO();
		dto.setId(user.getId());
		dto.setFirstname(user.getFirstname());
		dto.setLastname(user.getLastname());
		dto.setEmail(user.getEmail());
		dto.setRole(user.getRole());

		model.addAttribute("user", dto);

		return "admin/edit-user";
	}

	@PostMapping("/users/edit")
	public String updateUser(@Valid @ModelAttribute UserUpdateDTO user, BindingResult result,
			RedirectAttributes flashMap) {

		if (result.hasErrors()) {
			return "admin/edit-user";
		}

		userService.updateUser(user);

		flashMap.addFlashAttribute("msg", "User updated successfully!");

		return "redirect:/admin/users";
	}

	// Show form
	@GetMapping("/users/add")
	public String showAddUserForm(Model model) {
		model.addAttribute("user", new UserCreateDTO());
		System.out.println("get user done");
		return "admin/add-user";
	}

	// Process form
	@PostMapping("/users/add")
	public String addUser(@Valid @ModelAttribute("user") UserCreateDTO dto, BindingResult result,
			RedirectAttributes flashMap) {
		System.out.println("user added");
		if (result.hasErrors()) {
			return "admin/add-user";
		}
		System.out.println("successfully.!!");
		userService.addUser(dto);

		flashMap.addFlashAttribute("msg", "User added successfully!");

		return "redirect:/admin/users";
	}

}
