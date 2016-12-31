package pl.shop.repository;

import java.util.List;

import pl.shop.domain.Product;

public interface ProductRepository {
	public List<Product> findAll();
	public Product findById(Long id);
}
