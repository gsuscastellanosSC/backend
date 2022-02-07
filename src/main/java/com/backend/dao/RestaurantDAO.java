package com.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.model.Restaurant;

public interface RestaurantDAO extends CrudRepository<Restaurant, Integer> {

}
