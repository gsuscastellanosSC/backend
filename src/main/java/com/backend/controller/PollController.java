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

import com.backend.model.Poll;
import com.backend.service.PollService;
import com.backend.service.RestaurantService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class PollController {

	@Autowired
	private PollService pollService;
	@Autowired
	private RestaurantService restaurantService;

	@PostMapping(Constant.SLASH_POLLS)
	public Poll save(@RequestBody Poll poll) {
		restaurantService.save(poll.getRestaurant());
		return pollService.save(poll);
	}

	@GetMapping(Constant.SLASH_POLLS)
	public List<Poll> findAll() {
		return pollService.findAll();
	}

	@GetMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public Poll findById(@PathVariable Integer id) {
		return pollService.findById(id);
	}

	@PutMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public Poll update(@RequestBody Poll poll, @PathVariable Integer id) {

		Poll encuestaUpdated = pollService.findById(id);

		encuestaUpdated.setName(poll.getName());
		encuestaUpdated.setRestaurant(poll.getRestaurant());
		encuestaUpdated.setQuestions(poll.getQuestions());

		return pollService.save(encuestaUpdated);
	}

	@DeleteMapping(Constant.SLASH_POLLS_SLASH_BRACKET_ID_BRACKET)
	public void delete(@PathVariable Integer id) {
		pollService.delete(id);
	}

}
