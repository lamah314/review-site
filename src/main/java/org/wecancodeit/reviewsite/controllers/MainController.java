package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.junit.Before;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.User;
import org.wecancodeit.reviewsite.repositories.AddressesRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
public class MainController {

	@Resource
	private UsersRepository userRepo;
	@Resource
	private PortfoliosRepository portfolioRepo;
	@Resource
	private ReviewsRepository reviewRepo;
	@Resource
	private AddressesRepository addressRepo;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.findAll());
		return "home";
	}

}
