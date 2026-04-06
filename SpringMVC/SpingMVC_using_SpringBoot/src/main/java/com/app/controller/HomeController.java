package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("HomeController initialized: " + getClass().getSimpleName());
	}

	@GetMapping("/")
	public String showHomePage(Model model) {

		System.out.println("Inside Home Page Controller");

		// Adding server timestamp
		model.addAttribute("ts", new Date());

		return "index"; 
	}
}