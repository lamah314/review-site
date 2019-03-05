package org.wecancodeit.reviewsite.repositories;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.reviewsite.models.ReviewTag;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewTagsRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ReviewTagTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	ReviewTagsRepository reviewTagRepo;

	@Test
	public void shouldSaveAndLoadReviewTag() {
		ReviewTag reviewTag = reviewTagRepo.save(new ReviewTag("test"));

		entityManager.persist(reviewTag);
		entityManager.flush();
		entityManager.clear();

		ReviewTag reviewTagFromDB = reviewTagRepo.findByTagName("test");

		assertThat(reviewTagFromDB.getTagName(), is("test"));
	}
}
