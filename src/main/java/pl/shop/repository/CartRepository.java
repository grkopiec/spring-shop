package pl.shop.repository;

import pl.shop.domain.Cart;
import pl.shop.domain.CartItem;

public interface CartRepository {
	public Cart create(Cart cart);
	public Cart read(Long id);
	public void delete(Long id);
	public void updateCartItem(Long cartId, Long cartItemId, CartItem cartItem);
	public void deleteCartItem(Long cartId, Long cartItemId);
}
