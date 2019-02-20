package org.wecancodeit.reviewsite.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.PersonForm;

@Controller
public class MainController {
	
	List<PersonForm> people = new ArrayList<PersonForm>();

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/individualPortfolio")
	public String individualPortfolio() {
		return "individualPortfolio";
	}

	@RequestMapping("/results")
	public String results(Model model) {
		// Figure out Model
		return "results";
	}


//    public void addViewControllers() {
//        registry.addViewController("/results").setViewName("results");
//    }

	@GetMapping("/form")
	public String showForm() {
		return "form";
	}

	@PostMapping("/results")
	public String checkPersonInfo(String username, String password) {
		people.add(new PersonForm(username, password));
		return "redirect:/results";



	}
}
