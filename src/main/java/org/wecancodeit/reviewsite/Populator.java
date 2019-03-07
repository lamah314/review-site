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

		portfolioRepo.save(new Portfolio("Josue Espinosa", Portfolio.URLChecker("http://ejosue.com/")));
		portfolioRepo.save(new Portfolio("Helen W. Bentley", Portfolio.URLChecker("http://helenwbentley.com/")));
		portfolioRepo.save(new Portfolio("Jessie Ren", Portfolio.URLChecker("http://jessieren.com/")));
		portfolioRepo.save(new Portfolio("Brooke Harper", Portfolio.URLChecker("http://www.bfrancesi.com/")));
		portfolioRepo.save(new Portfolio("Tobias Ahlin", Portfolio.URLChecker("http://tobiasahlin.com/")));
		portfolioRepo.save(new Portfolio("Emelyn Baker", Portfolio.URLChecker("http://emelynbaker.com/")));
		portfolioRepo.save(new Portfolio("Jeffery Gochman", Portfolio.URLChecker("http://jeffreygochman.com/")));



		ReviewTag reviewTagTeam = reviewTagRepo.save(new ReviewTag("Team"));
		ReviewTag reviewTagAesthetic = reviewTagRepo.save(new ReviewTag("Aesthetic"));
		ReviewTag reviewTagContent = reviewTagRepo.save(new ReviewTag("Content"));
		ReviewTag reviewTagUX = reviewTagRepo.save(new ReviewTag("UX"));


		Review review1 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"),
				5L, 5L, 5L, 5L, 5L, "Great", reviewTagTeam));
		Review review2 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Nick Miner"),
				5L, 5L, 5L, 5L, 5L, "Fantastic", reviewTagTeam));
		Review review3 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Alicia Jeffers"),
				5L, 5L, 5L, 5L, 5L, "Amazing", reviewTagTeam));
		Review review4 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Bini Alemu"),
				5L, 5L, 5L, 5L, 5L, "Incredible", reviewTagTeam));
		Review review5 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jim Jewell"),
				5L, 5L, 5L, 5L, 5L, "Astounding", reviewTagTeam));
		
		Review review6 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Jeffery Gochman"),
				5L, 5L, 5L, 5L, 5L, "Tons of information and projects.", reviewTagContent));
		Review review7 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Emelyn Baker"),
				5L, 5L, 5L, 5L, 5L, "Great color contrasts down the page while still highlighting content.", reviewTagAesthetic));
		Review review8 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Tobias Ahlin"),
				5L, 5L, 5L, 5L, 5L, "Really dynamic page that is minimimal but still informative.", reviewTagAesthetic));
		Review review9 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Brooke Harper"),
				5L, 5L, 5L, 5L, 5L, "Amazingly simple user design that is concise and attractive.", reviewTagUX));
		Review review10 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Helen W. Bentley"),
				5L, 5L, 5L, 5L, 5L, "Every box on the page is dynamic! Great content.", reviewTagUX));
		Review review11 = reviewRepo.save(new Review(portfolioRepo.findByPortfolioName("Josue Espinosa"),
				5L, 5L, 5L, 5L, 5L, "Inspired Anthony's own personal profile!", reviewTagContent));

	}
}
