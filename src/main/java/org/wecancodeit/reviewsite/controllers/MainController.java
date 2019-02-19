package org.wecancodeit.reviewsite.controllers;

import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wecancodeit.reviewsite.UserForm;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/individualPortfolio")
	public String individualPortfolio() {
		return "individualPortfolio";
	}
	
	
//	@RequestMapping("/form")
//    public String form() {
//        return "form";
//    }
	
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
	
	@GetMapping("/form")
    public String showForm(UserForm userForm) {
        return "form";
    }

    @PostMapping("/form")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
	
}


