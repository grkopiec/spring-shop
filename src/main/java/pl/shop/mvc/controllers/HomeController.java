package pl.shop.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome in online shop");
		model.addAttribute("tagline", "excelent, good internet shop");
		return "forward:/welcome/greeting";	//redirect request to another method, request includes all "Model" attributes
		//return "redirect:/welcome/greeting"; //it would not include "Model" attributes
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
}
