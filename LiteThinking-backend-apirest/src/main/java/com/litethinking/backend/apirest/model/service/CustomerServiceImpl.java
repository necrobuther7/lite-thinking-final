package com.litethinking.backend.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litethinking.backend.apirest.model.dao.ICategoryDao;
import com.litethinking.backend.apirest.model.dao.ICustomerDao;
import com.litethinking.backend.apirest.model.entity.Category;
import com.litethinking.backend.apirest.model.entity.Customer;


@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		customerDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategories() {
		return categoryDao.findAllCategories();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findByName(String name) {
		return customerDao.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findByLastname(String lastname) {
		return customerDao.findByLastname(lastname);
	}
	
	

}