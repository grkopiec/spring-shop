package pl.shop.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import pl.shop.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	private static final List<Product> products = allProducts();
	
	@Override
	public List<Product> findAll() {
		return products;
	}

	@Override
	public Product findById(Long id) {
		return products.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Did not find requested product"));
	}
	
	@Override
	public List<Product> findByCategory(String category) {
		List<Product> list = products.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase(category))
				.collect(Collectors.toList());
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Did not find elements for category: " + category);
		}
		return list;
	}
	
	@Override
	public List<Product> findByManufacturer(String manufacturer) {
		List<Product> list = products.stream()
				.filter(p -> p.getManufacturer().equalsIgnoreCase(manufacturer))
				.collect(Collectors.toList());
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Did not find elements for manufacturer: " + manufacturer);
		}
		return list;
	}
	
	@Override
	public List<Product> findByCriteria(Map<String, List<String>> filterParams) {
		List<String> brandCriteria = filterParams.get("brand").stream().map(f -> f.toLowerCase()).collect(Collectors.toList());
		List<String> categoryCriteria = filterParams.get("category").stream().map(f -> f.toLowerCase()).collect(Collectors.toList());
		
		List<Product> list = products.stream()
				.filter(p -> brandCriteria.contains(p.getManufacturer().toLowerCase()))
				.filter(p -> categoryCriteria.contains(p.getCategory().toLowerCase()))
				.collect(Collectors.toList());
				
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Did not find elements");
		}
		
		return list;
	}

	private static List<Product> allProducts() {
		Product iPhone = new Product();
		iPhone.setId(0L);
		iPhone.setName("iPhone 5S");
		iPhone.setPrice(new BigDecimal(1500));
		iPhone.setDescription("Apple iPhone 5S, smartphone with 4-inches screen, 640x1136 screen resolution, 8-MP camera");
		iPhone.setManufacturer("Apple");
		iPhone.setCategory("smartphone");
		iPhone.setInStock(100L);
		iPhone.setInOrder(0L);
		iPhone.setDiscontinued(false);
		iPhone.setCondition("good");
		
		Product dell = new Product();
		dell.setId(1L);
		dell.setName("Inspiron");
		dell.setPrice(new BigDecimal(2000));
		dell.setDescription("Dell Inspiron, laptop with 14-inches screen, 1280x720 screen resolution, processor Intel Core 3th generation");
		dell.setManufacturer("Dell");
		dell.setCategory("laptop");
		dell.setInStock(50L);
		dell.setInOrder(0L);
		dell.setDiscontinued(false);
		dell.setCondition("good");
		
		Product nexus = new Product();
		nexus.setId(2L);
		nexus.setName("Nexus 7");
		nexus.setPrice(new BigDecimal(1000));
		nexus.setDescription("Google Nexus 7, the lighter 7-inches screen tablet, 4-core processor Qualcomm Snapdragon S4 Pro");
		nexus.setManufacturer("Google");
		nexus.setCategory("tablet");
		nexus.setInStock(200L);
		nexus.setInOrder(0L);
		nexus.setDiscontinued(false);
		nexus.setCondition("good");
		
		List<Product> list = new ArrayList<>();
		list.add(iPhone);
		list.add(dell);
		list.add(nexus);
		return list;
	}
}
