package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ITopicService topicService;

	@Autowired
	private ITutorialService tutorialService;

	@GetMapping("/topics")
	public String getAllTopics(Model map) {
		System.out.println("in get all topics");
		map.addAttribute("topics", topicService.getAllTopics());
		return "/customer/topics";
	}

	@GetMapping("/tutorials")
	public String getTutorialsByTopic(Model map, @RequestParam long topicId) {

		map.addAttribute("tut_names", tutorialService.getTutorialNamesByTopic(topicId));

		return "customer/tutorials";
	}

	@GetMapping("/tutorial_detail")
	public String getTutorialDetails(@RequestParam("tutName") String tutorialName, Model map) {

		map.addAttribute("tutorial_details", tutorialService.getTutorialDetails(tutorialName));

		return "/customer/tutorial_details";
	}

}
