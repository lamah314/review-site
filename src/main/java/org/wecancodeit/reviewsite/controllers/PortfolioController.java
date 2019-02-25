package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.repositories.AddressesRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
@RequestMapping("/portfolios")
public class PortfolioController {

	@Resource
	UsersRepository userRepo;
	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	AddressesRepository addressRepo;

	@GetMapping("/{portfolioId}")
	public String getPortfolio(Model model, @PathVariable Long portfolioId) {
		model.addAttribute("Portfolio", portfolioRepo.findById(portfolioId).get());
		return "portfolios/individualPortfolio";
	}

	@GetMapping("/submissions")
	public String getPortfolioForm(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.findAll());
		return "/portfolios/submissions";
	}

	@PostMapping("/submissions")
	public String addPortfolio(String portfolioName, String url) {

		for (Portfolio specificPortfolio : portfolioRepo.findAll()) {
			if (specificPortfolio.getPortfolioName().equals(portfolioName)) {
				return "redirect:/portfolios/submissions";
			}
		}
		url = Portfolio.URLChecker(url);
		portfolioRepo.save(new Portfolio(portfolioName, url));
		return "redirect:/";
	}

	@GetMapping("/{portfolioId}/writeReview")
	public String getReview(Model model, @PathVariable Long portfolioId) {
		model.addAttribute("Portfolio", portfolioRepo.findById(portfolioId).get());
		return "portfolios/writeReview";
	}

	@PostMapping("/{portfolioId}/writeReview")
	public String addPortfolioReview(Model model, @PathVariable Long portfolioId, String userName, long easeOfUseRating,
			long aestheticsRating, long contentRating, long creativityRating, long overallRating, String name,
			String overallComment, String easeOfUseComment, String aestheticsComment, String contentComment,
			String creativityComment) {
		Review review = reviewRepo
				.save(new Review(portfolioRepo.findById(portfolioId).get(), userRepo.findByUserName(userName).getId(),
						easeOfUseRating, aestheticsRating, contentRating, creativityRating, overallRating,
						overallComment, easeOfUseComment, aestheticsComment, contentComment, creativityComment));
		portfolioRepo.findById(portfolioId).get().addReview(review);
		model.addAttribute("Portfolio", portfolioRepo.findById(portfolioId));
		return "/portfolios/individualPortfolio";
	}
}
