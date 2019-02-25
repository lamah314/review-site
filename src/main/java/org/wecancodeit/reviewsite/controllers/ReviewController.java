package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	@Resource
	UsersRepository userRepo;
	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	
}
