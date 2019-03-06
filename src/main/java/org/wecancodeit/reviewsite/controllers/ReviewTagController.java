package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@Controller
@RequestMapping("/reviewTags")
public class ReviewTagController {

	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagRepo;

	@GetMapping("/")
	public String getReviews(Model model) {
		model.addAttribute("ReviewTags", reviewTagRepo.findAll());
		return "reviewTags/reviewTagsHomePage";
	}

	@GetMapping("/{reviewTagId}/")
	public String getReview(Model model, @PathVariable Long reviewTagId) {
		model.addAttribute("ReviewTag", reviewTagRepo.findById(reviewTagId).get());
		model.addAttribute("ParticularReviews", reviewTagRepo.findById(reviewTagId).get().getReviews());
		model.addAttribute("AllReviews", reviewRepo.findAll());
		return "reviewTags/individualReviewTag";
	}

	@PostMapping("/{reviewTagId}/")
	public String addReviewToReviewTag(Model model, Long reviewId, @PathVariable Long reviewTagId) {

		ReviewTag reviewTag = reviewTagRepo.findById(reviewTagId).get();
		Review reviewToAdd = reviewRepo.findById(reviewId).get();
		return "redirect:/reviewTags/{reviewTagId}";
	}

//	@GetMapping("/{reviewId}")
//	public void getReview(@PathVariable Long reviewId, Model model) {
//		model.addAttribute("Review", reviewRepo.findById(reviewId).get());
//	}

}
