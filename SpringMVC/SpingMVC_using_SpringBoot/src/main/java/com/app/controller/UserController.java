package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public String showLoginForm() {

		return "users/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, HttpSession session,
			RedirectAttributes flashMap) {

		String redirectUrl = userService.authenticateAndGetRedirect(email, password, session);

		flashMap.addFlashAttribute("msg", "Login successful!");

		return redirectUrl;
	}

	@PostMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes flashMap) {

		// Destroy session
		session.invalidate();
		flashMap.addFlashAttribute("msg", "You have been logged out successfully 👋");
		return "redirect:/users/login";
	}

}
