package com.backend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Restaurant;
@Repository
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer> {

}
