package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Topic;
import com.app.pojos.Tutorial;
import com.app.pojos.User;
import com.app.service.ITopicService;
import com.app.service.ITutorialService;

@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private ITopicService topicService;

	@Autowired
	private ITutorialService tutorialService;

	@GetMapping("/dashboard")
	public String showAuthorDashboard(Model model, HttpSession session) {

		// Get user from session
		User user = (User) session.getAttribute("userDetails");

		if (user == null) {

			return "redirect:/users/login";
		}

		model.addAttribute("user", user);

		List<Tutorial> tutorials = tutorialService.findByAuthor(user.getId());
		model.addAttribute("tutorials", tutorials);

		return "author/dashboard";
	}

	@GetMapping("/tutorials/add")
	public String showAddTutorialForm(Model model, HttpSession session) {

		User user = (User) session.getAttribute("userDetails");
		if (user == null) {
			return "redirect:/users/login";
		}

		// Add empty tutorial object
		model.addAttribute("tutorial", new Tutorial());

		// Load topics for dropdown
		model.addAttribute("topics", topicService.getAllTopics());

		return "author/add_tutorial";
	}

	@PostMapping("/tutorials/add")
	public String addTutorial(@ModelAttribute Tutorial tutorial, HttpSession session, RedirectAttributes flash) {

		User user = (User) session.getAttribute("userDetails");
		if (user == null) {
			return "redirect:/users/login";
		}

		// Set author
		tutorial.setAuthor(user);

		// Optional: set default visits
		tutorial.setVisits(0);

		// Save tutorial
		tutorialService.saveTutorial(tutorial);

		flash.addFlashAttribute("msg", "Tutorial added successfully!");

		return "redirect:/author/dashboard";
	}

	@GetMapping("/tutorials/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model, HttpSession session, RedirectAttributes flash) {

		// Check login
		User user = (User) session.getAttribute("userDetails");
		if (user == null) {
			return "redirect:/users/login";
		}

		Tutorial tutorial = tutorialService.findById(id);

		// Optional: Security check (author should only edit own tutorial)
		if (!tutorial.getAuthor().getId().equals(user.getId())) {
			flash.addFlashAttribute("error", "⚠️ You are not allowed to edit this tutorial!");
			return "redirect:/author/dashboard";
		}

		model.addAttribute("tutorial", tutorial);
		model.addAttribute("topics", topicService.getAllTopics());

		return "author/edit_tutorial";
	}

	@PostMapping("/tutorials/edit/{id}")
	public String updateTutorial(@ModelAttribute Tutorial tutorial, HttpSession session, RedirectAttributes flash) {

		User user = (User) session.getAttribute("userDetails");
		if (user == null) {
			return "redirect:/users/login";
		}

		Tutorial existing = tutorialService.findById(tutorial.getId());

		// Security check
		if (!existing.getAuthor().getId().equals(user.getId())) {
			flash.addFlashAttribute("error", "⚠️ You are not allowed to edit this tutorial!");
			return "redirect:/author/dashboard";
		}

		existing.setTutorialName(tutorial.getTutorialName());
		existing.setPublishDate(tutorial.getPublishDate());
		existing.setContent(tutorial.getContent());

		// Set topic
		Topic topic = topicService.findById(tutorial.getSelectedTopic().getId());
		existing.setSelectedTopic(topic);

		// Save
		tutorialService.saveTutorial(existing);

		flash.addFlashAttribute("msg", "Tutorial updated successfully!");

		return "redirect:/author/dashboard";
	}

	@GetMapping("/tutorials/delete/{id}")
	public String deleteTutorial(@PathVariable Long id, HttpSession session, RedirectAttributes flash) {

		// Check login
		User user = (User) session.getAttribute("userDetails");
		if (user == null)
			return "redirect:/users/login";

		Tutorial tutorial = tutorialService.findById(id);

		if (!tutorial.getAuthor().getId().equals(user.getId())) {
			flash.addFlashAttribute("error", "⚠️ You are not allowed to delete this tutorial!");
			return "redirect:/author/dashboard";
		}

		tutorialService.deleteById(id);

		flash.addFlashAttribute("msg", "Tutorial id " + id + " deleted successfully!");

		return "redirect:/author/dashboard";
	}

}
