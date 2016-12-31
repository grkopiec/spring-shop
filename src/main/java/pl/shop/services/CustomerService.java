package pl.shop.services;

import java.util.List;

import pl.shop.domain.Customer;

public interface CustomerService {
	public List<Customer> findAll();
}
