package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.RoleEnum;
import com.app.pojos.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public String showLoginForm() {

		return "user/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam("pass") String password, Model map,
			HttpSession session, RedirectAttributes flashMap) {
		try {
			System.out.println(email+"  "+password);
			User user = userService.authenticateUser(email, password);
			System.out.println("user : "+user);
			flashMap.addFlashAttribute("mesg", "Login Successful, Hello , " + user.getFirstname()
					+ " , logged in under " + user.getRole() + " role");
			System.out.println("Login Successful, Hello , " + user.getFirstname() + " , logged in under "
					+ user.getRole() + " role");
			session.setAttribute("user_dtls", user);
			if (user.getRole() == RoleEnum.CUSTOMER)
				return "redirect:/customer/topics";

			return "redirect:/admin/status";

		} catch (RuntimeException e) {
			map.addAttribute("mesg", "Invalid login, Please try again...!!!");
			System.out.println(">>>>LOGIN FAILED..!!");
		}
		return "user/login";
	}

	@GetMapping("/logout")
	public String logoutForm(HttpSession session, Model map, HttpServletResponse resp, HttpServletRequest req) {
		map.addAttribute("user_dtls", session.getAttribute("user_dtls"));
		session.invalidate();
		resp.setHeader("refresh", "5;url=" + req.getContextPath());
		return "user/logout";
	}

}
