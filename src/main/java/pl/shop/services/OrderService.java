package pl.shop.services;

public interface OrderService {
	public void processOrder(Long productId, Long quantity);
}
