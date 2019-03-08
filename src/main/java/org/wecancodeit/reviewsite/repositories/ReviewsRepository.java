package org.wecancodeit.reviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.Review;

@Repository
public interface ReviewsRepository extends CrudRepository<Review, Long> {

	Review findByPortfolio(Portfolio findByPortfolioName);

}
