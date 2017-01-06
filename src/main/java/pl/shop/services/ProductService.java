package pl.shop.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import pl.shop.domain.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findById(Long id);
	public List<Product> findByCategory(String category);
	public List<Product> findByCriteria(Map<String, List<String>> filterParams);
	public List<Product> findByCategoryPriceManufacturer(String category, String manufacturer, Map<String, BigDecimal> filterPrice);
	public void addProduct(Product product);
}
