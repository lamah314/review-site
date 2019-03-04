package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@Controller
public class MainController {

	@Resource
	private PortfoliosRepository portfolioRepo;
	@Resource
	private ReviewsRepository reviewRepo;
	@Resource
	private ReviewTagsRepository reviewTagRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("Portfolios", portfolioRepo.findAll());
		return "home";
	}

}
