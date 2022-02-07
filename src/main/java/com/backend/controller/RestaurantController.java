package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Restaurant;
import com.backend.service.RestaurantService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping(Constant.SLASH_RESTAURANTS)
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return restaurantService.save(restaurant);
	}

	@GetMapping(Constant.SLASH_RESTAURANTS)
	public List<Restaurant> findAll() {
		return restaurantService.findAll();
	}

	@GetMapping(Constant.SLASH_RESTAURANTS_SLASH_BRACKET_ID_BRACKET)
	public Restaurant findById(@PathVariable Integer id) {
		return restaurantService.findById(id);
	}

	@PutMapping(Constant.SLASH_RESTAURANTS_SLASH_BRACKET_ID_BRACKET)
	public Restaurant update(@RequestBody Restaurant restaurant, @PathVariable Integer id) {

		Restaurant restaurantUpdated = restaurantService.findById(restaurant.getId());
		restaurantUpdated.setName(restaurant.getName());

		return restaurantService.save(restaurantUpdated);
	}

	@DeleteMapping(Constant.SLASH_RESTAURANTS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		restaurantService.delete(id);
	}
}
