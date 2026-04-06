package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String showHomePage(Model map) {
		System.out.println("Home Controller : ");
		map.addAttribute("latset_date", new Date());
		return "index";
	}

}
