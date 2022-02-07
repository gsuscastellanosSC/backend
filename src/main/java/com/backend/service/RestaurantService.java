package com.backend.service;

import java.util.List;

import com.backend.model.Restaurant;

public interface RestaurantService {

	public Restaurant save(Restaurant restaurant);

	public void delete(Integer id);

	public Restaurant findById(Integer id);

	public List<Restaurant> findAll();
}
