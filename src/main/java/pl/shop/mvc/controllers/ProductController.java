package pl.shop.mvc.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.shop.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list(Model model) {
		model.addAttribute(productService.findAll());
		return "products";
	}
	
	@RequestMapping("/all")
	public ModelAndView all(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(productService.findAll());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	@RequestMapping("/{category}")
	public String byCategory(Model model, @PathVariable String category) {
		model.addAttribute(productService.findByCategory(category));
		return "products";
	}
	//example URL paths:
	//http://localhost:8080/products/filter/category;brand=apple,dell;category=smartphone,laptop
	//http://localhost:8080/products/filter/brand=apple,dell;category=smartphone,laptop
	//http://localhost:8080/products/filter/brand=apple;brand=dell;category=smartphone,laptop	//the same keys can be separated
	//remember about override "configurePathMatch()" method in "WebConfig.java"
	@RequestMapping("/filter/{criteria}")
	public String byCriteria(Model model, @MatrixVariable(pathVar = "criteria") Map<String, List<String>> filterParams) {
		model.addAttribute(productService.findByCriteria(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String byId(Model model, @RequestParam Long id) {
		model.addAttribute(productService.findById(id));
		return "product";
	}
	//example URL
	//http://localhost:8080/products/tablet/price;min=500;max=2000?manufacturer=Google
	@RequestMapping("/{category}/{price}")
	public String byCategoryPriceManufacturer(Model model, @PathVariable String category, @MatrixVariable(pathVar = "price") Map<String, String> filterPrice,
			@RequestParam String manufacturer) {
		Map<String, BigDecimal> map = new HashMap<>();
		map.put("min", BigDecimal.valueOf(Double.valueOf(filterPrice.get("min"))));
		map.put("max", BigDecimal.valueOf(Double.valueOf(filterPrice.get("max"))));
		model.addAttribute(productService.findByCategoryPriceManufacturer(category, manufacturer, map));
		return "products";
	}
}
