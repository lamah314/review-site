package org.wecancodeit.reviewsite.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite.models.Address;
import org.wecancodeit.reviewsite.models.User;
import org.wecancodeit.reviewsite.repositories.AddressesRepository;
import org.wecancodeit.reviewsite.repositories.PortfoliosRepository;
import org.wecancodeit.reviewsite.repositories.ReviewsRepository;
import org.wecancodeit.reviewsite.repositories.UsersRepository;

@Controller
@RequestMapping("/users")
public class UserController {

	@Resource
	UsersRepository userRepo;
	@Resource
	PortfoliosRepository portfolioRepo;
	@Resource
	ReviewsRepository reviewRepo;
	@Resource
	AddressesRepository addressRepo;

	@GetMapping("/form")
	public String getUserForm(Model model) {
		model.addAttribute("Users", userRepo.findAll());
		return "users/form";
	}

	@PostMapping("/form")
	public String addUser(String username, String password, String streetAddress, String cityAddress,
			String stateAddress, String zipAddress) {

		for (User specificPerson : userRepo.findAll()) {
			if (specificPerson.getUserName().equals(username)) {
				return "redirect:/users/form";
			}
		}

		Address address;
		if (addressRepo.findByStreetAddressAndCityAddressAndStateAddressAndZipAddress(streetAddress,
				cityAddress, stateAddress, zipAddress) == null) {
			address = addressRepo.findByStreetAddressAndCityAddressAndStateAddressAndZipAddress(streetAddress,
					cityAddress, stateAddress, zipAddress);
		} else {
			address = addressRepo.save(new Address(streetAddress, cityAddress, stateAddress, zipAddress));
		}

		addressRepo.save(new Address(streetAddress, cityAddress, stateAddress, zipAddress));
		userRepo.save(new User(username, password, address));

		return "redirect:/users/results";

	}
}
