package com.litethinking.backend.apirest.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.litethinking.backend.apirest.model.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long> {
	
	/*@Query("select c from Customer c where c.name LIKE %:name%")
	public List<Customer> findByName(@Param("name") String name);*/
	
	public List<Customer> findByName(String name);
	
	public List<Customer> findByLastname(String lastname);
	
	
	
}
