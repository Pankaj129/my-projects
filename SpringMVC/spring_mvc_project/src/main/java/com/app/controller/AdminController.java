package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.RoleEnum;
import com.app.pojos.Tutorial;
import com.app.service.ITopicService;
import com.app.service.ITutorialService;
import com.app.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ITopicService topicService;

	@Autowired
	private ITutorialService tutorialService;

	@GetMapping("/status")
	public String getStatus() {
		return "admin/status";
	}

	@GetMapping("/add_new_tut")
	public String addNewTutorial(Model map, Tutorial tutorial) {
		System.out.println("admin = topic list");
		map.addAttribute("topic_list", topicService.getAllTopics());
		System.out.println("admin = author list");
		map.addAttribute("author_list", userService.getAllAuthors(RoleEnum.AUTHOR));
		System.out.println("move to tutorial");
		return "admin/add_tutorial";

	}

	@PostMapping("/add_new_tut")
	public String addNewTutorialProcessForm(Tutorial transientTut, Model map, RedirectAttributes flashMap) {
		System.out.println("in add tut process form tut : " + transientTut);
		System.out.println("tut's topic " + transientTut.getSelectedTopic());
		System.out.println("tut's author " + transientTut.getAuthor());
		try {
			flashMap.addFlashAttribute("mesg", tutorialService.validateNAddTutotrial(transientTut));
		} catch (RuntimeException e) {

			map.addAttribute("err_mesg", e.getMessage());
			return "/admin/add_tutorial";
		}

		return "redirect:/admin/status";

	}

}
