package pl.shop.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.shop.services.OrderService;

@Controller
public class OrderContoroller {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/{productId}")
	public String order(@PathVariable Long productId, @RequestParam("quantity") Long quantity) {
		orderService.processOrder(productId, quantity);
		return "redirect:/products";
	}
}
