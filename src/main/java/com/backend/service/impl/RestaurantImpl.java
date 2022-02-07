package com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.RestaurantDAO;
import com.backend.model.Restaurant;
import com.backend.service.RestaurantService;
import com.backend.util.Constant;

@Service
public class RestaurantImpl implements RestaurantService {

	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Restaurant save(Restaurant restaurant) {

		return restaurantDAO.save(restaurant);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		restaurantDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public Restaurant findById(Integer id) {
		return restaurantDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<Restaurant> findAll() {
		return (List<Restaurant>) restaurantDAO.findAll();
	}

}
