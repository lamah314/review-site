package org.wecancodeit.reviewsite.oldCode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.Portfolio;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);
}
