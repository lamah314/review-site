package org.wecancodeit.reviewsite;

import javax.annotation.Resource;

import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewsite.models.Address;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.models.User;
import org.wecancodeit.reviewsite.repositories.AddressesRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Service
public class Populator implements CommandLineRunner {

	@Resource
	private UsersRepository userRepo;
	@Resource
	private PortfoliosRepository portfolioRepo;
	@Resource
	private ReviewsRepository reviewRepo;
	@Resource
	private AddressesRepository addressRepo;
	@Resource
	private ReviewTagsRepository reviewTagRepo;

	@Override
	public void run(String... args) throws Exception {
		portfolioRepo.save(new Portfolio("Anthony Lam", Portfolio.URLChecker("lamah314.github.io")));
		portfolioRepo.save(new Portfolio("Nick Miner", Portfolio.URLChecker("MinerNJ.github.io")));
		portfolioRepo.save(new Portfolio("Jim Jewell", Portfolio.URLChecker("JimJewell.github.io")));
		portfolioRepo.save(new Portfolio("Bini Alemu", Portfolio.URLChecker("BiniEth.github.io")));
		portfolioRepo.save(new Portfolio("Alicia Jeffers", Portfolio.URLChecker("akjeffers.github.io")));
		
		portfolioRepo.save(new Portfolio("Nick Fritz", Portfolio.URLChecker("nate-fritz.github.io")));
		portfolioRepo.save(new Portfolio("Matt Fry", Portfolio.URLChecker("mateofrito.github.io")));
		portfolioRepo.save(new Portfolio("Rene Garcia", Portfolio.URLChecker("nay9.github.io")));
		

		Address address = addressRepo.save(new Address("314 Pi Road", "Indianapolis", "IN", "43212"));
		userRepo.save(new User("Anthony Lam", "asdf", address));
		userRepo.save(new User("Nick Miner", "asdf", address));
		userRepo.save(new User("Jim Jewell", "asdf", address));
		userRepo.save(new User("Bini Alemu", "asdf", address));
		userRepo.save(new User("Alicia Jeffers", "asdf", address));
		
		ReviewTag reviewTag = reviewTagRepo.save(new ReviewTag("Team"));
		
		Review review1 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Anthony Lam").getId(),5,5,5,5,5, "Super Great","Super Great", "Super Great","Super Great","Super Great"));
		Review review2 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Anthony Lam").getId(),5,5,5,5,5, "Super Great","Super Great", "Super Great","Super Great","Super Great"));
		Review review3 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Anthony Lam").getId(),5,5,5,5,5, "Super Great","Super Great", "Super Great","Super Great","Super Great"));
		Review review4 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Anthony Lam").getId(),5,5,5,5,5, "Super Great","Super Great", "Super Great","Super Great","Super Great"));
		
		
		reviewTagRepo.save(new ReviewTag("Team", review1));
		reviewTagRepo.save(new ReviewTag("Team", review2));
		reviewTagRepo.save(new ReviewTag("Team", review3));
		reviewTagRepo.save(new ReviewTag("Team", review4));
		
//		review1.getReviewTags().add(reviewTag);
//		review2.getReviewTags().add(reviewTag);
//		review3.getReviewTags().add(reviewTag);
//		review4.getReviewTags().add(reviewTag);
//	
//		reviewTag.getReviews().add(review1);
//		reviewTag.getReviews().add(review2);
//		reviewTag.getReviews().add(review3);
//		reviewTag.getReviews().add(review4);
//		
//		reviewRepo.save(review1);
//		reviewRepo.save(review2);
//		reviewRepo.save(review3);
//		reviewRepo.save(review4);
//		
//		reviewTagsRepo.save(reviewTag);
		
		
		
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Nick Miner").getId(),4,4,4,4,4, "Has room for improvement","Has room for improvement", "Has room for improvement","Has room for improvement","Has room for improvement"));
//		
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"), userRepo.findByUserName("Jim Jewell").getId(),1,1,1,1,1, "Your face border reminds me of the first baby chicken egg that I held, I crushed it.","I hate your guts", "You're weak","Don't quit your day job","Someone poke me in the eye"));
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"), userRepo.findByUserName("Bini Alemu").getId(),5,5,5,5,5, "Very Nice","Very Nice", "Very Nice","Very Nice","Very Nice"));
//		
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jim Jewell"), userRepo.findByUserName("Nick Miner").getId(),1,1,1,1,1, "Your face reminds me of the first hampster that I held, I killed it.","I hate your guts", "You're soft","You should give up","Someone stab me in the thigh"));
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jim Jewell"), userRepo.findByUserName("Alicia Jeffers").getId(),4,4,4,4,4, "Super Sharp","Super Sharp", "Super Sharp","Super Sharp","Super Sharp"));
//		
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Bini Alemu"), userRepo.findByUserName("Alicia Jeffers").getId(), 4,4,4,4,4, "Super Dope","Super Dope", "Super Dope","Super Dope","Super Dope"));
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Bini Alemu"), userRepo.findByUserName("Anthony Lam").getId(), 5,5,5,5,5, "Super Good","Super Good", "Super Good","Super Good","Super Good"));
//	
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Alicia Jeffers"), userRepo.findByUserName("Jim Jewell").getId(), 5,5,5,5,5, "Looks Great!", "Looks Great!","Looks Great!","Looks Great!","Looks Great!"));
//		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Alicia Jeffers"), userRepo.findByUserName("Bini Alemu").getId(), 5,5,5,5,5, "Very Good", "Very Good","Very Good","Very Good","Very Good"));
	}
}
