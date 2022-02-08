package com.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dao.UserDAO;
import com.backend.model.User;
import com.backend.service.UserService;
import com.backend.util.Constant;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public User save(User user) {
		return userDAO.save(user);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public void delete(Integer id) {
		userDAO.deleteById(id);

	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public User findById(Integer id) {
		return userDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = Constant.FALSE)
	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

}
