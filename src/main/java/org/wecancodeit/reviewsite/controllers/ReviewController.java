package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@Controller
@RequestMapping("/reviewTags")
public class ReviewController {

	
	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagRepo;
	
	////CHECK ALL OF THIS///////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
////	@GetMapping("/{reviewTagId}")
//	public String getPortfolio(Model model, @PathVariable Long reviewTagId) {
//		model.addAttribute("Portfolio", reviewTagRepo.findById(reviewTagId).get());
//		return "reviewTags/individualReviewTag";
//	}
//
//	@GetMapping("/submissions")
//	public String getPortfolioForm(Model model) {
//		model.addAttribute("Portfolios", portfolioRepo.findAll());
//		return "/reviewTags/submissions";
//	} 
//
//	@PostMapping("/submissions")
//	public String addPortfolio(Review review, String reviewTagName) {
//
//		for (ReviewTag specificReview : reviewTagRepo.findAll()) {
//			if (specificReview.getTagName().equals(reviewTagName)) {
//				return "redirect:/portfolios/submissions";
//			}
//		}
//	//////////////FIX THIS?///////////////////////////////////////
////		reviewRepo.save(new Review(review, reviewTagName));
//		return "redirect:/";
//	}
//
	@GetMapping("/{reviewTagId}/writeReview")
	public String getReview(Model model, @PathVariable Long reviewTagId) {
		model.addAttribute("Review", reviewTagRepo.findById(reviewTagId).get());
		return "reviewTags/writeReview";
	}

	@PostMapping("/{reviewTagId}/writeReview")
	public String addPortfolioReview(Model model, Long portfolioId, 
//			String userName, 
			long easeOfUseRating,
			long aestheticsRating, long contentRating, long creativityRating, long overallRating, String name,
			String overallComment, String easeOfUseComment, String aestheticsComment, String contentComment,
			String creativityComment, @PathVariable Long reviewTagId) {
		Review review = reviewRepo.save(new Review(portfolioRepo.findById(portfolioId).get(),
//				userRepo.findByUserName(userName).getId(),
				easeOfUseRating, aestheticsRating, contentRating, creativityRating, overallRating,
				easeOfUseComment, aestheticsComment, contentComment, creativityComment, overallComment));
		portfolioRepo.findById(portfolioId).get().addReview(review);
		model.addAttribute("Review", reviewTagRepo.findById(reviewTagId));
		return "redirect:/portfolios/{reviewTagId}";
	}
	
}
