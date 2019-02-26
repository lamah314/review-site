package org.wecancodeit.reviewsite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewsite.models.Address;
import org.wecancodeit.reviewsite.models.Portfolio;
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
		portfolioRepo.save(new Portfolio("Anthony", Portfolio.URLChecker("lamah314.github.io")));
		portfolioRepo.save(new Portfolio("Nick", Portfolio.URLChecker("MinerNJ.github.io")));
		portfolioRepo.save(new Portfolio("Jim", Portfolio.URLChecker("JimJewell.github.io")));
		portfolioRepo.save(new Portfolio("Bini", Portfolio.URLChecker("BiniEth.github.io")));
		portfolioRepo.save(new Portfolio("Alicia", Portfolio.URLChecker("akjeffers.github.io")));

		Address address = addressRepo.save(new Address("314 Pi Road", "Indianapolis", "IN", "43212"));
		userRepo.save(new User("Anthony", "asdf", address));
		userRepo.save(new User("Nick", "asdf", address));
		userRepo.save(new User("Jim", "asdf", address));
		userRepo.save(new User("Bini", "asdf", address));
		userRepo.save(new User("Alicia", "asdf", address));
	}
}
