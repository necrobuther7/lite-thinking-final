package com.litethinking.backend.apirest.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.litethinking.backend.apirest.model.entity.Product;

public interface IProductDao extends CrudRepository<Product, Long> {


}
