package com.backend.dao;

import org.springframework.data.repository.CrudRepository;
import com.backend.model.User;

public interface UserDAO extends CrudRepository<User, Integer> {

}
