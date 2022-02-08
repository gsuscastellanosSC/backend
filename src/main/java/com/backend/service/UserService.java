package com.backend.service;

import java.util.List;

import com.backend.model.User;

public interface UserService {

	public User save(User user);

	public void delete(Integer id);

	public User findById(Integer id);

	public List<User> findAll();

}
