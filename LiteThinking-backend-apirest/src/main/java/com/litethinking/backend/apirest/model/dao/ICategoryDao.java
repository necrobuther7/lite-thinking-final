package com.litethinking.backend.apirest.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.litethinking.backend.apirest.model.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{
	
	@Query("select c from Category c")
	public List<Category> findAllCategories();

}
