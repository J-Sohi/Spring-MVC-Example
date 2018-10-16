package com.fdmgroup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;
import com.fdmgroup.repository.UserRepository;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class AuthenticationController {

	@Autowired
	//private UserDao userDao;
	private UserRepository ur;
	
	@RequestMapping(value = "/login")
	public String showLogin(Model model){
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public String processLogin(Model model, @Valid User user, BindingResult br){
		if (br.hasErrors()){
			return "login";
		}
	
		User foundUser = ur.findByUsername(user.getUsername());
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())){
	
			model.addAttribute("user", foundUser);
			return "welcome";
		}
		else
		model.addAttribute("errorMsg", "Username/Password is incorrect!");
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		//return "redirect:/nameOfController";
		return "redirect:/login";
		
	}
}
