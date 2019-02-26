package org.wecancodeit.reviewsite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewsite.models.Address;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.User;
import org.wecancodeit.reviewsite.repositories.AddressesRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
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
		
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Anthony Lam").getId(),5,5,5,5,5, "Super Great","Super Great", "Super Great","Super Great","Super Great"));
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), userRepo.findByUserName("Alicia Jeffers").getId(),4,4,4,4,4, "Super Sharp","Super Sharp", "Super Sharp","Super Sharp","Super Sharp"));
		
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"), userRepo.findByUserName("Jim Jewell").getId(),1,1,1,1,1, "Your face border reminds me of the first baby chicken egg that I held, I crushed it.","I hate your guts", "You're soft and now so am I","Don't quit your day job","Someone stab me in the eye and then in the heart"));
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"), userRepo.findByUserName("Bini Alemu").getId(),5,5,5,5,5, "Very Nice","Very Nice", "Very Nice","Very Nice","Very Nice"));
		
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jim Jewell"), userRepo.findByUserName("Nick Miner").getId(),1,1,1,1,1, "Your face reminds me of the first baby chicken egg that I held, I crushed it.","I hate your guts", "You're soft and now so am I","Don't quit your day job","Someone stab me in the eye and then in the heart"));
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jim Jewell"), userRepo.findByUserName("Alicia Jeffers").getId(),4,4,4,4,4, "Super Sharp","Super Sharp", "Super Sharp","Super Sharp","Super Sharp"));
		
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Bini Alemu"), userRepo.findByUserName("Alicia Jeffers").getId(), 4,4,4,4,4, "Super Dope","Super Dope", "Super Dope","Super Dope","Super Dope"));
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Bini Alemu"), userRepo.findByUserName("Anthony Lam").getId(), 5,5,5,5,5, "Super Good","Super Good", "Super Good","Super Good","Super Good"));
	
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Alicia Jeffers"), userRepo.findByUserName("Jim Jewell").getId(), 5,5,5,5,5, "You remind me of my second wife", "You remind me of my second wife","You remind me of my second wife","You remind me of my second wife","You remind me of my second wife"));
		reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Alicia Jeffers"), userRepo.findByUserName("Bini Alemu").getId(), 5,5,5,5,5, "You remind me of my second wife", "You remind me of my second wife","You remind me of my second wife","You remind me of my second wife","You remind me of my second wife"));
	}
}