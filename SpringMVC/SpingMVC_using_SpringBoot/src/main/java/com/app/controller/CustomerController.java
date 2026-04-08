package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Topic;
import com.app.pojos.Tutorial;
import com.app.pojos.User;
import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ITopicService topicService;

	@Autowired
	private ITutorialService tutorialService;

	@GetMapping("/dashboard")
	public String showCustomerDashboard(@RequestParam(required = false) Long topicId, Model model,
			HttpSession session) {

		User user = (User) session.getAttribute("userDetails");
		if (user == null) {
			return "redirect:/users/login";
		}

		List<Topic> topics = topicService.getAllTopics();
		model.addAttribute("topics", topics);

		List<Tutorial> tutorials;

		if (topicId != null) {
			tutorials = tutorialService.findByTopicSorted(topicId);
			model.addAttribute("selectedTopicId", topicId);
		} else {
			tutorials = tutorialService.getAllSorted();
		}

		// 🔥 Trending tutorials (TOP 5)
		List<Tutorial> trendingTutorials = tutorialService.getAllSorted();
		if (trendingTutorials.size() > 5) {
			trendingTutorials = trendingTutorials.subList(0, 5);
		}

		model.addAttribute("tutorials", tutorials);
		model.addAttribute("trendingTutorials", trendingTutorials);
		model.addAttribute("user", user);

		return "customer/dashboard";
	}

	@GetMapping("/tutorial/{id}")
	public String viewTutorial(@PathVariable Long id, Model model) {

		Tutorial tutorial = tutorialService.getById(id);

		if (tutorial == null) {
			return "redirect:/customer/dashboard";
		}

		// 🔥 Increase visit count
		tutorial.setVisits(tutorial.getVisits() + 1);
		tutorialService.save(tutorial);

		model.addAttribute("tutorial", tutorial);

		return "customer/view_tutorial";
	}

}
