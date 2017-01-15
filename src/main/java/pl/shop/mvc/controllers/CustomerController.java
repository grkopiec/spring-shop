package pl.shop.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.shop.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String list(Model model) {
		model.addAttribute(customerService.findAll());
		return "customers";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
}
