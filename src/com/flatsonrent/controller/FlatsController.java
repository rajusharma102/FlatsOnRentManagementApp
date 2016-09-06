package com.flatsonrent.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flatsonrent.model.User;
import com.flatsonrent.validator.UserValidator;

@Controller
public class FlatsController {
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value= "verifyUser", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("user") User user, BindingResult result){
		String un = user.getUsername();
		String pw = user.getPassword();
		
		userValidator.validate(user, result);
		if(result.hasErrors()){
			return "login";
			}
		if(un.equals(pw)){
			return "home";
		}
		return "login";
}
	@RequestMapping(value = "/flats")
	protected String loginPage(Map model) throws Exception {
		User user = new User();
		user.setUsername("RAJU");
		model.put("user", user);
		return "login";
	}
	
}
