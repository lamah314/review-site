package org.wecancodeit.reviewsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.reviewsite.models.Address;
import org.wecancodeit.reviewsite.models.Review;

@Repository
public interface AddressesRepository extends CrudRepository<Address, Long> {

	Address findByStreetAddressAndCityAddressAndStateAddressAndZipAddress(String streetAddress, String cityAddress,
			String stateAddress, String zipAddress);

}
