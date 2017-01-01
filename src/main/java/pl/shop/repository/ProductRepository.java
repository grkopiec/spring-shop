package pl.shop.repository;

import java.util.List;
import java.util.Map;

import pl.shop.domain.Product;

public interface ProductRepository {
	public List<Product> findAll();
	public Product findById(Long id);
	public List<Product> findByCategory(String category);
	public List<Product> findByManufacturer(String manufacturer);
	public List<Product> findByCriteria(Map<String, List<String>> filterParams);
}
