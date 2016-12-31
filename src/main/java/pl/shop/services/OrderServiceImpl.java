package pl.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shop.domain.Product;
import pl.shop.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRepository ProductRepository;
	
	@Override
	public void processOrder(Long productId, Long quantity) {
		Product product = ProductRepository.findById(productId);
		if (product.getInStock() < quantity) {
			throw new IllegalArgumentException("Products are too little");
		}
		Long newInStock = product.getInStock() - quantity;
		product.setInStock(newInStock);
	}
}
