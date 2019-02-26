package org.wecancodeit.reviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.Portfolio;

@Repository
public interface PortfoliosRepository extends CrudRepository<Portfolio, Long> {
	
	Portfolio findByPortfolioName(String portfolioName);


}
