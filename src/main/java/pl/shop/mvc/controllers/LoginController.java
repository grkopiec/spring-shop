package pl.shop.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginFailed(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	//I defined logout page in spring security configuration
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(Model model) {
//		return "login";
//	}
}
