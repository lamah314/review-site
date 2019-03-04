package org.wecancodeit.reviewsite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.oldCode.UsersRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@Service
public class Populator implements CommandLineRunner {

	@Resource
	private UsersRepository userRepo;
	@Resource
	private PortfoliosRepository portfolioRepo;
	@Resource
	private ReviewsRepository reviewRepo;
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

		ReviewTag reviewTag = reviewTagRepo.save(new ReviewTag("Team"));

		Review review1 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"),
//				userRepo.findByName("Anthony Lam").getId(), 
				5, 5, 5, 5, 5, "Super Great", "Super Great",
				"Super Great", "Super Great", "Super Great", reviewTag));
		Review review2 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"),
//				userRepo.findByUserName("Anthony Lam").getId(),
				5, 5, 5, 5, 5, "Super Great", "Super Great",
				"Super Great", "Super Great", "Super Great", reviewTag));
		Review review3 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"),
//				userRepo.findByUserName("Anthony Lam").getId(),
				5, 5, 5, 5, 5, "Super Great", "Super Great",
				"Super Great", "Super Great", "Super Great", reviewTag));
		Review review4 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"),
//				userRepo.findByUserName("Anthony Lam").getId(),
				5, 5, 5, 5, 5, "Super Great", "Super Great",
				"Super Great", "Super Great", "Super Great", reviewTag));

	}
}
