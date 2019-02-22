package org.wecancodeit.reviewsite.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewsite.models.User;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
public class MainController {

	private UsersRepository userRepo = new UsersRepository(new ArrayList<User>());
	private PortfoliosRepository portfolioRepo = new PortfoliosRepository(new ArrayList<Portfolio>());
	private ReviewsRepository reviewRepo = new ReviewsRepository(new ArrayList<Review>());
	
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

	@GetMapping("/users/{userName}")
	public String getUser(Model model, @PathVariable String userName) {
		model.addAttribute("User", userRepo.findUser(userName));
		return "users/individual";
	}

	@GetMapping("/portfolios/{portfolioName}")
	public String getPortfolio(Model model, @PathVariable String portfolioName) {
		model.addAttribute("Portfolio", portfolioRepo.findPortfolio(portfolioName));
		return "portfolios/individualPortfolio";
	}

	@GetMapping("/users/form")
	public String getUserForm(Model model) {
		model.addAttribute("Users", userRepo.getUsers());
		return "users/form";
	}

	@PostMapping("/users/form")
	public String addUser(String username, String password) {

		for (User specificPerson : userRepo.getUsers()) {
			if (specificPerson.getName().equals(username)) {
				return "redirect:/users/form";
			}
		}

		userRepo.addUser(new User(username, password));
		return "redirect:/users/results";

	}

	@GetMapping ("/portfolios/{portfolioName}/writeReview")
	public String getReview(Model model, @PathVariable String portfolioName) {
		model.addAttribute("Portfolio", portfolioRepo.findPortfolio(portfolioName));
		return "/portfolios/writeReview";
		
	}

	@PostMapping("/portfolios/{portfolioName}/writeReview")
	public String addPortfolioReview( @PathVariable String portfolioName, long easeOfUseRating, long aestheticsRating, long contentRating, long creativityRating, long overallRating, String name, String overallComment, String easeOfUseComment, String aestheticsComment, String contentComment, String creativityComment) {
		reviewRepo.addReview(new Review(portfolioName, easeOfUseRating, aestheticsRating, contentRating,
				 creativityRating, overallRating, overallComment, easeOfUseComment,
				 aestheticsComment, contentComment,creativityComment, name));
		return "redirect:/portfolios/{portfolioName}";
	}
	
}
