package pl.shop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.shop.domain.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	private static final List<Customer> customers = allCustomers();

	@Override
	public List<Customer> findAll() {
		return customers;
	}

	private static List<Customer> allCustomers() {
		Customer mirek = new Customer();
		mirek.setId(0L);
		mirek.setName("Miros³aw Tomaszewski");
		mirek.setAddress("ul. Okrêgowa 146, 93-367 £ódŸ");
		mirek.setOrdersQuantity(0L);
		
		Customer ula = new Customer();
		ula.setId(1L);
		ula.setName("Urszula D¹browska");
		ula.setAddress("ul. Miêtowa 23, 15-690 Bia³ystok");
		ula.setOrdersQuantity(0L);
		
		Customer gienek = new Customer();
		gienek.setId(2L);
		gienek.setName("Eugeniusz Wojciechowski");
		gienek.setAddress("ul. KoŸla 143, 00-234 Warszawa");
		gienek.setOrdersQuantity(0L);
		
		List<Customer> list = new ArrayList<>();
		list.add(mirek);
		list.add(ula);
		list.add(gienek);
		return list;
	}
}
