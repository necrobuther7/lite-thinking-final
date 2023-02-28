package com.litethinking.backend.apirest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.litethinking.backend.apirest.model.entity.Customer;
import com.litethinking.backend.apirest.model.service.ICustomerService;


@CrossOrigin(origins = { "http_//localhost:4200" })
@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> index() {
		return customerService.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Customer customer = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			customer = customerService.findById(id);
		} catch(DataAccessException e) {
			response.put("message", "Error in query!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(customer == null) {
			response.put("message", "The customer Id: ".concat(id.toString().concat(" doesn't exist in the database!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping("/customer")
	public ResponseEntity<?> create( @RequestBody Customer customer, BindingResult result) {
		
		Customer newCustomer = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "Field '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			newCustomer = customerService.save(customer);
		} catch(DataAccessException e) {
			response.put("message", "Error inserting in database!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "The customer has been created successfully!");
		response.put("customer", newCustomer);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> update( @RequestBody Customer customer, BindingResult result, @PathVariable Long id) {

		Customer newCustomer = customerService.findById(id);

		Customer updateCustomer = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "Field '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (newCustomer == null) {
			response.put("mensaje", "Error Can`t edit customer: "
					.concat(id.toString().concat(" doesn't exist in the database!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			newCustomer.setLastname(customer.getLastname());
			newCustomer.setName(customer.getName());
			newCustomer.setEmail(customer.getEmail());

			updateCustomer = customerService.save(newCustomer);

		} catch (DataAccessException e) {
			response.put("message", "Error updating customer in database!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("message", "Customer has been updated successfully!");
		response.put("customer", updateCustomer);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			customerService.delete(id);
		} catch (DataAccessException e) {
			response.put("message", "Error deleting customer!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "Customer has been removed successfully!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	/*@GetMapping("/customer/name/{name}")
	public ResponseEntity<?> showName(@PathVariable String name) {
		
		Customer customer = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			customerService.findByName(name);
		} catch(DataAccessException e) {
			response.put("message", "Error in query!");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(customer == null) {
			response.put("message", "The customer name: ".concat(name.toString().concat(" doesn't exist in the database!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity <Customer>(customer, HttpStatus.OK);
	}*/
	
	@GetMapping("/customer/name/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> showName(@PathVariable String name) {
		return customerService.findByName(name);
	}
	
	
	@GetMapping("/customer/lastname/{lastname}")
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> showLastname(@PathVariable String lastname) {
		return customerService.findByLastname(lastname);
	}
	
	
	

}