package com.fdmgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String showHome(){
		return "index";
	}
	
	@RequestMapping(value="/find/{lang}/{id}")
	public String findBook(Model model, @PathVariable String lang, @PathVariable int id){
			if (lang.equals("en") && id == 1){
				model.addAttribute("bookInfo", "Information about Book 1");
			}
			else if (lang.equals("fr") && id == 1){
				model.addAttribute("bookInfo", "Informations sur le livr 1");
			}
			else if (lang.equals("en") && id == 2){
				model.addAttribute("bookInfo", "Information about Book 2");
			}
			else if (lang.equals("fr") && id == 2){
				model.addAttribute("bookInfo", "Informations sur le livr 2");
			}
			else {
				model.addAttribute("bookInfo", "The provided language/id is invalid.");
			}
	return "info";
	}
}
