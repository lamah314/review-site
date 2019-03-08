package org.wecancodeit.reviewsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PortfolioTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagRepo;

	@Test
	public void shouldSaveAndLoadPortfolio() {
		Portfolio portfolio = portfolioRepo
				.save(new Portfolio("Anthony Lam", Portfolio.URLChecker("lamah314.github.io")));

		entityManager.persist(portfolio);
		entityManager.flush();
		entityManager.clear();

		Portfolio portfolioFromDB = portfolioRepo.findByPortfolioName("Anthony Lam");

		assertThat(portfolioFromDB.getPortfolioName(), is("Anthony Lam"));
	}
}
