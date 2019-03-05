package org.wecancodeit.reviewsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagsRepo;

	@Test
	public void shouldSaveAndLoadReviewTag() {
		Review review = reviewRepo
				.save(new Review(portfolioRepo.findByPortfolioName("Anthony Lam"), 5, 5, 5, 5, 5, "Super Great"));

		entityManager.persist(review);
		entityManager.flush();
		entityManager.clear();

		Review reviewFromDB = reviewRepo.findByPortfolio(portfolioRepo.findByPortfolioName("Anthony Lam"));

		long answer = 5;
		assertThat(reviewFromDB.getAestheticsRating(), is(answer));
		assertThat(String.valueOf(reviewFromDB.getAestheticsRating()), is("5"));
	}
}
