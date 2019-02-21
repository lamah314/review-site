package org.wecancodeit.reviewsite.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewsite.models.PersonForm;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
public class MainController {
	
	private UsersRepository userRepo = new UsersRepository(new ArrayList<PersonForm>());
	private PortfoliosRepository portfolioRepo = new PortfoliosRepository(new ArrayList<Portfolio>());

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.getPortfolios());
		return "home";
	}

	@GetMapping("/individualPortfolio")
	public String individualPortfolio() {
		return "individualPortfolio";
	}

	@GetMapping("/users/results")
	public String results() {
		// Figure out Model
		return "users/results";
	}

	@GetMapping("/users/form")
	public String getUserForm(Model model) {
		model.addAttribute("Users", userRepo.getUsers());
		return "users/form";
	}
	
	@GetMapping("/users/{id}")
	public String getUser(Model model, String id) {
		model.addAttribute("User", userRepo.findPerson(id));
		return "users/individual";
	}

	@PostMapping("/users/form")
	public String addUser(String username, String password) {

		for (PersonForm specificPerson: userRepo.getUsers()) {
			if (specificPerson.getName().equals(username)) {
				return "redirect:/users/form";
			}
		} 
		
		userRepo.addUser(new PersonForm(username, password));
		return "redirect:/users/results";
		
	}
	
	
}
