package pl.shop.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.shop.domain.Cart;
import pl.shop.domain.CartItem;

@Repository
public class CartRepositoryImpl implements CartRepository {
	private static final List<Cart> carts = new ArrayList<>();
	
	@Override
	public Cart create(Cart cart) {
		if (cart.getCartItems() == null) {
			cart.setCartItems(new HashMap<>());
		}
		
		carts.add(cart);
		return cart;
	}

	@Override
	public Cart read(Long id) {
		return carts.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Did not find requested cart"));
	}
	
	@Override
	public void delete(Long id) {
		try {
			read(id);
		} catch (IllegalArgumentException e) {
			throw e;
		}
		System.out.println("---------------------");
		carts.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.ifPresent(p -> carts.remove(p));
		System.out.println("---------------------");
	}

	@Override
	public void updateCartItem(Long cartId, Long cartItemId, CartItem cartItem) {
		Cart foundCart = carts.stream()
				.filter(p -> p.getId() == cartId)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Did not find requested cart"));
		
		if (foundCart.getCartItems().containsKey(cartItemId)) {
			foundCart.getCartItems().replace(cartItemId, cartItem);
		} else {
			foundCart.getCartItems().put(cartItemId, cartItem);
		}
	}

	@Override
	public void deleteCartItem(Long cartId, Long cartItemId) {
		Cart foundCart = carts.stream()
				.filter(p -> p.getId() == cartId)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Did not find requested cart"));
		
		if (foundCart.getCartItems().containsKey(cartItemId)) {
			foundCart.getCartItems().remove(cartItemId);
		} else {
			throw new IllegalArgumentException("Can not delete requested product because did not find this product in Cart");
		}
	}
}
