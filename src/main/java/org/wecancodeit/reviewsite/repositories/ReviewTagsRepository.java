package org.wecancodeit.reviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.ReviewTag;

@Repository
public interface ReviewTagsRepository extends CrudRepository<ReviewTag, Long> {

	ReviewTag findByTagName(String string);

}
