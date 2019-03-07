package org.wecancodeit.reviewsite.controllers;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@Controller
@RequestMapping("/portfolios")
public class PortfolioController {

	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagRepo;

	@GetMapping("/{portfolioId}")
	public String getPortfolio(@PathVariable Long portfolioId, Model model) {
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
	public String addPortfolioReview(Model model, @PathVariable Long portfolioId, Long easeOfUse, Long aesthetics,
			Long content, Long creativity, Long overall, String tagName, String overallComment) {

		ReviewTag reviewTag;
		if (reviewTagRepo.findByTagName(tagName) == null) {
			reviewTag = reviewTagRepo.save(new ReviewTag(tagName));
		} else {
			reviewTag = reviewTagRepo.findByTagName(tagName);
		}
		 

		Review review = reviewRepo.save(new Review(portfolioRepo.findById(portfolioId).get(), easeOfUse, aesthetics,
				content, creativity, overall, overallComment, reviewTag));

		portfolioRepo.findById(portfolioId).get().addReview(review);
		model.addAttribute("Portfolio", portfolioRepo.findById(portfolioId));
		return "redirect:/portfolios/{portfolioId}";
	}
}
