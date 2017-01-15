package pl.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shop.domain.Cart;
import pl.shop.domain.CartItem;
import pl.shop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Cart create(Cart cart) {
		try {
			cartRepository.read(cart.getId());
		} catch (IllegalArgumentException e) {
			return cartRepository.create(cart);
		}
		return cartRepository.read(cart.getId());
//		throw new IllegalArgumentException("Cart with this id already exists");
	}
	
	@Override
	public void delete(Long id) {
		cartRepository.delete(id);
	}

	@Override
	public Cart read(Long id) {
		return cartRepository.read(id);
	}

	@Override
	public void updateCartItem(Long cartId, Long cartItemId, CartItem cartItem) {
		cartRepository.updateCartItem(cartId, cartItemId, cartItem);
	}

	@Override
	public void deleteCartItem(Long cartId, Long cartItemId) {
		cartRepository.deleteCartItem(cartId, cartItemId);
	}
}
