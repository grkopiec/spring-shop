package pl.shop.repository;

import java.util.List;

import pl.shop.domain.Customer;

public interface CustomerRepository {
	public List<Customer> findAll();
}
