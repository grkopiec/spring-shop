package pl.shop.services;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.shop.domain.Product;
import pl.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Product findById(Long id) {
		return productRepository.findById(id);
	}
	
	@Override
	public List<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}
	
	@Override
	public List<Product> findByCriteria(Map<String, List<String>> filterParams) {
		return productRepository.findByCriteria(filterParams);
	}
	
	@Override
	public List<Product> findByCategoryPriceManufacturer(String category, String manufacturer, Map<String, BigDecimal> filterPrice) {
		Set<Product> result = new HashSet<>();
		result.addAll(productRepository.findByCategory(category));
		result.addAll(productRepository.findByManufacturer(manufacturer));
		
		return result.stream()
				.filter(p -> p.getPrice().compareTo(filterPrice.get("min")) >= 0  && p.getPrice().compareTo(filterPrice.get("max")) <= 0)
				.collect(Collectors.toList());
	}
	
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
}
