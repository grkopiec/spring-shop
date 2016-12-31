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
		mirek.setName("Miros�aw Tomaszewski");
		mirek.setAddress("ul. Okr�gowa 146, 93-367 ��d�");
		mirek.setOrdersQuantity(0L);
		
		Customer ula = new Customer();
		ula.setId(1L);
		ula.setName("Urszula D�browska");
		ula.setAddress("ul. Mi�towa 23, 15-690 Bia�ystok");
		ula.setOrdersQuantity(0L);
		
		Customer gienek = new Customer();
		gienek.setId(2L);
		gienek.setName("Eugeniusz Wojciechowski");
		gienek.setAddress("ul. Ko�la 143, 00-234 Warszawa");
		gienek.setOrdersQuantity(0L);
		
		List<Customer> list = new ArrayList<>();
		list.add(mirek);
		list.add(ula);
		list.add(gienek);
		return list;
	}
}
