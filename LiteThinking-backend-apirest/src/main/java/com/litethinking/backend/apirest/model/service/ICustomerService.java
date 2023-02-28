package com.litethinking.backend.apirest.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.litethinking.backend.apirest.model.entity.Category;
import com.litethinking.backend.apirest.model.entity.Customer;

@Service
public interface ICustomerService {
	
	public List<Customer> findAll();
	
	public Customer findById(Long id);
	
	public Customer save(Customer customer);
	
	public void delete(Long id);
	
	public List<Category> findAllCategories();
	
	public List<Customer> findByName(String name);
	
	public List<Customer> findByLastname(String lastname);

}