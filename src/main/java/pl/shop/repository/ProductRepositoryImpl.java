package pl.shop.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.shop.domain.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	private static final List<Product> products = allProducts();
	
	@Override
	public List<Product> list() {
		return products;
	}

	@Override
	public Product findById(Long id) {
		return products.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Did not find requested product"));
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
