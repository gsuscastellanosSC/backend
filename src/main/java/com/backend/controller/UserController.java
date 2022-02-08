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

import com.backend.model.User;
import com.backend.service.UserService;
import com.backend.util.Constant;

@RestController
@CrossOrigin(origins = { Constant.ASTERISK })
@RequestMapping(Constant.SLASH_API)
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(Constant.SLASH_USERS)
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping(Constant.SLASH_USERS)
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(Constant.SLASH_USERS_SLASH_BRACKET_ID_BRACKET)
	public User findById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@PutMapping(Constant.SLASH_USERS_SLASH_BRACKET_ID_BRACKET)
	public User update(@RequestBody User user, @PathVariable Integer id) {

		User userUpdated = userService.findById(id);
		userUpdated.setName(user.getName());

		return userService.save(userUpdated);

	}
	
	@DeleteMapping(Constant.SLASH_USERS_SLASH_BRACKET_ID_BRACKET)
	public void delete (@PathVariable Integer id) {
		userService.delete(id);
	}

}
