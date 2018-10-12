package com.fdmgroup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/login")
	public String showLoginPage(Model model){
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/processLogin", method=RequestMethod.POST)
	public String processLogin(Model model, @Valid User user, BindingResult br){
		if (br.hasErrors()){
			return "login";
		}
		
		User foundUser = userDao.findByUsername(user.getUsername());
		if (foundUser != null && foundUser.getPassword().equals(user.getPassword())){
			model.addAttribute("user", foundUser);
			return "welcome";
		}
		
		model.addAttribute("errorMsg", "Username/Password is incorrect.");
		return "login";
	}
}
