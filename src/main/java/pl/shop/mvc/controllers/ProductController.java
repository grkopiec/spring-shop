package pl.shop.mvc.controllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pl.shop.domain.Product;
import pl.shop.exceptions.NoProductFoundForIdException;
import pl.shop.exceptions.NoProductsFoundException;
import pl.shop.services.ProductService;
import pl.shop.validation.ProductValidator;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductValidator productValidator;
	
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
		List<Product> products = productService.findByCategory(category);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundException(category);
		}
		
		model.addAttribute(products);
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
		Product product = productService.findById(id);
		if (product == null) {
			throw new NoProductFoundForIdException();
		}
		
		model.addAttribute(productService.findById(id));
		return "product";
	}
	
	@RequestMapping(value = "/productt", produces = {"application/xml", "application/json"})	//return json or xml
	public @ResponseBody Product byIdJson(Model model, @RequestParam Long id) {
		return  productService.findById(id);
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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProductForm(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		return "addProduct";
	}
	
/*	@RequestMapping(value = "/add", method = RequestMethod.GET)	//we can also use shorter version
	public String addProductFormUsingAnnotation(@ModelAttribute("product") Product product) {
		return "addProduct";
	}*/
	//indicate fields that should not be changing during filling form
	@InitBinder
	public void initialiseBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("inOrder", "discontinued");
		webDataBinder.setValidator(productValidator);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, HttpServletRequest request) throws IllegalStateException, IOException {
		if (bindingResult.hasErrors()) {
			return "addProduct";
		}
		
		String[] suppressedFields = bindingResult.getSuppressedFields();	//get fields that were changed
		if (suppressedFields.length > 0) {	//if somebody changed do not allowed fields throw exception
			throw new RuntimeException("Tried binding not allowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		
		MultipartFile image = product.getImage();
		MultipartFile manual = product.getManual();
		HttpSession httpSession = request.getSession();
		ServletContext servletContext = httpSession.getServletContext();
			
		if (image != null && !image.isEmpty()) {
			String directory = servletContext.getRealPath("/resources/images/");
			String fullPath = directory + "" + product.getId() + ".png";
			File file = new File(fullPath);
			image.transferTo(file);
		}
		if (manual != null && !manual.isEmpty()) {
			String directory = servletContext.getRealPath("/resources/pdfs/");
			String fullPath = directory + "" + product.getId() + ".pdf";
			File file = new File(fullPath);
			manual.transferTo(file);
		}
		
		productService.addProduct(product);
		return "redirect:/products";
	}
	//url with right code: http://localhost:8080/products/specialOffer?promo=ABCD
	//url with wrong code: http://localhost:8080/products/specialOffer?promo"sldkjf
	@RequestMapping("/invalidCode")
	public String invalidCode() {
		return "invalidCode";
	}
	
	@ExceptionHandler(NoProductsFoundException.class)
	public String handleError(Model model, NoProductsFoundException exception, HttpServletRequest request) {
		model.addAttribute("category", exception.getCategory());
		model.addAttribute("exception", exception);
		model.addAttribute("url", request.getRequestURL());
		return "productNotFound";
	}
}
