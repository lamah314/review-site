package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.User;
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

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.findAll());
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

	@GetMapping("/portfolios/{id}")
	public String getPortfolio(Model model, @PathVariable Long id) {
		model.addAttribute("Portfolio", portfolioRepo.findById(id).get());
		return "portfolios/individualPortfolio";
	}

	@GetMapping("/portfolios/submissions")
	public String getPortfolioForm(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.findAll());
		return "/portfolios/submissions";
	}

	@PostMapping("/portfolios/submissions")
	public String addPortfolio(String portfolioName, String url) {

		for (Portfolio specificPortfolio : portfolioRepo.findAll()) {
			if (specificPortfolio.getPortfolioName().equals(portfolioName)) {
				return "redirect:/portfolios/submissions";
			}
		}

		portfolioRepo.save(new Portfolio(portfolioName, Portfolio.URLChecker(url)));
		return "redirect:/portfolios/submissions";
	}

	@GetMapping("/users/form")
	public String getUserForm(Model model) {
		model.addAttribute("Users", userRepo.findAll());
		return "users/form";
	}

	@PostMapping("/users/form")
	public String addUser(String username, String password) {

		for (User specificPerson : userRepo.findAll()) {
			if (specificPerson.getName().equals(username)) {
				return "redirect:/users/form";
			}
		}

		userRepo.save(new User(username, password));
		return "redirect:/users/results";

	}

	@GetMapping("/portfolios/{id}/writeReview")
	public String getReview(Model model, @PathVariable Long id) {
		model.addAttribute("Portfolio", portfolioRepo.findById(id).get());
		return "portfolios/writeReview";
	}

	@PostMapping("/portfolios/{id}/writeReview")
	public String addPortfolioReview(Model model, @PathVariable Long id, long easeOfUseRating, long aestheticsRating,
			long contentRating, long creativityRating, long overallRating, String name, String overallComment,
			String easeOfUseComment, String aestheticsComment, String contentComment, String creativityComment) {
		reviewRepo.save(new Review(portfolioRepo.findById(id).get().getPortfolioName(), easeOfUseRating,
				aestheticsRating, contentRating, creativityRating, overallRating, overallComment, easeOfUseComment,
				aestheticsComment, contentComment, creativityComment, name));
		model.addAttribute("Portfolio", portfolioRepo.findById(id));
		return "/portfolios/individualPortfolio";
	}

}
