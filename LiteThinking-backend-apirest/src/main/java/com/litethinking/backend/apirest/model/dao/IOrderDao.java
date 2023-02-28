package com.litethinking.backend.apirest.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.litethinking.backend.apirest.model.entity.Order;

public interface IOrderDao extends CrudRepository<Order, Long> {

}
