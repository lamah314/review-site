package org.wecancodeit.reviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.Portfolio;
import org.wecancodeit.reviewsite.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

	User findByName(String name);
}
