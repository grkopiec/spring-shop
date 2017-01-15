package pl.shop.mvc.controllers.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import pl.shop.domain.Cart;
import pl.shop.domain.CartItem;
import pl.shop.domain.Product;
import pl.shop.exceptions.NoProductFoundForIdException;
import pl.shop.services.CartService;
import pl.shop.services.ProductService;

@Controller	//we should use "@RestController"
@RequestMapping("/carts")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	private static final Logger logger = Logger.getLogger(CartController.class);
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Cart read(@PathVariable Long id) {
		return cartService.read(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		cartService.delete(id);
	}
	
	@RequestMapping(value = "/add/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void add(@PathVariable Long cartId, @RequestParam Long productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		logger.info("Current session: " + sessionId);
		
		Product product;
		try {
			product = productService.findById(productId);
		} catch (IllegalArgumentException e) {
			throw new NoProductFoundForIdException();
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1L);
		cartItem.setTotalPrice(product.getPrice());
		cartService.updateCartItem(cartId, product.getId(), cartItem);
	}
	
	@RequestMapping(value = "/remove/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long cartId, @RequestParam Long productId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		logger.info("Current session: " + sessionId);
		
		try {
			productService.findById(productId);
		} catch (IllegalArgumentException e) {
			throw new NoProductFoundForIdException();
		}

		cartService.deleteCartItem(cartId, productId);
	}
	
	@ExceptionHandler(NoProductFoundForIdException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request, check sent data out")
	public void handleNoProductFoundForIdException(Exception e) {}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request, check sent data out")
	public void handleRuntimeException(Exception e) {}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request, check sent data out")
	public void handleException(Exception e) {}
}
